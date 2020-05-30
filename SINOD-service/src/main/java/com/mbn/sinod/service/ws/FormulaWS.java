/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.service.ws;

import com.mbn.sinod.model.dto.FormulaDTO;
import com.mbn.sinod.model.negocio.FormulaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ambrosio
 */
@RestController
@RequestMapping("/ws/formula")
public class FormulaWS {

    @Autowired
    FormulaService tsgnomFormulaService;

    @RequestMapping(method = RequestMethod.GET, value = "/listarFormulas",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody// anotacion que nos permite retornar un json
    public FormulaDTO listarFormulas() {
        return tsgnomFormulaService.listarFormulas();
    }
    
    
    @RequestMapping(method = RequestMethod.POST, value = "/guardar/",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public FormulaDTO guardar(@RequestBody FormulaDTO formula) {
        return tsgnomFormulaService.guardar(formula);
    }
}
