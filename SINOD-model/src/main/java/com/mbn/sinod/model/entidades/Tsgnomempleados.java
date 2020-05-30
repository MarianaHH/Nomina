/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 *
 * @author Ivette
 */
@Entity
@Table(name = "tsgnomempleados", catalog = "suite", schema = "sgnom")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tsgnomempleados.findAll", query = "SELECT t FROM Tsgnomempleados t")})
public class Tsgnomempleados implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GenericGenerator(name="argId", strategy="increment",parameters = { @Parameter(name = "schema", value = "sgnom") })
    @GeneratedValue(generator = "argId")
    @Basic(optional = false)
    @Column(name = "cod_empleadoid")
    private Integer codEmpleadoid;
    @Basic(optional = false)
    @Column(name = "fec_ingreso")
    @Temporal(TemporalType.DATE)
    private Date fecIngreso;
    @Column(name = "fec_salida")
    @Temporal(TemporalType.DATE)
    private Date fecSalida;
    @Basic(optional = false)
    @Column(name = "bol_estatus")
    private boolean bolEstatus;
    @Basic(optional = false)
    @Column(name = "cod_empleado_fk")
    private int codEmpleadoFk;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "imp_sueldoimss")
    private BigDecimal impSueldoimss;
    @Column(name = "imp_honorarios")
    private BigDecimal impHonorarios;
    @Column(name = "imp_finiquito")
    private BigDecimal impFiniquito;
    @Column(name = "cod_tipoimss")
    private Character codTipoimss;
    @Column(name = "cod_tipohonorarios")
    private Character codTipohonorarios;
    @Column(name = "cod_banco")
    private String codBanco;
    @Column(name = "cod_sucursal")
    private Integer codSucursal;
    @Column(name = "cod_cuenta")
    private String codCuenta;
    @Column(name = "cod_bancoh")
    private String codBancoh;
    @Column(name = "cod_sucursalh")
    private Integer codSucursalh;
    @Column(name = "cod_cuentah")
    private String codCuentah;
    @Column(name = "txt_descripcionbaja")
    private String txtDescripcionbaja;
    @Basic(optional = false)
    @Column(name = "aud_codcreadopor")
    private int audCodcreadopor;
    @Basic(optional = false)
    @Column(name = "aud_feccreacion")
    @Temporal(TemporalType.DATE)
    private Date audFeccreacion;
    @Column(name = "aud_codmodificadopor")
    private Integer audCodmodificadopor;
    @Column(name = "aud_fecmodificacion")
    @Temporal(TemporalType.DATE)
    private Date audFecmodificacion;
    @Column(name = "cod_clabe")
    private String codClabe;
    @Column(name = "cod_clabeh")
    private String codClabeh;
    @Column(name = "des_validacion")
    private Boolean desValidacion;
    @Column(name = "cod_validaciones")
    private Character codValidaciones;

    public Tsgnomempleados() {
    }

    public Tsgnomempleados(Integer codEmpleadoid) {
        this.codEmpleadoid = codEmpleadoid;
    }

    public Tsgnomempleados(Integer codEmpleadoid, Date fecIngreso, boolean bolEstatus, int codEmpleadoFk, int audCodcreadopor, Date audFeccreacion) {
        this.codEmpleadoid = codEmpleadoid;
        this.fecIngreso = fecIngreso;
        this.bolEstatus = bolEstatus;
        this.codEmpleadoFk = codEmpleadoFk;
        this.audCodcreadopor = audCodcreadopor;
        this.audFeccreacion = audFeccreacion;
    }

    public Integer getCodEmpleadoid() {
        return codEmpleadoid;
    }

    public void setCodEmpleadoid(Integer codEmpleadoid) {
        this.codEmpleadoid = codEmpleadoid;
    }

    public Date getFecIngreso() {
        return fecIngreso;
    }

    public void setFecIngreso(Date fecIngreso) {
        this.fecIngreso = fecIngreso;
    }

    public Date getFecSalida() {
        return fecSalida;
    }

    public void setFecSalida(Date fecSalida) {
        this.fecSalida = fecSalida;
    }

    public boolean getBolEstatus() {
        return bolEstatus;
    }

    public void setBolEstatus(boolean bolEstatus) {
        this.bolEstatus = bolEstatus;
    }

    public int getCodEmpleadoFk() {
        return codEmpleadoFk;
    }

    public void setCodEmpleadoFk(int codEmpleadoFk) {
        this.codEmpleadoFk = codEmpleadoFk;
    }

    public BigDecimal getImpSueldoimss() {
        return impSueldoimss;
    }

    public void setImpSueldoimss(BigDecimal impSueldoimss) {
        this.impSueldoimss = impSueldoimss;
    }

    public BigDecimal getImpHonorarios() {
        return impHonorarios;
    }

    public void setImpHonorarios(BigDecimal impHonorarios) {
        this.impHonorarios = impHonorarios;
    }

    public BigDecimal getImpFiniquito() {
        return impFiniquito;
    }

    public void setImpFiniquito(BigDecimal impFiniquito) {
        this.impFiniquito = impFiniquito;
    }

    public Character getCodTipoimss() {
        return codTipoimss;
    }

    public void setCodTipoimss(Character codTipoimss) {
        this.codTipoimss = codTipoimss;
    }

    public Character getCodTipohonorarios() {
        return codTipohonorarios;
    }

    public void setCodTipohonorarios(Character codTipohonorarios) {
        this.codTipohonorarios = codTipohonorarios;
    }

    public String getCodBanco() {
        return codBanco;
    }

    public void setCodBanco(String codBanco) {
        this.codBanco = codBanco;
    }

    public Integer getCodSucursal() {
        return codSucursal;
    }

    public void setCodSucursal(Integer codSucursal) {
        this.codSucursal = codSucursal;
    }

    public String getCodCuenta() {
        return codCuenta;
    }

    public void setCodCuenta(String codCuenta) {
        this.codCuenta = codCuenta;
    }

    public String getTxtDescripcionbaja() {
        return txtDescripcionbaja;
    }

    public void setTxtDescripcionbaja(String txtDescripcionbaja) {
        this.txtDescripcionbaja = txtDescripcionbaja;
    }

    public int getAudCodcreadopor() {
        return audCodcreadopor;
    }

    public void setAudCodcreadopor(int audCodcreadopor) {
        this.audCodcreadopor = audCodcreadopor;
    }

    public Date getAudFeccreacion() {
        return audFeccreacion;
    }

    public void setAudFeccreacion(Date audFeccreacion) {
        this.audFeccreacion = audFeccreacion;
    }

    public Integer getAudCodmodificadopor() {
        return audCodmodificadopor;
    }

    public void setAudCodmodificadopor(Integer audCodmodificadopor) {
        this.audCodmodificadopor = audCodmodificadopor;
    }

    public Date getAudFecmodificacion() {
        return audFecmodificacion;
    }

    public void setAudFecmodificacion(Date audFecmodificacion) {
        this.audFecmodificacion = audFecmodificacion;
    }

    public String getCodClabe() {
        return codClabe;
    }

    public void setCodClabe(String codClabe) {
        this.codClabe = codClabe;
    }

    public Boolean getDesValidacion() {
        return desValidacion;
    }

    public void setDesValidacion(Boolean desValidacion) {
        this.desValidacion = desValidacion;
    }

    public Character getCodValidaciones() {
        return codValidaciones;
    }

    public void setCodValidaciones(Character codValidaciones) {
        this.codValidaciones = codValidaciones;
    }

    
    public String getCodBancoh() {
        return codBancoh;
    }

    public void setCodBancoh(String codBancoh) {
        this.codBancoh = codBancoh;
    }

    public Integer getCodSucursalh() {
        return codSucursalh;
    }

    public void setCodSucursalh(Integer codSucursalh) {
        this.codSucursalh = codSucursalh;
    }

    public String getCodCuentah() {
        return codCuentah;
    }

    public void setCodCuentah(String codCuentah) {
        this.codCuentah = codCuentah;
    }
    
    public String getCodClabeh() {
        return codClabeh;
    }

    public void setCodClabeh(String codClabeh) {
        this.codClabeh = codClabeh;
    }
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codEmpleadoid != null ? codEmpleadoid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tsgnomempleados)) {
            return false;
        }
        Tsgnomempleados other = (Tsgnomempleados) object;
        if ((this.codEmpleadoid == null && other.codEmpleadoid != null) || (this.codEmpleadoid != null && !this.codEmpleadoid.equals(other.codEmpleadoid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mbn.sinod.model.entidades.Tsgnomempleados[ codEmpleadoid=" + codEmpleadoid + " ]";
    }  
}
