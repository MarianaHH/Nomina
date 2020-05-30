/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.service.ws;

import com.mbn.sinod.model.dto.EstatusNominaDTO;
import com.mbn.sinod.model.negocio.EstatusNominaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author User
 */
@RestController //Incluye las anotaciones @Controller y @ResponseBody,simplifica la implementación del controlador
@RequestMapping("/ws/EstatusNomina") 
public class EstatusNominaWS {
    @Autowired
    EstatusNominaService estatus;
    
    @RequestMapping(value = "/listarEstatus/",method = RequestMethod.GET)
    @ResponseBody
    public EstatusNominaDTO obtenerArgumento(){
        return estatus.listarEstatusNominas();
    }
}
