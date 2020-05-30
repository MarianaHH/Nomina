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
@Table(name = "tsgnomincidencia", catalog = "suite", schema = "sgnom")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tsgnomincidencia.findAll", query = "SELECT t FROM Tsgnomincidencia t")})
public class Tsgnomincidencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
	@GenericGenerator(name="incId", strategy="increment",parameters = { @Parameter(name = "schema", value = "sgnom") })
        @GeneratedValue(generator = "incId")
    @Basic(optional = false)
    @Column(name = "cod_incidenciaid")
    private Integer codIncidenciaid;
    @Column(name = "cnu_cantidad")
    private Short cnuCantidad;
    @Column(name = "des_actividad")
    private String desActividad;
    @Column(name = "txt_comentarios")
    private String txtComentarios;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "imp_monto")
    private BigDecimal impMonto;
    @Column(name = "xml_detcantidad", columnDefinition = "XMLType")
    private String xmlDetcantidad;
    @Column(name = "bol_estatus")
    private Boolean bolEstatus;
    @Column(name = "bol_validacion")
    private Boolean bolValidacion;
    @Column(name = "fec_validacion")
    @Temporal(TemporalType.DATE)
    private Date fecValidacion;
    @Basic(optional = false)
    @Column(name = "aud_codcreadopor")
    private int audCodcreadopor;
    @Basic(optional = false)
    @Column(name = "aud_feccreacion")
    @Temporal(TemporalType.DATE)
    private Date audFeccreacion;
    @Column(name = "aud_codmodificadopor")
    private Integer audCodmodificadopor;
    @Column(name = "aud_fecmodificacion")
    @Temporal(TemporalType.DATE)
    private Date audFecmodificacion;
//    @JoinColumn(name = "cod_catincidenciaid_fk", referencedColumnName = "cod_catincidenciaid")
//    @ManyToOne(optional = false)
    @Column(name = "cod_catincidenciaid_fk")
    private Integer codCatincidenciaidFk;
//    @JoinColumn(name = "cod_empautoriza_fk", referencedColumnName = "cod_empleadoid")
//    @ManyToOne()
    @Column(name = "cod_empautoriza_fk")
    private Integer codEmpautorizaFk;
//    @JoinColumn(name = "cod_empreporta_fk", referencedColumnName = "cod_empleadoid")
//    @ManyToOne()
    @Column(name = "cod_empreporta_fk")
    private Integer codEmpreportaFk;
//    @JoinColumn(name = "cod_quincenaid_fk", referencedColumnName = "cod_quincenaid")
//    @ManyToOne(optional = false)
    @Basic(optional = false)
    @Column(name = "cod_quincenaid_fk")
    private Integer codQuincenaidFk;
    @Column(name = "bol_aceptacion")
    private Boolean bolAceptacion;
    @Column(name = "bol_pago")
    private Boolean bolPago;

    public Tsgnomincidencia() {
    }

    public Tsgnomincidencia(Integer codIncidenciaid) {
        this.codIncidenciaid = codIncidenciaid;
    }

    public Tsgnomincidencia(Integer codIncidenciaid, int audCodcreadopor, Date audFeccreacion) {
        this.codIncidenciaid = codIncidenciaid;
        this.audCodcreadopor = audCodcreadopor;
        this.audFeccreacion = audFeccreacion;
    }

    public Integer getCodIncidenciaid() {
        return codIncidenciaid;
    }

    public void setCodIncidenciaid(Integer codIncidenciaid) {
        this.codIncidenciaid = codIncidenciaid;
    }

    public Short getCnuCantidad() {
        return cnuCantidad;
    }

    public void setCnuCantidad(Short cnuCantidad) {
        this.cnuCantidad = cnuCantidad;
    }

    public String getDesActividad() {
        return desActividad;
    }

    public void setDesActividad(String desActividad) {
        this.desActividad = desActividad;
    }

    public String getTxtComentarios() {
        return txtComentarios;
    }

    public void setTxtComentarios(String txtComentarios) {
        this.txtComentarios = txtComentarios;
    }

    public BigDecimal getImpMonto() {
        return impMonto;
    }

    public void setImpMonto(BigDecimal impMonto) {
        this.impMonto = impMonto;
    }

    public String getXmlDetcantidad() {
        return xmlDetcantidad;
    }

    public void setXmlDetcantidad(String xmlDetcantidad) {
        this.xmlDetcantidad = xmlDetcantidad;
    }

    public Boolean getBolEstatus() {
        return bolEstatus;
    }

    public void setBolEstatus(Boolean bolEstatus) {
        this.bolEstatus = bolEstatus;
    }

    public Boolean getBolValidacion() {
        return bolValidacion;
    }

    public void setBolValidacion(Boolean bolValidacion) {
        this.bolValidacion = bolValidacion;
    }

    public Date getFecValidacion() {
        return fecValidacion;
    }

    public void setFecValidacion(Date fecValidacion) {
        this.fecValidacion = fecValidacion;
    }

    public int getAudCodcreadopor() {
        return audCodcreadopor;
    }

    public void setAudCodcreadopor(int audCodcreadopor) {
        this.audCodcreadopor = audCodcreadopor;
    }

    public Date getAudFeccreacion() {
        return audFeccreacion;
    }

    public void setAudFeccreacion(Date audFeccreacion) {
        this.audFeccreacion = audFeccreacion;
    }

    public Integer getAudCodmodificadopor() {
        return audCodmodificadopor;
    }

    public void setAudCodmodificadopor(Integer audCodmodificadopor) {
        this.audCodmodificadopor = audCodmodificadopor;
    }

    public Date getAudFecmodificacion() {
        return audFecmodificacion;
    }

    public void setAudFecmodificacion(Date audFecmodificacion) {
        this.audFecmodificacion = audFecmodificacion;
    }

//    public Tsgnomcatincidencia getCodCatincidenciaidFk() {
//        return codCatincidenciaidFk;
//    }
//
//    public void setCodCatincidenciaidFk(Tsgnomcatincidencia codCatincidenciaidFk) {
//        this.codCatincidenciaidFk = codCatincidenciaidFk;
//    }
//
//    public Tsgnomempleados getCodEmpautorizaFk() {
//        return codEmpautorizaFk;
//    }
//
//    public void setCodEmpautorizaFk(Tsgnomempleados codEmpautorizaFk) {
//        this.codEmpautorizaFk = codEmpautorizaFk;
//    }
//
//    public Tsgnomempleados getCodEmpreportaFk() {
//        return codEmpreportaFk;
//    }
//
//    public void setCodEmpreportaFk(Tsgnomempleados codEmpreportaFk) {
//        this.codEmpreportaFk = codEmpreportaFk;
//    }
//
//    public Tsgnomquincena getCodQuincenaidFk() {
//        return codQuincenaidFk;
//    }
//
//    public void setCodQuincenaidFk(Tsgnomquincena codQuincenaidFk) {
//        this.codQuincenaidFk = codQuincenaidFk;
//    }

    public Integer getCodCatincidenciaidFk() {
        return codCatincidenciaidFk;
    }

    public void setCodCatincidenciaidFk(Integer codCatincidenciaidFk) {
        this.codCatincidenciaidFk = codCatincidenciaidFk;
    }

    public Integer getCodEmpautorizaFk() {
        return codEmpautorizaFk;
    }

    public void setCodEmpautorizaFk(Integer codEmpautorizaFk) {
        this.codEmpautorizaFk = codEmpautorizaFk;
    }

    public Integer getCodEmpreportaFk() {
        return codEmpreportaFk;
    }

    public void setCodEmpreportaFk(Integer codEmpreportaFk) {
        this.codEmpreportaFk = codEmpreportaFk;
    }

    public Integer getCodQuincenaidFk() {
        return codQuincenaidFk;
    }

    public void setCodQuincenaidFk(Integer codQuincenaidFk) {
        this.codQuincenaidFk = codQuincenaidFk;
    }

    
    public Boolean getBolAceptacion() {
        return bolAceptacion;
    }

    public void setBolAceptacion(Boolean bolAceptacion) {
        this.bolAceptacion = bolAceptacion;
    }

    public Boolean getBolPago() {
        return bolPago;
    }

    public void setBolPago(Boolean bolPago) {
        this.bolPago = bolPago;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codIncidenciaid != null ? codIncidenciaid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tsgnomincidencia)) {
            return false;
        }
        Tsgnomincidencia other = (Tsgnomincidencia) object;
        if ((this.codIncidenciaid == null && other.codIncidenciaid != null) || (this.codIncidenciaid != null && !this.codIncidenciaid.equals(other.codIncidenciaid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mbn.sinod.model.entidades.Tsgnomincidencia[ codIncidenciaid=" + codIncidenciaid + " ]";
    }
    
}
