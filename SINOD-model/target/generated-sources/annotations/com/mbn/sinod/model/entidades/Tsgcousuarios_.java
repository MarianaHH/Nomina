package com.mbn.sinod.model.entidades;

import com.mbn.sinod.model.entidades.Tsgcotipousuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-12-05T11:39:34")
@StaticMetamodel(Tsgcousuarios.class)
public class Tsgcousuarios_ { 

    public static volatile SingularAttribute<Tsgcousuarios, Integer> codUsuario;
    public static volatile SingularAttribute<Tsgcousuarios, String> codUsuariosistema;
    public static volatile SingularAttribute<Tsgcousuarios, String> desContrasenacorreo;
    public static volatile SingularAttribute<Tsgcousuarios, String> desContrasenasistema;
    public static volatile ListAttribute<Tsgcousuarios, Tsgcotipousuario> tsgcotipousuarioList;
    public static volatile SingularAttribute<Tsgcousuarios, String> desCorreo;
    public static volatile SingularAttribute<Tsgcousuarios, Integer> codEmpleado;

}