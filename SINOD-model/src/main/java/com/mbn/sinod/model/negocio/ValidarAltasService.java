/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.negocio;

import com.mbn.sinod.model.dto.ValidacionAltasDTO;
import com.mbn.sinod.model.entidades.Tsgnomempleados;

/**
 *
 * @author mariana
 */
public interface ValidarAltasService extends BaseService<Tsgnomempleados, Integer >{
   ValidacionAltasDTO listarAltasAValidar();
   ValidacionAltasDTO validarCadaAlta(ValidacionAltasDTO altas);
   ValidacionAltasDTO validarAltasAceptadas(ValidacionAltasDTO altas);
   ValidacionAltasDTO validarAltasRechazadas(ValidacionAltasDTO altas);
}
