/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.dao;

import com.googlecode.genericdao.dao.hibernate.GenericDAO;
import com.mbn.sinod.model.entidades.Tsgnomformula;
import java.util.List;

/**
 *
 * @author ambrosio
 */
public interface FormulaDAO extends GenericDAO<Tsgnomformula, Integer>{
    
    /**
     *
     * @return
     */
    List<Tsgnomformula> listarFormulas();
    boolean guardarFormula(Tsgnomformula formula);
}
