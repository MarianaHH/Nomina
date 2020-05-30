
package com.mbn.sinod.model.negocio;

import com.mbn.sinod.model.entidades.Tsgrhempleados;
import java.util.List;

/**
 * Interfaz que encapsula las operaciones de negocio
 * 
 * @author Francisco R M, MBN
 * @version 2.0
 * @since 15/12/2017
 */
public interface EmpleadoService extends BaseService<Tsgrhempleados, Integer> {
    
    List<Tsgrhempleados> listaEmpleados();
    Tsgrhempleados obtenerEmpleadoPorId( Integer empleadoId );
    
}
