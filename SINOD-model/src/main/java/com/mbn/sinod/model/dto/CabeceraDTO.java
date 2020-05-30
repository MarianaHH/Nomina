/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.dto;

import com.mbn.sinod.model.entidades.Tsgnomcabecera;
import java.util.List;

/**
 *
 * @author Mi Pe
 */
public class CabeceraDTO extends GenericDTO {

    private Tsgnomcabecera cabecera;
    private List<Tsgnomcabecera> listarCabecera;
    private Boolean confirmacion;

    /**
     * @return the CatCabecera
     */
    public Tsgnomcabecera getCabecera() {
        return cabecera;
    }

    /**
     * @param CatCabecera the CatCabecera to set
     */
    public void setCabecera(Tsgnomcabecera Cabecera) {
        this.cabecera = Cabecera;
    }

    /**
     * @return the listarCabecera
     */
    public List<Tsgnomcabecera> getListarCabecera() {
        return listarCabecera;
    }

    /**
     * @param listarCabecera the listarCabecera to set
     */
    public void setListarCabecera(List<Tsgnomcabecera> listarCabecera) {
        this.listarCabecera = listarCabecera;
    }

    /**
     * @return the confirmacion
     */
    public Boolean getConfirmacion() {
        return confirmacion;
    }

    /**
     * @param confirmacion the confirmacion to set
     */
    public void setConfirmacion(Boolean confirmacion) {
        this.confirmacion = confirmacion;
    }
}
