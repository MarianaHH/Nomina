package com.mbn.sinod.model.entidades;

import com.mbn.sinod.model.entidades.Tsgrhareas;
import com.mbn.sinod.model.entidades.Tsgrhempleados;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2019-12-05T11:39:33")
@StaticMetamodel(Tsgrhpuestos.class)
public class Tsgrhpuestos_ { 

    public static volatile SingularAttribute<Tsgrhpuestos, String> desPuesto;
    public static volatile ListAttribute<Tsgrhpuestos, Tsgrhempleados> tsgrhempleadosList;
    public static volatile SingularAttribute<Tsgrhpuestos, String> codAcronimo;
    public static volatile SingularAttribute<Tsgrhpuestos, Tsgrhareas> codArea;
    public static volatile SingularAttribute<Tsgrhpuestos, Integer> codPuesto;

}