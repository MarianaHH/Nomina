/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.dto;

import com.mbn.sinod.model.entidades.Tsgnomempquincena;
import java.util.List;

/**
 *
 * @author torre
 */
public class SumaDesgloseDTO extends GenericDTO {
    
    private Tsgnomempquincena conceptosSum;
    private List<Tsgnomempquincena> listConceptosSum;

    /**
     * @return the conceptosSum
     */
    public Tsgnomempquincena getConceptosSum() {
        return conceptosSum;
    }

    /**
     * @param conceptosSum the conceptosSum to set
     */
    public void setConceptosSum(Tsgnomempquincena conceptosSum) {
        this.conceptosSum = conceptosSum;
    }

    /**
     * @return the listConceptosSum
     */
    public List<Tsgnomempquincena> getListConceptosSum() {
        return listConceptosSum;
    }

    /**
     * @param listConceptosSum the listConceptosSum to set
     */
    public void setListConceptosSum(List<Tsgnomempquincena> listConceptosSum) {
        this.listConceptosSum = listConceptosSum;
    }
    
}
