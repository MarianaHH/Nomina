/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.negocio;

import com.mbn.sinod.model.comun.StaticConstantes;
import com.mbn.sinod.model.dao.CatConceptosSATDAO;
import com.mbn.sinod.model.dto.CatConceptosSATDTO;
import com.mbn.sinod.model.entidades.Tsgnomconceptosat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CatConceptosSATServiceImpl extends BaseServiceImpl<Tsgnomconceptosat, Integer> implements CatConceptosSATService {

    private static final Logger logger = Logger.getLogger(CatConceptosSATService.class.getName());

    @Override
    public CatConceptosSATDTO listarConceptosSAT() {
        CatConceptosSATDTO respuesta = new CatConceptosSATDTO();

        try {
            List<Tsgnomconceptosat> listConcepSAT
                    = ((CatConceptosSATDAO) getGenericDAO()).listarConceptosSAT();

            if (listConcepSAT != null) {
                respuesta.setListarConceptosSAT(listConcepSAT);
//                respuesta.setCodigoMensaje(StaticConstantes.EXITO_OBTENER_LISTA);
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_CORRECTO);
            } else {
                listConcepSAT = new ArrayList();
                respuesta.setListarConceptosSAT(listConcepSAT);
//                respuesta.setCodigoMensaje(StaticConstantes.ERROR_OBTENER_LISTA);
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            }
        } catch (Exception e) {
            respuesta = new CatConceptosSATDTO();
            respuesta.setCodigoMensaje(e.getMessage());
            respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            logger.getLogger(Tsgnomconceptosat.class.getName()).log(Level.SEVERE, null, e);
        }

        return respuesta;
    }

}
