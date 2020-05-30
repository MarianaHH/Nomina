/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.service.ws;

import com.mbn.sinod.model.dto.ConceptoDTO;
import com.mbn.sinod.model.negocio.ConceptoService;
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
@RequestMapping("/ws/concepto")
public class ConceptoWS {
    
    @Autowired
    ConceptoService tsgnomconceptoService;

    @RequestMapping(method = RequestMethod.GET, value = "/listarConceptos",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody// anotacion que nos permite retornar un json
    public ConceptoDTO listarConceptos() {
        return tsgnomconceptoService.listarConceptos();
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/listarConceptos/percepcion",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody// anotacion que nos permite retornar un json
    public ConceptoDTO listarConceptosPercepcion() {
        return tsgnomconceptoService.listarConceptosPercepcion();
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/listarConceptos/deduccion",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody// anotacion que nos permite retornar un json
    public ConceptoDTO listarConceptosDeduccion() {
        return tsgnomconceptoService.listarConceptosDeduccion();
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/eliminar/",produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ConceptoDTO eliminarConcepto(@RequestParam Integer conceptoid) {
        return tsgnomconceptoService.eliminarConcepto(conceptoid);
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/guardar/",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ConceptoDTO guardar(@RequestBody ConceptoDTO concepto) {
        return tsgnomconceptoService.guardarConcepto(concepto);
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/guardarPrioridad/",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ConceptoDTO guardarPrioridad(@RequestBody ConceptoDTO concepto) {
        return tsgnomconceptoService.guardarPrioridad(concepto);
    }
    
}
