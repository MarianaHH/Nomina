/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.service.ws;

import com.mbn.sinod.model.dto.FuncionDTO;
import com.mbn.sinod.model.negocio.FuncionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author mariana
 */
@RestController //Incluye las anotaciones @Controller y @ResponseBody,simplifica la implementación del controlador
@RequestMapping("/ws/funcion") 
public class FuncionWS{
    @Autowired
    FuncionService funcionService;
    
    @RequestMapping(value = "/obtenerFunciones/",method = RequestMethod.GET)
    @ResponseBody
    public FuncionDTO obtenerArgumento(){
        return funcionService.obtenerFunciones();
    }
}
