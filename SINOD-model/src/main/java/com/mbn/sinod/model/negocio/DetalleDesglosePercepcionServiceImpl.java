/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.negocio;

import com.ibm.wsdl.ServiceImpl;
import com.mbn.sinod.model.dto.DetalleDesgloPercepDTO;
import com.mbn.sinod.model.entidades.Tsgnomcncptoquinc;
import org.springframework.beans.factory.annotation.Autowired;
import com.mbn.sinod.model.dao.DetalleDesglosePercepcionDAO;
import com.mbn.sinod.model.dto.DetalleDesglosePercepcionDTO;
import java.util.List;
import java.util.logging.Logger;


public class DetalleDesglosePercepcionServiceImpl extends BaseServiceImpl<Tsgnomcncptoquinc, Integer>
        implements DetalleDesglosePercepcionService {
    
    
    @Autowired
    private DetalleDesglosePercepcionDAO detalleDesglosePercepcionDAO;

    @Override
    public DetalleDesgloPercepDTO detalleDesglocePercepDTO(Integer cod_empleado, Integer cod_cabecera) {
        DetalleDesgloPercepDTO dto = new DetalleDesgloPercepDTO();
        dto.setGetListaPercepcion(getDetalleDesglosePercepcionDAO().percepcionesPosEmp(cod_empleado, cod_cabecera));
        return dto;
    }

    /**
     * @return the detalleDesglosePercepcionDAO
     */
    public DetalleDesglosePercepcionDAO getDetalleDesglosePercepcionDAO() {
        return detalleDesglosePercepcionDAO;
    }

    /**
     * @param detalleDesglosePercepcionDAO the detalleDesglosePercepcionDAO to set
     */
    public void setDetalleDesglosePercepcionDAO(DetalleDesglosePercepcionDAO detalleDesglosePercepcionDAO) {
        this.detalleDesglosePercepcionDAO = detalleDesglosePercepcionDAO;
    }
}
