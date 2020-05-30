package com.mbn.sinod.web.security;

import com.mbn.sinod.model.entidades.Usuario;
import org.picketlink.idm.model.annotation.AttributeProperty;
import org.picketlink.idm.model.basic.User;

/**
 * Se crean el bean del usuario que inicie sesión en el sistema
 *
 * @author Francisco R M, MBN
 */
public class UsuarioLogueado extends User {

    @AttributeProperty
    private Usuario usuario;
    @AttributeProperty
    private int rol;
    @AttributeProperty
    private String correo;

    public UsuarioLogueado() {
    }

    public UsuarioLogueado(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the rol
     */
    public int getRol() {
        return rol;
    }

    /**
     * @param rol the rol to set
     */
    public void setRol(int rol) {
        this.rol = rol;
    }

    /**
     * @return the email
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param email the email to set
     */
    public void setCorreo(String email) {
        this.correo = email;
    }

}
