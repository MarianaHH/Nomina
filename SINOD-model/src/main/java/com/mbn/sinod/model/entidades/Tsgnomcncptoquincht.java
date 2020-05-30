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
@Table(name = "tsgnomcncptoquincht", catalog = "suite", schema = "sgnom")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tsgnomcncptoquincht.findAll", query = "SELECT t FROM Tsgnomcncptoquincht t")})
public class Tsgnomcncptoquincht implements Serializable {

    private static final long serialVersionUID = 1L;
    	@Id
	@GenericGenerator(name="argId", strategy="increment",parameters = { @Parameter(name = "schema", value = "sgnom") })
    @GeneratedValue(generator = "argId")
    @Basic(optional = false)
    @Column(name = "cod_cncptoquinchtid")
    private Integer codCncptoquinchtid;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "imp_concepto")
    private BigDecimal impConcepto;
    @Column(name = "imp_gravado")
    private BigDecimal impGravado;
    @Column(name = "imp_exento")
    private BigDecimal impExento;
    @Column(name = "xml_desgloce")
    private Serializable xmlDesgloce;
    @JoinColumn(name = "cod_conceptoid_fk", referencedColumnName = "cod_conceptoid")
    @ManyToOne(optional = false)
    private Tsgnomconcepto codConceptoidFk;
    @JoinColumn(name = "cod_empquincenaid_fk", referencedColumnName = "cod_empquincenaid")
    @ManyToOne(optional = false)
    private Tsgnomempquincena codEmpquincenaidFk;

    public Tsgnomcncptoquincht() {
    }

    public Tsgnomcncptoquincht(Integer codCncptoquinchtid) {
        this.codCncptoquinchtid = codCncptoquinchtid;
    }

    public Tsgnomcncptoquincht(Integer codCncptoquinchtid, BigDecimal impConcepto) {
        this.codCncptoquinchtid = codCncptoquinchtid;
        this.impConcepto = impConcepto;
    }

    public Integer getCodCncptoquinchtid() {
        return codCncptoquinchtid;
    }

    public void setCodCncptoquinchtid(Integer codCncptoquinchtid) {
        this.codCncptoquinchtid = codCncptoquinchtid;
    }

    public BigDecimal getImpConcepto() {
        return impConcepto;
    }

    public void setImpConcepto(BigDecimal impConcepto) {
        this.impConcepto = impConcepto;
    }

    public BigDecimal getImpGravado() {
        return impGravado;
    }

    public void setImpGravado(BigDecimal impGravado) {
        this.impGravado = impGravado;
    }

    public BigDecimal getImpExento() {
        return impExento;
    }

    public void setImpExento(BigDecimal impExento) {
        this.impExento = impExento;
    }

    public Serializable getXmlDesgloce() {
        return xmlDesgloce;
    }

    public void setXmlDesgloce(Serializable xmlDesgloce) {
        this.xmlDesgloce = xmlDesgloce;
    }

    public Tsgnomconcepto getCodConceptoidFk() {
        return codConceptoidFk;
    }

    public void setCodConceptoidFk(Tsgnomconcepto codConceptoidFk) {
        this.codConceptoidFk = codConceptoidFk;
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
        hash += (codCncptoquinchtid != null ? codCncptoquinchtid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tsgnomcncptoquincht)) {
            return false;
        }
        Tsgnomcncptoquincht other = (Tsgnomcncptoquincht) object;
        if ((this.codCncptoquinchtid == null && other.codCncptoquinchtid != null) || (this.codCncptoquinchtid != null && !this.codCncptoquinchtid.equals(other.codCncptoquinchtid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mbn.sinod.model.entidades.Tsgnomcncptoquincht[ codCncptoquinchtid=" + codCncptoquinchtid + " ]";
    }
    
}
