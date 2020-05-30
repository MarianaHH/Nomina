/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.service.ws;

import com.mbn.sinod.model.dto.DetalleDesglosePercepcionDTO;
import com.mbn.sinod.model.dto.DetalleDesgloPercepDTO;
import com.mbn.sinod.model.negocio.DetalleDesglosePercepcionService;
import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author torre
 */
@RestController
@RequestMapping("/ws") 

public class DetalleDesglosePercepcionWS implements Serializable {
    
    @Autowired
    DetalleDesglosePercepcionService detalleDesglosePercepcionService;
    
    @RequestMapping(method = RequestMethod.POST, value = "/detalleDesglocePercecion/",
            produces = MediaType.APPLICATION_JSON_VALUE)
    
    @ResponseBody
    public DetalleDesgloPercepDTO detalleDesglosePercepcion (@RequestParam(name = "cod_empleado") Integer cod_empleado, 
                                                             @RequestParam(name = "cod_cabecera") Integer cod_cabecera){
        return detalleDesglosePercepcionService.detalleDesglocePercepDTO(cod_empleado, cod_cabecera);
               
    }
}
