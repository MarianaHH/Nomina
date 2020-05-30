/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.dto;

import com.mbn.sinod.model.entidades.Tsgnomestatusnom;
import java.util.List;

/**
 *
 * @author User
 */
public class EstatusNominaDTO extends GenericDTO{
    private Tsgnomestatusnom estatusNomina;
    private List<Tsgnomestatusnom> listEstatusNomina;

    /**
     * @return the estatusNomina
     */
    public Tsgnomestatusnom getEstatusNomina() {
        return estatusNomina;
    }

    /**
     * @param estatusNomina the estatusNomina to set
     */
    public void setEstatusNomina(Tsgnomestatusnom estatusNomina) {
        this.estatusNomina = estatusNomina;
    }

    /**
     * @return the listEstatusNomina
     */
    public List<Tsgnomestatusnom> getListEstatusNomina() {
        return listEstatusNomina;
    }

    /**
     * @param listEstatusNomina the listEstatusNomina to set
     */
    public void setListEstatusNomina(List<Tsgnomestatusnom> listEstatusNomina) {
        this.listEstatusNomina = listEstatusNomina;
    }
}
