/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.service.ws;


import com.mbn.sinod.model.dto.QuincenasDTO;
import com.mbn.sinod.model.negocio.QuincenasService;
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
 * @author mipe
 */
//Arnold
//@RestController
//@RequestMapping("/ws")
//public class QuincenasWS implements Serializable {
//    
//    @Autowired
//    private QuincenasService quincenasService;
//    
//    @RequestMapping(method = RequestMethod.GET, 
//value = "/listaquincenas", produces = MediaType.APPLICATION_JSON_VALUE)
//    @ResponseBody
//    public quincenasDTO listarquincenass() {
//        quincenasDTO dto = new quincenasDTO();
//        dto.setListaquincenas( this.quincenasService.listaquincenas() );
//        return dto;
//    }

@RestController
@RequestMapping("/ws/Quincena")
public class QuincenasWS implements Serializable {

    @Autowired
    QuincenasService Quincenaservice;

    @RequestMapping(value = "/listarQuincenas", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public QuincenasDTO listQuincenas() {
        return Quincenaservice.listQuincenas();
    }
    
    @RequestMapping(value = "/QuincenasFuturas", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public QuincenasDTO listQuinFuturas() {
        return Quincenaservice.listQuinFuturas();
    }
     @RequestMapping(method = RequestMethod.POST, value = "/guardarQuincena/",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public QuincenasDTO guardar(@RequestBody QuincenasDTO quincena) {
        //System.out.println("ws " + q.getArgumento().getCodNbargumento());
        return Quincenaservice.guardar(quincena);
    }
    
    @RequestMapping(value = "/quincenaActual", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public QuincenasDTO quincenaActual() {
        return Quincenaservice.quincenaActual();
    }
    
    
}
