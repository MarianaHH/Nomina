/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.negocio;

import com.ibm.wsdl.ServiceImpl;
import com.mbn.sinod.model.comun.StaticConstantes;
import com.mbn.sinod.model.dao.ValidarBajasDAO;
import com.mbn.sinod.model.dto.ValidacionBajasDTO;
import com.mbn.sinod.model.entidades.Tsgnomempleados;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Ivette
 */
public class ValidarBajasServiceImpl extends BaseServiceImpl<Tsgnomempleados, Integer> 
        implements ValidarBajasService{

    private static final Logger logger = Logger.getLogger(ServiceImpl.class.getName());
    
    @Override
    public ValidacionBajasDTO listarBajasAValidar() {
        ValidacionBajasDTO respuesta = new ValidacionBajasDTO();
        try {

            List<ValidacionBajasDTO> listaBajas = ((ValidarBajasDAO) getGenericDAO()).listarBajasAValidar();

            if (listaBajas != null) {
                respuesta.setListaInformacionValidar(listaBajas);
                //declara las constantes
                respuesta.setCodigoMensaje(StaticConstantes.ERROR_LISTAR_BAJAS_A_VALIDAR);
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_CORRECTO);

            } else {
                respuesta.setListaInformacionValidar(listaBajas);
                //declara las constantes
                respuesta.setCodigoMensaje(StaticConstantes.ERROR_LISTAR_ALTAS_A_VALIDAR);
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            }
        } catch (Exception e) {
            respuesta = new ValidacionBajasDTO();
            respuesta.setCodigoMensaje(StaticConstantes.ERROR_OBTENER_LISTA_ARGUMENTOS);
            respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);

            logger.getLogger(IncidenciasQuincenaServiceImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        return respuesta;
    }

    @Transactional
    @Override
    public ValidacionBajasDTO validarCadaBaja(ValidacionBajasDTO bajas) {
        ValidacionBajasDTO respuesta = new ValidacionBajasDTO();
        try {
            boolean respuestaGuardar
                    = ((ValidarBajasDAO) getGenericDAO()).validarCadaBaja(bajas.getListaInformacionValidar());
                           

            if (respuestaGuardar) {
//                respuesta.setCodigoMensaje(StaticConstantes.EXITO_GUARDAR_ENTIDAD_ACADEMICA);
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_CORRECTO);
                
                
                respuesta.setListaInformacionValidar(bajas.getListaInformacionValidar());
                
            } else {
//                respuesta.setCodigoMensaje(StaticConstantes.ERROR_GUARDAR_ENTIDAD_ACADEMICA);
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

    @Transactional
    @Override
    public ValidacionBajasDTO validarBajasAceptadas(ValidacionBajasDTO bajas) {
       ValidacionBajasDTO respuesta = new ValidacionBajasDTO();
        try {
            boolean respuestaGuardar
                    = ((ValidarBajasDAO) getGenericDAO()).validarBajasAceptadas(bajas.getListaInformacionValidar());
                            

            if (respuestaGuardar) {
//                respuesta.setCodigoMensaje(StaticConstantes.EXITO_GUARDAR_ENTIDAD_ACADEMICA);
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_CORRECTO);
                
                
                respuesta.setListaInformacionValidar(bajas.getListaInformacionValidar());
                
            } else {
//                respuesta.setCodigoMensaje(StaticConstantes.ERROR_GUARDAR_ENTIDAD_ACADEMICA);
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

    @Transactional
    @Override
    public ValidacionBajasDTO validarBajasRechazadas(ValidacionBajasDTO bajas) {
        ValidacionBajasDTO respuesta = new ValidacionBajasDTO();
        try {
            boolean respuestaGuardar
                    = ((ValidarBajasDAO) getGenericDAO()).validarBajasRechazadas(bajas.getListaInformacionValidar());
                            

            if (respuestaGuardar) {
//                respuesta.setCodigoMensaje(StaticConstantes.EXITO_GUARDAR_ENTIDAD_ACADEMICA);
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_CORRECTO);
                
                
                respuesta.setListaInformacionValidar(bajas.getListaInformacionValidar());
               
            } else {
//                respuesta.setCodigoMensaje(StaticConstantes.ERROR_GUARDAR_ENTIDAD_ACADEMICA);
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
