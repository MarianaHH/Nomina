/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.dao;

import com.googlecode.genericdao.dao.hibernate.GenericDAOImpl;
import com.mbn.sinod.model.entidades.Tsgnomconfpago;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.Query;

public class ConfPagoDAOImpl extends GenericDAOImpl<Tsgnomconfpago, Integer> implements ConfPagoDAO {

    @Override
    public boolean guardarAutorizacionRF(List<Tsgnomconfpago> conf1) {
//        try {
//            StringBuilder sb = new StringBuilder("UPDATE sgnom.Tsgnomconfpago "
//                    + "SET bol_pagofinanzas = :estatus "
//                    + "WHERE cod_empquincenaid_fk = :empquincenaid");
//            Query sql = getSession().createSQLQuery(sb.toString());
//            sql.setParameter("estatus", conf1.getBolPagofinanzas());
//            sql.setParameter("empquincenaid", conf1.getCodEmpquincenaidFk().getCodEmpquincenaid());
//
//            if (sql.executeUpdate() > 0) {
//                return true;
//            }
//        } catch (Exception e) {
//            return false;
//        }
//        return false;
        int contador = 0;
        boolean respuesta = false;
        System.out.println("tamaño " + conf1.size());
        try {
            for (int i = 0; i < conf1.size(); i++) {
//                _saveOrUpdate(conf1.get(i));
                StringBuilder sb = new StringBuilder("UPDATE sgnom.Tsgnomconfpago "
                        + "SET bol_pagofinanzas = :estatus "
                        + "WHERE cod_empquincenaid_fk = :empquincenaid");
                Query sql = getSession().createSQLQuery(sb.toString());
                sql.setParameter("estatus", conf1.get(i).getBolPagofinanzas());
                sql.setParameter("empquincenaid", conf1.get(i).getCodEmpquincenaidFk().getCodEmpquincenaid());
                System.out.println(" " + sb);
                if (sql.executeUpdate() > 0) {
                    contador++;
                    if (conf1.size() == contador) {
                        respuesta = true;
                    }
                }
            }
        } catch (Exception e) {
            Logger.getLogger(ConfPagoDAOImpl.class.getName()).log(Level.SEVERE, null, e);
            respuesta = false;
        }
        return respuesta;
    }

    @Override
    public boolean guardarAutorizacionRH(List<Tsgnomconfpago> conf2) {
        int contador = 0;
        boolean respuesta = false;
        try {
            for (int i = 0; i < conf2.size(); i++) {
                StringBuilder sb = new StringBuilder("UPDATE sgnom.Tsgnomconfpago "
                        + "SET bol_pagorh = :estatus "
                        + "WHERE cod_empquincenaid_fk = :empquincenaid");
                Query sql = getSession().createSQLQuery(sb.toString());
                sql.setParameter("estatus", conf2.get(i).getBolPagorh());
                sql.setParameter("empquincenaid", conf2.get(i).getCodEmpquincenaidFk().getCodEmpquincenaid());

                if (sql.executeUpdate() > 0) {
                    contador++;
                    if (conf2.size() == contador) {
                        respuesta = true;
                    }
                }
            }

        } catch (Exception e) {
            Logger.getLogger(ConfPagoDAOImpl.class.getName()).log(Level.SEVERE, null, e);
            respuesta = false;
        }
        return respuesta;
    }

    @Override
    public boolean guardarAutorizacionEMP(Integer empquincenaFK, Boolean conf3) {
        try {
            StringBuilder sb = new StringBuilder("UPDATE sgnom.Tsgnomconfpago "
                    + "SET bol_pagoempleado = :estatus "
                    + "WHERE cod_empquincenaid_fk = :empquincenaid");
            Query sql = getSession().createSQLQuery(sb.toString());
            sql.setParameter("estatus", conf3);
            sql.setParameter("empquincenaid", empquincenaFK);

            if (sql.executeUpdate() > 0) {
                return true;
            }
        } catch (Exception e) {
            Logger.getLogger(ConfPagoDAOImpl.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }

        return false;
    }

    @Override
    public boolean validarTodas(Integer cabecera) {
        try {
            StringBuilder sb = new StringBuilder("UPDATE sgnom.Tsgnomconfpago "
                    + "SET bol_pagofinanzas = true "
                    + "WHERE cod_empquincenaid_fk IN (SELECT cod_empquincenaid  "
                    + "FROM sgnom.tsgnomempquincena WHERE cod_cabeceraid_fk = :cabecera )");
//                    + ".cod_cabeceraid_fk.cod_cabeceraid = :cabecera");
            Query sql = getSession().createSQLQuery(sb.toString());
//            sql.setParameter("estatus", conf3);
//            sql.setParameter("empquincenaid", empquincenaFK);
            sql.setParameter("cabecera", cabecera);

            if (sql.executeUpdate() > 0) {
                return true;
            }
        } catch (Exception e) {
            Logger.getLogger(ConfPagoDAOImpl.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }

        return false;
    }

    @Override
    public boolean validarTodasRH(Integer cabecera) {
        try {
            StringBuilder sb = new StringBuilder("UPDATE sgnom.Tsgnomconfpago "
                    + "SET bol_pagorh = true "
                    + "WHERE cod_empquincenaid_fk IN (SELECT cod_empquincenaid  "
                    + "FROM sgnom.tsgnomempquincena WHERE cod_cabeceraid_fk = :cabecera )");
//                    + ".cod_cabeceraid_fk.cod_cabeceraid = :cabecera");
            Query sql = getSession().createSQLQuery(sb.toString());
            sql.setParameter("cabecera", cabecera);

            if (sql.executeUpdate() > 0) {
                return true;
            }
        } catch (Exception e) {
            Logger.getLogger(ConfPagoDAOImpl.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }

        return false;
    }

    @Override
    public boolean rechazarTodasRF(Integer cabecera) {
        try {
            StringBuilder sb = new StringBuilder("UPDATE sgnom.Tsgnomconfpago "
                    + "SET bol_pagofinanzas = false "
                    + "WHERE cod_empquincenaid_fk IN (SELECT cod_empquincenaid  "
                    + "FROM sgnom.tsgnomempquincena WHERE cod_cabeceraid_fk = :cabecera )");
//                    + ".cod_cabeceraid_fk.cod_cabeceraid = :cabecera");
            Query sql = getSession().createSQLQuery(sb.toString());
            sql.setParameter("cabecera", cabecera);

            if (sql.executeUpdate() > 0) {
                return true;
            }
        } catch (Exception e) {
            Logger.getLogger(ConfPagoDAOImpl.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }

        return false;
    }

    @Override
    public boolean rechazarTodasRH(Integer cabecera) {
        try {
            StringBuilder sb = new StringBuilder("UPDATE sgnom.Tsgnomconfpago "
                    + "SET bol_pagorh = false "
                    + "WHERE cod_empquincenaid_fk IN (SELECT cod_empquincenaid  "
                    + "FROM sgnom.tsgnomempquincena WHERE cod_cabeceraid_fk = :cabecera )");
//                    + ".cod_cabeceraid_fk.cod_cabeceraid = :cabecera");
            Query sql = getSession().createSQLQuery(sb.toString());
            sql.setParameter("cabecera", cabecera);

            if (sql.executeUpdate() > 0) {
                return true;
            }
        } catch (Exception e) {
            Logger.getLogger(ConfPagoDAOImpl.class.getName()).log(Level.SEVERE, null, e);
            return false;
        }

        return false;
    }
}
