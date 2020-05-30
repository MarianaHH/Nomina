/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.dto;

/**
 *
 * @author ambrosio
 */
public class PrioridadCalculoDTO extends GenericDTO {
    private Integer id;
    private Integer indexOrigen;
    private Integer indexDestino;
    private Integer prioridadCalculo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIndexOrigen() {
        return indexOrigen;
    }

    public void setIndexOrigen(Integer indexOrigen) {
        this.indexOrigen = indexOrigen;
    }

    public Integer getIndexDestino() {
        return indexDestino;
    }

    public void setIndexDestino(Integer indexDestino) {
        this.indexDestino = indexDestino;
    }

    public Integer getPrioridadCalculo() {
        return prioridadCalculo;
    }

    public void setPrioridadCalculo(Integer prioridadCalculo) {
        this.prioridadCalculo = prioridadCalculo;
    }
    
    
}
