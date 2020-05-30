/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.service.ws;

import com.mbn.sinod.model.dto.CatConceptosSATDTO;
import com.mbn.sinod.model.negocio.CatConceptosSATService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ambrosio
 */
@RestController
@RequestMapping("/ws/SAT")
public class CatConceptosSATWS {
    @Autowired
    CatConceptosSATService tsgnomcatConceptosSATService;

    @RequestMapping(method = RequestMethod.GET, value = "/listarCatConceptosSAT",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody// anotacion que nos permite retornar un json
    public CatConceptosSATDTO listarCatConceptosSATs() {
        return tsgnomcatConceptosSATService.listarConceptosSAT();
    }
}
