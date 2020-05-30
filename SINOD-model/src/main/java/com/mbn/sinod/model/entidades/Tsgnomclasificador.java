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
@Table(name = "tsgnomclasificador", catalog = "suite", schema = "sgnom")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tsgnomclasificador.findAll", query = "SELECT t FROM Tsgnomclasificador t")})
public class Tsgnomclasificador implements Serializable {

    private static final long serialVersionUID = 1L;
    	@Id
	@GenericGenerator(name="argId", strategy="increment",parameters = { @Parameter(name = "schema", value = "sgnom") })
    @GeneratedValue(generator = "argId")
    @Basic(optional = false)
    @Column(name = "cod_clasificadorid")
    private Integer codClasificadorid;
    @Column(name = "cod_tpclasificador")
    private String codTpclasificador;
    @Column(name = "bol_estatus")
    private Boolean bolEstatus;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codClasificadoridFk")
    private List<Tsgnomconcepto> tsgnomconceptoList;

    public Tsgnomclasificador() {
    }

    public Tsgnomclasificador(Integer codClasificadorid) {
        this.codClasificadorid = codClasificadorid;
    }

    public Integer getCodClasificadorid() {
        return codClasificadorid;
    }

    public void setCodClasificadorid(Integer codClasificadorid) {
        this.codClasificadorid = codClasificadorid;
    }

    public String getCodTpclasificador() {
        return codTpclasificador;
    }

    public void setCodTpclasificador(String codTpclasificador) {
        this.codTpclasificador = codTpclasificador;
    }

    public Boolean getBolEstatus() {
        return bolEstatus;
    }

    public void setBolEstatus(Boolean bolEstatus) {
        this.bolEstatus = bolEstatus;
    }

    @XmlTransient @JsonIgnore
    public List<Tsgnomconcepto> getTsgnomconceptoList() {
        return tsgnomconceptoList;
    }

    public void setTsgnomconceptoList(List<Tsgnomconcepto> tsgnomconceptoList) {
        this.tsgnomconceptoList = tsgnomconceptoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codClasificadorid != null ? codClasificadorid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tsgnomclasificador)) {
            return false;
        }
        Tsgnomclasificador other = (Tsgnomclasificador) object;
        if ((this.codClasificadorid == null && other.codClasificadorid != null) || (this.codClasificadorid != null && !this.codClasificadorid.equals(other.codClasificadorid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mbn.sinod.model.entidades.Tsgnomclasificador[ codClasificadorid=" + codClasificadorid + " ]";
    }
    
}
