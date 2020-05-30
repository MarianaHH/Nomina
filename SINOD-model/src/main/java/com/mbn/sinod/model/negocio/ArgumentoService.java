/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.negocio;

import com.mbn.sinod.model.dto.ArgumentoDTO;
import com.mbn.sinod.model.entidades.Tsgnomargumento;


/**
 *
 * @author mariana
 */
public interface ArgumentoService  extends BaseService<Tsgnomargumento, Integer> {
    ArgumentoDTO listarArgumentos();
    
    ArgumentoDTO listarArgumentosConstantes();
    
    ArgumentoDTO listarArgumentosVariables();
    
    ArgumentoDTO guardar(ArgumentoDTO argumento);
    
    ArgumentoDTO eliminarArgumento(Integer argumentoId);
    
    
}
