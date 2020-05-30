/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.dao;

import com.googlecode.genericdao.dao.hibernate.GenericDAOImpl;
import com.mbn.sinod.model.dto.DetalleEmpDTO;
import com.mbn.sinod.model.entidades.Tsgrhempleados;
import java.util.List;
import org.hibernate.transform.Transformers;


public class DetalleEmpDAOImpl extends GenericDAOImpl<Tsgrhempleados, Integer> implements DetalleEmpDAO {

    @Override
    public List<DetalleEmpDTO> empleadosPorArea(Integer cabecera) {
        System.out.println("SQL EMP va bien");
        List<DetalleEmpDTO> detalleEmp = (List<DetalleEmpDTO>)
                getSession().createSQLQuery("SELECT * FROM sgnom.buscar_detalle_emp(?);")
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
                .list();
//                System.out.println("SQL DAOImpl bien"); //comprobar si va bien el sql
                return detalleEmp;
                    
    }

}
