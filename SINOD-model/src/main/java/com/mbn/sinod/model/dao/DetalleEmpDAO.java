/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.dao;

import com.googlecode.genericdao.dao.hibernate.GenericDAO;
import com.mbn.sinod.model.dto.DetalleEmpDTO;
import com.mbn.sinod.model.entidades.Tsgrhempleados;
import java.util.List;

/**
 *
 * @author eduardotorres
 */
public interface DetalleEmpDAO extends GenericDAO<Tsgrhempleados, Integer> {
    
    List<DetalleEmpDTO> empleadosPorArea (Integer cabecera);
//    boolean validarPagosRF(List<DetalleEmpDTO> lista);
    
//    void aumentarEmpleado(DetalleEmpDTO detalleEmp);
    
}
