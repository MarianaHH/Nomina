/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.negocio;

import com.mbn.sinod.model.dao.VerInformacionDePersonalDAO;
import com.mbn.sinod.model.dto.InformacionPorPersonalDTO;
import com.mbn.sinod.model.entidades.Tsgrhempleados;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Ivette
 */
public class VerInformacionDePersonalServiceImpl extends BaseServiceImpl<Tsgrhempleados,Integer>
implements VerInformacionDePersonalService {
    
    @Autowired 
    private VerInformacionDePersonalDAO verInformacionDePersonalDAO;

    public VerInformacionDePersonalDAO getVerInformacionDePersonalDAO() {
        return verInformacionDePersonalDAO;
    }

    public void setVerInformacionDePersonalDAO(VerInformacionDePersonalDAO verInformacionDePersonalDAO) {
        this.verInformacionDePersonalDAO = verInformacionDePersonalDAO;
    }

    @Override
    public InformacionPorPersonalDTO informacionPorPersonal(Integer cod_empleadoid) {
        
        InformacionPorPersonalDTO dto= new InformacionPorPersonalDTO();
        dto.setListaInformacionPorPersonal(getVerInformacionDePersonalDAO().informacionPorPersonal(cod_empleadoid));
        return dto;
        
    }

    
}
