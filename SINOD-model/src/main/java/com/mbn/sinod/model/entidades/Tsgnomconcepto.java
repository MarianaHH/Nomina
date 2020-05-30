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
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 *
 * @author ambrosio
 */
@Entity
@Table(name = "tsgnomconcepto", catalog = "suite", schema = "sgnom")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tsgnomconcepto.findAll", query = "SELECT t FROM Tsgnomconcepto t")})
public class Tsgnomconcepto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GenericGenerator(name = "argId", strategy = "increment", parameters = {
        @Parameter(name = "schema", value = "sgnom")})
    @GeneratedValue(generator = "argId")
    @Basic(optional = false)
    @Column(name = "cod_conceptoid")
    private Integer codConceptoid;
    @Basic(optional = false)
    @Column(name = "cod_nbconcepto")
    private String codNbconcepto;
    @Basic(optional = false)
    @Column(name = "cod_claveconcepto")
    private String codClaveconcepto;
    @Basic(optional = false)
    @Column(name = "cnu_prioricalculo")
    private int cnuPrioricalculo;
    @Basic(optional = false)
    @Column(name = "cnu_articulo")
    private int cnuArticulo;
    @Basic(optional = false)
    @Column(name = "bol_estatus")
    private boolean bolEstatus;
    @Basic(optional = false)
    @Column(name = "cod_frecuenciapago")
    private String codFrecuenciapago;
    @Basic(optional = false)
    @Column(name = "cod_partidaprep")
    private int codPartidaprep;
    @Basic(optional = false)
    @Column(name = "cnu_cuentacontable")
    private String cnuCuentacontable;
    @Column(name = "cod_gravado")
    private Character codGravado;
    @Column(name = "cod_excento")
    private Character codExcento;
    @Column(name = "bol_aplicaisn")
    private Boolean bolAplicaisn;
    @Basic(optional = false)
    @Column(name = "bol_retroactividad")
    private boolean bolRetroactividad;
    @Column(name = "cnu_topeex")
    private Integer cnuTopeex;
    @Column(name = "imp_monto")
    private Double impMonto;
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
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codConceptoidFk", fetch = FetchType.LAZY)
    private List<Tsgnomcncptoquincht> tsgnomcncptoquinchtList;
    @JoinColumn(name = "cod_calculoid_fk", referencedColumnName = "cod_calculoid")
    @ManyToOne(optional = false)
    private Tsgnomcalculo codCalculoidFk;
    @JoinColumn(name = "cod_clasificadorid_fk", referencedColumnName = "cod_clasificadorid")
    @ManyToOne(optional = false)
    private Tsgnomclasificador codClasificadoridFk;
    @JoinColumn(name = "cod_conceptosatid_fk", referencedColumnName = "cod_conceptosatid")
    @ManyToOne(optional = false)
    private Tsgnomconceptosat codConceptosatidFk;
    @JoinColumn(name = "cod_formulaid_fk", referencedColumnName = "cod_formulaid")
    @ManyToOne()
    private Tsgnomformula codFormulaidFk;
    @JoinColumn(name = "cod_tipoconceptoid_fk", referencedColumnName = "cod_tipoconceptoid")
    @ManyToOne(optional = false)
    private Tsgnomtipoconcepto codTipoconceptoidFk;
    @JoinColumn(name = "cod_tiponominaid_fk", referencedColumnName = "cod_tiponominaid")
    @ManyToOne()
    private Tsgnomtiponomina codTiponominaidFk;
    @OneToMany(mappedBy = "codConceptoidFk", fetch = FetchType.LAZY)
    private List<Tsgnommanterceros> tsgnommantercerosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codConceptoidFk", fetch = FetchType.LAZY)
    private List<Tsgnomcncptoquinc> tsgnomcncptoquincList;

    public Tsgnomconcepto() {
    }

    public Tsgnomconcepto(Integer codConceptoid) {
        this.codConceptoid = codConceptoid;
    }

    public Tsgnomconcepto(Integer codConceptoid, String codNbconcepto, String codClaveconcepto, int cnuPrioricalculo, int cnuArticulo, boolean bolEstatus, String codFrecuenciapago, int codPartidaprep, String cnuCuentacontable, boolean bolRetroactividad, int audCodcreadopor, Date audFeccreacion) {
        this.codConceptoid = codConceptoid;
        this.codNbconcepto = codNbconcepto;
        this.codClaveconcepto = codClaveconcepto;
        this.cnuPrioricalculo = cnuPrioricalculo;
        this.cnuArticulo = cnuArticulo;
        this.bolEstatus = bolEstatus;
        this.codFrecuenciapago = codFrecuenciapago;
        this.codPartidaprep = codPartidaprep;
        this.cnuCuentacontable = cnuCuentacontable;
        this.bolRetroactividad = bolRetroactividad;
        this.audCodcreadopor = audCodcreadopor;
        this.audFeccreacion = audFeccreacion;
    }

    public Integer getCodConceptoid() {
        return codConceptoid;
    }

    public void setCodConceptoid(Integer codConceptoid) {
        this.codConceptoid = codConceptoid;
    }

    public String getCodNbconcepto() {
        return codNbconcepto;
    }

    public void setCodNbconcepto(String codNbconcepto) {
        this.codNbconcepto = codNbconcepto;
    }

    public String getCodClaveconcepto() {
        return codClaveconcepto;
    }

    public void setCodClaveconcepto(String codClaveconcepto) {
        this.codClaveconcepto = codClaveconcepto;
    }

    public int getCnuPrioricalculo() {
        return cnuPrioricalculo;
    }

    public void setCnuPrioricalculo(int cnuPrioricalculo) {
        this.cnuPrioricalculo = cnuPrioricalculo;
    }

    public int getCnuArticulo() {
        return cnuArticulo;
    }

    public void setCnuArticulo(int cnuArticulo) {
        this.cnuArticulo = cnuArticulo;
    }

    public boolean getBolEstatus() {
        return bolEstatus;
    }

    public void setBolEstatus(boolean bolEstatus) {
        this.bolEstatus = bolEstatus;
    }

    public String getCodFrecuenciapago() {
        return codFrecuenciapago;
    }

    public void setCodFrecuenciapago(String codFrecuenciapago) {
        this.codFrecuenciapago = codFrecuenciapago;
    }

    public int getCodPartidaprep() {
        return codPartidaprep;
    }

    public void setCodPartidaprep(int codPartidaprep) {
        this.codPartidaprep = codPartidaprep;
    }

    public String getCnuCuentacontable() {
        return cnuCuentacontable;
    }

    public void setCnuCuentacontable(String cnuCuentacontable) {
        this.cnuCuentacontable = cnuCuentacontable;
    }

    public Character getCodGravado() {
        return codGravado;
    }

    public void setCodGravado(Character codGravado) {
        this.codGravado = codGravado;
    }

    public Character getCodExcento() {
        return codExcento;
    }

    public void setCodExcento(Character codExcento) {
        this.codExcento = codExcento;
    }

    public Boolean getBolAplicaisn() {
        return bolAplicaisn;
    }

    public void setBolAplicaisn(Boolean bolAplicaisn) {
        this.bolAplicaisn = bolAplicaisn;
    }

    public boolean getBolRetroactividad() {
        return bolRetroactividad;
    }

    public void setBolRetroactividad(boolean bolRetroactividad) {
        this.bolRetroactividad = bolRetroactividad;
    }

    public Integer getCnuTopeex() {
        return cnuTopeex;
    }

    public void setCnuTopeex(Integer cnuTopeex) {
        this.cnuTopeex = cnuTopeex;
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

    @XmlTransient
    @JsonIgnore
    public List<Tsgnomcncptoquincht> getTsgnomcncptoquinchtList() {
        return tsgnomcncptoquinchtList;
    }

    public void setTsgnomcncptoquinchtList(List<Tsgnomcncptoquincht> tsgnomcncptoquinchtList) {
        this.tsgnomcncptoquinchtList = tsgnomcncptoquinchtList;
    }

    public Tsgnomcalculo getCodCalculoidFk() {
        return codCalculoidFk;
    }

    public void setCodCalculoidFk(Tsgnomcalculo codCalculoidFk) {
        this.codCalculoidFk = codCalculoidFk;
    }

    public Tsgnomclasificador getCodClasificadoridFk() {
        return codClasificadoridFk;
    }

    public void setCodClasificadoridFk(Tsgnomclasificador codClasificadoridFk) {
        this.codClasificadoridFk = codClasificadoridFk;
    }

    public Tsgnomconceptosat getCodConceptosatidFk() {
        return codConceptosatidFk;
    }

    public void setCodConceptosatidFk(Tsgnomconceptosat codConceptosatidFk) {
        this.codConceptosatidFk = codConceptosatidFk;
    }

    public Tsgnomformula getCodFormulaidFk() {
        return codFormulaidFk;
    }

    public void setCodFormulaidFk(Tsgnomformula codFormulaidFk) {
        this.codFormulaidFk = codFormulaidFk;
    }

    public Tsgnomtipoconcepto getCodTipoconceptoidFk() {
        return codTipoconceptoidFk;
    }

    public void setCodTipoconceptoidFk(Tsgnomtipoconcepto codTipoconceptoidFk) {
        this.codTipoconceptoidFk = codTipoconceptoidFk;
    }

    public Tsgnomtiponomina getCodTiponominaidFk() {
        return codTiponominaidFk;
    }

    public void setCodTiponominaidFk(Tsgnomtiponomina codTiponominaidFk) {
        this.codTiponominaidFk = codTiponominaidFk;
    }

    @XmlTransient
    @JsonIgnore
    public List<Tsgnommanterceros> getTsgnommantercerosList() {
        return tsgnommantercerosList;
    }

    public void setTsgnommantercerosList(List<Tsgnommanterceros> tsgnommantercerosList) {
        this.tsgnommantercerosList = tsgnommantercerosList;
    }

    @XmlTransient
    @JsonIgnore
    public List<Tsgnomcncptoquinc> getTsgnomcncptoquincList() {
        return tsgnomcncptoquincList;
    }

    public void setTsgnomcncptoquincList(List<Tsgnomcncptoquinc> tsgnomcncptoquincList) {
        this.tsgnomcncptoquincList = tsgnomcncptoquincList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codConceptoid != null ? codConceptoid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tsgnomconcepto)) {
            return false;
        }
        Tsgnomconcepto other = (Tsgnomconcepto) object;
        if ((this.codConceptoid == null && other.codConceptoid != null) || (this.codConceptoid != null && !this.codConceptoid.equals(other.codConceptoid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mbn.sinod.model.entidades.Tsgnomconcepto[ codConceptoid=" + codConceptoid + " ]";
    }

    /**
     * @return the impMonto
     */
    public Double getImpMonto() {
        return impMonto;
    }

    /**
     * @param impMonto the impMonto to set
     */
    public void setImpMonto(Double impMonto) {
        this.impMonto = impMonto;
    }

}
