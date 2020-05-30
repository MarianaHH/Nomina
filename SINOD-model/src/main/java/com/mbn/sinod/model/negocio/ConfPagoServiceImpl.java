/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.negocio;

import com.mbn.sinod.model.comun.StaticConstantes;
import com.mbn.sinod.model.dao.ConfPagoDAO;
import com.mbn.sinod.model.dto.ConfPagoDTO;
import com.mbn.sinod.model.dto.DetalleEmpDTO;
import com.mbn.sinod.model.dto.DetalleEmpDTO;
import com.mbn.sinod.model.entidades.Tsgnomconfpago;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author eduardotorres
 */
public class ConfPagoServiceImpl extends BaseServiceImpl<Tsgnomconfpago, Integer>
        implements ConfPagoService {

    private static final Logger logger = Logger.getLogger(ConfPagoService.class.getName());

    @Transactional
    @Override
    public ConfPagoDTO guardarAutorizacionRF(ConfPagoDTO conf1) {
        ConfPagoDTO respuesta = new ConfPagoDTO();
        try {
            boolean respuestaGuardar
                    = ((ConfPagoDAO) getGenericDAO()).guardarAutorizacionRF(conf1.getArrayListaConfirmaPago());

            if (respuestaGuardar) {

                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_CORRECTO);
//                respuesta.setConfirmaPago(conf1.getConfirmaPago());
                respuesta.setArrayListaConfirmaPago(conf1.getArrayListaConfirmaPago());
            } else {

                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            }
        } catch (Exception e) {
            respuesta = new ConfPagoDTO();
            respuesta.setCodigoMensaje(e.getMessage());
            respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            logger.getLogger(Tsgnomconfpago.class.getName()).log(Level.SEVERE, null, e);
        }
        return respuesta;
    }

    @Transactional
    @Override
    public ConfPagoDTO guardarAutorizacionRH(ConfPagoDTO conf2) {
        ConfPagoDTO respuesta = new ConfPagoDTO();
        try {
            boolean respuestaGuardar
                    = ((ConfPagoDAO) getGenericDAO()).guardarAutorizacionRH(conf2.getArrayListaConfirmaPago());

            if (respuestaGuardar) {

                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_CORRECTO);
//                respuesta.setConfirmaPago(conf2.getConfirmaPago());
                respuesta.setArrayListaConfirmaPago(conf2.getArrayListaConfirmaPago());
            } else {

                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            }
        } catch (Exception e) {
            respuesta = new ConfPagoDTO();
            respuesta.setCodigoMensaje(e.getMessage());
            respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            logger.getLogger(Tsgnomconfpago.class.getName()).log(Level.SEVERE, null, e);
        }
        return respuesta;
    }

    @Transactional
    @Override
    public ConfPagoDTO guardarAutorizacionEMP(Integer empquincenaFK, Boolean conf3) {
        ConfPagoDTO respuesta = new ConfPagoDTO();
        try {
            boolean respuestaGuardar
                    = ((ConfPagoDAO) getGenericDAO()).guardarAutorizacionEMP(empquincenaFK, conf3);

            if (respuestaGuardar) {

                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_CORRECTO);
//                respuesta.setConfirmaPago(conf3.getConfirmaPago());
            } else {

                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            }
        } catch (Exception e) {
            respuesta = new ConfPagoDTO();
            respuesta.setCodigoMensaje(e.getMessage());
            respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            logger.getLogger(Tsgnomconfpago.class.getName()).log(Level.SEVERE, null, e);
        }
        return respuesta;
    }
    
    @Transactional
    @Override
    public ConfPagoDTO validarTodas (Integer cabecera){
        ConfPagoDTO valida = new ConfPagoDTO();
        try {
            boolean validaGuardar
                    = ((ConfPagoDAO) getGenericDAO()).validarTodas(cabecera);

            if (validaGuardar) {

                valida.setTipoMensaje(StaticConstantes.MENSAJE_CORRECTO);
//                respuesta.setConfirmaPago(conf3.getConfirmaPago());
            } else {

                valida.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            }
        } catch (Exception e) {
            valida = new ConfPagoDTO();
            valida.setCodigoMensaje(e.getMessage());
            valida.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            logger.getLogger(Tsgnomconfpago.class.getName()).log(Level.SEVERE, null, e);
        }
        return valida;
    }
    
    @Transactional
    @Override
    public ConfPagoDTO validarTodasRH (Integer cabecera){
        ConfPagoDTO valida = new ConfPagoDTO();
        try {
            boolean validaGuardar
                    = ((ConfPagoDAO) getGenericDAO()).validarTodasRH(cabecera);

            if (validaGuardar) {

                valida.setTipoMensaje(StaticConstantes.MENSAJE_CORRECTO);
//                respuesta.setConfirmaPago(conf3.getConfirmaPago());
            } else {

                valida.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            }
        } catch (Exception e) {
            valida = new ConfPagoDTO();
            valida.setCodigoMensaje(e.getMessage());
            valida.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            logger.getLogger(Tsgnomconfpago.class.getName()).log(Level.SEVERE, null, e);
        }
        return valida;
    }
    
    @Transactional
    @Override
    public ConfPagoDTO rechazarTodasRF (Integer cabecera) {
        ConfPagoDTO rechazar = new ConfPagoDTO();
        try {
            boolean guargarRechazada
                    = ((ConfPagoDAO) getGenericDAO()).rechazarTodasRF(cabecera);

            if (guargarRechazada) {

                rechazar.setTipoMensaje(StaticConstantes.MENSAJE_CORRECTO);
//                respuesta.setConfirmaPago(conf3.getConfirmaPago());
            } else {

                rechazar.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            }
        } catch (Exception e) {
            rechazar = new ConfPagoDTO();
            rechazar.setCodigoMensaje(e.getMessage());
            rechazar.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            logger.getLogger(Tsgnomconfpago.class.getName()).log(Level.SEVERE, null, e);
        }
        return rechazar;
    }
    
    @Transactional
    @Override
    public ConfPagoDTO rechazarTodasRH (Integer cabecera){
        ConfPagoDTO rechazar = new ConfPagoDTO();
        try {
            boolean guargarRechazada
                    = ((ConfPagoDAO) getGenericDAO()).rechazarTodasRH(cabecera);

            if (guargarRechazada) {

                rechazar.setTipoMensaje(StaticConstantes.MENSAJE_CORRECTO);
//                respuesta.setConfirmaPago(conf3.getConfirmaPago());
            } else {

                rechazar.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            }
        } catch (Exception e) {
            rechazar = new ConfPagoDTO();
            rechazar.setCodigoMensaje(e.getMessage());
            rechazar.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            logger.getLogger(Tsgnomconfpago.class.getName()).log(Level.SEVERE, null, e);
        }
        return rechazar;
    }
}
