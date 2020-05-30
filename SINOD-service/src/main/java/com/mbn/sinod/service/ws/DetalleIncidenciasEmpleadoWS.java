/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.service.ws;

import com.mbn.sinod.model.dto.IncidenciasDTO;
import com.mbn.sinod.model.dto.IncidenciasPorEmpleadoDTO;
import com.mbn.sinod.model.negocio.DetalleIncidenciasEmpleadoService;
import java.io.Serializable;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Karla
 */
@RestController
@RequestMapping("/ws")
public class DetalleIncidenciasEmpleadoWS implements Serializable{
    
    @Autowired
    DetalleIncidenciasEmpleadoService detalleIncidenciasEmpleadoService;
    
    @RequestMapping(value = "/incidenciasPorEmpleado", method = RequestMethod.POST, 
            produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public IncidenciasPorEmpleadoDTO incidenciasPorEmpleado(@RequestParam Integer reporta){
        return detalleIncidenciasEmpleadoService.incidenciasPorEmpleado(reporta);
    }

    @RequestMapping(value = "/incidenciasPorQuincena", method = RequestMethod.POST, 
            produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public IncidenciasPorEmpleadoDTO incidenciasPorQuincena(@RequestParam Integer quincena){
        return detalleIncidenciasEmpleadoService.incidenciasPorQuincena(quincena);
    }
    
    @RequestMapping(value = "/incidenciasPorEmpleadoQuincena", method = RequestMethod.POST, 
            produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public IncidenciasPorEmpleadoDTO incidenciasPorEmpleadoQuincena(@RequestParam Integer empleado, @RequestParam Integer quincena){
        return detalleIncidenciasEmpleadoService.incidenciasPorEmpleadoQuincena(empleado, quincena);
    }
    
    @RequestMapping(value = "/incidenciasPorQuincenaArea", method = RequestMethod.POST, 
            produces = { MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public IncidenciasPorEmpleadoDTO incidenciasPorQuincenaArea(@RequestParam Integer quincena, @RequestParam Integer area){
        return detalleIncidenciasEmpleadoService.incidenciasPorQuincenaArea(quincena, area);
    }
    
    @RequestMapping(value = "/eliminarIncidenciaEmpleado", method = RequestMethod.POST)
    @ResponseBody
    public boolean eliminarIncidenciaEmpleado(@RequestParam Integer incidenciaid, @RequestParam Integer reporta){
        return detalleIncidenciasEmpleadoService.eliminarIncidenciaEmpleado(incidenciaid, reporta);
    }
    
    @RequestMapping(value = "/actualizarComentariosIncidencia", method = RequestMethod.POST)
    @ResponseBody
    public boolean actualizarComentariosIncidencia(@RequestParam Integer incidenciaid,
            @RequestParam String comentarios, @RequestParam Integer reporta){
        return detalleIncidenciasEmpleadoService.actualizarComentariosIncidencia(incidenciaid, comentarios, reporta);
    } 
    
    @RequestMapping(value = "/actualizarImporteIncidencia", method = RequestMethod.POST)
    @ResponseBody
    public boolean actualizarImporteIncidencia(@RequestParam Integer incidenciaid,
            @RequestParam BigDecimal importe, @RequestParam Integer reporta){
        return detalleIncidenciasEmpleadoService.actualizarImporteIncidencia(incidenciaid, importe, reporta);
    }
    
    @RequestMapping(value = "/actualizarIncidencia", method = RequestMethod.POST)
    @ResponseBody
    public boolean actualizarIncidencia(@RequestParam Integer incidenciaid,
            @RequestParam String comentarios,
            @RequestParam BigDecimal importe, @RequestParam Integer reporta){
        return detalleIncidenciasEmpleadoService.actualizarIncidencia(incidenciaid,comentarios, importe, reporta);
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/registrarIncidencia")
    @ResponseBody
    public boolean registrarIncidencia(@RequestBody IncidenciasDTO incidencia) {
        return detalleIncidenciasEmpleadoService.registrarIncidencia(incidencia);
    }

    public DetalleIncidenciasEmpleadoService getDetalleIncidenciasEmpleadoService() {
        return detalleIncidenciasEmpleadoService;
    }

    public void setDetalleIncidenciasEmpleadoService(DetalleIncidenciasEmpleadoService detalleIncidenciasEmpleadoService) {
        this.detalleIncidenciasEmpleadoService = detalleIncidenciasEmpleadoService;
    }
}
