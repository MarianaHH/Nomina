/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.negocio;

import com.mbn.sinod.model.dto.InfoValidacionesNominaDTO;
import com.mbn.sinod.model.entidades.Tsgnomempleados;


/**
 *
 * @author Ivette
 */
public interface ValidacionesNominaService extends BaseService<Tsgnomempleados,Integer> {
    
     InfoValidacionesNominaDTO detallesValidacionesNomina();
    
}
