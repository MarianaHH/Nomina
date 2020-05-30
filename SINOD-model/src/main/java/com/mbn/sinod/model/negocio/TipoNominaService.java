/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.negocio;

import com.mbn.sinod.model.dto.TipoNominaDTO;
import com.mbn.sinod.model.entidades.Tsgnomtiponomina;

/**
 *
 * @author ambrosio
 */
public interface TipoNominaService extends BaseService<Tsgnomtiponomina, Integer>{
    TipoNominaDTO listaTipoNomina();
}
