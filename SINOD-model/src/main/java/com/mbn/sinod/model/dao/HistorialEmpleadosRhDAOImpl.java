/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.dao;

import com.googlecode.genericdao.dao.hibernate.GenericDAOImpl;
import com.mbn.sinod.model.dto.HistorialEmpleadosRhDTO;
import com.mbn.sinod.model.entidades.Tsgrhempleados;
import java.util.List;
import org.hibernate.transform.Transformers;

/**
 *
 * @author Ivette
 */
public class HistorialEmpleadosRhDAOImpl extends GenericDAOImpl<Tsgrhempleados,Integer>
implements HistorialEmpleadosRhDAO{

    @Override
    public List<HistorialEmpleadosRhDTO> detallesHistorialRh() {
        List<HistorialEmpleadosRhDTO> detallesHistorialRh= (List<HistorialEmpleadosRhDTO>)
        getSession().createSQLQuery("select * from sgnom.historialdatos")
        .addScalar("cod_empleadoid")
        .addScalar("nom_empleado")
        .addScalar("des_nbarea")
        .addScalar("des_puesto")
        .addScalar("sueldo")
        .addScalar("fec_ingreso")        
        .setResultTransformer(Transformers.aliasToBean(HistorialEmpleadosRhDTO.class))
        .list();
        return detallesHistorialRh;
    }

    @Override
    public List<HistorialEmpleadosRhDTO> informacionEmpleado(Integer cod_empleadoid) {
        
         List<HistorialEmpleadosRhDTO> informacionPersonal= (List<HistorialEmpleadosRhDTO>)
                getSession().createSQLQuery("select* from sgnom.historialquincenasemp(?);")
                .addScalar("cod_empleado")
                .addScalar("fecha_ingreso")
                .addScalar("nom_empleado")
                .addScalar("des_nbarea")
                .addScalar("des_puesto")
                .addScalar("des_quincena") 
                .addScalar("fec_inicio")   
                .addScalar("fec_fin")      
                .addScalar("fec_pago")   
                .addScalar("imp_concepto")
                .addScalar("quincena")         
                .setResultTransformer(Transformers.aliasToBean(HistorialEmpleadosRhDTO.class))
                .setInteger(0,cod_empleadoid)
                .list();
         return informacionPersonal;
    }
    
}
