/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.negocio;

import com.mbn.sinod.model.dao.DetalleEmpleadosDAO;
import com.mbn.sinod.model.dto.InformacionEmpleadosDTO;
import com.mbn.sinod.model.entidades.Tsgrhempleados;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Ivette
 */
public class DetalleEmpleadosServiceImpl extends BaseServiceImpl<Tsgrhempleados,Integer>
implements  DetalleEmpleadosService{
    
    @Autowired 
    private DetalleEmpleadosDAO detalleEmpleadosDAO;

    @Override
    public InformacionEmpleadosDTO detallesEmpleados() {
         InformacionEmpleadosDTO dto= new  InformacionEmpleadosDTO();
         dto.setListaInformacionEmpleados(getDetalleEmpleadosDAO().detallesEmpleados());
         return dto;
    }
    
    @Override
    public InformacionEmpleadosDTO empleadosPorArea(Integer area) {
         InformacionEmpleadosDTO dto = new  InformacionEmpleadosDTO();
         dto.setListaInformacionEmpleados(getDetalleEmpleadosDAO().empleadosPorArea(area));
         return dto;
    }

    public DetalleEmpleadosDAO getDetalleEmpleadosDAO() {
        return detalleEmpleadosDAO;
    }

    public void setDetalleEmpleadosDAO(DetalleEmpleadosDAO detalleEmpleadosDAO) {
        this.detalleEmpleadosDAO = detalleEmpleadosDAO;
    }


    
}
