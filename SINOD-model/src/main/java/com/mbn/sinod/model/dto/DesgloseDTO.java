/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.dto;

import java.util.List;

/**
 *
 * @author eduardotorres
 */
public class DesgloseDTO extends GenericDTO{
    
    private List<DetalleDesgloseDTO> getListaConcep;

    /**
     * @return the getListaConcep
     */
    public List<DetalleDesgloseDTO> getGetListaConcep() {
        return getListaConcep;
    }

    /**
     * @param getListaConcep the getListaConcep to set
     */
    public void setGetListaConcep(List<DetalleDesgloseDTO> getListaConcep) {
        this.getListaConcep = getListaConcep;
    }
    
}

