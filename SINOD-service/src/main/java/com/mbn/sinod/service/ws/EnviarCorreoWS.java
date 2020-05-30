/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.service.ws;


import com.mbn.sinod.model.dto.IncidenciasQuincenaDTO;
import com.mbn.sinod.model.dto.ValidacionAltasDTO;
import com.mbn.sinod.model.dto.ValidacionBajasDTO;
import com.mbn.sinod.model.negocio.EnviarCorreoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author mariana
 */
@RestController //Incluye las anotaciones @Controller y @ResponseBody,simplifica la implementación del controlador
@RequestMapping("/ws/correo") 
public class EnviarCorreoWS {
    @Autowired
     EnviarCorreoService service;
   
    @RequestMapping(value = "/enviarCorreo/",method = RequestMethod.POST)
    @ResponseBody
    public void enviarEmail(@RequestBody IncidenciasQuincenaDTO incidenciasValidadas){
       
       service.enviarCorreos(incidenciasValidadas);
       
    }
 
    @RequestMapping(value = "/enviarCorreoValidarAltas/",method = RequestMethod.POST)
    @ResponseBody
    public void enviarEmailValidarAltas(@RequestBody ValidacionAltasDTO altas){
       
       service.enviarCorreosValidarAltas(altas);
       System.out.println("jsjsjsjsjs WS");
    }
    
    @RequestMapping(value = "/enviarCorreoValidarBajas/",method = RequestMethod.POST)
    @ResponseBody
    public void enviarEmailValidarBajas(@RequestBody ValidacionBajasDTO bajas){
       
       service.enviarCorreosValidarBajas(bajas);
       System.out.println("jsjsjsjsjs WS");
    }
    
}
