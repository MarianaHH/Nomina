/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.dto;

import com.mbn.sinod.model.entidades.Tsgnomquincena;
import java.util.List;

/**
 *
 * @author mipe
 */
public class CatCalendarioDTO extends GenericDTO{
    private Tsgnomquincena quincena;
            private List<Tsgnomquincena> listarquincena;

    /**
     * @return the quincena
     */
    public Tsgnomquincena getQuincena() {
        return quincena;
    }

    /**
     * @param quincena the quincena to set
     */
    public void setQuincena(Tsgnomquincena quincena) {
        this.quincena = quincena;
    }

    /**
     * @return the listarquincena
     */
    public List<Tsgnomquincena> getListarquincena() {
        return listarquincena;
    }

    /**
     * @param listarquincena the listarquincena to set
     */
    public void setListarquincena(List<Tsgnomquincena> listarquincena) {
        this.listarquincena = listarquincena;
    }
            
}
