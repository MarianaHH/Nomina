/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.dao;

import com.googlecode.genericdao.dao.hibernate.GenericDAO;
import com.mbn.sinod.model.dto.DetalleIncidenciasEmpleadoDTO;
import com.mbn.sinod.model.entidades.Tsgnomincidencia;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author Karla
 */
public interface DetalleIncidenciasEmpleadoDAO extends GenericDAO<Tsgnomincidencia, Integer>{

    /**
     * Obtiene las incidencias dependiendo del empleado
     * @param reporta id del empleado
     * @return 
     */
    List<DetalleIncidenciasEmpleadoDTO> incidenciasPorEmpleado(int reporta);
    
    /**
     * Obtiene las incidencias dependiendo de la quincena
     * @param quincena id de la quincena
     * @return 
     */
    List<DetalleIncidenciasEmpleadoDTO> incidenciasPorQuincena(int quincena);
    
    /**
     * Obtiene las incidencias dependiendo del empleado y la quincena
     * @param empleado id del empleado
     * @param quincena id de la quincena
     * @return 
     */
    List<DetalleIncidenciasEmpleadoDTO> incidenciasPorEmpleadoQuincena(int empleado, int quincena);
    
    /**
     * Elimina el registro de incidencia del empleado (estatus = false)
     * @param incidenciaid id del registro de incidencia
     * @param reporta id del empleado logueado
     * @return 
     */
    boolean eliminarIncidenciaEmpleado(Integer incidenciaid, Integer reporta);
    
    /**
     * Obtiene las incidencias dependiendo de la quincena y el área (para líder de célula)
     * @param quincena id de la quincena
     * @param area id del área
     * @return 
     */
    List<DetalleIncidenciasEmpleadoDTO> incidenciasPorQuincenaArea(int quincena, int area);
    
    /**
     * Actualiza el dato "comentarios" de una incidencia por id
     * @param incidenciaid id del registro de incidencia
     * @param comentarios
     * @param reporta id del empleado logueado
     * @return 
     */
    boolean actualizarComentariosIncidencia(Integer incidenciaid, String comentarios, Integer reporta);

    /**
     * Actualiza el dato "importe" de una incidencia por id
     * @param incidenciaid id del registro de incidencia
     * @param importe
     * @param reporta id del empleado logueado
     * @return 
     */
    boolean actualizarImporteIncidencia(Integer incidenciaid, BigDecimal importe, Integer reporta);
    
    /**
     * Actualiza los valores de "comentario" e "importe" de una incidencia por id
     * @param incidenciaid id del registro de incidencia
     * @param comentarios comentario actualizado
     * @param importe importe actualizado
     * @param reporta id del empleado logueado
     * @return 
     */
    boolean actualizarIncidencia(Integer incidenciaid,String comentarios, BigDecimal importe, Integer reporta);
    
    /**
     * Realiza el registro de una incidencia en la bd
     * @param incidencia 
     * @return 
     */
    boolean registrarIncidencia(Tsgnomincidencia incidencia);
    
}
