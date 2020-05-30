package com.mbn.sinod.model.dao;

import com.googlecode.genericdao.dao.hibernate.GenericDAOImpl;
import com.googlecode.genericdao.search.Search;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Clase en la que se de claran los direntes métodos genéricos para catálogos
 *
 * @author Francisco R M, MBN
 */
public class CatalogosDAOImpl extends GenericDAOImpl implements CatalogosDAO {

    private static final Logger logger = Logger.getLogger(CatalogosDAOImpl.class.getName());

    /**
     * Método que obtiene la información de un catálogo
     *
     * @param clazz
     * @return
     */
    @Override
    public List obtenerCatalogo(Class clazz) {
        try {
            logger.info("Buscando catálogo de: ----------------->" + clazz);
            persistentClass = Class.forName(clazz.getName());
            Search sql = new Search();
            return search(sql);
        } catch (ClassNotFoundException ex) {
            logger.log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
