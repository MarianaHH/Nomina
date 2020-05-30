
package com.mbn.sinod.model.dao;

import com.googlecode.genericdao.dao.hibernate.GenericDAO;
import com.mbn.sinod.model.entidades.Tsgrhareas;
import java.util.List;

/**
 * Interfaz DAO que declara TODOS los métodos de operaciones a base de datos.
 * Cualquier operación que se dese realizar a la base de datos debe estar
 * declarada en esta Interfaz.
 *
 * @author Francisco R M, MBN
 * @version 2.0
 * 
 */
public interface AreasDAO extends GenericDAO<Tsgrhareas, Integer> {
    List<Tsgrhareas>listaAreas();
    Tsgrhareas obtenerAreasPorId(Integer areasId);
}
