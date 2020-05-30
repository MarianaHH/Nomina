package com.mbn.sinod.model.negocio;

import com.mbn.sinod.model.dao.UsuarioDAO;
import com.mbn.sinod.model.dto.UsuarioDTO;
import com.mbn.sinod.model.entidades.Usuario;
import org.springframework.beans.factory.annotation.Autowired;

public class UsuarioServiceImpl extends BaseServiceImpl<Usuario, Integer> implements UsuarioService {

    @Autowired
    private UsuarioDAO usuarioDAO;
    
    @Override
    public UsuarioDTO obtenerUsuarioPorId(UsuarioDTO dto){
        UsuarioDTO usuarioDTO = new UsuarioDTO();
        usuarioDTO.setUsuario(usuarioDAO.obtenerUsuarioPorId(dto.getUsuario().getCod_usuario()));
        return usuarioDTO;
    }
    
    /**
     * @return the usuarioDAO
     */
    public UsuarioDAO getUsuarioDAO() {
        return usuarioDAO;
    }

    /**
     * @param usuarioDAO the usuarioDAO to set
     */
    public void setUsuarioDAO(UsuarioDAO usuarioDAO) {
        this.usuarioDAO = usuarioDAO;
    }

}
