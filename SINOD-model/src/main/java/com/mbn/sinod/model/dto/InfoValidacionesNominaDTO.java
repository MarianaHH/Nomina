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
public class InfoValidacionesNominaDTO extends GenericDTO {
    
    private List<ValidacionesNominaDTO> listaValidacionesNomina;

    public List<ValidacionesNominaDTO> getListaValidacionesNomina() {
        return listaValidacionesNomina;
    }

    public void setListaValidacionesNomina(List<ValidacionesNominaDTO> listaValidacionesNomina) {
        this.listaValidacionesNomina = listaValidacionesNomina;
    }
    
}
