/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.dao;

import com.googlecode.genericdao.dao.hibernate.GenericDAOImpl;
import com.mbn.sinod.model.entidades.Tsgnomquincena;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class QuincenasDAOImpl extends GenericDAOImpl<Tsgnomquincena, Integer> implements QuincenasDAO {

    @Override
    public List<Tsgnomquincena> listarQuincena() {
        return findAll();
    }

    @Override
    public List<Tsgnomquincena> listarQuinFuturas() {
        List<Tsgnomquincena> quincena = (List<Tsgnomquincena>) getSession().createQuery("FROM Tsgnomquincena "
                + "WHERE fec_fin >= CURRENT_DATE ")
//                + "WHERE fec_inicio >= CURRENT_DATE - 10")
                .list();
        return quincena;
    }

    @Override
    public boolean guardarActualizarQuincena(Tsgnomquincena quincena) {
       try {
            _saveOrUpdate(quincena);
            return true;
        } catch (Exception e) {
            Logger.getLogger(QuincenasDAOImpl.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }
    
    @Override
    public Tsgnomquincena quincenaActual() {
        Tsgnomquincena quincena = (Tsgnomquincena) getSession().createQuery("FROM Tsgnomquincena "
                + "WHERE fec_inicio <= CURRENT_DATE AND fec_fin >= CURRENT_DATE")
                .uniqueResult();
        return quincena;
    }
}
