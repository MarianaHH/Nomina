/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.service.ws;


import com.mbn.sinod.model.dto.DesgloseEmpleadoDTO;
import com.mbn.sinod.model.dto.EmpleadosNomDTO;
import com.mbn.sinod.model.negocio.EmpleadosNomService;
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
 * @author Ivette
 */
@RestController
@RequestMapping("/ws")
public class EmpleadosNomWS implements Serializable{
    
    @Autowired
    EmpleadosNomService empleadosService;
        
    @RequestMapping(method = RequestMethod.GET, value = "/listaEmpleadosNom", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public EmpleadosNomDTO listarEmpleadosNom() {
        EmpleadosNomDTO dto = new EmpleadosNomDTO();
        dto.setListarEmpleadosNom(empleadosService.listarEmpleadosNom());
        return dto;
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/obtenerEmpleadonomPorIdrh", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public EmpleadosNomDTO obtenerEmpleadonomPorIdrh(@RequestParam(value = "idempleadorh") Integer idempleadorh) {
        EmpleadosNomDTO dto = new EmpleadosNomDTO();
        dto.setEmpleado(this.empleadosService.obtenerEmpleadonomPorIdrh(idempleadorh));
        return dto;
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/nomina/guardar/",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public EmpleadosNomDTO guardar(@RequestBody EmpleadosNomDTO empleado) {
        return empleadosService.guardar(empleado);
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/obtenerEmpleadosnomPorIdNom", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public EmpleadosNomDTO obtenerEmpleadosnomPorIdNom(@RequestParam(value = "idempleadonom") Integer idempleadonom) {
        EmpleadosNomDTO dto = new EmpleadosNomDTO();
        dto.setEmpleado(this.empleadosService.obtenerEmpleadosnomPorIdNom(idempleadonom));
        return dto;
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/obtenerEmpleadosnomPorIdNomHT", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public DesgloseEmpleadoDTO obtenerEmpleadosnomPorIdNomHT(@RequestParam(value = "idempleadonom") Integer idempleadonom) {
        DesgloseEmpleadoDTO dto = new DesgloseEmpleadoDTO();
        dto.setListaDesgloce(this.empleadosService.obtenerEmpleadosnomPorIdNomHT(idempleadonom).getListaDesgloce());
        return dto;
    }
}
