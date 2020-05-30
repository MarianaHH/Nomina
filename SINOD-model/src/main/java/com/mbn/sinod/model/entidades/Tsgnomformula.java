/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
	import javax.persistence.GeneratedValue;
	import org.hibernate.annotations.GenericGenerator;
	import org.hibernate.annotations.Parameter;
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
@Table(name = "tsgnomformula", catalog = "suite", schema = "sgnom")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tsgnomformula.findAll", query = "SELECT t FROM Tsgnomformula t")})
public class Tsgnomformula implements Serializable {

    private static final long serialVersionUID = 1L;
    	@Id
	@GenericGenerator(name="argId", strategy="increment",parameters = { @Parameter(name = "schema", value = "sgnom") })
    @GeneratedValue(generator = "argId")
    @Basic(optional = false)
    @Column(name = "cod_formulaid")
    private Integer codFormulaid;
    @Basic(optional = false)
    @Column(name = "des_nbformula")
    private String desNbformula;
    @Basic(optional = false)
    @Column(name = "des_formula")
    private String desFormula;
    @Basic(optional = false)
    @Column(name = "bol_estatus")
    private boolean bolEstatus;
    @OneToMany(mappedBy = "codFormulaidFk", fetch = FetchType.LAZY)
    private List<Tsgnomconcepto> tsgnomconceptoList;

    public Tsgnomformula() {
    }

    public Tsgnomformula(Integer codFormulaid) {
        this.codFormulaid = codFormulaid;
    }

    public Tsgnomformula(Integer codFormulaid, String desNbformula, String desFormula, boolean bolEstatus) {
        this.codFormulaid = codFormulaid;
        this.desNbformula = desNbformula;
        this.desFormula = desFormula;
        this.bolEstatus = bolEstatus;
    }

    public Integer getCodFormulaid() {
        return codFormulaid;
    }

    public void setCodFormulaid(Integer codFormulaid) {
        this.codFormulaid = codFormulaid;
    }

    public String getDesNbformula() {
        return desNbformula;
    }

    public void setDesNbformula(String desNbformula) {
        this.desNbformula = desNbformula;
    }

    public String getDesFormula() {
        return desFormula;
    }

    public void setDesFormula(String desFormula) {
        this.desFormula = desFormula;
    }

    public boolean getBolEstatus() {
        return bolEstatus;
    }

    public void setBolEstatus(boolean bolEstatus) {
        this.bolEstatus = bolEstatus;
    }

    @XmlTransient @JsonIgnore
    public List<Tsgnomconcepto> getTsgnomconceptoList() {
        return tsgnomconceptoList;
    }

    public void setTsgnomconceptoList(List<Tsgnomconcepto> tsgnomconceptoList) {
        this.tsgnomconceptoList = tsgnomconceptoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codFormulaid != null ? codFormulaid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tsgnomformula)) {
            return false;
        }
        Tsgnomformula other = (Tsgnomformula) object;
        if ((this.codFormulaid == null && other.codFormulaid != null) || (this.codFormulaid != null && !this.codFormulaid.equals(other.codFormulaid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mbn.sinod.model.entidades.Tsgnomformula[ codFormulaid=" + codFormulaid + " ]";
    }
    
}
