/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.negocio;

import com.mbn.sinod.model.comun.StaticConstantes;
import com.mbn.sinod.model.dao.SumaDesgloseDAO;
import com.mbn.sinod.model.dto.SumaDesgloseDTO;
import com.mbn.sinod.model.entidades.Tsgnomempquincena;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class SumaDesgloseServiceImpl extends BaseServiceImpl<Tsgnomempquincena, Integer> 
        implements SumaDesgloseService {

    private static final Logger logger = Logger.getLogger(SumaDesgloseService.class.getName());
    
    @Override
    public SumaDesgloseDTO sumaDesglose(Integer cabecera, Integer empleado) {
        SumaDesgloseDTO respuesta = new SumaDesgloseDTO();
        try {

            List<Tsgnomempquincena> sumaDesglose = ((SumaDesgloseDAO) getGenericDAO()).sumaDesglose(cabecera, empleado);

            if (sumaDesglose != null) {
                respuesta.setListConceptosSum(sumaDesglose);
                //declara las constantes
//                respuesta.setCodigoMensaje(StaticConstantes.EXITO_LISTAR_CONCEPTOS_PERCEPCION);
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_CORRECTO);

            } else {
                respuesta.setListConceptosSum(sumaDesglose);
                //declara las constantes
//                respuesta.setCodigoMensaje(StaticConstantes.ERROR_LISTAR_CONCEPTOS_PERCEPCION);
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            }
        } catch (Exception e) {
            respuesta = new SumaDesgloseDTO();
//            respuesta.setCodigoMensaje(StaticConstantes.ERROR_LISTAR_CONCEPTOS_PERCEPCION);
            respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);

            logger.getLogger(ConceptoServiceImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        return respuesta;
    }
}
