/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.web.mb;

import com.mbn.sinod.model.dto.DetalleIncidenciasEmpleadoDTO;
import com.mbn.sinod.model.entidades.Tsgnomempleados;
import com.mbn.sinod.model.entidades.Tsgnomquincena;
import com.mbn.sinod.model.entidades.Tsgrhempleados;
import com.mbn.sinod.model.entidades.Usuario;
import com.mbn.sinod.web.client.EmpleadosNomWSClient;
import com.mbn.sinod.web.client.IncidenciasEmpleadoWSClient;
import com.mbn.sinod.web.client.QuincenasWSClient;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.io.StringReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletOutputStream;
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
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 *
 * @author Karla
 */
@Named(value = "hstIncidenciasMB")
@ViewAccessScoped
public class HistorialIncidenciasMB implements Serializable {
    
    private List<Tsgnomquincena> quincenas;
    private Tsgnomquincena quincenaSeleccionada;
    private List<DetalleIncidenciasEmpleadoDTO> listaIncidencias;
    private DetalleIncidenciasEmpleadoDTO detIncidenciaSeleccionada;
    
    private String detallefechasxml;
    private char perfil;
    private String desQuincenaSeleccionada;
    
    private Tsgrhempleados empleadoLogeado;
    private Usuario usuario;
    private Tsgnomempleados empleadoNom;
    
    @PostConstruct
    public void inicializar(){
        this.usuario = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        this.setEmpleadoLogeado((Tsgrhempleados) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("empleado"));
        this.quincenas = new ArrayList<>();
        setQuincenas(QuincenasWSClient.listarQuincenas());
        setEmpleadoNom(new Tsgnomempleados());
        setEmpleadoNom(EmpleadosNomWSClient.obtenerEmpleadonomPorIdrh(getEmpleadoLogeado().getCodEmpleado()).getEmpleado());
    }
    
    public void busquedaIncidenciasQuincena() { 
        SimpleDateFormat format  = new SimpleDateFormat("dd/MM/yyyy");
        setDesQuincenaSeleccionada("Del " +format.format(getQuincenaSeleccionada().getFecInicio())+ " al " +format.format(getQuincenaSeleccionada().getFecFin()));
        switch(getUsuario().getCod_rol()){
            case 1: setListaIncidencias(IncidenciasEmpleadoWSClient.incidenciasQuincena(getQuincenaSeleccionada().getCodQuincenaid()));
                break;
            case 2: setListaIncidencias(IncidenciasEmpleadoWSClient.incidenciasQuincenaArea(getQuincenaSeleccionada().getCodQuincenaid(),getEmpleadoLogeado().getCodPuesto().getCodArea().getCodArea()));
                break;
            case 3: setListaIncidencias(IncidenciasEmpleadoWSClient.incidenciasEmpleadoQuincena(getEmpleadoNom().getCodEmpleadoid(),getQuincenaSeleccionada().getCodQuincenaid()));
                break;
            case 4: setListaIncidencias(IncidenciasEmpleadoWSClient.incidenciasQuincenaArea(getQuincenaSeleccionada().getCodQuincenaid(),getEmpleadoLogeado().getCodPuesto().getCodArea().getCodArea()));
                break;
            default : mostrarMensaje("No tiene permiso para acceder a la información", "info");
                break;
        }
    }
    
    public void dialogoVer(DetalleIncidenciasEmpleadoDTO detIncidenciaSeleccionada) {
        setDetIncidenciaSeleccionada(detIncidenciaSeleccionada);
        setDetallefechasxml(extraerFechasXml(getDetIncidenciaSeleccionada().getDetallefechas()));
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('diagVerDetalleIncidencia').show();");
    }
    
    public void dialogoVerCerrar(){
        setDetIncidenciaSeleccionada(new DetalleIncidenciasEmpleadoDTO());
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('diagVerDetalleIncidencia').hide();");
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
    
    public void reporteHistorialIncidencias() {
        try {

            //inicio ruta del reporte 
            //Carpeta
            String reportPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/resources/") + File.separator + "reports";

            //Nombre del documento
            String ubicacionPlantilla = reportPath + File.separator + "ReporteHistorialIncidencias.jasper";

            //Crear objeto de java 
            File jasper = new File(ubicacionPlantilla);

            //ruta de imagenes
            String ubicacionHeaderImage = reportPath + File.separator + "images" + File.separator + "Encabezado.png";

            String ubicacionFooterImage = reportPath + File.separator + "images" + File.separator + "Pie.png";

            //Termina ruta del reporte
            //inicia contenido de reporte 

            JRBeanCollectionDataSource historial = new JRBeanCollectionDataSource(getListaIncidencias());
            //JRBeanCollectionDataSource incidencias = new JRBeanCollectionDataSource(getDesQuincenaSeleccionada());
            //JRBeanCollectionDataSource ordenPorClienteServicio = new JRBeanCollectionDataSource(DetalleOrdenClienteWSClient.detalleOrdenCliente(getClienteSeleccionado().getClienteid()));
            JRBeanCollectionDataSource IncidenciasPorQuincena = new JRBeanCollectionDataSource(IncidenciasEmpleadoWSClient.incidenciasQuincena(getQuincenaSeleccionada().getCodQuincenaid()));
            
            //Termina el contenido
            //parametros de contenido 
            Map<String, Object> parametros = new HashMap<>();
            parametros.put("urlHeaderImage", ubicacionHeaderImage);
            parametros.put("urlFooterImage", ubicacionFooterImage);
            parametros.put("detalleIncidencias", historial);
            parametros.put("incidenciasPorQuincena", IncidenciasPorQuincena);
            parametros.put("quincena", (IncidenciasEmpleadoWSClient.incidenciasQuincena(getQuincenaSeleccionada().getCodQuincenaid())));
            
            parametros.put("fechasXml", getDetallefechasxml());
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
            java.util.logging.Logger.getLogger(HistorialIncidenciasMB.class.getName()).log(Level.SEVERE, null, ioe);
        }
    }
    
    public List<Tsgnomquincena> getQuincenas() {
        return quincenas;
    }

    public void setQuincenas(List<Tsgnomquincena> quincenas) {
        this.quincenas = quincenas;
    }

    public List<DetalleIncidenciasEmpleadoDTO> getListaIncidencias() {
        return listaIncidencias;
    }

    public void setListaIncidencias(List<DetalleIncidenciasEmpleadoDTO> listaIncidencias) {
        this.listaIncidencias = listaIncidencias;
    }

    public Tsgnomquincena getQuincenaSeleccionada() {
        return quincenaSeleccionada;
    }

    public void setQuincenaSeleccionada(Tsgnomquincena quincenaSeleccionada) {
        this.quincenaSeleccionada = quincenaSeleccionada;
    }

    public DetalleIncidenciasEmpleadoDTO getDetIncidenciaSeleccionada() {
        return detIncidenciaSeleccionada;
    }

    public void setDetIncidenciaSeleccionada(DetalleIncidenciasEmpleadoDTO detIncidenciaSeleccionada) {
        this.detIncidenciaSeleccionada = detIncidenciaSeleccionada;
    }

    public String getDetallefechasxml() {
        return detallefechasxml;
    }

    public void setDetallefechasxml(String detallefechasxml) {
        this.detallefechasxml = detallefechasxml;
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

    public Tsgnomempleados getEmpleadoNom() {
        return empleadoNom;
    }

    public void setEmpleadoNom(Tsgnomempleados empleadoNom) {
        this.empleadoNom = empleadoNom;
    }
    
    public char getPerfil() {
        return perfil;
    }

    public void setPerfil(char perfil) {
        this.perfil = perfil;
    }

    public String getDesQuincenaSeleccionada() {
        return desQuincenaSeleccionada;
    }

    public void setDesQuincenaSeleccionada(String desQuincenaSeleccionada) {
        this.desQuincenaSeleccionada = desQuincenaSeleccionada;
    }
    
}
