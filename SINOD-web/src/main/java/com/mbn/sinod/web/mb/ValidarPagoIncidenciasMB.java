/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.web.mb;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mbn.sinod.model.dto.IncidenciasQuincenaDTO;
import com.mbn.sinod.model.entidades.Tsgnomempleados;
import com.mbn.sinod.model.entidades.Tsgnomquincena;
import com.mbn.sinod.model.entidades.Tsgrhempleados;
import com.mbn.sinod.model.entidades.Usuario;
import com.mbn.sinod.web.client.EmpleadosNomWSClient;
import com.mbn.sinod.web.client.IncidenciasQuincenaWSClient;
import com.mbn.sinod.web.client.QuincenasWSClient;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.apache.deltaspike.core.api.scope.ViewAccessScoped;
import org.primefaces.context.RequestContext;
import java.util.logging.Logger;
import java.util.logging.Level;

/**
 *
 * @author Karla
 */
@Named(value = "validarpagoincidenciasMB")
@ViewAccessScoped
public class ValidarPagoIncidenciasMB implements Serializable {
    
    private List<IncidenciasQuincenaDTO> listaIncidenciasValidar;
    private List<IncidenciasQuincenaDTO> listaIncidenciasQuincena;
    private IncidenciasQuincenaDTO incidenciaSeleccionada;
    private Tsgnomquincena quincenaActual;
    private String desQuincenaActual;
    private SimpleDateFormat format;
    private String comentarios;
    
    private Tsgrhempleados empleadoLogeado;
    private Usuario usuario;
    private Tsgnomempleados empleadoNom;
    
    @PostConstruct
    public void iniciarVariables() {
        this.setEmpleadoLogeado((Tsgrhempleados) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("empleado"));
        this.usuario = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        setEmpleadoNom(EmpleadosNomWSClient.obtenerEmpleadonomPorIdrh(getEmpleadoLogeado().getCodEmpleado()).getEmpleado());
        setListaIncidenciasValidar(new ArrayList<>());
        setListaIncidenciasQuincena(new ArrayList<>());
        setQuincenaActual(QuincenasWSClient.quincenaActual().getQuincena());
        this.format = new SimpleDateFormat("dd/MM/yyyy");
        setDesQuincenaActual("del " +format.format(getQuincenaActual().getFecInicio())+ " al " +format.format(getQuincenaActual().getFecFin()));
        setListaIncidenciasQuincena(IncidenciasQuincenaWSClient.listarIncidenciasQuincena());
        this.comentarios = "";
    }
    
    public void dialogAutorizarPagos() {
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('dialogAutorizarPagos').show();");
    }

    public void dialogRechazarPagos() {
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('dialogRechazarPagos').show();");
    }
    
    public void dialogoPosponerPago(IncidenciasQuincenaDTO seleccionado) {
        setComentarios("");
        setIncidenciaSeleccionada(seleccionado);
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('dialogoPosponerPago').show();");
    }
    
    public void aprobarPagos(){
        for(int i = 0; i<getListaIncidenciasQuincena().size(); i++){
            getListaIncidenciasQuincena().get(i).setModifica(getEmpleadoLogeado().getCodEmpleado());//sgrh
        }
        Boolean autorizarPagoGuardar = true;
        for(int i=0; i < getListaIncidenciasQuincena().size(); i++){
            if(getListaIncidenciasQuincena().get(i).getImporte().compareTo(BigDecimal.ZERO) > 0){
                autorizarPagoGuardar = true;
            } else {
                autorizarPagoGuardar = false;
                break;
            }
        }
        IncidenciasQuincenaDTO dtoRespuesta = new IncidenciasQuincenaDTO();
        dtoRespuesta.setListaIncidencias(getListaIncidenciasQuincena());
        if(autorizarPagoGuardar){
            try {
                IncidenciasQuincenaWSClient.autorizarPagoIncidencias(dtoRespuesta);
                generarMensaje("Pagos autorizados", FacesMessage.SEVERITY_INFO);
            } catch (JsonProcessingException ex) {
                Logger.getLogger(IncidenciasQuincenaMB.class.getName()).log(Level.SEVERE, null, ex);
                generarMensaje("Error al autorizar", FacesMessage.SEVERITY_ERROR);
            }
            getListaIncidenciasQuincena().clear();
            setListaIncidenciasQuincena(IncidenciasQuincenaWSClient.listarIncidenciasQuincena());
        }else{
            generarMensaje("No puede autorizar incidencias sin monto asignado.\nPor favor actualice el importe de todas las incidencias antes de autorizar.", FacesMessage.SEVERITY_INFO);
        }
    }

    public void denegarPagos() {
        for(int i = 0; i<getListaIncidenciasQuincena().size(); i++){
            getListaIncidenciasQuincena().get(i).setModifica(getEmpleadoLogeado().getCodEmpleado());//sgrh
        }
        IncidenciasQuincenaDTO dtoRespuesta = new IncidenciasQuincenaDTO();
        dtoRespuesta.setListaIncidencias(getListaIncidenciasQuincena());
        try {
            IncidenciasQuincenaWSClient.denegarPagoIncidencias(dtoRespuesta);
            generarMensaje("Pagos denegados.", FacesMessage.SEVERITY_INFO);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(IncidenciasQuincenaMB.class.getName()).log(Level.SEVERE, null, ex);
            generarMensaje("Error al denegar.", FacesMessage.SEVERITY_ERROR);
        }
        getListaIncidenciasQuincena().clear();
        setListaIncidenciasQuincena(IncidenciasQuincenaWSClient.listarIncidenciasQuincena());
    }

    public void autorizarPagoIncidencia(Boolean bandera, int index) {
        getListaIncidenciasQuincena().get(index).setModifica(getEmpleadoLogeado().getCodEmpleado());//sgrh
        setListaIncidenciasValidar(getListaIncidenciasQuincena());
        if(bandera){
            if(getListaIncidenciasValidar().get(index).getImporte().compareTo(BigDecimal.ZERO)> 0){
                getListaIncidenciasValidar().get(index).setAutpago(bandera);
                getListaIncidenciasQuincena().get(index).setAutpago(bandera);
            }else{
                generarMensaje("No puede autorizar una incidencia sin importe asignado.", FacesMessage.SEVERITY_INFO);
            }
        }else{
            getListaIncidenciasValidar().get(index).setAutpago(bandera);
            getListaIncidenciasQuincena().get(index).setAutpago(bandera);
        }
    }
    
    public void autorizarPagosIncidencias(){
        IncidenciasQuincenaDTO dtoRespuesta = new IncidenciasQuincenaDTO();
        Boolean autorizarPagoGuardar = true;
        
        for(int i=0; i < getListaIncidenciasQuincena().size(); i++){
            if(getListaIncidenciasQuincena().get(i).getAutpago()!= null){
                autorizarPagoGuardar = true;
            } else {
                autorizarPagoGuardar = false;
                break;
            }
        }
        if(autorizarPagoGuardar){
            dtoRespuesta.setListaIncidencias(getListaIncidenciasQuincena());
            try {
                IncidenciasQuincenaWSClient.autorizarPagosIncidencias(dtoRespuesta);
                generarMensaje("Se han guardado los datos.", FacesMessage.SEVERITY_INFO);
            } catch (JsonProcessingException ex) {
                Logger.getLogger(IncidenciasQuincenaMB.class.getName()).log(Level.SEVERE, null, ex);
                generarMensaje("Error al guardar incidencias.", FacesMessage.SEVERITY_ERROR);
            }
            getListaIncidenciasQuincena().clear();
            setListaIncidenciasQuincena(IncidenciasQuincenaWSClient.listarIncidenciasQuincena());
        } else {
            generarMensaje("Por favor actualice el estatus de todas las incidencias antes de guardar.", FacesMessage.SEVERITY_INFO);
        }
    }
    
    public void posponerPagoIncidencia(){
        if(getComentarios().length()>0){
            if(IncidenciasQuincenaWSClient.posponerPagoIncidencia(getIncidenciaSeleccionada().getIdincidencia(), getComentarios(), getEmpleadoLogeado().getCodEmpleado())){
                generarMensaje("Pago de incidencia pospuesto con éxito.", FacesMessage.SEVERITY_INFO);
            } else {
                generarMensaje("No se pudo posponer el pago.", FacesMessage.SEVERITY_ERROR);
            }
            RequestContext context = RequestContext.getCurrentInstance();
            context.execute("PF('dialogoPosponerPago').hide();");
            setListaIncidenciasQuincena(IncidenciasQuincenaWSClient.listarIncidenciasQuincena());
        }else{
            generarMensaje("Por favor agregue un comentario.", FacesMessage.SEVERITY_ERROR);
        }
    }

    //Mensajes
    public void generarMensaje(String mensaje, FacesMessage.Severity sever) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(sever, "Mensaje: ", mensaje));
    }
    
    //Getters y Setters
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

    public List<IncidenciasQuincenaDTO> getListaIncidenciasValidar() {
        return listaIncidenciasValidar;
    }

    public void setListaIncidenciasValidar(List<IncidenciasQuincenaDTO> listaIncidenciasValidar) {
        this.listaIncidenciasValidar = listaIncidenciasValidar;
    }

    public List<IncidenciasQuincenaDTO> getListaIncidenciasQuincena() {
        return listaIncidenciasQuincena;
    }

    public void setListaIncidenciasQuincena(List<IncidenciasQuincenaDTO> listaIncidenciasQuincena) {
        this.listaIncidenciasQuincena = listaIncidenciasQuincena;
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

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public IncidenciasQuincenaDTO getIncidenciaSeleccionada() {
        return incidenciaSeleccionada;
    }

    public void setIncidenciaSeleccionada(IncidenciasQuincenaDTO incidenciaSeleccionada) {
        this.incidenciaSeleccionada = incidenciaSeleccionada;
    }
    
}
