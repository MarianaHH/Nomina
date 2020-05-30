package com.mbn.sinod.model.entidades;

import com.mbn.sinod.model.entidades.Tsgnomalguinaldo;
import com.mbn.sinod.model.entidades.Tsgnomcabecera;
import com.mbn.sinod.model.entidades.Tsgnomcncptoquinc;
import com.mbn.sinod.model.entidades.Tsgnomcncptoquincht;
import com.mbn.sinod.model.entidades.Tsgnomconfpago;
import com.mbn.sinod.model.entidades.Tsgnomempleados;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-12-05T11:39:34")
@StaticMetamodel(Tsgnomempquincena.class)
public class Tsgnomempquincena_ { 

    public static volatile SingularAttribute<Tsgnomempquincena, Boolean> bolEstatusemp;
    public static volatile SingularAttribute<Tsgnomempquincena, BigDecimal> impTotpercepcion;
    public static volatile SingularAttribute<Tsgnomempquincena, BigDecimal> impTotalemp;
    public static volatile SingularAttribute<Tsgnomempquincena, Integer> codEmpquincenaid;
    public static volatile ListAttribute<Tsgnomempquincena, Tsgnomconfpago> tsgnomconfpagoList;
    public static volatile SingularAttribute<Tsgnomempquincena, Tsgnomempleados> codEmpleadoidFk;
    public static volatile SingularAttribute<Tsgnomempquincena, Tsgnomcabecera> codCabeceraidFk;
    public static volatile SingularAttribute<Tsgnomempquincena, BigDecimal> impTotdeduccion;
    public static volatile ListAttribute<Tsgnomempquincena, Tsgnomcncptoquincht> tsgnomcncptoquinchtList;
    public static volatile ListAttribute<Tsgnomempquincena, Tsgnomalguinaldo> tsgnomalguinaldoList;
    public static volatile ListAttribute<Tsgnomempquincena, Tsgnomcncptoquinc> tsgnomcncptoquincList;

}