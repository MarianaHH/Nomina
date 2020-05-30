/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.dao;

import com.googlecode.genericdao.dao.hibernate.GenericDAOImpl;
import com.mbn.sinod.model.entidades.Tsgnomejercicio;
import java.util.List;

public class EjercicioFiscalDAOImpl extends GenericDAOImpl<Tsgnomejercicio, Integer>
        implements EjercicioFiscalDAO {

    @Override
    public List<Tsgnomejercicio> listaEjercicios() {
        List<Tsgnomejercicio> conceptos = (List<Tsgnomejercicio>) getSession()
                .createQuery("From Tsgnomejercicio " +
                "WHERE cnuValorejercicio >= EXTRACT(year FROM current_date)")
                .list();
        return conceptos;
    }
}
