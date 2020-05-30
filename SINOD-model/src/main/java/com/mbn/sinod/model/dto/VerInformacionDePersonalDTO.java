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
public class VerInformacionDePersonalDTO {
    
    private Integer cod_empleado;
    private String fec_ingreso;
    private String fec_modificacion;
    private String des_nombre;
    private String des_apepaterno;
    private String des_apematerno;
    private String des_nbarea;
    private String des_puesto;
    private String des_rol;
    private String cod_rfc;
    private String cod_curp;
    private String cod_nss;
    private String fec_nacimiento;
    private String des_direccion;
    private String des_correo;
    private String correo_personal;
    private Character cod_tipoaguinaldo;
    private BigDecimal imp_aguinaldo;
    private Integer quincena;
    

    public String getDes_apepaterno() {
        return des_apepaterno;
    }

    public void setDes_apepaterno(String des_apepaterno) {
        this.des_apepaterno = des_apepaterno;
    }

    public String getDes_apematerno() {
        return des_apematerno;
    }

    public void setDes_apematerno(String des_apematerno) {
        this.des_apematerno = des_apematerno;
    }
    
    

    public String getDes_puesto() {
        return des_puesto;
    }

    public void setDes_puesto(String des_puesto) {
        this.des_puesto = des_puesto;
    }

    public Character getCod_tipoaguinaldo() {
        return cod_tipoaguinaldo;
    }

    public void setCod_tipoaguinaldo(Character cod_tipoaguinaldo) {
        this.cod_tipoaguinaldo = cod_tipoaguinaldo;
    }

    public BigDecimal getImp_aguinaldo() {
        return imp_aguinaldo;
    }

    public void setImp_aguinaldo(BigDecimal imp_aguinaldo) {
        this.imp_aguinaldo = imp_aguinaldo;
    }

    public Integer getQuincena() {
        return quincena;
    }

    public void setQuincena(Integer quincena) {
        this.quincena = quincena;
    }
    


    public String getDes_nombre() {
        return des_nombre;
    }

    public void setDes_nombre(String des_nombre) {
        this.des_nombre = des_nombre;
    }


    public String getDes_nbarea() {
        return des_nbarea;
    }

    public void setDes_nbarea(String des_nbarea) {
        this.des_nbarea = des_nbarea;
    }

    public String getCod_rfc() {
        return cod_rfc;
    }

    public void setCod_rfc(String cod_rfc) {
        this.cod_rfc = cod_rfc;
    }


    public String getCod_nss() {
        return cod_nss;
    }

    public void setCod_nss(String cod_nss) {
        this.cod_nss = cod_nss;
    }


    public String getDes_direccion() {
        return des_direccion;
    }

    public void setDes_direccion(String des_direccion) {
        this.des_direccion = des_direccion;
    }

    public String getDes_correo() {
        return des_correo;
    }

    public void setDes_correo(String des_correo) {
        this.des_correo = des_correo;
    }
    
     public Integer getCod_empleado() {
        return cod_empleado;
    }

    public void setCod_empleado(Integer cod_empleado) {
        this.cod_empleado = cod_empleado;
    }
    
    
    public String getCod_curp() {
        return cod_curp;
    }

    public void setCod_curp(String cod_curp) {
        this.cod_curp = cod_curp;
    }
    
     public String getCorreo_personal() {
        return correo_personal;
    }

    public void setCorreo_personal(String correo_personal) {
        this.correo_personal = correo_personal;
    }
    
    public String getDes_rol() {
        return des_rol;
    }

    public void setDes_rol(String des_rol) {
        this.des_rol = des_rol;
    }

    public String getFec_ingreso() {
        return fec_ingreso;
    }

    public void setFec_ingreso(String fec_ingreso) {
        this.fec_ingreso = fec_ingreso;
    }

    public String getFec_modificacion() {
        return fec_modificacion;
    }

    public void setFec_modificacion(String fec_modificacion) {
        this.fec_modificacion = fec_modificacion;
    }

    public String getFec_nacimiento() {
        return fec_nacimiento;
    }

    public void setFec_nacimiento(String fec_nacimiento) {
        this.fec_nacimiento = fec_nacimiento;
    }
    
}
