/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.service.ws;

import com.mbn.sinod.model.dto.SumaDesgloseDTO;
import com.mbn.sinod.model.negocio.SumaDesgloseService;
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
@RequestMapping("/ws/desglose")
public class SumaDesgloseWS {
    
    @Autowired
    SumaDesgloseService TsgnomempquincenaService;
    
    @RequestMapping(method = RequestMethod.POST, value = "/suma/",
    produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody// anotacion que nos permite retornar un json
    public SumaDesgloseDTO sumar(@RequestParam Integer empleado, @RequestParam Integer cabecera) {
        return TsgnomempquincenaService.sumaDesglose(cabecera, empleado);
    }
}
