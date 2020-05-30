/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.dao;

import com.googlecode.genericdao.dao.hibernate.GenericDAOImpl;
import com.mbn.sinod.model.dto.DetalleIncidenciasEmpleadoDTO;
import com.mbn.sinod.model.entidades.Tsgnomincidencia;
import java.math.BigDecimal;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.transform.Transformers;

/**
 *
 * @author Karla
 */
public class DetalleIncidenciasEmpleadoDAOImpl extends GenericDAOImpl<Tsgnomincidencia, Integer> 
        implements DetalleIncidenciasEmpleadoDAO{

    @Override
    public List<DetalleIncidenciasEmpleadoDTO> incidenciasPorEmpleado(int reporta) {
        List<DetalleIncidenciasEmpleadoDTO> incidenciasEmpleado = (List<DetalleIncidenciasEmpleadoDTO>)
                getSession().createSQLQuery("SELECT * FROM sgnom.buscar_incidencias_por_empleado(?);")
                .addScalar("idincidencia")
                .addScalar("fechaalta")
                .addScalar("clave")
                .addScalar("incidencia")
                .addScalar("idtipo")
                .addScalar("desctipo")
                .addScalar("cantidad")
                .addScalar("actividad")
                .addScalar("comentarios")
                .addScalar("reportaid")
                .addScalar("reportanb")
                .addScalar("autorizaid")
                .addScalar("autorizanb")
                .addScalar("perfil")
                .addScalar("detallefechas")
                .addScalar("montoincidencia")
                .addScalar("montopagado")
                .addScalar("aceptacion")
                .addScalar("validacion")
                .addScalar("quincenaid")
                .addScalar("desquincena")
                .addScalar("creaid")
                .addScalar("creanb")
                .setResultTransformer(Transformers.aliasToBean(DetalleIncidenciasEmpleadoDTO.class))
                .setInteger(0, reporta)
                .list();
        return incidenciasEmpleado;
    }
    
    @Override
    public List<DetalleIncidenciasEmpleadoDTO> incidenciasPorQuincena(int quincena) {
        List<DetalleIncidenciasEmpleadoDTO> incidenciasEmpleado = (List<DetalleIncidenciasEmpleadoDTO>)
                getSession().createSQLQuery("SELECT * FROM sgnom.fn_incidencias_por_quincena(?);")
                .addScalar("idincidencia")
                .addScalar("fechaalta")
                .addScalar("clave")
                .addScalar("incidencia")
                .addScalar("idtipo")
                .addScalar("desctipo")
                .addScalar("cantidad")
                .addScalar("actividad")
                .addScalar("comentarios")
                .addScalar("reportaid")
                .addScalar("reportanb")
                .addScalar("autorizaid")
                .addScalar("autorizanb")
                .addScalar("perfil")
                .addScalar("detallefechas")
                .addScalar("montoincidencia")
                .addScalar("montopagado")
                .addScalar("validacion")
                .addScalar("aceptacion")
                .addScalar("autorizacion")
                .addScalar("quincenaid")
                .addScalar("desquincena")
                .addScalar("creaid")
                .addScalar("creanb")
                .setResultTransformer(Transformers.aliasToBean(DetalleIncidenciasEmpleadoDTO.class))
                .setInteger(0, quincena)
                .list();
        return incidenciasEmpleado;
    }

    @Override
    public List<DetalleIncidenciasEmpleadoDTO> incidenciasPorEmpleadoQuincena(int empleado, int quincena) {
        List<DetalleIncidenciasEmpleadoDTO> incidenciasEmpleado = (List<DetalleIncidenciasEmpleadoDTO>)
                getSession().createSQLQuery("SELECT * FROM sgnom.fn_incidencias_por_quincena(?) WHERE reportaid = ?;")
                .addScalar("idincidencia")
                .addScalar("fechaalta")
                .addScalar("clave")
                .addScalar("incidencia")
                .addScalar("idtipo")
                .addScalar("desctipo")
                .addScalar("cantidad")
                .addScalar("actividad")
                .addScalar("comentarios")
                .addScalar("reportaid")
                .addScalar("reportanb")
                .addScalar("autorizaid")
                .addScalar("autorizanb")
                .addScalar("perfil")
                .addScalar("detallefechas")
                .addScalar("montoincidencia")
                .addScalar("montopagado")
                .addScalar("validacion")
                .addScalar("aceptacion")
                .addScalar("autorizacion")
                .addScalar("quincenaid")
                .addScalar("desquincena")
                .addScalar("creaid")
                .addScalar("creanb")
                .setResultTransformer(Transformers.aliasToBean(DetalleIncidenciasEmpleadoDTO.class))
                .setInteger(0, quincena)
                .setInteger(1, empleado)
                .list();
        return incidenciasEmpleado;
    }
    
    @Override
    public List<DetalleIncidenciasEmpleadoDTO> incidenciasPorQuincenaArea(int quincena, int area) {
        List<DetalleIncidenciasEmpleadoDTO> incidenciasEmpleado = (List<DetalleIncidenciasEmpleadoDTO>)
                getSession().createSQLQuery("SELECT * FROM sgnom.fn_incidencias_por_quincena(?) WHERE reportaid IN (SELECT * FROM sgnom.empleadosnom_por_area(?));")
                .addScalar("idincidencia")
                .addScalar("fechaalta")
                .addScalar("clave")
                .addScalar("incidencia")
                .addScalar("idtipo")
                .addScalar("desctipo")
                .addScalar("cantidad")
                .addScalar("actividad")
                .addScalar("comentarios")
                .addScalar("reportaid")
                .addScalar("reportanb")
                .addScalar("autorizaid")
                .addScalar("autorizanb")
                .addScalar("perfil")
                .addScalar("detallefechas")
                .addScalar("montoincidencia")
                .addScalar("montopagado")
                .addScalar("validacion")
                .addScalar("aceptacion")
                .addScalar("autorizacion")
                .addScalar("quincenaid")
                .addScalar("desquincena")
                .addScalar("creaid")
                .addScalar("creanb")
                .setResultTransformer(Transformers.aliasToBean(DetalleIncidenciasEmpleadoDTO.class))
                .setInteger(0, quincena)
                .setInteger(1, area)
                .list();
        return incidenciasEmpleado;
    }
    
    @Override
    public boolean eliminarIncidenciaEmpleado(Integer incidenciaid, Integer reporta) {
        Query query = getSession().createSQLQuery("SELECT * FROM sgnom.eliminar_incidencia_por_empleado(?, ?)")
                .setInteger(0, incidenciaid)
                .setInteger(1, reporta);
        return (boolean) query.uniqueResult();
    }

    @Override
    public boolean actualizarComentariosIncidencia(Integer incidenciaid, String comentarios, Integer reporta) {
        Query query = getSession().createSQLQuery("SELECT * FROM sgnom.actualizar_comentarios_incidencia(?, ?, ?)")
                .setInteger(0, incidenciaid)
                .setString(1, comentarios)
                .setInteger(2, reporta);
        return (boolean) query.uniqueResult();
    }

    @Override
    public boolean actualizarImporteIncidencia(Integer incidenciaid, BigDecimal importe, Integer reporta) {
        Query query = getSession().createSQLQuery("SELECT * FROM sgnom.actualizar_importe_incidencia(?, ?, ?)")
                .setInteger(0, incidenciaid)
                .setBigDecimal(1, importe)
                .setInteger(2, reporta);
        return (boolean) query.uniqueResult();
    }
    
    @Override
    public boolean actualizarIncidencia(Integer incidenciaid, String comentarios, BigDecimal importe, Integer reporta) {
        Query query = getSession().createSQLQuery("SELECT * FROM sgnom.actualizar_incidencia(?, ?, ?, ?)")
                .setInteger(0, incidenciaid)
                .setString(1, comentarios)
                .setBigDecimal(2, importe)
                .setInteger(3, reporta);
        return (boolean) query.uniqueResult();
    }
    
    @Override
    public boolean registrarIncidencia(Tsgnomincidencia incidencia){
        Query query = getSession()
                .createSQLQuery("SELECT * FROM sgnom.insertar_incidencia_por_empleado(?,?,?,?,?,?,?,?)")
                .setInteger(0, incidencia.getCodCatincidenciaidFk())
                .setShort(1, incidencia.getCnuCantidad())
                .setString(2, incidencia.getDesActividad())
                .setText(3, incidencia.getTxtComentarios())
                .setInteger(4, incidencia.getCodEmpreportaFk())
                .setInteger(5, incidencia.getAudCodcreadopor())
                .setBigDecimal(6, incidencia.getImpMonto())
                .setString(7, incidencia.getXmlDetcantidad());
        return (boolean) query.uniqueResult();
    }
}
