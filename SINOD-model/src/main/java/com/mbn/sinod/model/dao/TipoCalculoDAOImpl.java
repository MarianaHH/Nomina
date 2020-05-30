/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.dao;

import com.googlecode.genericdao.dao.hibernate.GenericDAOImpl;
import com.mbn.sinod.model.entidades.Tsgnomcalculo;
import java.util.List;


public class TipoCalculoDAOImpl extends GenericDAOImpl<Tsgnomcalculo, Integer> implements TipoCalculoDAO {

    @Override
    public List<Tsgnomcalculo> listarTiposCalculo() {
        return findAll();
    }
}