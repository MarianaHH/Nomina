/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.dao;

import com.googlecode.genericdao.dao.hibernate.GenericDAOImpl;
import com.mbn.sinod.model.dto.ValidacionesNominaDTO;
import com.mbn.sinod.model.entidades.Tsgnomempleados;
import java.util.List;
import org.hibernate.transform.Transformers;


/**
 *
 * @author Ivette
 */
public class ValidacionesNominaDAOImpl extends GenericDAOImpl<Tsgnomempleados,Integer>
implements ValidacionesNominaDAO {

    @Override
    public List<ValidacionesNominaDTO> detallesValidacionesNomina() {
        List<ValidacionesNominaDTO> detallesValidacionesNomina= (List<ValidacionesNominaDTO>)
        getSession().createSQLQuery("select* from sgnom.altasvalidadas()")
        .addScalar("cod_empleadoid")
        .addScalar("nom_empleado")
        .addScalar("cod_rfc")
        .addScalar("cod_curp")
        .addScalar("des_nbarea")
        .addScalar("des_puesto")
        .addScalar("validar")
        .addScalar("fecha_validacion")        
        .setResultTransformer(Transformers.aliasToBean(ValidacionesNominaDTO.class))
        .list();
        return detallesValidacionesNomina;
    }

   
}
