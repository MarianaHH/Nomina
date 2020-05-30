/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.negocio;

import com.mbn.sinod.model.dao.ValidacionesNomBajasDAO;
import com.mbn.sinod.model.dto.InfoValidacionesNomBajasDTO;
import com.mbn.sinod.model.entidades.Tsgnomempleados;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Ivette
 */
public class ValidacionesNomBajasServiceImpl extends BaseServiceImpl<Tsgnomempleados,Integer>
implements  ValidacionesNomBajasService {
    
    @Autowired 
    private ValidacionesNomBajasDAO validacionesNomBajasDAO;

    public ValidacionesNomBajasDAO getValidacionesNomBajasDAO() {
        return validacionesNomBajasDAO;
    }

    public void setValidacionesNomBajasDAO(ValidacionesNomBajasDAO validacionesNomBajasDAO) {
        this.validacionesNomBajasDAO = validacionesNomBajasDAO;
    }

    @Override
    public InfoValidacionesNomBajasDTO detallesValidacionesNominaBajas() {
        InfoValidacionesNomBajasDTO dto = new InfoValidacionesNomBajasDTO();
        dto.setListaValidacionesNomBajas(getValidacionesNomBajasDAO().detallesValidacionesNominaBajas());
        return dto;
    }
    
}
