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
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
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
@Table(name = "tsgrhpuestos", catalog = "suite", schema = "sgrh")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tsgrhpuestos.findAll", query = "SELECT t FROM Tsgrhpuestos t")})
public class Tsgrhpuestos implements Serializable {

    private static final long serialVersionUID = 1L;
    	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_puesto")
    private Integer codPuesto;
    @Basic(optional = false)
    @Column(name = "des_puesto")
    private String desPuesto;
    @Column(name = "cod_acronimo")
    private String codAcronimo;
    @JoinColumn(name = "cod_area", referencedColumnName = "cod_area")
    @ManyToOne(optional = false)
    private Tsgrhareas codArea;
    @OneToMany(mappedBy = "codPuesto", fetch = FetchType.LAZY)
    private List<Tsgrhempleados> tsgrhempleadosList;

    public Tsgrhpuestos() {
    }

    public Tsgrhpuestos(Integer codPuesto) {
        this.codPuesto = codPuesto;
    }

    public Tsgrhpuestos(Integer codPuesto, String desPuesto) {
        this.codPuesto = codPuesto;
        this.desPuesto = desPuesto;
    }

    public Integer getCodPuesto() {
        return codPuesto;
    }

    public void setCodPuesto(Integer codPuesto) {
        this.codPuesto = codPuesto;
    }

    public String getDesPuesto() {
        return desPuesto;
    }

    public void setDesPuesto(String desPuesto) {
        this.desPuesto = desPuesto;
    }

    public String getCodAcronimo() {
        return codAcronimo;
    }

    public void setCodAcronimo(String codAcronimo) {
        this.codAcronimo = codAcronimo;
    }

    public Tsgrhareas getCodArea() {
        return codArea;
    }

    public void setCodArea(Tsgrhareas codArea) {
        this.codArea = codArea;
    }
    @XmlTransient
    @JsonIgnore
    public List<Tsgrhempleados> getTsgrhempleadosList() {
        return tsgrhempleadosList;
    }

    public void setTsgrhempleadosList(List<Tsgrhempleados> tsgrhempleadosList) {
        this.tsgrhempleadosList = tsgrhempleadosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codPuesto != null ? codPuesto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tsgrhpuestos)) {
            return false;
        }
        Tsgrhpuestos other = (Tsgrhpuestos) object;
        if ((this.codPuesto == null && other.codPuesto != null) || (this.codPuesto != null && !this.codPuesto.equals(other.codPuesto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mbn.sinod.model.entidades.Tsgrhpuestos[ codPuesto=" + codPuesto + " ]";
    }

}
