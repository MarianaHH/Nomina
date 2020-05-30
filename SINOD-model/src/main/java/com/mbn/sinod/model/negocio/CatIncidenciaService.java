/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.negocio;

import com.mbn.sinod.model.dto.CatIncidenciaDTO;
import com.mbn.sinod.model.entidades.Tsgnomcatincidencia;

/**
 *
 * @author ambrosio
 */
public interface CatIncidenciaService extends BaseService<Tsgnomcatincidencia, Integer>{

    /**
     *
     * @return
     */
    CatIncidenciaDTO listarCatIncidencias();
    
    /**
     *
     * @param catIncidencia
     * @return
     */
    CatIncidenciaDTO guardarActualizarCatInci(CatIncidenciaDTO catIncidencia);
    
    /**
     *
     * @param id
     * @return
     */
    CatIncidenciaDTO eliminarCatIncidenciasId(Integer id);
}


