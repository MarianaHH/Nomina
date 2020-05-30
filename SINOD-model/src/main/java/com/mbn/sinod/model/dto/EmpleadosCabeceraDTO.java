/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.dto;

import java.util.List;

/**
 *
 * @author mariana
 */
public class EmpleadosCabeceraDTO extends GenericDTO{
    private String nom_empleado;
    private String rol;
    private String area;
    private Integer cod_empleado;
    private Integer cod_empquincenaid;
    private List<EmpleadosCabeceraDTO> listaEmpleadosCabecera;

    public String getNom_empleado() {
        return nom_empleado;
    }

    public void setNom_empleado(String nom_empleado) {
        this.nom_empleado = nom_empleado;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Integer getCod_empleado() {
        return cod_empleado;
    }

    public void setCod_empleado(Integer cod_empleado) {
        this.cod_empleado = cod_empleado;
    }

    public Integer getCod_empquincenaid() {
        return cod_empquincenaid;
    }

    public void setCod_empquincenaid(Integer cod_empquincenaid) {
        this.cod_empquincenaid = cod_empquincenaid;
    }

    public List<EmpleadosCabeceraDTO> getListaEmpleadosCabecera() {
        return listaEmpleadosCabecera;
    }

    public void setListaEmpleadosCabecera(List<EmpleadosCabeceraDTO> listaEmpleadosCabecera) {
        this.listaEmpleadosCabecera = listaEmpleadosCabecera;
    }
    
    
    
    
    
    
}
