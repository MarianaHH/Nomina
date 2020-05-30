/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.dao;

import com.googlecode.genericdao.dao.hibernate.GenericDAOImpl;
import com.googlecode.genericdao.search.Search;
import com.mbn.sinod.model.dto.EmpQuincenaPorCabeceraDTO;
import com.mbn.sinod.model.entidades.Tsgnomcabecera;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;

public class CabeceraDAOImpl extends GenericDAOImpl<Tsgnomcabecera, Integer> implements CabeceraDAO {

    @Override
    public Integer guardarAtualizarCabecera(Tsgnomcabecera cabecera) {
        Query query = getSession().createSQLQuery("SELECT * "
                + "FROM sgnom.fn_insertacabecera(?, ?, ?, ?)")
                .setInteger(0, cabecera.getCodQuincenaidFk().getCodQuincenaid())
                .setInteger(1, cabecera.getCodTiponominaidFk().getCodTiponominaid())
                .setString(2, cabecera.getCodNbnomina())
                .setInteger(3, cabecera.getAudCodcreadopor());
        return Integer.parseInt(query.uniqueResult().toString());
    }

    @Override
    public List<Tsgnomcabecera> listarCabeceras() {
        List<Tsgnomcabecera> cabecera = (List<Tsgnomcabecera>) getSession().createQuery("FROM Tsgnomcabecera "
                + "WHERE codEstatusnomidFk != 6 "
                + "ORDER BY fec_creacion DESC")
                .list();
        return cabecera;
    }

    @Override
    public Tsgnomcabecera obtenerCabeceraPorId(Integer cabeceraId) {
        Search search = new Search();
        search.addFilterEqual("codCabeceraid", cabeceraId);
        return searchUnique(search);
    }

    @Override
    public Boolean calculaNomina(Integer cabeceraId) {
        Query query = getSession().createSQLQuery("SELECT * "
                + "FROM sgnom.fn_calcula_nomina(?)")
                .setInteger(0, cabeceraId);
        return (Boolean) query.uniqueResult().equals(1);
    }

    @Override
    public List<EmpQuincenaPorCabeceraDTO> listarEmpleadosCabecera(Integer cabeceraId) {
        List<EmpQuincenaPorCabeceraDTO> empleadosCabecera = (List<EmpQuincenaPorCabeceraDTO>) getSession().createSQLQuery("SELECT * FROM sgnom.fn_empleadosQuincena(?);")
                .addScalar("idemp_nom")
                .addScalar("idemp_quincena")
                .addScalar("nombre")
                .addScalar("puesto")
                .addScalar("area")
                .setResultTransformer(Transformers.aliasToBean(EmpQuincenaPorCabeceraDTO.class))
                .setInteger(0, cabeceraId)
                .list();
        return empleadosCabecera;
    }

    @Override
    public boolean eliminarCabecera(Integer id) {
        try {
            Query sql = getSession().createSQLQuery("UPDATE sgnom.tsgnomcabecera "
                    + "SET cod_estatusnomid_fk = 6 "
                    + "WHERE cod_cabeceraid = :cabeceraId");
            sql.setParameter("cabeceraId", id);

            if (sql.executeUpdate() > 0) {
                return true;
            }
        } catch (Exception e) {
            Logger.getLogger(CabeceraDAOImpl.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }

        return false;
    }

    @Override
    public Boolean validaPagosNomina(Integer cabecera) {
        Query query = getSession().createSQLQuery("SELECT * FROM sgnom.fn_validapagosnomina(?)")
                .setInteger(0, cabecera);
        return (Boolean) query.uniqueResult();
    }

    @Override
    public Boolean cargarImss(String archivo, Integer cabecera) {
        Query query = getSession().createSQLQuery("SELECT * FROM sgnom.fn_cargar_nom_imss(?, ?)")
                .setString(0, archivo)
                .setInteger(1, cabecera);
        return (Boolean) query.uniqueResult();
    }
}
