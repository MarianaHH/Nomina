/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.negocio;

import com.mbn.sinod.model.comun.StaticConstantes;
import com.mbn.sinod.model.dao.EmpQuincenasDAO;
import com.mbn.sinod.model.dto.EmpQuincenasDTO;
import com.mbn.sinod.model.entidades.Tsgnomempquincena;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.transaction.annotation.Transactional;


public class EmpQuincenasServiceImpl extends BaseServiceImpl<Tsgnomempquincena, Integer> 
        implements EmpQuincenasService {
    
    private static final Logger logger = Logger.getLogger(EmpQuincenasService.class.getName());
    
    @Override
    public EmpQuincenasDTO listaEmpQuincenas() {
        
        EmpQuincenasDTO respuesta = new EmpQuincenasDTO();

        try {
            List<Tsgnomempquincena> listEmpQuincenas
                    = ((EmpQuincenasDAO) getGenericDAO()).listaEmpQuincenas();

            if (listEmpQuincenas != null) {
                respuesta.setListaEmpQuincena(listEmpQuincenas);
//                respuesta.setCodigoMensaje(StaticConstantes.EXITO_OBTENER_LISTA);
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_CORRECTO);
            } else {
                listEmpQuincenas = new ArrayList();
                respuesta.setListaEmpQuincena(listEmpQuincenas);
//                respuesta.setCodigoMensaje(StaticConstantes.ERROR_OBTENER_LISTA);
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            }
        } catch (Exception e) {
            respuesta = new EmpQuincenasDTO();
            respuesta.setCodigoMensaje(e.getMessage());
            respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            logger.getLogger(Tsgnomempquincena.class.getName()).log(Level.SEVERE, null, e);
        }

        return respuesta;
    }

    @Override
    @Transactional
    public EmpQuincenasDTO insertaEmpleadosQuincena(Integer cabeceraid_fk) {
        EmpQuincenasDTO respuesta = new EmpQuincenasDTO();

        try {
            Boolean quincena
                    = ((EmpQuincenasDAO) getGenericDAO()).insertaEmpleadosQuincena(cabeceraid_fk);
            System.out.println("entra EMPquincena");
            if (quincena) {
                respuesta.setConfirmacion(quincena);
//                respuesta.setCodigoMensaje(StaticConstantes.EXITO_OBTENER_LISTA);
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_CORRECTO);
            } else {
                
                respuesta.setConfirmacion(quincena);
//                respuesta.setCodigoMensaje(StaticConstantes.ERROR_OBTENER_LISTA);
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            }
        } catch (Exception e) {
            respuesta = new EmpQuincenasDTO();
            respuesta.setCodigoMensaje(e.getMessage());
            respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            logger.getLogger(Tsgnomempquincena.class.getName()).log(Level.SEVERE, null, e);
        }
        return respuesta;
    }    

    @Override
    public EmpQuincenasDTO listaEmpQuincenas(Integer cabeceraid_fk) {
        EmpQuincenasDTO respuesta = new EmpQuincenasDTO();

        try {
            List<Tsgnomempquincena> listEmpQuincenas
                    = ((EmpQuincenasDAO) getGenericDAO()).listaEmpQuincenas(cabeceraid_fk);

            if (listEmpQuincenas != null) {
                respuesta.setListaEmpQuincena(listEmpQuincenas);
//                respuesta.setCodigoMensaje(StaticConstantes.EXITO_OBTENER_LISTA);
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_CORRECTO);
            } else {
                listEmpQuincenas = new ArrayList();
                respuesta.setListaEmpQuincena(listEmpQuincenas);
//                respuesta.setCodigoMensaje(StaticConstantes.ERROR_OBTENER_LISTA);
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            }
        } catch (Exception e) {
            respuesta = new EmpQuincenasDTO();
            respuesta.setCodigoMensaje(e.getMessage());
            respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            logger.getLogger(Tsgnomempquincena.class.getName()).log(Level.SEVERE, null, e);
        }

        return respuesta;
    }
}
