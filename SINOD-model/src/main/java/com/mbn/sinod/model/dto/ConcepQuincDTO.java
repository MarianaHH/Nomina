/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.dto;

import com.mbn.sinod.model.entidades.Tsgnomcncptoquinc;
import java.util.List;

/**
 *
 * @author User
 */
public class ConcepQuincDTO extends GenericDTO{
    private Tsgnomcncptoquinc cncptoquinc;
    private List<Tsgnomcncptoquinc> listCncptoquinc;

    /**
     * @return the cncptoquinc
     */
    public Tsgnomcncptoquinc getCncptoquinc() {
        return cncptoquinc;
    }

    /**
     * @param cncptoquinc the cncptoquinc to set
     */
    public void setCncptoquinc(Tsgnomcncptoquinc cncptoquinc) {
        this.cncptoquinc = cncptoquinc;
    }

    /**
     * @return the listCncptoquinc
     */
    public List<Tsgnomcncptoquinc> getListCncptoquinc() {
        return listCncptoquinc;
    }

    /**
     * @param listCncptoquinc the listCncptoquinc to set
     */
    public void setListCncptoquinc(List<Tsgnomcncptoquinc> listCncptoquinc) {
        this.listCncptoquinc = listCncptoquinc;
    }
}
