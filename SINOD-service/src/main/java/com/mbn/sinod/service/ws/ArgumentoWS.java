/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.service.ws;

import com.mbn.sinod.model.dto.ArgumentoDTO;
import com.mbn.sinod.model.negocio.ArgumentoService;
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
 * @author mariana
 */
@RestController //Incluye las anotaciones @Controller y @ResponseBody,simplifica la implementación del controlador
@RequestMapping("/ws/argumento") 
public class ArgumentoWS {
    @Autowired
    ArgumentoService argumento;
    
    @RequestMapping(value = "/obtenerArgumento/",method = RequestMethod.GET)
    @ResponseBody
    public ArgumentoDTO obtenerArgumento(){
        return argumento.listarArgumentos();
    }
    
    @RequestMapping(value = "/obtenerArgumentoConstante/",method = RequestMethod.GET)
    @ResponseBody
    public ArgumentoDTO obtenerArgumentoConstante(){
        return argumento.listarArgumentosConstantes();
    }
    
    @RequestMapping(value = "/obtenerArgumentoVariable/",method = RequestMethod.GET)
    @ResponseBody
    public ArgumentoDTO obtenerArgumentoVariable(){
        return argumento.listarArgumentosVariables();
    }
 
    @RequestMapping(method = RequestMethod.POST, value = "/guardar/",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ArgumentoDTO guardar(@RequestBody ArgumentoDTO argu) {
        return argumento.guardar(argu);
    }

    
    
    @RequestMapping(method = RequestMethod.POST, value = "/eliminar/",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ArgumentoDTO eliminar(@RequestParam Integer argumentoid) {
        return argumento.eliminarArgumento(argumentoid);
    }
   
}
