/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.service.ws;

import com.mbn.sinod.model.dto.EmpDTO;
import com.mbn.sinod.model.negocio.ConfirmaEmpleadoService;
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
public class ConfirmaEmpleadoWS implements Serializable {
    
    @Autowired
    ConfirmaEmpleadoService confirmaEmpleadoService;
    
    @RequestMapping(method = RequestMethod.POST, value = "/confEmpleado/",
            produces = MediaType.APPLICATION_JSON_VALUE)
    
    @ResponseBody
    public EmpDTO empDTO (@RequestParam(name = "cabecera") Integer cabecera, 
                         @RequestParam(name = "empleado") Integer empleado){
        return confirmaEmpleadoService.empDTO(cabecera, empleado);
               
    }
}
