/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.service.ws;

import com.mbn.sinod.model.dto.EjercicioFiscalDTO;
import com.mbn.sinod.model.negocio.EjercicioFiscalService;
import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author mipe
 */
@RestController
@RequestMapping("/ws")
public class EjercicioFiscalWS implements Serializable{
    
    @Autowired
    EjercicioFiscalService ejercicioFiscalService;
    
     @RequestMapping(value = "/EjerFiscal", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
     
    @ResponseBody
    public EjercicioFiscalDTO listQuincenas() {
        return ejercicioFiscalService.listaEjercicios();
    }
}
