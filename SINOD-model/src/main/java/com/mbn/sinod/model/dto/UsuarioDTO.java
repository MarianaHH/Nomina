
package com.mbn.sinod.model.dto;

import com.mbn.sinod.model.entidades.Usuario;
import java.util.List;

/**
 *
 * @author Francisco Rolando Muñoz M
 */
public class UsuarioDTO extends GenericDTO{
    
    private Usuario usuario;
    private List<Usuario> listaUsuario;

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
     * @return the listaUsuario
     */
    public List <Usuario> getListaUsuario() {
        return listaUsuario;
    }

    /**
     * @param listaUsuario the listaUsuario to set
     */
    public void setListaUsuario(List <Usuario> listaUsuario) {
        this.listaUsuario = listaUsuario;
    }
    
}
