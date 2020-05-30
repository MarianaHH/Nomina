/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.dao;

import com.googlecode.genericdao.dao.hibernate.GenericDAOImpl;
import com.mbn.sinod.model.entidades.Tsgnomempquincena;
import java.util.List;
import org.hibernate.Query;

public class EmpQuincenasDAOImpl extends GenericDAOImpl<Tsgnomempquincena, Integer>
        implements EmpQuincenasDAO {

    @Override
    public List<Tsgnomempquincena> listaEmpQuincenas() {
        return findAll();
    }

//    @Override
//    public List<Tsgnomempquincena> listaEmpQuincenas(Integer cabeceraid_fk) {
//        List<Tsgnomempquincena> empquincena = (List<Tsgnomempquincena>) 
//                getSession().createQuery("FROM Tsgnomempquincena EQ, Tsgrhempleados E "
//                + "WHERE EQ.codCabeceraidFk.codCabeceraid = :parametro "
//                + "AND EQ.codEmpleadoidFk.codEmpleadoFk = E.codEmpleado"
//                + "ORDER BY EQ.codEmpquincenaid")
//                .setParameter("parametro", cabeceraid_fk)
//                .list();
//        return empquincena;
//    }
    @Override
    public List<Tsgnomempquincena> listaEmpQuincenas(Integer cabeceraid_fk) {
        List<Tsgnomempquincena> empquincena = (List<Tsgnomempquincena>) getSession().createQuery("FROM Tsgnomempquincena EQ "
                + "WHERE EQ.codCabeceraidFk.codCabeceraid = :parametro "
                + "ORDER BY EQ.codEmpquincenaid")
                .setParameter("parametro", cabeceraid_fk)
                .list();
        return empquincena;
    }

    @Override
    public Boolean insertaEmpleadosQuincena(Integer cabeceraid_fk) {
        Query query = getSession().createSQLQuery("SELECT * FROM sgnom.fn_crearnomina(?)")
                //                .addScalar("confirmacion")
                //                .setResultTransformer(Transformers.aliasToBean(EmpQuincenasDTO.class))
                .setInteger(0, cabeceraid_fk);
        return (Boolean) query.uniqueResult();
    }

}
