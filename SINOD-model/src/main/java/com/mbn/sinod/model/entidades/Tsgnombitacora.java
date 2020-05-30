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
import javax.persistence.FetchType;
import javax.persistence.Id;
	import javax.persistence.GeneratedValue;
	import org.hibernate.annotations.GenericGenerator;
	import org.hibernate.annotations.Parameter;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ambrosio
 */
@Entity
@Table(name = "tsgnombitacora", catalog = "suite", schema = "sgnom")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tsgnombitacora.findAll", query = "SELECT t FROM Tsgnombitacora t")})
public class Tsgnombitacora implements Serializable {

    private static final long serialVersionUID = 1L;
    	@Id
	@GenericGenerator(name="argId", strategy="increment",parameters = { @Parameter(name = "schema", value = "sgnom") })
    @GeneratedValue(generator = "argId")
    @Basic(optional = false)
    @Column(name = "cod_bitacoraid")
    private Integer codBitacoraid;
    @Basic(optional = false)
    @Column(name = "xml_bitacora")
    private Serializable xmlBitacora;
    @JoinColumn(name = "cod_tablaid_fk", referencedColumnName = "cod_tablaid")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Tsgnomhisttabla codTablaidFk;

    public Tsgnombitacora() {
    }

    public Tsgnombitacora(Integer codBitacoraid) {
        this.codBitacoraid = codBitacoraid;
    }

    public Tsgnombitacora(Integer codBitacoraid, Serializable xmlBitacora) {
        this.codBitacoraid = codBitacoraid;
        this.xmlBitacora = xmlBitacora;
    }

    public Integer getCodBitacoraid() {
        return codBitacoraid;
    }

    public void setCodBitacoraid(Integer codBitacoraid) {
        this.codBitacoraid = codBitacoraid;
    }

    public Serializable getXmlBitacora() {
        return xmlBitacora;
    }

    public void setXmlBitacora(Serializable xmlBitacora) {
        this.xmlBitacora = xmlBitacora;
    }

    public Tsgnomhisttabla getCodTablaidFk() {
        return codTablaidFk;
    }

    public void setCodTablaidFk(Tsgnomhisttabla codTablaidFk) {
        this.codTablaidFk = codTablaidFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codBitacoraid != null ? codBitacoraid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tsgnombitacora)) {
            return false;
        }
        Tsgnombitacora other = (Tsgnombitacora) object;
        if ((this.codBitacoraid == null && other.codBitacoraid != null) || (this.codBitacoraid != null && !this.codBitacoraid.equals(other.codBitacoraid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mbn.sinod.model.entidades.Tsgnombitacora[ codBitacoraid=" + codBitacoraid + " ]";
    }
    
}
