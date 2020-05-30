/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.dto;

import com.mbn.sinod.model.entidades.Tsgnomempquincena;
import java.util.List;

/**
 *
 * @author ambrosio
 */
public class EmpQuincenasDTO extends GenericDTO{
    private Boolean confirmacion;
    private Tsgnomempquincena empQuincena;
    private List<Tsgnomempquincena> listaEmpQuincena;

    /**
     * @return the empQuincena
     */
    public Tsgnomempquincena getEmpQuincena() {
        return empQuincena;
    }

    /**
     * @param empQuincena the empQuincena to set
     */
    public void setEmpQuincena(Tsgnomempquincena empQuincena) {
        this.empQuincena = empQuincena;
    }

    /**
     * @return the listaEmpQuincena
     */
    public List<Tsgnomempquincena> getListaEmpQuincena() {
        return listaEmpQuincena;
    }

    /**
     * @param listaEmpQuincena the listaEmpQuincena to set
     */
    public void setListaEmpQuincena(List<Tsgnomempquincena> listaEmpQuincena) {
        this.listaEmpQuincena = listaEmpQuincena;
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
