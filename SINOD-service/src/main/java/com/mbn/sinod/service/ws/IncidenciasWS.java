/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.service.ws;

import com.mbn.sinod.model.dto.IncidenciasDTO;
import com.mbn.sinod.model.negocio.IncidenciasService;
import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Karla
 */
@RestController //Incluye las anotaciones @Controller y @ResponseBody,simplifica la implementación del controlador
@RequestMapping("/ws") //Indica la ruta de acceso
public class IncidenciasWS implements Serializable {
    
    @Autowired
    IncidenciasService incidenciasService;
    
    @RequestMapping(method = RequestMethod.GET, value = "/listarIncidencias", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public IncidenciasDTO listarIncidencias(){
        IncidenciasDTO dto = new IncidenciasDTO();
        dto.setListaIncidencias(incidenciasService.listarIncidencias());
        return dto;
    }

}
