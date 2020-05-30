/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.dto;

import com.mbn.sinod.model.entidades.Tsgnomconfpago;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author eduardotorres
 */
public class DetalleEmpDTO extends GenericDTO{


    private Integer codempleado;
    private String despuesto;
    private String nomcompleto;
    private String desnbarea;
    private Integer codempqui;
    private Boolean bol_pagorh;
    private Boolean bol_pagofinanzas;
    private Boolean bol_pagoempleado;
    private BigDecimal monto;
    
    private List<DetalleEmpDTO> listaDetalleDTO;
    private List<ConfPagoDTO> listaPagos;
    
    private Tsgnomconfpago confirmaPago;
    private ArrayList<Tsgnomconfpago> ArrayListaConfirmaPago;
    
    /**
     * @return the codempleado
     */
    public Integer getCodempleado() {
        return codempleado;
    }

    /**
     * @param codempleado the codempleado to set
     */
    public void setCodempleado(Integer codempleado) {
        this.codempleado = codempleado;
    }

    /**
     * @return the despuesto
     */
    public String getDespuesto() {
        return despuesto;
    }

    /**
     * @param despuesto the despuesto to set
     */
    public void setDespuesto(String despuesto) {
        this.despuesto = despuesto;
    }
    
     /**
     * @return the nomcompleto
     */
    public String getNomcompleto() {
        return nomcompleto;
    }

    /**
     * @param nomcompleto the nomcompleto to set
     */
    public void setNomcompleto(String nomcompleto) {
        this.nomcompleto = nomcompleto;
    }

    /**
     * @return the desnbarea
     */
    public String getDesnbarea() {
        return desnbarea;
    }

    /**
     * @param desnbarea the desnbarea to set
     */
    public void setDesnbarea(String desnbarea) {
        this.desnbarea = desnbarea;
    }

    /**
     * @return the codempqui
     */
    public Integer getCodempqui() {
        return codempqui;
    }

    /**
     * @param codempqui the codempqui to set
     */
    public void setCodempqui(Integer codempqui) {
        this.codempqui = codempqui;
    }

    /**
     * @return the bol_pagorh
     */
    public Boolean getBol_pagorh() {
        return bol_pagorh;
    }

    /**
     * @param bol_pagorh the bol_pagorh to set
     */
    public void setBol_pagorh(Boolean bol_pagorh) {
        this.bol_pagorh = bol_pagorh;
    }

    /**
     * @return the bol_pagofinanzas
     */
    public Boolean getBol_pagofinanzas() {
        return bol_pagofinanzas;
    }

    /**
     * @param bol_pagofinanzas the bol_pagofinanzas to set
     */
    public void setBol_pagofinanzas(Boolean bol_pagofinanzas) {
        this.bol_pagofinanzas = bol_pagofinanzas;
    }

    /**
     * @return the bol_pagoempleado
     */
    public Boolean getBol_pagoempleado() {
        return bol_pagoempleado;
    }

    /**
     * @param bol_pagoempleado the bol_pagoempleado to set
     */
    public void setBol_pagoempleado(Boolean bol_pagoempleado) {
        this.bol_pagoempleado = bol_pagoempleado;
    }

    /**
     * @return the listaDetalleDTO
     */
    public List<DetalleEmpDTO> getListaDetalleDTO() {
        return listaDetalleDTO;
    }

    /**
     * @param listaDetalleDTO the listaDetalleDTO to set
     */
    public void setListaDetalleDTO(List<DetalleEmpDTO> listaDetalleDTO) {
        this.listaDetalleDTO = listaDetalleDTO;
    }

    /**
     * @return the listaPagos
     */
    public List<ConfPagoDTO> getListaPagos() {
        return listaPagos;
    }

    /**
     * @param listaPagos the listaPagos to set
     */
    public void setListaPagos(List<ConfPagoDTO> listaPagos) {
        this.listaPagos = listaPagos;
    }

    /**
     * @return the confirmaPago
     */
    public Tsgnomconfpago getConfirmaPago() {
        return confirmaPago;
    }

    /**
     * @param confirmaPago the confirmaPago to set
     */
    public void setConfirmaPago(Tsgnomconfpago confirmaPago) {
        this.confirmaPago = confirmaPago;
    }

    /**
     * @return the ArrayListaConfirmaPago
     */
    public ArrayList<Tsgnomconfpago> getArrayListaConfirmaPago() {
        return ArrayListaConfirmaPago;
    }

    /**
     * @param ArrayListaConfirmaPago the ArrayListaConfirmaPago to set
     */
    public void setArrayListaConfirmaPago(ArrayList<Tsgnomconfpago> ArrayListaConfirmaPago) {
        this.ArrayListaConfirmaPago = ArrayListaConfirmaPago;
    }

    /**
     * @return the monto
     */
    public BigDecimal getMonto() {
        return monto;
    }

    /**
     * @param monto the monto to set
     */
    public void setMonto(BigDecimal monto) {
        this.monto = monto;
    }

        
}
