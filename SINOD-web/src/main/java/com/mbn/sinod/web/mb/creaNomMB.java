/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.web.mb;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mbn.sinod.model.dto.CabeceraDTO;
import com.mbn.sinod.model.entidades.Tsgnomcabecera;
import com.mbn.sinod.model.entidades.Tsgrhempleados;
import com.mbn.sinod.web.client.CabecerasWSClient;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.apache.deltaspike.core.api.scope.ViewAccessScoped;
import org.primefaces.context.RequestContext;

/**
 *
 * @author mipe
 */
//nombre de la clase en minuscula
@Named(value = "creaNomMB")
@ViewAccessScoped
public class creaNomMB implements Serializable {

    private Boolean boton;
    private Tsgrhempleados empleado;
    private List<Tsgnomcabecera> listaCabeceras;
    private Tsgnomcabecera CabeceraSelecionada;
    
    @PostConstruct
    public void iniciarVariables() { 
        this.setEmpleado((Tsgrhempleados) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("empleado"));
        setListaCabeceras(CabecerasWSClient.listaCabecera());
    }
    
    public void dialogoCrear() {
        setBoton(true);
        setCabeceraSelecionada(new Tsgnomcabecera());
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('dlgCrear').show();");
    }
    
    public void guardar() throws JsonProcessingException{
        System.out.println("entra a guardar");
        CabeceraDTO dtoRespuesta = new CabeceraDTO();
        dtoRespuesta.setCabecera(CabeceraSelecionada);
//        CabecerasWSClient.guardarConcepto(dtoRespuesta);
    }
    
    public void confirmarCrear() {
        setBoton(true);
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('crearNom').show();");
    }

    /**
     * @return the boton
     */
    public Boolean getBoton() {
        return boton;
    }

    /**
     * @param boton the boton to set
     */
    public void setBoton(Boolean boton) {
        this.boton = boton;
    }

    public void mostrarCalcular() {
        setBoton(true);
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('dlgCrear').show();");
    }

    /**
     * @return the listaCabeceras
     */
    public List<Tsgnomcabecera> getListaCabeceras() {
        return listaCabeceras;
    }

    /**
     * @param listaCabeceras the listaCabeceras to set
     */
    public void setListaCabeceras(List<Tsgnomcabecera> listaCabeceras) {
        this.listaCabeceras = listaCabeceras;
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
     * @return the CabeceraSelecionada
     */
    public Tsgnomcabecera getCabeceraSelecionada() {
        return CabeceraSelecionada;
    }

    /**
     * @param CabeceraSelecionada the CabeceraSelecionada to set
     */
    public void setCabeceraSelecionada(Tsgnomcabecera CabeceraSelecionada) {
        this.CabeceraSelecionada = CabeceraSelecionada;
    }
}
