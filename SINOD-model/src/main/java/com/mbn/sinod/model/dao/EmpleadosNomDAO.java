/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.dao;

import com.googlecode.genericdao.dao.hibernate.GenericDAO;
import com.mbn.sinod.model.dto.DesgloseEmpleadoDTO;
import com.mbn.sinod.model.entidades.Tsgnomempleados;
import java.util.List;

/**
 *
 * @author Ivette
 */
public interface EmpleadosNomDAO extends GenericDAO<Tsgnomempleados, Integer> {
    
     List<Tsgnomempleados> listarEmpleadosNom();
    
     /**
      * Obtiene el objeto/entidad de Tsgnomempleados por medio del id de RH
     * @param idempleadorh id del empleado en RH (empleado logueado)
      * @return 
      */
    Tsgnomempleados obtenerEmpleadonomPorIdrh(Integer idempleadorh);
    boolean guardarActualizarEmpleados(Tsgnomempleados empleado);
    Tsgnomempleados obtenerEmpleadosnomPorIdNom(Integer idempleadonom);
    List<DesgloseEmpleadoDTO> obtenerEmpleadosnomPorIdNomHT(Integer idempleadonom);
}
