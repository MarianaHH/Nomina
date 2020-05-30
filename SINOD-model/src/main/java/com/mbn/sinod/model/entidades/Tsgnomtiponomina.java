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
@Table(name = "tsgnomtiponomina", catalog = "suite", schema = "sgnom")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tsgnomtiponomina.findAll", query = "SELECT t FROM Tsgnomtiponomina t")})
public class Tsgnomtiponomina implements Serializable {

    private static final long serialVersionUID = 1L;
    	@Id
	@GenericGenerator(name="argId", strategy="increment",parameters = { @Parameter(name = "schema", value = "sgnom") })
    @GeneratedValue(generator = "argId")
    @Basic(optional = false)
    @Column(name = "cod_tiponominaid")
    private Integer codTiponominaid;
    @Basic(optional = false)
    @Column(name = "cod_nomina")
    private String codNomina;
    @Basic(optional = false)
    @Column(name = "bol_estatus")
    private boolean bolEstatus;
    @OneToMany(mappedBy = "codTiponominaidFk", fetch = FetchType.LAZY)
    private List<Tsgnomconcepto> tsgnomconceptoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codTiponominaidFk", fetch = FetchType.LAZY)
    private List<Tsgnomcabecera> tsgnomcabeceraList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codTiponominaidFk", fetch = FetchType.LAZY)
    private List<Tsgnomcabeceraht> tsgnomcabecerahtList;

    public Tsgnomtiponomina() {
    }

    public Tsgnomtiponomina(Integer codTiponominaid) {
        this.codTiponominaid = codTiponominaid;
    }

    public Tsgnomtiponomina(Integer codTiponominaid, String codNomina, boolean bolEstatus) {
        this.codTiponominaid = codTiponominaid;
        this.codNomina = codNomina;
        this.bolEstatus = bolEstatus;
    }

    public Integer getCodTiponominaid() {
        return codTiponominaid;
    }

    public void setCodTiponominaid(Integer codTiponominaid) {
        this.codTiponominaid = codTiponominaid;
    }

    public String getCodNomina() {
        return codNomina;
    }

    public void setCodNomina(String codNomina) {
        this.codNomina = codNomina;
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

    @XmlTransient @JsonIgnore
    public List<Tsgnomcabecera> getTsgnomcabeceraList() {
        return tsgnomcabeceraList;
    }

    public void setTsgnomcabeceraList(List<Tsgnomcabecera> tsgnomcabeceraList) {
        this.tsgnomcabeceraList = tsgnomcabeceraList;
    }

    @XmlTransient @JsonIgnore
    public List<Tsgnomcabeceraht> getTsgnomcabecerahtList() {
        return tsgnomcabecerahtList;
    }

    public void setTsgnomcabecerahtList(List<Tsgnomcabeceraht> tsgnomcabecerahtList) {
        this.tsgnomcabecerahtList = tsgnomcabecerahtList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codTiponominaid != null ? codTiponominaid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tsgnomtiponomina)) {
            return false;
        }
        Tsgnomtiponomina other = (Tsgnomtiponomina) object;
        if ((this.codTiponominaid == null && other.codTiponominaid != null) || (this.codTiponominaid != null && !this.codTiponominaid.equals(other.codTiponominaid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mbn.sinod.model.entidades.Tsgnomtiponomina[ codTiponominaid=" + codTiponominaid + " ]";
    }
    
}
