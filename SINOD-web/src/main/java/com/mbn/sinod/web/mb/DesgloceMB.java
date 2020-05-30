 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.web.mb;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mbn.sinod.model.dto.CabeceraDTO;
import com.mbn.sinod.model.dto.DesgloseDTO;
import com.mbn.sinod.model.dto.DetalleDesgloPercepDTO;
import com.mbn.sinod.model.dto.DetalleDesgloseDTO;
import com.mbn.sinod.model.dto.DetalleDesglosePercepcionDTO;
import com.mbn.sinod.model.entidades.Tsgnomcabecera;
import com.mbn.sinod.model.entidades.Tsgnomcncptoquinc;
import com.mbn.sinod.model.entidades.Tsgnomempquincena;
import com.mbn.sinod.model.entidades.Tsgrhempleados;
import com.mbn.sinod.model.entidades.Usuario;
import com.mbn.sinod.web.client.CabecerasWSClient;
import com.mbn.sinod.web.client.DetalleDesglosePercepcionWSClient;
import com.mbn.sinod.web.client.DetalleDesgloseWSClient;
import com.mbn.sinod.web.client.SumaDesgloseWSClient;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
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
import static org.atmosphere.annotation.AnnotationUtil.logger;

/**
 *
 * @author torre
 */

@Named(value = "desgloceMB")
@ViewAccessScoped
public class DesgloceMB implements Serializable{
    
    private CabeceraDTO todasCabeceras;
    private List<Tsgnomcabecera> todasCabece;
    private Tsgnomcabecera Cabece;
    private Tsgrhempleados empleadoLogeado;
    private Usuario usuario;
    private List<Tsgnomcncptoquinc> desgloceconcepto;
    
    private List<DetalleDesglosePercepcionDTO> perceciones2;
    private List<DetalleDesgloseDTO> deducciones2;  
    
    private DetalleDesgloPercepDTO perceciones;
    private DesgloseDTO deducciones;
    private List<Tsgnomempquincena> sumaDesglose;
//    private List<Team> teams;
    
            
    // Constructor
    @PostConstruct
    public void iniciarVariables() {
        this.usuario = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        this.setEmpleadoLogeado((Tsgrhempleados) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("empleado"));
//        
//        setPerceciones(DetalleDesglosePercepcionWSClient.listarPercepciones());
//        System.out.println("mb de percepciones bien");
//        
//        setDeducciones(DetalleDesgloseWSClient.listarConceptos());
//        System.out.println("mb de deducciones bien ");
        setTodasCabece(CabecerasWSClient.listaCabecera());
//        perceciones2 = new ArrayList<>();
//        setPerceciones2(DetalleDesglosePercepcionWSClient.listarPercepciones(Integer.cod_empleado, Integer.cod_cabecera));
        
    }

    public void busqueda() throws JsonProcessingException {
        setPerceciones(DetalleDesglosePercepcionWSClient.listarPercepciones(getEmpleadoLogeado().getCodEmpleado(), 
                getCabece().getCodCabeceraid()));
        
        setDeducciones(DetalleDesgloseWSClient
                .listarDeducciones(getEmpleadoLogeado().getCodEmpleado(), getCabece().getCodCabeceraid()));
        
        setPerceciones2(getPerceciones().getGetListaPercepcion());
//        setPerceciones(DetalleDesglosePercepcionWSClient               
//                .listarPercepciones(getEmpleadoLogeado().getCodEmpleado(), getCabece().getCodCabeceraid()));
        System.out.println("mb de percepciones bien " + getPerceciones().getGetListaPercepcion().size());
         
//        setDeducciones(DetalleDesgloseWSClient.listarDeducciones(11,16));
//        System.out.println("mb de deducciones bien ");
        setDeducciones2(getDeducciones().getGetListaConcep());
        System.out.println("mb de deducciones bien " + getDeducciones().getGetListaConcep().size());
        
        setSumaDesglose(SumaDesgloseWSClient.sumaDesglose(getEmpleadoLogeado().getCodEmpleado(), getCabece().getCodCabeceraid()));
        System.out.println("suma " + getSumaDesglose().get(0).getImpTotpercepcion()); 
        System.out.println("suma " + getSumaDesglose().get(0).getImpTotalemp()); 
    }
    
    public void reporteDesglose() {
        try {

            //inicio ruta del reporte 
            //Carpeta
            String reportPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/resources/") + File.separator + "reports";

            //Nombre del documento
            String ubicacionPlantilla = reportPath + File.separator + "ReporteDesglose.jasper";

            //Crear objeto de java 
            File jasper = new File(ubicacionPlantilla);

            //ruta de imagenes
            String ubicacionHeaderImage = reportPath + File.separator + "images" + File.separator + "Encabezado.png";

            String ubicacionFooterImage = reportPath + File.separator + "images" + File.separator + "Pie.png";

            //Termina ruta del reporte
            //inicia contenido de reporte 
            JRBeanCollectionDataSource detallePersepciones = new JRBeanCollectionDataSource(getPerceciones2());
            JRBeanCollectionDataSource detalleDeducciones = new JRBeanCollectionDataSource(getDeducciones2());
            JRBeanCollectionDataSource detalleSumas = new JRBeanCollectionDataSource(getSumaDesglose());
            JRBeanCollectionDataSource detalleSumas2 = new JRBeanCollectionDataSource(getSumaDesglose());
            
            //JRBeanCollectionDataSource detallePercepServicio = new JRBeanCollectionDataSource(DetalleDesglosePercepcionWSClient.listarPercepciones(getEmpleadoLogeado().getCodEmpleado(), getCabece().getCodCabeceraid()));
            
            //JRBeanCollectionDataSource ordenPorClienteServicio = new JRBeanCollectionDataSource(DetalleOrdenClienteWSClient.detalleOrdenCliente(getClienteSeleccionado().getClienteid()));
            //Termina el contenido
            //parametros de contenido 
            Map<String, Object> parametros = new HashMap<>();
            parametros.put("urlHeaderImage", ubicacionHeaderImage);
            parametros.put("urlFooterImage", ubicacionFooterImage);
            parametros.put("detallePercepcion", detallePersepciones);
            parametros.put("detalleDeduccion", detalleDeducciones);
            parametros.put("detalleSuma", detalleSumas);
            parametros.put("detalleSuma2", detalleSumas2);
            parametros.put("fecha", new Date());
            parametros.put("empleado", getEmpleadoLogeado());
            //parametros.put("nombreCliente", getClienteSeleccionado().getNombrecia());
            parametros.put("id", getEmpleadoLogeado().getCodEmpleado());
            parametros.put("nombre", getEmpleadoLogeado().getDesNombre());
            parametros.put("nombres", getEmpleadoLogeado().getDesNombres());
            parametros.put("apePaterno", getEmpleadoLogeado().getDesApepaterno());
            parametros.put("apeMaterno", getEmpleadoLogeado().getDesApematerno());
            parametros.put("codCurp", getEmpleadoLogeado().getCodCurp());
            parametros.put("codRfc", getEmpleadoLogeado().getCodRfc());
            parametros.put("codNss", getEmpleadoLogeado().getCodNss());
            parametros.put("desPuesto", getEmpleadoLogeado().getCodPuesto().getDesPuesto());
            parametros.put("desNbarea", getEmpleadoLogeado().getCodPuesto().getCodArea().getDesNbarea());
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
            java.util.logging.Logger.getLogger(DesgloceMB.class.getName()).log(Level.SEVERE, null, ioe);
        }
    }
    
    /**
     * @return the todasCabeceras
     */
    /**
     * @return the todasCabeceras
     */
    public CabeceraDTO getTodasCabeceras() {
        return todasCabeceras;
    }

    /**
     * @param todasCabeceras the todasCabeceras to set
     */
    public void setTodasCabeceras(CabeceraDTO todasCabeceras) {
        this.todasCabeceras = todasCabeceras;
    }

    /**
     * @return the todasCabece
     */
    public List<Tsgnomcabecera> getTodasCabece() {
        return todasCabece;
    }

    /**
     * @param todasCabece the todasCabece to set
     */
    public void setTodasCabece(List<Tsgnomcabecera> todasCabece) {
        this.todasCabece = todasCabece;
    }

    /**
     * @return the empleadoLogeado
     */
    public Tsgrhempleados getEmpleadoLogeado() {
        return empleadoLogeado;
    }

    /**
     * @param empleadoLogeado the empleadoLogeado to set
     */
    public void setEmpleadoLogeado(Tsgrhempleados empleadoLogeado) {
        this.empleadoLogeado = empleadoLogeado;
    }

    /**
     * @return the desgloceconcepto
     */
    public List<Tsgnomcncptoquinc> getDesgloceconcepto() {
        return desgloceconcepto;
    }

    /**
     * @param desgloceconcepto the desgloceconcepto to set
     */
    public void setDesgloceconcepto(List<Tsgnomcncptoquinc> desgloceconcepto) {
        this.desgloceconcepto = desgloceconcepto;
    }

    /**
     * @return the perceciones
     */
    public DetalleDesgloPercepDTO getPerceciones() {
        return perceciones;
    }

    /**
     * @param perceciones the perceciones to set
     */
    public void setPerceciones(DetalleDesgloPercepDTO perceciones) {
        this.perceciones = perceciones;
    }

    /**
     * @return the deducciones
     */
    public DesgloseDTO getDeducciones() {
        return deducciones;
    }

    /**
     * @param deducciones the deducciones to set
     */
    public void setDeducciones(DesgloseDTO deducciones) {
        this.deducciones = deducciones;
    }

    /**
     * @return the Cabece
     */
    public Tsgnomcabecera getCabece() {
        return Cabece;
    }

    /**
     * @param Cabece the Cabece to set
     */
    public void setCabece(Tsgnomcabecera Cabece) {
        this.Cabece = Cabece;
    }

    /**
     * @return the perceciones2
     */
    public List<DetalleDesglosePercepcionDTO> getPerceciones2() {
        return perceciones2;
    }

    /**
     * @param perceciones2 the perceciones2 to set
     */
    public void setPerceciones2(List<DetalleDesglosePercepcionDTO> perceciones2) {
        this.perceciones2 = perceciones2;
    }

    /**
     * @return the deducciones2
     */
    public List<DetalleDesgloseDTO> getDeducciones2() {
        return deducciones2;
    }

    /**
     * @param deducciones2 the deducciones2 to set
     */
    public void setDeducciones2(List<DetalleDesgloseDTO> deducciones2) {
        this.deducciones2 = deducciones2;
    }

    /**
     * @return the sumaDesglose
     */
    public List<Tsgnomempquincena> getSumaDesglose() {
        return sumaDesglose;
    }

    /**
     * @param sumaDesglose the sumaDesglose to set
     */
    public void setSumaDesglose(List<Tsgnomempquincena> sumaDesglose) {
        this.sumaDesglose = sumaDesglose;
    }

    
}
