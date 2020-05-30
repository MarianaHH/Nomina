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
@Table(name = "tsgnomtipoconcepto", catalog = "suite", schema = "sgnom")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tsgnomtipoconcepto.findAll", query = "SELECT t FROM Tsgnomtipoconcepto t")})
public class Tsgnomtipoconcepto implements Serializable {

    private static final long serialVersionUID = 1L;
    	@Id
	@GenericGenerator(name="argId", strategy="increment",parameters = { @Parameter(name = "schema", value = "sgnom") })
    @GeneratedValue(generator = "argId")
    @Basic(optional = false)
    @Column(name = "cod_tipoconceptoid")
    private Integer codTipoconceptoid;
    @Basic(optional = false)
    @Column(name = "cod_tipoconcepto")
    private String codTipoconcepto;
    @Basic(optional = false)
    @Column(name = "bol_estatus")
    private boolean bolEstatus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codTipoconceptoidFk", fetch = FetchType.LAZY)
    private List<Tsgnomconcepto> tsgnomconceptoList;

    public Tsgnomtipoconcepto() {
    }

    public Tsgnomtipoconcepto(Integer codTipoconceptoid) {
        this.codTipoconceptoid = codTipoconceptoid;
    }

    public Tsgnomtipoconcepto(Integer codTipoconceptoid, String codTipoconcepto, boolean bolEstatus) {
        this.codTipoconceptoid = codTipoconceptoid;
        this.codTipoconcepto = codTipoconcepto;
        this.bolEstatus = bolEstatus;
    }

    public Integer getCodTipoconceptoid() {
        return codTipoconceptoid;
    }

    public void setCodTipoconceptoid(Integer codTipoconceptoid) {
        this.codTipoconceptoid = codTipoconceptoid;
    }

    public String getCodTipoconcepto() {
        return codTipoconcepto;
    }

    public void setCodTipoconcepto(String codTipoconcepto) {
        this.codTipoconcepto = codTipoconcepto;
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
        hash += (codTipoconceptoid != null ? codTipoconceptoid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tsgnomtipoconcepto)) {
            return false;
        }
        Tsgnomtipoconcepto other = (Tsgnomtipoconcepto) object;
        if ((this.codTipoconceptoid == null && other.codTipoconceptoid != null) || (this.codTipoconceptoid != null && !this.codTipoconceptoid.equals(other.codTipoconceptoid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mbn.sinod.model.entidades.Tsgnomtipoconcepto[ codTipoconceptoid=" + codTipoconceptoid + " ]";
    }
    
}
