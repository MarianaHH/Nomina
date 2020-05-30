/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.dto;

import com.mbn.sinod.model.entidades.Tsgnomtiponomina;
import java.util.List;

/**
 *
 * @author ambrosio
 */
public class TipoNominaDTO extends GenericDTO{
    private Tsgnomtiponomina tipoNomina;
    private List<Tsgnomtiponomina> listaTipoNomina;

    /**
     * @return the tipoNomina
     */
    public Tsgnomtiponomina getTipoNomina() {
        return tipoNomina;
    }

    /**
     * @param tipoNomina the tipoNomina to set
     */
    public void setTipoNomina(Tsgnomtiponomina tipoNomina) {
        this.tipoNomina = tipoNomina;
    }

    /**
     * @return the listaTipoNomina
     */
    public List<Tsgnomtiponomina> getListaTipoNomina() {
        return listaTipoNomina;
    }

    /**
     * @param listaTipoNomina the listaTipoNomina to set
     */
    public void setListaTipoNomina(List<Tsgnomtiponomina> listaTipoNomina) {
        this.listaTipoNomina = listaTipoNomina;
    }
}
