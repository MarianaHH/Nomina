/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.dao;

import com.googlecode.genericdao.dao.hibernate.GenericDAO;
import com.mbn.sinod.model.dto.VerInformacionDePersonalDTO;
import com.mbn.sinod.model.entidades.Tsgrhempleados;
import java.util.List;

/**
 *
 * @author Ivette
 */
public interface VerInformacionDePersonalDAO extends GenericDAO<Tsgrhempleados, Integer>{
    
    List<VerInformacionDePersonalDTO> informacionPorPersonal(Integer cod_empleadoid);
    
    
}
