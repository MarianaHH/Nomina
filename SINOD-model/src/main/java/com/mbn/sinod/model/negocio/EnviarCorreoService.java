/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.negocio;


import com.mbn.sinod.model.dto.IncidenciasQuincenaDTO;
import com.mbn.sinod.model.dto.ValidacionAltasDTO;
import com.mbn.sinod.model.dto.ValidacionBajasDTO;
import com.mbn.sinod.model.entidades.Tsgnomincidencia;

/**
 *
 * @author mariana
 */
public interface EnviarCorreoService extends BaseService<Tsgnomincidencia, Integer> {
     IncidenciasQuincenaDTO enviarCorreos(IncidenciasQuincenaDTO incidencia);
     ValidacionAltasDTO enviarCorreosValidarAltas(ValidacionAltasDTO altas);
     ValidacionBajasDTO enviarCorreosValidarBajas(ValidacionBajasDTO bajas);
}
