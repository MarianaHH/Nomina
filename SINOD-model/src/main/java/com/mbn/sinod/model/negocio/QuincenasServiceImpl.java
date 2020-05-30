/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.negocio;

import com.mbn.sinod.model.comun.StaticConstantes;
import com.mbn.sinod.model.dao.QuincenasDAO;
import com.mbn.sinod.model.dto.QuincenasDTO;
import com.mbn.sinod.model.entidades.Tsgnomquincena;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.transaction.annotation.Transactional;

public class QuincenasServiceImpl extends BaseServiceImpl<Tsgnomquincena, Integer> implements QuincenasService {

    private static final Logger logger = Logger.getLogger(QuincenasService.class.getName());

    @Override
    public QuincenasDTO listQuincenas() {
        QuincenasDTO respuesta = new QuincenasDTO();

        try {
            List<Tsgnomquincena> listarQuincenas
                    = ((QuincenasDAO) getGenericDAO()).listarQuincena();
            if (listarQuincenas != null) {
                respuesta.setListarquincena(listarQuincenas);

            } else {
                listarQuincenas = new ArrayList<>();
                respuesta.setListarquincena(listarQuincenas);
            }
        } catch (Exception e) {
            respuesta = new QuincenasDTO();
            respuesta.setCodigoMensaje(e.getMessage());

            logger.getLogger(Tsgnomquincena.class.getName()).
                    log(Level.SEVERE, null, e);
        }
        return respuesta;
    }

    @Override
    public QuincenasDTO listQuinFuturas() {
        QuincenasDTO respuesta = new QuincenasDTO();

        try {
            List<Tsgnomquincena> listarQuincenas
                    = ((QuincenasDAO) getGenericDAO()).listarQuinFuturas();
            if (listarQuincenas != null) {
                respuesta.setListarquincena(listarQuincenas);

            } else {
                listarQuincenas = new ArrayList<>();
                respuesta.setListarquincena(listarQuincenas);
            }
        } catch (Exception e) {
            respuesta = new QuincenasDTO();
            respuesta.setCodigoMensaje(e.getMessage());

            logger.getLogger(Tsgnomquincena.class.getName()).
                    log(Level.SEVERE, null, e);
        }
        return respuesta;
    }

    @Override
    @Transactional
    public QuincenasDTO guardar(QuincenasDTO quincena) {
        QuincenasDTO respuesta = new QuincenasDTO();
        System.out.println("Quincena SERVICE GUARDAR");
        try {
            boolean respuestaGuardar
                    = ((QuincenasDAO) getGenericDAO()).guardarActualizarQuincena(quincena.getQuincena());

            if (respuestaGuardar) {
//                respuesta.setCodigoMensaje(StaticConstantes.EXITO_GUARDAR_ENTIDAD_ACADEMICA);
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_CORRECTO);
                respuesta.setQuincena(quincena.getQuincena());
            } else {
//                respuesta.setCodigoMensaje(StaticConstantes.ERROR_GUARDAR_ENTIDAD_ACADEMICA);
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            }
        } catch (Exception e) {
            respuesta = new QuincenasDTO();
            respuesta.setCodigoMensaje(e.getMessage());
            respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);

            logger.getLogger(Tsgnomquincena.class.getName()).log(Level.SEVERE, null, e);
        }
        return respuesta;
    }
    
    @Override
    public QuincenasDTO quincenaActual() {
        QuincenasDTO respuesta = new QuincenasDTO();
        try {
            Tsgnomquincena quincena
                    = ((QuincenasDAO) getGenericDAO()).quincenaActual();
            if (quincena != null) {
                respuesta.setQuincena(quincena);
            } else {
                quincena = new Tsgnomquincena();
                respuesta.setQuincena(quincena);
            }
        } catch (Exception e) {
            respuesta = new QuincenasDTO();
            respuesta.setCodigoMensaje(e.getMessage());
            logger.getLogger(Tsgnomquincena.class.getName()).
                    log(Level.SEVERE, null, e);
        }
        return respuesta;
    }

}
