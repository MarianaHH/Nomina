package com.mbn.sinod.model.entidades;

import com.mbn.sinod.model.entidades.Tsgnomestatusnom;
import com.mbn.sinod.model.entidades.Tsgnomquincena;
import com.mbn.sinod.model.entidades.Tsgnomtiponomina;
import java.math.BigDecimal;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-12-05T11:39:34")
@StaticMetamodel(Tsgnomcabeceraht.class)
public class Tsgnomcabeceraht_ { 

    public static volatile SingularAttribute<Tsgnomcabeceraht, Tsgnomestatusnom> codEstatusnomidFk;
    public static volatile SingularAttribute<Tsgnomcabeceraht, Integer> audCodcreadopor;
    public static volatile SingularAttribute<Tsgnomcabeceraht, Date> fecCierre;
    public static volatile SingularAttribute<Tsgnomcabeceraht, BigDecimal> impTotalemp;
    public static volatile SingularAttribute<Tsgnomcabeceraht, Date> audFeccreacion;
    public static volatile SingularAttribute<Tsgnomcabeceraht, Integer> audCodmodificadopor;
    public static volatile SingularAttribute<Tsgnomcabeceraht, Tsgnomquincena> codQuincenaidFk;
    public static volatile SingularAttribute<Tsgnomcabeceraht, BigDecimal> impTotdeduccion;
    public static volatile SingularAttribute<Tsgnomcabeceraht, Tsgnomtiponomina> codTiponominaidFk;
    public static volatile SingularAttribute<Tsgnomcabeceraht, Integer> codCabeceraid;
    public static volatile SingularAttribute<Tsgnomcabeceraht, Date> fecEjecucion;
    public static volatile SingularAttribute<Tsgnomcabeceraht, BigDecimal> impTotpercepcion;
    public static volatile SingularAttribute<Tsgnomcabeceraht, Integer> cnuTotalemp;
    public static volatile SingularAttribute<Tsgnomcabeceraht, Date> fecCreacion;
    public static volatile SingularAttribute<Tsgnomcabeceraht, Date> audFecmodificacion;
    public static volatile SingularAttribute<Tsgnomcabeceraht, String> codNbnomina;

}