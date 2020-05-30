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
import javax.persistence.GenerationType;
import javax.persistence.Id;
	import javax.persistence.GeneratedValue;
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
@Table(name = "tsgrhareas", catalog = "suite", schema = "sgrh")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tsgrhareas.findAll", query = "SELECT t FROM Tsgrhareas t")})
public class Tsgrhareas implements Serializable {

    private static final long serialVersionUID = 1L;
    	@Id
	
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_area")
    private Integer codArea;
    @Basic(optional = false)
    @Column(name = "des_nbarea")
    private String desNbarea;
    @Basic(optional = false)
    @Column(name = "cod_acronimo")
    private String codAcronimo;
    @Basic(optional = false)
    @Column(name = "cnu_activo")
    private boolean cnuActivo;
    @Column(name = "cod_sistemasuite")
    private Integer codSistemasuite;
//    @Column(name = "cod_creadopor")
//    private Integer codCreadopor;
//    @Column(name = "cod_modificadopor")
//    private Integer codModificadopor;
//    @Column(name = "fec_creacion")
//    @Temporal(TemporalType.DATE)
//    private Date fecCreacion;
//    @Column(name = "fec_modificacion")
//    @Temporal(TemporalType.DATE)
//    private Date fecModificacion;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codArea", fetch = FetchType.LAZY)
//    private List<Tsgrhpuestos> tsgrhpuestosList;

    public Tsgrhareas() {
    }

    public Tsgrhareas(Integer codArea) {
        this.codArea = codArea;
    }

    public Tsgrhareas(Integer codArea, String desNbarea, String codAcronimo, boolean cnuActivo) {
        this.codArea = codArea;
        this.desNbarea = desNbarea;
        this.codAcronimo = codAcronimo;
        this.cnuActivo = cnuActivo;
    }

    public Integer getCodArea() {
        return codArea;
    }

    public void setCodArea(Integer codArea) {
        this.codArea = codArea;
    }

    public String getDesNbarea() {
        return desNbarea;
    }

    public void setDesNbarea(String desNbarea) {
        this.desNbarea = desNbarea;
    }

    public String getCodAcronimo() {
        return codAcronimo;
    }

    public void setCodAcronimo(String codAcronimo) {
        this.codAcronimo = codAcronimo;
    }

    public boolean getCnuActivo() {
        return cnuActivo;
    }

    public void setCnuActivo(boolean cnuActivo) {
        this.cnuActivo = cnuActivo;
    }

    public Integer getCodSistemasuite() {
        return codSistemasuite;
    }

    public void setCodSistemasuite(Integer codSistemasuite) {
        this.codSistemasuite = codSistemasuite;
    }

//    public Integer getCodCreadopor() {
//        return codCreadopor;
//    }
//
//    public void setCodCreadopor(Integer codCreadopor) {
//        this.codCreadopor = codCreadopor;
//    }
//
//    public Integer getCodModificadopor() {
//        return codModificadopor;
//    }
//
//    public void setCodModificadopor(Integer codModificadopor) {
//        this.codModificadopor = codModificadopor;
//    }
//
//    public Date getFecCreacion() {
//        return fecCreacion;
//    }
//
//    public void setFecCreacion(Date fecCreacion) {
//        this.fecCreacion = fecCreacion;
//    }
//
//    public Date getFecModificacion() {
//        return fecModificacion;
//    }
//
//    public void setFecModificacion(Date fecModificacion) {
//        this.fecModificacion = fecModificacion;
//    }

//    @XmlTransient
//    @JsonIgnore
//    public List<Tsgrhpuestos> getTsgrhpuestosList() {
//        return tsgrhpuestosList;
//    }
//
//    public void setTsgrhpuestosList(List<Tsgrhpuestos> tsgrhpuestosList) {
//        this.tsgrhpuestosList = tsgrhpuestosList;
//    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codArea != null ? codArea.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tsgrhareas)) {
            return false;
        }
        Tsgrhareas other = (Tsgrhareas) object;
        if ((this.codArea == null && other.codArea != null) || (this.codArea != null && !this.codArea.equals(other.codArea))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mbn.sinod.model.entidades.Tsgrhareas[ codArea=" + codArea + " ]";
    }

}
