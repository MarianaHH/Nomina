/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.service.ws;


import com.mbn.sinod.model.dto.ValidacionAltasDTO;
import com.mbn.sinod.model.negocio.ValidarAltasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;
/**
 *
 * @author mariana
 */
@RestController //Incluye las anotaciones @Controller y @ResponseBody,simplifica la implementación del controlador
@RequestMapping("/ws") 
public class ValidarAltaWS {
     @Autowired
     ValidarAltasService validacionAltasService;
     
     @RequestMapping(value = "detalleempleados/validar/altas",
            method = RequestMethod.GET)
    @ResponseBody
    public ValidacionAltasDTO obtenerAltas(){
        return validacionAltasService.listarAltasAValidar();
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "detallesEmpleados/validarCadaAlta",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ValidacionAltasDTO validarCadaAlta(@RequestBody ValidacionAltasDTO altas) {
        System.out.println("ws altas  cu" + altas.getListaInformacionValidar().get(0).getNom_empleado());
        return validacionAltasService.validarCadaAlta(altas);
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "detallesEmpleados/validarAltasAceptadas",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ValidacionAltasDTO validarAltasAceptadas(@RequestBody ValidacionAltasDTO altas) {
        System.out.println("ws altas aceptar todas " + altas.getListaInformacionValidar().get(0).getNom_empleado());
        return validacionAltasService.validarAltasAceptadas(altas);
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "detallesEmpleados/validarAltasRechazadas",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ValidacionAltasDTO validarAltasRechazadas(@RequestBody ValidacionAltasDTO altas) {
         System.out.println("ws altas rechazar todas " + altas.getListaInformacionValidar().get(0).getNom_empleado());
        return validacionAltasService.validarAltasRechazadas(altas);
    }
    
    
    
}
