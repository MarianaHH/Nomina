/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.dto;

import com.mbn.sinod.model.entidades.Tsgnomclasificador;
import java.util.List;

/**
 *
 * @author ambrosio
 */
public class CatClasificadorDTO extends GenericDTO{
    private Tsgnomclasificador catClasificador;
    private List<Tsgnomclasificador> listaCatClasificadores;

    /**
     * @return the catClasificador
     */
    public Tsgnomclasificador getCatClasificador() {
        return catClasificador;
    }

    /**
     * @param catClasificador the catClasificador to set
     */
    public void setCatClasificador(Tsgnomclasificador catClasificador) {
        this.catClasificador = catClasificador;
    }

    /**
     * @return the listaCatClasificadores
     */
    public List<Tsgnomclasificador> getListaCatClasificadores() {
        return listaCatClasificadores;
    }

    /**
     * @param listaCatClasificadores the listaCatClasificadores to set
     */
    public void setListaCatClasificadores(List<Tsgnomclasificador> listaCatClasificadores) {
        this.listaCatClasificadores = listaCatClasificadores;
    }
}
