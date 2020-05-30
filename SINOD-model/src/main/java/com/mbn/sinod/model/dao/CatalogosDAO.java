package com.mbn.sinod.model.dao;

import com.googlecode.genericdao.dao.hibernate.GenericDAO;
import java.util.List;

/**
 *
 * @author Francisco R M, MBN
 */
public interface CatalogosDAO extends GenericDAO{
    List obtenerCatalogo(Class clazz);
}
