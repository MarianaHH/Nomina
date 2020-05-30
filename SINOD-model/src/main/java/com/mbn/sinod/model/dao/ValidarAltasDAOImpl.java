/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.dao;

import com.googlecode.genericdao.dao.hibernate.GenericDAOImpl;
import com.mbn.sinod.model.dto.ValidacionAltasDTO;
import com.mbn.sinod.model.entidades.Tsgnomempleados;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;

/**
 *
 * @author mariana
 */
public class ValidarAltasDAOImpl extends GenericDAOImpl<Tsgnomempleados, Integer> implements ValidarAltasDAO {

    @Override
    public List<ValidacionAltasDTO> listarAltasAValidar() {
       List<ValidacionAltasDTO> listarAltasAValidar = (List<ValidacionAltasDTO>) getSession().createSQLQuery("select * from sgnom.validaraltas();")
                .addScalar("cod_empleadoid")
                .addScalar("nom_empleado")
                .addScalar("cod_rfc")
                .addScalar("cod_curp")
                .addScalar("des_nbarea")
                .addScalar("des_puesto")
                .addScalar("validar")
                .setResultTransformer(Transformers.aliasToBean(ValidacionAltasDTO.class)) //especificamos que los parametros se van a transformar en un DTO que especifiquemos

                .list();

        return listarAltasAValidar;
    }
    
    @Override
    public boolean validarCadaAlta(List<ValidacionAltasDTO> listaInformacionValidar) {
        int contador = 0;
        boolean respuesta = false;

        for (int i = 0; i < listaInformacionValidar.size(); i++) {
            StringBuilder sb = new StringBuilder("UPDATE sgnom.tsgnomempleados  SET des_validacion = :estatus,cod_validaciones = :validacion,aud_fecvalidacion = CURRENT_DATE WHERE cod_empleadoid = :id");
            
            Query sql = getSession().createSQLQuery(sb.toString());
            sql.setParameter("estatus", listaInformacionValidar.get(i).getValidar());
            sql.setParameter("validacion", listaInformacionValidar.get(i).getValidacion());
            sql.setParameter("id", listaInformacionValidar.get(i).getCod_empleadoid());
            sql.executeUpdate();

            contador++;

            if (listaInformacionValidar.size() == contador) {
                respuesta = true;
            }
        }

        return respuesta;
    }

    @Override
    public boolean validarAltasAceptadas(List<ValidacionAltasDTO> listaInformacionValidar) {
        int contador = 0;
        boolean respuesta = false;

        for (int i = 0; i < listaInformacionValidar.size(); i++) {
            StringBuilder sb = new StringBuilder("UPDATE sgnom.tsgnomempleados  SET des_validacion = true,cod_validaciones = 'a',aud_fecvalidacion = CURRENT_DATE WHERE cod_empleadoid = :id");

            Query sql = getSession().createSQLQuery(sb.toString());
            sql.setParameter("id", listaInformacionValidar.get(i).getCod_empleadoid());
            sql.executeUpdate();

            contador++;

            if (listaInformacionValidar.size() == contador) {
                respuesta = true;
            }
        }

        return respuesta;
    }

    @Override
    public boolean validarAltasRechazadas(List<ValidacionAltasDTO> listaInformacionValidar) {
        int contador = 0;
        boolean respuesta = false;

        for (int i = 0; i < listaInformacionValidar.size(); i++) {
            StringBuilder sb = new StringBuilder("UPDATE sgnom.tsgnomempleados  SET des_validacion = false,cod_validaciones = 'b',aud_fecvalidacion = CURRENT_DATE WHERE cod_empleadoid = :id");

            Query sql = getSession().createSQLQuery(sb.toString());
            sql.setParameter("id", listaInformacionValidar.get(i).getCod_empleadoid());
            sql.executeUpdate();

            contador++;

            if (listaInformacionValidar.size() == contador) {
                respuesta = true;
            }
        }

        return respuesta;
    }
    
    
}
