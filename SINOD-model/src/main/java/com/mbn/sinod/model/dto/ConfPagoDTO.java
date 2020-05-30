/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.dto;

import com.mbn.sinod.model.entidades.Tsgnomconfpago;
import java.util.ArrayList;

/**
 *
 * @author torre
 */
public class ConfPagoDTO extends GenericDTO{
   
    private Tsgnomconfpago confirmaPago;
    private ArrayList<Tsgnomconfpago> ArrayListaConfirmaPago;

    /**
     * @return the confirmaPago
     */
    public Tsgnomconfpago getConfirmaPago() {
        return confirmaPago;
    }

    /**
     * @param confirmaPago the confirmaPago to set
     */
    public void setConfirmaPago(Tsgnomconfpago confirmaPago) {
        this.confirmaPago = confirmaPago;
    }

    /**
     * @return the ArrayListaConfirmaPago
     */
    public ArrayList<Tsgnomconfpago> getArrayListaConfirmaPago() {
        return ArrayListaConfirmaPago;
    }

    /**
     * @param ArrayListaConfirmaPago the ArrayListaConfirmaPago to set
     */
    public void setArrayListaConfirmaPago(ArrayList<Tsgnomconfpago> ArrayListaConfirmaPago) {
        this.ArrayListaConfirmaPago = ArrayListaConfirmaPago;
    }

    
}
