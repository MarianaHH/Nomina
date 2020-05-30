/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.dto;

import com.mbn.sinod.model.entidades.Tsgnomtipoconcepto;
import java.util.List;

/**
 *
 * @author ambrosio
 */
public class TipoConceptoDTO extends GenericDTO{
    private Tsgnomtipoconcepto tipoConcepto;
    private List<Tsgnomtipoconcepto> listarTiposConcepto;

    /**
     * @return the tipoConcepto
     */
    public Tsgnomtipoconcepto getTipoConcepto() {
        return tipoConcepto;
    }

    /**
     * @param tipoConcepto the tipoConcepto to set
     */
    public void setTipoConcepto(Tsgnomtipoconcepto tipoConcepto) {
        this.tipoConcepto = tipoConcepto;
    }

    /**
     * @return the listarTiposConcepto
     */
    public List<Tsgnomtipoconcepto> getListarTiposConcepto() {
        return listarTiposConcepto;
    }

    /**
     * @param listarTiposConcepto the listarTiposConcepto to set
     */
    public void setListarTiposConcepto(List<Tsgnomtipoconcepto> listarTiposConcepto) {
        this.listarTiposConcepto = listarTiposConcepto;
    }
}
