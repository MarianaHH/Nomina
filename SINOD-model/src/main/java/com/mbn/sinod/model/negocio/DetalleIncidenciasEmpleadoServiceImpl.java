/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.negocio;

import com.mbn.sinod.model.dao.DetalleIncidenciasEmpleadoDAO;
import com.mbn.sinod.model.dto.IncidenciasDTO;
import com.mbn.sinod.model.dto.IncidenciasPorEmpleadoDTO;
import com.mbn.sinod.model.entidades.Tsgnomincidencia;
import java.math.BigDecimal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Karla
 */
public class DetalleIncidenciasEmpleadoServiceImpl extends BaseServiceImpl<Tsgnomincidencia, Integer> 
    implements DetalleIncidenciasEmpleadoService{

    @Autowired
    private DetalleIncidenciasEmpleadoDAO detalleIncidenciasEmpleadoDAO;
    
    @Override
    public IncidenciasPorEmpleadoDTO incidenciasPorEmpleado(int reporta) {
        IncidenciasPorEmpleadoDTO dto = new IncidenciasPorEmpleadoDTO();
        dto.setListaIncidenciasEmpleado(getDetalleIncidenciasEmpleadoDAO().incidenciasPorEmpleado(reporta));
        return dto;
    }
    
    @Override
    public IncidenciasPorEmpleadoDTO incidenciasPorQuincena(int quincena) {
        IncidenciasPorEmpleadoDTO dto = new IncidenciasPorEmpleadoDTO();
        dto.setListaIncidenciasEmpleado(getDetalleIncidenciasEmpleadoDAO().incidenciasPorQuincena(quincena));
        return dto;
    }
    
    @Override
    public IncidenciasPorEmpleadoDTO incidenciasPorEmpleadoQuincena(int reporta, int quincena) {
        IncidenciasPorEmpleadoDTO dto = new IncidenciasPorEmpleadoDTO();
        dto.setListaIncidenciasEmpleado(getDetalleIncidenciasEmpleadoDAO().incidenciasPorEmpleadoQuincena(reporta, quincena));
        return dto;
    }
    
    @Override
    public IncidenciasPorEmpleadoDTO incidenciasPorQuincenaArea(int quincena, int area) {
        IncidenciasPorEmpleadoDTO dto = new IncidenciasPorEmpleadoDTO();
        dto.setListaIncidenciasEmpleado(getDetalleIncidenciasEmpleadoDAO().incidenciasPorQuincenaArea(quincena, area));
        return dto;
    }

    @Transactional(readOnly = false)
    @Override
    public boolean eliminarIncidenciaEmpleado(Integer incidenciaid, Integer reporta) {
        return getDetalleIncidenciasEmpleadoDAO().eliminarIncidenciaEmpleado(incidenciaid, reporta);
    }

    @Transactional(readOnly = false)
    @Override
    public boolean actualizarComentariosIncidencia(Integer incidenciaid, String comentarios, Integer reporta) {
        return getDetalleIncidenciasEmpleadoDAO().actualizarComentariosIncidencia(incidenciaid, comentarios, reporta);
    }

    @Transactional(readOnly = false)
    @Override
    public boolean actualizarImporteIncidencia(Integer incidenciaid, BigDecimal importe, Integer reporta) {
        return getDetalleIncidenciasEmpleadoDAO().actualizarImporteIncidencia(incidenciaid, importe, reporta);
    }
    
    @Transactional(readOnly = false)
    @Override
    public boolean actualizarIncidencia(Integer incidenciaid,String comentarios, BigDecimal importe, Integer reporta) {
        return getDetalleIncidenciasEmpleadoDAO().actualizarIncidencia(incidenciaid,comentarios, importe, reporta);
    }
    
    @Transactional(readOnly = false)
    @Override
    public boolean registrarIncidencia(IncidenciasDTO incidencia){
        return getDetalleIncidenciasEmpleadoDAO().registrarIncidencia(incidencia.getIncidencia());
    }
       
    //Get y Set del DAO detalle de incidencias por empleado
    public DetalleIncidenciasEmpleadoDAO getDetalleIncidenciasEmpleadoDAO() {
        return detalleIncidenciasEmpleadoDAO;
    }

    public void setDetalleIncidenciasEmpleadoDAO(DetalleIncidenciasEmpleadoDAO detalleIncidenciasEmpleadoDAO) {
        this.detalleIncidenciasEmpleadoDAO = detalleIncidenciasEmpleadoDAO;
    }

}
