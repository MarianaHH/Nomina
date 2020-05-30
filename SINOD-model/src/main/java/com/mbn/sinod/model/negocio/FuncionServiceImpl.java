/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.negocio;

import com.ibm.wsdl.ServiceImpl;
import com.mbn.sinod.model.comun.StaticConstantes;
import com.mbn.sinod.model.dao.FuncionDAO;
import com.mbn.sinod.model.dto.FuncionDTO;
import com.mbn.sinod.model.entidades.Tsgnomfuncion;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mariana
 */
public class FuncionServiceImpl extends BaseServiceImpl<Tsgnomfuncion, Integer> 
        implements FuncionService {

    private static final Logger logger = Logger.getLogger(ServiceImpl.class.getName());
    
    @Override
    public FuncionDTO obtenerFunciones() {
       FuncionDTO respuesta = new FuncionDTO();
        try {

            List<Tsgnomfuncion> listarFunciones = ((FuncionDAO) getGenericDAO()).obtenerFunciones();

            if (listarFunciones != null) {
                respuesta.setListafunciones(listarFunciones);
                //declara las constantes
                respuesta.setCodigoMensaje(StaticConstantes.EXITO_OBTENER_LISTA_FUNCIONES);
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_CORRECTO);

            } else {
                respuesta.setListafunciones(listarFunciones);
                //declara las constantes
                respuesta.setCodigoMensaje(StaticConstantes.ERROR_OBTENER_LISTA_FUNCIONES);
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            }
        } catch (Exception e) {
            respuesta = new FuncionDTO();
            respuesta.setCodigoMensaje(StaticConstantes.ERROR_OBTENER_LISTA_ARGUMENTOS);
            respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);

            logger.getLogger(FuncionServiceImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        return respuesta;
    }
    
}
