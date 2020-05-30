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
import javax.persistence.Id;
	import javax.persistence.GeneratedValue;
	import org.hibernate.annotations.GenericGenerator;
	import org.hibernate.annotations.Parameter;
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
@Table(name = "tsgnomargumento", catalog = "suite", schema = "sgnom")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tsgnomargumento.findAll", query = "SELECT t FROM Tsgnomargumento t")})
public class Tsgnomargumento implements Serializable {

    private static final long serialVersionUID = 1L;
    	@Id
	@GenericGenerator(name="argId", strategy="increment",parameters = { @Parameter(name = "schema", value = "sgnom") })
    @GeneratedValue(generator = "argId")
    @Basic(optional = false)
    @Column(name = "cod_argumentoid")
    private Integer codArgumentoid;
    @Basic(optional = false)
    @Column(name = "cod_nbargumento")
    private String codNbargumento;
    @Basic(optional = false)
    @Column(name = "cod_clavearg")
    private String codClavearg;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "imp_valorconst")
    private BigDecimal impValorconst;
    @Column(name = "des_funcionbd")
    private String desFuncionbd;
    @Column(name = "cod_tipoargumento")
    private Character codTipoargumento;
    @Basic(optional = false)
    @Column(name = "bol_estatus")
    private boolean bolEstatus;
    @Basic(optional = false)
    @Column(name = "txt_descripcion")
    private String txtDescripcion;
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

    public Tsgnomargumento() {
    }

    public Tsgnomargumento(Integer codArgumentoid) {
        this.codArgumentoid = codArgumentoid;
    }

    public Tsgnomargumento(Integer codArgumentoid, String codNbargumento, String codClavearg, boolean bolEstatus, String txtDescripcion, int audCodcreadopor, Date audFeccreacion) {
        this.codArgumentoid = codArgumentoid;
        this.codNbargumento = codNbargumento;
        this.codClavearg = codClavearg;
        this.bolEstatus = bolEstatus;
        this.txtDescripcion = txtDescripcion;
        this.audCodcreadopor = audCodcreadopor;
        this.audFeccreacion = audFeccreacion;
    }

    public Integer getCodArgumentoid() {
        return codArgumentoid;
    }

    public void setCodArgumentoid(Integer codArgumentoid) {
        this.codArgumentoid = codArgumentoid;
    }

    public String getCodNbargumento() {
        return codNbargumento;
    }

    public void setCodNbargumento(String codNbargumento) {
        this.codNbargumento = codNbargumento;
    }

    public String getCodClavearg() {
        return codClavearg;
    }

    public void setCodClavearg(String codClavearg) {
        this.codClavearg = codClavearg;
    }

    public BigDecimal getImpValorconst() {
        return impValorconst;
    }

    public void setImpValorconst(BigDecimal impValorconst) {
        this.impValorconst = impValorconst;
    }

    public String getDesFuncionbd() {
        return desFuncionbd;
    }

    public void setDesFuncionbd(String desFuncionbd) {
        this.desFuncionbd = desFuncionbd;
    }

    public Character getCodTipoargumento() {
        return codTipoargumento;
    }

    public void setCodTipoargumento(Character codTipoargumento) {
        this.codTipoargumento = codTipoargumento;
    }

    public boolean getBolEstatus() {
        return bolEstatus;
    }

    public void setBolEstatus(boolean bolEstatus) {
        this.bolEstatus = bolEstatus;
    }

    public String getTxtDescripcion() {
        return txtDescripcion;
    }

    public void setTxtDescripcion(String txtDescripcion) {
        this.txtDescripcion = txtDescripcion;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codArgumentoid != null ? codArgumentoid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tsgnomargumento)) {
            return false;
        }
        Tsgnomargumento other = (Tsgnomargumento) object;
        if ((this.codArgumentoid == null && other.codArgumentoid != null) || (this.codArgumentoid != null && !this.codArgumentoid.equals(other.codArgumentoid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mbn.sinod.model.entidades.Tsgnomargumento[ codArgumentoid=" + codArgumentoid + " ]";
    }
    
}
