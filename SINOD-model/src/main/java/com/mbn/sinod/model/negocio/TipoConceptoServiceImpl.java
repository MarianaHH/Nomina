/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.negocio;

import com.mbn.sinod.model.comun.StaticConstantes;
import com.mbn.sinod.model.dao.TipoConceptoDAO;
import com.mbn.sinod.model.dto.TipoConceptoDTO;
import com.mbn.sinod.model.entidades.Tsgnomtipoconcepto;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class TipoConceptoServiceImpl extends BaseServiceImpl<Tsgnomtipoconcepto, Integer> implements TipoConceptoService {
    private static final Logger logger = Logger.getLogger(TipoConceptoService.class.getName());
    @Override
    public TipoConceptoDTO listarTiposConceptos() {
        TipoConceptoDTO respuesta = new TipoConceptoDTO();

        try {
            List<Tsgnomtipoconcepto> listTipoConcep
                    = ((TipoConceptoDAO) getGenericDAO()).listarTiposConceptos();

            if (listTipoConcep != null) {
                respuesta.setListarTiposConcepto(listTipoConcep);
//                respuesta.setCodigoMensaje(StaticConstantes.EXITO_OBTENER_LISTA);
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_CORRECTO);
            } else {
                listTipoConcep = new ArrayList();
                respuesta.setListarTiposConcepto(listTipoConcep);
//                respuesta.setCodigoMensaje(StaticConstantes.ERROR_OBTENER_LISTA);
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            }
        } catch (Exception e) {
            respuesta = new TipoConceptoDTO();
            respuesta.setCodigoMensaje(e.getMessage());
            respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            logger.getLogger(Tsgnomtipoconcepto.class.getName()).log(Level.SEVERE, null, e);
        }

        return respuesta;
    }
    
}
