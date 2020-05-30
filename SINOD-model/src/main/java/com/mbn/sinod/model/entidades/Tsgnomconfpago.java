/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
	import javax.persistence.GeneratedValue;
	import org.hibernate.annotations.GenericGenerator;
	import org.hibernate.annotations.Parameter;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ambrosio
 */
@Entity
@Table(name = "tsgnomconfpago", catalog = "suite", schema = "sgnom")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tsgnomconfpago.findAll", query = "SELECT t FROM Tsgnomconfpago t")})
public class Tsgnomconfpago implements Serializable {

    private static final long serialVersionUID = 1L; //NUMERO DE REGISTRO UNICO PARA LA MAQUINA VIRTUAL 
    	@Id //  ID DE LA TABLA 
	@GenericGenerator(name="argId", strategy="increment",parameters = { @Parameter(name = "schema", value = "sgnom") })
    @GeneratedValue(generator = "argId")
    @Basic(optional = false) //DECIR QE EL CAMPO ES NO NULO 
    @Column(name = "cod_confpagoid")
    private Integer codConfpagoid;
    @Column(name = "bol_pagoempleado")
    private Boolean bolPagoempleado;
    @Column(name = "bol_pagorh")
    private Boolean bolPagorh;
    @Column(name = "bol_pagofinanzas")
    private Boolean bolPagofinanzas;
    @JoinColumn(name = "cod_empquincenaid_fk", referencedColumnName = "cod_empquincenaid")
    @ManyToOne()
    private Tsgnomempquincena codEmpquincenaidFk;

    public Tsgnomconfpago() {
    }

    public Tsgnomconfpago(Integer codConfpagoid) {
        this.codConfpagoid = codConfpagoid;
    }

    public Integer getCodConfpagoid() {
        return codConfpagoid;
    }

    public void setCodConfpagoid(Integer codConfpagoid) {
        this.codConfpagoid = codConfpagoid;
    }

    public Boolean getBolPagoempleado() {
        return bolPagoempleado;
    }

    public void setBolPagoempleado(Boolean bolPagoempleado) {
        this.bolPagoempleado = bolPagoempleado;
    }

    public Boolean getBolPagorh() {
        return bolPagorh;
    }

    public void setBolPagorh(Boolean bolPagorh) {
        this.bolPagorh = bolPagorh;
    }

    public Boolean getBolPagofinanzas() {
        return bolPagofinanzas;
    }

    public void setBolPagofinanzas(Boolean bolPagofinanzas) {
        this.bolPagofinanzas = bolPagofinanzas;
    }

    public Tsgnomempquincena getCodEmpquincenaidFk() {
        return codEmpquincenaidFk;
    }

    public void setCodEmpquincenaidFk(Tsgnomempquincena codEmpquincenaidFk) {
        this.codEmpquincenaidFk = codEmpquincenaidFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codConfpagoid != null ? codConfpagoid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tsgnomconfpago)) {
            return false;
        }
        Tsgnomconfpago other = (Tsgnomconfpago) object;
        if ((this.codConfpagoid == null && other.codConfpagoid != null) || (this.codConfpagoid != null && !this.codConfpagoid.equals(other.codConfpagoid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mbn.sinod.model.entidades.Tsgnomconfpago[ codConfpagoid=" + codConfpagoid + " ]";
    }
    
}
