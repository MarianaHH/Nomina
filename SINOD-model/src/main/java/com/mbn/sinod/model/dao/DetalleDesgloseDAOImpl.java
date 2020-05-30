/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.dao;

import com.googlecode.genericdao.dao.hibernate.GenericDAOImpl;
import com.mbn.sinod.model.dto.DetalleDesgloseDTO;
import com.mbn.sinod.model.entidades.Tsgnomcncptoquinc;
import java.util.List;
import org.hibernate.transform.Transformers;

public class DetalleDesgloseDAOImpl extends GenericDAOImpl<Tsgnomcncptoquinc, Integer>
        implements DetalleDesgloseDAO {

    @Override
    public List<DetalleDesgloseDTO> conceptosPorEmp(Integer cod_empleado, Integer cod_cabecera) {
        List<DetalleDesgloseDTO> detalleDesglose = (List<DetalleDesgloseDTO>) 
                getSession().createSQLQuery("SELECT * FROM sgnom.detalle_desglose_deduccion(?,?);")
                    .addScalar("imp_concepto")
                    .addScalar("imp_exento")
                    .addScalar("imp_gravado")
                    .addScalar("nombre")
                    .addScalar("clave")
                    .addScalar("cod_conceptoid_fk")
                .setResultTransformer(Transformers.aliasToBean(DetalleDesgloseDTO.class))
                .setInteger(0, cod_empleado)
                .setInteger(1, cod_cabecera)
                .list();
                System.out.println("SQL Desglose Deduccion bien");
                return detalleDesglose;
                
    }

}
