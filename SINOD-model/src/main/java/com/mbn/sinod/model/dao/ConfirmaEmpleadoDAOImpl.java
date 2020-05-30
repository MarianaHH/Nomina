/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.dao;

import com.googlecode.genericdao.dao.hibernate.GenericDAOImpl;
import com.googlecode.genericdao.search.ExampleOptions;
import com.googlecode.genericdao.search.Filter;
import com.googlecode.genericdao.search.ISearch;
import com.googlecode.genericdao.search.SearchResult;
import com.mbn.sinod.model.dto.DetalleEmpDTO;
import com.mbn.sinod.model.dto.EmpDTO;
import com.mbn.sinod.model.entidades.Tsgnomconfpago;
import java.util.List;
import org.hibernate.transform.Transformers;


public class ConfirmaEmpleadoDAOImpl extends GenericDAOImpl<Tsgnomconfpago, Integer> 
        implements ConfirmaEmpleadoDAO {

    @Override
    public List<DetalleEmpDTO> ConfiPAgo(Integer cabecera, Integer empleado) {
        List<DetalleEmpDTO> confirmaEmpleado = (List<DetalleEmpDTO>)
                getSession().createSQLQuery("SELECT * FROM sgnom.empleado_confpago(?,?);")
                .addScalar("codempleado")
                    .addScalar("despuesto")
                    .addScalar("nomcompleto")
                    .addScalar("desnbarea")
                    .addScalar("codempqui")
                    .addScalar("bol_pagorh")
                    .addScalar("bol_pagofinanzas")
                    .addScalar("bol_pagoempleado")
                    .addScalar("monto")
                .setResultTransformer(Transformers.aliasToBean(DetalleEmpDTO.class))
                .setInteger(0, cabecera)
                .setInteger(1, empleado)
                .list();
//                System.out.println("SQL. Cabecera ConfPago es: "+ cabecera); //comprobar si va bien el sql
//                System.out.println("SQL. IdEmpleado ConfPago es: "+ empleado); //comprobar si va bien el sql
                return confirmaEmpleado;
    }
    
}
