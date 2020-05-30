/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.service.ws;

import com.mbn.sinod.model.dto.TipoCalculoDTO;
import com.mbn.sinod.model.negocio.TipoCalculoService;
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
@RequestMapping("/ws")
public class TipoCalculoWS {
    @Autowired
    TipoCalculoService tsgnomTipoCalculoService;

    @RequestMapping(method = RequestMethod.GET, value = "/listarTiposCalculos",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody// anotacion que nos permite retornar un json
    public TipoCalculoDTO listarTipoCalculos() {
        return tsgnomTipoCalculoService.listarTiposCalculo();
    }
}
