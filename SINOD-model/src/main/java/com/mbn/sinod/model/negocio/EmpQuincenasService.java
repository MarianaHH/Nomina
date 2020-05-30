/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.negocio;

import com.mbn.sinod.model.dto.EmpQuincenasDTO;
import com.mbn.sinod.model.entidades.Tsgnomempquincena;

/**
 *
 * @author ambrosio
 */
public interface EmpQuincenasService 
        extends BaseService<Tsgnomempquincena, Integer>{
    
    EmpQuincenasDTO listaEmpQuincenas();
    EmpQuincenasDTO listaEmpQuincenas(Integer cabeceraid_fk);
    EmpQuincenasDTO insertaEmpleadosQuincena(Integer cabeceraid_fk);
}
