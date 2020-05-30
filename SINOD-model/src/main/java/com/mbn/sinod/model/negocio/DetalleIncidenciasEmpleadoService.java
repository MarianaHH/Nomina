/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.negocio;

import com.mbn.sinod.model.dto.IncidenciasDTO;
import com.mbn.sinod.model.dto.IncidenciasPorEmpleadoDTO;
import com.mbn.sinod.model.entidades.Tsgnomincidencia;
import java.math.BigDecimal;

/**
 *
 * @author Karla
 */
public interface DetalleIncidenciasEmpleadoService extends BaseService<Tsgnomincidencia,Integer>{
    
    /**
     * Obtiene las incidencias dependiendo del empleado
     * @param reporta id del empleado
     * @return 
     */
    IncidenciasPorEmpleadoDTO incidenciasPorEmpleado(int reporta);
    
    /**
     * Obtiene las incidencias dependiendo de la quincena
     * @param quincena id de la quincena
     * @return 
     */
    IncidenciasPorEmpleadoDTO incidenciasPorQuincena(int quincena);
    
    /**
     * Obtiene las incidencias dependiendo del empleado y la quincena
     * @param empleado id del empleado
     * @param quincena id de la quincena
     * @return 
     */
    IncidenciasPorEmpleadoDTO incidenciasPorEmpleadoQuincena(int empleado, int quincena);
    
    /**
     * Obtiene las incidencias dependiendo de la quincena y el área (para líder de célula)
     * @param quincena id de la quincena
     * @param area id del area
     * @return 
     */
    IncidenciasPorEmpleadoDTO incidenciasPorQuincenaArea(int quincena, int area);
    
    /**
     * Elimina el registro de incidencia del empleado (estatus = false)
     * @param incidenciaid id del registro de incidencia
     * @param reporta id del empleado logueado
     * @return 
     */
    boolean eliminarIncidenciaEmpleado(Integer incidenciaid, Integer reporta);
    
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
     * Actualiza los datos de "comentarios" e "importe" de una incidencia por id
     * @param incidenciaid id de la incidencia a actualizar
     * @param comentarios comentarios actualizados
     * @param importe importe actualizado
     * @param reporta id del empleado logueado 
     * @return
     */
    boolean actualizarIncidencia(Integer incidenciaid, String comentarios, BigDecimal importe, Integer reporta);
    
    /**
     * Realiza el registro de una incidencia en la bd
     * @param incidencia 
     * @return 
     */
    boolean registrarIncidencia(IncidenciasDTO incidencia);
}
