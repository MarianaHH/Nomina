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
import javax.persistence.FetchType;
import javax.persistence.Id;
	import javax.persistence.GeneratedValue;
	import org.hibernate.annotations.GenericGenerator;
	import org.hibernate.annotations.Parameter;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ambrosio
 */
@Entity
@Table(name = "tsgnommanterceros", catalog = "suite", schema = "sgnom")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tsgnommanterceros.findAll", query = "SELECT t FROM Tsgnommanterceros t")})
public class Tsgnommanterceros implements Serializable {

    private static final long serialVersionUID = 1L;
    	@Id
	@GenericGenerator(name="argId", strategy="increment",parameters = { @Parameter(name = "schema", value = "sgnom") })
    @GeneratedValue(generator = "argId")
    @Basic(optional = false)
    @Column(name = "cod_mantercerosid")
    private Integer codMantercerosid;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "imp_monto")
    private BigDecimal impMonto;
    @Column(name = "cod_frecuenciapago")
    private String codFrecuenciapago;
    @Column(name = "bol_estatus")
    private Boolean bolEstatus;
    @Basic(optional = false)
    @Column(name = "aud_codcreadopor")
    private int audCodcreadopor;
    @Column(name = "aud_codmodificadopor")
    private Integer audCodmodificadopor;
    @Basic(optional = false)
    @Column(name = "aud_fecreacion")
    @Temporal(TemporalType.DATE)
    private Date audFecreacion;
    @Column(name = "aud_fecmodificacion")
    @Temporal(TemporalType.DATE)
    private Date audFecmodificacion;
    @JoinColumn(name = "cod_conceptoid_fk", referencedColumnName = "cod_conceptoid")
    @ManyToOne()
    private Tsgnomconcepto codConceptoidFk;
    @JoinColumn(name = "cod_empleadoid_fk", referencedColumnName = "cod_empleadoid")
    @ManyToOne()
    private Tsgnomempleados codEmpleadoidFk;
    @JoinColumn(name = "cod_quincenafin_fk", referencedColumnName = "cod_quincenaid")
    @ManyToOne()
    private Tsgnomquincena codQuincenafinFk;
    @JoinColumn(name = "cod_quincenainicio_fk", referencedColumnName = "cod_quincenaid")
    @ManyToOne()
    private Tsgnomquincena codQuincenainicioFk;

    public Tsgnommanterceros() {
    }

    public Tsgnommanterceros(Integer codMantercerosid) {
        this.codMantercerosid = codMantercerosid;
    }

    public Tsgnommanterceros(Integer codMantercerosid, int audCodcreadopor, Date audFecreacion) {
        this.codMantercerosid = codMantercerosid;
        this.audCodcreadopor = audCodcreadopor;
        this.audFecreacion = audFecreacion;
    }

    public Integer getCodMantercerosid() {
        return codMantercerosid;
    }

    public void setCodMantercerosid(Integer codMantercerosid) {
        this.codMantercerosid = codMantercerosid;
    }

    public BigDecimal getImpMonto() {
        return impMonto;
    }

    public void setImpMonto(BigDecimal impMonto) {
        this.impMonto = impMonto;
    }

    public String getCodFrecuenciapago() {
        return codFrecuenciapago;
    }

    public void setCodFrecuenciapago(String codFrecuenciapago) {
        this.codFrecuenciapago = codFrecuenciapago;
    }

    public Boolean getBolEstatus() {
        return bolEstatus;
    }

    public void setBolEstatus(Boolean bolEstatus) {
        this.bolEstatus = bolEstatus;
    }

    public int getAudCodcreadopor() {
        return audCodcreadopor;
    }

    public void setAudCodcreadopor(int audCodcreadopor) {
        this.audCodcreadopor = audCodcreadopor;
    }

    public Integer getAudCodmodificadopor() {
        return audCodmodificadopor;
    }

    public void setAudCodmodificadopor(Integer audCodmodificadopor) {
        this.audCodmodificadopor = audCodmodificadopor;
    }

    public Date getAudFecreacion() {
        return audFecreacion;
    }

    public void setAudFecreacion(Date audFecreacion) {
        this.audFecreacion = audFecreacion;
    }

    public Date getAudFecmodificacion() {
        return audFecmodificacion;
    }

    public void setAudFecmodificacion(Date audFecmodificacion) {
        this.audFecmodificacion = audFecmodificacion;
    }

    public Tsgnomconcepto getCodConceptoidFk() {
        return codConceptoidFk;
    }

    public void setCodConceptoidFk(Tsgnomconcepto codConceptoidFk) {
        this.codConceptoidFk = codConceptoidFk;
    }

    public Tsgnomempleados getCodEmpleadoidFk() {
        return codEmpleadoidFk;
    }

    public void setCodEmpleadoidFk(Tsgnomempleados codEmpleadoidFk) {
        this.codEmpleadoidFk = codEmpleadoidFk;
    }

    public Tsgnomquincena getCodQuincenafinFk() {
        return codQuincenafinFk;
    }

    public void setCodQuincenafinFk(Tsgnomquincena codQuincenafinFk) {
        this.codQuincenafinFk = codQuincenafinFk;
    }

    public Tsgnomquincena getCodQuincenainicioFk() {
        return codQuincenainicioFk;
    }

    public void setCodQuincenainicioFk(Tsgnomquincena codQuincenainicioFk) {
        this.codQuincenainicioFk = codQuincenainicioFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codMantercerosid != null ? codMantercerosid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tsgnommanterceros)) {
            return false;
        }
        Tsgnommanterceros other = (Tsgnommanterceros) object;
        if ((this.codMantercerosid == null && other.codMantercerosid != null) || (this.codMantercerosid != null && !this.codMantercerosid.equals(other.codMantercerosid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mbn.sinod.model.entidades.Tsgnommanterceros[ codMantercerosid=" + codMantercerosid + " ]";
    }
    
}
