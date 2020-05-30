package com.mbn.sinod.web.mb;


import com.mbn.sinod.model.entidades.Tsgrhempleados;
import com.mbn.sinod.model.entidades.Usuario;
import java.io.IOException;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import org.apache.deltaspike.core.api.scope.ViewAccessScoped;

/**
 *
 * @author Cesar Jesús Gutiérrez Gutiérrez
 * 15/12/2017
 * Menú lateral y Bienvenida al sistema
 * Esta clase permite la navegación mediante el menú latera, y los mensajes de
 * bienvenida
 *
 */
@Named(value = "inicioMB")
@ViewAccessScoped
public class InicioMB implements Serializable {

    private Tsgrhempleados empleado;
    private Usuario usuario;

    @PostConstruct
    public void iniciarVariables() { 
        this.setEmpleado((Tsgrhempleados) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("empleado"));
        this.setUsuario((Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario"));
    }

    //Obtiene el nombre del empleado
    public String nombrarEmpleado() {
        if (this.empleado.getDesNombres() == null || "".equals(this.empleado.getDesNombres())) {
            return this.empleado.getDesNombre() + " " + this.empleado.getDesApepaterno() + " " + this.empleado.getDesApematerno();
        } else {
            return this.empleado.getDesNombre() + " " + this.empleado.getDesNombres() + " " + this.empleado.getDesApepaterno() + " " + this.empleado.getDesApematerno();
        }
    }
    
    //Redirecciona a la página de inicio
    public void irMenuSuite() throws IOException {
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext externalContext = context.getExternalContext();
        HttpServletRequest originRequest = (HttpServletRequest) externalContext.getRequest();
        String scheme = originRequest.getScheme();
        String server = originRequest.getServerName();
        int port = originRequest.getServerPort();
        String URL_Logout = scheme + "://" + server + ":" + port + "" + "/MBN-Suite/index.xhtml";
        context.getExternalContext().redirect(URL_Logout);
    }
    
    //Redirecciona a la página de inicio
    public void irInicio() throws IOException {
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext externalContext = context.getExternalContext();
        HttpServletRequest originRequest = (HttpServletRequest) externalContext.getRequest();
        String scheme = originRequest.getScheme();
        String server = originRequest.getServerName();
        int port = originRequest.getServerPort();
        String contextPath = originRequest.getContextPath();
        String URL_Logout = scheme + "://" + server + ":" + port + "" + contextPath + "/index.xhtml?faces-redirect=true";
        context.getExternalContext().redirect(URL_Logout);
    }
    
    public void irRuta(String ruta) throws IOException {
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext externalContext = context.getExternalContext();
        HttpServletRequest originRequest = (HttpServletRequest) externalContext.getRequest();
        String scheme = originRequest.getScheme();
        String server = originRequest.getServerName();
        int port = originRequest.getServerPort();
        String contextPath = originRequest.getContextPath();
        String URL_Logout = scheme + "://" + server + ":" + port + "" + contextPath + ruta;
        context.getExternalContext().redirect(URL_Logout);
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

}
