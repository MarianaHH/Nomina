/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.dao;

import com.googlecode.genericdao.dao.hibernate.GenericDAOImpl;
import com.mbn.sinod.model.dto.ValidacionesNomBajasDTO;
import com.mbn.sinod.model.entidades.Tsgnomempleados;
import java.util.List;
import org.hibernate.transform.Transformers;

/**
 *
 * @author Ivette
 */
public class ValidacionesNomBajasDAOImpl extends GenericDAOImpl<Tsgnomempleados,Integer>
implements ValidacionesNomBajasDAO {

    @Override
    public List<ValidacionesNomBajasDTO> detallesValidacionesNominaBajas() {
        List<ValidacionesNomBajasDTO>  detallesValidacionesNominaBajas= (List<ValidacionesNomBajasDTO>)
        getSession().createSQLQuery("select* from sgnom.bajasvalidadas()")
        .addScalar("cod_empleadoid")
        .addScalar("nom_empleado")
        .addScalar("cod_rfc")
        .addScalar("des_nbarea")
        .addScalar("des_puesto")
        .addScalar("validar")
        .addScalar("fecha_validacion")        
        .setResultTransformer(Transformers.aliasToBean(ValidacionesNomBajasDTO.class))
        .list();
        return detallesValidacionesNominaBajas;
    }
    
}
