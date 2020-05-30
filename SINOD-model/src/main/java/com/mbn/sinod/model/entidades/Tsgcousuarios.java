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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ambro
 */
@Entity
@Table(name = "tsgcousuarios", catalog = "suite", schema = "sgco")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tsgcousuarios.findAll", query = "SELECT t FROM Tsgcousuarios t")})
public class Tsgcousuarios implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cod_usuario")
    private Integer codUsuario;
    @Basic(optional = false)
    @Column(name = "cod_empleado")
    private int codEmpleado;
    @Basic(optional = false)
    @Column(name = "des_correo")
    private String desCorreo;
    @Basic(optional = false)
    @Column(name = "des_contrasenacorreo")
    private String desContrasenacorreo;
    @Basic(optional = false)
    @Column(name = "cod_usuariosistema")
    private String codUsuariosistema;
    @Basic(optional = false)
    @Column(name = "des_contrasenasistema")
    private String desContrasenasistema;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codUsuario", fetch = FetchType.LAZY)
    private List<Tsgcotipousuario> tsgcotipousuarioList;

    public Tsgcousuarios() {
    }

    public Tsgcousuarios(Integer codUsuario) {
        this.codUsuario = codUsuario;
    }

    public Tsgcousuarios(Integer codUsuario, int codEmpleado, String desCorreo, String desContrasenacorreo, String codUsuariosistema, String desContrasenasistema) {
        this.codUsuario = codUsuario;
        this.codEmpleado = codEmpleado;
        this.desCorreo = desCorreo;
        this.desContrasenacorreo = desContrasenacorreo;
        this.codUsuariosistema = codUsuariosistema;
        this.desContrasenasistema = desContrasenasistema;
    }

    public Integer getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(Integer codUsuario) {
        this.codUsuario = codUsuario;
    }

    public int getCodEmpleado() {
        return codEmpleado;
    }

    public void setCodEmpleado(int codEmpleado) {
        this.codEmpleado = codEmpleado;
    }

    public String getDesCorreo() {
        return desCorreo;
    }

    public void setDesCorreo(String desCorreo) {
        this.desCorreo = desCorreo;
    }

    public String getDesContrasenacorreo() {
        return desContrasenacorreo;
    }

    public void setDesContrasenacorreo(String desContrasenacorreo) {
        this.desContrasenacorreo = desContrasenacorreo;
    }

    public String getCodUsuariosistema() {
        return codUsuariosistema;
    }

    public void setCodUsuariosistema(String codUsuariosistema) {
        this.codUsuariosistema = codUsuariosistema;
    }

    public String getDesContrasenasistema() {
        return desContrasenasistema;
    }

    public void setDesContrasenasistema(String desContrasenasistema) {
        this.desContrasenasistema = desContrasenasistema;
    }

    @XmlTransient @JsonIgnore
    public List<Tsgcotipousuario> getTsgcotipousuarioList() {
        return tsgcotipousuarioList;
    }

    public void setTsgcotipousuarioList(List<Tsgcotipousuario> tsgcotipousuarioList) {
        this.tsgcotipousuarioList = tsgcotipousuarioList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codUsuario != null ? codUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tsgcousuarios)) {
            return false;
        }
        Tsgcousuarios other = (Tsgcousuarios) object;
        if ((this.codUsuario == null && other.codUsuario != null) || (this.codUsuario != null && !this.codUsuario.equals(other.codUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mbn.sinod.model.entidades.Tsgcousuarios[ codUsuario=" + codUsuario + " ]";
    }
    
}
