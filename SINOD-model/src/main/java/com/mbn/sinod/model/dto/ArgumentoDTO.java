/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.dto;

import com.mbn.sinod.model.entidades.Tsgnomargumento;
import java.util.List;

/**
 *
 * @author mariana
 */
public class ArgumentoDTO extends GenericDTO {
    private List<Tsgnomargumento> listaArgumentos;
    private Tsgnomargumento argumento;
  

    public List<Tsgnomargumento> getListaArgumentos() {
        return listaArgumentos;
    }

    public void setListaArgumentos(List<Tsgnomargumento> listaArgumentos) {
        this.listaArgumentos = listaArgumentos;
    }

    public Tsgnomargumento getArgumento() {
        return argumento;
    }

    public void setArgumento(Tsgnomargumento argumento) {
        this.argumento = argumento;
    }

 
}
