/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.negocio;

import com.mbn.sinod.model.comun.StaticConstantes;
import com.mbn.sinod.model.dao.TipoNominaDAO;
import com.mbn.sinod.model.dto.TipoNominaDTO;
import com.mbn.sinod.model.dto.TipoNominaDTO;
import com.mbn.sinod.model.entidades.Tsgnomtiponomina;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class TipoNominaServiceImpl extends BaseServiceImpl<Tsgnomtiponomina, Integer> implements TipoNominaService {
    private static final Logger logger = Logger.getLogger(TipoNominaService.class.getName());
    @Override
    public TipoNominaDTO listaTipoNomina() {
        TipoNominaDTO respuesta = new TipoNominaDTO();

        try {
            List<Tsgnomtiponomina> listTipoNomina
                    = ((TipoNominaDAO) getGenericDAO()).listarTiposConceptos();

            if (listTipoNomina != null) {
                respuesta.setListaTipoNomina(listTipoNomina);
//                respuesta.setCodigoMensaje(StaticConstantes.EXITO_OBTENER_LISTA);
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_CORRECTO);
            } else {
                listTipoNomina = new ArrayList();
                respuesta.setListaTipoNomina(listTipoNomina);
//                respuesta.setCodigoMensaje(StaticConstantes.ERROR_OBTENER_LISTA);
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            }
        } catch (Exception e) {
            respuesta = new TipoNominaDTO();
            respuesta.setCodigoMensaje(e.getMessage());
            respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            logger.getLogger(Tsgnomtiponomina.class.getName()).log(Level.SEVERE, null, e);
        }

        return respuesta;
    }
}
