/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.service.ws;

import com.mbn.sinod.model.dto.DesgloseDTO;
import com.mbn.sinod.model.dto.DetalleDesgloseDTO;
import com.mbn.sinod.model.negocio.DetalleDesgloseService;
import java.io.Serializable;
import java.util.List;
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

public class DetalleDesgloseWS implements Serializable {
    
    @Autowired
    DetalleDesgloseService detalleDesgloseService;
    
    @RequestMapping(method = RequestMethod.POST, value = "/detalleDesgloce/",
            produces = MediaType.APPLICATION_JSON_VALUE) 
    @ResponseBody
    public DesgloseDTO conceptosPorEmp (@RequestParam(name = "cod_empleado") Integer cod_empleado, 
                                        @RequestParam(name = "cod_cabecera") Integer cod_cabecera){
        return detalleDesgloseService.desgloseDTO(cod_empleado, cod_cabecera);
       
        
    }
//        DesgloseDTO dto = new DesgloseDTO();
//        dto.setGetListaConcep((List<DetalleDesgloseDTO>) detalleDesgloseService.desgloseDTO(cod_empleado, cod_cabecera));
//        return dto;
//    }
    
}
