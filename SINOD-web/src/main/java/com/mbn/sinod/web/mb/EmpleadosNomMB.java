/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.web.mb;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mbn.sinod.model.dto.EmpleadoDTO;
import com.mbn.sinod.model.dto.EmpleadosNomDTO;
import com.mbn.sinod.model.dto.VerInformacionDePersonalDTO;
import com.mbn.sinod.model.entidades.Tsgnomempleados;
import com.mbn.sinod.model.entidades.Tsgrhempleados;
import com.mbn.sinod.web.client.EmpleadosNomWSClient;
import com.mbn.sinod.web.client.EmpleadosWSClient;
import com.mbn.sinod.web.client.VerInformacionDePersonalWSClient;
import com.mbn.sinod.web.util.ResourceBundles;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import org.apache.deltaspike.core.api.scope.ViewAccessScoped;
import org.primefaces.event.FlowEvent;

/**
 *
 * @author Ivette
 */
@Named(value = "empleadosNomMB")
@ViewAccessScoped
public class EmpleadosNomMB implements Serializable {

    private static final ResourceBundle BUNDLE = ResourceBundle.getBundle(ResourceBundles.MESSAGES.getBundleName());
    private List<Tsgrhempleados> listarEmpleados;
    private Tsgrhempleados empleadoSeleccionado;
    private List<EmpleadoDTO> listaRH;
    private EmpleadoDTO dtoemp;
    private Tsgnomempleados empleadosNom;
    private Tsgnomempleados empleadosNomAlta;
    private Date fecha;
    private EmpleadosNomDTO listaNomina;
    private Integer cod_empleado;
    private List<Tsgnomempleados> listaempleadosNom;
    private VerInformacionDePersonalDTO detalleSeleccionado;
    private Tsgrhempleados empleadoLogeado;

    @PostConstruct
    public void iniciarVariables() {
        listarEmpleados = new ArrayList<>();
        this.setEmpleadoLogeado((Tsgrhempleados) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("empleado"));
        setDetalleSeleccionado(new VerInformacionDePersonalDTO());
        setEmpleadosNom(new Tsgnomempleados());
        setEmpleadosNomAlta(new Tsgnomempleados());
        setListarEmpleados(EmpleadosWSClient.listarEmpleados());
        setCod_empleado(verifica());
        if (getCod_empleado() > 0) {
            setDetalleSeleccionado(VerInformacionDePersonalWSClient.informacionPorEmpleado(getCod_empleado()).get(0));
            setEmpleadosNom(EmpleadosNomWSClient.obtenerEmpleadosnomPorIdNom(getCod_empleado()).getEmpleado());
        }
    }

    public Integer verifica() {
        // get cookies
        HttpServletRequest httpServletRequest = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        Cookie[] cookies = httpServletRequest.getCookies();
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                if (cookies[i].getName().equals("mbnEMPmbn")) {
                    return Integer.parseInt(cookies[i].getValue());
                }
            }
        }
        return 0;
    }

    public void busquedaInfoPersonal() {
        setDtoemp(EmpleadosWSClient.listarEmpleadosRh(getEmpleadoSeleccionado().getCodEmpleado()));
    }

    public void guardar() throws JsonProcessingException {

        EmpleadosNomDTO dtoRespuesta = new EmpleadosNomDTO();

        getEmpleadosNomAlta().setAudCodcreadopor(getEmpleadoLogeado().getCodEmpleado());
        getEmpleadosNomAlta().setAudFeccreacion(new Date());
        getEmpleadosNomAlta().setCodEmpleadoFk(getEmpleadoSeleccionado().getCodEmpleado());
        getEmpleadosNomAlta().setBolEstatus(true);
        getEmpleadosNomAlta().setCodValidaciones('n');
        
        dtoRespuesta.setEmpleado(getEmpleadosNomAlta());
        EmpleadosNomWSClient.guardarEmpleado(dtoRespuesta);

        mostrarMensaje("Los datos han sido guardados exitosamente", "succes");

    }

    public void editar() throws JsonProcessingException {

        EmpleadosNomDTO dtoRespuesta = new EmpleadosNomDTO();

        getEmpleadosNom().setAudCodmodificadopor(getEmpleadoLogeado().getCodEmpleado());
        getEmpleadosNom().setAudFecmodificacion(new Date());

        dtoRespuesta.setEmpleado(getEmpleadosNom());
        EmpleadosNomWSClient.guardarEmpleado(dtoRespuesta);

        mostrarMensaje("Los datos han sido actualizados exitosamente", "succes");

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

    public void generarMensaje() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Mensaje: ", getMensaje()));
    }

    public String onFlowProcess(FlowEvent event) {

        return event.getNewStep();

    }

    public Tsgrhempleados getEmpleadoSeleccionado() {
        return empleadoSeleccionado;
    }

    public void setEmpleadoSeleccionado(Tsgrhempleados empleadoSeleccionado) {
        this.empleadoSeleccionado = empleadoSeleccionado;
    }

    public List<Tsgrhempleados> getListarEmpleados() {
        return listarEmpleados;
    }

    public void setListarEmpleados(List<Tsgrhempleados> listarEmpleados) {
        this.listarEmpleados = listarEmpleados;
    }


    public List<EmpleadoDTO> getListaRH() {
        return listaRH;
    }

    public void setListaRH(List<EmpleadoDTO> listaRH) {
        this.listaRH = listaRH;
    }

    public EmpleadoDTO getDtoemp() {
        return dtoemp;
    }

    public void setDtoemp(EmpleadoDTO dtoemp) {
        this.dtoemp = dtoemp;
    }

    public Tsgnomempleados getEmpleadosNom() {
        return empleadosNom;
    }

    public void setEmpleadosNom(Tsgnomempleados empleadosNom) {
        this.empleadosNom = empleadosNom;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Integer getCod_empleado() {
        return cod_empleado;
    }

    public void setCod_empleado(Integer cod_empleado) {
        this.cod_empleado = cod_empleado;
    }

    public EmpleadosNomDTO getListaNomina() {
        return listaNomina;
    }

    public void setListaNomina(EmpleadosNomDTO listaNomina) {
        this.listaNomina = listaNomina;
    }

    public List<Tsgnomempleados> getListaempleadosNom() {
        return listaempleadosNom;
    }

    public void setListaempleadosNom(List<Tsgnomempleados> listaempleadosNom) {
        this.listaempleadosNom = listaempleadosNom;
    }

    /**
     * @return the detalleSeleccionado
     */
    public VerInformacionDePersonalDTO getDetalleSeleccionado() {
        return detalleSeleccionado;
    }

    /**
     * @param detalleSeleccionado the detalleSeleccionado to set
     */
    public void setDetalleSeleccionado(VerInformacionDePersonalDTO detalleSeleccionado) {
        this.detalleSeleccionado = detalleSeleccionado;
    }

    public Tsgnomempleados getEmpleadosNomAlta() {
        return empleadosNomAlta;
    }

    public void setEmpleadosNomAlta(Tsgnomempleados empleadosNomAlta) {
        this.empleadosNomAlta = empleadosNomAlta;
    }

    public Tsgrhempleados getEmpleadoLogeado() {
        return empleadoLogeado;
    }

    public void setEmpleadoLogeado(Tsgrhempleados empleadoLogeado) {
        this.empleadoLogeado = empleadoLogeado;
    }

}
