/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.web.mb;

import com.mbn.sinod.model.dto.DetalleEmpleadosDTO;
import com.mbn.sinod.model.entidades.Tsgnomquincena;
import com.mbn.sinod.model.entidades.Tsgrhempleados;
import com.mbn.sinod.model.entidades.Usuario;
import com.mbn.sinod.web.client.DetalleEmpleadosWSClient;
import com.mbn.sinod.web.client.QuincenasWSClient;
import java.io.IOException;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.HttpServletRequest;
import org.apache.deltaspike.core.api.scope.ViewAccessScoped;

/**
 *
 * @author Karla
 */
@Named(value = "empleadosporareaMB")
@ViewAccessScoped
public class EmpleadosPorAreaMB implements Serializable {
    
    private static Integer codEmpleado;
    private List<DetalleEmpleadosDTO> listaEmpleadosPorArea;
    private Tsgnomquincena quincenaActual;
    private String desQuincenaActual;
    private SimpleDateFormat format;
    
    private Tsgrhempleados empleadoLogeado;
    private Usuario usuario;
    
    @PostConstruct
    public void iniciarVariables() {
        this.setEmpleadoLogeado((Tsgrhempleados) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("empleado"));
        this.usuario = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        listaEmpleadosPorArea = new ArrayList<>();
        setListaEmpleadosPorArea(DetalleEmpleadosWSClient.empleadosPorArea(getEmpleadoLogeado().getCodPuesto().getCodArea().getCodArea()));
        setQuincenaActual(QuincenasWSClient.quincenaActual().getQuincena());
        this.format  = new SimpleDateFormat("dd/MM/yyyy");
        setDesQuincenaActual("Del " +format.format(getQuincenaActual().getFecInicio())+ " al " +format.format(getQuincenaActual().getFecFin()));
    }
    
    public void registrarIncidencias(Integer empleadoid) throws IOException{
        setCodEmpleado(empleadoid);
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext externalContext = context.getExternalContext();
        HttpServletRequest originRequest = (HttpServletRequest) externalContext.getRequest();
        String scheme = originRequest.getScheme();
        String server = originRequest.getServerName();
        int port = originRequest.getServerPort();
        String contextPath = originRequest.getContextPath();
        String URL_Informacion = scheme + "://" + server + ":" + port + "" + contextPath + "/incidencias/incidenciasrh.xhtml?faces-redirect=true";
        context.getExternalContext().redirect(URL_Informacion);
        System.out.println("ABRIR VISTA DE REGISTRO DE INCIDENCIAS DE LC " +empleadoid);
    }

    public static Integer getCodEmpleado() {
        return codEmpleado;
    }

    public static void setCodEmpleado(Integer codEmpleado) {
        EmpleadosPorAreaMB.codEmpleado = codEmpleado;
    }

    public List<DetalleEmpleadosDTO> getListaEmpleadosPorArea() {
        return listaEmpleadosPorArea;
    }

    public void setListaEmpleadosPorArea(List<DetalleEmpleadosDTO> listaEmpleadosPorArea) {
        this.listaEmpleadosPorArea = listaEmpleadosPorArea;
    }

    public Tsgrhempleados getEmpleadoLogeado() {
        return empleadoLogeado;
    }

    public void setEmpleadoLogeado(Tsgrhempleados empleadoLogeado) {
        this.empleadoLogeado = empleadoLogeado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Tsgnomquincena getQuincenaActual() {
        return quincenaActual;
    }

    public void setQuincenaActual(Tsgnomquincena quincenaActual) {
        this.quincenaActual = quincenaActual;
    }

    public String getDesQuincenaActual() {
        return desQuincenaActual;
    }

    public void setDesQuincenaActual(String desQuincenaActual) {
        this.desQuincenaActual = desQuincenaActual;
    }

}
