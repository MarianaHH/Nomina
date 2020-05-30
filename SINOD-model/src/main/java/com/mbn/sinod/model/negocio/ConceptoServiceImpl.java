/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.negocio;

import com.mbn.sinod.model.comun.StaticConstantes;
import com.mbn.sinod.model.dao.ConceptoDAO;
import com.mbn.sinod.model.dto.ConceptoDTO;
import com.mbn.sinod.model.entidades.Tsgnomconcepto;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.transaction.annotation.Transactional;

public class ConceptoServiceImpl extends BaseServiceImpl<Tsgnomconcepto, Integer> implements ConceptoService {

    private static final Logger logger = Logger.getLogger(ConceptoService.class.getName());

    @Override
    public ConceptoDTO listarConceptos() {
        ConceptoDTO respuesta = new ConceptoDTO();

        try {
            List<Tsgnomconcepto> listCatInci
                    = ((ConceptoDAO) getGenericDAO()).listarConcepto();

            if (listCatInci != null) {
                respuesta.setListConceptos(listCatInci);
//                respuesta.setCodigoMensaje(StaticConstantes.EXITO_OBTENER_LISTA);
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_CORRECTO);
            } else {
                listCatInci = new ArrayList();
                respuesta.setListConceptos(listCatInci);
//                respuesta.setCodigoMensaje(StaticConstantes.ERROR_OBTENER_LISTA);
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            }
        } catch (Exception e) {
            respuesta = new ConceptoDTO();
            respuesta.setCodigoMensaje(e.getMessage());
            respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            logger.getLogger(Tsgnomconcepto.class.getName()).log(Level.SEVERE, null, e);
        }

        return respuesta;
    }

    @Transactional
    @Override
    public ConceptoDTO eliminarConcepto(Integer conceptoId) {
        ConceptoDTO respuesta = new ConceptoDTO();

        try {
            boolean respuestaEliminar = ((ConceptoDAO) getGenericDAO()).eliminarConcepto(conceptoId);
            if (respuestaEliminar) {

                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_CORRECTO);
                respuesta.setCodigoMensaje(StaticConstantes.ERROR_ELIMINAR_CONCEPTO);

            } else {
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            }
        } catch (Exception e) {
            respuesta = new ConceptoDTO();
            respuesta.setCodigoMensaje(e.getMessage());
            respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);

            logger.getLogger(Tsgnomconcepto.class.getName()).log(Level.SEVERE, null, e);
        }
        return respuesta;
    }

    @Transactional
    @Override
    public ConceptoDTO guardarConcepto(ConceptoDTO concepto) {
        ConceptoDTO respuesta = new ConceptoDTO();
        try {
            boolean respuestaGuardar
                    = ((ConceptoDAO) getGenericDAO()).guardarConcepto(concepto.getConcepto());

            if (respuestaGuardar) {
//                respuesta.setCodigoMensaje(StaticConstantes.EXITO_GUARDAR_ENTIDAD_ACADEMICA);
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_CORRECTO);
                respuesta.setConcepto(concepto.getConcepto());
            } else {
//                respuesta.setCodigoMensaje(StaticConstantes.ERROR_GUARDAR_ENTIDAD_ACADEMICA);
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            }
        } catch (Exception e) {
            respuesta = new ConceptoDTO();
            respuesta.setCodigoMensaje(e.getMessage());
            respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            logger.getLogger(Tsgnomconcepto.class.getName()).log(Level.SEVERE, null, e);
        }
        return respuesta;
    }

    @Transactional
    @Override
    public ConceptoDTO guardarPrioridad(ConceptoDTO concepto) {
        ConceptoDTO respuesta = new ConceptoDTO();
        try {
            boolean respuestaGuardar
                    = ((ConceptoDAO) getGenericDAO()).guardarPrioridad(concepto.getListConceptos());

            if (respuestaGuardar) {
//                respuesta.setCodigoMensaje(StaticConstantes.EXITO_GUARDAR_ENTIDAD_ACADEMICA);
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_CORRECTO);
                respuesta.setListConceptos(concepto.getListConceptos());
            } else {
//                respuesta.setCodigoMensaje(StaticConstantes.ERROR_GUARDAR_ENTIDAD_ACADEMICA);
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            }
        } catch (Exception e) {
            respuesta = new ConceptoDTO();
            respuesta.setCodigoMensaje(e.getMessage());
            respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            logger.getLogger(Tsgnomconcepto.class.getName()).log(Level.SEVERE, null, e);
        }
        return respuesta;
    }

    @Override
    public ConceptoDTO listarConceptosPercepcion() {
        ConceptoDTO respuesta = new ConceptoDTO();
        try {

            List<Tsgnomconcepto> listarconceptos = ((ConceptoDAO) getGenericDAO()).listarConceptosPercepcion();

            if (listarconceptos != null) {
                respuesta.setListConceptos(listarconceptos);
                //declara las constantes
//                respuesta.setCodigoMensaje(StaticConstantes.EXITO_LISTAR_CONCEPTOS_PERCEPCION);
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_CORRECTO);

            } else {
                respuesta.setListConceptos(listarconceptos);
                //declara las constantes
//                respuesta.setCodigoMensaje(StaticConstantes.ERROR_LISTAR_CONCEPTOS_PERCEPCION);
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            }
        } catch (Exception e) {
            respuesta = new ConceptoDTO();
//            respuesta.setCodigoMensaje(StaticConstantes.ERROR_LISTAR_CONCEPTOS_PERCEPCION);
            respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);

            logger.getLogger(Tsgnomconcepto.class.getName()).log(Level.SEVERE, null, e);
        }
        return respuesta;
    }

    @Override
    public ConceptoDTO listarConceptosDeduccion() {
        ConceptoDTO respuesta = new ConceptoDTO();
        try {

            List<Tsgnomconcepto> listarconceptos = ((ConceptoDAO) getGenericDAO()).listarConceptosDeduccion();

            if (listarconceptos != null) {
                respuesta.setListConceptos(listarconceptos);
                //declara las constantes
//                respuesta.setCodigoMensaje(StaticConstantes.EXITO_LISTAR_CONCEPTOS_DEDUCCION);
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_CORRECTO);

            } else {
                respuesta.setListConceptos(listarconceptos);
                //declara las constantes
//                respuesta.setCodigoMensaje(StaticConstantes.ERROR_LISTAR_CONCEPTOS_DEDUCCION);
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            }
        } catch (Exception e) {
            respuesta = new ConceptoDTO();
//            respuesta.setCodigoMensaje(StaticConstantes.ERROR_LISTAR_CONCEPTOS_DEDUCCION);
            respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);

            logger.getLogger(Tsgnomconcepto.class.getName()).log(Level.SEVERE, null, e);
        }
        return respuesta;
    }

}
