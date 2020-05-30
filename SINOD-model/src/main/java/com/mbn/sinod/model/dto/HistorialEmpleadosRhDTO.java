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
 * @author Ivette
 */
public class HistorialEmpleadosRhDTO {
    
    private Integer cod_empleado;
    private String fecha_ingreso;
    private String nom_empleado;
    private String des_nbarea;
    private String des_puesto;
    private String des_quincena;
    private Date fec_inicio;
    private Date fec_fin;
    private Date fec_pago;
    private BigDecimal imp_concepto;
    private Integer quincena;

    public Integer getQuincena() {
        return quincena;
    }

    public void setQuincena(Integer quincena) {
        this.quincena = quincena;
    }


    public BigDecimal getImp_concepto() {
        return imp_concepto;
    }

    public void setImp_concepto(BigDecimal imp_concepto) {
        this.imp_concepto = imp_concepto;
    }

    public Integer getCod_empleado() {
        return cod_empleado;
    }

    public void setCod_empleado(Integer cod_empleado) {
        this.cod_empleado = cod_empleado;
    }

    public String getFecha_ingreso() {
        return fecha_ingreso;
    }

    public void setFecha_ingreso(String fecha_ingreso) {
        this.fecha_ingreso = fecha_ingreso;
    }

    public String getNom_empleado() {
        return nom_empleado;
    }

    public void setNom_empleado(String nom_empleado) {
        this.nom_empleado = nom_empleado;
    }

    public String getDes_nbarea() {
        return des_nbarea;
    }

    public void setDes_nbarea(String des_nbarea) {
        this.des_nbarea = des_nbarea;
    }

    public String getDes_puesto() {
        return des_puesto;
    }

    public void setDes_puesto(String des_puesto) {
        this.des_puesto = des_puesto;
    }

    public String getDes_quincena() {
        return des_quincena;
    }

    public void setDes_quincena(String des_quincena) {
        this.des_quincena = des_quincena;
    }

    public Date getFec_inicio() {
        return fec_inicio;
    }

    public void setFec_inicio(Date fec_inicio) {
        this.fec_inicio = fec_inicio;
    }

    public Date getFec_fin() {
        return fec_fin;
    }

    public void setFec_fin(Date fec_fin) {
        this.fec_fin = fec_fin;
    }

    public Date getFec_pago() {
        return fec_pago;
    }

    public void setFec_pago(Date fec_pago) {
        this.fec_pago = fec_pago;
    }

}
