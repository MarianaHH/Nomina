/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.negocio;

import com.mbn.sinod.model.dto.EstatusNominaDTO;
import com.mbn.sinod.model.entidades.Tsgnomestatusnom;
import java.io.Serializable;

/**
 *
 * @author User
 */
public interface EstatusNominaService extends BaseService<Tsgnomestatusnom, Integer>{
    EstatusNominaDTO listarEstatusNominas();
}
