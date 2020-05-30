/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.dto;

import com.mbn.sinod.model.entidades.Tsgnomcncptoquincht;
import java.util.List;

/**
 *
 * @author Ambro
 */
public class ConcepQuincHTDTO extends GenericDTO{
    private Tsgnomcncptoquincht cncptoquinc;
    private List<Tsgnomcncptoquincht> listCncptoquinc;

    /**
     * @return the cncptoquinc
     */
    public Tsgnomcncptoquincht getCncptoquinc() {
        return cncptoquinc;
    }

    /**
     * @param cncptoquinc the cncptoquinc to set
     */
    public void setCncptoquinc(Tsgnomcncptoquincht cncptoquinc) {
        this.cncptoquinc = cncptoquinc;
    }

    /**
     * @return the listCncptoquinc
     */
    public List<Tsgnomcncptoquincht> getListCncptoquinc() {
        return listCncptoquinc;
    }

    /**
     * @param listCncptoquinc the listCncptoquinc to set
     */
    public void setListCncptoquinc(List<Tsgnomcncptoquincht> listCncptoquinc) {
        this.listCncptoquinc = listCncptoquinc;
    }
}
