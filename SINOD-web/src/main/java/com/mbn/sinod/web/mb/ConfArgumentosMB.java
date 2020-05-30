/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.web.mb;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mbn.sinod.model.dto.ArgumentoDTO;
import com.mbn.sinod.model.entidades.Tsgnomargumento;
import com.mbn.sinod.model.entidades.Tsgnomfuncion;
import com.mbn.sinod.model.entidades.Tsgrhempleados;
import com.mbn.sinod.web.client.ArgumentoWSClient;
import com.mbn.sinod.web.client.FuncionWSClient;
import com.mbn.sinod.web.util.ResourceBundles;
import com.mbn.sinod.web.util.StaticsConstants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.apache.deltaspike.core.api.scope.ViewAccessScoped;
import org.primefaces.context.RequestContext;

/**
 *
 * @author mariana
 */
@Named(value = "confArgumentosMB")
@ViewAccessScoped
public class ConfArgumentosMB implements Serializable {

    private static final ResourceBundle BUNDLE = ResourceBundle.getBundle(ResourceBundles.MESSAGES.getBundleName());
    private String clave;
    private String descripcion;
    private String titulo;
    private Boolean disable;
    private Boolean active;
    private Tsgnomargumento argumentoSeleccionado;
    private List<Tsgnomargumento> listaArgumentos;
    private List<ArgumentoDTO> listaArgumentosDTO;
    private List<Tsgnomfuncion> listaFunciones;
    private String mensaje;
    private Boolean boton;
    private Integer tipoArgumento;
    private Boolean tipoArgu;
    private Tsgrhempleados empleado;
    private Boolean claveEditar;

    @PostConstruct
    public void iniciarVariables() {
        this.setEmpleado((Tsgrhempleados) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("empleado"));
        listaFunciones = new ArrayList<>();
        setListaArgumentos(ArgumentoWSClient.listarArgumentos());
        setListaFunciones(FuncionWSClient.listarFunciones());

    }

    public void eliminarArgumento() throws JsonProcessingException {
        ArgumentoWSClient.eliminarArgumento(getArgumentoSeleccionado().getCodArgumentoid());
        setListaArgumentos(ArgumentoWSClient.listarArgumentos());
        generarMensaje(BUNDLE.getString(StaticsConstants.EXITO_ELIMINAR), FacesMessage.SEVERITY_INFO);
    }

    public void guardar() throws JsonProcessingException {
        try {
            ArgumentoDTO dtoRespuesta = new ArgumentoDTO();
            if (getBoton().equals(true)) {
                //si va a crear un nuevo argumento
                getArgumentoSeleccionado().setAudCodcreadopor(getEmpleado().getCodEmpleado());
                getArgumentoSeleccionado().setAudFeccreacion(new Date());
            } else {
                if (getArgumentoSeleccionado().getCodTipoargumento().equals('0')) {
                    getArgumentoSeleccionado().setImpValorconst(null);
                }
                if (getArgumentoSeleccionado().getCodTipoargumento().equals('1')) {
                    getArgumentoSeleccionado().setDesFuncionbd(null);
                }
                getArgumentoSeleccionado().setAudCodmodificadopor(getEmpleado().getCodEmpleado());
                getArgumentoSeleccionado().setAudFecmodificacion(new Date());
            }

            getArgumentoSeleccionado().setBolEstatus(true);
            if (!getArgumentoSeleccionado().getCodNbargumento().isEmpty()) {
                getArgumentoSeleccionado().setCodNbargumento(getArgumentoSeleccionado().getCodNbargumento().toUpperCase());
                getArgumentoSeleccionado().setCodNbargumento(getArgumentoSeleccionado().getCodNbargumento().replace(" ", ""));
            } else {
                getArgumentoSeleccionado().setCodNbargumento(null);
            }
            if (!getArgumentoSeleccionado().getCodClavearg().isEmpty()) {
                getArgumentoSeleccionado().setCodClavearg(getArgumentoSeleccionado().getCodClavearg().toUpperCase());
                getArgumentoSeleccionado().setCodClavearg(getArgumentoSeleccionado().getCodClavearg().replace(" ", ""));
            } else {
                getArgumentoSeleccionado().setCodClavearg(null);
            }
            if (!getArgumentoSeleccionado().getTxtDescripcion().isEmpty()) {
            } else {
                getArgumentoSeleccionado().setTxtDescripcion(null);
            }
            dtoRespuesta.setArgumento(getArgumentoSeleccionado());
            ArgumentoWSClient.guardarArgumento(dtoRespuesta);
            getListaArgumentos().clear();
            setListaArgumentos(ArgumentoWSClient.listarArgumentos());
            generarMensaje(BUNDLE.getString(StaticsConstants.EXITO_GUARDADO), FacesMessage.SEVERITY_INFO);
            RequestContext context = RequestContext.getCurrentInstance();
            context.execute("PF('ArgumentoDialogo').hide();");
        } catch (JsonProcessingException ex) {
            Logger.getLogger(ConfArgumentosMB.class.getName()).log(Level.SEVERE, null, ex);
            generarMensaje(BUNDLE.getString(StaticsConstants.ERROR_GUARDADO), FacesMessage.SEVERITY_ERROR);
        } catch (Exception e) {
            Logger.getLogger(ConfArgumentosMB.class.getName()).log(Level.SEVERE, null, e);
            generarMensaje(BUNDLE.getString(StaticsConstants.ERROR_CAMPOS_VACIOS), FacesMessage.SEVERITY_WARN);
        }
    }

    public void comparar() {
        for (int i = 0; i < getListaArgumentos().size(); i++) {
            if (getListaArgumentos().get(i).getCodClavearg().toUpperCase().equals(getArgumentoSeleccionado().getCodClavearg().toUpperCase())) {
                generarMensaje(BUNDLE.getString(StaticsConstants.ERROR_REPETIDO), FacesMessage.SEVERITY_WARN);
                setActive(true);
                setDisable(true);
                break;
            } else {
                setActive(false);
                setDisable(false);
            }

        }

    }

    public void compararNombre() {
        for (int i = 0; i < getListaArgumentos().size(); i++) {
            if (getListaArgumentos().get(i).getCodNbargumento().toUpperCase().equals(getArgumentoSeleccionado().getCodNbargumento().toUpperCase())) {
                generarMensaje(BUNDLE.getString(StaticsConstants.ERROR_REPETIDO), FacesMessage.SEVERITY_WARN);
                break;
            }
        }
    }

    public void generarMensaje(String mensaje, FacesMessage.Severity sever) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(sever, "Mensaje: ", mensaje));
    }

    public void dialogoCrear() {
        setClaveEditar(false);
        setArgumentoSeleccionado(new Tsgnomargumento());
        setBoton(true);
        setTitulo("Nuevo argumento");
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('ArgumentoDialogo').show();");
    }

    public void dialogoEliminar(Tsgnomargumento argumento) {
        setArgumentoSeleccionado(argumento);
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('dialogEliminar').show();");
    }

    public void dialogoEditar(Tsgnomargumento argumento) {
        setBoton(true);
        setClaveEditar(true);
        setTitulo("Modificar argumento");
        setArgumentoSeleccionado(argumento);
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('ArgumentoDialogo').show();");
        setActive(false);
        setDisable(false);
    }

    public void cerrarDialogo() {
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('ArgumentoDialogo').hide();");
        setListaArgumentos(ArgumentoWSClient.listarArgumentos());
        limpiarDialogo();
    }

    public void limpiarDialogo() {
        setClave("");
        setDescripcion("");
        setTitulo("");
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Tsgnomargumento getArgumentoSeleccionado() {
        return argumentoSeleccionado;
    }

    public void setArgumentoSeleccionado(Tsgnomargumento argumentoSeleccionado) {
        this.argumentoSeleccionado = argumentoSeleccionado;
    }

    public List<Tsgnomargumento> getListaArgumentos() {
        return listaArgumentos;
    }

    public void setListaArgumentos(List<Tsgnomargumento> listaArgumentos) {
        this.listaArgumentos = listaArgumentos;
    }

    public List<ArgumentoDTO> getListaArgumentosDTO() {
        return listaArgumentosDTO;
    }

    public void setListaArgumentosDTO(List<ArgumentoDTO> listaArgumentosDTO) {
        this.listaArgumentosDTO = listaArgumentosDTO;
    }

    public List<Tsgnomfuncion> getListaFunciones() {
        return listaFunciones;
    }

    public void setListaFunciones(List<Tsgnomfuncion> listaFunciones) {
        this.listaFunciones = listaFunciones;
    }

    public Boolean getBoton() {
        return boton;
    }

    public void setBoton(Boolean boton) {
        this.boton = boton;
    }

    public Integer getTipoArgumento() {
        return tipoArgumento;
    }

    public void setTipoArgumento(Integer tipoArgumento) {
        this.tipoArgumento = tipoArgumento;
    }

    public Boolean getTipoArgu() {
        return tipoArgu;
    }

    public void setTipoArgu(Boolean tipoArgu) {
        this.tipoArgu = tipoArgu;
    }

    /**
     * @return the empleado
     */
    public Tsgrhempleados getEmpleado() {
        return empleado;
    }

    /**
     * @param empleado the empleado to set
     */
    public void setEmpleado(Tsgrhempleados empleado) {
        this.empleado = empleado;
    }

    /**
     * @return the disable
     */
    public Boolean getDisable() {
        return disable;
    }

    /**
     * @param disable the disable to set
     */
    public void setDisable(Boolean disable) {
        this.disable = disable;
    }

    /**
     * @return the active
     */
    public Boolean getActive() {
        return active;
    }

    /**
     * @param active the active to set
     */
    public void setActive(Boolean active) {
        this.active = active;
    }

    /**
     * @return the claveArgumento
     */
    public Boolean getClaveEditar() {
        return claveEditar;
    }

    /**
     * @param claveArgumento the claveArgumento to set
     */
    public void setClaveEditar(Boolean claveEditar) {
        this.claveEditar = claveEditar;
    }

}
