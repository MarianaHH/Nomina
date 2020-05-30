/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.dto;

/**
 *
 * @author Ivette
 */
public class HistorialNomEmpleadosXMLDTO extends GenericDTO{
    
    private String fecha;
    private String sueldoImss;
    private String sueldoHonorarios;
    private String estatusFnzs;

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getSueldoImss() {
        return sueldoImss;
    }

    public void setSueldoImss(String sueldoImss) {
        this.sueldoImss = sueldoImss;
    }

    public String getSueldoHonorarios() {
        return sueldoHonorarios;
    }

    public void setSueldoHonorarios(String sueldoHonorarios) {
        this.sueldoHonorarios = sueldoHonorarios;
    }

    public String getEstatusFnzs() {
        return estatusFnzs;
    }

    public void setEstatusFnzs(String estatusFnzs) {
        this.estatusFnzs = estatusFnzs;
    }
    
}
