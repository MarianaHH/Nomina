/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.dao;

import com.googlecode.genericdao.dao.hibernate.GenericDAOImpl;
import com.googlecode.genericdao.search.ExampleOptions;
import com.googlecode.genericdao.search.Filter;
import com.googlecode.genericdao.search.ISearch;
import com.googlecode.genericdao.search.Search;
import com.googlecode.genericdao.search.SearchResult;
import com.mbn.sinod.model.entidades.Tsgrhpuestos;
import java.util.List;


public class PuestosDAOImpl extends GenericDAOImpl<Tsgrhpuestos, Integer> implements PuestosDAO {

    @Override
    public List<Tsgrhpuestos> listaPuestos() {
        return findAll();
    }

    @Override
    public Tsgrhpuestos obtenerPuestospoId(Integer puestosId) {
        Search search = new Search();
        search.addFilterEqual("codPuesto", puestosId);
        return searchUnique( search );
    }

}
