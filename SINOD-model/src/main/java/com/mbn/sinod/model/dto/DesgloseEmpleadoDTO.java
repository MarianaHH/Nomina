/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Ambro
 */
public class DesgloseEmpleadoDTO extends GenericDTO {

    private Date fecha;
    private BigDecimal sueldoimss;
    private BigDecimal sueldohono;
    private String estatus;
    private List<DesgloseEmpleadoDTO> listaDesgloce;

    /**
     * @return the fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /**
     * @return the sueldoimss
     */
    public BigDecimal getSueldoimss() {
        return sueldoimss;
    }

    /**
     * @param sueldoimss the sueldoimss to set
     */
    public void setSueldoimss(BigDecimal sueldoimss) {
        this.sueldoimss = sueldoimss;
    }

    /**
     * @return the sueldohono
     */
    public BigDecimal getSueldohono() {
        return sueldohono;
    }

    /**
     * @param sueldohono the sueldohono to set
     */
    public void setSueldohono(BigDecimal sueldohono) {
        this.sueldohono = sueldohono;
    }

    /**
     * @return the estatus
     */
    public String getEstatus() {
        return estatus;
    }

    /**
     * @param estatus the estatus to set
     */
    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    /**
     * @return the listaDesgloce
     */
    public List<DesgloseEmpleadoDTO> getListaDesgloce() {
        return listaDesgloce;
    }

    /**
     * @param listaDesgloce the listaDesgloce to set
     */
    public void setListaDesgloce(List<DesgloseEmpleadoDTO> listaDesgloce) {
        this.listaDesgloce = listaDesgloce;
    }

}
