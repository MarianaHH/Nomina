/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.dao;

import com.googlecode.genericdao.dao.hibernate.GenericDAOImpl;
import com.mbn.sinod.model.entidades.Tsgnomfuncion;
import java.util.List;

/**
 *
 * @author mariana
 */
public class FuncionDAOImpl extends GenericDAOImpl<Tsgnomfuncion, Integer> implements FuncionDAO {

    @Override
    public List<Tsgnomfuncion> obtenerFunciones() {
        List<Tsgnomfuncion> funciones
                = (List<Tsgnomfuncion>) getSession().createQuery("FROM Tsgnomfuncion WHERE bolEstatus = :parametro")
                        .setParameter("parametro", true)
                        .list();
        return funciones;
    }

}
