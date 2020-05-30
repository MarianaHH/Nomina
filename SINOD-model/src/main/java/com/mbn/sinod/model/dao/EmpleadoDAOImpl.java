package com.mbn.sinod.model.dao;

import com.googlecode.genericdao.dao.hibernate.GenericDAOImpl;
import com.googlecode.genericdao.search.Search;
import com.mbn.sinod.model.entidades.Tsgrhempleados;
import java.util.List;

/**
 * Clase DAO que implementa TODOS los métodos de operaciones a base de datos.
 * Cualquier operación que se dese realizar a la base de datos debe estar
 * implementada en esta clase.
 *
 * @author Francisco R M, MBN
 * @version 2.0
 * @since 15/12/2017
 */
public class EmpleadoDAOImpl extends GenericDAOImpl<Tsgrhempleados, Integer> implements EmpleadoDAO {

    @Override
    public boolean guardarEmpleado(Tsgrhempleados empleado) {
        return save(empleado);
    }

    @Override
    public void actualizarEmpleado(Tsgrhempleados empleado) {
        _saveOrUpdate(empleado);
    }

    @Override
    public List<Tsgrhempleados> listarEmpleados() {
        return findAll();
    }

    @Override
    public Tsgrhempleados obtenerEmpleadoPorId(Integer empleadoId) {
        Search search = new Search();
        search.addFilterEqual("codEmpleado", empleadoId);
        return searchUnique( search );
    }
}
