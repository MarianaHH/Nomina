package com.mbn.sinod.service.ws;

import com.mbn.sinod.model.dto.UsuarioDTO;
import com.mbn.sinod.model.negocio.UsuarioService;
import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ws")
public class UsuarioWS implements Serializable{

    @Autowired
    private UsuarioService usuarioService;

    @RequestMapping(method = RequestMethod.POST, value = "/obtenerUsuarioPorId", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public UsuarioDTO obtenerUsuarioPorId(@RequestBody UsuarioDTO dto) {
        return usuarioService.obtenerUsuarioPorId(dto);
    }

    /**
     * @return the usuarioService
     */
    public UsuarioService getUsuarioService() {
        return usuarioService;
    }

    /**
     * @param usuarioService the usuarioService to set
     */
    public void setUsuarioService(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

}
