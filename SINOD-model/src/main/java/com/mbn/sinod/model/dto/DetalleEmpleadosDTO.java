/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Ivette
 */
public class DetalleEmpleadosDTO {
    
    private Integer codempleado;
    private String nomcompleto;
    private String desrfc;
    private String descurp;
    private String desnbarea;
    private String despuesto;

    public Integer getCodempleado() {
        return codempleado;
    }

    public void setCodempleado(Integer codempleado) {
        this.codempleado = codempleado;
    }

    public String getNomcompleto() {
        return nomcompleto;
    }

    public void setNomcompleto(String nomcompleto) {
        this.nomcompleto = nomcompleto;
    }

    public String getDesrfc() {
        return desrfc;
    }

    public void setDesrfc(String desrfc) {
        this.desrfc = desrfc;
    }

    public String getDesnbarea() {
        return desnbarea;
    }

    public void setDesnbarea(String desnbarea) {
        this.desnbarea = desnbarea;
    }

    public String getDespuesto() {
        return despuesto;
    }

    public void setDespuesto(String despuesto) {
        this.despuesto = despuesto;
    }


    public String getDescurp() {
        return descurp;
    }

    public void setDescurp(String descurp) {
        this.descurp = descurp;
    }
    
    
}
