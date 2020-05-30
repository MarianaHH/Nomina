/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.negocio;

import com.mbn.sinod.model.dto.DetalleEmpDTO;
import com.mbn.sinod.model.dto.EmpDTO;
import com.mbn.sinod.model.entidades.Tsgrhempleados;

/**
 *
 * @author eduardotorres
 */
public interface DetalleEmpService extends BaseService<Tsgrhempleados, Integer> {
    EmpDTO empDTO (Integer cabecera);
//DetalleEmpDTO detalleEmpDTO (int empleadoId);
    
    
}
