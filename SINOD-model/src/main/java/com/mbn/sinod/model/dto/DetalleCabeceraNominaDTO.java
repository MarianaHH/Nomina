/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.dto;

import java.math.BigDecimal;

/**
 *
 * @author FIRST CASH
 */
public class DetalleCabeceraNominaDTO {

    private String nom_nomina; 
    private Integer nom_valorejercicio;
    private Integer nom_quincena;
    private String nom_tipo; 
    private String nom_estado;
    private Integer nom_totempleados;
    private BigDecimal nom_percepcion; 
    private BigDecimal nom_deduccion;
    private BigDecimal nom_total;
    
    /**
     * @return the nom_nomina
     */
    public String getNom_nomina() {
        return nom_nomina;
    }

    /**
     * @param nom_nomina the nom_nomina to set
     */
    public void setNom_nomina(String nom_nomina) {
        this.nom_nomina = nom_nomina;
    }

    /**
     * @return the nom_valorejercicio
     */
    public Integer getNom_valorejercicio() {
        return nom_valorejercicio;
    }

    /**
     * @param nom_valorejercicio the nom_valorejercicio to set
     */
    public void setNom_valorejercicio(Integer nom_valorejercicio) {
        this.nom_valorejercicio = nom_valorejercicio;
    }

    /**
     * @return the nom_quincena
     */
    public Integer getNom_quincena() {
        return nom_quincena;
    }

    /**
     * @param nom_quincena the nom_quincena to set
     */
    public void setNom_quincena(Integer nom_quincena) {
        this.nom_quincena = nom_quincena;
    }

    /**
     * @return the nom_tipo
     */
    public String getNom_tipo() {
        return nom_tipo;
    }

    /**
     * @param nom_tipo the nom_tipo to set
     */
    public void setNom_tipo(String nom_tipo) {
        this.nom_tipo = nom_tipo;
    }

    /**
     * @return the nom_estado
     */
    public String getNom_estado() {
        return nom_estado;
    }

    /**
     * @param nom_estado the nom_estado to set
     */
    public void setNom_estado(String nom_estado) {
        this.nom_estado = nom_estado;
    }

    /**
     * @return the nom_totempleados
     */
    public Integer getNom_totempleados() {
        return nom_totempleados;
    }

    /**
     * @param nom_totempleados the nom_totempleados to set
     */
    public void setNom_totempleados(Integer nom_totempleados) {
        this.nom_totempleados = nom_totempleados;
    }

    /**
     * @return the nom_percepcion
     */
    public BigDecimal getNom_percepcion() {
        return nom_percepcion;
    }

    /**
     * @param nom_percepcion the nom_percepcion to set
     */
    public void setNom_percepcion(BigDecimal nom_percepcion) {
        this.nom_percepcion = nom_percepcion;
    }

    /**
     * @return the nom_deduccion
     */
    public BigDecimal getNom_deduccion() {
        return nom_deduccion;
    }

    /**
     * @param nom_deduccion the nom_deduccion to set
     */
    public void setNom_deduccion(BigDecimal nom_deduccion) {
        this.nom_deduccion = nom_deduccion;
    }

    /**
     * @return the nom_total
     */
    public BigDecimal getNom_total() {
        return nom_total;
    }

    /**
     * @param nom_total the nom_total to set
     */
    public void setNom_total(BigDecimal nom_total) {
        this.nom_total = nom_total;
    }
    
}
