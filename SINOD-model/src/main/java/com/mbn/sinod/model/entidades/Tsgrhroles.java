/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ivette
 */
@Entity
@Table(name = "tsgrhroles", catalog = "suite", schema = "sgrh")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tsgrhroles.findAll", query = "SELECT t FROM Tsgrhroles t")})
public class Tsgrhroles implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cod_rol")
    private Integer codRol;
    @Basic(optional = false)
    @Column(name = "des_nbrol")
    private String desNbrol;
    @OneToMany(mappedBy = "codRol", fetch = FetchType.LAZY)
    private List<Tsgrhempleados> tsgrhempleadosList;

    public Tsgrhroles() {
    }

    public Tsgrhroles(Integer codRol) {
        this.codRol = codRol;
    }

    public Tsgrhroles(Integer codRol, String desNbrol) {
        this.codRol = codRol;
        this.desNbrol = desNbrol;
    }

    public Integer getCodRol() {
        return codRol;
    }

    public void setCodRol(Integer codRol) {
        this.codRol = codRol;
    }

    public String getDesNbrol() {
        return desNbrol;
    }

    public void setDesNbrol(String desNbrol) {
        this.desNbrol = desNbrol;
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
        hash += (codRol != null ? codRol.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tsgrhroles)) {
            return false;
        }
        Tsgrhroles other = (Tsgrhroles) object;
        if ((this.codRol == null && other.codRol != null) || (this.codRol != null && !this.codRol.equals(other.codRol))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mbn.sinod.model.entidades.Tsgrhroles[ codRol=" + codRol + " ]";
    }
    
}
