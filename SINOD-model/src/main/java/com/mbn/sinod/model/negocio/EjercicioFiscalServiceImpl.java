/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.negocio;

import com.mbn.sinod.model.comun.StaticConstantes;
import com.mbn.sinod.model.dao.EjercicioFiscalDAO;
import com.mbn.sinod.model.dto.EjercicioFiscalDTO;
import com.mbn.sinod.model.entidades.Tsgnomejercicio;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class EjercicioFiscalServiceImpl extends BaseServiceImpl<Tsgnomejercicio, Integer>
        implements EjercicioFiscalService {
    
        private static final Logger logger = Logger.getLogger(EjercicioFiscalService.class.getName());

    @Override
    public EjercicioFiscalDTO listaEjercicios() {
        EjercicioFiscalDTO respuesta = new EjercicioFiscalDTO();

        try {
            List<Tsgnomejercicio> listaEjercicioFiscal
                    = ((EjercicioFiscalDAO) getGenericDAO()).listaEjercicios();

            if (listaEjercicioFiscal != null) {
                respuesta.setListaEjercicios(listaEjercicioFiscal);
//                respuesta.setCodigoMensaje(StaticConstantes.EXITO_OBTENER_LISTA);
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_CORRECTO);
            } else {
                listaEjercicioFiscal = new ArrayList();
                respuesta.setListaEjercicios(listaEjercicioFiscal);
//                respuesta.setCodigoMensaje(StaticConstantes.ERROR_OBTENER_LISTA);
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            }
        } catch (Exception e) {
            respuesta = new EjercicioFiscalDTO();
            respuesta.setCodigoMensaje(e.getMessage());
            respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            logger.getLogger(Tsgnomejercicio.class.getName()).log(Level.SEVERE, null, e);
        }

        return respuesta;
    }

    
    
}
