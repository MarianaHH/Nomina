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
import com.mbn.sinod.model.dto.DetalleDesglosePercepcionDTO;
import com.mbn.sinod.model.entidades.Tsgnomcncptoquinc;
import java.util.List;
import org.hibernate.transform.Transformers;


public class DetalleDesglosePercepcionDAOImpl extends GenericDAOImpl<Tsgnomcncptoquinc, Integer> 
        implements DetalleDesglosePercepcionDAO {

    @Override
    public List<DetalleDesglosePercepcionDTO> percepcionesPosEmp(Integer cod_empleado, Integer cod_cabecera) {
        List<DetalleDesglosePercepcionDTO> detalleDesglosePercepcion = (List<DetalleDesglosePercepcionDTO>)
                getSession().createSQLQuery("SELECT * FROM sgnom.detalle_desglose_percepcion(?,?);")
                    .addScalar("imp_concepto")
                    .addScalar("imp_exento")
                    .addScalar("imp_gravado")
                    .addScalar("nombre")
                    .addScalar("clave")
                    .addScalar("cod_conceptoid_fk")
                .setResultTransformer(Transformers.aliasToBean(DetalleDesglosePercepcionDTO.class))
                .setInteger(0, cod_empleado)
                .setInteger(1, cod_cabecera)
                .list();
                System.out.println("SQL Desglose percepcion model");
                return detalleDesglosePercepcion;
    }

}
