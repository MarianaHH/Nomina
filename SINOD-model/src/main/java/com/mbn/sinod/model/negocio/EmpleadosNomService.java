/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.negocio;

import com.mbn.sinod.model.dto.DesgloseEmpleadoDTO;
import com.mbn.sinod.model.dto.EmpleadosNomDTO;
import com.mbn.sinod.model.entidades.Tsgnomempleados;
import java.util.List;

/**
 *
 * @author Ivette
 */
public interface EmpleadosNomService extends BaseService<Tsgnomempleados, Integer>{
    List<Tsgnomempleados> listarEmpleadosNom();
    
    /**
     * Obtiene el objeto del empleado de nómina por medio del id del empleado en RH
     * @param idempleadorh id del empleado en RH (empleado logueado)
     * @return 
     */
    Tsgnomempleados obtenerEmpleadonomPorIdrh(Integer idempleadorh);
    EmpleadosNomDTO guardar(EmpleadosNomDTO empleado);
    Tsgnomempleados obtenerEmpleadosnomPorIdNom(Integer idempleadonom);
    DesgloseEmpleadoDTO obtenerEmpleadosnomPorIdNomHT(Integer idempleadonom);
    
}
