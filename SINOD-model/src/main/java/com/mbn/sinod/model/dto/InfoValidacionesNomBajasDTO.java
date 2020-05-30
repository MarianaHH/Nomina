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
public class InfoValidacionesNomBajasDTO extends GenericDTO{
    
     private List<ValidacionesNomBajasDTO> listaValidacionesNomBajas;

    public List<ValidacionesNomBajasDTO> getListaValidacionesNomBajas() {
        return listaValidacionesNomBajas;
    }

    public void setListaValidacionesNomBajas(List<ValidacionesNomBajasDTO> listaValidacionesNomBajas) {
        this.listaValidacionesNomBajas = listaValidacionesNomBajas;
    }
    
}
