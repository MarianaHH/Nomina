/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.dto;

import com.mbn.sinod.model.entidades.Tsgnomcatincidencia;
import java.util.List;

/**
 *
 * @author ambrosio
 */
public class CatIncidenciaDTO extends GenericDTO{
    private Tsgnomcatincidencia catIncidencia;
    private List<Tsgnomcatincidencia> listarCatIncidencias;

    /**
     * @return the listarCatIncidencias
     */
    public List<Tsgnomcatincidencia> getListarCatIncidencias() {
        return listarCatIncidencias;
    }

    /**
     * @param listarCatIncidencias the listarCatIncidencias to set
     */
    public void setListarCatIncidencias(List<Tsgnomcatincidencia> listarCatIncidencias) {
        this.listarCatIncidencias = listarCatIncidencias;
    }

    /**
     * @return the catIncidencia
     */
    public Tsgnomcatincidencia getCatIncidencia() {
        return catIncidencia;
    }

    /**
     * @param catIncidencia the catIncidencia to set
     */
    public void setCatIncidencia(Tsgnomcatincidencia catIncidencia) {
        this.catIncidencia = catIncidencia;
    }
}
