/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.negocio;

import com.mbn.sinod.model.comun.StaticConstantes;
import com.mbn.sinod.model.entidades.Tsgnomcatincidencia;
import java.util.List;
import com.mbn.sinod.model.dao.CatIncidenciaDAO;
import com.mbn.sinod.model.dto.CatIncidenciaDTO;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.transaction.annotation.Transactional;

public class CatIncidenciaServiceImpl extends BaseServiceImpl<Tsgnomcatincidencia, Integer>
        implements CatIncidenciaService {

    private static final Logger logger = Logger.getLogger(CatIncidenciaService.class.getName());

    @Override
    public CatIncidenciaDTO listarCatIncidencias() {
        CatIncidenciaDTO respuesta = new CatIncidenciaDTO();

        try {
            List<Tsgnomcatincidencia> listCatInci
                    = ((CatIncidenciaDAO) getGenericDAO()).listarCatIncidencias();

            if (listCatInci != null) {
                respuesta.setListarCatIncidencias(listCatInci);
//                respuesta.setCodigoMensaje(StaticConstantes.EXITO_OBTENER_LISTA);
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_CORRECTO);
            } else {
                listCatInci = new ArrayList();
                respuesta.setListarCatIncidencias(listCatInci);
//                respuesta.setCodigoMensaje(StaticConstantes.ERROR_OBTENER_LISTA);
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            }
        } catch (Exception e) {
            respuesta = new CatIncidenciaDTO();
            respuesta.setCodigoMensaje(e.getMessage());
            respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            logger.getLogger(Tsgnomcatincidencia.class.getName()).log(Level.SEVERE, null, e);
        }

        return respuesta;
    }

    @Override
    @Transactional
    public CatIncidenciaDTO guardarActualizarCatInci(CatIncidenciaDTO catIncidencia) {
        CatIncidenciaDTO respuesta = new CatIncidenciaDTO();
        try {
            boolean respuestaGuardar
                    = ((CatIncidenciaDAO) getGenericDAO()).guardarActualizarCatInci(catIncidencia.getCatIncidencia());

            if (respuestaGuardar) {
//                respuesta.setCodigoMensaje(StaticConstantes.EXITO_GUARDAR_ENTIDAD_ACADEMICA);
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_CORRECTO);
                respuesta.setCatIncidencia(catIncidencia.getCatIncidencia());
            } else {
//                respuesta.setCodigoMensaje(StaticConstantes.ERROR_GUARDAR_ENTIDAD_ACADEMICA);
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            }
        } catch (Exception e) {
            respuesta = new CatIncidenciaDTO();
            respuesta.setCodigoMensaje(e.getMessage());
            respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            logger.getLogger(Tsgnomcatincidencia.class.getName()).log(Level.SEVERE, null, e);
        }
        return respuesta;
    }

    @Override
    @Transactional
    public CatIncidenciaDTO eliminarCatIncidenciasId(Integer id) {
        CatIncidenciaDTO respuesta = new CatIncidenciaDTO();
        try {
            boolean respuestaEliminar
                    = ((CatIncidenciaDAO) getGenericDAO()).eliminarCatIncidenciasId(id);

            if (respuestaEliminar) {
//                respuesta.setCodigoMensaje(StaticConstantes.EXITO_GUARDAR_ENTIDAD_ACADEMICA);
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_CORRECTO);
            } else {
//                respuesta.setCodigoMensaje(StaticConstantes.ERROR_GUARDAR_ENTIDAD_ACADEMICA);
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            }
        } catch (Exception e) {
            respuesta = new CatIncidenciaDTO();
            respuesta.setCodigoMensaje(e.getMessage());
            respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            logger.getLogger(Tsgnomcatincidencia.class.getName()).log(Level.SEVERE, null, e);
        }
        return respuesta;
    }

}
