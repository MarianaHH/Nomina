/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.service.ws;

import com.mbn.sinod.model.dto.IncidenciasQuincenaDTO;
import com.mbn.sinod.model.negocio.IncidenciasQuincenaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author mariana
 */
@RestController //Incluye las anotaciones @Controller y @ResponseBody,simplifica la implementación del controlador
@RequestMapping("/ws")
public class IncidenciasQuincenaWS {

    @Autowired
    IncidenciasQuincenaService incidenciasQuincenaService;

    @RequestMapping(value = "/incidenciasQuincena/obtenerIncidenciasQuincena/",
            method = RequestMethod.GET)
    @ResponseBody
    public IncidenciasQuincenaDTO obtenerIncidenciasQuincena() {
        return incidenciasQuincenaService.listarincidenciasQuincena();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/incidenciasQuincena/validarTodas/",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public IncidenciasQuincenaDTO validarTodas(@RequestBody IncidenciasQuincenaDTO incidenciasValidadas) {
        return incidenciasQuincenaService.validarTodas(incidenciasValidadas);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/incidenciasQuincena/rechazarTodas/",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public IncidenciasQuincenaDTO rechazarTodas(@RequestBody IncidenciasQuincenaDTO incidenciasValidadas) {
        return incidenciasQuincenaService.rechazarTodas(incidenciasValidadas);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/incidenciasQuincena/validarIncidencias/",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public IncidenciasQuincenaDTO validarIncidencias(@RequestBody IncidenciasQuincenaDTO incidenciasValidadas) {
        return incidenciasQuincenaService.validarIncidencias(incidenciasValidadas);
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/incidenciasQuincena/autorizarTodas/",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public IncidenciasQuincenaDTO autorizarTodas(@RequestBody IncidenciasQuincenaDTO incidenciasAutorizadas) {
        return incidenciasQuincenaService.autorizarTodas(incidenciasAutorizadas);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/incidenciasQuincena/denegarTodas/",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public IncidenciasQuincenaDTO denegarTodas(@RequestBody IncidenciasQuincenaDTO incidenciasNoAutorizadas) {
        return incidenciasQuincenaService.denegarTodas(incidenciasNoAutorizadas);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/incidenciasQuincena/autorizarIncidencias/",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public IncidenciasQuincenaDTO autorizarIncidencias(@RequestBody IncidenciasQuincenaDTO incidencias) {
        return incidenciasQuincenaService.autorizarIncidencias(incidencias);
    }
    
    @RequestMapping(value = "/incidenciasQuincena/incidenciasQuincenaPorArea/",
            method = RequestMethod.POST)
    @ResponseBody
    public IncidenciasQuincenaDTO incidenciasQuincenaPorArea(@RequestParam Integer area) {
        return incidenciasQuincenaService.incidenciasQuincenaPorArea(area);
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/incidenciasQuincena/autorizarPagoIncidencias/",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public IncidenciasQuincenaDTO autorizarPagoIncidencias(@RequestBody IncidenciasQuincenaDTO incidenciasAutorizadas) {
        return incidenciasQuincenaService.autorizarPagoIncidencias(incidenciasAutorizadas);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/incidenciasQuincena/denegarPagoIncidencias/",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public IncidenciasQuincenaDTO denegarPagoIncidencias(@RequestBody IncidenciasQuincenaDTO incidenciasNoAutorizadas) {
        return incidenciasQuincenaService.denegarPagoIncidencias(incidenciasNoAutorizadas);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/incidenciasQuincena/autorizarPagosIncidencias/",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public IncidenciasQuincenaDTO autorizarPagosIncidencias(@RequestBody IncidenciasQuincenaDTO incidencias) {
        return incidenciasQuincenaService.autorizarPagosIncidencias(incidencias);
    }
    
    @RequestMapping(value = "/incidenciasQuincena/posponerPagoIncidencia", method = RequestMethod.POST)
    @ResponseBody
    public boolean posponerPagoIncidencia(@RequestParam Integer incidenciaid,
            @RequestParam String comentarios, @RequestParam Integer modifica){
        return incidenciasQuincenaService.posponerPagoIncidencia(incidenciaid, comentarios, modifica);
    } 
}
