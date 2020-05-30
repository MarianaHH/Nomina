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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author José Antonio Zarco Robles, MBN
 */
@Entity
@Table(name = "tsgrhempleados", schema = "sgrh")
@XmlRootElement
public class Tsgrhempleados implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "cod_empleado")
    private Integer codEmpleado;
    @Basic(optional = false)
    @Column(name = "des_nombre")
    private String desNombre;
    @Column(name = "des_nombres")
    private String desNombres;
    @Basic(optional = false)
    @Column(name = "des_apepaterno")
    private String desApepaterno;
    @Column(name = "des_apematerno")
    private String desApematerno;
    @Column(name = "des_correo")
    private String desCorreo;
    @JoinColumn(name = "cod_puesto", referencedColumnName = "cod_puesto")
    @ManyToOne(optional = false)
    private Tsgrhpuestos codPuesto;
    @Basic(optional = false)
    @Column(name = "des_direccion")
    private String desDireccion;
    @Basic(optional = false)
    @Column(name = "fec_nacimiento")
    @Temporal(TemporalType.DATE)
    private Date fecNacimiento;
    @Basic(optional = false)
    @Column(name = "des_lugarnacimiento")
    private String desLugarnacimiento;
    @Basic(optional = false)
    @Column(name = "cod_edad")
    private int codEdad;
    @Basic(optional = false)
    @Column(name = "cod_tiposangre")
    private String codTiposangre;
    @Column(name = "cod_telefonocasa")
    private String codTelefonocasa;
    @Column(name = "cod_telefonocelular")
    private String codTelefonocelular;
    @Column(name = "cod_telemergencia")
    private String codTelemergencia;
    @Lob
    @Column(name = "bin_identificacion")
    private byte[] binIdentificacion;
    @Lob
    @Column(name = "bin_pasaporte")
    private byte[] binPasaporte;
    @Lob
    @Column(name = "bin_visa")
    private byte[] binVisa;
    @Column(name = "cod_licenciamanejo")
    private String codLicenciamanejo;
    @Basic(optional = false)
    @Column(name = "fec_ingreso")
    @Temporal(TemporalType.DATE)
    private Date fecIngreso;
    @Column(name = "cod_rfc")
    private String codRfc;
    @Column(name = "cod_nss")
    private String codNss;
    @Basic(optional = false)
    @Column(name = "cod_curp")
    private String codCurp;
    @Lob
    @Column(name = "bin_foto")
    private byte[] binFoto;
    @Column(name = "cod_tipofoto")
    private String codTipofoto;
    @Column(name = "cod_extensionfoto")
    private String codExtensionfoto;
    @Column(name = "cod_empleadoactivo")
    private Boolean codEmpleadoactivo;
    @Basic(optional = false)
    @Column(name = "cod_estatusempleado")
    private int codEstatusempleado;
    @Basic(optional = false)
    @Column(name = "cod_estadocivil")
    private int codEstadocivil;
    @JoinColumn(name = "cod_rol", referencedColumnName = "cod_rol")
    @ManyToOne(optional = false)
    private Tsgrhroles codRol;
    @Column(name = "cod_diasvacaciones")
    private Integer codDiasvacaciones;
    @Column(name = "cod_sistemasuite")
    private Integer codSistemasuite;
    @Basic(optional = false)
    @Column(name = "fec_creacion")
    @Temporal(TemporalType.DATE)
    private Date fecCreacion;
    @Basic(optional = false)
    @Column(name = "fec_modificacion")
    @Temporal(TemporalType.DATE)
    private Date fecModificacion;
    @Column(name = "des_correopersonal")
    private String desCorreopersonal;
//    @OneToMany(mappedBy = "codCreadopor")
//    private List<Tsgrhempleados> tsgrhempleadosList;
//    @JoinColumn(name = "cod_creadopor", referencedColumnName = "cod_empleado")
//    @ManyToOne
//    private Tsgrhempleados codCreadopor;
//    @OneToMany(mappedBy = "codModificadopor")
//    private List<Tsgrhempleados> tsgrhempleadosList1;
//    @JoinColumn(name = "cod_modificadopor", referencedColumnName = "cod_empleado")
//    @ManyToOne
//    private Tsgrhempleados codModificadopor;

    public Tsgrhempleados() {
    }

    public Tsgrhempleados(Integer codEmpleado) {
        this.codEmpleado = codEmpleado;
    }

    public Tsgrhempleados(Integer codEmpleado, String desNombre, String desApepaterno, String desDireccion, Date fecNacimiento, String desLugarnacimiento, String codTiposangre, Date fecIngreso, String codCurp, byte[] binFoto, String codTipofoto, String codExtensionfoto, int codEstatusempleado, int codEstadocivil, int codRol, int codDiasvacaciones, int codSistemasuite, Date fecCreacion, Date fecModificacion, int codCreadopor, int codModificadopor, String desCorreo) {
        this.codEmpleado = codEmpleado;
        this.desNombre = desNombre;
        this.desApepaterno = desApepaterno;
        this.desDireccion = desDireccion;
        this.fecNacimiento = fecNacimiento;
        this.desLugarnacimiento = desLugarnacimiento;
        this.codTiposangre = codTiposangre;
        this.fecIngreso = fecIngreso;
        this.codCurp = codCurp;
        this.binFoto = binFoto;
        this.codTipofoto = codTipofoto;
        this.codExtensionfoto = codExtensionfoto;
        this.codEstatusempleado = codEstatusempleado;
        this.codEstadocivil = codEstadocivil;
        //this.codRol = codRol;
        this.codDiasvacaciones = codDiasvacaciones;
        this.codSistemasuite = codSistemasuite;
        this.fecCreacion = fecCreacion;
//        this.fecModificacion = fecModificacion;
//        this.codCreadopor = codCreadopor;
//        this.codModificadopor = codModificadopor;
        this.desCorreo = desCorreo;
    }

    public Integer getCodEmpleado() {
        return codEmpleado;
    }

    public void setCodEmpleado(Integer codEmpleado) {
        this.codEmpleado = codEmpleado;
    }

    public String getDesNombre() {
        return desNombre;
    }

    public void setDesNombre(String desNombre) {
        this.desNombre = desNombre;
    }

    public String getDesNombres() {
        return desNombres;
    }

    public void setDesNombres(String desNombres) {
        this.desNombres = desNombres;
    }

    public String getDesApepaterno() {
        return desApepaterno;
    }

    public void setDesApepaterno(String desApepaterno) {
        this.desApepaterno = desApepaterno;
    }

    public String getDesApematerno() {
        return desApematerno;
    }

    public void setDesApematerno(String desApematerno) {
        this.desApematerno = desApematerno;
    }

    public byte[] getBinFoto() {
        return binFoto;
    }

    public void setBinFoto(byte[] binFoto) {
        this.binFoto = binFoto;
    }


//    public int getCodCreadopor() {
//        return codCreadopor;
//    }
//
//    public void setCodCreadopor(int codCreadopor) {
//        this.codCreadopor = codCreadopor;
//    }
//
//    public int getCodModificadopor() {
//        return codModificadopor;
//    }
//
//    public void setCodModificadopor(int codModificadopor) {
//        this.codModificadopor = codModificadopor;
//    }

    public String getDesCorreo() {
        return desCorreo;
    }

    public void setDesCorreo(String desCorreo) {
        this.desCorreo = desCorreo;
    }

    public Tsgrhpuestos getCodPuesto() {
        return codPuesto;
    }

    public void setCodPuesto(Tsgrhpuestos codPuesto) {
        this.codPuesto = codPuesto;
    }
   

    public String getDesDireccion() {
        return desDireccion;
    }

    public void setDesDireccion(String desDireccion) {
        this.desDireccion = desDireccion;
    }

    public Date getFecNacimiento() {
        return fecNacimiento;
    }

    public void setFecNacimiento(Date fecNacimiento) {
        this.fecNacimiento = fecNacimiento;
    }

    public String getDesLugarnacimiento() {
        return desLugarnacimiento;
    }

    public void setDesLugarnacimiento(String desLugarnacimiento) {
        this.desLugarnacimiento = desLugarnacimiento;
    }

    public int getCodEdad() {
        return codEdad;
    }

    public void setCodEdad(int codEdad) {
        this.codEdad = codEdad;
    }

    public String getCodTiposangre() {
        return codTiposangre;
    }

    public void setCodTiposangre(String codTiposangre) {
        this.codTiposangre = codTiposangre;
    }

    public String getCodTelefonocasa() {
        return codTelefonocasa;
    }

    public void setCodTelefonocasa(String codTelefonocasa) {
        this.codTelefonocasa = codTelefonocasa;
    }

    public String getCodTelefonocelular() {
        return codTelefonocelular;
    }

    public void setCodTelefonocelular(String codTelefonocelular) {
        this.codTelefonocelular = codTelefonocelular;
    }

    public String getCodTelemergencia() {
        return codTelemergencia;
    }

    public void setCodTelemergencia(String codTelemergencia) {
        this.codTelemergencia = codTelemergencia;
    }

    public byte[] getBinIdentificacion() {
        return binIdentificacion;
    }

    public void setBinIdentificacion(byte[] binIdentificacion) {
        this.binIdentificacion = binIdentificacion;
    }

    public byte[] getBinPasaporte() {
        return binPasaporte;
    }

    public void setBinPasaporte(byte[] binPasaporte) {
        this.binPasaporte = binPasaporte;
    }

    public byte[] getBinVisa() {
        return binVisa;
    }

    public void setBinVisa(byte[] binVisa) {
        this.binVisa = binVisa;
    }

    public String getCodLicenciamanejo() {
        return codLicenciamanejo;
    }

    public void setCodLicenciamanejo(String codLicenciamanejo) {
        this.codLicenciamanejo = codLicenciamanejo;
    }

    public Date getFecIngreso() {
        return fecIngreso;
    }

    public void setFecIngreso(Date fecIngreso) {
        this.fecIngreso = fecIngreso;
    }

    public String getCodRfc() {
        return codRfc;
    }

    public void setCodRfc(String codRfc) {
        this.codRfc = codRfc;
    }

    public String getCodNss() {
        return codNss;
    }

    public void setCodNss(String codNss) {
        this.codNss = codNss;
    }

    public String getCodCurp() {
        return codCurp;
    }

    public void setCodCurp(String codCurp) {
        this.codCurp = codCurp;
    }

//    public byte[] getBinFoto() {
//        return binFoto;
//    }
//
//    public void setBinFoto(byte[] binFoto) {
//        this.binFoto = binFoto;
//    }

    public String getCodTipofoto() {
        return codTipofoto;
    }

    public void setCodTipofoto(String codTipofoto) {
        this.codTipofoto = codTipofoto;
    }

    public String getCodExtensionfoto() {
        return codExtensionfoto;
    }

    public void setCodExtensionfoto(String codExtensionfoto) {
        this.codExtensionfoto = codExtensionfoto;
    }

    public Boolean getCodEmpleadoactivo() {
        return codEmpleadoactivo;
    }

    public void setCodEmpleadoactivo(Boolean codEmpleadoactivo) {
        this.codEmpleadoactivo = codEmpleadoactivo;
    }

    public int getCodEstatusempleado() {
        return codEstatusempleado;
    }

    public void setCodEstatusempleado(int codEstatusempleado) {
        this.codEstatusempleado = codEstatusempleado;
    }

    public int getCodEstadocivil() {
        return codEstadocivil;
    }

    public void setCodEstadocivil(int codEstadocivil) {
        this.codEstadocivil = codEstadocivil;
    }

  
    public Tsgrhroles getCodRol() {
        return codRol;
    }

    public void setCodRol(Tsgrhroles codRol) {
        this.codRol = codRol;
    }

    public Integer getCodDiasvacaciones() {
        return codDiasvacaciones;
    }

    public void setCodDiasvacaciones(Integer codDiasvacaciones) {
        this.codDiasvacaciones = codDiasvacaciones;
    }

    public Integer getCodSistemasuite() {
        return codSistemasuite;
    }

    public void setCodSistemasuite(Integer codSistemasuite) {
        this.codSistemasuite = codSistemasuite;
    }

    public Date getFecCreacion() {
        return fecCreacion;
    }

    public void setFecCreacion(Date fecCreacion) {
        this.fecCreacion = fecCreacion;
    }

    public Date getFecModificacion() {
        return fecModificacion;
    }

    public void setFecModificacion(Date fecModificacion) {
        this.fecModificacion = fecModificacion;
    }
    
    public String getDesCorreopersonal() {
        return desCorreopersonal;
    }

    public void setDesCorreopersonal(String desCorreopersonal) {
        this.desCorreopersonal = desCorreopersonal;
    }

//    @XmlTransient @JsonIgnore
//    public List<Tsgrhempleados> getTsgrhempleadosList() {
//        return tsgrhempleadosList;
//    }
//
//    public void setTsgrhempleadosList(List<Tsgrhempleados> tsgrhempleadosList) {
//        this.tsgrhempleadosList = tsgrhempleadosList;
//    }
//
//    public Tsgrhempleados getCodCreadopor() {
//        return codCreadopor;
//    }
//
//    public void setCodCreadopor(Tsgrhempleados codCreadopor) {
//        this.codCreadopor = codCreadopor;
//    }
//
//    @XmlTransient @JsonIgnore
//    public List<Tsgrhempleados> getTsgrhempleadosList1() {
//        return tsgrhempleadosList1;
//    }
//
//    public void setTsgrhempleadosList1(List<Tsgrhempleados> tsgrhempleadosList1) {
//        this.tsgrhempleadosList1 = tsgrhempleadosList1;
//    }
//
//    public Tsgrhempleados getCodModificadopor() {
//        return codModificadopor;
//    }
//
//    public void setCodModificadopor(Tsgrhempleados codModificadopor) {
//        this.codModificadopor = codModificadopor;
//    }
//    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codEmpleado != null ? codEmpleado.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tsgrhempleados)) {
            return false;
        }
        Tsgrhempleados other = (Tsgrhempleados) object;
        if ((this.codEmpleado == null && other.codEmpleado != null) || (this.codEmpleado != null && !this.codEmpleado.equals(other.codEmpleado))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mbn.sinod.model.entidades.Tsgrhempleados[ codEmpleado=" + codEmpleado + " ]";
    }
}
