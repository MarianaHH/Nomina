/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.negocio;

import com.googlecode.genericdao.dao.hibernate.GenericDAOImpl;
import com.googlecode.genericdao.search.ExampleOptions;
import com.googlecode.genericdao.search.Filter;
import com.googlecode.genericdao.search.ISearch;
import com.googlecode.genericdao.search.SearchResult;
import com.mbn.sinod.model.dao.PuestosDAO;
import com.mbn.sinod.model.entidades.Tsgrhpuestos;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;


@Transactional(readOnly = true)
public class PuestosServiceImpl extends GenericDAOImpl<Tsgrhpuestos, Integer> implements PuestosService {
    
    @Autowired
    private PuestosDAO puestosDAO;

    @Override
    public List<Tsgrhpuestos> listaPuestos() {
        return puestosDAO.listaPuestos();
    }

    @Override
    public Tsgrhpuestos obtenerPuestosPorId(Integer puestosId) {
        return this.puestosDAO.obtenerPuestospoId(puestosId);
    }

    /**
     * @return the puestosDAO
     */
    public PuestosDAO getPuestosDAO() {
        return puestosDAO;
    }

    /**
     * @param puestosDAO the puestosDAO to set
     */
    public void setPuestosDAO(PuestosDAO puestosDAO) {
        this.puestosDAO = puestosDAO;
    }

}
