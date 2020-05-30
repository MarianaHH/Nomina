/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.dto;

/**
 *
 * @author Ambro
 */
public class DetalleDesgloseXMLDTO extends GenericDTO{
    private String clave;
    private String nombreConcepto;
    private String unidades;
    private String importe;
    private String descripcion;
    private String nombre;
    private String valorConcepto;
    private String valorMes;
    private String valorLab;

    public String getValorMes() {
        return valorMes;
    }

    public void setValorMes(String valorMes) {
        this.valorMes = valorMes;
    }

    public String getValorLab() {
        return valorLab;
    }

    public void setValorLab(String valorLab) {
        this.valorLab = valorLab;
    }
   

    

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getValorConcepto() {
        return valorConcepto;
    }

    public void setValorConcepto(String valorConcepto) {
        this.valorConcepto = valorConcepto;
    }

    
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    

    /**
     * @return the clave
     */
    public String getClave() {
        return clave;
    }

    /**
     * @param clave the clave to set
     */
    public void setClave(String clave) {
        this.clave = clave;
    }

    /**
     * @return the nombreConcepto
     */
    public String getNombreConcepto() {
        return nombreConcepto;
    }

    /**
     * @param nombreConcepto the nombreConcepto to set
     */
    public void setNombreConcepto(String nombreConcepto) {
        this.nombreConcepto = nombreConcepto;
    }

    /**
     * @return the unidades
     */
    public String getUnidades() {
        return unidades;
    }

    /**
     * @param unidades the unidades to set
     */
    public void setUnidades(String unidades) {
        this.unidades = unidades;
    }

    /**
     * @return the importe
     */
    public String getImporte() {
        return importe;
    }

    /**
     * @param importe the importe to set
     */
    public void setImporte(String importe) {
        this.importe = importe;
    }
    
    
}
