package com.mbn.sinod.model.entidades;

import com.mbn.sinod.model.entidades.Tsgnomcabecera;
import com.mbn.sinod.model.entidades.Tsgnomcabeceraht;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-12-05T11:39:34")
@StaticMetamodel(Tsgnomestatusnom.class)
public class Tsgnomestatusnom_ { 

    public static volatile SingularAttribute<Tsgnomestatusnom, String> codEstatusnomina;
    public static volatile ListAttribute<Tsgnomestatusnom, Tsgnomcabeceraht> tsgnomcabecerahtList;
    public static volatile SingularAttribute<Tsgnomestatusnom, Boolean> bolEstatus;
    public static volatile ListAttribute<Tsgnomestatusnom, Tsgnomcabecera> tsgnomcabeceraList;
    public static volatile SingularAttribute<Tsgnomestatusnom, Integer> codEstatusnomid;

}