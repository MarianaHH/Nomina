/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.negocio;

import com.mbn.sinod.model.dto.CatClasificadorDTO;
import com.mbn.sinod.model.entidades.Tsgnomclasificador;

/**
 *
 * @author ambrosio
 */
public interface CatClasificadorService extends BaseService<Tsgnomclasificador, Integer>{
    
    /**
     *
     * @return
     */
    CatClasificadorDTO listarCatClasificador();
}
