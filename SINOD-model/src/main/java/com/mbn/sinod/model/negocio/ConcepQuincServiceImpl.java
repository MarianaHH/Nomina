/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.negocio;

import com.mbn.sinod.model.comun.StaticConstantes;
import com.mbn.sinod.model.dao.ConcepQuincDAO;
import com.mbn.sinod.model.dto.ConcepQuincDTO;
import com.mbn.sinod.model.dto.ConcepQuincHTDTO;
import com.mbn.sinod.model.entidades.Tsgnomcncptoquinc;
import com.mbn.sinod.model.entidades.Tsgnomcncptoquincht;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConcepQuincServiceImpl extends BaseServiceImpl<Tsgnomcncptoquinc, Integer> implements ConcepQuincService {

    private static final Logger logger = Logger.getLogger(ConcepQuincService.class.getName());

    @Override
    public ConcepQuincDTO listaConcepQuinc() {
        ConcepQuincDTO respuesta = new ConcepQuincDTO();

        try {
            List<Tsgnomcncptoquinc> listConQui
                    = ((ConcepQuincDAO) getGenericDAO()).listaConcepQuinc();
            if (listConQui != null) {
                respuesta.setListCncptoquinc(listConQui);
//                respuesta.setCodigoMensaje(StaticConstantes.EXITO_OBTENER_LISTA);
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_CORRECTO);
            } else {
                listConQui = new ArrayList();
                respuesta.setListCncptoquinc(listConQui);
//                respuesta.setCodigoMensaje(StaticConstantes.ERROR_OBTENER_LISTA);
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            }
        } catch (Exception e) {
            respuesta = new ConcepQuincDTO();
            respuesta.setCodigoMensaje(e.getMessage());
            respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            logger.getLogger(Tsgnomcncptoquinc.class.getName()).log(Level.SEVERE, null, e);
        }
        return respuesta;
    }

    @Override
    public ConcepQuincDTO listaConcepQuincByEmpQuin(Integer empQuinc) {
        ConcepQuincDTO respuesta = new ConcepQuincDTO();

        try {
            List<Tsgnomcncptoquinc> concepQuinc = ((ConcepQuincDAO) getGenericDAO()).listaConcepQuincByEmpQuin(empQuinc);
            if (concepQuinc != null) {
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_CORRECTO);
                respuesta.setListCncptoquinc(concepQuinc);
//                respuesta.setCodigoMensaje(StaticConstantes.ERROR_ELIMINAR_CONCEPTO);
            } else {
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            }
        } catch (Exception e) {
            respuesta = new ConcepQuincDTO();
            respuesta.setCodigoMensaje(e.getMessage());
            respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            logger.getLogger(ConcepQuincServiceImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        return respuesta;
    }

    @Override
    public ConcepQuincHTDTO listaConcepQuincByEmpQuinHT(Integer empQuinc) {
        ConcepQuincHTDTO respuesta = new ConcepQuincHTDTO();
        try {
            List<Tsgnomcncptoquincht> concepQuinc = ((ConcepQuincDAO) getGenericDAO()).listaConcepQuincByEmpQuinHT(empQuinc);
            if (concepQuinc != null) {
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_CORRECTO);
                respuesta.setListCncptoquinc(concepQuinc);
//                respuesta.setCodigoMensaje(StaticConstantes.ERROR_ELIMINAR_CONCEPTO);
            } else {
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            }
        } catch (Exception e) {
            respuesta = new ConcepQuincHTDTO();
            respuesta.setCodigoMensaje(e.getMessage());
            respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            logger.getLogger(ConcepQuincServiceImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        return respuesta;
    }

    @Override
    public ConcepQuincDTO listaConceptosEmpl(Integer empleado) {
        ConcepQuincDTO respuesta = new ConcepQuincDTO();

        try {
            List<Tsgnomcncptoquinc> concepQuinc = ((ConcepQuincDAO) getGenericDAO()).listaConceptosEmpl(empleado);
            if (concepQuinc != null) {
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_CORRECTO);
                respuesta.setListCncptoquinc(concepQuinc);
//                respuesta.setCodigoMensaje(StaticConstantes.ERROR_ELIMINAR_CONCEPTO);
            } else {
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            }
        } catch (Exception e) {
            respuesta = new ConcepQuincDTO();
            respuesta.setCodigoMensaje(e.getMessage());
            respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            logger.getLogger(ConcepQuincServiceImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        return respuesta;
    }

    @Override
    public ConcepQuincDTO listaConcepQuincByCabecera(Integer cabecera) {
        ConcepQuincDTO respuesta = new ConcepQuincDTO();

        try {
            List<Tsgnomcncptoquinc> concepQuinc = ((ConcepQuincDAO) getGenericDAO()).listaConcepQuincByCabecera(cabecera);
            if (concepQuinc != null) {
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_CORRECTO);
                respuesta.setListCncptoquinc(concepQuinc);
//                respuesta.setCodigoMensaje(StaticConstantes.ERROR_ELIMINAR_CONCEPTO);
            } else {
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            }
        } catch (Exception e) {
            respuesta = new ConcepQuincDTO();
            respuesta.setCodigoMensaje(e.getMessage());
            respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            logger.getLogger(ConcepQuincServiceImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        return respuesta;
    }
}
