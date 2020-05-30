/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.dao;

import com.googlecode.genericdao.dao.hibernate.GenericDAO;
import com.mbn.sinod.model.dto.DetalleEmpleadosDTO;
import com.mbn.sinod.model.entidades.Tsgrhempleados;
import java.util.List;

/**
 *
 * @author Ivette
 */
public interface DetalleEmpleadosDAO extends GenericDAO<Tsgrhempleados, Integer>{
    
    List<DetalleEmpleadosDTO> detallesEmpleados();
    
    /**
     * Obtiene el detalle de los empleado en nómina de acuerdo al área de trabajo dado de alta en RH
     * @param area id del área
     * @return 
     */
    List<DetalleEmpleadosDTO> empleadosPorArea(Integer area);
   
}
