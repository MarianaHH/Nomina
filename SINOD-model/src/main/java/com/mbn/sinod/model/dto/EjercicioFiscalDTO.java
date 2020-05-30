/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.dto;

import com.mbn.sinod.model.entidades.Tsgnomejercicio;
import java.util.List;

/**
 *
 * @author mipe
 */
public class EjercicioFiscalDTO extends GenericDTO{
    private Tsgnomejercicio ejercicio;
    private List<Tsgnomejercicio> listaEjercicios;

    /**
     * @return the ejercicio
     */
    public Tsgnomejercicio getEjercicio() {
        return ejercicio;
    }

    /**
     * @param ejercicio the ejercicio to set
     */
    public void setEjercicio(Tsgnomejercicio ejercicio) {
        this.ejercicio = ejercicio;
    }

    /**
     * @return the listaEjercicios
     */
    public List<Tsgnomejercicio> getListaEjercicios() {
        return listaEjercicios;
    }

    /**
     * @param listaEjercicios the listaEjercicios to set
     */
    public void setListaEjercicios(List<Tsgnomejercicio> listaEjercicios) {
        this.listaEjercicios = listaEjercicios;
    }
    
}
