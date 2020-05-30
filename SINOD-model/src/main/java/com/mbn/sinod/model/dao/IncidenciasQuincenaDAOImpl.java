/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.dao;

import com.googlecode.genericdao.dao.hibernate.GenericDAOImpl;
import com.mbn.sinod.model.dto.IncidenciasQuincenaDTO;
import com.mbn.sinod.model.entidades.Tsgnomcatincidencia;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;

/**
 *
 * @author mariana
 */
public class IncidenciasQuincenaDAOImpl extends GenericDAOImpl<Tsgnomcatincidencia, Integer> 
        implements IncidenciasQuincenaDAO {

    @Override
    public List<IncidenciasQuincenaDTO> listarincidenciasQuincena() {
        List<IncidenciasQuincenaDTO> incidenciasQuincena = 
                (List<IncidenciasQuincenaDTO>) getSession().createSQLQuery("select * from sgnom.incidencias_quincena();")
                .addScalar("idincidencia")
                .addScalar("clave")
                .addScalar("incidencia")
                .addScalar("idtipo")
                .addScalar("desctipo")
                .addScalar("cantidad")
                .addScalar("actividad")
                .addScalar("detallefechas")
                .addScalar("comentarios")
                .addScalar("importe")
                .addScalar("reporta")
                .addScalar("autoriza")
                .addScalar("nombre")
                .addScalar("perfil")
                .addScalar("validacion")
                .addScalar("aceptacion")
                .addScalar("modifica")
                .addScalar("autpago")
                .addScalar("quincenaid")
                .addScalar("desquincena")
                .setResultTransformer(Transformers.aliasToBean(IncidenciasQuincenaDTO.class)) //especificamos que los parametros se van a transformar en un DTO que especifiquemos
                .list();

        return incidenciasQuincena;
    }

    @Override
    public boolean validarTodas(List<IncidenciasQuincenaDTO> listaIncidencias) {
        int contador = 0;
        boolean respuesta = false;

        for (int i = 0; i < listaIncidencias.size(); i++) {
            StringBuilder sb = new StringBuilder(
                    "UPDATE sgnom.tsgnomincidencia SET bol_validacion = true,"
                            + "cod_empautoriza_fk = :autoriza," //Valida RH (id en nom)
                            + "aud_codmodificadopor = :modifica, "
                            + "fec_validacion = CURRENT_DATE," 
                            + "aud_fecmodificacion = CURRENT_DATE" 
                            + " WHERE cod_incidenciaid = :id");

            Query sql = getSession().createSQLQuery(sb.toString());
            sql.setParameter("autoriza", listaIncidencias.get(i).getAutoriza());
            sql.setParameter("modifica", listaIncidencias.get(i).getModifica());
            sql.setParameter("id", listaIncidencias.get(i).getIdincidencia());
            sql.executeUpdate();

            contador++;

            if (listaIncidencias.size() == contador) {
                respuesta = true;
            }
        }

        return respuesta;
    }

    @Override
    public boolean rechazarTodas(List<IncidenciasQuincenaDTO> listaIncidencias) {
        int contador = 0;
        boolean respuesta = false;

        for (int i = 0; i < listaIncidencias.size(); i++) {
            StringBuilder sb = new StringBuilder("UPDATE sgnom.tsgnomincidencia SET bol_validacion = false,"
                    + "cod_empautoriza_fk = :autoriza," //Valida RH (id en nom)
                    + "aud_codmodificadopor = :modifica, "
                    + "fec_validacion = CURRENT_DATE," 
                    + "aud_fecmodificacion = CURRENT_DATE" 
                    + " WHERE cod_incidenciaid = :id");

            Query sql = getSession().createSQLQuery(sb.toString());
            sql.setParameter("autoriza", listaIncidencias.get(i).getAutoriza());
            sql.setParameter("modifica", listaIncidencias.get(i).getModifica());
            sql.setParameter("id", listaIncidencias.get(i).getIdincidencia());
            sql.executeUpdate();

            contador++;

            if (listaIncidencias.size() == contador) {
                respuesta = true;
            }
        }

        return respuesta;
    }

    @Override
    public boolean validarIncidencias(List<IncidenciasQuincenaDTO> listaIncidencias) {
        int contador = 0;
        boolean respuesta = false;

        for (int i = 0; i < listaIncidencias.size(); i++) {
            StringBuilder sb = new StringBuilder("UPDATE sgnom.tsgnomincidencia SET bol_validacion = :estatus,"
                    + "cod_empautoriza_fk = :autoriza," //Valida RH (id en nom)
                    + "aud_codmodificadopor = :modifica, "
                    + "fec_validacion = CURRENT_DATE," 
                    + "aud_fecmodificacion = CURRENT_DATE" 
                    + " WHERE cod_incidenciaid = :id");

            Query sql = getSession().createSQLQuery(sb.toString());
            sql.setParameter("estatus", listaIncidencias.get(i).getValidacion());
            sql.setParameter("autoriza", listaIncidencias.get(i).getAutoriza());
            sql.setParameter("modifica", listaIncidencias.get(i).getModifica());
            sql.setParameter("id", listaIncidencias.get(i).getIdincidencia());
            sql.executeUpdate();

            contador++;

            if (listaIncidencias.size() == contador) {
                respuesta = true;
            }
        }

        return respuesta;
    }

    @Override
    public boolean autorizarIncidencias(List<IncidenciasQuincenaDTO> listaIncidencias) {
        int contador = 0;
        boolean respuesta = false;

        for (int i = 0; i < listaIncidencias.size(); i++) {
            StringBuilder sb = new StringBuilder("UPDATE sgnom.tsgnomincidencia SET bol_aceptacion = :estatus, "
                            + "aud_codmodificadopor = :modifica, "
                            + "aud_fecmodificacion = CURRENT_DATE"
                            + " WHERE cod_incidenciaid = :id");

            Query sql = getSession().createSQLQuery(sb.toString());
            sql.setParameter("estatus", listaIncidencias.get(i).getAceptacion());
            sql.setParameter("modifica", listaIncidencias.get(i).getModifica());
            sql.setParameter("id", listaIncidencias.get(i).getIdincidencia());
            sql.executeUpdate();

            contador++;

            if (listaIncidencias.size() == contador) {
                respuesta = true;
            }
        }
        return respuesta;
    }

    @Override
    public boolean autorizarTodas(List<IncidenciasQuincenaDTO> listaIncidencias) {
        int contador = 0;
        boolean respuesta = false;
        for (int i = 0; i < listaIncidencias.size(); i++) {
            StringBuilder sb = new StringBuilder(
                    "UPDATE sgnom.tsgnomincidencia SET bol_aceptacion = true, "
                            + "aud_codmodificadopor = :modifica, "
                            + "aud_fecmodificacion = CURRENT_DATE" 
                            + " WHERE cod_incidenciaid = :id");
            Query sql = getSession().createSQLQuery(sb.toString());
            sql.setParameter("modifica", listaIncidencias.get(i).getModifica());
            sql.setParameter("id", listaIncidencias.get(i).getIdincidencia());
            sql.executeUpdate();
            contador++;
            if (listaIncidencias.size() == contador) {
                respuesta = true;
            }
        }
        return respuesta;
    }

    @Override
    public boolean denegarTodas(List<IncidenciasQuincenaDTO> listaIncidencias) {
        int contador = 0;
        boolean respuesta = false;
        for (int i = 0; i < listaIncidencias.size(); i++) {
            StringBuilder sb = new StringBuilder(
                    "UPDATE sgnom.tsgnomincidencia SET bol_aceptacion = false, "
                            + "aud_codmodificadopor = :modifica, "
                            + "aud_fecmodificacion = CURRENT_DATE "
                            + " WHERE cod_incidenciaid = :id");
            Query sql = getSession().createSQLQuery(sb.toString());
            sql.setParameter("modifica", listaIncidencias.get(i).getModifica());
            sql.setParameter("id", listaIncidencias.get(i).getIdincidencia());
            sql.executeUpdate();
            contador++;
            if (listaIncidencias.size() == contador) {
                respuesta = true;
            }
        }
        return respuesta;
    }

    @Override
    public List<IncidenciasQuincenaDTO> incidenciasQuincenaPorArea(int area) {
        List<IncidenciasQuincenaDTO> incidenciasQuincena = 
                (List<IncidenciasQuincenaDTO>) getSession().createSQLQuery("SELECT * FROM sgnom.incidencias_quincena() WHERE reporta IN (SELECT * FROM sgnom.empleadosnom_por_area(?));")
                .addScalar("idincidencia")
                .addScalar("clave")
                .addScalar("incidencia")
                .addScalar("idtipo")
                .addScalar("desctipo")
                .addScalar("cantidad")
                .addScalar("actividad")
                .addScalar("detallefechas")
                .addScalar("comentarios")
                .addScalar("importe")
                .addScalar("reporta")
                .addScalar("autoriza")
                .addScalar("nombre")
                .addScalar("perfil")
                .addScalar("aceptacion")
                .addScalar("validacion")
                .addScalar("modifica")
                .addScalar("autpago")
                .addScalar("quincenaid")
                .addScalar("desquincena")
                .setResultTransformer(Transformers.aliasToBean(IncidenciasQuincenaDTO.class)) //especificamos que los parametros se van a transformar en un DTO que especifiquemos
                .setInteger(0, area)
                .list();

        return incidenciasQuincena;
    }
    
    @Override
    public boolean autorizarPagosIncidencias(List<IncidenciasQuincenaDTO> listaIncidencias) {
        int contador = 0;
        boolean respuesta = false;

        for (int i = 0; i < listaIncidencias.size(); i++) {
            StringBuilder sb = new StringBuilder("UPDATE sgnom.tsgnomincidencia SET bol_pago = :estatus, "
                            + "aud_codmodificadopor = :modifica, "
                            + "aud_fecmodificacion = CURRENT_DATE"
                            + " WHERE cod_incidenciaid = :id");

            Query sql = getSession().createSQLQuery(sb.toString());
            sql.setParameter("estatus", listaIncidencias.get(i).getAutpago());
            sql.setParameter("modifica", listaIncidencias.get(i).getModifica());
            sql.setParameter("id", listaIncidencias.get(i).getIdincidencia());
            sql.executeUpdate();

            contador++;

            if (listaIncidencias.size() == contador) {
                respuesta = true;
            }
        }
        return respuesta;
    }

    @Override
    public boolean autorizarPagoIncidencias(List<IncidenciasQuincenaDTO> listaIncidencias) {
        int contador = 0;
        boolean respuesta = false;
        for (int i = 0; i < listaIncidencias.size(); i++) {
            StringBuilder sb = new StringBuilder(
                    "UPDATE sgnom.tsgnomincidencia SET bol_pago = true, "
                            + "aud_codmodificadopor = :modifica, "
                            + "aud_fecmodificacion = CURRENT_DATE" 
                            + " WHERE cod_incidenciaid = :id");
            Query sql = getSession().createSQLQuery(sb.toString());
            sql.setParameter("modifica", listaIncidencias.get(i).getModifica());
            sql.setParameter("id", listaIncidencias.get(i).getIdincidencia());
            sql.executeUpdate();
            contador++;
            if (listaIncidencias.size() == contador) {
                respuesta = true;
            }
        }
        return respuesta;
    }

    @Override
    public boolean denegarPagoIncidencias(List<IncidenciasQuincenaDTO> listaIncidencias) {
        int contador = 0;
        boolean respuesta = false;
        for (int i = 0; i < listaIncidencias.size(); i++) {
            StringBuilder sb = new StringBuilder(
                    "UPDATE sgnom.tsgnomincidencia SET bol_pago = false, "
                            + "aud_codmodificadopor = :modifica, "
                            + "aud_fecmodificacion = CURRENT_DATE "
                            + " WHERE cod_incidenciaid = :id");
            Query sql = getSession().createSQLQuery(sb.toString());
            sql.setParameter("modifica", listaIncidencias.get(i).getModifica());
            sql.setParameter("id", listaIncidencias.get(i).getIdincidencia());
            sql.executeUpdate();
            contador++;
            if (listaIncidencias.size() == contador) {
                respuesta = true;
            }
        }
        return respuesta;
    }
    
    @Override
    public boolean posponerPagoIncidencia(Integer incidenciaid, String comentarios, Integer modifica){
        Query query = getSession().createSQLQuery("SELECT * FROM sgnom.posponer_pago_incidencia(?, ?, ?)")
                .setInteger(0, incidenciaid)
                .setString(1, comentarios)
                .setInteger(2, modifica);
        return (boolean) query.uniqueResult();
    }
}
