/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.service.ws;

import com.mbn.sinod.model.dto.EmpQuincenasDTO;
import com.mbn.sinod.model.negocio.EmpQuincenasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
@RequestMapping("/ws/EmpQuincena")
public class EmpQuincenasWS {
    @Autowired
    EmpQuincenasService empQuincenaService; 

    @RequestMapping(method = RequestMethod.GET, value = "/listarEmpQuincenas",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody// anotacion que nos permite retornar un json
    public EmpQuincenasDTO listarEmpQuincenas() {
        return empQuincenaService.listaEmpQuincenas();
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/listarEmpQuincenas/cabecera",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody// anotacion que nos permite retornar un json
    public EmpQuincenasDTO listarEmpQuincenas(@RequestParam(name = "cabeceraid_fk") Integer cabeceraid_fk) {
        return empQuincenaService.listaEmpQuincenas(cabeceraid_fk);
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/insertaEmpleadosQuincena",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody// anotacion que nos permite retornar un json
    public EmpQuincenasDTO insertaEmpleadosQuincena(@RequestParam(name = "cabeceraid_fk") Integer cabeceraid_fk) {
        return empQuincenaService.insertaEmpleadosQuincena(cabeceraid_fk);
    }
}
