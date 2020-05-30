package com.mbn.sinod.model.negocio;

import com.mbn.sinod.model.entidades.Tsgrhareas;
import java.util.List;

/**
 * Interfaz que encapsula las operaciones de negocio
 * 
 * @author Francisco R M, MBN
 * @version 2.0
 * 
 */
public interface AreasService extends BaseService<Tsgrhareas, Integer> {
    List<Tsgrhareas>listaAreas();
    Tsgrhareas obtenerAreasPorId(Integer areasId);
}
