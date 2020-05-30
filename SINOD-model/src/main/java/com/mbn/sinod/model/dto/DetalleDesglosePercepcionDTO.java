/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.dto;

import java.math.BigDecimal;

/**
 *
 * @author torre
 */
public class DetalleDesglosePercepcionDTO extends GenericDTO{
    
    private BigDecimal imp_concepto;
    private BigDecimal imp_exento;
    private BigDecimal imp_gravado;
    private String nombre;
    private String clave;
    private Integer cod_conceptoid_fk;

    /**
     * @return the imp_concepto
     */
    public BigDecimal getImp_concepto() {
        return imp_concepto;
    }

    /**
     * @param imp_concepto the imp_concepto to set
     */
    public void setImp_concepto(BigDecimal imp_concepto) {
        this.imp_concepto = imp_concepto;
    }

    /**
     * @return the imp_exento
     */
    public BigDecimal getImp_exento() {
        return imp_exento;
    }

    /**
     * @param imp_exento the imp_exento to set
     */
    public void setImp_exento(BigDecimal imp_exento) {
        this.imp_exento = imp_exento;
    }

    /**
     * @return the imp_gravado
     */
    public BigDecimal getImp_gravado() {
        return imp_gravado;
    }

    /**
     * @param imp_gravado the imp_gravado to set
     */
    public void setImp_gravado(BigDecimal imp_gravado) {
        this.imp_gravado = imp_gravado;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
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
     * @return the cod_conceptoid_fk
     */
    public Integer getCod_conceptoid_fk() {
        return cod_conceptoid_fk;
    }

    /**
     * @param cod_conceptoid_fk the cod_conceptoid_fk to set
     */
    public void setCod_conceptoid_fk(Integer cod_conceptoid_fk) {
        this.cod_conceptoid_fk = cod_conceptoid_fk;
    }
}
