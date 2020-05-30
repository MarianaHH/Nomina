/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author ambrosio
 */
@Entity
@Table(name = "tsgnomquincena", catalog = "suite", schema = "sgnom")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tsgnomquincena.findAll", query = "SELECT t FROM Tsgnomquincena t")})
public class Tsgnomquincena implements Serializable {

    private static final long serialVersionUID = 1L;
    	@Id
	@GenericGenerator(name="argId", strategy="increment",parameters = { @Parameter(name = "schema", value = "sgnom") })
    @GeneratedValue(generator = "argId")
    @Basic(optional = false)
    @Column(name = "cod_quincenaid")
    private Integer codQuincenaid;
    @Basic(optional = false)
    @Column(name = "des_quincena")
    private String desQuincena;
    @Basic(optional = false)
    @Column(name = "fec_inicio")
    @Temporal(TemporalType.DATE)
    private Date fecInicio;
    @Basic(optional = false)
    @Column(name = "fec_fin")
    @Temporal(TemporalType.DATE)
    private Date fecFin;
    @Basic(optional = false)
    @Column(name = "fec_pago")
    @Temporal(TemporalType.DATE)
    private Date fecPago;
    @Basic(optional = false)
    @Column(name = "fec_dispersion")
    @Temporal(TemporalType.DATE)
    private Date fecDispersion;
    @Basic(optional = false)
    @Column(name = "cnu_numquincena")
    private int cnuNumquincena;
    @Basic(optional = false)
    @Column(name = "bol_estatus")
    private boolean bolEstatus;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codQuincenaidFk", fetch = FetchType.LAZY)
//    private List<Tsgnomincidencia> tsgnomincidenciaList;
    @OneToMany(mappedBy = "codQuincenafinFk", fetch = FetchType.LAZY)
    private List<Tsgnommanterceros> tsgnommantercerosList;
    @OneToMany(mappedBy = "codQuincenainicioFk", fetch = FetchType.LAZY)
    private List<Tsgnommanterceros> tsgnommantercerosList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codQuincenaidFk", fetch = FetchType.LAZY)
    private List<Tsgnomcabecera> tsgnomcabeceraList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codQuincenaidFk", fetch = FetchType.LAZY)
    private List<Tsgnomcabeceraht> tsgnomcabecerahtList;
    @JoinColumn(name = "cod_ejercicioid_fk", referencedColumnName = "cod_ejercicioid")
    @ManyToOne(optional = false)
    private Tsgnomejercicio codEjercicioidFk;

    public Tsgnomquincena() {
    }

    public Tsgnomquincena(Integer codQuincenaid) {
        this.codQuincenaid = codQuincenaid;
    }

    public Tsgnomquincena(Integer codQuincenaid, String desQuincena, Date fecInicio, Date fecFin, Date fecPago, Date fecDispersion, int cnuNumquincena, boolean bolEstatus) {
        this.codQuincenaid = codQuincenaid;
        this.desQuincena = desQuincena;
        this.fecInicio = fecInicio;
        this.fecFin = fecFin;
        this.fecPago = fecPago;
        this.fecDispersion = fecDispersion;
        this.cnuNumquincena = cnuNumquincena;
        this.bolEstatus = bolEstatus;
    }

    public Integer getCodQuincenaid() {
        return codQuincenaid;
    }

    public void setCodQuincenaid(Integer codQuincenaid) {
        this.codQuincenaid = codQuincenaid;
    }

    public String getDesQuincena() {
        return desQuincena;
    }

    public void setDesQuincena(String desQuincena) {
        this.desQuincena = desQuincena;
    }

    public Date getFecInicio() {
        return fecInicio;
    }

    public void setFecInicio(Date fecInicio) {
        this.fecInicio = fecInicio;
    }

    public Date getFecFin() {
        return fecFin;
    }

    public void setFecFin(Date fecFin) {
        this.fecFin = fecFin;
    }

    public Date getFecPago() {
        return fecPago;
    }

    public void setFecPago(Date fecPago) {
        this.fecPago = fecPago;
    }

    public Date getFecDispersion() {
        return fecDispersion;
    }

    public void setFecDispersion(Date fecDispersion) {
        this.fecDispersion = fecDispersion;
    }

    public int getCnuNumquincena() {
        return cnuNumquincena;
    }

    public void setCnuNumquincena(int cnuNumquincena) {
        this.cnuNumquincena = cnuNumquincena;
    }

    public boolean getBolEstatus() {
        return bolEstatus;
    }

    public void setBolEstatus(boolean bolEstatus) {
        this.bolEstatus = bolEstatus;
    }

//    @XmlTransient @JsonIgnore
//    public List<Tsgnomincidencia> getTsgnomincidenciaList() {
//        return tsgnomincidenciaList;
//    }
//
//    public void setTsgnomincidenciaList(List<Tsgnomincidencia> tsgnomincidenciaList) {
//        this.tsgnomincidenciaList = tsgnomincidenciaList;
//    }

    @XmlTransient @JsonIgnore
    public List<Tsgnommanterceros> getTsgnommantercerosList() {
        return tsgnommantercerosList;
    }

    public void setTsgnommantercerosList(List<Tsgnommanterceros> tsgnommantercerosList) {
        this.tsgnommantercerosList = tsgnommantercerosList;
    }

    @XmlTransient @JsonIgnore
    public List<Tsgnommanterceros> getTsgnommantercerosList1() {
        return tsgnommantercerosList1;
    }

    public void setTsgnommantercerosList1(List<Tsgnommanterceros> tsgnommantercerosList1) {
        this.tsgnommantercerosList1 = tsgnommantercerosList1;
    }

    @XmlTransient @JsonIgnore
    public List<Tsgnomcabecera> getTsgnomcabeceraList() {
        return tsgnomcabeceraList;
    }

    public void setTsgnomcabeceraList(List<Tsgnomcabecera> tsgnomcabeceraList) {
        this.tsgnomcabeceraList = tsgnomcabeceraList;
    }

    @XmlTransient @JsonIgnore
    public List<Tsgnomcabeceraht> getTsgnomcabecerahtList() {
        return tsgnomcabecerahtList;
    }

    public void setTsgnomcabecerahtList(List<Tsgnomcabeceraht> tsgnomcabecerahtList) {
        this.tsgnomcabecerahtList = tsgnomcabecerahtList;
    }

    public Tsgnomejercicio getCodEjercicioidFk() {
        return codEjercicioidFk;
    }

    public void setCodEjercicioidFk(Tsgnomejercicio codEjercicioidFk) {
        this.codEjercicioidFk = codEjercicioidFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codQuincenaid != null ? codQuincenaid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tsgnomquincena)) {
            return false;
        }
        Tsgnomquincena other = (Tsgnomquincena) object;
        if ((this.codQuincenaid == null && other.codQuincenaid != null) || (this.codQuincenaid != null && !this.codQuincenaid.equals(other.codQuincenaid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mbn.sinod.model.entidades.Tsgnomquincena[ codQuincenaid=" + codQuincenaid + " ]";
    }
    
}
