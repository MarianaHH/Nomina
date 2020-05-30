/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.service.ws;

import com.mbn.sinod.model.dto.CatIncidenciaDTO;
import com.mbn.sinod.model.negocio.CatIncidenciaService;
import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ambrosio
 */
@RestController
@RequestMapping("/ws/CatInci")
public class CatIncidenciaWS implements Serializable {

    @Autowired
    CatIncidenciaService tsgnomcatincidenciaService;

    @RequestMapping(method = RequestMethod.GET, value = "/listarCatIncidencias",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody// anotacion que nos permite retornar un json
    public CatIncidenciaDTO listarCatIncidencias() {
        return tsgnomcatincidenciaService.listarCatIncidencias();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/guardarActualizar",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public CatIncidenciaDTO guardarActualizarCatInci(@RequestBody CatIncidenciaDTO catIncidencia) {
        return tsgnomcatincidenciaService.guardarActualizarCatInci(catIncidencia);
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/eliminarId",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public CatIncidenciaDTO eliminarCatIncidenciasId(@RequestParam(name = "codCatincidenciaid") Integer id) {
        return tsgnomcatincidenciaService.eliminarCatIncidenciasId(id);
    }
}
