/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.negocio;

import com.mbn.sinod.model.dao.DetalleEmpDAO;
import com.mbn.sinod.model.dto.EmpDTO;
import com.mbn.sinod.model.entidades.Tsgrhempleados;
import org.springframework.beans.factory.annotation.Autowired;


public class DetalleEmpServiceImpl extends BaseServiceImpl<Tsgrhempleados, Integer> 
        implements DetalleEmpService {

    @Autowired
    private DetalleEmpDAO detalleEmpDAO;
    
    @Override
    public EmpDTO empDTO(Integer cabecera) {
        EmpDTO dto = new EmpDTO();
        dto.setListaEmp(getDetalleEmpDAO().empleadosPorArea(cabecera));
        System.out.println("SErvice EMP va bien ");
        return dto;
       
    }
    
    /**
     * @return the detalleEmpDAO
     */
    public DetalleEmpDAO getDetalleEmpDAO() {
        return detalleEmpDAO;
    }

    /**
     * @param detalleEmpDAO the detalleEmpDAO to set
     */
    public void setDetalleEmpDAO(DetalleEmpDAO detalleEmpDAO) {
        this.detalleEmpDAO = detalleEmpDAO;
    }
}
