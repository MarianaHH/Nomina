/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.dao;

import com.googlecode.genericdao.dao.hibernate.GenericDAOImpl;
import com.mbn.sinod.model.entidades.Tsgnomformula;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class FormulaDAOImpl extends GenericDAOImpl<Tsgnomformula, Integer> implements FormulaDAO {

    @Override
    public List<Tsgnomformula> listarFormulas() {
        return findAll();
    }

    @Override
    public boolean guardarFormula(Tsgnomformula formula) {
        try {
             _saveOrUpdate(formula);
            return true;
        } catch (Exception e) {
            Logger.getLogger(FormulaDAOImpl.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }
}
