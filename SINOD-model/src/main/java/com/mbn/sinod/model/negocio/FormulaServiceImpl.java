/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.negocio;

import com.mbn.sinod.model.comun.StaticConstantes;
import com.mbn.sinod.model.dto.FormulaDTO;
import com.mbn.sinod.model.entidades.Tsgnomformula;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.mbn.sinod.model.dao.FormulaDAO;
import org.springframework.transaction.annotation.Transactional;


public class FormulaServiceImpl extends BaseServiceImpl<Tsgnomformula, Integer> implements FormulaService {
    private static final Logger logger = Logger.getLogger(FormulaService.class.getName());
    @Override
    public FormulaDTO listarFormulas() {
        FormulaDTO respuesta = new FormulaDTO();

        try {
            List<Tsgnomformula> listFormualas
                    = ((FormulaDAO) getGenericDAO()).listarFormulas();

            if (listFormualas != null) {
                respuesta.setListarFormulas(listFormualas);
//                respuesta.setCodigoMensaje(StaticConstantes.EXITO_OBTENER_LISTA);
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_CORRECTO);
            } else {
                listFormualas = new ArrayList();
                respuesta.setListarFormulas(listFormualas);
//                respuesta.setCodigoMensaje(StaticConstantes.ERROR_OBTENER_LISTA);
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            }
        } catch (Exception e) {
            respuesta = new FormulaDTO();
            respuesta.setCodigoMensaje(e.getMessage());
            respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            logger.getLogger(Tsgnomformula.class.getName()).log(Level.SEVERE, null, e);
        }

        return respuesta;
    }

    @Override
    @Transactional
    public FormulaDTO guardar(FormulaDTO formula) {
         FormulaDTO respuesta = new FormulaDTO();
        try {
            boolean respuestaGuardar
                    = ((FormulaDAO) getGenericDAO()).guardarFormula(formula.getFormula());

            if (respuestaGuardar) {
//                respuesta.setCodigoMensaje(StaticConstantes.EXITO_GUARDAR_ENTIDAD_ACADEMICA);
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_CORRECTO);
                respuesta.setFormula(formula.getFormula());
            } else {
//                respuesta.setCodigoMensaje(StaticConstantes.ERROR_GUARDAR_ENTIDAD_ACADEMICA);
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            }
        } catch (Exception e) {
            respuesta = new FormulaDTO();
            respuesta.setCodigoMensaje(e.getMessage());
            respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            logger.getLogger(Tsgnomformula.class.getName()).log(Level.SEVERE, null, e);
        }
        return respuesta;
    }
    
}
