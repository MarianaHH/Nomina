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
import javax.persistence.CascadeType;
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
@Table(name = "tsgnomconceptosat", catalog = "suite", schema = "sgnom")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tsgnomconceptosat.findAll", query = "SELECT t FROM Tsgnomconceptosat t")})
public class Tsgnomconceptosat implements Serializable {

    private static final long serialVersionUID = 1L;
    	@Id
	@GenericGenerator(name="argId", strategy="increment",parameters = { @Parameter(name = "schema", value = "sgnom") })
    @GeneratedValue(generator = "argId")
    @Basic(optional = false)
    @Column(name = "cod_conceptosatid")
    private Integer codConceptosatid;
    @Basic(optional = false)
    @Column(name = "des_conceptosat")
    private String desConceptosat;
    @Basic(optional = false)
    @Column(name = "des_descconcepto")
    private String desDescconcepto;
    @Basic(optional = false)
    @Column(name = "bol_estatus")
    private boolean bolEstatus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codConceptosatidFk", fetch = FetchType.LAZY)
    private List<Tsgnomconcepto> tsgnomconceptoList;

    public Tsgnomconceptosat() {
    }

    public Tsgnomconceptosat(Integer codConceptosatid) {
        this.codConceptosatid = codConceptosatid;
    }

    public Tsgnomconceptosat(Integer codConceptosatid, String desConceptosat, String desDescconcepto, boolean bolEstatus) {
        this.codConceptosatid = codConceptosatid;
        this.desConceptosat = desConceptosat;
        this.desDescconcepto = desDescconcepto;
        this.bolEstatus = bolEstatus;
    }

    public Integer getCodConceptosatid() {
        return codConceptosatid;
    }

    public void setCodConceptosatid(Integer codConceptosatid) {
        this.codConceptosatid = codConceptosatid;
    }

    public String getDesConceptosat() {
        return desConceptosat;
    }

    public void setDesConceptosat(String desConceptosat) {
        this.desConceptosat = desConceptosat;
    }

    public String getDesDescconcepto() {
        return desDescconcepto;
    }

    public void setDesDescconcepto(String desDescconcepto) {
        this.desDescconcepto = desDescconcepto;
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
        hash += (codConceptosatid != null ? codConceptosatid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tsgnomconceptosat)) {
            return false;
        }
        Tsgnomconceptosat other = (Tsgnomconceptosat) object;
        if ((this.codConceptosatid == null && other.codConceptosatid != null) || (this.codConceptosatid != null && !this.codConceptosatid.equals(other.codConceptosatid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mbn.sinod.model.entidades.Tsgnomconceptosat[ codConceptosatid=" + codConceptosatid + " ]";
    }
    
}
