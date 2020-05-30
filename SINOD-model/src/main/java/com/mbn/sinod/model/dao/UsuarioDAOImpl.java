package com.mbn.sinod.model.dao;

import com.googlecode.genericdao.dao.hibernate.GenericDAOImpl;
import com.mbn.sinod.model.comun.StaticConstantes;
import com.mbn.sinod.model.entidades.Usuario;
import org.hibernate.transform.Transformers;

public class UsuarioDAOImpl extends GenericDAOImpl<Usuario, Integer> implements UsuarioDAO {

    @Override
    public Usuario obtenerUsuarioPorId(int usuarioId) {

        Usuario usuario = (Usuario) getSession().createSQLQuery("SELECT cod_tipousuario, cod_usuario, cod_sistema, cod_rol "
                + "FROM sgco.tsgcotipousuario WHERE cod_usuario=? and cod_sistema=?;")
                .addScalar("cod_tipousuario")
                .addScalar("cod_usuario")
                .addScalar("cod_sistema")
                .addScalar("cod_rol")
                .setResultTransformer(Transformers.aliasToBean(Usuario.class))
                .setInteger(0, usuarioId)
                .setInteger(1, StaticConstantes.CODIGO_SISTEMA)
                .uniqueResult();
        return usuario;
    }

}
