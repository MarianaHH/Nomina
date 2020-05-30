/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ambrosio
 */
@Entity
@Table(name = "tsgnomempquincena", catalog = "suite", schema = "sgnom")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tsgnomempquincena.findAll", query = "SELECT t FROM Tsgnomempquincena t")})
public class Tsgnomempquincena implements Serializable {

    private static final long serialVersionUID = 1L;
    	@Id
	@GenericGenerator(name="argId", strategy="increment",parameters = { @Parameter(name = "schema", value = "sgnom") })
    @GeneratedValue(generator = "argId")
    @Basic(optional = false)
    @Column(name = "cod_empquincenaid")
    private Integer codEmpquincenaid;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codEmpquincenaidFk", fetch = FetchType.LAZY)
    private List<Tsgnomcncptoquincht> tsgnomcncptoquinchtList;
    @OneToMany(mappedBy = "codEmpquincenaidFk", fetch = FetchType.LAZY)
    private List<Tsgnomconfpago> tsgnomconfpagoList;
    @JoinColumn(name = "cod_cabeceraid_fk", referencedColumnName = "cod_cabeceraid")
    @ManyToOne(optional = false)
    private Tsgnomcabecera codCabeceraidFk;
    @JoinColumn(name = "cod_empleadoid_fk", referencedColumnName = "cod_empleadoid")
    @ManyToOne(optional = false)
    private Tsgnomempleados codEmpleadoidFk;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codEmpquincenaidFk", fetch = FetchType.LAZY)
    private List<Tsgnomcncptoquinc> tsgnomcncptoquincList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codEmpquincenaidFk", fetch = FetchType.LAZY)
    private List<Tsgnomalguinaldo> tsgnomalguinaldoList;

    public Tsgnomempquincena() {
    }

    public Tsgnomempquincena(Integer codEmpquincenaid) {
        this.codEmpquincenaid = codEmpquincenaid;
    }

    public Tsgnomempquincena(Integer codEmpquincenaid, BigDecimal impTotpercepcion, BigDecimal impTotdeduccion, BigDecimal impTotalemp, boolean bolEstatusemp) {
        this.codEmpquincenaid = codEmpquincenaid;
        this.impTotpercepcion = impTotpercepcion;
        this.impTotdeduccion = impTotdeduccion;
        this.impTotalemp = impTotalemp;
        this.bolEstatusemp = bolEstatusemp;
    }

    public Integer getCodEmpquincenaid() {
        return codEmpquincenaid;
    }

    public void setCodEmpquincenaid(Integer codEmpquincenaid) {
        this.codEmpquincenaid = codEmpquincenaid;
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

    @XmlTransient @JsonIgnore
    public List<Tsgnomcncptoquincht> getTsgnomcncptoquinchtList() {
        return tsgnomcncptoquinchtList;
    }

    public void setTsgnomcncptoquinchtList(List<Tsgnomcncptoquincht> tsgnomcncptoquinchtList) {
        this.tsgnomcncptoquinchtList = tsgnomcncptoquinchtList;
    }

    @XmlTransient @JsonIgnore
    public List<Tsgnomconfpago> getTsgnomconfpagoList() {
        return tsgnomconfpagoList;
    }

    public void setTsgnomconfpagoList(List<Tsgnomconfpago> tsgnomconfpagoList) {
        this.tsgnomconfpagoList = tsgnomconfpagoList;
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

    @XmlTransient @JsonIgnore
    public List<Tsgnomcncptoquinc> getTsgnomcncptoquincList() {
        return tsgnomcncptoquincList;
    }

    public void setTsgnomcncptoquincList(List<Tsgnomcncptoquinc> tsgnomcncptoquincList) {
        this.tsgnomcncptoquincList = tsgnomcncptoquincList;
    }

    @XmlTransient @JsonIgnore
    public List<Tsgnomalguinaldo> getTsgnomalguinaldoList() {
        return tsgnomalguinaldoList;
    }

    public void setTsgnomalguinaldoList(List<Tsgnomalguinaldo> tsgnomalguinaldoList) {
        this.tsgnomalguinaldoList = tsgnomalguinaldoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codEmpquincenaid != null ? codEmpquincenaid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tsgnomempquincena)) {
            return false;
        }
        Tsgnomempquincena other = (Tsgnomempquincena) object;
        if ((this.codEmpquincenaid == null && other.codEmpquincenaid != null) || (this.codEmpquincenaid != null && !this.codEmpquincenaid.equals(other.codEmpquincenaid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mbn.sinod.model.entidades.Tsgnomempquincena[ codEmpquincenaid=" + codEmpquincenaid + " ]";
    }
    
}
