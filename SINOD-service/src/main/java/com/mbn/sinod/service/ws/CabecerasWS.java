/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.service.ws;

import com.mbn.sinod.model.dto.CabeceraDTO;
import com.mbn.sinod.model.dto.EmpQuincenaPorCabeceraDTO;
import com.mbn.sinod.model.negocio.CabeceraService;
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
 * @author Mi Pe
 */
@RestController
@RequestMapping("/ws/cabecera")
public class CabecerasWS implements Serializable {

    @Autowired
    CabeceraService cabeceraService;
    
    @RequestMapping(method = RequestMethod.POST, value = "/obtenerCabeceraPorId", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public CabeceraDTO obtenerCabeceraPorId(@RequestParam(value = "cabeceraId") Integer cabeceraId) {
        CabeceraDTO dto = new CabeceraDTO();
        dto.setCabecera(this.cabeceraService.obtenerCabeceraPorId(cabeceraId));
        return dto;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/listarCabeceras",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody// anotacion que nos permite retornar un json
    public CabeceraDTO listarCatIncidencias() {
        return cabeceraService.listaCabeceras();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/guardarActualizar",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public CabeceraDTO guardarActualizarCabecera(@RequestBody CabeceraDTO cabecera) {
        return cabeceraService.guardarActualizarCabecera(cabecera);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/calculaNomina",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody// anotacion que nos permite retornar un json
    public CabeceraDTO calculaNomina(@RequestParam(name = "cabeceraid_fk") Integer cabeceraid_fk) {
        return cabeceraService.calculaNomina(cabeceraid_fk);
    }

    @RequestMapping(value = "/listarEmpleadosCabecera/",
            method = RequestMethod.POST)
    @ResponseBody
    public EmpQuincenaPorCabeceraDTO obtenerIncidenciasQuincena(@RequestParam(name = "cabeceraid") Integer cabeceraid) {
        return cabeceraService.listarEmpleadosCabecera(cabeceraid);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/eliminar/", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public CabeceraDTO eliminarCabecera(@RequestParam Integer cabeceraId) {
        return cabeceraService.eliminarCabecera(cabeceraId);
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/validaPagosNomina/", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public CabeceraDTO validaPagosNomina(@RequestParam Integer cabeceraId) {
        return cabeceraService.validaPagosNomina(cabeceraId);
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/cargarImss/", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public CabeceraDTO cargarImss(@RequestParam String archivo, @RequestParam Integer cabeceraId) {
        return cabeceraService.cargarImss(archivo, cabeceraId);
    }

}
