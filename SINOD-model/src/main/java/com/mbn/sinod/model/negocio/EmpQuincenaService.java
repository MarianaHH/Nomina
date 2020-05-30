/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.negocio;

import com.mbn.sinod.model.entidades.Tsgnomempquincena;
import com.mbn.sinod.model.dto.EmpQuincenaDTO;
import java.io.Serializable;

/**
 *
 * @author mipe
 */
public interface EmpQuincenaService extends BaseService<Tsgnomempquincena, Integer>{
    EmpQuincenaDTO listarEmpQuincena();
    
}
