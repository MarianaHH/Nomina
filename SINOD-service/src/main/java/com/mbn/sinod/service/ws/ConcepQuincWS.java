/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.service.ws;

import com.mbn.sinod.model.dto.ConcepQuincDTO;
import com.mbn.sinod.model.dto.ConcepQuincHTDTO;
import com.mbn.sinod.model.negocio.ConcepQuincService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author User
 */
@RestController
@RequestMapping("/ws/concepQuinc")
public class ConcepQuincWS {
    @Autowired
    ConcepQuincService concepQuincService;

    @RequestMapping(method = RequestMethod.GET, value = "/listarConcepQuinc",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody// anotacion que nos permite retornar un json
    public ConcepQuincDTO listarConceptos() {
        return concepQuincService.listaConcepQuinc();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/listarConcepQuincByEmpQuin",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody// anotacion que nos permite retornar un json
    public ConcepQuincDTO listarConceptosByEmpQuin(@RequestParam Integer empQuinc) {
        return concepQuincService.listaConcepQuincByEmpQuin(empQuinc);
    }

    @RequestMapping(method = RequestMethod.POST, value = "HT/listarConcepQuincByEmpQuinHT",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody// anotacion que nos permite retornar un json
    public ConcepQuincHTDTO listarConceptosByEmpQuinHT(@RequestParam Integer empQuinc) {
        return concepQuincService.listaConcepQuincByEmpQuinHT(empQuinc);
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/listarConceptosEmpleado",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody// anotacion que nos permite retornar un json
    public ConcepQuincDTO listaConceptosEmpl(@RequestParam Integer empleado) {
        return concepQuincService.listaConceptosEmpl(empleado);
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/listarConcepQuincByCabecera",
            produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody// anotacion que nos permite retornar un json
    public ConcepQuincDTO listarConceptosByCabecera(@RequestParam Integer cabecera) {
        return concepQuincService.listaConcepQuincByCabecera(cabecera);
    }
}
