
package com.mbn.sinod.model.dto;

import com.mbn.sinod.model.entidades.Tsgrhempleados;
import java.util.List;

/**
 * Clase DTO genérica que encapsula los datos enviados a través de los WS
 * 
 * @author Francisco R M, MBN
 * @version 2.0
 * @since 15/12/2017
 */
public class EmpleadoDTO extends GenericDTO {
    
    private Class clazz;
    private Tsgrhempleados empleado;
    private List<Tsgrhempleados> listaEmpleados;

    /**
     * @return the clazz
     */
    public Class getClazz() {
        return clazz;
    }

    /**
     * @param clazz the clazz to set
     */
    public void setClazz(Class clazz) {
        this.clazz = clazz;
    }

    /**
     * @return the empleado
     */
    public Tsgrhempleados getEmpleado() {
        return empleado;
    }

    /**
     * @param empleado the empleado to set
     */
    public void setEmpleado(Tsgrhempleados empleado) {
        this.empleado = empleado;
    }

    /**
     * @return the listaEmpleados
     */
    public List<Tsgrhempleados> getListaEmpleados() {
        return listaEmpleados;
    }

    /**
     * @param listaEmpleados the listaEmpleados to set
     */
    public void setListaEmpleados(List<Tsgrhempleados> listaEmpleados) {
        this.listaEmpleados = listaEmpleados;
    }
    
}
