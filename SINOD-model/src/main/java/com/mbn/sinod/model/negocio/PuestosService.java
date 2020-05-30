/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.negocio;

import com.googlecode.genericdao.dao.hibernate.GenericDAO;
import com.mbn.sinod.model.entidades.Tsgrhpuestos;
import java.util.List;

/**
 *
 * @author eduardotorres
 */
public interface PuestosService extends GenericDAO<Tsgrhpuestos, Integer> {
    List<Tsgrhpuestos> listaPuestos();
    Tsgrhpuestos obtenerPuestosPorId (Integer puestosId);
    
}
