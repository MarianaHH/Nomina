/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.web.mb;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mbn.sinod.model.dto.CabeceraDTO;
import com.mbn.sinod.model.dto.ConfPagoDTO;
import com.mbn.sinod.model.dto.DetalleEmpDTO;
import com.mbn.sinod.model.dto.EmpDTO;
import com.mbn.sinod.model.entidades.Tsgnomcabecera;
import com.mbn.sinod.model.entidades.Tsgnomconfpago;
import com.mbn.sinod.model.entidades.Tsgnomempquincena;
import com.mbn.sinod.model.entidades.Tsgrhempleados;
import com.mbn.sinod.model.entidades.Usuario;
import com.mbn.sinod.web.client.CabecerasWSClient;
import com.mbn.sinod.web.client.ConfPagoWSClient;
import com.mbn.sinod.web.client.DetalleDesglosePercepcionWSClient;
import com.mbn.sinod.web.client.DetalleDesgloseWSClient;
import com.mbn.sinod.web.client.DetalleEmpWSClient;
import com.mbn.sinod.web.client.SumaDesgloseWSClient;
import com.mbn.sinod.web.util.ResourceBundles;
import com.mbn.sinod.web.util.StaticsConstants;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import static net.sf.jasperreports.engine.fill.DefaultChartTheme.BUNDLE;
import org.apache.deltaspike.core.api.scope.ViewAccessScoped;
import static org.atmosphere.annotation.AnnotationUtil.logger;
import org.primefaces.context.RequestContext;

/**
 *
 * @author eduardotorres
 */
@Named(value = "empleadoMB")
@ViewAccessScoped
public class EmpleadoMB implements Serializable {

    private static final ResourceBundle BUNDLE = ResourceBundle.getBundle(ResourceBundles.MESSAGES.getBundleName());
    private Tsgrhempleados empleadoLogeado;
    private Usuario usuario;
    //ARCHIVOS DE CONF_PAGOS
    private List<DetalleEmpDTO> todosEmp;
    private ArrayList<ConfPagoDTO> confirmacionesPagos;
    private Tsgnomconfpago pagos3;
    private List<Tsgnomconfpago> pagos;
    private ArrayList<Tsgnomconfpago> pagos2;
    private Tsgnomempquincena empPagos;
    private ConfPagoDTO confPAgos;
    
    // ARCHIVOS DEL DTO 
    private EmpDTO empConf;  //EmpleadoConf
    private List<EmpDTO> empDTO;  //empleado
    private DetalleEmpDTO Emp2;
    private List<DetalleEmpDTO> empSelecionado;
    
    // CABECERAS 
    private List<Tsgnomcabecera> todasCabece;
    private Tsgnomcabecera cabeceraEmp;
    private CabeceraDTO todasCabeceras;
    
    
    @PostConstruct
    public void iniciarVariables() {
        
        empSelecionado = new ArrayList<>();
        this.setUsuario((Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario"));
        this.setEmpleadoLogeado((Tsgrhempleados) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("empleado"));
        
        setTodasCabece(CabecerasWSClient.listaCabecera());
        setConfirmacionesPagos(new ArrayList<>());
        setPagos2(new ArrayList<>());
    }
    
    public void busquedas() throws JsonProcessingException {

        setEmpDTO(getEmpDTO());
        setEmpConf(DetalleEmpWSClient.confirmaEmpleado(getCabeceraEmp().getCodCabeceraid(), 
                getEmpleadoLogeado().getCodEmpleado()));
        setEmpSelecionado(getEmpConf().getListaEmp());
    }
    
    public void generarMensaje(String mensaje, FacesMessage.Severity sever) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(sever, "Mensaje: ", mensaje));
    }
    
    public void dialogAprobar() {
        System.out.println("Aprobar");
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('aprobarPago').show();");

    }

    public void dialogRechazar() {
        System.out.println("Cancelar " );
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('rechazarPago').show();");
    }
    
    public void autorizarEMP(DetalleEmpDTO detalleEmp) throws JsonProcessingException {
        //System.out.println("FUNCA PARA GUARDAR " + detalleEmp.getNomcompleto());
        getEmpSelecionado().get(0).setBol_pagoempleado(true);
        ConfPagoWSClient.guardarPagoEMP(detalleEmp.getCodempqui(), detalleEmp.getBol_pagoempleado());
        
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('aprobarPago').hide();");
        generarMensaje(BUNDLE.getString(StaticsConstants.EXITO_GUARDADO), FacesMessage.SEVERITY_INFO);
        busquedas();
    }
    
    public void rechazarEMP(DetalleEmpDTO detalleEmp) throws JsonProcessingException {

        getEmpSelecionado().get(0).setBol_pagoempleado(false);
        ConfPagoWSClient.guardarPagoEMP(detalleEmp.getCodempqui(), detalleEmp.getBol_pagoempleado());
       
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('rechazarPago').hide();");
        generarMensaje(BUNDLE.getString(StaticsConstants.EXITO_GUARDADO), FacesMessage.SEVERITY_INFO);
        busquedas();
    }
    
    
    public void autorizarRF(DetalleEmpDTO detalleEmp) throws JsonProcessingException {
        System.out.println("FUNCA PARA GUARDAR " + detalleEmp.getNomcompleto());
        ConfPagoDTO DTO = new ConfPagoDTO();
        for (int i = 0; i < getTodosEmp().size(); i++) {
            setPagos3(new Tsgnomconfpago());
            setEmpPagos(new Tsgnomempquincena());
            if (getTodosEmp().get(i).getCodempqui().equals(detalleEmp.getCodempqui())) {
                getTodosEmp().get(i).setBol_pagofinanzas(true);
                getEmpPagos().setCodEmpquincenaid(detalleEmp.getCodempqui());
                getPagos3().setBolPagofinanzas(true);
                getPagos3().setCodEmpquincenaidFk(getEmpPagos());
                getPagos2().add(i, getPagos3());

            }
        }
    }
    
    public void autlrizaRH (DetalleEmpDTO detalleEmp) throws JsonProcessingException{
        System.out.println("FUNCA PARA GUARDAR: " + detalleEmp.getNomcompleto());
        ConfPagoDTO DTO = new ConfPagoDTO();
        for (int i = 0; i < getTodosEmp().size(); i++) {
            setPagos3(new Tsgnomconfpago());
            setEmpPagos(new Tsgnomempquincena());
            if (getTodosEmp().get(i).getCodempqui().equals(detalleEmp.getCodempqui())) {
                getTodosEmp().get(i).setBol_pagorh(true);getEmpPagos().setCodEmpquincenaid(detalleEmp.getCodempqui());
                System.out.println("Id EMP: " + detalleEmp.getCodempqui());
                getPagos3().setBolPagorh(true);
                getPagos3().setCodEmpquincenaidFk(getEmpPagos());
                getPagos2().add(i, getPagos3());

            }

        }
    }
    
    public void reporteReciboNomnia() {
        try {

            //inicio ruta del reporte 
            //Carpeta
            String reportPath = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/resources/") + File.separator + "reports";

            //Nombre del documento
            String ubicacionPlantilla = reportPath + File.separator + "ReporteReciboNomina.jasper";

            //Crear objeto de java 
            File jasper = new File(ubicacionPlantilla);

            //ruta de imagenes
            String ubicacionHeaderImage = reportPath + File.separator + "images" + File.separator + "Encabezado.png";

            String ubicacionFooterImage = reportPath + File.separator + "images" + File.separator + "Pie.png";

            //Termina ruta del reporte
            //inicia contenido de reporte 
            
            JRBeanCollectionDataSource detallePercepcionServicio = new JRBeanCollectionDataSource(DetalleDesglosePercepcionWSClient.listarPercepciones(getEmpleadoLogeado().getCodEmpleado(), getCabeceraEmp().getCodCabeceraid()).getGetListaPercepcion());
            JRBeanCollectionDataSource detalleDeduccionServicio = new JRBeanCollectionDataSource(DetalleDesgloseWSClient.listarDeducciones(getEmpleadoLogeado().getCodEmpleado(), getCabeceraEmp().getCodCabeceraid()).getGetListaConcep());
            JRBeanCollectionDataSource detalleSumasServicio = new JRBeanCollectionDataSource(SumaDesgloseWSClient.sumaDesglose(getEmpleadoLogeado().getCodEmpleado(), getCabeceraEmp().getCodCabeceraid()));
            JRBeanCollectionDataSource detalleSumas2Servicio = new JRBeanCollectionDataSource(SumaDesgloseWSClient.sumaDesglose(getEmpleadoLogeado().getCodEmpleado(), getCabeceraEmp().getCodCabeceraid()));
            JRBeanCollectionDataSource detalleCabeceraServicio = new JRBeanCollectionDataSource(CabecerasWSClient.listaCabecera());
            //JRBeanCollectionDataSource empleadoLogeado = new JRBeanCollectionDataSource(this.empleadoLogeado.);
        
            //Termina el contenido
            //parametros de contenido 
            Map<String, Object> parametros = new HashMap<>();
            parametros.put("urlHeaderImage", ubicacionHeaderImage);
            parametros.put("urlFooterImage", ubicacionFooterImage);
            parametros.put("detallePercepcion", detallePercepcionServicio);
            parametros.put("detalleDeduccion", detalleDeduccionServicio);
            parametros.put("detalleSuma", detalleSumasServicio);
            parametros.put("detalleSuma2", detalleSumas2Servicio);
            parametros.put("detalleCabecera", detalleCabeceraServicio);
            
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
            parametros.put("nomina", getCabeceraEmp().getCodNbnomina());
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
            java.util.logging.Logger.getLogger(DesgloceMB.class.getName()).log(Level.SEVERE, null, ioe);
        }
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
     * @return the todosEmp
     */
    public List<DetalleEmpDTO> getTodosEmp() {
        return todosEmp;
    }

    /**
     * @param todosEmp the todosEmp to set
     */
    public void setTodosEmp(List<DetalleEmpDTO> todosEmp) {
        this.todosEmp = todosEmp;
    }

    /**
     * @return the confirmacionesPagos
     */
    public ArrayList<ConfPagoDTO> getConfirmacionesPagos() {
        return confirmacionesPagos;
    }

    /**
     * @param confirmacionesPagos the confirmacionesPagos to set
     */
    public void setConfirmacionesPagos(ArrayList<ConfPagoDTO> confirmacionesPagos) {
        this.confirmacionesPagos = confirmacionesPagos;
    }

    /**
     * @return the pagos3
     */
    public Tsgnomconfpago getPagos3() {
        return pagos3;
    }

    /**
     * @param pagos3 the pagos3 to set
     */
    public void setPagos3(Tsgnomconfpago pagos3) {
        this.pagos3 = pagos3;
    }

    /**
     * @return the pagos
     */
    public List<Tsgnomconfpago> getPagos() {
        return pagos;
    }

    /**
     * @param pagos the pagos to set
     */
    public void setPagos(List<Tsgnomconfpago> pagos) {
        this.pagos = pagos;
    }

    /**
     * @return the pagos2
     */
    public ArrayList<Tsgnomconfpago> getPagos2() {
        return pagos2;
    }

    /**
     * @param pagos2 the pagos2 to set
     */
    public void setPagos2(ArrayList<Tsgnomconfpago> pagos2) {
        this.pagos2 = pagos2;
    }

    /**
     * @return the empPagos
     */
    public Tsgnomempquincena getEmpPagos() {
        return empPagos;
    }

    /**
     * @param empPagos the empPagos to set
     */
    public void setEmpPagos(Tsgnomempquincena empPagos) {
        this.empPagos = empPagos;
    }

    /**
     * @return the confPAgos
     */
    public ConfPagoDTO getConfPAgos() {
        return confPAgos;
    }

    /**
     * @param confPAgos the confPAgos to set
     */
    public void setConfPAgos(ConfPagoDTO confPAgos) {
        this.confPAgos = confPAgos;
    }

    /**
     * @return the empConf
     */
    public EmpDTO getEmpConf() {
        return empConf;
    }

    /**
     * @param empConf the empConf to set
     */
    public void setEmpConf(EmpDTO empConf) {
        this.empConf = empConf;
    }

    /**
     * @return the empDTO
     */
    public List<EmpDTO> getEmpDTO() {
        return empDTO;
    }

    /**
     * @param empDTO the empDTO to set
     */
    public void setEmpDTO(List<EmpDTO> empDTO) {
        this.empDTO = empDTO;
    }

    /**
     * @return the Emp2
     */
    public DetalleEmpDTO getEmp2() {
        return Emp2;
    }

    /**
     * @param Emp2 the Emp2 to set
     */
    public void setEmp2(DetalleEmpDTO Emp2) {
        this.Emp2 = Emp2;
    }

    /**
     * @return the empSelecionado
     */
    public List<DetalleEmpDTO> getEmpSelecionado() {
        return empSelecionado;
    }

    /**
     * @param empSelecionado the empSelecionado to set
     */
    public void setEmpSelecionado(List<DetalleEmpDTO> empSelecionado) {
        this.empSelecionado = empSelecionado;
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
     * @return the cabeceraEmp
     */
    public Tsgnomcabecera getCabeceraEmp() {
        return cabeceraEmp;
    }

    /**
     * @param cabeceraEmp the cabeceraEmp to set
     */
    public void setCabeceraEmp(Tsgnomcabecera cabeceraEmp) {
        this.cabeceraEmp = cabeceraEmp;
    }

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
    
}   