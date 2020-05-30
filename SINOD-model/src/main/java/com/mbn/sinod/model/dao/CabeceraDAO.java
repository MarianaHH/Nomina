/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.dao;

import com.googlecode.genericdao.dao.hibernate.GenericDAO;
import com.mbn.sinod.model.dto.EmpQuincenaPorCabeceraDTO;
import com.mbn.sinod.model.entidades.Tsgnomcabecera;
import java.util.List;

/**
 *
 * @author Mi Pe
 */
public interface CabeceraDAO extends GenericDAO<Tsgnomcabecera, Integer>{

    /**
     * crea la nomina atra vez de una funcion la cual nos retorna un true si se creo o un false en caso de no
     * @param cabecera
     * @return
     */
    Integer guardarAtualizarCabecera(Tsgnomcabecera cabecera);

    /**
     *
     * @return
     */
    List<Tsgnomcabecera> listarCabeceras();

    /**
     *
     * @param cabeceraId
     * @return
     */
    Tsgnomcabecera obtenerCabeceraPorId (Integer cabeceraId);

    /**
     * 
     * @param cabeceraId
     * @return
     */
    Boolean calculaNomina(Integer cabeceraId);

    /**
     *
     * @param cabeceraId
     * @return
     */
    List<EmpQuincenaPorCabeceraDTO> listarEmpleadosCabecera(Integer cabeceraId);

    /**
     *
     * @param id
     * @return
     */
    boolean eliminarCabecera(Integer id);

    /**
     *
     * @param cabecera
     * @return
     */
    Boolean validaPagosNomina(Integer cabecera); 
    
    /**
     *
     * @param archivo
     * @param cabecera
     * @return
     */
    Boolean cargarImss(String archivo, Integer cabecera);
}
