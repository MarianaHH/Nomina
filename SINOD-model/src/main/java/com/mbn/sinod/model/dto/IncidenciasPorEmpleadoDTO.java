/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.dto;

import java.util.List;

/**
 *
 * @author Karla
 */
public class IncidenciasPorEmpleadoDTO {
    
    private List<DetalleIncidenciasEmpleadoDTO> listaIncidenciasEmpleado;

    public List<DetalleIncidenciasEmpleadoDTO> getListaIncidenciasEmpleado() {
        return listaIncidenciasEmpleado;
    }

    public void setListaIncidenciasEmpleado(List<DetalleIncidenciasEmpleadoDTO> listaIncidenciasEmpleado) {
        this.listaIncidenciasEmpleado = listaIncidenciasEmpleado;
    }
    
}
