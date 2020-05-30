/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.mbn.sinod.web.util;

import javax.faces.application.FacesMessage;

/**
 * @author Annel
 * Clase para retornar mensajes en pantalla dependiendo del tipo de mensaje
 */
public class MensajeEnum {
    
    public static FacesMessage.Severity mensaje(int numero){
        switch (numero){
            case 1: return FacesMessage.SEVERITY_ERROR;
            case 2: return FacesMessage.SEVERITY_WARN;
            case 3: return FacesMessage.SEVERITY_INFO;
            default: return FacesMessage.SEVERITY_FATAL;
        }
    }
}
