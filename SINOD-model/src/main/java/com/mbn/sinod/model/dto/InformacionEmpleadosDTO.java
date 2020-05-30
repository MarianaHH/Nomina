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
public class InformacionEmpleadosDTO extends GenericDTO {
    
     private List<DetalleEmpleadosDTO> listaInformacionEmpleados;

    public List<DetalleEmpleadosDTO> getListaInformacionEmpleados() {
        return listaInformacionEmpleados;
    }

    public void setListaInformacionEmpleados(List<DetalleEmpleadosDTO> listaInformacionEmpleados) {
        this.listaInformacionEmpleados = listaInformacionEmpleados;
    }
    
}
