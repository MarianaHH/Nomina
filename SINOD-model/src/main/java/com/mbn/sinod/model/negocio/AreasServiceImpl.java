
package com.mbn.sinod.model.negocio;

import com.mbn.sinod.model.dao.AreasDAO;
import com.mbn.sinod.model.entidades.Tsgrhareas;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 * Clase que implementa las operaciones de negocio 
 * 
 * @author Francisco R M, MBN
 * @version 2.0
 * 
 */
@Transactional(readOnly = true)
public class AreasServiceImpl extends BaseServiceImpl<Tsgrhareas, Integer> implements AreasService {

    @Autowired
    private AreasDAO areasDAO;
    
    @Override
    public List<Tsgrhareas> listaAreas() {
        return areasDAO.listaAreas();
    }
    
    
    @Override
    public Tsgrhareas obtenerAreasPorId(Integer areasId) {
        return this.areasDAO.obtenerAreasPorId(areasId);
    }

    /**
     * @return the areasDAO
     */
    public AreasDAO getAreasDAO() {
        return areasDAO;
    }

    /**
     * @param areasDAO the areasDAO to set
     */
    public void setAreasDAO(AreasDAO areasDAO) {
        this.areasDAO = areasDAO;
    }
      
}
