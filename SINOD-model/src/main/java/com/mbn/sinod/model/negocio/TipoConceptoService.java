/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.negocio;

import com.mbn.sinod.model.dto.TipoConceptoDTO;
import com.mbn.sinod.model.entidades.Tsgnomtipoconcepto;

/**
 *
 * @author ambrosio
 */
public interface TipoConceptoService extends BaseService<Tsgnomtipoconcepto, Integer>{

    /**
     *
     * @return
     */
    TipoConceptoDTO listarTiposConceptos();
}
