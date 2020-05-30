package com.mbn.sinod.service.ws;

import com.mbn.sinod.model.dto.CatalogosDTO;
import com.mbn.sinod.model.negocio.CatalogosService;
import java.io.Serializable;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Clase en la que se implementan los servicios rest para catálogos
 *
 * @author Francisco R M, MBN
 */
@RestController
@RequestMapping("/ws")
public class CatalogosWS implements Serializable {

    @Autowired
    private CatalogosService catalogosService;
    private final Logger logger = Logger.getLogger(CatalogosWS.class.getName());

    /**
     * Web service de tipo rest que permite obtener los datos de un catalogo
     *
     * @param dto
     * @return
     */
    @RequestMapping(value = "/catalogos", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public CatalogosDTO obtenerCatalogo(@RequestBody CatalogosDTO dto) {
        logger.info("Ingresa al web service para obtener el catalogo de---------------------->" + dto.getClazz());
        return catalogosService.obtenerCatalogo(dto);
    }
    
 

}
