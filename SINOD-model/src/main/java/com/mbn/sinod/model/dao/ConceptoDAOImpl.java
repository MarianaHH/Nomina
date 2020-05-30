
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.dao;

import com.googlecode.genericdao.dao.hibernate.GenericDAOImpl;
import com.mbn.sinod.model.entidades.Tsgnomconcepto;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Query;

public class ConceptoDAOImpl extends GenericDAOImpl<Tsgnomconcepto, Integer> implements ConceptoDAO {

    @Override
    public List<Tsgnomconcepto> listarConcepto() {
//        return findAll();
        List<Tsgnomconcepto> conceptos = (List<Tsgnomconcepto>) getSession().createQuery("FROM Tsgnomconcepto "
                + "WHERE bolEstatus = :parametro "
                + "ORDER BY codConceptoid")
                .setParameter("parametro", true).list();
        return conceptos;
    }

    @Override
    public boolean eliminarConcepto(Integer id) {
        try {
            StringBuilder sb = new StringBuilder("UPDATE sgnom.tsgnomconcepto "
                    + "SET bol_estatus = false "
                    + "WHERE cod_conceptoid = :conceptoId");
            Query sql = getSession().createSQLQuery(sb.toString());
            sql.setParameter("conceptoId", id);

            if (sql.executeUpdate() > 0) {
                return true;
            }
        } catch (Exception e) {
            Logger.getLogger(ConceptoDAOImpl.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }

        return false;
    }

    @Override
    public boolean guardarConcepto(Tsgnomconcepto concepto) {
        try {
            _saveOrUpdate(concepto);
            return true;
        } catch (Exception e) {
            Logger.getLogger(ConceptoDAOImpl.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }
    }

    @Override
    public boolean guardarPrioridad(List<Tsgnomconcepto> concepto) {
        int contador = 0;
        boolean respuesta = false;
        try {
            for (int i = 0; i < concepto.size(); i++) {
                _saveOrUpdate(concepto.get(i));
                contador++;
            }
            if (concepto.size() == contador) {
                respuesta = true;
            }
        } catch (Exception e) {
            Logger.getLogger(ConceptoDAOImpl.class.getName()).log(Level.SEVERE, null, e);
            respuesta = false;
        }
        return respuesta;
    }

    @Override
    public List<Tsgnomconcepto> listarConceptosPercepcion() {
        List<Tsgnomconcepto> conceptos
                = (List<Tsgnomconcepto>) getSession().createQuery("FROM Tsgnomconcepto AS con "
                        + "WHERE con.codTipoconceptoidFk.codTipoconceptoid = 2 "
                        + "ORDER BY con.cnuPrioricalculo")
                        .list();
        return conceptos;

    }

    @Override
    public List<Tsgnomconcepto> listarConceptosDeduccion() {
        List<Tsgnomconcepto> conceptos
                = (List<Tsgnomconcepto>) getSession().createQuery("FROM Tsgnomconcepto AS con "
                        + "WHERE con.codTipoconceptoidFk.codTipoconceptoid = 1 "
                        + "ORDER BY con.cnuPrioricalculo")
                        .list();
        return conceptos;
    }

}
