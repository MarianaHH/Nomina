/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.negocio;

import com.mbn.sinod.model.comun.StaticConstantes;
import com.mbn.sinod.model.dao.EstatusNominaDAO;
import com.mbn.sinod.model.dto.EstatusNominaDTO;
import com.mbn.sinod.model.entidades.Tsgnomestatusnom;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class EstatusNominaServiceImpl extends BaseServiceImpl<Tsgnomestatusnom, Integer> implements EstatusNominaService {
    
    private static final Logger logger = Logger.getLogger(EstatusNominaService.class.getName());
    
    @Override
    public EstatusNominaDTO listarEstatusNominas() {
        EstatusNominaDTO respuesta = new EstatusNominaDTO();

        try {
            List<Tsgnomestatusnom> listaEstatusNomina
                    = ((EstatusNominaDAO) getGenericDAO()).listarEstatusNomina();

            if (listaEstatusNomina != null) {
                respuesta.setListEstatusNomina(listaEstatusNomina);
//                respuesta.setCodigoMensaje(StaticConstantes.EXITO_OBTENER_LISTA);
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_CORRECTO);
            } else {
                listaEstatusNomina = new ArrayList();
                respuesta.setListEstatusNomina(listaEstatusNomina);
//                respuesta.setCodigoMensaje(StaticConstantes.ERROR_OBTENER_LISTA);
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            }
        } catch (Exception e) {
            respuesta = new EstatusNominaDTO();
            respuesta.setCodigoMensaje(e.getMessage());
            respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            logger.getLogger(Tsgnomestatusnom.class.getName()).log(Level.SEVERE, null, e);
        }

        return respuesta;
    }    
}
