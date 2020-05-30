/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.negocio;

import com.ibm.wsdl.ServiceImpl;
import com.mbn.sinod.model.comun.StaticConstantes;
import com.mbn.sinod.model.dao.EnviarCorreoDAO;
import com.mbn.sinod.model.dto.IncidenciasQuincenaDTO;
import com.mbn.sinod.model.dto.ValidacionAltasDTO;
import com.mbn.sinod.model.dto.ValidacionBajasDTO;
import com.mbn.sinod.model.entidades.Tsgnomcatincidencia;
import com.mbn.sinod.model.entidades.Tsgnomempleados;
import com.mbn.sinod.model.entidades.Tsgnomincidencia;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author mariana
 */
public class EnviarCorreoServiceImpl extends BaseServiceImpl<Tsgnomincidencia, Integer>
        implements EnviarCorreoService {

    private static final Logger logger = Logger.getLogger(ServiceImpl.class.getName());

    @Transactional
    @Override
    public IncidenciasQuincenaDTO enviarCorreos(IncidenciasQuincenaDTO incidencia) {
        IncidenciasQuincenaDTO respuesta = new IncidenciasQuincenaDTO();
        try {
            boolean respuestaGuardar
                    = ((EnviarCorreoDAO) getGenericDAO()).enviarCorreos(incidencia.getListaIncidencias());

            if (respuestaGuardar) {
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_CORRECTO);

                respuesta.setListaIncidencias(incidencia.getListaIncidencias());
            } else {
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            }
        } catch (Exception e) {
            respuesta = new IncidenciasQuincenaDTO();
            respuesta.setCodigoMensaje(e.getMessage());
            respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            logger.getLogger(Tsgnomcatincidencia.class.getName()).log(Level.SEVERE, null, e);
        }
        return respuesta;
    }

    @Transactional
    @Override
    public ValidacionAltasDTO enviarCorreosValidarAltas(ValidacionAltasDTO altas) {
        ValidacionAltasDTO respuesta = new ValidacionAltasDTO();
        try {
            boolean respuestaGuardar
                    = ((EnviarCorreoDAO) getGenericDAO()).enviarCorreosValidacionAltas(altas.getListaInformacionValidar());

            if (respuestaGuardar) {
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_CORRECTO);

                respuesta.setListaInformacionValidar(altas.getListaInformacionValidar());
            } else {
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            }
        } catch (Exception e) {
            respuesta = new ValidacionAltasDTO();
            respuesta.setCodigoMensaje(e.getMessage());
            respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            logger.getLogger(Tsgnomempleados.class.getName()).log(Level.SEVERE, null, e);
        }
        return respuesta;
    }

    @Transactional
    @Override
    public ValidacionBajasDTO enviarCorreosValidarBajas(ValidacionBajasDTO bajas) {
       ValidacionBajasDTO respuesta = new ValidacionBajasDTO();
        try {
            boolean respuestaGuardar
                    = ((EnviarCorreoDAO) getGenericDAO()).enviarCorreosValidacionBajas(bajas.getListaInformacionValidar());

            if (respuestaGuardar) {
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_CORRECTO);

                respuesta.setListaInformacionValidar(bajas.getListaInformacionValidar());
            } else {
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            }
        } catch (Exception e) {
            respuesta = new ValidacionBajasDTO();
            respuesta.setCodigoMensaje(e.getMessage());
            respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            logger.getLogger(Tsgnomempleados.class.getName()).log(Level.SEVERE, null, e);
        }
        return respuesta;
    }

}
