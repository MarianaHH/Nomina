package com.mbn.sinod.model.entidades;

import com.mbn.sinod.model.entidades.Tsgnomconcepto;
import com.mbn.sinod.model.entidades.Tsgnomempleados;
import com.mbn.sinod.model.entidades.Tsgnomquincena;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-12-05T11:39:33")
@StaticMetamodel(Tsgnommanterceros.class)
public class Tsgnommanterceros_ { 

    public static volatile SingularAttribute<Tsgnommanterceros, Integer> audCodcreadopor;
    public static volatile SingularAttribute<Tsgnommanterceros, String> codFrecuenciapago;
    public static volatile SingularAttribute<Tsgnommanterceros, Date> audFecreacion;
    public static volatile SingularAttribute<Tsgnommanterceros, Integer> codMantercerosid;
    public static volatile SingularAttribute<Tsgnommanterceros, Tsgnomquincena> codQuincenainicioFk;
    public static volatile SingularAttribute<Tsgnommanterceros, Date> audFecmodificacion;
    public static volatile SingularAttribute<Tsgnommanterceros, BigDecimal> impMonto;
    public static volatile SingularAttribute<Tsgnommanterceros, Tsgnomempleados> codEmpleadoidFk;
    public static volatile SingularAttribute<Tsgnommanterceros, Integer> audCodmodificadopor;
    public static volatile SingularAttribute<Tsgnommanterceros, Tsgnomquincena> codQuincenafinFk;
    public static volatile SingularAttribute<Tsgnommanterceros, Boolean> bolEstatus;
    public static volatile SingularAttribute<Tsgnommanterceros, Tsgnomconcepto> codConceptoidFk;

}