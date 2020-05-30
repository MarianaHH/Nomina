/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.web.mb;

import com.mbn.sinod.model.entidades.Tsgrhempleados;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Clase que permite visualizar la imagen de perfil del usuario logueado
 *
 * @author Javier Sánchez Trejo, MBN
 * @since 18/12/2017
 */
@ManagedBean(name = "perfilMB")
@RequestScoped
public class PerfilMB {

    private StreamedContent fotoUsuario;
    private Tsgrhempleados empleado;
    private static final Logger LOGGER = LoggerFactory.getLogger(PerfilMB.class);

    @PostConstruct
    public void iniciarVariables() {
        setEmpleado((Tsgrhempleados) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("empleado"));
    }

    public StreamedContent obtenerImagenPerfil() {
        if (empleado.getBinFoto() != null) {
            return new DefaultStreamedContent(new ByteArrayInputStream(empleado.getBinFoto()), "image/png", empleado.getCodEmpleado() + ".png");
        } else {
            String urlImageDefault = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/resources/") + File.separator + "imagenes" + File.separator + "apidy.png";
            File chartFile = new File(urlImageDefault);
            try {
                return new DefaultStreamedContent(new FileInputStream(chartFile), "image/png", empleado.getCodEmpleado() + ".png");
            } catch (Exception e) {
                LOGGER.error("Ocurrió un error obteniendo la imagen de perfil: " + e.getMessage());
            } finally {
                return null;
            }

        }
    }

    /**
     * @return the fotoUsuario
     */
    public StreamedContent getFotoUsuario() {
        return fotoUsuario;
    }

    /**
     * @param fotoUsuario the fotoUsuario to set
     */
    public void setFotoUsuario(StreamedContent fotoUsuario) {
        this.fotoUsuario = fotoUsuario;
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
}
