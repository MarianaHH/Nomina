
package com.mbn.sinod.model.dto;

import com.mbn.sinod.model.entidades.Tsgrhareas;
import java.util.List;

/**
 * Clase DTO genérica que encapsula los datos enviados a través de los WS
 * 
 * @author Francisco R M, MBN
 * @version 2.0
 * 
 */
public class AreasDTO extends GenericDTO {

    /**
     * @return the area
     */
    public Tsgrhareas getArea() {
        return area;
    }

    /**
     * @param area the area to set
     */
    public void setArea(Tsgrhareas area) {
        this.area = area;
    }
    
    private List<Tsgrhareas> listarAreas;
    private Tsgrhareas area;

    /**
     * @return the listarAreas
     */
    public List<Tsgrhareas> getListarAreas() {
        return listarAreas;
    }

    /**
     * @param listarAreas the listarAreas to set
     */
    public void setListarAreas(List<Tsgrhareas> listarAreas) {
        this.listarAreas = listarAreas;
    }
}
