/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.negocio;

import com.mbn.sinod.model.dao.IncidenciasDAO;
import com.mbn.sinod.model.entidades.Tsgnomincidencia;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Karla
 */
public class IncidenciasServiceImpl extends BaseServiceImpl<Tsgnomincidencia, Integer> implements IncidenciasService{
    
    @Autowired
    private IncidenciasDAO incidenciasDAO;
    
    @Override
    public List<Tsgnomincidencia> listarIncidencias() {
        return getIncidenciasDAO().listarIncidencias();
    }
    
    //Get y Set del IncidenciasDAO
    public IncidenciasDAO getIncidenciasDAO() {
        return incidenciasDAO;
    }

    public void setIncidenciasDAO(IncidenciasDAO incidenciasDAO) {
        this.incidenciasDAO = incidenciasDAO;
    }
    
}
