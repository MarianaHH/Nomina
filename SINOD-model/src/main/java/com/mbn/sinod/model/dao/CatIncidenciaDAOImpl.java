/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.dao;

import com.googlecode.genericdao.dao.hibernate.GenericDAOImpl;
import com.mbn.sinod.model.entidades.Tsgnomcatincidencia;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Query;

public class CatIncidenciaDAOImpl extends GenericDAOImpl<Tsgnomcatincidencia, Integer> implements CatIncidenciaDAO {

    @Override
    public List<Tsgnomcatincidencia> listarCatIncidencias() {
//        return findAll();
        List<Tsgnomcatincidencia> catIncidencias = (List<Tsgnomcatincidencia>) getSession().createQuery("FROM Tsgnomcatincidencia "
                + "WHERE bolEstatus = :parametro")
                .setParameter("parametro", true).list();
        return catIncidencias;
    }

    @Override
    public boolean guardarActualizarCatInci(Tsgnomcatincidencia catIncidencia) {
        try {
            _saveOrUpdate(catIncidencia);
//            save(catIncidencia);
            return true;
        } catch (Exception e) {
            Logger.getLogger(CatIncidenciaDAOImpl.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }

    @Override
    public boolean eliminarCatIncidenciasId(Integer catincidenciaid) {
        try {
            Query query = getSession().createSQLQuery("UPDATE sgnom.tsgnomcatincidencia "
                    + " SET bol_estatus = false "
                    + " WHERE cod_catincidenciaid = " + catincidenciaid + ";");
            System.out.println(query);
            query.executeUpdate();
            return true;
        } catch (Exception e) {
            Logger.getLogger(CatIncidenciaDAOImpl.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }

}
