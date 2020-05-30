/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.dto;

import java.util.List;

/**
 *
 * @author Ivette
 */
public class InfoHistorialRhDTO extends GenericDTO {
    
    private List<HistorialEmpleadosRhDTO> listaHistorialEmpleadosRh;

    public List<HistorialEmpleadosRhDTO> getListaHistorialEmpleadosRh() {
        return listaHistorialEmpleadosRh;
    }

    public void setListaHistorialEmpleadosRh(List<HistorialEmpleadosRhDTO> listaHistorialEmpleadosRh) {
        this.listaHistorialEmpleadosRh = listaHistorialEmpleadosRh;
    }
    
    
}
