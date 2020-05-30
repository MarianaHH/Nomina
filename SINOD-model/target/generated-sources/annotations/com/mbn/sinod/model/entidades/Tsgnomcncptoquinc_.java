package com.mbn.sinod.model.entidades;

import com.mbn.sinod.model.entidades.Tsgnomconcepto;
import com.mbn.sinod.model.entidades.Tsgnomempquincena;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-12-05T11:39:33")
@StaticMetamodel(Tsgnomcncptoquinc.class)
public class Tsgnomcncptoquinc_ { 

    public static volatile SingularAttribute<Tsgnomcncptoquinc, Tsgnomempquincena> codEmpquincenaidFk;
    public static volatile SingularAttribute<Tsgnomcncptoquinc, Integer> codCncptoquincid;
    public static volatile SingularAttribute<Tsgnomcncptoquinc, BigDecimal> impGravado;
    public static volatile SingularAttribute<Tsgnomcncptoquinc, BigDecimal> impExento;
    public static volatile SingularAttribute<Tsgnomcncptoquinc, String> xmlDesgloce;
    public static volatile SingularAttribute<Tsgnomcncptoquinc, BigDecimal> impConcepto;
    public static volatile SingularAttribute<Tsgnomcncptoquinc, Tsgnomconcepto> codConceptoidFk;

}