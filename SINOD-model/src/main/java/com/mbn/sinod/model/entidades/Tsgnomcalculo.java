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
@Table(name = "tsgnomcalculo", catalog = "suite", schema = "sgnom")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tsgnomcalculo.findAll", query = "SELECT t FROM Tsgnomcalculo t")})
public class Tsgnomcalculo implements Serializable {

    private static final long serialVersionUID = 1L;
    	@Id
	@GenericGenerator(name="argId", strategy="increment",parameters = { @Parameter(name = "schema", value = "sgnom") })
    @GeneratedValue(generator = "argId")
    @Basic(optional = false)
    @Column(name = "cod_calculoid")
    private Integer codCalculoid;
    @Basic(optional = false)
    @Column(name = "cod_tpcalculo")
    private String codTpcalculo;
    @Basic(optional = false)
    @Column(name = "bol_estatus")
    private boolean bolEstatus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codCalculoidFk", fetch = FetchType.LAZY)
    private List<Tsgnomconcepto> tsgnomconceptoList;

    public Tsgnomcalculo() {
    }

    public Tsgnomcalculo(Integer codCalculoid) {
        this.codCalculoid = codCalculoid;
    }

    public Tsgnomcalculo(Integer codCalculoid, String codTpcalculo, boolean bolEstatus) {
        this.codCalculoid = codCalculoid;
        this.codTpcalculo = codTpcalculo;
        this.bolEstatus = bolEstatus;
    }

    public Integer getCodCalculoid() {
        return codCalculoid;
    }

    public void setCodCalculoid(Integer codCalculoid) {
        this.codCalculoid = codCalculoid;
    }

    public String getCodTpcalculo() {
        return codTpcalculo;
    }

    public void setCodTpcalculo(String codTpcalculo) {
        this.codTpcalculo = codTpcalculo;
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
        hash += (codCalculoid != null ? codCalculoid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tsgnomcalculo)) {
            return false;
        }
        Tsgnomcalculo other = (Tsgnomcalculo) object;
        if ((this.codCalculoid == null && other.codCalculoid != null) || (this.codCalculoid != null && !this.codCalculoid.equals(other.codCalculoid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mbn.sinod.model.entidades.Tsgnomcalculo[ codCalculoid=" + codCalculoid + " ]";
    }
    
}
