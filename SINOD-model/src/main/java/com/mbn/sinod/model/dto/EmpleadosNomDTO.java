/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.dto;

import com.mbn.sinod.model.entidades.Tsgnomempleados;
import java.util.List;

/**
 *
 * @author Ivette
 */
public class EmpleadosNomDTO extends GenericDTO {
    
    private Tsgnomempleados empleado; 
    private List<Tsgnomempleados> listarEmpleadosNom;

    public List<Tsgnomempleados> getListarEmpleadosNom() {
        return listarEmpleadosNom;
    }

    public void setListarEmpleadosNom(List<Tsgnomempleados> listarEmpleadosNom) {
        this.listarEmpleadosNom = listarEmpleadosNom;
    }

    public Tsgnomempleados getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Tsgnomempleados empleado) {
        this.empleado = empleado;
    }  
    
}
