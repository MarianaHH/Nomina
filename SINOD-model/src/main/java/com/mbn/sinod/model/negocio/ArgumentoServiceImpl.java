/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.negocio;

import com.mbn.sinod.model.comun.StaticConstantes;
import com.mbn.sinod.model.dao.ArgumentoDAO;
import com.mbn.sinod.model.dto.ArgumentoDTO;
import com.mbn.sinod.model.entidades.Tsgnomargumento;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author mariana
 */
public class ArgumentoServiceImpl extends BaseServiceImpl<Tsgnomargumento, Integer>
        implements ArgumentoService {

    private static final Logger logger = Logger.getLogger(ArgumentoService.class.getName());

    @Override
    public ArgumentoDTO listarArgumentos() {
        ArgumentoDTO respuesta = new ArgumentoDTO();
        try {

            List<Tsgnomargumento> listargumentos = ((ArgumentoDAO) getGenericDAO()).obtenerListaArgumentos();

            if (listargumentos != null) {
                respuesta.setListaArgumentos(listargumentos);
                //declara las constantes
                respuesta.setCodigoMensaje(StaticConstantes.EXITO_OBTENER_LISTA_ARGUMENTOS);
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_CORRECTO);

            } else {
                respuesta.setListaArgumentos(listargumentos);
                //declara las constantes
                respuesta.setCodigoMensaje(StaticConstantes.ERROR_OBTENER_LISTA_ARGUMENTOS);
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            }
        } catch (Exception e) {
            respuesta = new ArgumentoDTO();
            respuesta.setCodigoMensaje(StaticConstantes.ERROR_OBTENER_LISTA_ARGUMENTOS);
            respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);

            logger.getLogger(Tsgnomargumento.class.getName()).log(Level.SEVERE, null, e);
        }
        return respuesta;
    }

    @Override
    public ArgumentoDTO listarArgumentosConstantes() {
        ArgumentoDTO respuesta = new ArgumentoDTO();
        try {

            List<Tsgnomargumento> listargumentos = ((ArgumentoDAO) getGenericDAO()).obtenerArgumentosConstantes();

            if (listargumentos != null) {
                respuesta.setListaArgumentos(listargumentos);
                //declara las constantes
                respuesta.setCodigoMensaje(StaticConstantes.EXITO_OBTENER_LISTA_ARGUMENTOS_CONSTANTES);
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_CORRECTO);

            } else {
                respuesta.setListaArgumentos(listargumentos);
                //declara las constantes
                respuesta.setCodigoMensaje(StaticConstantes.ERROR_OBTENER_LISTA_ARGUMENTOS_CONSTANTES);
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            }
        } catch (Exception e) {
            respuesta = new ArgumentoDTO();
            respuesta.setCodigoMensaje(StaticConstantes.ERROR_OBTENER_LISTA_ARGUMENTOS_CONSTANTES);
            respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);

            logger.getLogger(Tsgnomargumento.class.getName()).log(Level.SEVERE, null, e);
        }
        return respuesta;
    }

    @Override
    public ArgumentoDTO listarArgumentosVariables() {
        ArgumentoDTO respuesta = new ArgumentoDTO();
        try {

            List<Tsgnomargumento> listargumentos = ((ArgumentoDAO) getGenericDAO()).obtenerArgumentosVariables();

            if (listargumentos != null) {
                respuesta.setListaArgumentos(listargumentos);
                //declara las constantes
                respuesta.setCodigoMensaje(StaticConstantes.EXITO_OBTENER_LISTA_ARGUMENTOS_VARIABLES);
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_CORRECTO);

            } else {
                respuesta.setListaArgumentos(listargumentos);
                //declara las constantes
                respuesta.setCodigoMensaje(StaticConstantes.ERROR_OBTENER_LISTA_ARGUMENTOS_VARIABLES);
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            }
        } catch (Exception e) {
            respuesta = new ArgumentoDTO();
            respuesta.setCodigoMensaje(StaticConstantes.ERROR_OBTENER_LISTA_ARGUMENTOS_VARIABLES);
            respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);

            logger.getLogger(Tsgnomargumento.class.getName()).log(Level.SEVERE, null, e);
        }
        return respuesta;
    }

    @Override
    @Transactional
    public ArgumentoDTO guardar(ArgumentoDTO argumento) {
        ArgumentoDTO respuesta = new ArgumentoDTO();
        System.out.println("ARGUMENTO SERVICE GUARDAR");
        try {
            boolean respuestaGuardar
                    = ((ArgumentoDAO) getGenericDAO()).guardarActualizarArgumento(argumento.getArgumento());

            if (respuestaGuardar) {
//                respuesta.setCodigoMensaje(StaticConstantes.EXITO_GUARDAR_ENTIDAD_ACADEMICA);
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_CORRECTO);
                respuesta.setArgumento(argumento.getArgumento());
            } else {
//                respuesta.setCodigoMensaje(StaticConstantes.ERROR_GUARDAR_ENTIDAD_ACADEMICA);
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            }
        } catch (Exception e) {
            respuesta = new ArgumentoDTO();
            respuesta.setCodigoMensaje(e.getMessage());
            respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);

            logger.getLogger(Tsgnomargumento.class.getName()).log(Level.SEVERE, null, e);
        }
        return respuesta;
    }

    @Transactional
    @Override
    public ArgumentoDTO eliminarArgumento(Integer argumentoId) {
        ArgumentoDTO respuesta = new ArgumentoDTO();

        try {
            boolean respuestaEliminar = ((ArgumentoDAO) getGenericDAO()).eliminarArgumento(argumentoId);
            if (respuestaEliminar) {

                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_CORRECTO);
                respuesta.setCodigoMensaje(StaticConstantes.ERROR_ELIMINAR_ARGUMENTO);

            } else {
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            }
        } catch (Exception e) {
            respuesta = new ArgumentoDTO();
            respuesta.setCodigoMensaje(e.getMessage());
            respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);

            logger.getLogger(Tsgnomargumento.class.getName()).log(Level.SEVERE, null, e);
        }
        return respuesta;
    }

}
