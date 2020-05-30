
package com.mbn.sinod.model.negocio;

import com.mbn.sinod.model.dao.EmpleadoDAO;
import com.mbn.sinod.model.entidades.Tsgrhempleados;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * Clase que implementa las operaciones de negocio 
 * 
 * @author Francisco R M, MBN
 * @version 2.0
 * @since 15/12/2017
 */
@Transactional(readOnly = true)
public class EmpleadoServiceImpl extends BaseServiceImpl<Tsgrhempleados, Integer> implements EmpleadoService {
    
    @Autowired
    private EmpleadoDAO empleadoDAO;
    
    @Override
    public List<Tsgrhempleados> listaEmpleados() {
        return this.empleadoDAO.listarEmpleados();
    }

    @Override
    public Tsgrhempleados obtenerEmpleadoPorId(Integer empleadoId) {
        return this.empleadoDAO.obtenerEmpleadoPorId(empleadoId);
    }

    /**
     * @return the empleadoDAO
     */
    public EmpleadoDAO getEmpleadoDAO() {
        return empleadoDAO;
    }

    /**
     * @param empleadoDAO the empleadoDAO to set
     */
    public void setEmpleadoDAO(EmpleadoDAO empleadoDAO) {
        this.empleadoDAO = empleadoDAO;
    }
    
}
