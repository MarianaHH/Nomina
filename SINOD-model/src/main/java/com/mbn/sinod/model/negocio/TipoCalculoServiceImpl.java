/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.negocio;

import com.mbn.sinod.model.comun.StaticConstantes;
import com.mbn.sinod.model.dao.TipoCalculoDAO;
import com.mbn.sinod.model.dto.TipoCalculoDTO;
import com.mbn.sinod.model.entidades.Tsgnomcalculo;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class TipoCalculoServiceImpl extends BaseServiceImpl<Tsgnomcalculo, Integer> implements TipoCalculoService {
    private static final Logger logger = Logger.getLogger(TipoCalculoService.class.getName());
    @Override
    public TipoCalculoDTO listarTiposCalculo() {
        TipoCalculoDTO respuesta = new TipoCalculoDTO();

        try {
            List<Tsgnomcalculo> listTipoCalculo
                    = ((TipoCalculoDAO) getGenericDAO()).listarTiposCalculo();

            if (listTipoCalculo != null) {
                respuesta.setListarTiposCalculo(listTipoCalculo);
//                respuesta.setCodigoMensaje(StaticConstantes.EXITO_OBTENER_LISTA);
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_CORRECTO);
            } else {
                listTipoCalculo = new ArrayList();
                respuesta.setListarTiposCalculo(listTipoCalculo);
//                respuesta.setCodigoMensaje(StaticConstantes.ERROR_OBTENER_LISTA);
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            }
        } catch (Exception e) {
            respuesta = new TipoCalculoDTO();
            respuesta.setCodigoMensaje(e.getMessage());
            respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            logger.getLogger(Tsgnomcalculo.class.getName()).log(Level.SEVERE, null, e);
        }

        return respuesta;
    }

}
