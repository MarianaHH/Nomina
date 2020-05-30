/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.web.mb;


import com.mbn.sinod.model.dto.DesgloseEmpleadoDTO;
import com.mbn.sinod.model.dto.HistorialNomEmpleadosXMLDTO;
import com.mbn.sinod.model.dto.ValidacionesNominaDTO;
import com.mbn.sinod.model.entidades.Tsgnomempleados;
import com.mbn.sinod.web.client.EmpleadosNomWSClient;
import com.mbn.sinod.web.client.ValidacionesNominaWSClient;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.apache.deltaspike.core.api.scope.ViewAccessScoped;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;

/**
 *
 * @author Ivette
 */
@Named(value = "validacionesNominaMB")
@ViewAccessScoped
public class ValidacionesNominaMB implements Serializable {
    
    private List<ValidacionesNominaDTO> listaValidaciones;
    private List<Tsgnomempleados> listaEmpleadosNom;
    private ArrayList<HistorialNomEmpleadosXMLDTO> detalleEmpleados;
    private HistorialNomEmpleadosXMLDTO desglocexmldto;
    private Document doc;
    private ArrayList<HistorialNomEmpleadosXMLDTO> listaDesglocexml;
    private List<DesgloseEmpleadoDTO> listaDesxml;
    
     private final static Logger logger = Logger.getLogger(HistorialEmpleadosRhMB.class); 
     
    @PostConstruct
    public void iniciarVariables() {
        listaValidaciones = new ArrayList<>();
        setListaValidaciones(ValidacionesNominaWSClient.detallesValidacionesNomina());
    }

    public List<ValidacionesNominaDTO> getListaValidaciones() {
        return listaValidaciones;
    }

    public void setListaValidaciones(List<ValidacionesNominaDTO> listaValidaciones) {
        this.listaValidaciones = listaValidaciones;
    }
    
    public void reporteHistorialAltas() {
        try {

            //inicio ruta del reporte 
            //Carpeta
            String reportPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/resources/") + File.separator + "reports";

            //Nombre del documento
            String ubicacionPlantilla = reportPath + File.separator + "ReporteAltasPersonal.jasper";

            //Crear objeto de java 
            File jasper = new File(ubicacionPlantilla);

            //ruta de imagenes
            String ubicacionHeaderImage = reportPath + File.separator + "images" + File.separator + "Encabezado.png";

            String ubicacionFooterImage = reportPath + File.separator + "images" + File.separator + "Pie.png";

            //Termina ruta del reporte
            //inicia contenido de reporte 
            JRBeanCollectionDataSource validaciones = new JRBeanCollectionDataSource(getListaValidaciones());          
            
            //Termina el contenido
            //parametros de contenido 
            Map<String, Object> parametros = new HashMap<>();
            parametros.put("urlHeaderImage", ubicacionHeaderImage);
            parametros.put("urlFooterImage", ubicacionFooterImage);
            parametros.put("validaciones", validaciones);
            //parametros.put("nomina", getCabeceraEmp().getCodNbnomina());
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
            java.util.logging.Logger.getLogger(ValidacionesNominaMB.class.getName()).log(Level.SEVERE, null, ioe);
        }
    }
   
    public void historialPorEmpleado(Integer empleado){
        setListaDesxml(EmpleadosNomWSClient.obtenerEmpleadosnomPorIdNomHT(empleado).getListaDesgloce());
//        setListaEmpleadosNom(EmpleadosNomWSClient.obtenerEmpleadosnomPorIdNom(empleado).getListarEmpleadosNom());
//        setDetalleEmpleados(new ArrayList<>());
//        setListaDesglocexml(new ArrayList<>());
//        for (int i = 0; i < getListaEmpleadosNom().size(); i++) {
//            setDesglocexmldto(new HistorialNomEmpleadosXMLDTO());
//            DocumentBuilder documentBuilder = null;
//            try {
//                documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
//            } catch (ParserConfigurationException ex) {
//                java.util.logging.Logger.getLogger(ValidacionesNominaMB.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            InputSource inputSource = new InputSource();
//            inputSource.setCharacterStream(new StringReader(EmpleadosNomWSClient.obtenerEmpleadosnomPorIdNomHT(empleado).getDegloseXML()));
//            try {
//                setDoc(documentBuilder.parse(inputSource));
//                getDoc().getDocumentElement().normalize();
//                getDesglocexmldto().setFecha(getDoc().getElementsByTagName("fecha").item(0).getTextContent());
//                getDesglocexmldto().setSueldoImss(getDoc().getElementsByTagName("sueldoimss").item(0).getTextContent());
//                getDesglocexmldto().setSueldoHonorarios(getDoc().getElementsByTagName("sueldoadicional").item(0).getTextContent());
//                getDesglocexmldto().setEstatusFnzs(getDoc().getElementsByTagName("estatus").item(0).getTextContent());
//                System.out.println("ERROR HISTORIAL POR EMPLEADO ");
//
//                getListaDesglocexml().add(i, getDesglocexmldto());
//            } catch (SAXException | IOException ex) {
//                java.util.logging.Logger.getLogger(ValidacionesNominaMB.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
    
    }

    public List<Tsgnomempleados> getListaEmpleadosNom() {
        return listaEmpleadosNom;
    }

    public void setListaEmpleadosNom(List<Tsgnomempleados> listaEmpleadosNom) {
        this.listaEmpleadosNom = listaEmpleadosNom;
    }

    public ArrayList<HistorialNomEmpleadosXMLDTO> getDetalleEmpleados() {
        return detalleEmpleados;
    }

    public void setDetalleEmpleados(ArrayList<HistorialNomEmpleadosXMLDTO> detalleEmpleados) {
        this.detalleEmpleados = detalleEmpleados;
    }

    public HistorialNomEmpleadosXMLDTO getDesglocexmldto() {
        return desglocexmldto;
    }

    public void setDesglocexmldto(HistorialNomEmpleadosXMLDTO desglocexmldto) {
        this.desglocexmldto = desglocexmldto;
    }

    public Document getDoc() {
        return doc;
    }

    public void setDoc(Document doc) {
        this.doc = doc;
    }

    public ArrayList<HistorialNomEmpleadosXMLDTO> getListaDesglocexml() {
        return listaDesglocexml;
    }

    public void setListaDesglocexml(ArrayList<HistorialNomEmpleadosXMLDTO> listaDesglocexml) {
        this.listaDesglocexml = listaDesglocexml;
    }

    /**
     * @return the listaDesxml
     */
    public List<DesgloseEmpleadoDTO> getListaDesxml() {
        return listaDesxml;
    }

    /**
     * @param listaDesxml the listaDesxml to set
     */
    public void setListaDesxml(List<DesgloseEmpleadoDTO> listaDesxml) {
        this.listaDesxml = listaDesxml;
    }

    
    
}
