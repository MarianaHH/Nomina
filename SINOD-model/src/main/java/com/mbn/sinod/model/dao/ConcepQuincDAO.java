/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.dao;

import com.googlecode.genericdao.dao.hibernate.GenericDAO;
import com.mbn.sinod.model.entidades.Tsgnomcncptoquinc;
import com.mbn.sinod.model.entidades.Tsgnomcncptoquincht;
import java.util.List;

/**
 *
 * @author User
 */
public interface ConcepQuincDAO extends GenericDAO<Tsgnomcncptoquinc, Integer>{
    List<Tsgnomcncptoquinc> listaConcepQuinc();
    List<Tsgnomcncptoquinc> listaConcepQuincByEmpQuin(Integer empQuin);
    List<Tsgnomcncptoquinc> listaConceptosEmpl (Integer empleado);
    List<Tsgnomcncptoquincht> listaConcepQuincByEmpQuinHT(Integer empQuin);
    List<Tsgnomcncptoquinc> listaConcepQuincByCabecera(Integer cabecera);
}
