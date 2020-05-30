/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.service.ws;

import com.mbn.sinod.model.dto.EmpDTO;
import com.mbn.sinod.model.negocio.DetalleEmpService;
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
public class EmpWS implements Serializable {
    
    @Autowired
    DetalleEmpService detalleEmpService;
    
    @RequestMapping(method = RequestMethod.POST, value = "/detalleEmp/", 
            produces = MediaType.APPLICATION_JSON_VALUE)
    
    @ResponseBody
    public EmpDTO Emp (@RequestParam(name = "cabecera") Integer cabecera){
//         EmpDTO empDTO = detalleEmpService.empDTO(empleadoId);
//         return (EmpDTO) detalleEmpService;
            System.out.println("WS bien ");        
            
           return detalleEmpService.empDTO(cabecera);
    }
    
}
