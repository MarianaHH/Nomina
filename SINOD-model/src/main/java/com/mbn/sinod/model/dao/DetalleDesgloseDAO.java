/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.dao;

import com.googlecode.genericdao.dao.hibernate.GenericDAO;
import com.mbn.sinod.model.dto.DetalleDesgloseDTO;
import com.mbn.sinod.model.entidades.Tsgnomcncptoquinc;
import java.util.List;
/**
 *
 * @author eduardotorres
 */
public interface DetalleDesgloseDAO extends GenericDAO<Tsgnomcncptoquinc, Integer>{
    
    List<DetalleDesgloseDTO> conceptosPorEmp (Integer cod_empleado, Integer cod_cabecera);
    
}
