/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.negocio;

import com.mbn.sinod.model.comun.StaticConstantes;
import com.mbn.sinod.model.dao.CatClasificadorDAO;
import com.mbn.sinod.model.dto.CatClasificadorDTO;
import com.mbn.sinod.model.entidades.Tsgnomclasificador;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class CatClasificadorServiceImpl extends BaseServiceImpl<Tsgnomclasificador, Integer> implements CatClasificadorService {
    
    private static final Logger logger = Logger.getLogger(CatClasificadorService.class.getName());
    
    @Override
    public CatClasificadorDTO listarCatClasificador() {
        CatClasificadorDTO respuesta = new CatClasificadorDTO();
        
        try {
            List<Tsgnomclasificador> listCatClasifi
                    = ((CatClasificadorDAO) getGenericDAO()).listarCatClasificador();

            if (listCatClasifi != null) {
                respuesta.setListaCatClasificadores(listCatClasifi);
//                respuesta.setCodigoMensaje(StaticConstantes.EXITO_OBTENER_LISTA);
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_CORRECTO);
            } else {
                listCatClasifi = new ArrayList();
                respuesta.setListaCatClasificadores(listCatClasifi);
//                respuesta.setCodigoMensaje(StaticConstantes.ERROR_OBTENER_LISTA);
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            }
        } catch (Exception e) {
            respuesta = new CatClasificadorDTO();
            respuesta.setCodigoMensaje(e.getMessage());
            respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            logger.getLogger(Tsgnomclasificador.class.getName()).log(Level.SEVERE, null, e);
        }

        return respuesta;
    }
}
