/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.dao;

import com.googlecode.genericdao.dao.hibernate.GenericDAOImpl;
import com.mbn.sinod.model.dto.VerInformacionDePersonalDTO;
import com.mbn.sinod.model.entidades.Tsgrhempleados;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;

/**
 *
 * @author Ivette
 */
public class VerInformacionDePersonalDAOImpl extends GenericDAOImpl<Tsgrhempleados,Integer>
implements VerInformacionDePersonalDAO {

    @Override
    public List<VerInformacionDePersonalDTO> informacionPorPersonal(Integer cod_empleadoid) {
        
        List<VerInformacionDePersonalDTO> informacionPersonal= (List<VerInformacionDePersonalDTO>)
                getSession().createSQLQuery("select* from sgnom.verinformaciondepersonal(?);")
                .addScalar("cod_empleado")
                .addScalar("fec_ingreso")
                .addScalar("fec_modificacion")       
                .addScalar("des_nombre")
                .addScalar("des_apepaterno")
                .addScalar("des_apematerno")
                .addScalar("des_nbarea")
                .addScalar("des_puesto")
                .addScalar("des_rol")        
                .addScalar("cod_rfc")
                .addScalar("cod_curp")
                .addScalar("cod_nss")
                .addScalar("fec_nacimiento")
                .addScalar("des_direccion")
                .addScalar("des_correo")
                .addScalar("correo_personal")
                .addScalar("cod_tipoaguinaldo")
                .addScalar("imp_aguinaldo")
                .addScalar("quincena")
                .setResultTransformer(Transformers.aliasToBean(VerInformacionDePersonalDTO.class))
                .setInteger(0,cod_empleadoid)
                .list();
        return informacionPersonal;
    }

}
