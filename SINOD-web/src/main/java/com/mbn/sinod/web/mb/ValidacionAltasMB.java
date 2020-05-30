/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.web.mb;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mbn.sinod.model.dto.ValidacionAltasDTO;
import com.mbn.sinod.model.entidades.Tsgnomempleados;
import com.mbn.sinod.web.client.EnviarCorreoWSClient;
import com.mbn.sinod.web.client.ValidarAltasWSClient;
import com.mbn.sinod.web.util.ResourceBundles;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
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
@Named(value = "validacionAltasMB")
@ViewAccessScoped
public class ValidacionAltasMB implements Serializable {

    private static final ResourceBundle BUNDLE = ResourceBundle.getBundle(ResourceBundles.MESSAGES.getBundleName());
    private Boolean validar;
    private List<ValidacionAltasDTO> listaAltasValidadas;
    private List<ValidacionAltasDTO> Validadas;
    private Boolean disable;
    private Boolean active;
    private Tsgnomempleados validacionselec;

    @PostConstruct
    public void iniciarVariables() {
        listaAltasValidadas = new ArrayList<>();
        setValidadas(new ArrayList<>());
        setListaAltasValidadas(ValidarAltasWSClient.listarValidarAltas());
    }

    public void dialogoValidarAltasAceptadas() {
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('dialogValidarAltasAceptadas').show();");
    }

    public void dialogoValidarAltasRechazadas() {
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('dialogValidarAltasRechazadas').show();");

    }

    public void dialogoGuardarValidaciones() {
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('dialogGuardarAltas').show();");

    }

    public void validarCadaAlta(int bandera, ValidacionAltasDTO vali) {

        if (bandera == 0) {
            vali.setValidar(true);
            vali.setValidacion('a');
        } else {
            vali.setValidar(false);
            vali.setValidacion('b');
        }
        getValidadas().add(vali);
    }

    public void enviarCorreos() {

        try {
            ValidacionAltasDTO dtoRespuesta = new ValidacionAltasDTO();
            dtoRespuesta.setListaInformacionValidar(getValidadas());
            EnviarCorreoWSClient.enviarCorreosValidarAltas(dtoRespuesta);
            
        } catch (JsonProcessingException ex) {
            Logger.getLogger(ValidacionAltasMB.class.getName()).log(Level.SEVERE, null, ex);
        }
        generarMensaje("Los correos han sido enviados", FacesMessage.SEVERITY_INFO);

    }

    public void validarAltasAceptadas() throws JsonProcessingException {

        ValidacionAltasDTO dtoRespuesta = new ValidacionAltasDTO();
        
        dtoRespuesta.setListaInformacionValidar(getListaAltasValidadas());

        try {
            ValidarAltasWSClient.validarAltasAceptadas(dtoRespuesta);
            generarMensaje("Altas validadas", FacesMessage.SEVERITY_INFO);            
            getListaAltasValidadas().clear();
            setListaAltasValidadas(ValidarAltasWSClient.listarValidarAltas());
            setValidadas(getListaAltasValidadas());
            enviarCorreos();
        } catch (JsonProcessingException ex) {
            Logger.getLogger(ConfConceptoMB.class.getName()).log(Level.SEVERE, null, ex);
            generarMensaje("P Error", FacesMessage.SEVERITY_ERROR);
        }

    }

    public void validarAltasRechazadas() throws JsonProcessingException {

        ValidacionAltasDTO dtoRespuesta = new ValidacionAltasDTO();
        dtoRespuesta.setListaInformacionValidar(getListaAltasValidadas());

        try {
           
            ValidarAltasWSClient.validarAltasRechazadas(dtoRespuesta);
            generarMensaje("Altas rechazadas", FacesMessage.SEVERITY_INFO);
            getListaAltasValidadas().clear();

            setListaAltasValidadas(ValidarAltasWSClient.listarValidarAltas());
             setValidadas(getListaAltasValidadas());
            enviarCorreos();
        } catch (JsonProcessingException ex) {
            Logger.getLogger(ConfConceptoMB.class.getName()).log(Level.SEVERE, null, ex);
            generarMensaje("P Error", FacesMessage.SEVERITY_ERROR);
        }

    }

    public void generarMensaje(String mensaje, FacesMessage.Severity sever) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(sever, "Mensaje: ", mensaje));
    }

    public void guardarAltas() {
        ValidacionAltasDTO dtoRespuesta = new ValidacionAltasDTO();
        Boolean validarGuardar = true;
        for(int i=0; i<getListaAltasValidadas().size();i++){
          if(getListaAltasValidadas().get(i).getValidacion()!=null){
              validarGuardar = true;
          }else{
              validarGuardar = false;
              break;
          }
        
        }
      if(validarGuardar){
         dtoRespuesta.setListaInformacionValidar(getValidadas());
        try {
            ValidarAltasWSClient.validarCadaAlta(dtoRespuesta);
            generarMensaje("Se han guardado los datos", FacesMessage.SEVERITY_INFO);
            getListaAltasValidadas().clear();
            setListaAltasValidadas(ValidarAltasWSClient.listarValidarAltas());
            setValidadas(getListaAltasValidadas());
            enviarCorreos();
        }catch (JsonProcessingException ex){
            Logger.getLogger(ValidacionAltasMB.class.getName()).log(Level.SEVERE, null, ex);
            generarMensaje("Error al guardar altas.", FacesMessage.SEVERITY_ERROR);
        }
        }else{
      
         generarMensaje("Por favor actualice el estatus de todas las altas antes de guardar.", FacesMessage.SEVERITY_INFO);
        }
        
    }

    public Boolean getValidar() {
        return validar;
    }

    public void setValidar(Boolean validar) {
        this.validar = validar;
    }

    public List<ValidacionAltasDTO> getListaAltasValidadas() {
        return listaAltasValidadas;
    }

    public void setListaAltasValidadas(List<ValidacionAltasDTO> listaAltasValidadas) {
        this.listaAltasValidadas = listaAltasValidadas;
    }

    public Boolean getDisable() {
        return disable;
    }

    public void setDisable(Boolean disable) {
        this.disable = disable;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Tsgnomempleados getValidacionselec() {
        return validacionselec;
    }

    public void setValidacionselec(Tsgnomempleados validacionselec) {
        this.validacionselec = validacionselec;
    }

    /**
     * @return the Validadas
     */
    public List<ValidacionAltasDTO> getValidadas() {
        return Validadas;
    }

    /**
     * @param Validadas the Validadas to set
     */
    public void setValidadas(List<ValidacionAltasDTO> Validadas) {
        this.Validadas = Validadas;
    }

}
