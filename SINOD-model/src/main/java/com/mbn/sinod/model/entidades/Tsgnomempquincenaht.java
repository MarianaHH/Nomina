/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ambrosio
 */
@Entity
@Table(name = "tsgnomempquincenaht", catalog = "suite", schema = "sgnom")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tsgnomempquincenaht.findAll", query = "SELECT t FROM Tsgnomempquincenaht t")})
public class Tsgnomempquincenaht implements Serializable {

    private static final long serialVersionUID = 1L;
    	@Id
	@GenericGenerator(name="argId", strategy="increment",parameters = { @Parameter(name = "schema", value = "sgnom") })
    @GeneratedValue(generator = "argId")
    @Basic(optional = false)
    @Column(name = "cod_empquincenahtid")
    private Integer codEmpquincenahtid;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "imp_totpercepcion")
    private BigDecimal impTotpercepcion;
    @Basic(optional = false)
    @Column(name = "imp_totdeduccion")
    private BigDecimal impTotdeduccion;
    @Basic(optional = false)
    @Column(name = "imp_totalemp")
    private BigDecimal impTotalemp;
    @Basic(optional = false)
    @Column(name = "bol_estatusemp")
    private boolean bolEstatusemp;
    @JoinColumn(name = "cod_cabeceraid_fk", referencedColumnName = "cod_cabeceraid")
    @ManyToOne(optional = false)
    private Tsgnomcabecera codCabeceraidFk;
    @JoinColumn(name = "cod_empleadoid_fk", referencedColumnName = "cod_empleadoid")
    @ManyToOne(optional = false)
    private Tsgnomempleados codEmpleadoidFk;

    public Tsgnomempquincenaht() {
    }

    public Tsgnomempquincenaht(Integer codEmpquincenahtid) {
        this.codEmpquincenahtid = codEmpquincenahtid;
    }

    public Tsgnomempquincenaht(Integer codEmpquincenahtid, BigDecimal impTotpercepcion, BigDecimal impTotdeduccion, BigDecimal impTotalemp, boolean bolEstatusemp) {
        this.codEmpquincenahtid = codEmpquincenahtid;
        this.impTotpercepcion = impTotpercepcion;
        this.impTotdeduccion = impTotdeduccion;
        this.impTotalemp = impTotalemp;
        this.bolEstatusemp = bolEstatusemp;
    }

    public Integer getCodEmpquincenahtid() {
        return codEmpquincenahtid;
    }

    public void setCodEmpquincenahtid(Integer codEmpquincenahtid) {
        this.codEmpquincenahtid = codEmpquincenahtid;
    }

    public BigDecimal getImpTotpercepcion() {
        return impTotpercepcion;
    }

    public void setImpTotpercepcion(BigDecimal impTotpercepcion) {
        this.impTotpercepcion = impTotpercepcion;
    }

    public BigDecimal getImpTotdeduccion() {
        return impTotdeduccion;
    }

    public void setImpTotdeduccion(BigDecimal impTotdeduccion) {
        this.impTotdeduccion = impTotdeduccion;
    }

    public BigDecimal getImpTotalemp() {
        return impTotalemp;
    }

    public void setImpTotalemp(BigDecimal impTotalemp) {
        this.impTotalemp = impTotalemp;
    }

    public boolean getBolEstatusemp() {
        return bolEstatusemp;
    }

    public void setBolEstatusemp(boolean bolEstatusemp) {
        this.bolEstatusemp = bolEstatusemp;
    }

    public Tsgnomcabecera getCodCabeceraidFk() {
        return codCabeceraidFk;
    }

    public void setCodCabeceraidFk(Tsgnomcabecera codCabeceraidFk) {
        this.codCabeceraidFk = codCabeceraidFk;
    }

    public Tsgnomempleados getCodEmpleadoidFk() {
        return codEmpleadoidFk;
    }

    public void setCodEmpleadoidFk(Tsgnomempleados codEmpleadoidFk) {
        this.codEmpleadoidFk = codEmpleadoidFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codEmpquincenahtid != null ? codEmpquincenahtid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tsgnomempquincenaht)) {
            return false;
        }
        Tsgnomempquincenaht other = (Tsgnomempquincenaht) object;
        if ((this.codEmpquincenahtid == null && other.codEmpquincenahtid != null) || (this.codEmpquincenahtid != null && !this.codEmpquincenahtid.equals(other.codEmpquincenahtid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mbn.sinod.model.entidades.Tsgnomempquincenaht[ codEmpquincenahtid=" + codEmpquincenahtid + " ]";
    }
    
}
