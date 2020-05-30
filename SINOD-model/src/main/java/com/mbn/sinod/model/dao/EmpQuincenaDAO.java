/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.dao;

import com.googlecode.genericdao.dao.hibernate.GenericDAO;
import com.mbn.sinod.model.entidades.Tsgnomempquincena;
import java.util.List;

/**
 *
 * @author mipe
 */
public interface EmpQuincenaDAO extends GenericDAO<Tsgnomempquincena, Integer>{
    
    List<Tsgnomempquincena> listarEmpQuincena();
    
}
