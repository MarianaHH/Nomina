/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.dao;

import com.googlecode.genericdao.dao.hibernate.GenericDAOImpl;
import com.googlecode.genericdao.search.Search;
import com.mbn.sinod.model.dto.DesgloseEmpleadoDTO;
import com.mbn.sinod.model.entidades.Tsgnomempleados;
import java.util.List;
import org.hibernate.transform.Transformers;

/**
 *
 * @author Ivette
 */
public class EmpleadosNomDAOImpl extends GenericDAOImpl<Tsgnomempleados, Integer> implements EmpleadosNomDAO {

    @Override
    public List<Tsgnomempleados> listarEmpleadosNom() {
        return findAll();
    }

    @Override
    public Tsgnomempleados obtenerEmpleadonomPorIdrh(Integer idempleadorh) {
        Search search = new Search();
        search.addFilterEqual("codEmpleadoFk", idempleadorh);
        return searchUnique(search);
    }

    @Override
    public boolean guardarActualizarEmpleados(Tsgnomempleados empleado) {
        try {
            _saveOrUpdate(empleado);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Tsgnomempleados obtenerEmpleadosnomPorIdNom(Integer idempleadonom) {
        Search search = new Search();
        search.addFilterEqual("codEmpleadoid", idempleadonom);
        return searchUnique(search);
    }

    @Override
    public List<DesgloseEmpleadoDTO> obtenerEmpleadosnomPorIdNomHT(Integer idempleadonom) {
//        Search search = new Search();
//        search.addFilterEqual("codEmpleadoid", idempleadonom);
//        return searchUnique(search);

//         Query query = getSession().createSQLQuery("SELECT xml_historial::text "
//                + "FROM sgnom.tsgnomempleados "
//                + "WHERE cod_empleadoid = ? ")
//                .setInteger(0, idempleadonom);
//        return query.uniqueResult().toString();
        List<DesgloseEmpleadoDTO> dTO = (List<DesgloseEmpleadoDTO>)
        getSession().createSQLQuery("SELECT * FROM sgnom.historialempleado(?); ")
                .addScalar("fecha")
                .addScalar("sueldoimss")
                .addScalar("sueldohono")
                .addScalar("estatus")
                .setResultTransformer(Transformers.aliasToBean(DesgloseEmpleadoDTO.class))
                .setInteger(0, idempleadonom)
                .list();
        return dTO;
    }
}
