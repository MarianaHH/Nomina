/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.dao;

import com.googlecode.genericdao.dao.hibernate.GenericDAOImpl;
import com.mbn.sinod.model.entidades.Tsgnomestatusnom;
import java.util.List;


public class EstatusNominaDAOImpl extends GenericDAOImpl<Tsgnomestatusnom, Integer> implements EstatusNominaDAO {

    @Override
    public List<Tsgnomestatusnom> listarEstatusNomina() {
//        return findAll();
        List<Tsgnomestatusnom> estatus = (List<Tsgnomestatusnom>) getSession().createQuery("FROM Tsgnomestatusnom "
                + "WHERE codEstatusnomid = :parametro "
                + "")
                .setParameter("parametro", 1).list();
        return estatus;
    }

    
    
}
