/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.negocio;

import com.ibm.wsdl.ServiceImpl;
import com.mbn.sinod.model.comun.StaticConstantes;
import com.mbn.sinod.model.dao.ValidarAltasDAO;
import com.mbn.sinod.model.dto.ValidacionAltasDTO;
import com.mbn.sinod.model.entidades.Tsgnomempleados;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.hibernate.annotations.common.util.impl.LoggerFactory.logger;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author mariana
 */
public class ValidarAltasServiceImpl extends BaseServiceImpl<Tsgnomempleados, Integer> 
        implements ValidarAltasService {
    
    private static final Logger logger = Logger.getLogger(ServiceImpl.class.getName());

    @Override
    public ValidacionAltasDTO listarAltasAValidar() {
        ValidacionAltasDTO respuesta = new ValidacionAltasDTO();
        try {

            List<ValidacionAltasDTO> listaIncidencias = ((ValidarAltasDAO) getGenericDAO()).listarAltasAValidar();

            if (listaIncidencias != null) {
                respuesta.setListaInformacionValidar(listaIncidencias);
                //declara las constantes
                respuesta.setCodigoMensaje(StaticConstantes.ERROR_LISTAR_ALTAS_A_VALIDAR);
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_CORRECTO);

            } else {
                respuesta.setListaInformacionValidar(listaIncidencias);
                //declara las constantes
                respuesta.setCodigoMensaje(StaticConstantes.ERROR_LISTAR_ALTAS_A_VALIDAR);
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            }
        } catch (Exception e) {
            respuesta = new ValidacionAltasDTO();
            respuesta.setCodigoMensaje(StaticConstantes.ERROR_OBTENER_LISTA_ARGUMENTOS);
            respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);

            logger.getLogger(IncidenciasQuincenaServiceImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        return respuesta;
    }
    
    @Transactional
    @Override
    public ValidacionAltasDTO validarCadaAlta(ValidacionAltasDTO altas) {
       ValidacionAltasDTO respuesta = new ValidacionAltasDTO();
        try {
            boolean respuestaGuardar
                    = ((ValidarAltasDAO) getGenericDAO()).validarCadaAlta(altas.getListaInformacionValidar());
                           

            if (respuestaGuardar) {
//                respuesta.setCodigoMensaje(StaticConstantes.EXITO_GUARDAR_ENTIDAD_ACADEMICA);
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_CORRECTO);
                
                
                respuesta.setListaInformacionValidar(altas.getListaInformacionValidar());
                
            } else {
//                respuesta.setCodigoMensaje(StaticConstantes.ERROR_GUARDAR_ENTIDAD_ACADEMICA);
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
    public ValidacionAltasDTO validarAltasAceptadas(ValidacionAltasDTO altas) {
       ValidacionAltasDTO respuesta = new ValidacionAltasDTO();
        try {
            boolean respuestaGuardar
                    = ((ValidarAltasDAO) getGenericDAO()).validarAltasAceptadas(altas.getListaInformacionValidar());
                            

            if (respuestaGuardar) {
//                respuesta.setCodigoMensaje(StaticConstantes.EXITO_GUARDAR_ENTIDAD_ACADEMICA);
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_CORRECTO);
                
                
                respuesta.setListaInformacionValidar(altas.getListaInformacionValidar());
                
            } else {
//                respuesta.setCodigoMensaje(StaticConstantes.ERROR_GUARDAR_ENTIDAD_ACADEMICA);
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
    public ValidacionAltasDTO validarAltasRechazadas(ValidacionAltasDTO altas) {
        ValidacionAltasDTO respuesta = new ValidacionAltasDTO();
        try {
            boolean respuestaGuardar
                    = ((ValidarAltasDAO) getGenericDAO()).validarAltasRechazadas(altas.getListaInformacionValidar());
                            

            if (respuestaGuardar) {
//                respuesta.setCodigoMensaje(StaticConstantes.EXITO_GUARDAR_ENTIDAD_ACADEMICA);
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_CORRECTO);
                
                
                respuesta.setListaInformacionValidar(altas.getListaInformacionValidar());
               
            } else {
//                respuesta.setCodigoMensaje(StaticConstantes.ERROR_GUARDAR_ENTIDAD_ACADEMICA);
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
    
    
    
}
