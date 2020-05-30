/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 *
 * @author ambrosio
 */
@Entity
@Table(name = "tsgnomcatincidencia", catalog = "suite", schema = "sgnom")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tsgnomcatincidencia.findAll", query = "SELECT t FROM Tsgnomcatincidencia t")})
public class Tsgnomcatincidencia implements Serializable {

    private static final long serialVersionUID = 1L;
    	@Id
	@GenericGenerator(name="argId", strategy="increment",parameters = { @Parameter(name = "schema", value = "sgnom") })
    @GeneratedValue(generator = "argId")
    @Basic(optional = false)
    @Column(name = "cod_catincidenciaid")
    private Integer codCatincidenciaid;
    @Column(name = "cod_claveincidencia")
    private String codClaveincidencia;
    @Column(name = "cod_nbincidencia")
    private String codNbincidencia;
    @Column(name = "cod_perfilincidencia")
    private String codPerfilincidencia;
    @Column(name = "bol_estatus")
    private Boolean bolEstatus;
    @Column(name = "cod_tipoincidencia")
    private Character codTipoincidencia;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "imp_monto")
    private BigDecimal impMonto;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codCatincidenciaidFk")
//    private List<Tsgnomincidencia> tsgnomincidenciaList;

    public Tsgnomcatincidencia() {
    }

    public Tsgnomcatincidencia(Integer codCatincidenciaid) {
        this.codCatincidenciaid = codCatincidenciaid;
    }

    public Integer getCodCatincidenciaid() {
        return codCatincidenciaid;
    }

    public void setCodCatincidenciaid(Integer codCatincidenciaid) {
        this.codCatincidenciaid = codCatincidenciaid;
    }

    public String getCodClaveincidencia() {
        return codClaveincidencia;
    }

    public void setCodClaveincidencia(String codClaveincidencia) {
        this.codClaveincidencia = codClaveincidencia;
    }

    public String getCodNbincidencia() {
        return codNbincidencia;
    }

    public void setCodNbincidencia(String codNbincidencia) {
        this.codNbincidencia = codNbincidencia;
    }

    public String getCodPerfilincidencia() {
        return codPerfilincidencia;
    }

    public void setCodPerfilincidencia(String codPerfilincidencia) {
        this.codPerfilincidencia = codPerfilincidencia;
    }

    public Boolean getBolEstatus() {
        return bolEstatus;
    }

    public void setBolEstatus(Boolean bolEstatus) {
        this.bolEstatus = bolEstatus;
    }

    public Character getCodTipoincidencia() {
        return codTipoincidencia;
    }

    public void setCodTipoincidencia(Character codTipoincidencia) {
        this.codTipoincidencia = codTipoincidencia;
    }

    public BigDecimal getImpMonto() {
        return impMonto;
    }

    public void setImpMonto(BigDecimal impMonto) {
        this.impMonto = impMonto;
    }

//    @XmlTransient @JsonIgnore
//    public List<Tsgnomincidencia> getTsgnomincidenciaList() {
//        return tsgnomincidenciaList;
//    }
//
//    public void setTsgnomincidenciaList(List<Tsgnomincidencia> tsgnomincidenciaList) {
//        this.tsgnomincidenciaList = tsgnomincidenciaList;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codCatincidenciaid != null ? codCatincidenciaid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tsgnomcatincidencia)) {
            return false;
        }
        Tsgnomcatincidencia other = (Tsgnomcatincidencia) object;
        if ((this.codCatincidenciaid == null && other.codCatincidenciaid != null) || (this.codCatincidenciaid != null && !this.codCatincidenciaid.equals(other.codCatincidenciaid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mbn.sinod.model.entidades.Tsgnomcatincidencia[ codCatincidenciaid=" + codCatincidenciaid + " ]";
    }
    
}
