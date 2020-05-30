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
@Table(name = "tsgnomestatusnom", catalog = "suite", schema = "sgnom")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tsgnomestatusnom.findAll", query = "SELECT t FROM Tsgnomestatusnom t")})
public class Tsgnomestatusnom implements Serializable {

    private static final long serialVersionUID = 1L;
    	@Id
	@GenericGenerator(name="argId", strategy="increment",parameters = { @Parameter(name = "schema", value = "sgnom") })
    @GeneratedValue(generator = "argId")
    @Basic(optional = false)
    @Column(name = "cod_estatusnomid")
    private Integer codEstatusnomid;
    @Basic(optional = false)
    @Column(name = "cod_estatusnomina")
    private String codEstatusnomina;
    @Basic(optional = false)
    @Column(name = "bol_estatus")
    private boolean bolEstatus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codEstatusnomidFk", fetch = FetchType.LAZY)
    private List<Tsgnomcabecera> tsgnomcabeceraList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codEstatusnomidFk", fetch = FetchType.LAZY)
    private List<Tsgnomcabeceraht> tsgnomcabecerahtList;

    public Tsgnomestatusnom() {
    }

    public Tsgnomestatusnom(Integer codEstatusnomid) {
        this.codEstatusnomid = codEstatusnomid;
    }

    public Tsgnomestatusnom(Integer codEstatusnomid, String codEstatusnomina, boolean bolEstatus) {
        this.codEstatusnomid = codEstatusnomid;
        this.codEstatusnomina = codEstatusnomina;
        this.bolEstatus = bolEstatus;
    }

    public Integer getCodEstatusnomid() {
        return codEstatusnomid;
    }

    public void setCodEstatusnomid(Integer codEstatusnomid) {
        this.codEstatusnomid = codEstatusnomid;
    }

    public String getCodEstatusnomina() {
        return codEstatusnomina;
    }

    public void setCodEstatusnomina(String codEstatusnomina) {
        this.codEstatusnomina = codEstatusnomina;
    }

    public boolean getBolEstatus() {
        return bolEstatus;
    }

    public void setBolEstatus(boolean bolEstatus) {
        this.bolEstatus = bolEstatus;
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
        hash += (codEstatusnomid != null ? codEstatusnomid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tsgnomestatusnom)) {
            return false;
        }
        Tsgnomestatusnom other = (Tsgnomestatusnom) object;
        if ((this.codEstatusnomid == null && other.codEstatusnomid != null) || (this.codEstatusnomid != null && !this.codEstatusnomid.equals(other.codEstatusnomid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mbn.sinod.model.entidades.Tsgnomestatusnom[ codEstatusnomid=" + codEstatusnomid + " ]";
    }
    
}
