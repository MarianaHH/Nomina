/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.dto;
import java.math.BigDecimal;
import java.util.List;
/**
 *
 * @author mariana
 */
public class IncidenciasQuincenaDTO extends GenericDTO {
    
    private Integer idincidencia;
    private String clave;
    private String incidencia;
    private Character idtipo;
    private String desctipo;
    private Short cantidad;
    private String actividad;
    private String detallefechas;
    private String comentarios;
    private BigDecimal importe;
    private Integer reporta;
    private Integer autoriza;
    private String nombre;
    private String perfil;
    private Boolean validacion;
    private Boolean aceptacion;
    private Boolean Correo;
    private Integer modifica;
    private Boolean autpago;
    private Integer quincenaid;
    private String desquincena;
    
    private List<IncidenciasQuincenaDTO> listaIncidencias;

    public List<IncidenciasQuincenaDTO> getListaIncidencias() {
        return listaIncidencias;
    }

    public void setListaIncidencias(List<IncidenciasQuincenaDTO> listaIncidencias) {
        this.listaIncidencias = listaIncidencias;
    }

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

    public BigDecimal getImporte() {
        return importe;
    }

    public void setImporte(BigDecimal importe) {
        this.importe = importe;
    }

    public Integer getReporta() {
        return reporta;
    }

    public void setReporta(Integer reporta) {
        this.reporta = reporta;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public Boolean getCorreo() {
        return Correo;
    }

    public void setCorreo(Boolean Correo) {
        this.Correo = Correo;
    }

    public String getDesctipo() {
        return desctipo;
    }

    public void setDesctipo(String desctipo) {
        this.desctipo = desctipo;
    }

    public String getDetallefechas() {
        return detallefechas;
    }

    public void setDetallefechas(String detallefechas) {
        this.detallefechas = detallefechas;
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

    public Integer getAutoriza() {
        return autoriza;
    }

    public void setAutoriza(Integer autoriza) {
        this.autoriza = autoriza;
    }

    public Integer getModifica() {
        return modifica;
    }

    public void setModifica(Integer modifica) {
        this.modifica = modifica;
    }

    public Boolean getAutpago() {
        return autpago;
    }

    public void setAutpago(Boolean autpago) {
        this.autpago = autpago;
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
    
}
