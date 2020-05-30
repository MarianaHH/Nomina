/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.negocio;

import com.mbn.sinod.model.dto.InformacionEmpleadosDTO;
import com.mbn.sinod.model.entidades.Tsgrhempleados;

/**
 *
 * @author Ivette
 */
public interface DetalleEmpleadosService extends BaseService<Tsgrhempleados,Integer> {
    
    InformacionEmpleadosDTO detallesEmpleados();
    
    /**
     * Obtiene el detalle de los empleado en nómina de acuerdo al área/célula de trabajo dado de alta en RH
     * @param area id del área
     * @return 
     */
    InformacionEmpleadosDTO empleadosPorArea(Integer area);
}
