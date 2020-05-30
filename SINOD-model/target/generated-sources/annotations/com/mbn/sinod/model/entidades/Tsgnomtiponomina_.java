package com.mbn.sinod.model.entidades;

import com.mbn.sinod.model.entidades.Tsgnomcabecera;
import com.mbn.sinod.model.entidades.Tsgnomcabeceraht;
import com.mbn.sinod.model.entidades.Tsgnomconcepto;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-12-05T11:39:33")
@StaticMetamodel(Tsgnomtiponomina.class)
public class Tsgnomtiponomina_ { 

    public static volatile ListAttribute<Tsgnomtiponomina, Tsgnomconcepto> tsgnomconceptoList;
    public static volatile ListAttribute<Tsgnomtiponomina, Tsgnomcabeceraht> tsgnomcabecerahtList;
    public static volatile SingularAttribute<Tsgnomtiponomina, String> codNomina;
    public static volatile SingularAttribute<Tsgnomtiponomina, Boolean> bolEstatus;
    public static volatile ListAttribute<Tsgnomtiponomina, Tsgnomcabecera> tsgnomcabeceraList;
    public static volatile SingularAttribute<Tsgnomtiponomina, Integer> codTiponominaid;

}