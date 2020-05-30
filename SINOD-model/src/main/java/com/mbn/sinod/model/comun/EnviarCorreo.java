/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.comun;

import com.mbn.sinod.model.dto.CorreoDTO;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author mariana
 */
public class EnviarCorreo {

    public void enviarCorreos(CorreoDTO correo) throws AddressException, MessagingException {
        System.out.println("Estoy en el enviar correo class");
        //propiedades de conexion
        Properties props = new Properties();
        props.setProperty("mail.smtp.host", "smtp.gmail.com");
        props.setProperty("mail.smtp.starttls.enable", "true");
        props.setProperty("mail.smtp.port", "587");
        props.setProperty("mail.smtp.user", "pruebaemail789@gmail.com");
        props.setProperty("mail.smtp.auth", "true");

        Session session = Session.getDefaultInstance(props);

        //contruir el mensaje
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress("pruebaemail789@gmail.com"));
        message.addRecipient(
                Message.RecipientType.TO,
                //new InternetAddress("marianahdzhdz97@gmail.com"));
                new InternetAddress(correo.getCorreo()));
        message.setSubject("Hola");
        //aqui va la ruta
        message.setText("Aviso de validaciones de incidencias");

        message.setContent(
                "<h1>la incidencia " + correo.getIncidencia() + " ha sido " + correo.getValidar() + "</h1>",
                "text/html");

        Transport t = session.getTransport("smtp");
        t.connect("pruebaemail789@gmail.com", "MBNpruebaemail123#@");
        t.sendMessage(message, message.getAllRecipients());

        t.close();

    }

}
