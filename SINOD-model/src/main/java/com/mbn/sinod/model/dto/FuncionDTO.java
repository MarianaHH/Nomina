/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.dto;

import com.mbn.sinod.model.entidades.Tsgnomfuncion;
import java.util.List;

/**
 *
 * @author mariana
 */
public class FuncionDTO extends GenericDTO {
    private List<Tsgnomfuncion> listafunciones;
    private Tsgnomfuncion funcion;

    public List<Tsgnomfuncion> getListafunciones() {
        return listafunciones;
    }

    public void setListafunciones(List<Tsgnomfuncion> listafunciones) {
        this.listafunciones = listafunciones;
    }

    public Tsgnomfuncion getFuncion() {
        return funcion;
    }

    public void setFuncion(Tsgnomfuncion funcion) {
        this.funcion = funcion;
    }
    
    

    
}
