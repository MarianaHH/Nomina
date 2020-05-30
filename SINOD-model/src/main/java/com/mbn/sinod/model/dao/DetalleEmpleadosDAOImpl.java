/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.dao;

import com.googlecode.genericdao.dao.hibernate.GenericDAOImpl;
import com.mbn.sinod.model.dto.DetalleEmpleadosDTO;
import com.mbn.sinod.model.dto.VerInformacionDePersonalDTO;
import com.mbn.sinod.model.entidades.Tsgrhempleados;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;

/**
 *
 * @author Ivette
 */
public class DetalleEmpleadosDAOImpl extends GenericDAOImpl<Tsgrhempleados,Integer>
implements DetalleEmpleadosDAO{

    @Override
    public List<DetalleEmpleadosDTO> detallesEmpleados() {
        List<DetalleEmpleadosDTO> detallesEmpleados= (List<DetalleEmpleadosDTO>)
        getSession().createSQLQuery("select * from sgnom.detallespersonal()")
        .addScalar("codempleado")
        .addScalar("nomcompleto")
        .addScalar("desrfc")
        .addScalar("descurp")
        .addScalar("desnbarea")
        .addScalar("despuesto")
        .setResultTransformer(Transformers.aliasToBean(DetalleEmpleadosDTO.class))
        .list();
        return detallesEmpleados;
        
    }

    @Override
    public List<DetalleEmpleadosDTO> empleadosPorArea(Integer area) {
        List<DetalleEmpleadosDTO> detallesEmpleados= (List<DetalleEmpleadosDTO>)
        getSession().createSQLQuery("SELECT * FROM sgnom.detallespersonal() WHERE codempleado IN (SELECT * FROM sgnom.empleadosnom_por_area(?))")
        .addScalar("codempleado")
        .addScalar("nomcompleto")
        .addScalar("desrfc")
        .addScalar("descurp")
        .addScalar("desnbarea")
        .addScalar("despuesto")
        .setResultTransformer(Transformers.aliasToBean(DetalleEmpleadosDTO.class))
        .setInteger(0, area)
        .list();
        return detallesEmpleados;
    }
}
