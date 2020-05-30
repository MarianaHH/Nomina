/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.dto;

import com.mbn.sinod.model.entidades.Tsgnomconcepto;
import java.util.List;

/**
 *
 * @author ambrosio
 */
public class ConceptoDTO extends GenericDTO{
    private Tsgnomconcepto concepto;
    private List<Tsgnomconcepto> listConceptos;

    /**
     * @return the concepto
     */
    public Tsgnomconcepto getConcepto() {
        return concepto;
    }

    /**
     * @param concepto the concepto to set
     */
    public void setConcepto(Tsgnomconcepto concepto) {
        this.concepto = concepto;
    }

    /**
     * @return the listConceptos
     */
    public List<Tsgnomconcepto> getListConceptos() {
        return listConceptos;
    }

    /**
     * @param listConceptos the listConceptos to set
     */
    public void setListConceptos(List<Tsgnomconcepto> listConceptos) {
        this.listConceptos = listConceptos;
    }
}
