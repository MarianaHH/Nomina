package com.mbn.sinod.model.entidades;

import com.mbn.sinod.model.entidades.Tsgrhpuestos;
import com.mbn.sinod.model.entidades.Tsgrhroles;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-12-05T11:39:33")
@StaticMetamodel(Tsgrhempleados.class)
public class Tsgrhempleados_ { 

    public static volatile SingularAttribute<Tsgrhempleados, String> codLicenciamanejo;
    public static volatile SingularAttribute<Tsgrhempleados, String> codTelefonocasa;
    public static volatile SingularAttribute<Tsgrhempleados, Integer> codEstatusempleado;
    public static volatile SingularAttribute<Tsgrhempleados, String> desLugarnacimiento;
    public static volatile SingularAttribute<Tsgrhempleados, String> codNss;
    public static volatile SingularAttribute<Tsgrhempleados, String> desNombres;
    public static volatile SingularAttribute<Tsgrhempleados, Tsgrhroles> codRol;
    public static volatile SingularAttribute<Tsgrhempleados, Integer> codEdad;
    public static volatile SingularAttribute<Tsgrhempleados, String> codTipofoto;
    public static volatile SingularAttribute<Tsgrhempleados, byte[]> binFoto;
    public static volatile SingularAttribute<Tsgrhempleados, Integer> codDiasvacaciones;
    public static volatile SingularAttribute<Tsgrhempleados, String> codTiposangre;
    public static volatile SingularAttribute<Tsgrhempleados, Date> fecCreacion;
    public static volatile SingularAttribute<Tsgrhempleados, byte[]> binIdentificacion;
    public static volatile SingularAttribute<Tsgrhempleados, Integer> codEstadocivil;
    public static volatile SingularAttribute<Tsgrhempleados, String> desDireccion;
    public static volatile SingularAttribute<Tsgrhempleados, Date> fecIngreso;
    public static volatile SingularAttribute<Tsgrhempleados, String> desNombre;
    public static volatile SingularAttribute<Tsgrhempleados, String> codCurp;
    public static volatile SingularAttribute<Tsgrhempleados, String> desCorreopersonal;
    public static volatile SingularAttribute<Tsgrhempleados, Integer> codEmpleado;
    public static volatile SingularAttribute<Tsgrhempleados, Integer> codSistemasuite;
    public static volatile SingularAttribute<Tsgrhempleados, String> desApematerno;
    public static volatile SingularAttribute<Tsgrhempleados, Tsgrhpuestos> codPuesto;
    public static volatile SingularAttribute<Tsgrhempleados, String> desApepaterno;
    public static volatile SingularAttribute<Tsgrhempleados, String> desCorreo;
    public static volatile SingularAttribute<Tsgrhempleados, String> codRfc;
    public static volatile SingularAttribute<Tsgrhempleados, byte[]> binVisa;
    public static volatile SingularAttribute<Tsgrhempleados, String> codExtensionfoto;
    public static volatile SingularAttribute<Tsgrhempleados, String> codTelefonocelular;
    public static volatile SingularAttribute<Tsgrhempleados, Date> fecNacimiento;
    public static volatile SingularAttribute<Tsgrhempleados, Boolean> codEmpleadoactivo;
    public static volatile SingularAttribute<Tsgrhempleados, Date> fecModificacion;
    public static volatile SingularAttribute<Tsgrhempleados, String> codTelemergencia;
    public static volatile SingularAttribute<Tsgrhempleados, byte[]> binPasaporte;

}