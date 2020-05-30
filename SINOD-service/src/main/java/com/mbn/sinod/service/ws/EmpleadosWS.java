package com.mbn.sinod.service.ws;

import com.mbn.sinod.model.dto.ConcepQuincHTDTO;
import com.mbn.sinod.model.dto.EmpleadoDTO;
import com.mbn.sinod.model.negocio.EmpleadoService;
import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Clase que se usa como WebService de tipo RESTful
 *
 * @author Francisco R M, MBN
 */
@RestController
@RequestMapping("/ws")
public class EmpleadosWS implements Serializable {

    @Autowired
    private EmpleadoService empleadoService;

    @RequestMapping(method = RequestMethod.GET, value = "/listaEmpleados", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public EmpleadoDTO listarEmpleados() {
        EmpleadoDTO dto = new EmpleadoDTO();
        dto.setListaEmpleados(this.empleadoService.listaEmpleados());
        return dto; 
    }

    @RequestMapping(method = RequestMethod.POST, value = "/obtenerEmpleadoPorId", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public EmpleadoDTO obtenerEmpleadoPorId(@RequestParam(value = "empleadoId") Integer empleadoId) {
        EmpleadoDTO dto = new EmpleadoDTO();
        dto.setEmpleado(this.empleadoService.obtenerEmpleadoPorId(empleadoId));
        return dto;
    }

}
