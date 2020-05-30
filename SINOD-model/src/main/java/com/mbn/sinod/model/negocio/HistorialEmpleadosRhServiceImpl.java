/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.negocio;

import com.mbn.sinod.model.dao.HistorialEmpleadosRhDAO;
import com.mbn.sinod.model.dto.InfoHistorialRhDTO;
import com.mbn.sinod.model.entidades.Tsgrhempleados;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Ivette
 */
public class HistorialEmpleadosRhServiceImpl extends BaseServiceImpl<Tsgrhempleados,Integer>
implements  HistorialEmpleadosRhService {
    
    @Autowired 
    private HistorialEmpleadosRhDAO historialEmpleadosRhDAO;

    public HistorialEmpleadosRhDAO getHistorialEmpleadosRhDAO() {
        return historialEmpleadosRhDAO;
    }

    public void setHistorialEmpleadosRhDAO(HistorialEmpleadosRhDAO historialEmpleadosRhDAO) {
        this.historialEmpleadosRhDAO = historialEmpleadosRhDAO;
    }

    @Override
    public InfoHistorialRhDTO detallesHistorialRh() {
        
        InfoHistorialRhDTO dto = new InfoHistorialRhDTO();
        dto.setListaHistorialEmpleadosRh( getHistorialEmpleadosRhDAO().detallesHistorialRh());
        return dto;
    }

    @Override
    public InfoHistorialRhDTO informacionPersonal(Integer cod_empleadoid) {
        
        InfoHistorialRhDTO dto = new InfoHistorialRhDTO();
        dto.setListaHistorialEmpleadosRh(getHistorialEmpleadosRhDAO().informacionEmpleado(cod_empleadoid));
        return dto;
    }
    
}
