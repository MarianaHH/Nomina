package com.mbn.sinod.model.dao;

import com.googlecode.genericdao.dao.hibernate.GenericDAOImpl;
import com.googlecode.genericdao.search.Search;
import com.mbn.sinod.model.entidades.Tsgrhareas;
import java.util.List;

/**
 * Clase DAO que implementa TODOS los métodos de operaciones a base de datos.
 * Cualquier operación que se dese realizar a la base de datos debe estar
 * implementada en esta clase.
 *
 * @author Francisco R M, MBN
 * @version 2.0
 * 
 */
public class AreasDAOImpl extends GenericDAOImpl<Tsgrhareas, Integer> implements AreasDAO {
    
   @Override
   public List<Tsgrhareas>listaAreas(){
       return findAll();
   }
   
    @Override
    public Tsgrhareas obtenerAreasPorId(Integer areasId) {
        Search search = new Search();
        search.addFilterEqual("codArea", areasId);
        return searchUnique( search );
    }
}
