/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.dto;

import java.util.List;

/**
 *
 * @author eduardotorres
 */
public class EmpDTO extends GenericDTO{
    private List<DetalleEmpDTO> listaEmp;
    private DetalleEmpDTO ConfirmaEmp;

    /**
     * @return the listaEmp
     */
    public List<DetalleEmpDTO> getListaEmp() {
        return listaEmp;
    }

    /**
     * @param listaEmp the listaEmp to set
     */
    public void setListaEmp(List<DetalleEmpDTO> listaEmp) {
        this.listaEmp = listaEmp;
    }

    /**
     * @return the ConfirmaEmp
     */
    public DetalleEmpDTO getConfirmaEmp() {
        return ConfirmaEmp;
    }

    /**
     * @param ConfirmaEmp the ConfirmaEmp to set
     */
    public void setConfirmaEmp(DetalleEmpDTO ConfirmaEmp) {
        this.ConfirmaEmp = ConfirmaEmp;
    }
    
}
