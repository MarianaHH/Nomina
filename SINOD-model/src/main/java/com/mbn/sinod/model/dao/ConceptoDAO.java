/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.dao;

import com.googlecode.genericdao.dao.hibernate.GenericDAO;
import com.mbn.sinod.model.entidades.Tsgnomconcepto;
import java.util.List;

/**
 *
 * @author ambrosio
 */
public interface ConceptoDAO  extends GenericDAO<Tsgnomconcepto, Integer>{
    List<Tsgnomconcepto> listarConcepto();
    List<Tsgnomconcepto> listarConceptosPercepcion();
    List<Tsgnomconcepto> listarConceptosDeduccion();
    boolean eliminarConcepto(Integer id);
    boolean guardarConcepto(Tsgnomconcepto concepto);
    boolean guardarPrioridad(List<Tsgnomconcepto> concepto);
    
}
