/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.negocio;

import com.mbn.sinod.model.comun.StaticConstantes;
import com.mbn.sinod.model.dao.EmpQuincenaDAO;
import com.mbn.sinod.model.dto.EmpQuincenaDTO;
import com.mbn.sinod.model.entidades.Tsgnomempquincena;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EmpQuincenaServiceImpl extends BaseServiceImpl<Tsgnomempquincena, Integer>
        implements EmpQuincenaService {

    private static final Logger logger = Logger.getLogger(QuincenasService.class.getName());

    @Override
    public EmpQuincenaDTO listarEmpQuincena() {
        EmpQuincenaDTO respuesta = new EmpQuincenaDTO();

        try {
            List<Tsgnomempquincena> listarEmpQuincena
                    = ((EmpQuincenaDAO) getGenericDAO()).listarEmpQuincena();

            if (listarEmpQuincena != null) {
                respuesta.setListarEmpQuincena(listarEmpQuincena);
//                respuesta.setCodigoMensaje(StaticConstantes.EXITO_OBTENER_LISTA);
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_CORRECTO);
            } else {
                listarEmpQuincena = new ArrayList();
                respuesta.setListarEmpQuincena(listarEmpQuincena);
//                respuesta.setCodigoMensaje(StaticConstantes.ERROR_OBTENER_LISTA);
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            }
        } catch (Exception e) {
            respuesta = new EmpQuincenaDTO();
            respuesta.setCodigoMensaje(e.getMessage());
            respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            logger.getLogger(Tsgnomempquincena.class.getName()).log(Level.SEVERE, null, e);
        }

        return respuesta;

    }
}
