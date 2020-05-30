/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.dto;

import java.util.Date;

/**
 *
 * @author Ivette
 */
public class ValidacionesNominaDTO {
    
    private Integer cod_empleadoid;
    private String nom_empleado;
    private String cod_rfc;
    private String cod_curp;
    private String des_nbarea;
    private String des_puesto;
    private Boolean validar;
    private String fecha_validacion;

    

    public Integer getCod_empleadoid() {
        return cod_empleadoid;
    }

    public void setCod_empleadoid(Integer cod_empleadoid) {
        this.cod_empleadoid = cod_empleadoid;
    }

    public String getNom_empleado() {
        return nom_empleado;
    }

    public void setNom_empleado(String nom_empleado) {
        this.nom_empleado = nom_empleado;
    }

    public String getCod_rfc() {
        return cod_rfc;
    }

    public void setCod_rfc(String cod_rfc) {
        this.cod_rfc = cod_rfc;
    }

    public String getDes_nbarea() {
        return des_nbarea;
    }

    public void setDes_nbarea(String des_nbarea) {
        this.des_nbarea = des_nbarea;
    }

    public String getDes_puesto() {
        return des_puesto;
    }

    public void setDes_puesto(String des_puesto) {
        this.des_puesto = des_puesto;
    }

    public Boolean getValidar() {
        return validar;
    }

    public void setValidar(Boolean validar) {
        this.validar = validar;
    }

    /**
     * @return the cod_curp
     */
    public String getCod_curp() {
        return cod_curp;
    }

    /**
     * @param cod_curp the cod_curp to set
     */
    public void setCod_curp(String cod_curp) {
        this.cod_curp = cod_curp;
    }

    public String getFecha_validacion() {
        return fecha_validacion;
    }

    public void setFecha_validacion(String fecha_validacion) {
        this.fecha_validacion = fecha_validacion;
    }

    
    
}
