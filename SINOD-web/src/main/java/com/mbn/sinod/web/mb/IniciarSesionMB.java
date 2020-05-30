/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.web.mb;

import com.mbn.sinod.model.entidades.Tsgrhempleados;
import com.mbn.sinod.model.entidades.Usuario;
import com.mbn.sinod.web.client.EmpleadosWSClient;
import com.mbn.sinod.web.client.UsuarioWSClient;
import com.mbn.sinod.web.util.Encryption;
import com.mbn.sinod.web.util.ResourceBundles;
import java.io.IOException;
import java.io.Serializable;
import java.util.ResourceBundle;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Clase que permite verificar la sesión del sistema
 *
 * @author Javier Sánchez Trejo, MBN
 * @since 18/12/2017
 */
@ManagedBean(name = "iniciarSesionMB", eager = true)
@SessionScoped
public class IniciarSesionMB implements Serializable {

    private static final ResourceBundle bundle = ResourceBundle.getBundle(ResourceBundles.CONFIG.getBundleName());
    private Usuario usuario;
    private Tsgrhempleados empleado;
    private boolean usuarioLogueado;

    @PostConstruct
    public void iniciarVariables() {
        usuario = new Usuario();
        empleado = new Tsgrhempleados();
    }

    /**
     * Se verifica que el usuario haya ingresado por login previamente
     *
     * @throws IOException
     * @throws Exception
     */
    public void verificarSesion() throws IOException, Exception {
//        System.out.println("Verificando sesión==========>>");

        //boolean usuarioLogueado = false;
        ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();

        //Encript data
        Encryption encrypt = new Encryption();
        String cod_usuario = "";
        String cod_empleado = "";

        // get cookies
        HttpServletRequest httpServletRequest = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        Cookie[] cookies = httpServletRequest.getCookies();
//        System.out.println("Cookies encontradas: ==============>");
        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
//                System.out.println("Cookie: " + cookies[i].getName() + " - " + cookies[i].getValue());
                if (cookies[i].getName().equals("mbnUmbn")) {
                    cod_usuario = cookies[i].getValue();
                } else if (cookies[i].getName().equals("mbnEmbn")) {
                    cod_empleado = cookies[i].getValue();
                }
            }
        }

        if (!cod_usuario.equals("") && !cod_empleado.equals("") && isUsuarioLogueado() == false) {
//            System.out.println("Usuario logueado============>");
            setUsuarioLogueado(true);

            //Decrypt data
            cod_usuario = encrypt.decrypt(cod_usuario);
            cod_empleado = encrypt.decrypt(cod_empleado);
//            System.out.println("Usuario: " + cod_usuario);
//            System.out.println("Empleado: " + cod_empleado);

            setUsuario(UsuarioWSClient.obtenerUsuarioPorId(Integer.parseInt(cod_usuario)));
            setEmpleado(EmpleadosWSClient.obtenerEmpleadoPorId(Integer.parseInt(cod_empleado)));

//            System.out.println("DATOS OBTENIDOS===========>");
//            System.out.println("Nombre empleado: " + empleado.getDesNombre());
//            System.out.println("Rol: " + usuario.getCod_rol());
            FacesContext facesContext = FacesContext.getCurrentInstance();
            ExternalContext externalContext = facesContext.getExternalContext();
            HttpSession session = (HttpSession) externalContext.getSession(true);
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", usuario);
            FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("empleado", empleado);
//            System.out.println("cok " + getEmpleado());
        }

        if (cod_usuario.equals("") || cod_empleado.equals("") && isUsuarioLogueado() == false) {
//            System.out.println("Usuario no logueado===================>");
            context.redirect(bundle.getString("config.path.login"));
        }

    }

    public void cerrarSesion() throws IOException {
        // get cookies
        HttpServletRequest httpServletRequest = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        Cookie[] cookies = httpServletRequest.getCookies();

        if (cookies != null) {
            for (int i = 0; i < cookies.length; i++) {
                if (cookies[i].getName().equals("mbnUmbn") || cookies[i].getName().equals("mbnEmbn")) {
                    //delete cookie
                    HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
                    Cookie cookie = new Cookie("mbnUmbn", null);
                    cookie.setPath("/");
                    cookie.setMaxAge(0);
                    httpServletResponse.addCookie(cookie);
                }
            }
        }

        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext externalContext = context.getExternalContext();
        externalContext.invalidateSession();

        //Redirect to login
        //ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
        externalContext.redirect(bundle.getString("config.path.login"));
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
     * @return the empleado
     */
    public Tsgrhempleados getEmpleado() {
        return empleado;
    }

    /**
     * @param empleado the empleado to set
     */
    public void setEmpleado(Tsgrhempleados empleado) {
        this.empleado = empleado;
    }

    /**
     * @return the usuarioLogueado
     */
    public boolean isUsuarioLogueado() {
        return usuarioLogueado;
    }

    /**
     * @param usuarioLogueado the usuarioLogueado to set
     */
    public void setUsuarioLogueado(boolean usuarioLogueado) {
        this.usuarioLogueado = usuarioLogueado;
    }
}
