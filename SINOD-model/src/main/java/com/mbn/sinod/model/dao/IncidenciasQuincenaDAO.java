/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.dao;

import com.googlecode.genericdao.dao.hibernate.GenericDAO;
import com.mbn.sinod.model.dto.IncidenciasQuincenaDTO;
import com.mbn.sinod.model.entidades.Tsgnomcatincidencia;
import java.util.List;

/**
 *
 * @author mariana
 */ 
public interface IncidenciasQuincenaDAO extends GenericDAO<Tsgnomcatincidencia,Integer> {
    List<IncidenciasQuincenaDTO> listarincidenciasQuincena();
    boolean validarIncidencias(List<IncidenciasQuincenaDTO> listaIncidencias);
    boolean validarTodas(List<IncidenciasQuincenaDTO> listaIncidencias);
    boolean rechazarTodas(List<IncidenciasQuincenaDTO> listaIncidencias);
    
    /**
     * Actualiza el estatus de autorización de las incidencias por quincena
     * @param listaIncidencias
     * @return 
     */
    boolean autorizarIncidencias(List<IncidenciasQuincenaDTO> listaIncidencias);
    
    /**
     * Actualiza el estatus de autorización de todas las incidencias de la quincena a TRUE/Autorizada
     * @param listaIncidencias
     * @return 
     */
    boolean autorizarTodas(List<IncidenciasQuincenaDTO> listaIncidencias);
    
    /**
     * Actualiza el estatus de autorización de todas las incidencias de la quincena a FALSE/Denegada o no autorizada
     * @param listaIncidencias
     * @return 
     */
    boolean denegarTodas(List<IncidenciasQuincenaDTO> listaIncidencias);
    
    /**
     * Obtiene las incidencias de la quincena dependiendo del área (para líder de célula)
     * @param area id del área
     * @return 
     */
    List<IncidenciasQuincenaDTO> incidenciasQuincenaPorArea(int area);
    
    /**
     * Actualiza el estatus de autorización de pago de todas las incidencias de la quincena a TRUE/Autorizada
     * Para finanzas
     * @param listaIncidencias
     * @return 
     */
    boolean autorizarPagoIncidencias(List<IncidenciasQuincenaDTO> listaIncidencias);
    
    /**
     * Actualiza el estatus de autorización de todas las incidencias de la quincena a FALSE/Denegada o no autorizada
     * Para finanzas
     * @param listaIncidencias
     * @return 
     */
    boolean denegarPagoIncidencias(List<IncidenciasQuincenaDTO> listaIncidencias);

    /**
     * Actualiza el estatus de autorización de pago de las incidencias por quincena
     * Para finanzas
     * @param listaIncidencias
     * @return 
     */
    boolean autorizarPagosIncidencias(List<IncidenciasQuincenaDTO> listaIncidencias);
    
    /**
     * Actualiza el id de la quincena en que se va a pagar la incidencia al id de la siguiente quincena
     * @param incidenciaid
     * @param comentarios motivo por el que va a posponer el pago
     * @param modifica
     * @return 
     */
    boolean posponerPagoIncidencia(Integer incidenciaid, String comentarios, Integer modifica);
}
