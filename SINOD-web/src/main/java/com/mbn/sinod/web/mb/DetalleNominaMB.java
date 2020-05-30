/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.web.mb;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mbn.sinod.model.dto.DetalleDesgloseXMLDTO;
import com.mbn.sinod.model.dto.EmpQuincenaPorCabeceraDTO;
import com.mbn.sinod.model.entidades.Tsgnomcabecera;
import com.mbn.sinod.model.entidades.Tsgnomcncptoquinc;
import com.mbn.sinod.model.entidades.Tsgnomcncptoquincht;
import com.mbn.sinod.model.entidades.Tsgnomempquincena;
import com.mbn.sinod.model.entidades.Tsgrhempleados;
import com.mbn.sinod.model.entidades.Usuario;
import com.mbn.sinod.web.client.CabecerasWSClient;
import com.mbn.sinod.web.client.ConcepQuincWSClient;
import com.mbn.sinod.web.client.SumaDesgloseWSClient;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.io.StringReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.apache.deltaspike.core.api.scope.ViewAccessScoped;
import static org.atmosphere.annotation.AnnotationUtil.logger;
import org.primefaces.context.RequestContext;
import org.primefaces.event.ToggleEvent;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 *
 * @author ambrosio
 */
@Named(value = "detalleNominaMB")
@ViewAccessScoped
public class DetalleNominaMB implements Serializable {

    private String titulo;
    private String mensaje;
    private Integer visible;
    private BigDecimal sueldoBruto;
    private Tsgrhempleados empleado;
    private Tsgnomcabecera cabecera;
    private Tsgnomcabecera cabeceraSelecionada;
    private List<Tsgnomcabecera> listaCabecera;
    private Usuario usuario;
    private List<EmpQuincenaPorCabeceraDTO> listaEmpleadosCabecera;
    private Integer cabeceraId;
    private List<Tsgnomcncptoquinc> listaConcepQuincena;
    private List<Tsgnomcncptoquinc> listaConcepQuincenaPercep;
    private List<Tsgnomcncptoquinc> listaConcepQuincenaDeduc;
    private List<Tsgnomcncptoquincht> listaConcepQuincenaHT;
    private Document doc;
    private DetalleDesgloseXMLDTO ddxmldto;
    private ArrayList<DetalleDesgloseXMLDTO> listaDetallePerc;
    private ArrayList<DetalleDesgloseXMLDTO> listaDetalleDeduc;
    private List<Tsgnomempquincena> totales;

    @PostConstruct
    public void iniciarVariables() {
        this.setEmpleado((Tsgrhempleados) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("empleado"));
        this.setUsuario((Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario"));
        verifica();
        btnVisible();
        setTitulo("");
        setMensaje("");
        try {
            setListaEmpleadosCabecera(CabecerasWSClient.listarEmpleadosCabecera(
                    getCabeceraSelecionada().getCodCabeceraid()));
        } catch (JsonProcessingException ex) {
            Logger.getLogger(DetalleNominaMB.class.getName()).log(Level.SEVERE, null, ex);
        }
        llenarConceptos();
    }
    
    private void llenarConceptos(){
        for (int i = 0; i < getListaEmpleadosCabecera().size(); i++) {
            setListaConcepQuincena(ConcepQuincWSClient
                    .listarConceptosByEmpQuin(getListaEmpleadosCabecera()
                                    .get(i).getIdemp_quincena())
                    .getListCncptoquinc());
            
            for (int j = 0; j < getListaConcepQuincena().size(); j++) {
                if(getListaConcepQuincena().get(j).getCodConceptoidFk()
                        .getCodTipoconceptoidFk().getCodTipoconceptoid().equals(1)){
                    getListaConcepQuincenaDeduc().add(getListaConcepQuincena().get(j));
                }else{
                    getListaConcepQuincenaPercep().add(getListaConcepQuincena().get(j));
                }
            }
            
            getListaEmpleadosCabecera().get(i)
                    .setConceptosDeduccionEmpleado(getListaConcepQuincenaDeduc());
            
            getListaEmpleadosCabecera().get(i)
                    .setConceptosPercepcionesEmpleado(getListaConcepQuincenaPercep());
        }
    }
    
    public void verifica() {
        // get cookies
        HttpServletRequest httpServletRequest = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        Cookie[] cookies = httpServletRequest.getCookies();
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                if (cookies[i].getName().equals("mbnCmbn")) {
                    setCabeceraSelecionada(CabecerasWSClient.cabeceraPorId(Integer.parseInt(cookies[i].getValue())).getCabecera());
                }
            }
        }
    }

    public void handleToggle(ToggleEvent event) {
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Toggled", "Visibility:" + event.getVisibility());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void detalleEmpleado(EmpQuincenaPorCabeceraDTO ecdto) {
        setListaConcepQuincena(ConcepQuincWSClient.listarConceptosByEmpQuin(ecdto.getIdemp_quincena()).getListCncptoquinc());
        setTotales(SumaDesgloseWSClient.sumaDesglose(ecdto.getIdemp_nom(), getCabeceraSelecionada().getCodCabeceraid()));
        setSueldoBruto(getTotales().get(0).getImpTotalemp());
        setListaDetallePerc(new ArrayList<>());
        setListaDetalleDeduc(new ArrayList<>());
        for (int i = 0; i < getListaConcepQuincena().size(); i++) {
            setDdxmldto(new DetalleDesgloseXMLDTO());
            DocumentBuilder documentBuilder = null;
            try {
                documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            } catch (ParserConfigurationException ex) {
                Logger.getLogger(DetalleNominaMB.class.getName()).log(Level.SEVERE, null, ex);
            }
            InputSource inputSource = new InputSource();
            inputSource.setCharacterStream(new StringReader(getListaConcepQuincena().get(i).getXmlDesgloce()));
            try {
                setDoc(documentBuilder.parse(inputSource));
                getDoc().getDocumentElement().normalize();
                getDdxmldto().setClave(getDoc().getElementsByTagName("claveConcepto").item(0).getTextContent());
                getDdxmldto().setNombreConcepto(getDoc().getElementsByTagName("nombreConcepto").item(0).getTextContent());
//                getDdxmldto().setUnidades(getDoc().getElementsByTagName("x").item(0).getTextContent());
                getDdxmldto().setImporte(getDoc().getElementsByTagName("importe").item(0).getTextContent());
                if (getListaConcepQuincena().get(i).getCodConceptoidFk().getCodTipoconceptoidFk().getCodTipoconceptoid().equals(2)) {
                    getListaDetallePerc().add(getDdxmldto());
                } else {
                    getListaDetalleDeduc().add(getDdxmldto());
                }
            } catch (SAXException | IOException ex) {
                Logger.getLogger(DetalleNominaMB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void btnVisible() {
        if (getCabeceraSelecionada().getCodEstatusnomidFk().getCodEstatusnomid().equals(1)) {
            setVisible(1);
        } else if (getCabeceraSelecionada().getCodEstatusnomidFk().getCodEstatusnomid().equals(2)) {
            setVisible(2);
        }
    }

    public void mostrarCalcular() {
        setTitulo("Calcular nómina");
        setMensaje("¿Desea calcular la nómina de la " + getCabeceraSelecionada().getCodNbnomina() + "?");
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('dlg').show();");
    }

    public void mostrarValidar() {
        setTitulo("Validar nómina");
        setMensaje("¿Desea enviar a proceso de validación " + getCabeceraSelecionada().getCodNbnomina() + "?");
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('dlg').show();");
    }

    public void cerrarNom() {
        setTitulo("Cerrar nómina");
        setMensaje("¿Desea cerrar la nómina " + getCabeceraSelecionada().getCodNbnomina() + "?");
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('dlg').show();");
    }

    public void calcular() throws JsonProcessingException {
        CabecerasWSClient.calculoNomina(getCabeceraSelecionada().getCodCabeceraid());
        setCabeceraSelecionada(CabecerasWSClient.cabeceraPorId(getCabeceraSelecionada().getCodCabeceraid()).getCabecera());
        setVisible(2);
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('dlg').hide();");
    }

    public void validar() {
        setVisible(3);
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('dlg').hide();");
    }

    public void cerrar() {
        setVisible(4);
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('dlg').hide();");
    }

    public void reporteNomina() {
        try {

            //inicio ruta del reporte 
            //Carpeta
            String reportPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/resources/") + File.separator + "reports";

            //Nombre del documento
            String ubicacionPlantilla = reportPath + File.separator + "ReporteNominaGeneral.jasper";

            //Crear objeto de java 
            File jasper = new File(ubicacionPlantilla);

            //ruta de imagenes
            String ubicacionHeaderImage = reportPath + File.separator + "images" + File.separator + "Encabezado.png";

            String ubicacionFooterImage = reportPath + File.separator + "images" + File.separator + "Pie.png";

            //Termina ruta del reporte
            //inicia contenido de reporte 
            JRBeanCollectionDataSource empleados = new JRBeanCollectionDataSource(getListaEmpleadosCabecera());
            JRBeanCollectionDataSource persepciones = new JRBeanCollectionDataSource(getListaDetallePerc());
            JRBeanCollectionDataSource deducciones = new JRBeanCollectionDataSource(getListaDetalleDeduc());
            JRBeanCollectionDataSource total = new JRBeanCollectionDataSource(getTotales());
            //JRBeanCollectionDataSource ordenPorClienteServicio = new JRBeanCollectionDataSource(DetalleOrdenClienteWSClient.detalleOrdenCliente(getClienteSeleccionado().getClienteid()));
            //Termina el contenido
            //parametros de contenido 
            Map<String, Object> parametros = new HashMap<>();
            parametros.put("urlHeaderImage", ubicacionHeaderImage);
            parametros.put("urlFooterImage", ubicacionFooterImage);
            parametros.put("detalleEmpleados", empleados);
            parametros.put("detallePersepciones", persepciones);
            parametros.put("detalleDeducciones", deducciones);
            parametros.put("detalleTotal", total);

            parametros.put("cabecera", getCabeceraSelecionada().getCodNbnomina());
            parametros.put("tipo", getCabeceraSelecionada().getCodTiponominaidFk().getCodNomina());
            parametros.put("totalEmpleados", getCabeceraSelecionada().getCnuTotalemp());
            parametros.put("fechaInicio", getCabeceraSelecionada().getCodQuincenaidFk().getFecInicio());
            parametros.put("fechaFin", getCabeceraSelecionada().getCodQuincenaidFk().getFecFin());
            parametros.put("fechaPago", getCabeceraSelecionada().getCodQuincenaidFk().getFecPago());
            parametros.put("totalPerc", getCabeceraSelecionada().getImpTotpercepcion());
            parametros.put("totalDeduc", getCabeceraSelecionada().getImpTotdeduccion());
            parametros.put("importeTotal", getCabeceraSelecionada().getImpTotalemp());
            //terminan parametros

            //inicia la construccion del reporte
            byte[] bytes = JasperRunManager.runReportToPdf(jasper.getPath(), parametros, new JREmptyDataSource());

            HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
            response.setContentType("application/pdf");
            response.setContentLength(bytes.length);
            try (ServletOutputStream outStream = response.getOutputStream()) {
                outStream.write(bytes, 0, bytes.length);

                outStream.flush();
            }

            FacesContext.getCurrentInstance().responseComplete();

        } catch (IOException | JRException ioe) {
            logger.error(" Error creando reporte, causado por: " + ioe);
            java.util.logging.Logger.getLogger(DetalleNominaMB.class.getName()).log(Level.SEVERE, null, ioe);
        }
    }

    /**
     * @return the empleado
     */
    public Tsgrhempleados getEmpleado() {
        return empleado;
    }

    /**
     * @param empleado the empleado to set
     */
    public void setEmpleado(Tsgrhempleados empleado) {
        this.empleado = empleado;
    }

    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the cabecera
     */
    public Tsgnomcabecera getCabecera() {
        return cabecera;
    }

    /**
     * @param cabecera the cabecera to set
     */
    public void setCabecera(Tsgnomcabecera cabecera) {
        this.cabecera = cabecera;
    }

    /**
     * @return the cabeceraSelecionada
     */
    public Tsgnomcabecera getCabeceraSelecionada() {
        return cabeceraSelecionada;
    }

    /**
     * @param cabeceraSelecionada the cabeceraSelecionada to set
     */
    public void setCabeceraSelecionada(Tsgnomcabecera cabeceraSelecionada) {
        this.cabeceraSelecionada = cabeceraSelecionada;
    }

    /**
     * @return the listaCabecera
     */
    public List<Tsgnomcabecera> getListaCabecera() {
        return listaCabecera;
    }

    /**
     * @param listaCabecera the listaCabecera to set
     */
    public void setListaCabecera(List<Tsgnomcabecera> listaCabecera) {
        this.listaCabecera = listaCabecera;
    }

    /**
     * @return the visible
     */
    public Integer getVisible() {
        return visible;
    }

    /**
     * @param visible the visible to set
     */
    public void setVisible(Integer visible) {
        this.visible = visible;
    }

    public List<EmpQuincenaPorCabeceraDTO> getListaEmpleadosCabecera() {
        return listaEmpleadosCabecera;
    }

    public void setListaEmpleadosCabecera(List<EmpQuincenaPorCabeceraDTO> listaEmpleadosCabecera) {
        this.listaEmpleadosCabecera = listaEmpleadosCabecera;
    }

    public Integer getCabeceraId() {
        return cabeceraId;
    }

    public void setCabeceraId(Integer cabeceraId) {
        this.cabeceraId = cabeceraId;
    }

    /**
     * @return the listaConcepQuincena
     */
    public List<Tsgnomcncptoquinc> getListaConcepQuincena() {
        return listaConcepQuincena;
    }

    /**
     * @param listaConcepQuincena the listaConcepQuincena to set
     */
    public void setListaConcepQuincena(List<Tsgnomcncptoquinc> listaConcepQuincena) {
        this.listaConcepQuincena = listaConcepQuincena;
    }

    /**
     * @return the listaConcepQuincenaHT
     */
    public List<Tsgnomcncptoquincht> getListaConcepQuincenaHT() {
        return listaConcepQuincenaHT;
    }

    /**
     * @param listaConcepQuincenaHT the listaConcepQuincenaHT to set
     */
    public void setListaConcepQuincenaHT(List<Tsgnomcncptoquincht> listaConcepQuincenaHT) {
        this.listaConcepQuincenaHT = listaConcepQuincenaHT;
    }

    /**
     * @return the doc
     */
    public Document getDoc() {
        return doc;
    }

    /**
     * @param doc the doc to set
     */
    public void setDoc(Document doc) {
        this.doc = doc;
    }

    /**
     * @return the ddxmldto
     */
    public DetalleDesgloseXMLDTO getDdxmldto() {
        return ddxmldto;
    }

    /**
     * @param ddxmldto the ddxmldto to set
     */
    public void setDdxmldto(DetalleDesgloseXMLDTO ddxmldto) {
        this.ddxmldto = ddxmldto;
    }

    /**
     * @return the listaDetallePerc
     */
    public ArrayList<DetalleDesgloseXMLDTO> getListaDetallePerc() {
        return listaDetallePerc;
    }

    /**
     * @param listaDetallePerc the listaDetallePerc to set
     */
    public void setListaDetallePerc(ArrayList<DetalleDesgloseXMLDTO> listaDetallePerc) {
        this.listaDetallePerc = listaDetallePerc;
    }

    /**
     * @return the listaDetalleDeduc
     */
    public ArrayList<DetalleDesgloseXMLDTO> getListaDetalleDeduc() {
        return listaDetalleDeduc;
    }

    /**
     * @param listaDetalleDeduc the listaDetalleDeduc to set
     */
    public void setListaDetalleDeduc(ArrayList<DetalleDesgloseXMLDTO> listaDetalleDeduc) {
        this.listaDetalleDeduc = listaDetalleDeduc;
    }

    /**
     * @return the totales
     */
    public List<Tsgnomempquincena> getTotales() {
        return totales;
    }

    /**
     * @param totales the totales to set
     */
    public void setTotales(List<Tsgnomempquincena> totales) {
        this.totales = totales;
    }

    /**
     * @return the sueldoBruto
     */
    public BigDecimal getSueldoBruto() {
        return sueldoBruto;
    }

    /**
     * @param sueldoBruto the sueldoBruto to set
     */
    public void setSueldoBruto(BigDecimal sueldoBruto) {
        this.sueldoBruto = sueldoBruto;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the mensaje
     */
    public String getMensaje() {
        return mensaje;
    }

    /**
     * @param mensaje the mensaje to set
     */
    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    /**
     * @return the listaConcepQuincenaPercep
     */
    public List<Tsgnomcncptoquinc> getListaConcepQuincenaPercep() {
        return listaConcepQuincenaPercep;
    }

    /**
     * @param listaConcepQuincenaPercep the listaConcepQuincenaPercep to set
     */
    public void setListaConcepQuincenaPercep(List<Tsgnomcncptoquinc> listaConcepQuincenaPercep) {
        this.listaConcepQuincenaPercep = listaConcepQuincenaPercep;
    }

    /**
     * @return the listaConcepQuincenaDeduc
     */
    public List<Tsgnomcncptoquinc> getListaConcepQuincenaDeduc() {
        return listaConcepQuincenaDeduc;
    }

    /**
     * @param listaConcepQuincenaDeduc the listaConcepQuincenaDeduc to set
     */
    public void setListaConcepQuincenaDeduc(List<Tsgnomcncptoquinc> listaConcepQuincenaDeduc) {
        this.listaConcepQuincenaDeduc = listaConcepQuincenaDeduc;
    }
}
