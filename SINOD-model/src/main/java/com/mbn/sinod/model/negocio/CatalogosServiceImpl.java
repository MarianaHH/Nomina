package com.mbn.sinod.model.negocio;

import org.springframework.transaction.annotation.Transactional;
import com.mbn.sinod.model.dto.CatalogosDTO;
import com.mbn.sinod.model.dao.CatalogosDAO;

/**
 * Clase que permite obtener la información de todos los catálogos
 *
 * @author Francisco R M, MBN
 */
public class CatalogosServiceImpl implements CatalogosService {

    private CatalogosDAO catalogosDAO;

    /**
     * Método que obtiene la información de cualquer catálogo
     *
     * @param dto
     * @return
     */
    @Override
    @Transactional
    public CatalogosDTO obtenerCatalogo(CatalogosDTO dto) {
        //Ejemplo de declaracion de un catalogo para este metodo
        // En este metodo se colocan todos los catalogos de del sistema
        /*if (dto.getClazz().getName().equalsIgnoreCase(Tsgrtestados.class.getName())) {
            dto.setCatEstados(catalogosDAO.obtenerCatalogo(dto.getClazz()));
        }*/
        return dto;
    }

    /**
     * @return the catalogosDAO
     */
    public CatalogosDAO getCatalogosDAO() {
        return catalogosDAO;
    }

    /**
     * @param catalogosDAO the catalogosDAO to set
     */
    public void setCatalogosDAO(CatalogosDAO catalogosDAO) {
        this.catalogosDAO = catalogosDAO;
    }

}
