/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ambro
 */
@Entity
@Table(name = "tsgcotipousuario", catalog = "suite", schema = "sgco")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tsgcotipousuario.findAll", query = "SELECT t FROM Tsgcotipousuario t")})
public class Tsgcotipousuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "cod_tipousuario")
    private Integer codTipousuario;
    @Basic(optional = false)
    @Column(name = "cod_rol")
    private int codRol;
    @JoinColumn(name = "cod_sistema", referencedColumnName = "cod_sistema")
    @ManyToOne(optional = false)
    private Tsgcosistemas codSistema;
    @JoinColumn(name = "cod_usuario", referencedColumnName = "cod_usuario")
    @ManyToOne(optional = false)
    private Tsgcousuarios codUsuario;

    public Tsgcotipousuario() {
    }

    public Tsgcotipousuario(Integer codTipousuario) {
        this.codTipousuario = codTipousuario;
    }

    public Tsgcotipousuario(Integer codTipousuario, int codRol) {
        this.codTipousuario = codTipousuario;
        this.codRol = codRol;
    }

    public Integer getCodTipousuario() {
        return codTipousuario;
    }

    public void setCodTipousuario(Integer codTipousuario) {
        this.codTipousuario = codTipousuario;
    }

    public int getCodRol() {
        return codRol;
    }

    public void setCodRol(int codRol) {
        this.codRol = codRol;
    }

    public Tsgcosistemas getCodSistema() {
        return codSistema;
    }

    public void setCodSistema(Tsgcosistemas codSistema) {
        this.codSistema = codSistema;
    }

    public Tsgcousuarios getCodUsuario() {
        return codUsuario;
    }

    public void setCodUsuario(Tsgcousuarios codUsuario) {
        this.codUsuario = codUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codTipousuario != null ? codTipousuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tsgcotipousuario)) {
            return false;
        }
        Tsgcotipousuario other = (Tsgcotipousuario) object;
        if ((this.codTipousuario == null && other.codTipousuario != null) || (this.codTipousuario != null && !this.codTipousuario.equals(other.codTipousuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mbn.sinod.model.entidades.Tsgcotipousuario[ codTipousuario=" + codTipousuario + " ]";
    }
    
}
