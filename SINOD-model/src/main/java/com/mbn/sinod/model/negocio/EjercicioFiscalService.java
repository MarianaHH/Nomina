/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.negocio;

import com.mbn.sinod.model.dto.EjercicioFiscalDTO;
import com.mbn.sinod.model.entidades.Tsgnomejercicio;

/**
 *
 * @author mipe
 */
public interface EjercicioFiscalService extends BaseService<Tsgnomejercicio, Integer>{
    
    EjercicioFiscalDTO listaEjercicios();
    
}
