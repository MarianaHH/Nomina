/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.negocio;

import com.mbn.sinod.model.dto.IncidenciasQuincenaDTO;
import com.mbn.sinod.model.entidades.Tsgnomcatincidencia;

/**
 *
 * @author mariana
 */
public interface IncidenciasQuincenaService extends BaseService<Tsgnomcatincidencia, Integer> {
    IncidenciasQuincenaDTO listarincidenciasQuincena();
    IncidenciasQuincenaDTO validarTodas(IncidenciasQuincenaDTO incidencia);
    IncidenciasQuincenaDTO validarIncidencias(IncidenciasQuincenaDTO incidencia);
    IncidenciasQuincenaDTO rechazarTodas(IncidenciasQuincenaDTO incidencia);
    
    /**
     * Actualiza el estatus de autorización de las incidencias por quincena
     * @param listaIncidencias
     * @return 
     */
    IncidenciasQuincenaDTO autorizarIncidencias(IncidenciasQuincenaDTO listaIncidencias);
    
    /**
     * Actualiza el estatus de autorización de todas las incidencias de la quincena a TRUE/Autorizada
     * @param listaIncidencias
     * @return 
     */
    IncidenciasQuincenaDTO autorizarTodas(IncidenciasQuincenaDTO listaIncidencias);
    
    /**
     * Actualiza el estatus de autorización de todas las incidencias de la quincena a FALSE/Rechazada o no autorizada
     * @param listaIncidencias
     * @return 
     */
    IncidenciasQuincenaDTO denegarTodas(IncidenciasQuincenaDTO listaIncidencias);
    
    /**
     * Obtiene las incidencias de la quincena dependiendo del área (para líder de célula)
     * @param area id del área
     * @return 
     */
    IncidenciasQuincenaDTO incidenciasQuincenaPorArea(int area);
    
    /**
     * Actualiza el estatus de autorización de pago de todas las incidencias de la quincena a TRUE/Autorizada
     * Para finanzas
     * @param listaIncidencias
     * @return 
     */
    IncidenciasQuincenaDTO autorizarPagoIncidencias(IncidenciasQuincenaDTO listaIncidencias);
    
    /**
     * Actualiza el estatus de autorización de todas las incidencias de la quincena a FALSE/Denegada o no autorizada
     * Para finanzas
     * @param listaIncidencias
     * @return 
     */
    IncidenciasQuincenaDTO denegarPagoIncidencias(IncidenciasQuincenaDTO listaIncidencias);

    /**
     * Actualiza el estatus de autorización de pago de las incidencias por quincena
     * Para finanzas
     * @param listaIncidencias
     * @return 
     */
    IncidenciasQuincenaDTO autorizarPagosIncidencias(IncidenciasQuincenaDTO listaIncidencias);
    
    /**
     * Actualiza el id de la quincena en que se va a pagar la incidencia al id de la siguiente quincena
     * @param incidenciaid
     * @param comentarios motivo por el que va a posponer el pago
     * @param modifica
     * @return 
     */
    boolean posponerPagoIncidencia(Integer incidenciaid, String comentarios, Integer modifica);
}
