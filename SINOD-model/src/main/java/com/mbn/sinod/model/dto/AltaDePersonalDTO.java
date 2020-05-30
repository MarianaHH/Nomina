/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.dto;

import java.util.Date;

/**
 *
 * @author Ivette
 */
public class AltaDePersonalDTO {
    
    private Integer cod_empleado;
    private Date fec_ingreso;
    private String nombre;
    private String apepaterno;
    private String apematerno;
    private String area;
    private String puesto;
    private String rfc;
    private String curp;
    private String nss;
    private String rol;
    private Date fec_nacimiento;
    private String direccion;
    private String correo;

    public Integer getCod_empleado() {
        return cod_empleado;
    }

    public void setCod_empleado(Integer cod_empleado) {
        this.cod_empleado = cod_empleado;
    }

    public Date getFec_ingreso() {
        return fec_ingreso;
    }

    public void setFec_ingreso(Date fec_ingreso) {
        this.fec_ingreso = fec_ingreso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApepaterno() {
        return apepaterno;
    }

    public void setApepaterno(String apepaterno) {
        this.apepaterno = apepaterno;
    }

    public String getApematerno() {
        return apematerno;
    }

    public void setApematerno(String apematerno) {
        this.apematerno = apematerno;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getCurp() {
        return curp;
    }

    public void setCurp(String curp) {
        this.curp = curp;
    }

    public String getNss() {
        return nss;
    }

    public void setNss(String nss) {
        this.nss = nss;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public Date getFec_nacimiento() {
        return fec_nacimiento;
    }

    public void setFec_nacimiento(Date fec_nacimiento) {
        this.fec_nacimiento = fec_nacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
}
