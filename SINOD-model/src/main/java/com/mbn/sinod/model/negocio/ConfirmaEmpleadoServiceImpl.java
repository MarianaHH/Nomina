/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.negocio;

import com.mbn.sinod.model.dao.ConfirmaEmpleadoDAO;
import com.mbn.sinod.model.dto.DetalleEmpDTO;
import com.mbn.sinod.model.dto.EmpDTO;
import com.mbn.sinod.model.entidades.Tsgnomconfpago;
import java.io.Serializable;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;


public class ConfirmaEmpleadoServiceImpl extends BaseServiceImpl<Tsgnomconfpago, Integer> 
        implements ConfirmaEmpleadoService {
    
    @Autowired
    private ConfirmaEmpleadoDAO confirmaEmpleadoDAO;
    
    @Override
    public EmpDTO empDTO(Integer cabecera, Integer empleado) {
        EmpDTO dto = new EmpDTO();
        dto.setListaEmp(getConfirmaEmpleadoDAO().ConfiPAgo(cabecera, empleado));
        //System.err.println("ServiceEMP");
        return dto;
    }
//  public DetalleDesgloPercepDTO detalleDesglocePercepDTO(Integer cod_empleado, Integer cod_cabecera) {
//    DetalleDesgloPercepDTO dto = new DetalleDesgloPercepDTO();
//        dto.setGetListaPercepcion(getDetalleDesglosePercepcionDAO().percepcionesPosEmp(cod_empleado, cod_cabecera));
//        return dto;

    /**
     * @return the confirmaEmpleadoDAO
     */
    public ConfirmaEmpleadoDAO getConfirmaEmpleadoDAO() {
        return confirmaEmpleadoDAO;
    }

    /**
     * @param confirmaEmpleadoDAO the confirmaEmpleadoDAO to set
     */
    public void setConfirmaEmpleadoDAO(ConfirmaEmpleadoDAO confirmaEmpleadoDAO) {
        this.confirmaEmpleadoDAO = confirmaEmpleadoDAO;
    }
}
