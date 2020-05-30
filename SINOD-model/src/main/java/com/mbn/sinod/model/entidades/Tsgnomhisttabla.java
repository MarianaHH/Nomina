/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.entidades;

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
@Table(name = "tsgnomhisttabla", catalog = "suite", schema = "sgnom")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tsgnomhisttabla.findAll", query = "SELECT t FROM Tsgnomhisttabla t")})
public class Tsgnomhisttabla implements Serializable {

    private static final long serialVersionUID = 1L;
    	@Id
	@GenericGenerator(name="argId", strategy="increment",parameters = { @Parameter(name = "schema", value = "sgnom") })
    @GeneratedValue(generator = "argId")
    @Basic(optional = false)
    @Column(name = "cod_tablaid")
    private Integer codTablaid;
    @Basic(optional = false)
    @Column(name = "cod_nbtabla")
    private String codNbtabla;
    @Basic(optional = false)
    @Column(name = "bol_estatus")
    private boolean bolEstatus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codTablaidFk", fetch = FetchType.LAZY)
    private List<Tsgnombitacora> tsgnombitacoraList;

    public Tsgnomhisttabla() {
    }

    public Tsgnomhisttabla(Integer codTablaid) {
        this.codTablaid = codTablaid;
    }

    public Tsgnomhisttabla(Integer codTablaid, String codNbtabla, boolean bolEstatus) {
        this.codTablaid = codTablaid;
        this.codNbtabla = codNbtabla;
        this.bolEstatus = bolEstatus;
    }

    public Integer getCodTablaid() {
        return codTablaid;
    }

    public void setCodTablaid(Integer codTablaid) {
        this.codTablaid = codTablaid;
    }

    public String getCodNbtabla() {
        return codNbtabla;
    }

    public void setCodNbtabla(String codNbtabla) {
        this.codNbtabla = codNbtabla;
    }

    public boolean getBolEstatus() {
        return bolEstatus;
    }

    public void setBolEstatus(boolean bolEstatus) {
        this.bolEstatus = bolEstatus;
    }

    @XmlTransient
    public List<Tsgnombitacora> getTsgnombitacoraList() {
        return tsgnombitacoraList;
    }

    public void setTsgnombitacoraList(List<Tsgnombitacora> tsgnombitacoraList) {
        this.tsgnombitacoraList = tsgnombitacoraList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codTablaid != null ? codTablaid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tsgnomhisttabla)) {
            return false;
        }
        Tsgnomhisttabla other = (Tsgnomhisttabla) object;
        if ((this.codTablaid == null && other.codTablaid != null) || (this.codTablaid != null && !this.codTablaid.equals(other.codTablaid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mbn.sinod.model.entidades.Tsgnomhisttabla[ codTablaid=" + codTablaid + " ]";
    }
    
}
