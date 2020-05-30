/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.service.ws;

import com.mbn.sinod.model.dto.ConfPagoDTO;
import com.mbn.sinod.model.negocio.ConfPagoService;
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
 * @author eduardotorres
 */
@RestController
@RequestMapping("/ws/pagos")
public class ConfPagoWS {

    @Autowired
    ConfPagoService tsgnomconfpagoService;

    @RequestMapping(method = RequestMethod.POST, value = "/pagoRF/",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ConfPagoDTO guardarRF(@RequestBody ConfPagoDTO pago1) {
//        System.out.println("ws " + concepto);
        return tsgnomconfpagoService.guardarAutorizacionRF(pago1);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/pagoRH/",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ConfPagoDTO guardarRH(@RequestBody ConfPagoDTO pago2) {
//        System.out.println("ws " + concepto);
        return tsgnomconfpagoService.guardarAutorizacionRH(pago2);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/pagoEMP/",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ConfPagoDTO guardarEMP(@RequestParam Integer empquincenaFK, @RequestParam Boolean pago3) {
//        System.out.println("ws " + concepto);
        return tsgnomconfpagoService.guardarAutorizacionEMP(empquincenaFK, pago3);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/validarTodas/",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ConfPagoDTO validarTodas(@RequestParam Integer cabecera) {
//        System.out.println("ws " + concepto);
        return tsgnomconfpagoService.validarTodas(cabecera);
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/validarTodasRH/",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ConfPagoDTO validarTodasRH (@RequestParam Integer cabecera) {
//        System.out.println("ws " + concepto);
        return tsgnomconfpagoService.validarTodasRH(cabecera);
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/rechazarTodasRF/",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ConfPagoDTO rechazarTodasRF (@RequestParam Integer cabecera) {
//        System.out.println("ws " + concepto);
        return tsgnomconfpagoService.rechazarTodasRF(cabecera);
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/rechazarTodasRH/",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ConfPagoDTO rechazarTodasRH (@RequestParam Integer cabecera) {
//        System.out.println("ws " + concepto);
        return tsgnomconfpagoService.rechazarTodasRH(cabecera);
    }
}
