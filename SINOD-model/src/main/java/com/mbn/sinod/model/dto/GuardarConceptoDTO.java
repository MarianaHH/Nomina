/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.dto;


/**
 *
 * @author mariana
 */
public class GuardarConceptoDTO {
    private Integer id_concepto;
    private String nombre_concepto;
    private String clave;
    private Integer prioridad_calculo;
    private Integer fundamento_legal;
    private Integer formula_id;
    private String formula;
    private String nombre_formula;
    private Integer tipo_concepto;
    private Integer tipo_calculo;
    private Integer concepto_sat;
    private String frecuencia_pago;
    private Integer partida_presupuestal;
    private Integer cuenta_contable;
    private Character gravado;
    private Character excento;
    private boolean aplica_isn;
    private boolean aplica_retroactividad;
    private Integer tope_exception;
    private Integer clasificador_concepto;
    private Integer tipo_nomina;
    private Integer usuario_crea;

    public Integer getId_concepto() {
        return id_concepto;
    }

    public void setId_concepto(Integer id_concepto) {
        this.id_concepto = id_concepto;
    }

    public String getNombre_concepto() {
        return nombre_concepto;
    }

    public void setNombre_concepto(String nombre_concepto) {
        this.nombre_concepto = nombre_concepto;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public Integer getPrioridad_calculo() {
        return prioridad_calculo;
    }

    public void setPrioridad_calculo(Integer prioridad_calculo) {
        this.prioridad_calculo = prioridad_calculo;
    }

    public Integer getFundamento_legal() {
        return fundamento_legal;
    }

    public void setFundamento_legal(Integer fundamento_legal) {
        this.fundamento_legal = fundamento_legal;
    }

    public Integer getFormula_id() {
        return formula_id;
    }

    public void setFormula_id(Integer formula_id) {
        this.formula_id = formula_id;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public String getNombre_formula() {
        return nombre_formula;
    }

    public void setNombre_formula(String nombre_formula) {
        this.nombre_formula = nombre_formula;
    }

    public Integer getTipo_concepto() {
        return tipo_concepto;
    }

    public void setTipo_concepto(Integer tipo_concepto) {
        this.tipo_concepto = tipo_concepto;
    }

    public Integer getTipo_calculo() {
        return tipo_calculo;
    }

    public void setTipo_calculo(Integer tipo_calculo) {
        this.tipo_calculo = tipo_calculo;
    }

    public Integer getConcepto_sat() {
        return concepto_sat;
    }

    public void setConcepto_sat(Integer concepto_sat) {
        this.concepto_sat = concepto_sat;
    }

    public String getFrecuencia_pago() {
        return frecuencia_pago;
    }

    public void setFrecuencia_pago(String frecuencia_pago) {
        this.frecuencia_pago = frecuencia_pago;
    }

    public Integer getPartida_presupuestal() {
        return partida_presupuestal;
    }

    public void setPartida_presupuestal(Integer partida_presupuestal) {
        this.partida_presupuestal = partida_presupuestal;
    }

    public Integer getCuenta_contable() {
        return cuenta_contable;
    }

    public void setCuenta_contable(Integer cuenta_contable) {
        this.cuenta_contable = cuenta_contable;
    }

    public Character getGravado() {
        return gravado;
    }

    public void setGravado(Character gravado) {
        this.gravado = gravado;
    }

    public Character getExcento() {
        return excento;
    }

    public void setExcento(Character excento) {
        this.excento = excento;
    }

    public boolean isAplica_isn() {
        return aplica_isn;
    }

    public void setAplica_isn(boolean aplica_isn) {
        this.aplica_isn = aplica_isn;
    }

    public boolean isAplica_retroactividad() {
        return aplica_retroactividad;
    }

    public void setAplica_retroactividad(boolean aplica_retroactividad) {
        this.aplica_retroactividad = aplica_retroactividad;
    }

    public Integer getTope_exception() {
        return tope_exception;
    }

    public void setTope_exception(Integer tope_exception) {
        this.tope_exception = tope_exception;
    }

    public Integer getClasificador_concepto() {
        return clasificador_concepto;
    }

    public void setClasificador_concepto(Integer clasificador_concepto) {
        this.clasificador_concepto = clasificador_concepto;
    }

    public Integer getTipo_nomina() {
        return tipo_nomina;
    }

    public void setTipo_nomina(Integer tipo_nomina) {
        this.tipo_nomina = tipo_nomina;
    }

    public Integer getUsuario_crea() {
        return usuario_crea;
    }

    public void setUsuario_crea(Integer usuario_crea) {
        this.usuario_crea = usuario_crea;
    }
    
    
    
}
