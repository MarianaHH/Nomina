/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.service.ws;


import com.mbn.sinod.model.dto.InfoHistorialRhDTO;
import com.mbn.sinod.model.negocio.HistorialEmpleadosRhService;
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
public class HistorialEmpleadosRhWS {
    
    @Autowired
    HistorialEmpleadosRhService historialEmpleadosRhService;
    
    @RequestMapping(method = RequestMethod.POST,value = "/informacionHistorialRh",produces=
        MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public InfoHistorialRhDTO obtenerHistorialRh() {

     
         return historialEmpleadosRhService.detallesHistorialRh();
        
    }
    
    @RequestMapping(method = RequestMethod.POST,value = "/obtenerHistorialId",produces=
        MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public InfoHistorialRhDTO obtenerPersonal(@RequestParam Integer cod_empleadoid){

     
         return historialEmpleadosRhService.informacionPersonal(cod_empleadoid);
        
    }
    
}
