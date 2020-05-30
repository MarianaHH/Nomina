package com.mbn.sinod.model.entidades;

import com.mbn.sinod.model.entidades.Tsgnomcabecera;
import com.mbn.sinod.model.entidades.Tsgnomcabeceraht;
import com.mbn.sinod.model.entidades.Tsgnomejercicio;
import com.mbn.sinod.model.entidades.Tsgnommanterceros;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-12-05T11:39:33")
@StaticMetamodel(Tsgnomquincena.class)
public class Tsgnomquincena_ { 

    public static volatile ListAttribute<Tsgnomquincena, Tsgnommanterceros> tsgnommantercerosList1;
    public static volatile ListAttribute<Tsgnomquincena, Tsgnomcabeceraht> tsgnomcabecerahtList;
    public static volatile SingularAttribute<Tsgnomquincena, Tsgnomejercicio> codEjercicioidFk;
    public static volatile SingularAttribute<Tsgnomquincena, Date> fecFin;
    public static volatile SingularAttribute<Tsgnomquincena, Date> fecDispersion;
    public static volatile ListAttribute<Tsgnomquincena, Tsgnomcabecera> tsgnomcabeceraList;
    public static volatile ListAttribute<Tsgnomquincena, Tsgnommanterceros> tsgnommantercerosList;
    public static volatile SingularAttribute<Tsgnomquincena, Date> fecPago;
    public static volatile SingularAttribute<Tsgnomquincena, Integer> cnuNumquincena;
    public static volatile SingularAttribute<Tsgnomquincena, Integer> codQuincenaid;
    public static volatile SingularAttribute<Tsgnomquincena, Boolean> bolEstatus;
    public static volatile SingularAttribute<Tsgnomquincena, Date> fecInicio;
    public static volatile SingularAttribute<Tsgnomquincena, String> desQuincena;

}