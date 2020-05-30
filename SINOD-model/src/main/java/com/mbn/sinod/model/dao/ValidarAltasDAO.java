/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.dao;

import com.googlecode.genericdao.dao.hibernate.GenericDAO;
import com.mbn.sinod.model.dto.ValidacionAltasDTO;
import com.mbn.sinod.model.entidades.Tsgnomempleados;
import java.util.List;

/**
 *
 * @author mariana
 */
public interface ValidarAltasDAO extends GenericDAO<Tsgnomempleados,Integer> {
    List<ValidacionAltasDTO> listarAltasAValidar();
    boolean validarCadaAlta(List<ValidacionAltasDTO> listaInformacionValidar);
    boolean validarAltasAceptadas(List<ValidacionAltasDTO> listaInformacionValidar);
    boolean validarAltasRechazadas(List<ValidacionAltasDTO> listaInformacionValidar);
}
