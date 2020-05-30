/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.dao;

import com.googlecode.genericdao.dao.hibernate.GenericDAOImpl;
import com.mbn.sinod.model.dto.CorreoDTO;
import com.mbn.sinod.model.dto.IncidenciasQuincenaDTO;
import com.mbn.sinod.model.dto.ValidacionAltasDTO;
import com.mbn.sinod.model.dto.ValidacionBajasDTO;
import com.mbn.sinod.model.entidades.Tsgnomincidencia;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import org.hibernate.transform.Transformers;

/**
 *
 * @author mariana
 */
public class EnviarCorreoDAOImpl extends GenericDAOImpl<Tsgnomincidencia, Integer>
        implements EnviarCorreoDAO {
    
    List<IncidenciasQuincenaDTO> lista;
    List<CorreoDTO> correo;
    
    @Override
    public boolean enviarCorreos(List<IncidenciasQuincenaDTO> incidencias) {

        //CorreoDTO correo;
       // EnviarCorreo enviar = new EnviarCorreo();
        	

        Properties props = new Properties();
        props.setProperty("mail.smtp.host", "smtp.gmail.com");
        props.setProperty("mail.smtp.starttls.enable", "true");
        props.setProperty("mail.smtp.port", "587");
        props.setProperty("mail.smtp.user", "pruebaemail789@gmail.com");
        props.setProperty("mail.smtp.auth", "true");
        
        Session session = Session.getDefaultInstance(props);
        
        try {
            
            for (int i = 0; i < incidencias.size(); i++) {
                
                correo = (List<CorreoDTO>) getSession().
                        createSQLQuery("select * from sgnom.obtener_correos() where nomempleado = " + incidencias.get(i).getReporta())
                        .addScalar("nomempleado")
                        .addScalar("correo")
                        .setResultTransformer(Transformers.aliasToBean(CorreoDTO.class)) //especificamos que los parametros se van a transformar en un DTO que especifiquemos
                        .list();
                correo.get(0).setIncidencia(incidencias.get(i).getIncidencia());
                if (incidencias.get(i).getValidacion()) {
                    correo.get(0).setValidar("VALIDADA");
                } else {
                    correo.get(0).setValidar("RECHAZADA");
                }
                //enviar.enviarCorreos(correo.get(0));

                MimeMessage message = new MimeMessage(session);
                message.setFrom(new InternetAddress("pruebaemail789@gmail.com"));
                message.addRecipient(
                        Message.RecipientType.TO,
                        //new InternetAddress("marianahdzhdz97@gmail.com"));
                        new InternetAddress(correo.get(0).getCorreo()));
                message.setSubject("Hola");
                
                message.setText("Aviso de validaciones de incidencias");
                
                message.setContent(
                        "<h1>la incidencia " + correo.get(0).getIncidencia() + " ha sido " + correo.get(0).getValidar() + "</h1>",
                        "text/html");
                
                Transport t = session.getTransport("smtp");
                t.connect("pruebaemail789@gmail.com", "MBNpruebaemail123#@");
                t.sendMessage(message, message.getAllRecipients());
                
                t.close();
                
            }
            
        } catch (MessagingException ex) {
            Logger.getLogger(EnviarCorreoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
        return true;
    }

        
    @Override
    public boolean enviarCorreosValidacionAltas(List<ValidacionAltasDTO> altas) {       
        Properties props = new Properties();
        props.setProperty("mail.smtp.host", "smtp.gmail.com");
        props.setProperty("mail.smtp.starttls.enable", "true");
        props.setProperty("mail.smtp.port", "587");
        props.setProperty("mail.smtp.user", "pruebaemail789@gmail.com");
        props.setProperty("mail.smtp.auth", "true");
        
        Session session = Session.getDefaultInstance(props);
        
        try {
            
            for (int i = 0; i < altas.size(); i++) {
                
                correo = (List<CorreoDTO>) getSession().
                        createSQLQuery("select * from sgnom.obtener_correos() where nomempleado = " + altas.get(i).getCod_empleadoid())
                        .addScalar("nomempleado")
                        .addScalar("correo")
                        .setResultTransformer(Transformers.aliasToBean(CorreoDTO.class)) //especificamos que los parametros se van a transformar en un DTO que especifiquemos
                        .list();
               
                //enviar.enviarCorreos(correo.get(0));

                MimeMessage message = new MimeMessage(session);
                message.setFrom(new InternetAddress("pruebaemail789@gmail.com"));
                message.addRecipient(
                        Message.RecipientType.TO,
                        //new InternetAddress("marianahdzhdz97@gmail.com"));
                        new InternetAddress(correo.get(0).getCorreo()));
                message.setSubject("Hola");
                
                message.setText("Helou");
                
                if(altas.get(i).getValidar())
                {
                     message.setContent(
                        "<h1> Su alta ha sido validada </h1>",
                        "text/html");
                }else
                {
                    message.setContent(
                        "<h1> Su alta ha sido rechazada </h1>",
                        "text/html");
                    
                }
            
                Transport t = session.getTransport("smtp");
                t.connect("pruebaemail789@gmail.com", "MBNpruebaemail123#@");
                t.sendMessage(message, message.getAllRecipients());
                
                t.close();
                
            }
            
        } catch (MessagingException ex) {
            Logger.getLogger(EnviarCorreoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
        return true; 
    }
    
    
    @Override
    public boolean enviarCorreosValidacionBajas(List<ValidacionBajasDTO> bajas) {
       
        Properties props = new Properties();
        props.setProperty("mail.smtp.host", "smtp.gmail.com");
        props.setProperty("mail.smtp.starttls.enable", "true");
        props.setProperty("mail.smtp.port", "587");
        props.setProperty("mail.smtp.user", "pruebaemail789@gmail.com");
        props.setProperty("mail.smtp.auth", "true");
        
        Session session = Session.getDefaultInstance(props);
        
        try {
            
            for (int i = 0; i < bajas.size(); i++) {
                
                correo = (List<CorreoDTO>) getSession().
                        createSQLQuery("select * from sgnom.obtener_correos() where nomempleado = " + bajas.get(i).getCod_empleadoid())
                        .addScalar("nomempleado")
                        .addScalar("correo")
                        .setResultTransformer(Transformers.aliasToBean(CorreoDTO.class)) //especificamos que los parametros se van a transformar en un DTO que especifiquemos
                        .list();
               
                //enviar.enviarCorreos(correo.get(0));

                MimeMessage message = new MimeMessage(session);
                message.setFrom(new InternetAddress("pruebaemail789@gmail.com"));
                message.addRecipient(
                        Message.RecipientType.TO,
                        //new InternetAddress("marianahdzhdz97@gmail.com"));
                        new InternetAddress(correo.get(0).getCorreo()));
                message.setSubject("Hola");
                
                message.setText("Helou");
                
                if(bajas.get(i).getValidar())
                {
                     message.setContent(
                        "<h1> Su baja ha sido validada </h1>",
                        "text/html");
                }else
                {
                    message.setContent(
                        "<h1> Su baja ha sido rechazada </h1>",
                        "text/html");
                    
                }
            
                Transport t = session.getTransport("smtp");
                t.connect("pruebaemail789@gmail.com", "MBNpruebaemail123#@");
                t.sendMessage(message, message.getAllRecipients());
                
                t.close();
                
            }
            
        } catch (MessagingException ex) {
            Logger.getLogger(EnviarCorreoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
        return true;
        
        
    }
    
    public List<IncidenciasQuincenaDTO> getLista() {
        return lista;
    }
    
    public void setLista(List<IncidenciasQuincenaDTO> lista) {
        this.lista = lista;
    }
    
    public List<CorreoDTO> getCorreo() {
        return correo;
    }
    
    public void setCorreo(List<CorreoDTO> correo) {
        this.correo = correo;
    }


    
    
}
