package com.mbn.sinod.model.negocio;

import com.mbn.sinod.model.dto.UsuarioDTO;
import com.mbn.sinod.model.entidades.Usuario;

public interface UsuarioService extends BaseService<Usuario, Integer> {

    UsuarioDTO obtenerUsuarioPorId(UsuarioDTO dto);
}
