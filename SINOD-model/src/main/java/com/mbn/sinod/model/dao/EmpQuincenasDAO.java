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
 * @author ambrosio
 */
public interface EmpQuincenasDAO extends GenericDAO<Tsgnomempquincena, Integer>{

    /**
     *
     * @return
     */
    List<Tsgnomempquincena> listaEmpQuincenas();
    
    List<Tsgnomempquincena> listaEmpQuincenas(Integer cabeceraid_fk);
    
    Boolean insertaEmpleadosQuincena(Integer cabeceraid_fk);
}
