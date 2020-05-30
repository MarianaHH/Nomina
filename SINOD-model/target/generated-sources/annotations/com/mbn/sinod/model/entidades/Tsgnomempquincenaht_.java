package com.mbn.sinod.model.entidades;

import com.mbn.sinod.model.entidades.Tsgnomcabecera;
import com.mbn.sinod.model.entidades.Tsgnomempleados;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-12-05T11:39:34")
@StaticMetamodel(Tsgnomempquincenaht.class)
public class Tsgnomempquincenaht_ { 

    public static volatile SingularAttribute<Tsgnomempquincenaht, Boolean> bolEstatusemp;
    public static volatile SingularAttribute<Tsgnomempquincenaht, BigDecimal> impTotpercepcion;
    public static volatile SingularAttribute<Tsgnomempquincenaht, BigDecimal> impTotalemp;
    public static volatile SingularAttribute<Tsgnomempquincenaht, Tsgnomempleados> codEmpleadoidFk;
    public static volatile SingularAttribute<Tsgnomempquincenaht, Integer> codEmpquincenahtid;
    public static volatile SingularAttribute<Tsgnomempquincenaht, Tsgnomcabecera> codCabeceraidFk;
    public static volatile SingularAttribute<Tsgnomempquincenaht, BigDecimal> impTotdeduccion;

}