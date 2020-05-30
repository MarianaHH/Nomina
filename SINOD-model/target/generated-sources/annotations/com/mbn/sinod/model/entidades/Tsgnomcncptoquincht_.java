package com.mbn.sinod.model.entidades;

import com.mbn.sinod.model.entidades.Tsgnomconcepto;
import com.mbn.sinod.model.entidades.Tsgnomempquincena;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-12-05T11:39:33")
@StaticMetamodel(Tsgnomcncptoquincht.class)
public class Tsgnomcncptoquincht_ { 

    public static volatile SingularAttribute<Tsgnomcncptoquincht, Tsgnomempquincena> codEmpquincenaidFk;
    public static volatile SingularAttribute<Tsgnomcncptoquincht, BigDecimal> impGravado;
    public static volatile SingularAttribute<Tsgnomcncptoquincht, BigDecimal> impExento;
    public static volatile SingularAttribute<Tsgnomcncptoquincht, Serializable> xmlDesgloce;
    public static volatile SingularAttribute<Tsgnomcncptoquincht, Integer> codCncptoquinchtid;
    public static volatile SingularAttribute<Tsgnomcncptoquincht, BigDecimal> impConcepto;
    public static volatile SingularAttribute<Tsgnomcncptoquincht, Tsgnomconcepto> codConceptoidFk;

}