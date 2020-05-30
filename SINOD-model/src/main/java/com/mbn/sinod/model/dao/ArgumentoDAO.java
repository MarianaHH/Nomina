/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.dao;

import com.googlecode.genericdao.dao.hibernate.GenericDAO;
import com.mbn.sinod.model.entidades.Tsgnomargumento;

import java.util.List;
/**
 *
 * @author mariana
 */
public interface ArgumentoDAO extends GenericDAO<Tsgnomargumento, Integer>{
    
    List<Tsgnomargumento> obtenerListaArgumentos();
    
    List<Tsgnomargumento> obtenerArgumentosConstantes();
    
    List<Tsgnomargumento> obtenerArgumentosVariables();
    
    boolean guardarActualizarArgumento(Tsgnomargumento argumento);
    
    boolean eliminarArgumento(Integer id);
    
    
}

