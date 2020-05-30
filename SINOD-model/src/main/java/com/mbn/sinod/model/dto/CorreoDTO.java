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
public class CorreoDTO extends GenericDTO {

    private Integer nom_empleado;
    private String correo;
    private List<IncidenciasQuincenaDTO> incidenciasEmpleado;
    private List<CorreoDTO> listaCorreos;
    private String incidencia;
    private String validar;

    public String getIncidencia() {
        return incidencia;
    }

    public void setIncidencia(String incidencia) {
        this.incidencia = incidencia;
    }

    public String getValidar() {
        return validar;
    }

    public void setValidar(String validar) {
        this.validar = validar;
    }

   
    
    
    

    public Integer getNom_empleado() {
        return nom_empleado;
    }

    public void setNom_empleado(Integer nom_empleado) {
        this.nom_empleado = nom_empleado;
    }

   

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String Correo) {
        this.correo = Correo;
    }

    public List<IncidenciasQuincenaDTO> getIncidenciasEmpleado() {
        return incidenciasEmpleado;
    }

    public void setIncidenciasEmpleado(List<IncidenciasQuincenaDTO> incidenciasEmpleado) {
        this.incidenciasEmpleado = incidenciasEmpleado;
    }

    public List<CorreoDTO> getListaCorreos() {
        return listaCorreos;
    }

    public void setListaCorreos(List<CorreoDTO> listaCorreos) {
        this.listaCorreos = listaCorreos;
    }

    
    
    
}
