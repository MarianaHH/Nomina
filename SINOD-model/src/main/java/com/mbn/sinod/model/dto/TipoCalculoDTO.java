/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.dto;

import com.mbn.sinod.model.entidades.Tsgnomcalculo;
import java.util.List;

/**
 *
 * @author ambrosio
 */
public class TipoCalculoDTO extends GenericDTO{
    private Tsgnomcalculo tipoCalculo;
    private List<Tsgnomcalculo> listarTiposCalculo;

    /**
     * @return the tipoCalculo
     */
    public Tsgnomcalculo getTipoCalculo() {
        return tipoCalculo;
    }

    /**
     * @param tipoCalculo the tipoCalculo to set
     */
    public void setTipoCalculo(Tsgnomcalculo tipoCalculo) {
        this.tipoCalculo = tipoCalculo;
    }

    /**
     * @return the listarTiposCalculo
     */
    public List<Tsgnomcalculo> getListarTiposCalculo() {
        return listarTiposCalculo;
    }

    /**
     * @param listarTiposCalculo the listarTiposCalculo to set
     */
    public void setListarTiposCalculo(List<Tsgnomcalculo> listarTiposCalculo) {
        this.listarTiposCalculo = listarTiposCalculo;
    }
}
