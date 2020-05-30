/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.service.ws;

import com.mbn.sinod.model.dto.InfoValidacionesNominaDTO;
import com.mbn.sinod.model.negocio.ValidacionesNominaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Ivette
 */
@RestController
@RequestMapping("/ws")
public class ValidacionesNominaWS {
    
    @Autowired
    ValidacionesNominaService validacionesNominaService;
    
     @RequestMapping(method = RequestMethod.POST,value = "/informacionValidacionesdeAltas",produces=
        MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public InfoValidacionesNominaDTO obtenerValidacionesAltas() {

     
         return validacionesNominaService.detallesValidacionesNomina();
        
    }
    
}
