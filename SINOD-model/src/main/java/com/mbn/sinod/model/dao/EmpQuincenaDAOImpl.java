/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.dao;

import com.googlecode.genericdao.dao.hibernate.GenericDAOImpl;
import com.mbn.sinod.model.entidades.Tsgnomempquincena;
import java.util.List;


public class EmpQuincenaDAOImpl extends GenericDAOImpl<Tsgnomempquincena, Integer>
        implements EmpQuincenaDAO {

    @Override
    public List<Tsgnomempquincena> listarEmpQuincena() {
        return findAll();
    }

    
}
