/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.negocio;

import com.mbn.sinod.model.dao.ValidacionesNominaDAO;
import com.mbn.sinod.model.dto.InfoValidacionesNominaDTO;
import com.mbn.sinod.model.entidades.Tsgnomempleados;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Ivette
 */
public class ValidacionesNominaServiceImpl extends BaseServiceImpl<Tsgnomempleados,Integer>
implements  ValidacionesNominaService  {
    
    @Autowired 
    private ValidacionesNominaDAO validacionesNominaDAO;

    public ValidacionesNominaDAO getValidacionesNominaDAO() {
        return validacionesNominaDAO;
    }

    public void setValidacionesNominaDAO(ValidacionesNominaDAO validacionesNominaDAO) {
        this.validacionesNominaDAO = validacionesNominaDAO;
    }

    @Override
    public InfoValidacionesNominaDTO detallesValidacionesNomina() {
        InfoValidacionesNominaDTO dto = new InfoValidacionesNominaDTO();
        dto.setListaValidacionesNomina(getValidacionesNominaDAO().detallesValidacionesNomina());
        return dto;
    }
    
}
