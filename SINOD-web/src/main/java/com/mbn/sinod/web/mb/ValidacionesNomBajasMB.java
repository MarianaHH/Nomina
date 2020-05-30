/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.web.mb;

import com.mbn.sinod.model.dto.ValidacionesNomBajasDTO;
import com.mbn.sinod.web.client.ValidacionesNomBajasWSClient;
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

/**
 *
 * @author Ivette
 */
@Named(value = "validacionesNomBajasMB")
@ViewAccessScoped
public class ValidacionesNomBajasMB implements Serializable{
    
    private List<ValidacionesNomBajasDTO> listaBajasValidadas;
    
    private final static Logger logger = Logger.getLogger(HistorialEmpleadosRhMB.class);
    
    @PostConstruct
    public void iniciarVariables() {
        listaBajasValidadas = new ArrayList<>();
        setListaBajasValidadas(ValidacionesNomBajasWSClient.detallesValidacionesNominaBajas());
    }

    public List<ValidacionesNomBajasDTO> getListaBajasValidadas() {
        return listaBajasValidadas;
    }

    public void setListaBajasValidadas(List<ValidacionesNomBajasDTO> listaBajasValidadas) {
        this.listaBajasValidadas = listaBajasValidadas;
    }
    
    public void reporteHistorialBajas() {
        try {

            //inicio ruta del reporte 
            //Carpeta
            String reportPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/resources/") + File.separator + "reports";

            //Nombre del documento
            String ubicacionPlantilla = reportPath + File.separator + "ReporteBajasPersonal.jasper";

            //Crear objeto de java 
            File jasper = new File(ubicacionPlantilla);

            //ruta de imagenes
            String ubicacionHeaderImage = reportPath + File.separator + "images" + File.separator + "Encabezado.png";

            String ubicacionFooterImage = reportPath + File.separator + "images" + File.separator + "Pie.png";

            //Termina ruta del reporte
            //inicia contenido de reporte 
            JRBeanCollectionDataSource rechazadas = new JRBeanCollectionDataSource(getListaBajasValidadas());          
            
            //Termina el contenido
            //parametros de contenido 
            Map<String, Object> parametros = new HashMap<>();
            parametros.put("urlHeaderImage", ubicacionHeaderImage);
            parametros.put("urlFooterImage", ubicacionFooterImage);
            parametros.put("rechazadas", rechazadas);
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
            java.util.logging.Logger.getLogger(ValidacionesNomBajasMB.class.getName()).log(Level.SEVERE, null, ioe);
        }
    }
}
