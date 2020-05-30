/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.negocio;

import com.mbn.sinod.model.dto.FormulaDTO;
import com.mbn.sinod.model.entidades.Tsgnomformula;

/**
 *
 * @author ambrosio
 */
public interface FormulaService extends BaseService<Tsgnomformula, Integer>{

    /**
     *
     * @return
     */
    FormulaDTO listarFormulas();
    FormulaDTO guardar(FormulaDTO argumento);
}
