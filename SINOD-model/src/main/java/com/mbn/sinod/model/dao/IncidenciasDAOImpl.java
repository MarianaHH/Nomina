/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.dao;

import com.googlecode.genericdao.dao.hibernate.GenericDAOImpl;
import com.mbn.sinod.model.entidades.Tsgnomincidencia;
import java.util.List;

/**
 *
 * @author Karla
 */
public class IncidenciasDAOImpl extends GenericDAOImpl<Tsgnomincidencia, Integer> implements IncidenciasDAO{

    @Override
    public List<Tsgnomincidencia> listarIncidencias() {
        return findAll();
    }
    
}
