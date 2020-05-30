/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
	import javax.persistence.GeneratedValue;
	import org.hibernate.annotations.GenericGenerator;
	import org.hibernate.annotations.Parameter;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ambrosio
 */
@Entity
@Table(name = "tsgnomfuncion", catalog = "suite", schema = "sgnom")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tsgnomfuncion.findAll", query = "SELECT t FROM Tsgnomfuncion t")})
public class Tsgnomfuncion implements Serializable {

    private static final long serialVersionUID = 1L;
    	@Id
	@GenericGenerator(name="argId", strategy="increment",parameters = { @Parameter(name = "schema", value = "sgnom") })
    @GeneratedValue(generator = "argId")
    @Basic(optional = false)
    @Column(name = "cod_funcionid")
    private Integer codFuncionid;
    @Basic(optional = false)
    @Column(name = "cod_nbfuncion")
    private String codNbfuncion;
    @Basic(optional = false)
    @Column(name = "bol_estatus")
    private boolean bolEstatus;

    public Tsgnomfuncion() {
    }

    public Tsgnomfuncion(Integer codFuncionid) {
        this.codFuncionid = codFuncionid;
    }

    public Tsgnomfuncion(Integer codFuncionid, String codNbfuncion, boolean bolEstatus) {
        this.codFuncionid = codFuncionid;
        this.codNbfuncion = codNbfuncion;
        this.bolEstatus = bolEstatus;
    }

    public Integer getCodFuncionid() {
        return codFuncionid;
    }

    public void setCodFuncionid(Integer codFuncionid) {
        this.codFuncionid = codFuncionid;
    }

    public String getCodNbfuncion() {
        return codNbfuncion;
    }

    public void setCodNbfuncion(String codNbfuncion) {
        this.codNbfuncion = codNbfuncion;
    }

    public boolean getBolEstatus() {
        return bolEstatus;
    }

    public void setBolEstatus(boolean bolEstatus) {
        this.bolEstatus = bolEstatus;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codFuncionid != null ? codFuncionid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tsgnomfuncion)) {
            return false;
        }
        Tsgnomfuncion other = (Tsgnomfuncion) object;
        if ((this.codFuncionid == null && other.codFuncionid != null) || (this.codFuncionid != null && !this.codFuncionid.equals(other.codFuncionid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mbn.sinod.model.entidades.Tsgnomfuncion[ codFuncionid=" + codFuncionid + " ]";
    }
    
}
