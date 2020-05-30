/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.web.util;

/**
 *
 * @author Administrator
 */
 
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import org.primefaces.context.RequestContext;
 
@ManagedBean(name = "dfView")
public class DFView {
         
    public void showMessage() {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "¡Aviso!", "La aplicación PCCFDI requiere los siguientes navegadores para su correcto funcionamiento <br> -Mozilla Firefox <br> -Google Chrome <br> Si utiliza Internet Explorer es necesario descargar el siguiente complemento: <br> <a target='_blank' href='https://get.adobe.com/es/reader'>Adobe Reader</a> <br> para visualizar el archivo pdf.");
         
        RequestContext.getCurrentInstance().showMessageInDialog(message);
    }
}
