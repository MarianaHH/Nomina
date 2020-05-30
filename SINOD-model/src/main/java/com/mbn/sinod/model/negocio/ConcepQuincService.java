/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.negocio;

import com.mbn.sinod.model.dto.ConcepQuincDTO;
import com.mbn.sinod.model.dto.ConcepQuincHTDTO;
import com.mbn.sinod.model.entidades.Tsgnomcncptoquinc;

/**
 *
 * @author User
 */
public interface ConcepQuincService extends BaseService<Tsgnomcncptoquinc, Integer>{
    ConcepQuincDTO listaConcepQuinc();
    ConcepQuincDTO listaConcepQuincByEmpQuin(Integer empQuinc);
    ConcepQuincDTO listaConceptosEmpl (Integer empleado);
    ConcepQuincHTDTO listaConcepQuincByEmpQuinHT(Integer empQuinc);
    ConcepQuincDTO listaConcepQuincByCabecera(Integer cabecera);
}
