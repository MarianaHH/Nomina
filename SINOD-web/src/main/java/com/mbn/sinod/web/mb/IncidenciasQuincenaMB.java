/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.web.mb;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mbn.sinod.model.dto.CorreoDTO;
import com.mbn.sinod.model.dto.IncidenciasQuincenaDTO;
import com.mbn.sinod.model.entidades.Tsgnomempleados;
import com.mbn.sinod.model.entidades.Tsgnomquincena;
import com.mbn.sinod.model.entidades.Tsgrhempleados;
import com.mbn.sinod.model.entidades.Usuario;
import com.mbn.sinod.web.client.EmpleadosNomWSClient;
import com.mbn.sinod.web.client.EnviarCorreoWSClient;
import com.mbn.sinod.web.client.IncidenciasQuincenaWSClient;
import com.mbn.sinod.web.client.QuincenasWSClient;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.apache.deltaspike.core.api.scope.ViewAccessScoped;
import org.primefaces.context.RequestContext;
import java.util.logging.Logger;

/**
 *
 * @author mariana
 */
@Named(value = "incidenciasQuincenaMB")
@ViewAccessScoped
public class IncidenciasQuincenaMB implements Serializable {

    private List<IncidenciasQuincenaDTO> listaIncidenciasQuincena;
    private IncidenciasQuincenaDTO incidenciaSeleccionada;
    private Boolean validar;
    private List<IncidenciasQuincenaDTO> listaIncidenciasValidar;
    private List<CorreoDTO> listaCorreos;
    private List<IncidenciasQuincenaDTO> lista;
    private Tsgnomquincena quincenaActual;
    private String desQuincenaActual;
    private SimpleDateFormat format;
    private String nompantalla;
    private char accion;
    
    private Tsgrhempleados empleadoLogeado;
    private Usuario usuario;
    private Tsgnomempleados empleadoNom;

    @PostConstruct
    public void iniciarVariables() {
        setListaIncidenciasValidar(new ArrayList<>());
        setListaIncidenciasQuincena(new ArrayList<>());
        setValidar(true);
        this.setEmpleadoLogeado((Tsgrhempleados) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("empleado"));
        this.usuario = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        switch(getUsuario().getCod_rol()){
            case 1: setAccion('v'); setNompantalla("Validar incidencias");
                    setListaIncidenciasQuincena(IncidenciasQuincenaWSClient.listarIncidenciasQuincena());
                break;
            case 2: 
            case 4: setAccion('a'); setNompantalla("Autorizar incidencias");
                    setListaIncidenciasQuincena(IncidenciasQuincenaWSClient.incidenciasQuincenaPorArea(getEmpleadoLogeado().getCodPuesto().getCodArea().getCodArea()));
                break;
            default : generarMensaje("No tiene permiso para acceder a la información", FacesMessage.SEVERITY_ERROR);
                break;
        }
        setEmpleadoNom(EmpleadosNomWSClient.obtenerEmpleadonomPorIdrh(getEmpleadoLogeado().getCodEmpleado()).getEmpleado());
        setQuincenaActual(QuincenasWSClient.quincenaActual().getQuincena());
        this.format  = new SimpleDateFormat("dd/MM/yyyy");
        setDesQuincenaActual("Del " +format.format(getQuincenaActual().getFecInicio())+ " al " +format.format(getQuincenaActual().getFecFin()));
    }

    public void verDetalleIncidencia(IncidenciasQuincenaDTO seleccionado) {
        setIncidenciaSeleccionada(seleccionado);
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('detalleIncidencia').show();");
    }

    public void dialogoValidarIncidencias() {
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('dialogValidarIncidencias').show();");
    }

    public void dialogoRechazarIncidencias() {
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('dialogRechazarIncidencias').show();");
    }

    public void validarTodas() throws JsonProcessingException {
        for(int i = 0; i<getListaIncidenciasQuincena().size(); i++){
            getListaIncidenciasQuincena().get(i).setAutoriza(getEmpleadoNom().getCodEmpleadoid());//sgnom
            getListaIncidenciasQuincena().get(i).setModifica(getEmpleadoLogeado().getCodEmpleado());//sgrh
        }
        Boolean validarTodas = true;
        for(int i=0; i < getListaIncidenciasQuincena().size(); i++){
            if(getListaIncidenciasQuincena().get(i).getImporte().compareTo(BigDecimal.ZERO) > 0){
                validarTodas = true;
            } else {
                validarTodas = false;
                break;
            }
        }
        IncidenciasQuincenaDTO dtoRespuesta = new IncidenciasQuincenaDTO();
        dtoRespuesta.setListaIncidencias(getListaIncidenciasQuincena());
        if(validarTodas){
            try {
                IncidenciasQuincenaWSClient.validarTodas(dtoRespuesta);
                generarMensaje("Incidencias validadas", FacesMessage.SEVERITY_INFO);
            } catch (JsonProcessingException ex) {
                Logger.getLogger(IncidenciasQuincenaMB.class.getName()).log(Level.SEVERE, null, ex);
                generarMensaje("Error al validar", FacesMessage.SEVERITY_ERROR);
            }
        getListaIncidenciasQuincena().clear();
        setListaIncidenciasQuincena(IncidenciasQuincenaWSClient.listarIncidenciasQuincena());
        }else{
            generarMensaje("No puede autorizar incidencias sin monto asignado.\nPor favor actualice el importe de todas las incidencias antes de autorizar.", FacesMessage.SEVERITY_INFO);
        }
    }

    public void rechazarTodas() {
        for(int i = 0; i<getListaIncidenciasQuincena().size(); i++){
            getListaIncidenciasQuincena().get(i).setAutoriza(getEmpleadoNom().getCodEmpleadoid());//sgnom
            getListaIncidenciasQuincena().get(i).setModifica(getEmpleadoLogeado().getCodEmpleado());//sgrh
        }
        IncidenciasQuincenaDTO dtoRespuesta = new IncidenciasQuincenaDTO();
        dtoRespuesta.setListaIncidencias(getListaIncidenciasQuincena());
        try {
            IncidenciasQuincenaWSClient.rechazarTodas(dtoRespuesta);
            generarMensaje("Incidencias rechazadas.", FacesMessage.SEVERITY_INFO);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(IncidenciasQuincenaMB.class.getName()).log(Level.SEVERE, null, ex);
            generarMensaje("Error al rechazar.", FacesMessage.SEVERITY_ERROR);
        }
        getListaIncidenciasQuincena().clear();
        setListaIncidenciasQuincena(IncidenciasQuincenaWSClient.listarIncidenciasQuincena());
    }

    public void validarIncidencias(int bandera, int index, char accion) {
        getListaIncidenciasQuincena().get(index).setAutoriza(getEmpleadoNom().getCodEmpleadoid());//sgnom
        getListaIncidenciasQuincena().get(index).setModifica(getEmpleadoLogeado().getCodEmpleado());//sgrh
        setListaIncidenciasValidar(getListaIncidenciasQuincena());
        if (bandera == 0 && accion == 'v') {
            getListaIncidenciasValidar().get(index).setValidacion(true);
            getListaIncidenciasQuincena().get(index).setValidacion(true); 
        } else if (bandera == 1 && accion == 'v') {
            getListaIncidenciasValidar().get(index).setValidacion(false);
            getListaIncidenciasQuincena().get(index).setValidacion(false);
        } else if(bandera == 0 && accion == 'a'){
            if(getListaIncidenciasValidar().get(index).getImporte().compareTo(BigDecimal.ZERO)> 0){
                getListaIncidenciasValidar().get(index).setAceptacion(true); 
                getListaIncidenciasQuincena().get(index).setAceptacion(true);
            }else{
                generarMensaje("No puede autorizar una incidencia sin importe asignado.", FacesMessage.SEVERITY_INFO);
            }
        }else if(bandera == 1 && accion == 'a'){
            getListaIncidenciasValidar().get(index).setAceptacion(false);
            getListaIncidenciasQuincena().get(index).setAceptacion(false);
        }else{
            System.out.println("ERROR VALIDAR INCIDENCIAS MB: asignación de validación");
        }
    }

    public void enviarCorrreos() {
        try {
            IncidenciasQuincenaDTO dtoRespuesta = new IncidenciasQuincenaDTO();
            dtoRespuesta.setListaIncidencias(getListaIncidenciasQuincena());
            EnviarCorreoWSClient.enviarCorreos(dtoRespuesta);
            generarMensaje("Los correos han sido enviados", FacesMessage.SEVERITY_INFO);

        } catch (JsonProcessingException ex) {
            generarMensaje("Error al enviar los correos", FacesMessage.SEVERITY_ERROR);
        }

    }

    public void guardarIncidencias() {
        IncidenciasQuincenaDTO dtoRespuesta = new IncidenciasQuincenaDTO();
        Boolean validarGuardar = true;
        Boolean autorizarGuardar = true;
        
        switch (getAccion()) {
            case 'v': for(int i=0; i < getListaIncidenciasQuincena().size(); i++){
                        if(getListaIncidenciasQuincena().get(i).getValidacion()!= null){
                            validarGuardar = true;
                        } else {
                            validarGuardar = false;
                            break;
                        }
                    }
                    if(validarGuardar){
                        dtoRespuesta.setListaIncidencias(getListaIncidenciasQuincena());
                        try {
                            IncidenciasQuincenaWSClient.validarIncidencias(dtoRespuesta);
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
                break;
            case 'a': for(int i=0; i < getListaIncidenciasQuincena().size(); i++){
                        if(getListaIncidenciasQuincena().get(i).getAceptacion()!= null){
                            autorizarGuardar = true;
                        } else {
                            autorizarGuardar = false;
                            break;
                        }
                    }
                    if(autorizarGuardar){
                        dtoRespuesta.setListaIncidencias(getListaIncidenciasQuincena());
                        try {
                            IncidenciasQuincenaWSClient.autorizarIncidencias(dtoRespuesta);
                            generarMensaje("Se han guardado los datos.", FacesMessage.SEVERITY_INFO);
                        } catch (JsonProcessingException ex) {
                            Logger.getLogger(IncidenciasQuincenaMB.class.getName()).log(Level.SEVERE, null, ex);
                            generarMensaje("Error al guardar incidencias.", FacesMessage.SEVERITY_ERROR);
                        }
                        getListaIncidenciasQuincena().clear();
                        setListaIncidenciasQuincena(IncidenciasQuincenaWSClient.incidenciasQuincenaPorArea(getEmpleadoLogeado().getCodPuesto().getCodArea().getCodArea()));
                    } else {
                        generarMensaje("Por favor actualice el estatus de todas las incidencias antes de guardar.", FacesMessage.SEVERITY_INFO);
                    }
                break;
            default:
                generarMensaje("Error al guardar.", FacesMessage.SEVERITY_FATAL);
                break;
        }
    }
    
    public void autorizarTodas() throws JsonProcessingException {
        for(int i = 0; i<getListaIncidenciasQuincena().size(); i++){
            getListaIncidenciasQuincena().get(i).setModifica(getEmpleadoLogeado().getCodEmpleado());//sgrh
        }
        Boolean autorizarTodas = true;
        for(int i=0; i < getListaIncidenciasQuincena().size(); i++){
            if(getListaIncidenciasQuincena().get(i).getImporte().compareTo(BigDecimal.ZERO) > 0){
                autorizarTodas = true;
            } else {
                autorizarTodas = false;
                break;
            }
        }
        IncidenciasQuincenaDTO dtoRespuesta = new IncidenciasQuincenaDTO();
        dtoRespuesta.setListaIncidencias(getListaIncidenciasQuincena());
        if(autorizarTodas){
            try {
                IncidenciasQuincenaWSClient.autorizarTodas(dtoRespuesta);
                generarMensaje("Incidencias autorizadas.", FacesMessage.SEVERITY_INFO);
            } catch (JsonProcessingException ex) {
                Logger.getLogger(IncidenciasQuincenaMB.class.getName()).log(Level.SEVERE, null, ex);
                generarMensaje("Error al autorizar", FacesMessage.SEVERITY_ERROR);
            }
            getListaIncidenciasQuincena().clear();
            setListaIncidenciasQuincena(IncidenciasQuincenaWSClient.incidenciasQuincenaPorArea(getEmpleadoLogeado().getCodPuesto().getCodArea().getCodArea()));
        }else{
            generarMensaje("No puede autorizar incidencias sin monto asignado.\nPor favor actualice el importe de todas las incidencias antes de autorizar.", FacesMessage.SEVERITY_INFO);
        }
    }

    public void denegarTodas() {
        for(int i = 0; i<getListaIncidenciasQuincena().size(); i++){
            getListaIncidenciasQuincena().get(i).setModifica(getEmpleadoLogeado().getCodEmpleado());//sgrh
        }
        IncidenciasQuincenaDTO dtoRespuesta = new IncidenciasQuincenaDTO();
        dtoRespuesta.setListaIncidencias(getListaIncidenciasQuincena());
        try {
            IncidenciasQuincenaWSClient.denegarTodas(dtoRespuesta);
            generarMensaje("Incidencias denegadas.", FacesMessage.SEVERITY_INFO);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(IncidenciasQuincenaMB.class.getName()).log(Level.SEVERE, null, ex);
            generarMensaje("Error al denegar", FacesMessage.SEVERITY_ERROR);
        }
        getListaIncidenciasQuincena().clear();
        setListaIncidenciasQuincena(IncidenciasQuincenaWSClient.incidenciasQuincenaPorArea(getEmpleadoLogeado().getCodPuesto().getCodArea().getCodArea()));
    }

    public void generarMensaje(String mensaje, FacesMessage.Severity sever) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(sever, "Mensaje: ", mensaje));
    }

    public List<IncidenciasQuincenaDTO> getListaIncidenciasQuincena() {
        return listaIncidenciasQuincena;
    }

    public void setListaIncidenciasQuincena(List<IncidenciasQuincenaDTO> listaIncidenciasQuincena) {
        this.listaIncidenciasQuincena = listaIncidenciasQuincena;
    }

    public IncidenciasQuincenaDTO getIncidenciaSeleccionada() {
        return incidenciaSeleccionada;
    }

    public void setIncidenciaSeleccionada(IncidenciasQuincenaDTO incidenciaSeleccionada) {
        this.incidenciaSeleccionada = incidenciaSeleccionada;
    }

    public Boolean getValidar() {
        return validar;
    }

    public void setValidar(Boolean validar) {
        this.validar = validar;
    }

    public List<IncidenciasQuincenaDTO> getListaIncidenciasValidar() {
        return listaIncidenciasValidar;
    }

    public void setListaIncidenciasValidar(List<IncidenciasQuincenaDTO> listaIncidenciasValidar) {
        this.listaIncidenciasValidar = listaIncidenciasValidar;
    }

    public List<CorreoDTO> getListaCorreos() {
        return listaCorreos;
    }

    public void setListaCorreos(List<CorreoDTO> listaCorreos) {
        this.listaCorreos = listaCorreos;
    }

    public List<IncidenciasQuincenaDTO> getLista() {
        return lista;
    }

    public void setLista(List<IncidenciasQuincenaDTO> lista) {
        this.lista = lista;
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

    public char getAccion() {
        return accion;
    }

    public void setAccion(char accion) {
        this.accion = accion;
    }

    public Tsgnomempleados getEmpleadoNom() {
        return empleadoNom;
    }

    public void setEmpleadoNom(Tsgnomempleados empleadoNom) {
        this.empleadoNom = empleadoNom;
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

    public String getNompantalla() {
        return nompantalla;
    }

    public void setNompantalla(String nompantalla) {
        this.nompantalla = nompantalla;
    }
    
}
