/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "tsgnomalguinaldo", catalog = "suite", schema = "sgnom")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tsgnomalguinaldo.findAll", query = "SELECT t FROM Tsgnomalguinaldo t")})
public class Tsgnomalguinaldo implements Serializable {

    private static final long serialVersionUID = 1L;
    	@Id
	@GenericGenerator(name="argId", strategy="increment",parameters = { @Parameter(name = "schema", value = "sgnom") })
    @GeneratedValue(generator = "argId")
    @Basic(optional = false)
    @Column(name = "cod_aguinaldoid")
    private Integer codAguinaldoid;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "imp_aguinaldo")
    private BigDecimal impAguinaldo;
    @Basic(optional = false)
    @Column(name = "cod_tipoaguinaldo")
    private Character codTipoaguinaldo;
    @Basic(optional = false)
    @Column(name = "bol_estatus")
    private boolean bolEstatus;
    @Column(name = "xml_desgloce", columnDefinition = "XMLType")
    private String xmlDesgloce;
    @JoinColumn(name = "cod_empquincenaid_fk", referencedColumnName = "cod_empquincenaid")
    @ManyToOne(optional = false)
    private Tsgnomempquincena codEmpquincenaidFk;

    public Tsgnomalguinaldo() {
    }

    public Tsgnomalguinaldo(Integer codAguinaldoid) {
        this.codAguinaldoid = codAguinaldoid;
    }

    public Tsgnomalguinaldo(Integer codAguinaldoid, BigDecimal impAguinaldo, Character codTipoaguinaldo, boolean bolEstatus) {
        this.codAguinaldoid = codAguinaldoid;
        this.impAguinaldo = impAguinaldo;
        this.codTipoaguinaldo = codTipoaguinaldo;
        this.bolEstatus = bolEstatus;
    }

    public Integer getCodAguinaldoid() {
        return codAguinaldoid;
    }

    public void setCodAguinaldoid(Integer codAguinaldoid) {
        this.codAguinaldoid = codAguinaldoid;
    }

    public BigDecimal getImpAguinaldo() {
        return impAguinaldo;
    }

    public void setImpAguinaldo(BigDecimal impAguinaldo) {
        this.impAguinaldo = impAguinaldo;
    }

    public Character getCodTipoaguinaldo() {
        return codTipoaguinaldo;
    }

    public void setCodTipoaguinaldo(Character codTipoaguinaldo) {
        this.codTipoaguinaldo = codTipoaguinaldo;
    }

    public boolean getBolEstatus() {
        return bolEstatus;
    }

    public void setBolEstatus(boolean bolEstatus) {
        this.bolEstatus = bolEstatus;
    }

    public String getXmlDesgloce() {
        return xmlDesgloce;
    }

    public void setXmlDesgloce(String xmlDesgloce) {
        this.xmlDesgloce = xmlDesgloce;
    }

    public Tsgnomempquincena getCodEmpquincenaidFk() {
        return codEmpquincenaidFk;
    }

    public void setCodEmpquincenaidFk(Tsgnomempquincena codEmpquincenaidFk) {
        this.codEmpquincenaidFk = codEmpquincenaidFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codAguinaldoid != null ? codAguinaldoid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tsgnomalguinaldo)) {
            return false;
        }
        Tsgnomalguinaldo other = (Tsgnomalguinaldo) object;
        if ((this.codAguinaldoid == null && other.codAguinaldoid != null) || (this.codAguinaldoid != null && !this.codAguinaldoid.equals(other.codAguinaldoid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mbn.sinod.model.entidades.Tsgnomalguinaldo[ codAguinaldoid=" + codAguinaldoid + " ]";
    }
    
}
