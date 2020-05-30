/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.negocio;

import com.mbn.sinod.model.dto.TipoCalculoDTO;
import com.mbn.sinod.model.entidades.Tsgnomcalculo;

/**
 *
 * @author ambrosio
 */
public interface TipoCalculoService extends BaseService<Tsgnomcalculo, Integer>{

    /**
     *
     * @return
     */
    TipoCalculoDTO listarTiposCalculo();
}
