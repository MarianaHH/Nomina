/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.entidades;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ambrosio
 */
@Entity
@Table(name = "tsgnomcabeceraht", catalog = "suite", schema = "sgnom")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tsgnomcabeceraht.findAll", query = "SELECT t FROM Tsgnomcabeceraht t")})
public class Tsgnomcabeceraht implements Serializable {

    private static final long serialVersionUID = 1L;
    	@Id
	@GenericGenerator(name="argId", strategy="increment",parameters = { @Parameter(name = "schema", value = "sgnom") })
    @GeneratedValue(generator = "argId")
    @Basic(optional = false)
    @Column(name = "cod_cabeceraid")
    private Integer codCabeceraid;
    @Basic(optional = false)
    @Column(name = "cod_nbnomina")
    private String codNbnomina;
    @Basic(optional = false)
    @Column(name = "fec_creacion")
    @Temporal(TemporalType.DATE)
    private Date fecCreacion;
    @Column(name = "fec_ejecucion")
    @Temporal(TemporalType.DATE)
    private Date fecEjecucion;
    @Column(name = "fec_cierre")
    @Temporal(TemporalType.DATE)
    private Date fecCierre;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "imp_totpercepcion")
    private BigDecimal impTotpercepcion;
    @Column(name = "imp_totdeduccion")
    private BigDecimal impTotdeduccion;
    @Column(name = "imp_totalemp")
    private BigDecimal impTotalemp;
    @Column(name = "cnu_totalemp")
    private Integer cnuTotalemp;
    @Basic(optional = false)
    @Column(name = "aud_codcreadopor")
    private int audCodcreadopor;
    @Column(name = "aud_codmodificadopor")
    private Integer audCodmodificadopor;
    @Basic(optional = false)
    @Column(name = "aud_feccreacion")
    @Temporal(TemporalType.DATE)
    private Date audFeccreacion;
    @Column(name = "aud_fecmodificacion")
    @Temporal(TemporalType.DATE)
    private Date audFecmodificacion;
    @JoinColumn(name = "cod_estatusnomid_fk", referencedColumnName = "cod_estatusnomid")
    @ManyToOne(optional = false)
    private Tsgnomestatusnom codEstatusnomidFk;
    @JoinColumn(name = "cod_quincenaid_fk", referencedColumnName = "cod_quincenaid")
    @ManyToOne(optional = false)
    private Tsgnomquincena codQuincenaidFk;
    @JoinColumn(name = "cod_tiponominaid_fk", referencedColumnName = "cod_tiponominaid")
    @ManyToOne(optional = false)
    private Tsgnomtiponomina codTiponominaidFk;

    public Tsgnomcabeceraht() {
    }

    public Tsgnomcabeceraht(Integer codCabeceraid) {
        this.codCabeceraid = codCabeceraid;
    }

    public Tsgnomcabeceraht(Integer codCabeceraid, String codNbnomina, Date fecCreacion, int audCodcreadopor, Date audFeccreacion) {
        this.codCabeceraid = codCabeceraid;
        this.codNbnomina = codNbnomina;
        this.fecCreacion = fecCreacion;
        this.audCodcreadopor = audCodcreadopor;
        this.audFeccreacion = audFeccreacion;
    }

    public Integer getCodCabeceraid() {
        return codCabeceraid;
    }

    public void setCodCabeceraid(Integer codCabeceraid) {
        this.codCabeceraid = codCabeceraid;
    }

    public String getCodNbnomina() {
        return codNbnomina;
    }

    public void setCodNbnomina(String codNbnomina) {
        this.codNbnomina = codNbnomina;
    }

    public Date getFecCreacion() {
        return fecCreacion;
    }

    public void setFecCreacion(Date fecCreacion) {
        this.fecCreacion = fecCreacion;
    }

    public Date getFecEjecucion() {
        return fecEjecucion;
    }

    public void setFecEjecucion(Date fecEjecucion) {
        this.fecEjecucion = fecEjecucion;
    }

    public Date getFecCierre() {
        return fecCierre;
    }

    public void setFecCierre(Date fecCierre) {
        this.fecCierre = fecCierre;
    }

    public BigDecimal getImpTotpercepcion() {
        return impTotpercepcion;
    }

    public void setImpTotpercepcion(BigDecimal impTotpercepcion) {
        this.impTotpercepcion = impTotpercepcion;
    }

    public BigDecimal getImpTotdeduccion() {
        return impTotdeduccion;
    }

    public void setImpTotdeduccion(BigDecimal impTotdeduccion) {
        this.impTotdeduccion = impTotdeduccion;
    }

    public BigDecimal getImpTotalemp() {
        return impTotalemp;
    }

    public void setImpTotalemp(BigDecimal impTotalemp) {
        this.impTotalemp = impTotalemp;
    }

    public Integer getCnuTotalemp() {
        return cnuTotalemp;
    }

    public void setCnuTotalemp(Integer cnuTotalemp) {
        this.cnuTotalemp = cnuTotalemp;
    }

    public int getAudCodcreadopor() {
        return audCodcreadopor;
    }

    public void setAudCodcreadopor(int audCodcreadopor) {
        this.audCodcreadopor = audCodcreadopor;
    }

    public Integer getAudCodmodificadopor() {
        return audCodmodificadopor;
    }

    public void setAudCodmodificadopor(Integer audCodmodificadopor) {
        this.audCodmodificadopor = audCodmodificadopor;
    }

    public Date getAudFeccreacion() {
        return audFeccreacion;
    }

    public void setAudFeccreacion(Date audFeccreacion) {
        this.audFeccreacion = audFeccreacion;
    }

    public Date getAudFecmodificacion() {
        return audFecmodificacion;
    }

    public void setAudFecmodificacion(Date audFecmodificacion) {
        this.audFecmodificacion = audFecmodificacion;
    }

    public Tsgnomestatusnom getCodEstatusnomidFk() {
        return codEstatusnomidFk;
    }

    public void setCodEstatusnomidFk(Tsgnomestatusnom codEstatusnomidFk) {
        this.codEstatusnomidFk = codEstatusnomidFk;
    }

    public Tsgnomquincena getCodQuincenaidFk() {
        return codQuincenaidFk;
    }

    public void setCodQuincenaidFk(Tsgnomquincena codQuincenaidFk) {
        this.codQuincenaidFk = codQuincenaidFk;
    }

    public Tsgnomtiponomina getCodTiponominaidFk() {
        return codTiponominaidFk;
    }

    public void setCodTiponominaidFk(Tsgnomtiponomina codTiponominaidFk) {
        this.codTiponominaidFk = codTiponominaidFk;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codCabeceraid != null ? codCabeceraid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tsgnomcabeceraht)) {
            return false;
        }
        Tsgnomcabeceraht other = (Tsgnomcabeceraht) object;
        if ((this.codCabeceraid == null && other.codCabeceraid != null) || (this.codCabeceraid != null && !this.codCabeceraid.equals(other.codCabeceraid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mbn.sinod.model.entidades.Tsgnomcabeceraht[ codCabeceraid=" + codCabeceraid + " ]";
    }
    
}
