package com.mbn.sinod.model.dao;

import com.googlecode.genericdao.dao.hibernate.GenericDAO;
import com.mbn.sinod.model.entidades.Usuario;

/**
 *
 * @author Francisco Rolando Muñoz M
 */
public interface UsuarioDAO extends GenericDAO<Usuario, Integer> {

    public Usuario obtenerUsuarioPorId(int usuarioId);
}
