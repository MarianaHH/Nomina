/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.web.mb;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mbn.sinod.model.dto.QuincenasDTO;
import com.mbn.sinod.model.entidades.Tsgnomejercicio;
import com.mbn.sinod.model.entidades.Tsgnomquincena;
import com.mbn.sinod.web.client.EjercicioFiscalWSClient;
import com.mbn.sinod.web.client.QuincenasWSClient;
import com.mbn.sinod.web.util.ResourceBundles;
import com.mbn.sinod.web.util.StaticsConstants;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
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
 * @author mipe
 */
@Named(value = "calendarioMB")
@ViewAccessScoped
public class CalendarioMB implements Serializable {

    private static final ResourceBundle BUNDLE = ResourceBundle.getBundle(ResourceBundles.MESSAGES.getBundleName());
    private String titulo;
    private List<Tsgnomquincena> listaQuincenas;
    private Tsgnomquincena calendarioSeleccionado;
    private List<Tsgnomejercicio> listaEjercicios;
    private Date fechaInicial;
    private Boolean disable;
    private Boolean active;

    @PostConstruct
    public void iniciarVariables() {
        listaQuincenas = new ArrayList();
        setTitulo("");
        setListaQuincenas(QuincenasWSClient.listarQuincenas());
        setListaEjercicios(EjercicioFiscalWSClient.listarEjercicioFiscal());

    }

    public void dialogoCrearConfig() throws ParseException {

        setTitulo("Nueva");
        setCalendarioSeleccionado(new Tsgnomquincena());
        getCalendarioSeleccionado().setBolEstatus(true);
        Calendar c = Calendar.getInstance();

// this takes current date
        System.out.println("Dia " + c.get(Calendar.DAY_OF_YEAR));
        System.out.println("Dia mes " + Calendar.DAY_OF_MONTH);
        System.out.println("Dia semana " + Calendar.DAY_OF_WEEK);
        System.out.println("Dia semana mes " + Calendar.DAY_OF_WEEK_IN_MONTH);
        //inicio de mes
        if (c.get(Calendar.DAY_OF_MONTH) <= 15) {
            c.set(Calendar.DAY_OF_MONTH, c.getActualMinimum(Calendar.DAY_OF_MONTH));

            System.out.println(c.getTime());
            getCalendarioSeleccionado().setFecInicio(c.getTime());

            System.out.println("IF Inic : " + calendarioSeleccionado.getFecInicio());

            c.set(Calendar.DAY_OF_MONTH, c.getActualMinimum(Calendar.DAY_OF_MONTH) + 14);
            getCalendarioSeleccionado().setFecFin(c.getTime());

            System.out.println("IF Fin : " + calendarioSeleccionado.getFecFin());

        } else {    //fin de mes
            c.set(Calendar.DAY_OF_MONTH, c.getActualMinimum(Calendar.DAY_OF_MONTH) + 15);
            getCalendarioSeleccionado().setFecInicio(c.getTime());
            c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
            getCalendarioSeleccionado().setFecFin(c.getTime());
            System.out.println("ELSE Inic : " + calendarioSeleccionado.getFecInicio());
            System.out.println("ELSE Fin : " + calendarioSeleccionado.getFecFin());
        }

        RequestContext context = RequestContext.getCurrentInstance();
        if (verificarFechaInicio()) {
            setActive(true);
            setDisable(true);
        } else {
            setActive(false);
            setDisable(false);
        }
        context.execute("PF('dlgCalen').show();");

    }

    public boolean verificarFechaInicio() throws ParseException {
        for (int i = 0; i < getListaQuincenas().size(); i++) {
            System.out.println("Lista: " + getListaQuincenas().get(i).getFecInicio().toString().substring(0, 10));
            System.out.println("seleccionado: " + getCalendarioSeleccionado().getFecInicio().toString().substring(0, 10));

            if (getListaQuincenas().get(i).getFecInicio().toString().substring(0, 10)
                    .equals(getCalendarioSeleccionado().getFecInicio().toString().substring(0, 10))) {
                System.out.println("Se bloquea el boton");
                //si la fecha de inicio ya existe
                return true;
            }
        }
        return false;
    }

    public void guardarQuincena() {

        try {
            QuincenasDTO dtoRespuesta = new QuincenasDTO();
            getCalendarioSeleccionado().setDesQuincena(getCalendarioSeleccionado().getDesQuincena().toUpperCase());
            dtoRespuesta.setQuincena(getCalendarioSeleccionado());
            QuincenasWSClient.guardarQuincena(dtoRespuesta);
            generarMensaje(BUNDLE.getString(StaticsConstants.EXITO_GUARDADO), FacesMessage.SEVERITY_INFO);
            RequestContext context = RequestContext.getCurrentInstance();
            context.execute("PF('dlgCalen').hide();");
            //generarMensaje(BUNDLE.getString(StaticsConstants.EXITO_GUARDADO), FacesMessage.SEVERITY_INFO);
            getListaQuincenas().clear();
            setListaQuincenas(QuincenasWSClient.listarQuincenas());

        } catch (JsonProcessingException ex) {
            Logger.getLogger(CalendarioMB.class.getName()).log(Level.SEVERE, null, ex);
            generarMensaje(BUNDLE.getString(StaticsConstants.ERROR_GUARDADO), FacesMessage.SEVERITY_ERROR);
        } catch (Exception e) {
            Logger.getLogger(CalendarioMB.class.getName()).log(Level.SEVERE, null, e);
            generarMensaje(BUNDLE.getString(StaticsConstants.ERROR_CAMPOS_VACIOS), FacesMessage.SEVERITY_WARN);
        }

    }

    public void generarMensaje(String mensaje, FacesMessage.Severity sever) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(sever, "Mensaje: ", mensaje));
    }

    public List<Tsgnomquincena> getListaQuincenas() {
        return listaQuincenas;
    }

    public void setListaQuincenas(List<Tsgnomquincena> listaQuincenas) {
        this.listaQuincenas = listaQuincenas;
    }

    /**
     * @return the calendarioSeleccionado
     */
    public Tsgnomquincena getCalendarioSeleccionado() {
        return calendarioSeleccionado;
    }

    /**
     * @param calendarioSeleccionado the calendarioSeleccionado to set
     */
    public void setCalendarioSeleccionado(Tsgnomquincena calendarioSeleccionado) {
        this.calendarioSeleccionado = calendarioSeleccionado;
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
     * @return the listaEjercicios
     */
    public List<Tsgnomejercicio> getListaEjercicios() {
        return listaEjercicios;
    }

    /**
     * @param listaEjercicios the listaEjercicios to set
     */
    public void setListaEjercicios(List<Tsgnomejercicio> listaEjercicios) {
        this.listaEjercicios = listaEjercicios;
    }

    /**
     * @return the fechaInicial
     */
    public Date getFechaInicial() {
        return fechaInicial;
    }

    /**
     * @param fechaInicial the fechaInicial to set
     */
    public void setFechaInicial(Date fechaInicial) {
        this.fechaInicial = fechaInicial;
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

}
