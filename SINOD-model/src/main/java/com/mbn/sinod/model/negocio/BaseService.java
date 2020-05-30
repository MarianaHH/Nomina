package com.mbn.sinod.model.negocio;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Jony
 * @param <T> Clase de entidad a manejar por el Servicio
 * @param <ID> Tipo de dato del identificador de la entidad a manejar por el servicio
 */
public interface BaseService<T extends Object, ID extends Serializable>{
    List<T> findAll();
    
    public T find(ID id);
    
    public boolean save(T t);
    
    public boolean remove(T t);
}
