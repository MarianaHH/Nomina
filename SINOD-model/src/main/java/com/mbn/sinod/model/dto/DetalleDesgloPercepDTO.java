/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.dto;

import java.util.List;

/**
 *
 * @author torre
 */
public class DetalleDesgloPercepDTO extends GenericDTO{
    
    private List<DetalleDesglosePercepcionDTO> getListaPercepcion;
    

    /**
     * @return the getListaPercepcion
     */
    public List<DetalleDesglosePercepcionDTO> getGetListaPercepcion() {
        return getListaPercepcion;
    }

    /**
     * @param getListaPercepcion the getListaPercepcion to set
     */
    public void setGetListaPercepcion(List<DetalleDesglosePercepcionDTO> getListaPercepcion) {
        this.getListaPercepcion = getListaPercepcion;
    }
}
