/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.service.ws;

import com.mbn.sinod.model.dto.ValidacionBajasDTO;
import com.mbn.sinod.model.negocio.ValidarBajasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
/**
 *
 * @author Ivette
 */
@RestController //Incluye las anotaciones @Controller y @ResponseBody,simplifica la implementación del controlador
@RequestMapping("/ws") 
public class ValidarBajasWS {
    
     @Autowired
     ValidarBajasService validarBajasService;
     
     @RequestMapping(value = "validar/bajas",
            method = RequestMethod.GET)
    @ResponseBody
    public ValidacionBajasDTO obtenerBajas(){
        return validarBajasService.listarBajasAValidar();
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "validarCadaBaja",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ValidacionBajasDTO validarCadaBaja(@RequestBody ValidacionBajasDTO bajas) {
        System.out.println("ws bajas cu" + bajas.getListaInformacionValidar().get(0).getNom_empleado());
        return validarBajasService.validarCadaBaja(bajas);
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "validarBajasAceptadas",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ValidacionBajasDTO validarBajasAceptadas(@RequestBody ValidacionBajasDTO bajas) {
        System.out.println("ws bajas aceptar todas " + bajas.getListaInformacionValidar().get(0).getNom_empleado());
        return validarBajasService.validarBajasAceptadas(bajas);
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "validarBajasRechazadas",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ValidacionBajasDTO validarBajasRechazadas(@RequestBody ValidacionBajasDTO bajas) {
         System.out.println("ws bajas rechazar todas " + bajas.getListaInformacionValidar().get(0).getNom_empleado());
        return validarBajasService.validarBajasRechazadas(bajas);
    }
    
    

}
