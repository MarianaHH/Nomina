/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.dto;

import com.mbn.sinod.model.entidades.Tsgnomconceptosat;
import java.util.List;

/**
 *
 * @author ambrosio
 */
public class CatConceptosSATDTO extends GenericDTO{
    private Tsgnomconceptosat conceptoSAT;
    private List<Tsgnomconceptosat> listarConceptosSAT;

    /**
     * @return the conceptoSAT
     */
    public Tsgnomconceptosat getConceptoSAT() {
        return conceptoSAT;
    }

    /**
     * @param conceptoSAT the conceptoSAT to set
     */
    public void setConceptoSAT(Tsgnomconceptosat conceptoSAT) {
        this.conceptoSAT = conceptoSAT;
    }

    /**
     * @return the listarConceptosSAT
     */
    public List<Tsgnomconceptosat> getListarConceptosSAT() {
        return listarConceptosSAT;
    }

    /**
     * @param listarConceptosSAT the listarConceptosSAT to set
     */
    public void setListarConceptosSAT(List<Tsgnomconceptosat> listarConceptosSAT) {
        this.listarConceptosSAT = listarConceptosSAT;
    }
    
}
