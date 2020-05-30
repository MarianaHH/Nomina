/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.web.security;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import org.picketlink.Identity;

/**
 *
 * @author Annel
 */
@Singleton
@Named("verifyIdentity")
public class VerifyIdentity {

    @Inject
    private Identity identity;

   /* public int getObtenerRol() {
        return ((UsuarioLogueado) identity.getAccount()).getUsuario().getRol();
    }
    
    public String getObtenerCorreo() {
        return ((UsuarioLogueado) identity.getAccount()).getUsuario().getEmail();
    }*/
    
}
