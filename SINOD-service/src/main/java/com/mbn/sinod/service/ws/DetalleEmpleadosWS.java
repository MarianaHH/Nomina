/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.service.ws;

import com.mbn.sinod.model.dto.InformacionEmpleadosDTO;
import com.mbn.sinod.model.negocio.DetalleEmpleadosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Ivette
 */
@RestController
@RequestMapping("/ws")
public class DetalleEmpleadosWS {
    
    @Autowired
    DetalleEmpleadosService detalleempleadosService;
    
    @RequestMapping(method = RequestMethod.POST,value = "/informacionEmpleados",produces=
        MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public InformacionEmpleadosDTO obtenerDetallesEmpleados() {

     
         return detalleempleadosService.detallesEmpleados();
        
    }
    
    @RequestMapping(method = RequestMethod.POST,value = "/empleadosPorArea",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public InformacionEmpleadosDTO empleadosPorArea(@RequestParam Integer area) {
         return detalleempleadosService.empleadosPorArea(area);
    }
    
}
