/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.negocio;

import com.mbn.sinod.model.dto.ValidacionBajasDTO;
import com.mbn.sinod.model.entidades.Tsgnomempleados;

/**
 *
 * @author Ivette
 */
public interface ValidarBajasService extends BaseService<Tsgnomempleados, Integer >{
    
   ValidacionBajasDTO listarBajasAValidar();
   ValidacionBajasDTO validarCadaBaja(ValidacionBajasDTO bajas);
   ValidacionBajasDTO validarBajasAceptadas(ValidacionBajasDTO bajas);
   ValidacionBajasDTO validarBajasRechazadas(ValidacionBajasDTO bajas);
  
}
