/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.web.mb;

import com.mbn.sinod.model.dto.DetalleIncidenciasEmpleadoDTO;
import com.mbn.sinod.model.dto.IncidenciasDTO;
import com.mbn.sinod.model.dto.VerInformacionDePersonalDTO;
import com.mbn.sinod.model.entidades.Tsgnomcatincidencia;
import com.mbn.sinod.model.entidades.Tsgnomincidencia;
import com.mbn.sinod.model.entidades.Tsgnomquincena;
import com.mbn.sinod.model.entidades.Tsgrhempleados;
import com.mbn.sinod.model.entidades.Usuario;
import com.mbn.sinod.web.client.CatIncidenciaWSClient;
import com.mbn.sinod.web.client.IncidenciasEmpleadoWSClient;
import com.mbn.sinod.web.client.QuincenasWSClient;
import com.mbn.sinod.web.client.VerInformacionDePersonalWSClient;
import java.io.IOException;
import java.io.Serializable;
import java.io.StringReader;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.deltaspike.core.api.scope.ViewAccessScoped;
import org.apache.log4j.Logger;
import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 *
 * @author Karla
 */
@Named(value = "incidenciasrhMB")
@ViewAccessScoped
public class IncidenciasrhMB implements Serializable{
    
    private final static Logger logger = Logger.getLogger(IncidenciasrhMB.class);

    private String clave;
    private Integer incidenciaid;
    private Integer cantidad;
    private String actividad;
    private String comentarios;
    private String tipoIncidencia;
    private BigDecimal monto;
    private String detallefechas;
    private String fechas;
    private Date fecha;
    private String detallefechasxml;
    private Boolean editar;
    private Boolean automatico;
    private List<String> listaFechas;

    private List<Tsgnomcatincidencia> listaIncidencias;
    private List<DetalleIncidenciasEmpleadoDTO> listaDetalleIncidenciasEmpleado;
    private DetalleIncidenciasEmpleadoDTO detalleIncidenciaSeleccionada;
    private Tsgnomcatincidencia catIncidenciaSeleccionada;
    private Tsgnomincidencia IncidenciaSeleccionada;
    private Tsgnomincidencia incidencia;
    private Tsgnomquincena quincenaActual;
    private String desQuincenaActual;
    
    private Tsgrhempleados empleadoLogeado;
    private Usuario usuario;
    private String perfil;
    private VerInformacionDePersonalDTO detalleEmpleado;
    
    private Integer idempleadonom;
    
    private SimpleDateFormat format;
    
    @PostConstruct
    public void inicializar() {
        this.usuario = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        this.setEmpleadoLogeado((Tsgrhempleados) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("empleado"));
        if(getUsuario().getCod_rol() == 1){
            DetalleEmpleadosMB detalleEmpMB = new DetalleEmpleadosMB();
            setIdempleadonom(detalleEmpMB.getCod_empleado());
        }else if(getUsuario().getCod_rol() == 2 || getUsuario().getCod_rol() == 4){
            EmpleadosPorAreaMB empPorArea = new EmpleadosPorAreaMB();
            setIdempleadonom(empPorArea.getCodEmpleado());
        }
        this.monto= BigDecimal.ZERO;
        this.listaDetalleIncidenciasEmpleado = new ArrayList<>();
        this.detallefechas = "{"; this.fechas = "";
        setCatIncidenciaSeleccionada(new Tsgnomcatincidencia());
        setQuincenaActual(QuincenasWSClient.quincenaActual().getQuincena());
        this.format  = new SimpleDateFormat("dd/MM/yyyy");
        setDesQuincenaActual("Del " +format.format(getQuincenaActual().getFecInicio())+ " al " +format.format(getQuincenaActual().getFecFin()));
        setListaDetalleIncidenciasEmpleado(IncidenciasEmpleadoWSClient.detalleIncidenciasEmpleado(getIdempleadonom()));
        setListaIncidencias(CatIncidenciaWSClient.listarCatIncidencias());
        setIncidenciaSeleccionada(new Tsgnomincidencia());
        setDetalleEmpleado(VerInformacionDePersonalWSClient.informacionPorEmpleado(getIdempleadonom()).get(0));
    }

    public void eliminarIncidencia() {
        if (IncidenciasEmpleadoWSClient.eliminarIncidenciaEmpleado(getDetalleIncidenciaSeleccionada().getIdincidencia(), getIdempleadonom())) {
            setListaDetalleIncidenciasEmpleado(IncidenciasEmpleadoWSClient.detalleIncidenciasEmpleado(getIdempleadonom()));
            mostrarMensaje("Incidencia eliminada correctamente", "succes");
        } else {
            mostrarMensaje("No se pudo eliminar la incidencia", "error");
        }
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('diagEliminarIncidencia').hide();");
    }

    public void registrarIncidencia() {
        String detallearreglo;
        BigDecimal montonuevo;
        IncidenciasDTO registrar = new IncidenciasDTO();
        setIncidencia(new Tsgnomincidencia());
        RequestContext context = RequestContext.getCurrentInstance();
        if( null == getCatIncidenciaSeleccionada().getCodTipoincidencia()){
            mostrarMensaje("No se ha completado el formulario.", "info");            
        }else if(getDetallefechas().length() > 0 & (getCantidad()> 0 || getActividad().length()>1)) { 
            detallearreglo = detallefechas.substring(0, detallefechas.length()-1) + "}";
            if(getAutomatico()) {
                montonuevo = getCatIncidenciaSeleccionada().getImpMonto();
            } else {
                montonuevo = getMonto();
            }
            //Asignamos los datos a la entidad
            System.out.println("incidencia id: " +getCatIncidenciaSeleccionada().getCodCatincidenciaid());
            getIncidencia().setCodCatincidenciaidFk(getCatIncidenciaSeleccionada().getCodCatincidenciaid());
            getIncidencia().setCnuCantidad(getCantidad().shortValue());
            getIncidencia().setDesActividad(getActividad());
            getIncidencia().setTxtComentarios(getComentarios());
            getIncidencia().setCodEmpreportaFk(getIdempleadonom());
            getIncidencia().setAudCodcreadopor(getEmpleadoLogeado().getCodEmpleado());
            getIncidencia().setImpMonto(montonuevo);
            getIncidencia().setXmlDetcantidad(detallearreglo);
            
            registrar.setIncidencia(getIncidencia());
            if (IncidenciasEmpleadoWSClient.registrarIncidencia(registrar)){
                mostrarMensaje("Incidencia agregada correctamente", "succes");
            } else {
                mostrarMensaje("No se pudo agregar la incidencia", "error");
            }
            context.execute("PF('dialogoAgregar').hide();");
            setListaDetalleIncidenciasEmpleado(IncidenciasEmpleadoWSClient.detalleIncidenciasEmpleado(getIdempleadonom()));
        } else{
            mostrarMensaje("Por favor, complete el formulario.", "info");
        }
    }
    
    public void editarIncidencia(){
        if(IncidenciasEmpleadoWSClient.actualizarIncidencia(getDetalleIncidenciaSeleccionada().getIdincidencia(), getDetalleIncidenciaSeleccionada().getComentarios(), getDetalleIncidenciaSeleccionada().getMontopagado(), getEmpleadoLogeado().getCodEmpleado())){
            mostrarMensaje("Datos actualizados correctamente.", "succes");
        } else {
            mostrarMensaje("No se pudo actualizar la incidencia.", "error");
        }
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('diagVerDetalleIncidencia').hide();");
        setListaDetalleIncidenciasEmpleado(IncidenciasEmpleadoWSClient.detalleIncidenciasEmpleado(getIdempleadonom()));
    }

    public void agregarFecha(SelectEvent event){
        boolean agregar = true;
        if(getListaFechas().size()>0){
            for(int i=0; i< getListaFechas().size();i++){
                if(!getListaFechas().get(i).equals(format.format(event.getObject()))){
                    agregar = true;
                }else{
                    agregar = false;
                    break;
                }
            }
        }
        if(agregar){
            if(event.getObject() != null){
                detallefechas += format.format(event.getObject()) +",";
                fechas += format.format(event.getObject()) + "\n";
                getListaFechas().add(format.format(event.getObject()));
            }else{
                mostrarMensaje("Seleccione una fecha", "info");
            }
        }else{
            mostrarMensaje("Fecha repetida.", "info");
        }
    }
    
    public void limpiarFechas(){
        this.detallefechas = "{"; this.fechas = "";
        getListaFechas().clear();
    }

    public void asignarFormulario() {
        setCantidad(0);
        setActividad("");
        setFecha(new Date());
        setComentarios("");
        setDetallefechas("{");
        setFechas("");
        setAutomatico(true);
        setMonto(BigDecimal.ZERO);
        if(getCatIncidenciaSeleccionada().getImpMonto().compareTo(BigDecimal.ZERO) <= 0){
            setMonto(BigDecimal.ZERO);
        }else{
            setMonto(getCatIncidenciaSeleccionada().getImpMonto());
        }
        setIncidenciaid(getCatIncidenciaSeleccionada().getCodCatincidenciaid());
    }
    
    public void asignarMonto() {
        if(getCatIncidenciaSeleccionada().getImpMonto().compareTo(BigDecimal.ZERO) <= 0){
            setMonto(BigDecimal.ZERO);
        }else{
            setMonto(getCatIncidenciaSeleccionada().getImpMonto());
        }
    }

    public void dialogoAgregar() {
        setIncidenciaSeleccionada(new Tsgnomincidencia());
        setCatIncidenciaSeleccionada(new Tsgnomcatincidencia());
        setCantidad(0);
        setActividad("");
        setFecha(new Date());
        setComentarios("");
        setDetallefechas("{");
        setFechas("");
        setAutomatico(true);
        setMonto(BigDecimal.ZERO);
        this.listaFechas = new ArrayList<>();
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('dialogoAgregar').show();");
    }
    
    public void dialogoAgregarCerrar(){
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('dialogoAgregar').hide();");
    }
    
    public void dialogoEditarCerrar(){
        setIncidenciaSeleccionada(new Tsgnomincidencia());
        setCatIncidenciaSeleccionada(new Tsgnomcatincidencia());
        setCantidad(0);
        setActividad("");
        setFecha(new Date());
        setComentarios("");
        setDetallefechas("{");
        setFechas("");
        setAutomatico(true);
        setMonto(BigDecimal.ZERO);
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('diagVerDetalleIncidencia').hide();");
    }
        
    public void dialogoVer(DetalleIncidenciasEmpleadoDTO detalleIncidenciaSeleccionada) {
        setEditar(false);
        setDetalleIncidenciaSeleccionada(detalleIncidenciaSeleccionada);
        setDetallefechasxml(extraerFechasXml(getDetalleIncidenciaSeleccionada().getDetallefechas()));
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('diagVerDetalleIncidencia').show();");
    }

    public void dialogoEditar(DetalleIncidenciasEmpleadoDTO detalleIncidenciaSeleccionada) {
        setEditar(true);
        setDetalleIncidenciaSeleccionada(detalleIncidenciaSeleccionada);
        setDetallefechasxml(extraerFechasXml(getDetalleIncidenciaSeleccionada().getDetallefechas()));
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('diagVerDetalleIncidencia').show();");
    }

    public void dialogoEliminar(DetalleIncidenciasEmpleadoDTO detalleIncidenciaDTO) {
        setDetalleIncidenciaSeleccionada(detalleIncidenciaDTO);
        if(getDetalleIncidenciaSeleccionada().getCreaid() == getEmpleadoLogeado().getCodEmpleado()){
            RequestContext context = RequestContext.getCurrentInstance();
            context.execute("PF('diagEliminarIncidencia').show();");
        } else {
            mostrarMensaje("No tiene permiso para eliminar esta incidencia", "info");
        }
    }
    
    //XML READER
    public String extraerFechasXml(String cadenaXml){
        String detallefechas = "";
        DocumentBuilder documentBuilder = null;
        Document doc;
        try {
                documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            } catch (ParserConfigurationException ex) {
                java.util.logging.Logger.getLogger(RegistrarMB.class.getName()).log(Level.SEVERE, null, ex);
            }
        try {
            InputSource inputSource = new InputSource();
            inputSource.setCharacterStream(new StringReader(cadenaXml));

            doc = documentBuilder.parse(inputSource);
            doc.getDocumentElement().normalize();
            for(int i = 0; i < doc.getElementsByTagName("fecha").getLength(); i++){
                detallefechas += doc.getElementsByTagName("fecha").item(i).getTextContent() +"\n";
            }
        } catch (SAXException | IOException ex) {
            java.util.logging.Logger.getLogger(RegistrarMB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return detallefechas;
    }

    //MENSAJES
    private String mensaje;

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public void mostrarMensaje(String mensaje, String severidad) {
        FacesContext context = FacesContext.getCurrentInstance();
        switch (severidad) {
            case "info":
                context.addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "", mensaje));//FacesMessage.SEVERITY_INFO, summary, detail
                break;
            case "error":
                context.addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", mensaje));
                break;
            case "succes":
                context.addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "Operación exitosa", mensaje));
                break;
            default:
                context.addMessage(null,
                        new FacesMessage(FacesMessage.SEVERITY_INFO, "", ""));
                break;
        }
    }

    //GETTERS Y SETTERS

    public Integer getIdempleadonom() {
        return idempleadonom;
    }

    public void setIdempleadonom(Integer idempleadonom) {
        this.idempleadonom = idempleadonom;
    }
    
    public Tsgrhempleados getEmpleadoLogeado() {
        return empleadoLogeado;
    }

    public void setEmpleadoLogeado(Tsgrhempleados empleadoLogeado) {
        this.empleadoLogeado = empleadoLogeado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Boolean getEditar() {
        return editar;
    }

    public void setEditar(Boolean editar) {
        this.editar = editar;
    }
    
    public List<DetalleIncidenciasEmpleadoDTO> getListaDetalleIncidenciasEmpleado() {
        return listaDetalleIncidenciasEmpleado;
    }

    public void setListaDetalleIncidenciasEmpleado(List<DetalleIncidenciasEmpleadoDTO> listaDetalleIncidenciasEmpleado) {
        this.listaDetalleIncidenciasEmpleado = listaDetalleIncidenciasEmpleado;
    }

    public DetalleIncidenciasEmpleadoDTO getDetalleIncidenciaSeleccionada() {
        return detalleIncidenciaSeleccionada;
    }

    public void setDetalleIncidenciaSeleccionada(DetalleIncidenciasEmpleadoDTO detalleIncidenciaSeleccionada) {
        this.detalleIncidenciaSeleccionada = detalleIncidenciaSeleccionada;
    }

    public List<Tsgnomcatincidencia> getListaIncidencias() {
        return listaIncidencias;
    }

    public void setListaIncidencias(List<Tsgnomcatincidencia> listaIncidencias) {
        this.listaIncidencias = listaIncidencias;
    }

    public Tsgnomcatincidencia getCatIncidenciaSeleccionada() {
        return catIncidenciaSeleccionada;
    }

    public void setCatIncidenciaSeleccionada(Tsgnomcatincidencia catIncidenciaSeleccionada) {
        this.catIncidenciaSeleccionada = catIncidenciaSeleccionada;
    }

    public Tsgnomincidencia getIncidencia() {
        return incidencia;
    }

    public void setIncidencia(Tsgnomincidencia incidencia) {
        this.incidencia = incidencia;
    }

    public Integer getIncidenciaid() {
        return incidenciaid;
    }

    public void setIncidenciaid(Integer incidenciaid) {
        this.incidenciaid = incidenciaid;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public BigDecimal getMonto() {
        return monto;
    }

    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }
    
    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getTipoIncidencia() {
        return tipoIncidencia;
    }

    public void setTipoIncidencia(String tipoIncidencia) {
        this.tipoIncidencia = tipoIncidencia;
    }

    public Tsgnomincidencia getIncidenciaSeleccionada() {
        return IncidenciaSeleccionada;
    }

    public void setIncidenciaSeleccionada(Tsgnomincidencia IncidenciaSeleccionada) {
        this.IncidenciaSeleccionada = IncidenciaSeleccionada;
    }

    public String getDetallefechas() {
        return detallefechas;
    }

    public void setDetallefechas(String detallefechas) {
        this.detallefechas = detallefechas;
    }

    public String getFechas() {
        return fechas;
    }

    public void setFechas(String fechas) {
        this.fechas = fechas;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDetallefechasxml() {
        return detallefechasxml;
    }

    public void setDetallefechasxml(String detallefechasxml) {
        this.detallefechasxml = detallefechasxml;
    }

    public Boolean getAutomatico() {
        return automatico;
    }

    public void setAutomatico(Boolean automatico) {
        this.automatico = automatico;
    }

    public Tsgnomquincena getQuincenaActual() {
        return quincenaActual;
    }

    public void setQuincenaActual(Tsgnomquincena quincenaActual) {
        this.quincenaActual = quincenaActual;
    }

    public String getDesQuincenaActual() {
        return desQuincenaActual;
    }

    public void setDesQuincenaActual(String desQuincenaActual) {
        this.desQuincenaActual = desQuincenaActual;
    }

    public SimpleDateFormat getFormat() {
        return format;
    }

    public void setFormat(SimpleDateFormat format) {
        this.format = format;
    }

    public List<String> getListaFechas() {
        return listaFechas;
    }

    public void setListaFechas(List<String> listaFechas) {
        this.listaFechas = listaFechas;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public VerInformacionDePersonalDTO getDetalleEmpleado() {
        return detalleEmpleado;
    }

    public void setDetalleEmpleado(VerInformacionDePersonalDTO detalleEmpleado) {
        this.detalleEmpleado = detalleEmpleado;
    }
        
}
