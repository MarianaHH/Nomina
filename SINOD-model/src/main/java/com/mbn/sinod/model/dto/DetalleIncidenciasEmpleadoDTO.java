/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 *
 * @author Karla
 */
public class DetalleIncidenciasEmpleadoDTO {
    
    private Integer idincidencia;
    private Date fechaalta;
    private String clave;
    private String incidencia;
    private Character idtipo;
    private String desctipo;
    private Short cantidad;
    private String actividad;
    private String comentarios;
    private Integer reportaid;
    private String reportanb;
    private Integer autorizaid;
    private String autorizanb;
    private String perfil;
    private String detallefechas;
    private BigDecimal montoincidencia;
    private BigDecimal montopagado;
    private Boolean aceptacion; //validacion por parte del lider de celula
    private Boolean validacion; //de validacion por parte de RH
    private Boolean autorizacion; //de validacion de pago Finanzas
    private Integer quincenaid;
    private String desquincena;
    private Integer creaid;
    private String creanb;

    public Integer getIdincidencia() {
        return idincidencia;
    }

    public void setIdincidencia(Integer idincidencia) {
        this.idincidencia = idincidencia;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getIncidencia() {
        return incidencia;
    }

    public void setIncidencia(String incidencia) {
        this.incidencia = incidencia;
    }

    public Character getIdtipo() {
        return idtipo;
    }

    public void setIdtipo(Character idtipo) {
        this.idtipo = idtipo;
    }

    public String getDesctipo() {
        return desctipo;
    }

    public void setDesctipo(String desctipo) {
        this.desctipo = desctipo;
    }

    public Short getCantidad() {
        return cantidad;
    }

    public void setCantidad(Short cantidad) {
        this.cantidad = cantidad;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public Integer getReportaid() {
        return reportaid;
    }

    public void setReportaid(Integer reportaid) {
        this.reportaid = reportaid;
    }

    public String getReportanb() {
        return reportanb;
    }

    public void setReportanb(String reportanb) {
        this.reportanb = reportanb;
    }

    public Date getFechaalta() {
        return fechaalta;
    }

    public void setFechaalta(Date fechaalta) {
        this.fechaalta = fechaalta;
    }

    public Integer getAutorizaid() {
        return autorizaid;
    }

    public void setAutorizaid(Integer autorizaid) {
        this.autorizaid = autorizaid;
    }

    public String getAutorizanb() {
        return autorizanb;
    }

    public void setAutorizanb(String autorizanb) {
        this.autorizanb = autorizanb;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getDetallefechas() {
        return detallefechas;
    }

    public void setDetallefechas(String detallefechas) {
        this.detallefechas = detallefechas;
    }

    public BigDecimal getMontoincidencia() {
        return montoincidencia;
    }

    public void setMontoincidencia(BigDecimal montoincidencia) {
        this.montoincidencia = montoincidencia;
    }

    public BigDecimal getMontopagado() {
        return montopagado;
    }

    public void setMontopagado(BigDecimal montopagado) {
        this.montopagado = montopagado;
    }

    public Boolean getValidacion() {
        return validacion;
    }

    public void setValidacion(Boolean validacion) {
        this.validacion = validacion;
    }

    public Boolean getAceptacion() {
        return aceptacion;
    }

    public void setAceptacion(Boolean aceptacion) {
        this.aceptacion = aceptacion;
    }

    public Integer getQuincenaid() {
        return quincenaid;
    }

    public void setQuincenaid(Integer quincenaid) {
        this.quincenaid = quincenaid;
    }

    public String getDesquincena() {
        return desquincena;
    }

    public void setDesquincena(String desquincena) {
        this.desquincena = desquincena;
    }

    public Integer getCreaid() {
        return creaid;
    }

    public void setCreaid(Integer creaid) {
        this.creaid = creaid;
    }

    public String getCreanb() {
        return creanb;
    }

    public void setCreanb(String creanb) {
        this.creanb = creanb;
    }

    public Boolean getAutorizacion() {
        return autorizacion;
    }

    public void setAutorizacion(Boolean autorizacion) {
        this.autorizacion = autorizacion;
    }
    
}
