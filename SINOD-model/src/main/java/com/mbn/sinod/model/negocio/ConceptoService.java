/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.negocio;

import com.mbn.sinod.model.dto.ConceptoDTO;
import com.mbn.sinod.model.entidades.Tsgnomconcepto;

/**
 *
 * @author ambrosio
 */
public interface ConceptoService extends BaseService<Tsgnomconcepto, Integer>{
    ConceptoDTO listarConceptos();
    ConceptoDTO listarConceptosPercepcion();
    ConceptoDTO listarConceptosDeduccion();
    ConceptoDTO eliminarConcepto(Integer conceptoId);
    ConceptoDTO guardarConcepto(ConceptoDTO concepto);
    ConceptoDTO guardarPrioridad(ConceptoDTO concepto);
}
