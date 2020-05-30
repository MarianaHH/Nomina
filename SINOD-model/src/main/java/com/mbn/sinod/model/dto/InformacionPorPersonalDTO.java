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
public class InformacionPorPersonalDTO  extends GenericDTO{
    
    private List<VerInformacionDePersonalDTO> listaInformacionPorPersonal;

    public List<VerInformacionDePersonalDTO> getListaInformacionPorPersonal() {
        return listaInformacionPorPersonal;
    }

    public void setListaInformacionPorPersonal(List<VerInformacionDePersonalDTO> listaInformacionPorPersonal) {
        this.listaInformacionPorPersonal = listaInformacionPorPersonal;
    }
    
}
