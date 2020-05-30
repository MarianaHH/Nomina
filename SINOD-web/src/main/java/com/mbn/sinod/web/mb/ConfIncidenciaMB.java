/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.web.mb;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mbn.sinod.model.dto.CatIncidenciaDTO;
import com.mbn.sinod.model.entidades.Tsgnomcatincidencia;
import com.mbn.sinod.web.client.CatIncidenciaWSClient;
import com.mbn.sinod.web.util.ResourceBundles;
import com.mbn.sinod.web.util.StaticsConstants;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
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
 * @author Ambrosio Muñoz Flores
 */
@Named(value = "confIncidenciaMB")
@ViewAccessScoped
public class ConfIncidenciaMB implements Serializable {

    private static final ResourceBundle BUNDLE = ResourceBundle.getBundle(ResourceBundles.MESSAGES.getBundleName());
    private String titulo;
    private Boolean disable;
    private Boolean active;
    private List<Tsgnomcatincidencia> listaCatIncidencias;
    private Tsgnomcatincidencia catIncidenciaSeleccionado;
    private Boolean claveEditar;

    @PostConstruct
    public void iniciarVariables() {
        listaCatIncidencias = new ArrayList();
        setCatIncidenciaSeleccionado(new Tsgnomcatincidencia());
        titulo = "";
//        setActive(true); 
//        setDisable(true);
        setListaCatIncidencias(CatIncidenciaWSClient.listarCatIncidencias());
    }

    public void dialogoCrearConfig() {
        setClaveEditar(false);
        setTitulo("Nueva");
        setCatIncidenciaSeleccionado(new Tsgnomcatincidencia());
        catIncidenciaSeleccionado.setBolEstatus(true);
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('detalleConfIncidencia').show();");
    }

    public void dialogoEditarConfig(Tsgnomcatincidencia catIncidencia) {
        setClaveEditar(true);
        setTitulo("Modificar");
        setCatIncidenciaSeleccionado(catIncidencia);
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('detalleConfIncidencia').show();");
    }

    public void dialogoEliminar(Tsgnomcatincidencia catIncidencia) {
        setCatIncidenciaSeleccionado(catIncidencia);
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('eliminarConfIncidencia').show();");
    }

    public void comparar() {
        for (int i = 0; i < getListaCatIncidencias().size(); i++) {
            if (getListaCatIncidencias().get(i).getCodClaveincidencia().toUpperCase().equals(getCatIncidenciaSeleccionado().getCodClaveincidencia().toUpperCase())) {
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

    public void guardar() {
        try {
            CatIncidenciaDTO dtoRespuesta = new CatIncidenciaDTO();
            if (!getCatIncidenciaSeleccionado().getCodClaveincidencia().isEmpty()) {
                getCatIncidenciaSeleccionado().setCodClaveincidencia(getCatIncidenciaSeleccionado().getCodClaveincidencia().toUpperCase());
            } else {
                getCatIncidenciaSeleccionado().setCodClaveincidencia(null);
            }
            if (!getCatIncidenciaSeleccionado().getCodNbincidencia().isEmpty()) {
                getCatIncidenciaSeleccionado().setCodNbincidencia(getCatIncidenciaSeleccionado().getCodNbincidencia().toUpperCase());
            } else {
                getCatIncidenciaSeleccionado().setCodNbincidencia(null);
            }
            System.out.println("gdfg " + getCatIncidenciaSeleccionado().getImpMonto());
            if (getCatIncidenciaSeleccionado().getImpMonto() == null) {
                getCatIncidenciaSeleccionado().setImpMonto(BigDecimal.ZERO);
            }
            dtoRespuesta.setCatIncidencia(getCatIncidenciaSeleccionado());
            CatIncidenciaWSClient.guardarActualizarCatInci(dtoRespuesta);
            getListaCatIncidencias().clear();
            setListaCatIncidencias(CatIncidenciaWSClient.listarCatIncidencias());
            generarMensaje(BUNDLE.getString(StaticsConstants.EXITO_GUARDADO), FacesMessage.SEVERITY_INFO);
            RequestContext context = RequestContext.getCurrentInstance();
            context.execute("PF('detalleConfIncidencia').hide();");

        } catch (JsonProcessingException ex) {
            Logger.getLogger(ConfIncidenciaMB.class.getName()).log(Level.SEVERE, null, ex);
            generarMensaje(BUNDLE.getString(StaticsConstants.ERROR_GUARDADO), FacesMessage.SEVERITY_ERROR);
        } catch (Exception e) {
            Logger.getLogger(ConfIncidenciaMB.class.getName()).log(Level.SEVERE, null, e);
            generarMensaje(BUNDLE.getString(StaticsConstants.ERROR_CAMPOS_VACIOS), FacesMessage.SEVERITY_WARN);
        }
    }

    public void eliminar() {
        try {
            CatIncidenciaWSClient.eliminarCatIncidenciasId(getCatIncidenciaSeleccionado().getCodCatincidenciaid());
            setListaCatIncidencias(CatIncidenciaWSClient.listarCatIncidencias());
            generarMensaje(BUNDLE.getString(StaticsConstants.EXITO_ELIMINAR), FacesMessage.SEVERITY_INFO);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(ConfIncidenciaMB.class.getName()).log(Level.SEVERE, null, ex);
            generarMensaje(BUNDLE.getString(StaticsConstants.ERROR_ELIMINAR), FacesMessage.SEVERITY_ERROR);
        }
    }

    public void limpiar() {
        getCatIncidenciaSeleccionado().setCodClaveincidencia("");
        getCatIncidenciaSeleccionado().setCodNbincidencia("");

    }

    public void generarMensaje(String mensaje, FacesMessage.Severity sever) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(sever, "Mensaje: ", mensaje));
    }

    public void cerrarDialogo() {
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('detalleConfIncidencia').hide();");
        setListaCatIncidencias(CatIncidenciaWSClient.listarCatIncidencias());
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the listaCatIncidencias
     */
    public List<Tsgnomcatincidencia> getListaCatIncidencias() {
        return listaCatIncidencias;
    }

    /**
     * @param listaCatIncidencias the listaCatIncidencias to set
     */
    public void setListaCatIncidencias(List<Tsgnomcatincidencia> listaCatIncidencias) {
        this.listaCatIncidencias = listaCatIncidencias;
    }

    /**
     * @return the catIncidenciaSeleccionado
     */
    public Tsgnomcatincidencia getCatIncidenciaSeleccionado() {
        return catIncidenciaSeleccionado;
    }

    /**
     * @param catIncidenciaSeleccionado the catIncidenciaSeleccionado to set
     */
    public void setCatIncidenciaSeleccionado(Tsgnomcatincidencia catIncidenciaSeleccionado) {
        this.catIncidenciaSeleccionado = catIncidenciaSeleccionado;
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
     * @return the claveEditar
     */
    public Boolean getClaveEditar() {
        return claveEditar;
    }

    /**
     * @param claveEditar the claveEditar to set
     */
    public void setClaveEditar(Boolean claveEditar) {
        this.claveEditar = claveEditar;
    }
}
