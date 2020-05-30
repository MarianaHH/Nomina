package com.mbn.sinod.model.entidades;

import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-12-05T11:39:33")
@StaticMetamodel(Tsgnomincidencia.class)
public class Tsgnomincidencia_ { 

    public static volatile SingularAttribute<Tsgnomincidencia, String> txtComentarios;
    public static volatile SingularAttribute<Tsgnomincidencia, Integer> audCodcreadopor;
    public static volatile SingularAttribute<Tsgnomincidencia, Date> fecValidacion;
    public static volatile SingularAttribute<Tsgnomincidencia, Integer> codEmpreportaFk;
    public static volatile SingularAttribute<Tsgnomincidencia, Date> audFeccreacion;
    public static volatile SingularAttribute<Tsgnomincidencia, BigDecimal> impMonto;
    public static volatile SingularAttribute<Tsgnomincidencia, String> desActividad;
    public static volatile SingularAttribute<Tsgnomincidencia, Integer> audCodmodificadopor;
    public static volatile SingularAttribute<Tsgnomincidencia, Integer> codQuincenaidFk;
    public static volatile SingularAttribute<Tsgnomincidencia, Integer> codIncidenciaid;
    public static volatile SingularAttribute<Tsgnomincidencia, Boolean> bolAceptacion;
    public static volatile SingularAttribute<Tsgnomincidencia, Integer> codEmpautorizaFk;
    public static volatile SingularAttribute<Tsgnomincidencia, Boolean> bolValidacion;
    public static volatile SingularAttribute<Tsgnomincidencia, Short> cnuCantidad;
    public static volatile SingularAttribute<Tsgnomincidencia, Date> audFecmodificacion;
    public static volatile SingularAttribute<Tsgnomincidencia, String> xmlDetcantidad;
    public static volatile SingularAttribute<Tsgnomincidencia, Integer> codCatincidenciaidFk;
    public static volatile SingularAttribute<Tsgnomincidencia, Boolean> bolEstatus;
    public static volatile SingularAttribute<Tsgnomincidencia, Boolean> bolPago;

}