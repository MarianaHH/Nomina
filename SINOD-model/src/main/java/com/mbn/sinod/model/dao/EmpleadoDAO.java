
package com.mbn.sinod.model.dao;

import com.googlecode.genericdao.dao.hibernate.GenericDAO;
import com.mbn.sinod.model.entidades.Tsgrhempleados;
import java.util.List;

/**
 * Interfaz DAO que declara TODOS los métodos de operaciones a base de datos.
 * Cualquier operación que se dese realizar a la base de datos debe estar
 * declarada en esta Interfaz.
 *
 * @author Francisco R M, MBN
 * @version 2.0
 * @since 15/12/2017
 */
public interface EmpleadoDAO extends GenericDAO<Tsgrhempleados, Integer> {
    
    boolean guardarEmpleado( Tsgrhempleados empleado );
    void actualizarEmpleado( Tsgrhempleados empleado );
    List<Tsgrhempleados> listarEmpleados();
    Tsgrhempleados obtenerEmpleadoPorId( Integer empleadoId );
}
