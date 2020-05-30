/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.dto;

import com.mbn.sinod.model.entidades.Tsgnomformula;
import java.util.List;

/**
 *
 * @author ambrosio
 */
public class FormulaDTO extends GenericDTO{
    private Tsgnomformula formula;
    private List<Tsgnomformula> listarFormulas;

    /**
     * @return the formula
     */
    public Tsgnomformula getFormula() {
        return formula;
    }

    /**
     * @param formula the formula to set
     */
    public void setFormula(Tsgnomformula formula) {
        this.formula = formula;
    }

    /**
     * @return the listarFormulas
     */
    public List<Tsgnomformula> getListarFormulas() {
        return listarFormulas;
    }

    /**
     * @param listarFormulas the listarFormulas to set
     */
    public void setListarFormulas(List<Tsgnomformula> listarFormulas) {
        this.listarFormulas = listarFormulas;
    }
}
