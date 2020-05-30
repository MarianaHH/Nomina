/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.dto;

import com.mbn.sinod.model.dto.GenericDTO;
import com.mbn.sinod.model.entidades.Tsgnomempquincena;
import java.util.List;

/**
 *
 * @author mipe
 */
public class EmpQuincenaDTO extends GenericDTO{
    private Tsgnomempquincena quincena;
    private List<Tsgnomempquincena> listarEmpQuincena;

    
    /**
     * @return the quincena
     */
    public Tsgnomempquincena getQuincena() {
        return quincena;
    }

    /**
     * @param quincena the quincena to set
     */
    public void setQuincena(Tsgnomempquincena quincena) {
        this.quincena = quincena;
    }

    /**
     * @return the listarEmpQuincena
     */
    public List<Tsgnomempquincena> getListarEmpQuincena() {
        return listarEmpQuincena;
    }

    /**
     * @param listarEmpQuincena the listarEmpQuincena to set
     */
    public void setListarEmpQuincena(List<Tsgnomempquincena> listarEmpQuincena) {
        this.listarEmpQuincena = listarEmpQuincena;
    }

    
}







