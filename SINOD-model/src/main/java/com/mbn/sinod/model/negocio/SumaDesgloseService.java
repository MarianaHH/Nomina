/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.negocio;

import com.mbn.sinod.model.dto.SumaDesgloseDTO;
import com.mbn.sinod.model.entidades.Tsgnomempquincena;
import java.io.Serializable;

/**
 *
 * @author torre
 */
public interface SumaDesgloseService extends BaseService<Tsgnomempquincena, Integer>{
    
    SumaDesgloseDTO sumaDesglose(Integer cabecera, Integer empleado);
}
