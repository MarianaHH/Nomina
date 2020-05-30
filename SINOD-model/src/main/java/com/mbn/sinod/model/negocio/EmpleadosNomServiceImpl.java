/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.negocio;

import com.mbn.sinod.model.comun.StaticConstantes;
import com.mbn.sinod.model.dao.EmpleadosNomDAO;
import com.mbn.sinod.model.dto.DesgloseEmpleadoDTO;
import com.mbn.sinod.model.dto.EmpleadosNomDTO;
import com.mbn.sinod.model.entidades.Tsgnomempleados;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Ivette
 */
public class EmpleadosNomServiceImpl extends BaseServiceImpl<Tsgnomempleados, Integer> implements EmpleadosNomService {

    private static final Logger logger = Logger.getLogger(EmpleadosNomServiceImpl.class.getName());

    @Autowired
    private EmpleadosNomDAO empleadosDAO;

    @Override
    public List<Tsgnomempleados> listarEmpleadosNom() {
        return empleadosDAO.listarEmpleadosNom();
    }

    @Override
    public Tsgnomempleados obtenerEmpleadonomPorIdrh(Integer idempleadorh) {
        return this.empleadosDAO.obtenerEmpleadonomPorIdrh(idempleadorh);
    }

    public EmpleadosNomDAO getEmpleadosDAO() {
        return empleadosDAO;
    }

    public void setEmpleadosDAO(EmpleadosNomDAO empleadosDAO) {
        this.empleadosDAO = empleadosDAO;
    }

    @Override
    @Transactional
    public EmpleadosNomDTO guardar(EmpleadosNomDTO empleado) {
        EmpleadosNomDTO respuesta = new EmpleadosNomDTO();
        System.out.println("EMPLEADO NOM SERVICE GUARDAR");
        try {
            boolean respuestaGuardar
                    = ((EmpleadosNomDAO) getGenericDAO()).guardarActualizarEmpleados(empleado.getEmpleado());

            if (respuestaGuardar) {
//                respuesta.setCodigoMensaje(StaticConstantes.EXITO_GUARDAR_ENTIDAD_ACADEMICA);
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_CORRECTO);
                respuesta.setEmpleado(empleado.getEmpleado());
            } else {
//                respuesta.setCodigoMensaje(StaticConstantes.ERROR_GUARDAR_ENTIDAD_ACADEMICA);
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            }
        } catch (Exception e) {
            respuesta = new EmpleadosNomDTO();
            respuesta.setCodigoMensaje(e.getMessage());
            respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);

            logger.getLogger(Tsgnomempleados.class.getName()).log(Level.SEVERE, null, e);
        }
        return respuesta;
    }

    @Override
    public Tsgnomempleados obtenerEmpleadosnomPorIdNom(Integer idempleadonom) {
        return this.empleadosDAO.obtenerEmpleadosnomPorIdNom(idempleadonom);
    }

    @Override
    public DesgloseEmpleadoDTO obtenerEmpleadosnomPorIdNomHT(Integer idempleadonom) {
//        return this.empleadosDAO.obtenerEmpleadosnomPorIdNomHT(idempleadonom);
        DesgloseEmpleadoDTO respuesta = new DesgloseEmpleadoDTO();
       try {
            List<DesgloseEmpleadoDTO> listaDesgloce
                    = ((EmpleadosNomDAO) getGenericDAO()).obtenerEmpleadosnomPorIdNomHT(idempleadonom);

            if (listaDesgloce != null) {
                respuesta.setListaDesgloce(listaDesgloce);
//                respuesta.setCodigoMensaje(StaticConstantes.EXITO_OBTENER_LISTA);
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_CORRECTO);
            } else {
                listaDesgloce = new ArrayList();
                respuesta.setListaDesgloce(listaDesgloce);
//                respuesta.setCodigoMensaje(StaticConstantes.ERROR_OBTENER_LISTA);
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            }
        } catch (Exception e) {
            respuesta = new DesgloseEmpleadoDTO();
            respuesta.setCodigoMensaje(e.getMessage());
            respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            logger.getLogger(Tsgnomempleados.class.getName()).log(Level.SEVERE, null, e);
        }

        return respuesta;
    }
}
