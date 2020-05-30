/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.dto;

import com.mbn.sinod.model.entidades.Tsgnomincidencia;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Karla
 */
public class IncidenciasDTO extends GenericDTO {
    
    private Tsgnomincidencia incidencia;
    private List<Tsgnomincidencia> listaIncidencias;

    public IncidenciasDTO(){
        this.incidencia = new Tsgnomincidencia();
        this.listaIncidencias = new ArrayList<Tsgnomincidencia>();
    }
    
    public Tsgnomincidencia getIncidencia() {
        return incidencia;
    }

    public void setIncidencia(Tsgnomincidencia incidencia) {
        this.incidencia = incidencia;
    }

    public List<Tsgnomincidencia> getListaIncidencias() {
        return listaIncidencias;
    }

    public void setListaIncidencias(List<Tsgnomincidencia> listaIncidencias) {
        this.listaIncidencias = listaIncidencias;
    }
    
}
