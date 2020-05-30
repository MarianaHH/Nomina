/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.negocio;

import com.mbn.sinod.model.dto.DesgloseDTO;
import com.mbn.sinod.model.entidades.Tsgnomcncptoquinc;
/**
 *
 * @author eduardotorres
 */
public interface DetalleDesgloseService extends BaseService<Tsgnomcncptoquinc, Integer> {
    
    DesgloseDTO desgloseDTO (Integer cod_empleado, Integer cod_cabecera);
    
}
