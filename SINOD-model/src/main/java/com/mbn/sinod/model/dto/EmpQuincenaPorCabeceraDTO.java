/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mbn.sinod.model.entidades.Tsgnomcncptoquinc;
import java.util.List;

/**
 *
 * @author Ambro
 */
public class EmpQuincenaPorCabeceraDTO extends GenericDTO {
    private Integer idemp_nom; 
    private Integer idemp_quincena;
    private String nombre;
    private String puesto;
    private String area;
    private List<EmpQuincenaPorCabeceraDTO> listaEmpQuincenaPorCabeceraDTO;
    
    private List<Tsgnomcncptoquinc> conceptosPercepcionesEmpleado;
    private List<Tsgnomcncptoquinc> conceptosDeduccionEmpleado;

    /**
     * @return the idemp_nom
     */
    public Integer getIdemp_nom() {
        return idemp_nom;
    }

    /**
     * @param idemp_nom the idemp_nom to set
     */
    public void setIdemp_nom(Integer idemp_nom) {
        this.idemp_nom = idemp_nom;
    }

    /**
     * @return the idemp_quincena
     */
    public Integer getIdemp_quincena() {
        return idemp_quincena;
    }

    /**
     * @param idemp_quincena the idemp_quincena to set
     */
    public void setIdemp_quincena(Integer idemp_quincena) {
        this.idemp_quincena = idemp_quincena;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the puesto
     */
    public String getPuesto() {
        return puesto;
    }

    /**
     * @param puesto the puesto to set
     */
    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    /**
     * @return the area
     */
    public String getArea() {
        return area;
    }

    /**
     * @param area the area to set
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     * @return the listaEmpQuincenaPorCabeceraDTO
     */
    public List<EmpQuincenaPorCabeceraDTO> getListaEmpQuincenaPorCabeceraDTO() {
        return listaEmpQuincenaPorCabeceraDTO;
    }

    /**
     * @param listaEmpQuincenaPorCabeceraDTO the listaEmpQuincenaPorCabeceraDTO to set
     */
    public void setListaEmpQuincenaPorCabeceraDTO(List<EmpQuincenaPorCabeceraDTO> listaEmpQuincenaPorCabeceraDTO) {
        this.listaEmpQuincenaPorCabeceraDTO = listaEmpQuincenaPorCabeceraDTO;
    }

    /**
     * @return the conceptosPercepcionesEmpleado
     */
    @JsonIgnore
    public List<Tsgnomcncptoquinc> getConceptosPercepcionesEmpleado() {
        return conceptosPercepcionesEmpleado;
    }

    /**
     * @param conceptosPercepcionesEmpleado the conceptosPercepcionesEmpleado to set
     */
    public void setConceptosPercepcionesEmpleado(List<Tsgnomcncptoquinc> conceptosPercepcionesEmpleado) {
        this.conceptosPercepcionesEmpleado = conceptosPercepcionesEmpleado;
    }

    /**
     * @return the conceptosDeduccionEmpleado
     */
    @JsonIgnore
    public List<Tsgnomcncptoquinc> getConceptosDeduccionEmpleado() {
        return conceptosDeduccionEmpleado;
    }

    /**
     * @param conceptosDeduccionEmpleado the conceptosDeduccionEmpleado to set
     */
    public void setConceptosDeduccionEmpleado(List<Tsgnomcncptoquinc> conceptosDeduccionEmpleado) {
        this.conceptosDeduccionEmpleado = conceptosDeduccionEmpleado;
    }
}
