package com.mbn.sinod.model.entidades;

import com.mbn.sinod.model.entidades.Tsgnomcalculo;
import com.mbn.sinod.model.entidades.Tsgnomclasificador;
import com.mbn.sinod.model.entidades.Tsgnomcncptoquinc;
import com.mbn.sinod.model.entidades.Tsgnomcncptoquincht;
import com.mbn.sinod.model.entidades.Tsgnomconceptosat;
import com.mbn.sinod.model.entidades.Tsgnomformula;
import com.mbn.sinod.model.entidades.Tsgnommanterceros;
import com.mbn.sinod.model.entidades.Tsgnomtipoconcepto;
import com.mbn.sinod.model.entidades.Tsgnomtiponomina;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-12-05T11:39:33")
@StaticMetamodel(Tsgnomconcepto.class)
public class Tsgnomconcepto_ { 

    public static volatile SingularAttribute<Tsgnomconcepto, Integer> audCodcreadopor;
    public static volatile SingularAttribute<Tsgnomconcepto, Boolean> bolAplicaisn;
    public static volatile SingularAttribute<Tsgnomconcepto, Integer> cnuArticulo;
    public static volatile SingularAttribute<Tsgnomconcepto, String> codFrecuenciapago;
    public static volatile SingularAttribute<Tsgnomconcepto, Tsgnomcalculo> codCalculoidFk;
    public static volatile SingularAttribute<Tsgnomconcepto, Date> audFeccreacion;
    public static volatile SingularAttribute<Tsgnomconcepto, String> codNbconcepto;
    public static volatile SingularAttribute<Tsgnomconcepto, Integer> audCodmodificadopor;
    public static volatile SingularAttribute<Tsgnomconcepto, Integer> codConceptoid;
    public static volatile SingularAttribute<Tsgnomconcepto, Integer> codPartidaprep;
    public static volatile SingularAttribute<Tsgnomconcepto, Character> codGravado;
    public static volatile SingularAttribute<Tsgnomconcepto, Boolean> bolRetroactividad;
    public static volatile SingularAttribute<Tsgnomconcepto, Tsgnomconceptosat> codConceptosatidFk;
    public static volatile SingularAttribute<Tsgnomconcepto, Tsgnomtiponomina> codTiponominaidFk;
    public static volatile SingularAttribute<Tsgnomconcepto, Tsgnomformula> codFormulaidFk;
    public static volatile SingularAttribute<Tsgnomconcepto, String> cnuCuentacontable;
    public static volatile SingularAttribute<Tsgnomconcepto, String> codClaveconcepto;
    public static volatile ListAttribute<Tsgnomconcepto, Tsgnomcncptoquinc> tsgnomcncptoquincList;
    public static volatile SingularAttribute<Tsgnomconcepto, Character> codExcento;
    public static volatile SingularAttribute<Tsgnomconcepto, Tsgnomclasificador> codClasificadoridFk;
    public static volatile SingularAttribute<Tsgnomconcepto, Double> impMonto;
    public static volatile ListAttribute<Tsgnomconcepto, Tsgnomcncptoquincht> tsgnomcncptoquinchtList;
    public static volatile ListAttribute<Tsgnomconcepto, Tsgnommanterceros> tsgnommantercerosList;
    public static volatile SingularAttribute<Tsgnomconcepto, Integer> cnuTopeex;
    public static volatile SingularAttribute<Tsgnomconcepto, Tsgnomtipoconcepto> codTipoconceptoidFk;
    public static volatile SingularAttribute<Tsgnomconcepto, Date> audFecmodificacion;
    public static volatile SingularAttribute<Tsgnomconcepto, Boolean> bolEstatus;
    public static volatile SingularAttribute<Tsgnomconcepto, Integer> cnuPrioricalculo;

}