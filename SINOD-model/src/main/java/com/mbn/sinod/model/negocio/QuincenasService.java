/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.negocio;

import com.mbn.sinod.model.dto.QuincenasDTO;
import com.mbn.sinod.model.entidades.Tsgnomquincena;

/**
 *
 * @author mipe
 */
public interface QuincenasService extends BaseService<Tsgnomquincena, Integer>{
    QuincenasDTO listQuincenas();
    QuincenasDTO listQuinFuturas();
    QuincenasDTO guardar(QuincenasDTO quincena);
    
    /**
     * Obtiene la quincena actual, 
     * @return 
     */
    QuincenasDTO quincenaActual();
}
