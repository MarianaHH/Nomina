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
import com.mbn.sinod.model.entidades.Tsgrhpuestos;
import com.mbn.sinod.web.client.CabecerasWSClient;
import com.mbn.sinod.web.client.ConfPagoWSClient;
import com.mbn.sinod.web.client.DetalleEmpWSClient;
import com.mbn.sinod.web.util.ResourceBundles;
import com.mbn.sinod.web.util.StaticsConstants;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.apache.deltaspike.core.api.scope.ViewAccessScoped;
import org.primefaces.context.RequestContext;

/**
 *
 * @author torre
 */
@Named(value = "autopagosMB")
@ViewAccessScoped
public class AutPagosMB implements Serializable {

    private static final ResourceBundle BUNDLE = ResourceBundle.getBundle(ResourceBundles.MESSAGES.getBundleName());
    private Boolean visible;
    private Integer mostrarBoton;
    private Tsgrhempleados empleados;
    private Tsgrhpuestos puestos;
    private Tsgnomcabecera cabeceraEmp;

    private EmpDTO todosEmpleados;
    private DetalleEmpDTO todosEmp2;
    private CabeceraDTO todasCabeceras;
    private ConfPagoDTO confPAgos;
    private List<Tsgrhempleados> listaEmpleados;
    private List<Tsgrhpuestos> listaPuestos;
    private List<EmpDTO> todosEmpleados2;
    
    private List<Tsgnomcabecera> todasCabece;
    private ArrayList<ConfPagoDTO> confirmacionesPagos;

    private Tsgnomconfpago pagos3;
    private List<Tsgnomconfpago> pagos;
    private ArrayList<Tsgnomconfpago> pagos2;
    private Tsgnomempquincena empPagos;

    private List<DetalleEmpDTO> todosEmp;
    
    @PostConstruct
    public void iniciarVariable() {
        todosEmp = new ArrayList<>();
        setTodasCabece(CabecerasWSClient.listaCabecera());
        setConfirmacionesPagos(new ArrayList<>());
        setPagos2(new ArrayList<>());
    }

    public void busquedas() throws JsonProcessingException {
        setTodosEmpleados2(getTodosEmpleados2());
        ///////////////////////////////////////////////////////////////////////////////////////////////
        setTodosEmpleados(DetalleEmpWSClient.EMPladoDTO(getCabeceraEmp().getCodCabeceraid()));
        setTodosEmp(getTodosEmpleados().getListaEmp());

        System.out.println("mb de pagos: " + getTodosEmp2());
        System.out.println("mb de la cabecera: " + getCabeceraEmp());
    }

    public void autorizarRF(DetalleEmpDTO detalleEmp) throws JsonProcessingException {
        System.out.println("FUNCA PARA GUARDAR " + detalleEmp.getNomcompleto());
        for (int i = 0; i < getTodosEmp().size(); i++) {
            setPagos3(new Tsgnomconfpago());
            setEmpPagos(new Tsgnomempquincena());
            if (getTodosEmp().get(i).getCodempqui().equals(detalleEmp.getCodempqui())) {
                getTodosEmp().get(i).setBol_pagofinanzas(true);
//                getConfirmacionesPagos().get(i).getConfirmaPago().setBolPagofinanzas(true);
//                getConfirmacionesPagos().get(i).getConfirmaPago().getCodEmpquincenaidFk().setCodEmpquincenaid(detalleEmp.getCodempqui());
                getEmpPagos().setCodEmpquincenaid(detalleEmp.getCodempqui());
                getPagos3().setBolPagofinanzas(true);
                getPagos3().setCodEmpquincenaidFk(getEmpPagos());
                getPagos2().add(getPagos3());

            }

        }
    }
    
    public void rechazarRF(DetalleEmpDTO detalleEmp) throws JsonProcessingException {
        System.out.println("FUNCA PARA RECHAZAR " + detalleEmp.getNomcompleto());
        for (int i = 0; i < getTodosEmp().size(); i++) {
            setPagos3(new Tsgnomconfpago());
            setEmpPagos(new Tsgnomempquincena());
            if (getTodosEmp().get(i).getCodempqui().equals(detalleEmp.getCodempqui())) {
                getTodosEmp().get(i).setBol_pagofinanzas(false);
//                getConfirmacionesPagos().get(i).getConfirmaPago().setBolPagofinanzas(true);
//                getConfirmacionesPagos().get(i).getConfirmaPago().getCodEmpquincenaidFk().setCodEmpquincenaid(detalleEmp.getCodempqui());
                getEmpPagos().setCodEmpquincenaid(detalleEmp.getCodempqui());
                getPagos3().setBolPagofinanzas(false);
                getPagos3().setCodEmpquincenaidFk(getEmpPagos());
                getPagos2().add(getPagos3());
            }

        }
    }

    public void autlrizaRH(DetalleEmpDTO detalleEmp) throws JsonProcessingException {
        System.out.println("FUNCA PARA GUARDAR: " + detalleEmp.getNomcompleto());
        ConfPagoDTO DTO = new ConfPagoDTO();
        for (int i = 0; i < getTodosEmp().size(); i++) {
            setPagos3(new Tsgnomconfpago());
            setEmpPagos(new Tsgnomempquincena());
            if (getTodosEmp().get(i).getCodempqui().equals(detalleEmp.getCodempqui())) {
                getTodosEmp().get(i).setBol_pagorh(true);
//                getConfirmacionesPagos().get(i).getConfirmaPago().setBolPagofinanzas(true);
//                getConfirmacionesPagos().get(i).getConfirmaPago().getCodEmpquincenaidFk().setCodEmpquincenaid(detalleEmp.getCodempqui());
                getEmpPagos().setCodEmpquincenaid(detalleEmp.getCodempqui());
                System.out.println("Id EMP: " + detalleEmp.getCodempqui());
                getPagos3().setBolPagorh(true);
                getPagos3().setCodEmpquincenaidFk(getEmpPagos());
                getPagos2().add(getPagos3());

            }

        }
    }

    public void rechazarRH(DetalleEmpDTO detalleEmp) throws JsonProcessingException {
        System.out.println("FUNCA PARA RECHAZAR " + detalleEmp.getNomcompleto());
        for (int i = 0; i < getTodosEmp().size(); i++) {
            setPagos3(new Tsgnomconfpago());
            setEmpPagos(new Tsgnomempquincena());
            if (getTodosEmp().get(i).getCodempqui().equals(detalleEmp.getCodempqui())) {
                getTodosEmp().get(i).setBol_pagorh(false);
//                getConfirmacionesPagos().get(i).getConfirmaPago().setBolPagofinanzas(true);
//                getConfirmacionesPagos().get(i).getConfirmaPago().getCodEmpquincenaidFk().setCodEmpquincenaid(detalleEmp.getCodempqui());
                getEmpPagos().setCodEmpquincenaid(detalleEmp.getCodempqui());
                getPagos3().setBolPagorh(false);
                getPagos3().setCodEmpquincenaidFk(getEmpPagos());
                getPagos2().add(getPagos3());
            }

        }
    }

    public void guardarRH() throws JsonProcessingException {
        ConfPagoDTO DTO = new ConfPagoDTO();
        DTO.setArrayListaConfirmaPago(getPagos2()); // funciones de guardar 
        ConfPagoWSClient.guardarPagoRH(DTO);
        generarMensaje(BUNDLE.getString(StaticsConstants.EXITO_GUARDADO), FacesMessage.SEVERITY_INFO);
    }

    public void guardarRF() throws JsonProcessingException {
        ConfPagoDTO DTO = new ConfPagoDTO();
        DTO.setArrayListaConfirmaPago(getPagos2()); // funciones de guardar 
        ConfPagoWSClient.guardarPagoRF(DTO);
        generarMensaje(BUNDLE.getString(StaticsConstants.EXITO_GUARDADO), FacesMessage.SEVERITY_INFO); //es para generar el mensaje en la pantalla
    }

    public void generarMensaje(String mensaje, FacesMessage.Severity sever) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(sever, "Mensaje: ", mensaje));
    }

    public void dialogAprobarTodos() {
        System.out.println("Aprobar");
        //generarMensaje(BUNDLE.getString(StaticsConstants.EXITO_GUARDADO), FacesMessage.SEVERITY_INFO);
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('confTodos').show();");

    }

    public void dialogCancelarTodos() {
        System.out.println("Cancelar");
        //generarMensaje(BUNDLE.getString(StaticsConstants.EXITO_GUARDADO), FacesMessage.SEVERITY_INFO);
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('cancelarTodos').show();");
    }
    
    public void validarTodas() throws JsonProcessingException {
//        DetalleEmpDTO dtoRespuesta = new DetalleEmpDTO();
//        dtoRespuesta.setListaDetalleDTO(getTodosEmp());
        //System.out.println(dtoRespuesta.getListaDetalleDTO().get(i).getDespuesto());
        ConfPagoWSClient.validarTodas(getCabeceraEmp().getCodCabeceraid());
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('confTodos').hide();");
        generarMensaje(BUNDLE.getString(StaticsConstants.EXITO_GUARDADO), FacesMessage.SEVERITY_INFO);
        busquedas();
    }
    
    public void validarTodasRH() throws JsonProcessingException {
        ConfPagoWSClient.validarTodasRH(getCabeceraEmp().getCodCabeceraid());
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('confTodos').hide();");
        generarMensaje(BUNDLE.getString(StaticsConstants.EXITO_GUARDADO), FacesMessage.SEVERITY_INFO);
        busquedas();
    }
    
    public void rechazarTodasRF() throws JsonProcessingException {
        ConfPagoWSClient.rechazarTodasRF(getCabeceraEmp().getCodCabeceraid());
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('cancelarTodos').hide();");
        generarMensaje(BUNDLE.getString(StaticsConstants.EXITO_GUARDADO), FacesMessage.SEVERITY_INFO);
        busquedas();
    }
    
    public void rechazarTodasRH() throws JsonProcessingException {
        ConfPagoWSClient.rechazarTodasRH(getCabeceraEmp().getCodCabeceraid());
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('cancelarTodos').hide();");
        generarMensaje(BUNDLE.getString(StaticsConstants.EXITO_GUARDADO), FacesMessage.SEVERITY_INFO);
        busquedas();
    }

    /**
     * @return the visible
     */
    public Boolean getVisible() {
        return visible;
    }

    /**
     * @param visible the visible to set
     */
    public void setVisible(Boolean visible) {
        this.visible = visible;
    }

    /**
     * @return the mostrarBoton
     */
    public Integer getMostrarBoton() {
        return mostrarBoton;
    }

    public void setMostrarBoton(Integer mostrarBoton) {
        this.mostrarBoton = mostrarBoton;
    }

    public void dialogoEditarConfig(int valor) throws IOException {
        setVisible(true);
        setMostrarBoton(valor);
        //reload();
        //RequestContext context = RequestContext.getCurrentInstance();
        //context.execute("PF('detalleConfConcepto').show();");
    }

    /**
     * @return the empleados
     */
    public Tsgrhempleados getEmpleados() {
        return empleados;
    }

    /**
     * @param empleados the empleados to set
     */
    public void setEmpleados(Tsgrhempleados empleados) {
        this.empleados = empleados;
    }

    /**
     * @return the listaPuestos
     */
    public List<Tsgrhpuestos> getListaPuestos() {
        return listaPuestos;
    }

    /**
     * @param listaPuestos the listaPuestos to set
     */
    public void setListaPuestos(List<Tsgrhpuestos> listaPuestos) {
        this.listaPuestos = listaPuestos;
    }

    /**
     * @return the puestos
     */
    public Tsgrhpuestos getPuestos() {
        return puestos;
    }

    /**
     * @param puestos the puestos to set
     */
    public void setPuestos(Tsgrhpuestos puestos) {
        this.puestos = puestos;
    }

    /**
     * @return the todosEmpleados
     */
    public EmpDTO getTodosEmpleados() {
        return todosEmpleados;
    }

    /**
     * @param todosEmpleados the todosEmpleados to set
     */
    public void setTodosEmpleados(EmpDTO todosEmpleados) {
        this.todosEmpleados = todosEmpleados;
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

    public List<Tsgrhempleados> getListaEmpleados() {
        return listaEmpleados;
    }

    public void setListaEmpleados(List<Tsgrhempleados> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }

//    public List<ConfPagoDTO> getListaPagos() {
//        return listaPagos;
//    }
//
//    public void setListaPagos(List<ConfPagoDTO> listaPagos) {
//        this.listaPagos = listaPagos;
//    }
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
     * @return the todosEmpleados2
     */
    public List<EmpDTO> getTodosEmpleados2() {
        return todosEmpleados2;
    }

    /**
     * @param todosEmpleados2 the todosEmpleados2 to set
     */
    public void setTodosEmpleados2(List<EmpDTO> todosEmpleados2) {
        this.todosEmpleados2 = todosEmpleados2;
    }

    /**
     * @return the todosEmp2
     */
    public DetalleEmpDTO getTodosEmp2() {
        return todosEmp2;
    }

    /**
     * @param todosEmp2 the todosEmp2 to set
     */
    public void setTodosEmp2(DetalleEmpDTO todosEmp2) {
        this.todosEmp2 = todosEmp2;
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

}
