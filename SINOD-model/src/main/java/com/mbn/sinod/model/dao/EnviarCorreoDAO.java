/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.dao;

import com.googlecode.genericdao.dao.hibernate.GenericDAO;

import com.mbn.sinod.model.dto.IncidenciasQuincenaDTO;
import com.mbn.sinod.model.dto.ValidacionAltasDTO;
import com.mbn.sinod.model.dto.ValidacionBajasDTO;
import com.mbn.sinod.model.entidades.Tsgnomincidencia;
import java.util.List;

/**
 *
 * @author mariana
 */
public interface EnviarCorreoDAO extends GenericDAO<Tsgnomincidencia,Integer>{
    
    boolean enviarCorreos(List<IncidenciasQuincenaDTO> incidencias);
    boolean enviarCorreosValidacionAltas(List<ValidacionAltasDTO> altas);
    boolean enviarCorreosValidacionBajas(List<ValidacionBajasDTO> bajas);
    
}
