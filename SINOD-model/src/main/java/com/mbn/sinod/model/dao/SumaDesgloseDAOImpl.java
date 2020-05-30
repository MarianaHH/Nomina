/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.dao;

import com.googlecode.genericdao.dao.hibernate.GenericDAOImpl;
import com.mbn.sinod.model.entidades.Tsgnomempquincena;
import java.util.List;

public class SumaDesgloseDAOImpl extends GenericDAOImpl<Tsgnomempquincena, Integer>
        implements SumaDesgloseDAO {

    @Override
    public List<Tsgnomempquincena> sumaDesglose(Integer cabecera, Integer empleado) {
        List<Tsgnomempquincena> suma = (List<Tsgnomempquincena>) getSession().createQuery("FROM Tsgnomempquincena "
                + "WHERE codEmpleadoidFk.codEmpleadoid = :parametro1 "
                + "AND codCabeceraidFk.codCabeceraid = :parametro2 "
                + "")
                .setParameter("parametro1", empleado)
                .setParameter("parametro2", cabecera)
                .list();
        return suma;
    }
}
