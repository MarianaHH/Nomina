/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.web.mb;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mbn.sinod.model.dto.ValidacionAltasDTO;
import com.mbn.sinod.model.dto.ValidacionBajasDTO;
import com.mbn.sinod.web.client.EnviarCorreoWSClient;
import com.mbn.sinod.web.client.ValidarBajasWSClient;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.apache.deltaspike.core.api.scope.ViewAccessScoped;
import org.primefaces.context.RequestContext;

/**
 *
 * @author Ivette
 */
@Named(value = "validacionBajasMB")
@ViewAccessScoped
public class ValidacionBajasMB implements Serializable {

    private Boolean validar;
    private List<ValidacionBajasDTO> listaBajasValidadas;
    private List<ValidacionBajasDTO> Validadas;

    @PostConstruct
    public void iniciarVariables() {
        listaBajasValidadas = new ArrayList<>();
        setValidadas(new ArrayList<>());
        setListaBajasValidadas(ValidarBajasWSClient.listarValidarBajas());
    }

    public void dialogoValidarBajasAceptadas() {
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('dialogValidarBajasAceptadas').show();");
    }

    public void dialogoValidarBajasRechazadas() {
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('dialogValidarBajasRechazadas').show();");

    }

    public void dialogoGuardarValidaciones() {
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('dialogGuardarBajas').show();");

    }

    public void validarCadaBaja(int bandera, ValidacionBajasDTO vali) {

        if (bandera == 0) {
            vali.setValidar(false);
            vali.setValidacion('c');
        } else {
            vali.setValidar(true);
            vali.setValidacion('d');
        }
        getValidadas().add(vali);

    }

    public void validarBajasAceptadas() throws JsonProcessingException {

        ValidacionBajasDTO dtoRespuesta = new ValidacionBajasDTO();
        dtoRespuesta.setListaInformacionValidar(getListaBajasValidadas());

        try {
            ValidarBajasWSClient.validarBajasAceptadas(dtoRespuesta);
            generarMensaje("Bajas validadas", FacesMessage.SEVERITY_INFO);
            getListaBajasValidadas().clear();
            setListaBajasValidadas(ValidarBajasWSClient.listarValidarBajas());
            setValidadas(getListaBajasValidadas());
            enviarCorreos();
        } catch (JsonProcessingException ex) {
            Logger.getLogger(ConfConceptoMB.class.getName()).log(Level.SEVERE, null, ex);
            generarMensaje("P Error", FacesMessage.SEVERITY_ERROR);
        }

    }

    public void validarBajasRechazadas() throws JsonProcessingException {

        ValidacionBajasDTO dtoRespuesta = new ValidacionBajasDTO();
        dtoRespuesta.setListaInformacionValidar(getListaBajasValidadas());

        try {
            ValidarBajasWSClient.validarBajasRechazadas(dtoRespuesta);
            generarMensaje("Bajas rechazadas", FacesMessage.SEVERITY_INFO);
            getListaBajasValidadas().clear();

            setListaBajasValidadas(ValidarBajasWSClient.listarValidarBajas());
            setValidadas(getListaBajasValidadas());
            enviarCorreos();

        } catch (JsonProcessingException ex) {
            Logger.getLogger(ConfConceptoMB.class.getName()).log(Level.SEVERE, null, ex);
            generarMensaje("P Error", FacesMessage.SEVERITY_ERROR);
        }

    }

    public void enviarCorreos() {

        try {
            ValidacionBajasDTO dtoRespuesta = new ValidacionBajasDTO();
            dtoRespuesta.setListaInformacionValidar(getValidadas());
            EnviarCorreoWSClient.enviarCorreosValidarBajas(dtoRespuesta);
            generarMensaje("Los correos han sido enviados", FacesMessage.SEVERITY_INFO);

        } catch (JsonProcessingException ex) {
            Logger.getLogger(ValidacionBajasMB.class.getName()).log(Level.SEVERE, null, ex);
            generarMensaje("Error al enviar los correos", FacesMessage.SEVERITY_INFO);
        }

    }

    public void generarMensaje(String mensaje, FacesMessage.Severity sever) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(sever, "Mensaje: ", mensaje));
    }

    public void guardarBajas() {
        ValidacionBajasDTO dtoRespuesta = new ValidacionBajasDTO();
        Boolean validarGuardar = true;
        for(int i=0; i<getListaBajasValidadas().size();i++){
          if(getListaBajasValidadas().get(i).getValidacion()!=null){
              validarGuardar = true;
          }else{
              validarGuardar = false;
              break;
          }
        }
        if(validarGuardar){
        dtoRespuesta.setListaInformacionValidar(getListaBajasValidadas());
        try {
            ValidarBajasWSClient.validarCadaBaja(dtoRespuesta);
            generarMensaje("Se han guardado los datos", FacesMessage.SEVERITY_INFO);
            getListaBajasValidadas().clear();
            setListaBajasValidadas(ValidarBajasWSClient.listarValidarBajas());
            setValidadas(getListaBajasValidadas());
            enviarCorreos();
        }catch(JsonProcessingException ex){
            Logger.getLogger(ValidacionBajasMB.class.getName()).log(Level.SEVERE, null, ex);
            generarMensaje("Error al guardar bajas.", FacesMessage.SEVERITY_ERROR);
        }
        } else {
            generarMensaje("Por favor actualice el estatus de todas las bajas antes de guardar.", FacesMessage.SEVERITY_INFO);
        }

    }

    public Boolean getValidar() {
        return validar;
    }

    public void setValidar(Boolean validar) {
        this.validar = validar;
    }

    public List<ValidacionBajasDTO> getListaBajasValidadas() {
        return listaBajasValidadas;
    }

    public void setListaBajasValidadas(List<ValidacionBajasDTO> listaBajasValidadas) {
        this.listaBajasValidadas = listaBajasValidadas;
    }

    public List<ValidacionBajasDTO> getValidadas() {
        return Validadas;
    }

    public void setValidadas(List<ValidacionBajasDTO> Validadas) {
        this.Validadas = Validadas;
    }

}
