/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.negocio;

import com.mbn.sinod.model.dto.InfoHistorialRhDTO;
import com.mbn.sinod.model.entidades.Tsgrhempleados;

/**
 *
 * @author Ivette
 */
public interface HistorialEmpleadosRhService extends BaseService<Tsgrhempleados,Integer>{
    
    InfoHistorialRhDTO detallesHistorialRh();
    InfoHistorialRhDTO informacionPersonal(Integer cod_empleadoid);
    
}
