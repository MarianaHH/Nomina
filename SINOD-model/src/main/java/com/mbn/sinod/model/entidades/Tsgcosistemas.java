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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ambro
 */
@Entity
@Table(name = "tsgcosistemas", catalog = "suite", schema = "sgco")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tsgcosistemas.findAll", query = "SELECT t FROM Tsgcosistemas t")})
public class Tsgcosistemas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cod_sistema")
    private Integer codSistema;
    @Basic(optional = false)
    @Column(name = "des_nbsistema")
    private String desNbsistema;
    @Column(name = "des_descripcion")
    private String desDescripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codSistema", fetch = FetchType.LAZY)
    private List<Tsgcotipousuario> tsgcotipousuarioList;

    public Tsgcosistemas() {
    }

    public Tsgcosistemas(Integer codSistema) {
        this.codSistema = codSistema;
    }

    public Tsgcosistemas(Integer codSistema, String desNbsistema) {
        this.codSistema = codSistema;
        this.desNbsistema = desNbsistema;
    }

    public Integer getCodSistema() {
        return codSistema;
    }

    public void setCodSistema(Integer codSistema) {
        this.codSistema = codSistema;
    }

    public String getDesNbsistema() {
        return desNbsistema;
    }

    public void setDesNbsistema(String desNbsistema) {
        this.desNbsistema = desNbsistema;
    }

    public String getDesDescripcion() {
        return desDescripcion;
    }

    public void setDesDescripcion(String desDescripcion) {
        this.desDescripcion = desDescripcion;
    }

    @XmlTransient @JsonIgnore
    public List<Tsgcotipousuario> getTsgcotipousuarioList() {
        return tsgcotipousuarioList;
    }

    public void setTsgcotipousuarioList(List<Tsgcotipousuario> tsgcotipousuarioList) {
        this.tsgcotipousuarioList = tsgcotipousuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codSistema != null ? codSistema.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tsgcosistemas)) {
            return false;
        }
        Tsgcosistemas other = (Tsgcosistemas) object;
        if ((this.codSistema == null && other.codSistema != null) || (this.codSistema != null && !this.codSistema.equals(other.codSistema))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mbn.sinod.model.entidades.Tsgcosistemas[ codSistema=" + codSistema + " ]";
    }
    
}
