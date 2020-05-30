/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.dao;

import com.googlecode.genericdao.dao.hibernate.GenericDAO;
import com.mbn.sinod.model.entidades.Tsgnomquincena;
import java.util.List;

/**
 *
 * @author mipe
 */
public interface QuincenasDAO extends GenericDAO<Tsgnomquincena, Integer>{

    /**
     *
     * @return
     */
    List<Tsgnomquincena> listarQuincena();
    List<Tsgnomquincena> listarQuinFuturas();
    boolean guardarActualizarQuincena(Tsgnomquincena quincena);
    
    /**
     * Obtiene la quincena actual, 
     * @return 
     */
    Tsgnomquincena quincenaActual();
}
