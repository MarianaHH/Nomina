/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.negocio;

import com.mbn.sinod.model.dto.IncidenciasDTO;
import com.mbn.sinod.model.entidades.Tsgnomincidencia;
import java.util.List;

/**
 *
 * @author Karla
 */
public interface IncidenciasService extends BaseService<Tsgnomincidencia, Integer> {
    
    List<Tsgnomincidencia> listarIncidencias();
}
