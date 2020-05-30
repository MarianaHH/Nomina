/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.dao;

import com.googlecode.genericdao.dao.hibernate.GenericDAO;
import com.mbn.sinod.model.entidades.Tsgnomejercicio;
import java.util.List;

/**
 *
 * @author mipe
 */
public interface EjercicioFiscalDAO extends GenericDAO<Tsgnomejercicio, Integer>{
    
    List<Tsgnomejercicio> listaEjercicios();
}
