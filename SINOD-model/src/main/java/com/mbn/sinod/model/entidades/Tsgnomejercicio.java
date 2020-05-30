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
@Table(name = "tsgnomejercicio", catalog = "suite", schema = "sgnom")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tsgnomejercicio.findAll", query = "SELECT t FROM Tsgnomejercicio t")})
public class Tsgnomejercicio implements Serializable {

    private static final long serialVersionUID = 1L;
    	@Id
	@GenericGenerator(name="argId", strategy="increment",parameters = { @Parameter(name = "schema", value = "sgnom") })
    @GeneratedValue(generator = "argId")
    @Basic(optional = false)
    @Column(name = "cod_ejercicioid")
    private Integer codEjercicioid;
    @Basic(optional = false)
    @Column(name = "cnu_valorejercicio")
    private int cnuValorejercicio;
    @Basic(optional = false)
    @Column(name = "bol_estatus")
    private boolean bolEstatus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codEjercicioidFk")
    private List<Tsgnomquincena> tsgnomquincenaList;

    public Tsgnomejercicio() {
    }

    public Tsgnomejercicio(Integer codEjercicioid) {
        this.codEjercicioid = codEjercicioid;
    }

    public Tsgnomejercicio(Integer codEjercicioid, int cnuValorejercicio, boolean bolEstatus) {
        this.codEjercicioid = codEjercicioid;
        this.cnuValorejercicio = cnuValorejercicio;
        this.bolEstatus = bolEstatus;
    }

    public Integer getCodEjercicioid() {
        return codEjercicioid;
    }

    public void setCodEjercicioid(Integer codEjercicioid) {
        this.codEjercicioid = codEjercicioid;
    }

    public int getCnuValorejercicio() {
        return cnuValorejercicio;
    }

    public void setCnuValorejercicio(int cnuValorejercicio) {
        this.cnuValorejercicio = cnuValorejercicio;
    }

    public boolean getBolEstatus() {
        return bolEstatus;
    }

    public void setBolEstatus(boolean bolEstatus) {
        this.bolEstatus = bolEstatus;
    }

    @XmlTransient @JsonIgnore
    public List<Tsgnomquincena> getTsgnomquincenaList() {
        return tsgnomquincenaList;
    }

    public void setTsgnomquincenaList(List<Tsgnomquincena> tsgnomquincenaList) {
        this.tsgnomquincenaList = tsgnomquincenaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codEjercicioid != null ? codEjercicioid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tsgnomejercicio)) {
            return false;
        }
        Tsgnomejercicio other = (Tsgnomejercicio) object;
        if ((this.codEjercicioid == null && other.codEjercicioid != null) || (this.codEjercicioid != null && !this.codEjercicioid.equals(other.codEjercicioid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mbn.sinod.model.entidades.Tsgnomejercicio[ codEjercicioid=" + codEjercicioid + " ]";
    }
    
}
