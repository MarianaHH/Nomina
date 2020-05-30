/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.dao;

import com.googlecode.genericdao.dao.hibernate.GenericDAO;
import com.mbn.sinod.model.dto.ValidacionBajasDTO;
import com.mbn.sinod.model.entidades.Tsgnomempleados;
import java.util.List;

/**
 *
 * @author Ivette
 */
public interface ValidarBajasDAO extends GenericDAO<Tsgnomempleados,Integer> {
    
    List<ValidacionBajasDTO> listarBajasAValidar();
    boolean validarCadaBaja(List<ValidacionBajasDTO> listaInformacionValidar);
    boolean validarBajasAceptadas(List<ValidacionBajasDTO> listaInformacionValidar);
    boolean validarBajasRechazadas(List<ValidacionBajasDTO> listaInformacionValidar);
   }
