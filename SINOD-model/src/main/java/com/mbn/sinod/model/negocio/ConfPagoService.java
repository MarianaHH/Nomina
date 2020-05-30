/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.negocio;

import com.mbn.sinod.model.dto.ConfPagoDTO;
import com.mbn.sinod.model.dto.DetalleEmpDTO;
import com.mbn.sinod.model.entidades.Tsgnomconfpago;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author eduardotorres
 */
public interface ConfPagoService extends BaseService<Tsgnomconfpago, Integer> {
    
     ConfPagoDTO guardarAutorizacionRF(ConfPagoDTO conf1);
     ConfPagoDTO guardarAutorizacionRH(ConfPagoDTO conf2);
     ConfPagoDTO guardarAutorizacionEMP(Integer empquincenaFK, Boolean conf3);
     ConfPagoDTO validarTodas(Integer cabecera);
     ConfPagoDTO validarTodasRH(Integer cabecera);
     ConfPagoDTO rechazarTodasRF(Integer cabecera);
     ConfPagoDTO rechazarTodasRH(Integer cabecera);
}
