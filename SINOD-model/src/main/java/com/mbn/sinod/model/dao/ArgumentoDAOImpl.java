/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.dao;

import com.googlecode.genericdao.dao.hibernate.GenericDAOImpl;
import com.mbn.sinod.model.entidades.Tsgnomargumento;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Query;

/**
 *
 * @author mariana
 */
public class ArgumentoDAOImpl extends GenericDAOImpl<Tsgnomargumento, Integer> implements ArgumentoDAO {

    @Override
    public List<Tsgnomargumento> obtenerListaArgumentos() {
        List<Tsgnomargumento> argumentos
                = (List<Tsgnomargumento>) getSession().createQuery("FROM Tsgnomargumento "
                        + "WHERE bolEstatus = :parametro")
                        .setParameter("parametro", true)
                        .list();
        return argumentos;
    }

    @Override
    public boolean guardarActualizarArgumento(Tsgnomargumento argumento) {
        try {
            _saveOrUpdate(argumento);
            return true;
        } catch (Exception e) {
            Logger.getLogger(ArgumentoDAOImpl.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }

    @Override
    public boolean eliminarArgumento(Integer id) {
        try {
            StringBuilder sb = new StringBuilder("UPDATE sgnom.tsgnomargumento "
                    + "SET bol_estatus = false "
                    + "WHERE cod_argumentoid = :argumentoId");
            Query sql = getSession().createSQLQuery(sb.toString());
            sql.setParameter("argumentoId", id);

            if (sql.executeUpdate() > 0) {
                return true;
            }
        } catch (Exception e) {
            Logger.getLogger(ArgumentoDAOImpl.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }

        return false;
    }

    @Override
    public List<Tsgnomargumento> obtenerArgumentosConstantes() {
        List<Tsgnomargumento> argumentos
                = (List<Tsgnomargumento>) getSession().createQuery("FROM Tsgnomargumento "
                        + "WHERE codTipoargumento = :parametro "
                        + "AND bol_estatus = true")
                        .setParameter("parametro", '1')
                        .list();
        return argumentos;
    }

    @Override
    public List<Tsgnomargumento> obtenerArgumentosVariables() {
        List<Tsgnomargumento> argumentos
                = (List<Tsgnomargumento>) getSession().createQuery("FROM Tsgnomargumento "
                        + "WHERE codTipoargumento = :parametro "
                        + "AND bol_estatus = true")
                        .setParameter("parametro", '0')
                        .list();
        return argumentos;
    }

}
