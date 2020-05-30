
package com.mbn.sinod.model.dto;

import com.mbn.sinod.model.entidades.Tsgrhpuestos;
import java.util.List;

/**
 *
 * @author eduardotorres
 * 
 * 
 * 
 */
public class PuestosDTO extends GenericDTO {
    private List<Tsgrhpuestos> listarPuestos;
    private Tsgrhpuestos puesto;

    /**
     * @return the listarPuestos
     */
    public List<Tsgrhpuestos> getListarPuestos() {
        return listarPuestos;
    }

    /**
     * @param listarPuestos the listarPuestos to set
     */
    public void setListarPuestos(List<Tsgrhpuestos> listarPuestos) {
        this.listarPuestos = listarPuestos;
    }

    /**
     * @return the puesto
     */
    public Tsgrhpuestos getPuesto() {
        return puesto;
    }

    /**
     * @param puesto the puesto to set
     */
    public void setPuesto(Tsgrhpuestos puesto) {
        this.puesto = puesto;
    }
    
}
