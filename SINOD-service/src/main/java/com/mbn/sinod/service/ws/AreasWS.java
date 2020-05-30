
package com.mbn.sinod.service.ws;


import com.mbn.sinod.model.dto.AreasDTO;
import com.mbn.sinod.model.negocio.AreasService;
import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *Clase que se usa como WebService de tipo RESTful
 * 
 * @author Francisco R M, MBN
 * @version 2.0
 */
@RestController
@RequestMapping("/ws")
public class AreasWS implements Serializable {

    @Autowired
    private AreasService areasService;
    
    @RequestMapping(method = RequestMethod.GET, value = "/listaAreas", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public AreasDTO listaAreas() {
        AreasDTO dto = new AreasDTO();
        dto.setListarAreas(areasService.listaAreas());
        return dto;
    }
    
    @RequestMapping(method = RequestMethod.POST, value = "/obtenerAreasPorId", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public AreasDTO obtenerEmpleadoPorId(@RequestParam (value = "areasId") Integer areasId) {
        AreasDTO dto = new AreasDTO();
        dto.setArea(this.areasService.obtenerAreasPorId(areasId) );
        return dto;
    }
    
    
    /**
     * @return the areasService
     */
    public AreasService getAreasService() {
        return areasService;
    }

    /**
     * @param areasService the areasService to set
     */
    public void setAreasService(AreasService areasService) {
        this.areasService = areasService;
    }
    
    
}
