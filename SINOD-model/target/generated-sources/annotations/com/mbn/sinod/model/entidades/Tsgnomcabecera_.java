package com.mbn.sinod.model.entidades;

import com.mbn.sinod.model.entidades.Tsgnomempquincena;
import com.mbn.sinod.model.entidades.Tsgnomempquincenaht;
import com.mbn.sinod.model.entidades.Tsgnomestatusnom;
import com.mbn.sinod.model.entidades.Tsgnomquincena;
import com.mbn.sinod.model.entidades.Tsgnomtiponomina;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-12-05T11:39:33")
@StaticMetamodel(Tsgnomcabecera.class)
public class Tsgnomcabecera_ { 

    public static volatile SingularAttribute<Tsgnomcabecera, Tsgnomestatusnom> codEstatusnomidFk;
    public static volatile SingularAttribute<Tsgnomcabecera, Integer> audCodcreadopor;
    public static volatile SingularAttribute<Tsgnomcabecera, Date> fecCierre;
    public static volatile SingularAttribute<Tsgnomcabecera, BigDecimal> impTotalemp;
    public static volatile ListAttribute<Tsgnomcabecera, Tsgnomempquincena> tsgnomempquincenaList;
    public static volatile ListAttribute<Tsgnomcabecera, Tsgnomempquincenaht> tsgnomempquincenahtList;
    public static volatile SingularAttribute<Tsgnomcabecera, Date> audFeccreacion;
    public static volatile SingularAttribute<Tsgnomcabecera, Integer> audCodmodificadopor;
    public static volatile SingularAttribute<Tsgnomcabecera, Tsgnomquincena> codQuincenaidFk;
    public static volatile SingularAttribute<Tsgnomcabecera, BigDecimal> impTotdeduccion;
    public static volatile SingularAttribute<Tsgnomcabecera, Tsgnomtiponomina> codTiponominaidFk;
    public static volatile SingularAttribute<Tsgnomcabecera, Integer> codCabeceraid;
    public static volatile SingularAttribute<Tsgnomcabecera, Date> fecEjecucion;
    public static volatile SingularAttribute<Tsgnomcabecera, BigDecimal> impTotpercepcion;
    public static volatile SingularAttribute<Tsgnomcabecera, Integer> cnuTotalemp;
    public static volatile SingularAttribute<Tsgnomcabecera, Date> fecCreacion;
    public static volatile SingularAttribute<Tsgnomcabecera, Date> audFecmodificacion;
    public static volatile SingularAttribute<Tsgnomcabecera, String> codNbnomina;

}