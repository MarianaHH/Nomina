/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.dao;

import com.googlecode.genericdao.dao.hibernate.GenericDAO;
import com.mbn.sinod.model.dto.DetalleEmpDTO;
import com.mbn.sinod.model.entidades.Tsgnomconfpago;
import java.util.List;

/**
 *
 * @author eduardotorres
 */
public interface ConfPagoDAO extends GenericDAO<Tsgnomconfpago, Integer> {
    
     boolean guardarAutorizacionRF(List<Tsgnomconfpago> conf1);
     boolean guardarAutorizacionRH(List<Tsgnomconfpago> conf2);
     boolean guardarAutorizacionEMP(Integer empquincenaFK, Boolean conf3);
     boolean validarTodas(Integer cabecera);
     boolean validarTodasRH(Integer cabecera);
     boolean rechazarTodasRF(Integer cabecera);
     boolean rechazarTodasRH(Integer cabecera);
}
