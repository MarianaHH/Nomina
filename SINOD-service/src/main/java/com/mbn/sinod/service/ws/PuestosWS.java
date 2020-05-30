/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.service.ws;

import com.mbn.sinod.model.dto.PuestosDTO;
import com.mbn.sinod.model.negocio.PuestosService;
import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author eduardotorres
 */
@RestController
@RequestMapping("/ws")
public class PuestosWS implements Serializable {
    
    @Autowired
    private PuestosService puestosService;
    
    @RequestMapping(method = RequestMethod.GET, value = "/listaPuestos", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public PuestosDTO listaPuestos() {
        PuestosDTO dto = new PuestosDTO();
        dto.setListarPuestos(puestosService.listaPuestos());
        return dto;
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/obtenerPuestosPorId", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public PuestosDTO obtenerEmpleadoPorId(@RequestParam (value = "puestosId") Integer puestosId) {
        PuestosDTO dto = new PuestosDTO();
        dto.setPuesto(this.puestosService.obtenerPuestosPorId(puestosId) );
        return dto;
    }

    /**
     * @return the puestosService
     */
    public PuestosService getPuestosService() {
        return puestosService;
    }

    /**
     * @param puestosService the puestosService to set
     */
    public void setPuestosService(PuestosService puestosService) {
        this.puestosService = puestosService;
    }
}
