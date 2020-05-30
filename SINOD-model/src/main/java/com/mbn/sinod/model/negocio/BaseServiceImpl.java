package com.mbn.sinod.model.negocio;

import com.googlecode.genericdao.dao.hibernate.GenericDAO;
import java.io.Serializable;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;

/**
 *Clase que implemente los metodo de genericDAO
 * 
 * @author Francisco R M, MBN
 * @param <T> Clase de entidad a manejar por el Servicio
 * @param <ID> Tipo de dato del identificador de la entidad a manejar por el servicio
 */
@Transactional(readOnly = true)
public class BaseServiceImpl<T extends Object, ID extends Serializable> {
    private GenericDAO<T,ID> genericDAO;
    protected Class<T> persistentClass;
    
    public List<T> findAll(){
        return genericDAO.findAll();
    }
    
    public T find(ID id){
        return (T)genericDAO.find(id);
    }
    @Transactional(readOnly = false)
    public boolean save(T t){
        return genericDAO.save(t);
    }
    @Transactional(readOnly = false)
    public boolean remove(T t){
        return genericDAO.remove(t);
    }

    /**
     * @return the genericDAO
     */
    public GenericDAO<T,ID> getGenericDAO() {
        return genericDAO;
    }

    /**
     * @param genericDAO the genericDAO to set
     */
    public void setGenericDAO(GenericDAO<T,ID> genericDAO) {
        this.genericDAO = genericDAO;
    }
    
    
}
