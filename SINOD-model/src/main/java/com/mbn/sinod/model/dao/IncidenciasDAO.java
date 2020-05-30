/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.dao;

import com.googlecode.genericdao.dao.hibernate.GenericDAO;
import com.mbn.sinod.model.entidades.Tsgnomincidencia;
import java.util.List;

/**
 *
 * @author Karla
 */
public interface IncidenciasDAO extends GenericDAO<Tsgnomincidencia, Integer> {
    
    /**
     * Lista las incidencias
     * @return 
     */
    public List<Tsgnomincidencia> listarIncidencias();
}
