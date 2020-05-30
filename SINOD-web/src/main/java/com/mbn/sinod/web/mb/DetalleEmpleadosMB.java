/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.web.mb;

import com.mbn.sinod.model.dto.DetalleEmpleadosDTO;
import com.mbn.sinod.model.dto.VerInformacionDePersonalDTO;
import com.mbn.sinod.web.client.DetalleEmpleadosWSClient;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import javax.annotation.PostConstruct;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.apache.deltaspike.core.api.scope.ViewAccessScoped;
import org.apache.log4j.Logger;

/**
 *
 * @author Ivette
 */
@Named(value = "detalleEmpleadosMB")
@ViewAccessScoped
public class DetalleEmpleadosMB implements Serializable {

    private List<DetalleEmpleadosDTO> listaDetalleEmpleadosNom;
    private static Integer cod_empleado;
    private VerInformacionDePersonalDTO VempleadoSeleccionado;

    private final static Logger logger = Logger.getLogger(DetalleEmpleadosMB.class);

    @PostConstruct//PERMITE QUE NUESTRA CLASE SE INICIALIZE CUANDO SEA LLAMADA
    public void iniciarVariables() {
        listaDetalleEmpleadosNom = new ArrayList<>();
        setListaDetalleEmpleadosNom(DetalleEmpleadosWSClient.detalleEmpleadosNom());
    }
  
    public void verEmpleado(Integer cod_empleado) throws IOException {

        setCod_empleado(cod_empleado);
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext externalContext = context.getExternalContext();
        HttpServletRequest originRequest = (HttpServletRequest) externalContext.getRequest();
        String scheme = originRequest.getScheme();
        String server = originRequest.getServerName();
        int port = originRequest.getServerPort();
        String contextPath = originRequest.getContextPath();
        String URL_Informacion = scheme + "://" + server + ":" + port + "" + contextPath + "/Personal/InformacionPersonal.xhtml?faces-redirect=true";
        context.getExternalContext().redirect(URL_Informacion);
        System.out.println("ERROR REUTILIZARMB" + cod_empleado);
    }

    public void verHistorial(Integer cod_empleado) throws IOException {
        setCod_empleado(cod_empleado);
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext externalContext = context.getExternalContext();
        HttpServletRequest originRequest = (HttpServletRequest) externalContext.getRequest();
        String scheme = originRequest.getScheme();
        String server = originRequest.getServerName();
        int port = originRequest.getServerPort();
        String contextPath = originRequest.getContextPath();
        String URL_Informacion = scheme + "://" + server + ":" + port + "" + contextPath + "/Personal/HistorialPersonal.xhtml?faces-redirect=true";
        context.getExternalContext().redirect(URL_Informacion);
        System.out.println("Historial" + cod_empleado);

    }
    
    public void registrarIncidencias(Integer cod_empleado) throws IOException{
        setCod_empleado(cod_empleado);
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext externalContext = context.getExternalContext();
        HttpServletRequest originRequest = (HttpServletRequest) externalContext.getRequest();
        String scheme = originRequest.getScheme();
        String server = originRequest.getServerName();
        int port = originRequest.getServerPort();
        String contextPath = originRequest.getContextPath();
        String URL_Informacion = scheme + "://" + server + ":" + port + "" + contextPath + "/incidencias/incidenciasrh.xhtml?faces-redirect=true";
        context.getExternalContext().redirect(URL_Informacion);
        System.out.println("ABRIR VISTA DE REGISTRO DE INCIDENCIAS DE RH " +cod_empleado);
    }

    public void editarEmpleado(Integer cod_empleado) throws IOException{
        try {
            HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
            Cookie empleadoCookie = new Cookie("mbnEMPmbn", String.valueOf(cod_empleado));
            empleadoCookie.setPath("/");
            httpServletResponse.addCookie(empleadoCookie);
        } catch (Exception e) {
        }
//        setCod_empleado(cod_empleado);
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext externalContext = context.getExternalContext();
        HttpServletRequest originRequest = (HttpServletRequest) externalContext.getRequest();
        String scheme = originRequest.getScheme();
        String server = originRequest.getServerName();
        int port = originRequest.getServerPort();
        String contextPath = originRequest.getContextPath();
        String URL_Informacion = scheme + "://" + server + ":" + port + "" + contextPath + "/Personal/EditarPersonal.xhtml?faces-redirect=true";
        context.getExternalContext().redirect(URL_Informacion);
        System.out.println("ABRIR VISTA DE EDICION DE EMPLEADO RH " +cod_empleado);
    }
    
    public void agregarEmpleado() throws IOException{
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext externalContext = context.getExternalContext();
        HttpServletRequest originRequest = (HttpServletRequest) externalContext.getRequest();
        String scheme = originRequest.getScheme();
        String server = originRequest.getServerName();
        int port = originRequest.getServerPort();
        String contextPath = originRequest.getContextPath();
        String URL_Informacion = scheme + "://" + server + ":" + port + "" + contextPath + "/Personal/AltaDePersonal.xhtml";
        context.getExternalContext().redirect(URL_Informacion);
        System.out.println("ABRIR VISTA DE AGREGAR DE EMPLEADO RH ");
    }

    public void reportePersonal() {
        try {

            //inicio ruta del reporte 
            //Carpeta
            String reportPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/resources/") + File.separator + "reports";

            //Nombre del documento
            String ubicacionPlantilla = reportPath + File.separator + "ReportePersonal.jasper";

            //Crear objeto de java 
            File jasper = new File(ubicacionPlantilla);

            //ruta de imagenes
            String ubicacionHeaderImage = reportPath + File.separator + "images" + File.separator + "Encabezado.png";
            String ubicacionHeaderImage2 = reportPath + File.separator + "images" + File.separator + "EncabezadoP2.png";

            String ubicacionFooterImage = reportPath + File.separator + "images" + File.separator + "Pie.png";

            //Termina ruta del reporte
            //inicia contenido de reporte 
            JRBeanCollectionDataSource detalle = new JRBeanCollectionDataSource(getListaDetalleEmpleadosNom());

            //JRBeanCollectionDataSource ordenPorClienteServicio = new JRBeanCollectionDataSource(DetalleOrdenClienteWSClient.detalleOrdenCliente(getClienteSeleccionado().getClienteid()));
            //Termina el contenido
            //parametros de contenido 
            Map<String, Object> parametros = new HashMap<>();
            parametros.put("urlHeaderImage", ubicacionHeaderImage);
            parametros.put("urlHeaderImage2", ubicacionHeaderImage2);
            parametros.put("urlFooterImage", ubicacionFooterImage);
            parametros.put("detalle", detalle);
            //parametros.put("nombreCliente", getClienteSeleccionado().getNombrecia());
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
            java.util.logging.Logger.getLogger(DetalleEmpleadosMB.class.getName()).log(Level.SEVERE, null, ioe);
        }
    }

    public List<DetalleEmpleadosDTO> getListaDetalleEmpleadosNom() {
        return listaDetalleEmpleadosNom;
    }

    public void setListaDetalleEmpleadosNom(List<DetalleEmpleadosDTO> listaDetalleEmpleadosNom) {
        this.listaDetalleEmpleadosNom = listaDetalleEmpleadosNom;
    }

    /**
     * @return the cod_empleado
     */
    public static Integer getCod_empleado() {
        return cod_empleado;
    }

    /**
     * @param aCod_empleado the cod_empleado to set
     */
    public static void setCod_empleado(Integer aCod_empleado) {
        cod_empleado = aCod_empleado;
    }
    
    public VerInformacionDePersonalDTO getVempleadoSeleccionado() {
        return VempleadoSeleccionado;
    }

    public void setVempleadoSeleccionado(VerInformacionDePersonalDTO VempleadoSeleccionado) {
        this.VempleadoSeleccionado = VempleadoSeleccionado;
    }

}
