/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.dao;

import com.googlecode.genericdao.dao.hibernate.GenericDAOImpl;
import com.mbn.sinod.model.entidades.Tsgnomcncptoquinc;
import com.mbn.sinod.model.entidades.Tsgnomcncptoquincht;
import java.util.List;


public class ConcepQuincDAOImpl extends GenericDAOImpl<Tsgnomcncptoquinc, Integer> implements ConcepQuincDAO {

    @Override
    public List<Tsgnomcncptoquinc> listaConcepQuinc() {
        return findAll();
    }

    @Override
    public List<Tsgnomcncptoquinc> listaConcepQuincByEmpQuin(Integer empQuin) {
         List<Tsgnomcncptoquinc> concepQuincena = (List<Tsgnomcncptoquinc>) getSession().createQuery("FROM Tsgnomcncptoquinc "
                + "WHERE cod_empquincenaid_fk = :parametro ")
                .setParameter("parametro", empQuin).list();
        return concepQuincena;
    }
    
   
    @Override
    public List<Tsgnomcncptoquincht> listaConcepQuincByEmpQuinHT(Integer empQuin) {
         List<Tsgnomcncptoquincht> concepQuincena = (List<Tsgnomcncptoquincht>) getSession().createQuery("FROM Tsgnomcncptoquincht "
                + "WHERE codEmpquincenaidFk.codEmpquincenahtid = :parametro ")
                .setParameter("parametro", empQuin).list();
        return concepQuincena;
    }

    @Override
    public List<Tsgnomcncptoquinc> listaConceptosEmpl(Integer empleado) {
        List<Tsgnomcncptoquinc> concepQuincena = (List<Tsgnomcncptoquinc>) getSession().createQuery("FROM Tsgnomcncptoquinc "
                + "WHERE codEmpquincenaidFk.codEmpleadoidFk.codEmpleadoid = :parametro ")
                .setParameter("parametro", empleado).list();
        return concepQuincena;
    }
    
    @Override
    public List<Tsgnomcncptoquinc> listaConcepQuincByCabecera(Integer cabecera) {
         List<Tsgnomcncptoquinc> concepQuincena = (List<Tsgnomcncptoquinc>) getSession().createQuery("FROM Tsgnomcncptoquinc "
                + "WHERE codEmpquincenaidFk.codCabeceraidFk.codCabeceraid = :parametro ")
                .setParameter("parametro", cabecera).list();
        return concepQuincena;
    }
}
