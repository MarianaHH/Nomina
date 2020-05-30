/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.web.mb;

import com.mbn.sinod.model.dto.VerInformacionDePersonalDTO;
import com.mbn.sinod.model.entidades.Tsgnomalguinaldo;
import com.mbn.sinod.model.entidades.Tsgnomquincena;
import com.mbn.sinod.model.entidades.Tsgrhareas;
import com.mbn.sinod.model.entidades.Tsgrhempleados;
import com.mbn.sinod.model.entidades.Tsgrhpuestos;
import com.mbn.sinod.web.client.VerInformacionDePersonalWSClient;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import org.apache.deltaspike.core.api.scope.ViewAccessScoped;
import org.apache.log4j.Logger;

/**
 *
 * @author Ivette
 */
@Named(value = "verInformacionDePersonalMB")
@ViewAccessScoped
public class VerInformacionDePersonalMB implements Serializable{
    
    
    private List<Tsgrhempleados> listarPersonal;
    private Tsgrhempleados personalSeleccionado;
    private Integer idPersonal;
    private List<VerInformacionDePersonalDTO> listaVerInformacionDePersonal;
    private VerInformacionDePersonalDTO detalleSeleccionado;
    private Tsgrhareas areaSeleccionada;
    private Tsgrhpuestos puestoSeleccionado;
    private Tsgnomquincena quincenaSeleccionada;
    private Tsgnomalguinaldo aguinaldoSeleccionado;
    
    private Integer cod_empleado;
    
    

   private final static Logger logger = Logger.getLogger(VerInformacionDePersonalMB.class);
    
   @PostConstruct
   public void iniciarVariables() {
       DetalleEmpleadosMB detalleEmpMB = new DetalleEmpleadosMB();
       setCod_empleado(detalleEmpMB.getCod_empleado());
       setDetalleSeleccionado(VerInformacionDePersonalWSClient.informacionPorEmpleado(cod_empleado).get(0));
       System.out.println("Detalles empleado: "+detalleEmpMB.getCod_empleado());
    }
   
   
    public void busquedaPersonalPorId(VerInformacionDePersonalDTO verInformacionDePersonalDTO){
       setDetalleSeleccionado(verInformacionDePersonalDTO);
        System.out.println("Ver Empleado: "+cod_empleado);
    }
    
    
    public List<Tsgrhempleados> getListarPersonal() {
        return listarPersonal;
    }

    public void setListarPersonal(List<Tsgrhempleados> listarPersonal) {
        this.listarPersonal = listarPersonal;
    }

    public Tsgrhempleados getPersonalSeleccionado() {
        return personalSeleccionado;
    }

    public void setPersonalSeleccionado(Tsgrhempleados personalSeleccionado) {
        this.personalSeleccionado = personalSeleccionado;
    }

    public Integer getIdPersonal() {
        return idPersonal;
    }

    public void setIdPersonal(Integer idPersonal) {
        this.idPersonal = idPersonal;
    }

    public List<VerInformacionDePersonalDTO> getListaVerInformacionDePersonal() {
        return listaVerInformacionDePersonal;
    }

    public void setListaVerInformacionDePersonal(List<VerInformacionDePersonalDTO> listaVerInformacionDePersonal) {
        this.listaVerInformacionDePersonal = listaVerInformacionDePersonal;
    }
    
     public Tsgrhareas getAreaSeleccionada() {
        return areaSeleccionada;
    }

    public void setAreaSeleccionada(Tsgrhareas areaSeleccionada) {
        this.areaSeleccionada = areaSeleccionada;
    }
    
    public Tsgrhpuestos getPuestoSeleccionado() {
        return puestoSeleccionado;
    }

    public void setPuestoSeleccionado(Tsgrhpuestos puestoSeleccionado) {
        this.puestoSeleccionado = puestoSeleccionado;
    }
    
    public Tsgnomquincena getQuincenaSeleccionada() {
        return quincenaSeleccionada;
    }

    public void setQuincenaSeleccionada(Tsgnomquincena quincenaSeleccionada) {
        this.quincenaSeleccionada = quincenaSeleccionada;
    }

    public Tsgnomalguinaldo getAguinaldoSeleccionado() {
        return aguinaldoSeleccionado;
    }

    public void setAguinaldoSeleccionado(Tsgnomalguinaldo aguinaldoSeleccionado) {
        this.aguinaldoSeleccionado = aguinaldoSeleccionado;
    }
    
     public VerInformacionDePersonalDTO getDetalleSeleccionado() {
        return detalleSeleccionado;
    }

    public void setDetalleSeleccionado(VerInformacionDePersonalDTO detalleSeleccionado) {
        this.detalleSeleccionado = detalleSeleccionado;
    }
    
    public Integer getCod_empleado() {
        return cod_empleado;
    }

    public void setCod_empleado(Integer cod_empleado) {
        this.cod_empleado = cod_empleado;
    }
}
