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
public class InfoAltaDePersonalDTO extends GenericDTO{
    
    private List<AltaDePersonalDTO> listaInformacionParaAltaNom;

    public List<AltaDePersonalDTO> getListaInformacionParaAltaNom() {
        return listaInformacionParaAltaNom;
    }

    public void setListaInformacionParaAltaNom(List<AltaDePersonalDTO> listaInformacionParaAltaNom) {
        this.listaInformacionParaAltaNom = listaInformacionParaAltaNom;
    }
    
}
