/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.negocio;

import com.mbn.sinod.model.dto.CabeceraDTO;
import com.mbn.sinod.model.dto.EmpQuincenaPorCabeceraDTO;
import com.mbn.sinod.model.entidades.Tsgnomcabecera;

/**
 *
 * @author Mi Pe
 */
public interface CabeceraService extends BaseService<Tsgnomcabecera, Integer>{
    CabeceraDTO listaCabeceras();
    CabeceraDTO guardarActualizarCabecera(CabeceraDTO cabecera);
    Tsgnomcabecera obtenerCabeceraPorId (Integer cabeceraId);
    CabeceraDTO calculaNomina(Integer cabeceraid);
    EmpQuincenaPorCabeceraDTO listarEmpleadosCabecera(Integer cabeceraId);   
    CabeceraDTO eliminarCabecera(Integer cabeceraId);
    CabeceraDTO validaPagosNomina(Integer cabecera);
    CabeceraDTO cargarImss(String archivo, Integer cabecera);
}
