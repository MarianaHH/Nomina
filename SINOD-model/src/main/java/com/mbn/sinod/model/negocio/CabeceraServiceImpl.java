/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.negocio;

import com.mbn.sinod.model.comun.StaticConstantes;
import com.mbn.sinod.model.dao.CabeceraDAO;
import com.mbn.sinod.model.dto.CabeceraDTO;
import com.mbn.sinod.model.dto.EmpQuincenaPorCabeceraDTO;
import com.mbn.sinod.model.entidades.Tsgnomcabecera;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class CabeceraServiceImpl extends BaseServiceImpl<Tsgnomcabecera, Integer>
        implements CabeceraService {

    @Autowired
    private CabeceraDAO cabeceraDAO;
    private static final Logger logger = Logger.getLogger(CabeceraService.class.getName());

    @Override
    public CabeceraDTO listaCabeceras() {
        CabeceraDTO respuesta = new CabeceraDTO();

        try {
            List<Tsgnomcabecera> listaCabeceras
                    = ((CabeceraDAO) getGenericDAO()).listarCabeceras();

            if (listaCabeceras != null) {
                respuesta.setListarCabecera(listaCabeceras);
                respuesta.getListarCabecera().get(0).getCodNbnomina();
//                respuesta.setCodigoMensaje(StaticConstantes.EXITO_OBTENER_LISTA);
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_CORRECTO);
            } else {
                listaCabeceras = new ArrayList();
                respuesta.setListarCabecera(listaCabeceras);
//                respuesta.setCodigoMensaje(StaticConstantes.ERROR_OBTENER_LISTA);
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            }
        } catch (Exception e) {
            respuesta = new CabeceraDTO();
            respuesta.setCodigoMensaje(e.getMessage());
            respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            logger.getLogger(Tsgnomcabecera.class.getName()).log(Level.SEVERE, null, e);
        }

        return respuesta;
    }

    @Override
    @Transactional
    public CabeceraDTO guardarActualizarCabecera(CabeceraDTO cabecera) {
        CabeceraDTO respuesta = new CabeceraDTO();
        try {
            Integer respuestaGuardar
                    = ((CabeceraDAO) getGenericDAO()).guardarAtualizarCabecera(cabecera.getCabecera());

            if (respuestaGuardar > 0) {
//                respuesta.setCodigoMensaje(StaticConstantes.EXITO_GUARDAR_ENTIDAD_ACADEMICA);
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_CORRECTO);
                respuesta.setCabecera(cabecera.getCabecera());
                respuesta.getCabecera().setCodCabeceraid(respuestaGuardar);
            } else {
//                respuesta.setCodigoMensaje(StaticConstantes.ERROR_GUARDAR_ENTIDAD_ACADEMICA);
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
                respuesta.getCabecera().setCodCabeceraid(respuestaGuardar);
            }
        } catch (Exception e) {
            respuesta = new CabeceraDTO();
            respuesta.setCodigoMensaje(e.getMessage());
            respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            logger.getLogger(Tsgnomcabecera.class.getName()).log(Level.SEVERE, null, e);
        }
        return respuesta;
    }

    @Override
    @Transactional
    public CabeceraDTO calculaNomina(Integer cabeceraid) {
        CabeceraDTO respuesta = new CabeceraDTO();

        try {
            Boolean calculo
                    = ((CabeceraDAO) getGenericDAO()).calculaNomina(cabeceraid);
            if (calculo) {
                respuesta.setConfirmacion(calculo);
//                respuesta.setCodigoMensaje(StaticConstantes.EXITO_OBTENER_LISTA);
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_CORRECTO);
            } else {

                respuesta.setConfirmacion(calculo);
//                respuesta.setCodigoMensaje(StaticConstantes.ERROR_OBTENER_LISTA);
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            }
        } catch (Exception e) {
            respuesta = new CabeceraDTO();
            respuesta.setCodigoMensaje(e.getMessage());
            respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            logger.getLogger(Tsgnomcabecera.class.getName()).log(Level.SEVERE, null, e);
        }
        return respuesta;
    }

    @Override
    public EmpQuincenaPorCabeceraDTO listarEmpleadosCabecera(Integer cabeceraId) {
        EmpQuincenaPorCabeceraDTO respuesta = new EmpQuincenaPorCabeceraDTO();
        try {

            List<EmpQuincenaPorCabeceraDTO> listaEmpleadosCabecera = ((CabeceraDAO) getGenericDAO()).listarEmpleadosCabecera(cabeceraId);

            if (listaEmpleadosCabecera != null) {
                respuesta.setListaEmpQuincenaPorCabeceraDTO(listaEmpleadosCabecera);
                //declara las constantes
                respuesta.setCodigoMensaje(StaticConstantes.EXITO_LISTAR_EMPLEADOS_CABECERA);
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_CORRECTO);

            } else {
                respuesta.setListaEmpQuincenaPorCabeceraDTO(listaEmpleadosCabecera);
                //declara las constantes
                respuesta.setCodigoMensaje(StaticConstantes.ERROR_LISTAR_EMPLEADOS_CABECERA);
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            }
        } catch (Exception e) {
            respuesta = new EmpQuincenaPorCabeceraDTO();
            respuesta.setCodigoMensaje(StaticConstantes.ERROR_LISTAR_EMPLEADOS_CABECERA);
            respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);

            logger.getLogger(Tsgnomcabecera.class.getName()).log(Level.SEVERE, null, e);
        }
        return respuesta;
    }

    @Override
    public Tsgnomcabecera obtenerCabeceraPorId(Integer cabeceraId) {
        return this.cabeceraDAO.obtenerCabeceraPorId(cabeceraId);
    }

    @Transactional
    @Override
    public CabeceraDTO eliminarCabecera(Integer cabeceraId) {
        CabeceraDTO respuesta = new CabeceraDTO();

        try {
            boolean respuestaEliminar = ((CabeceraDAO) getGenericDAO()).eliminarCabecera(cabeceraId);
            if (respuestaEliminar) {

                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_CORRECTO);
                respuesta.setCodigoMensaje(StaticConstantes.EXITO_ELIMINAR_CABECERA);

            } else {
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            }
        } catch (Exception e) {
            respuesta = new CabeceraDTO();
            respuesta.setCodigoMensaje(e.getMessage());
            respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);

            logger.getLogger(Tsgnomcabecera.class.getName()).log(Level.SEVERE, null, e);
        }
        return respuesta;
    }

    @Override
    public CabeceraDTO validaPagosNomina(Integer cabecera) {
        CabeceraDTO respuesta = new CabeceraDTO();
        try {
            boolean respuestaGuardar
                    = ((CabeceraDAO) getGenericDAO()).validaPagosNomina(cabecera);

            if (respuestaGuardar) {
//                respuesta.setCodigoMensaje(StaticConstantes.EXITO_GUARDAR_ENTIDAD_ACADEMICA);
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_CORRECTO);
                respuesta.setConfirmacion(respuestaGuardar);
            } else {
//                respuesta.setCodigoMensaje(StaticConstantes.ERROR_GUARDAR_ENTIDAD_ACADEMICA);
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
                respuesta.setConfirmacion(respuestaGuardar);
            }
        } catch (Exception e) {
            respuesta = new CabeceraDTO();
            respuesta.setCodigoMensaje(e.getMessage());
            respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            logger.getLogger(Tsgnomcabecera.class.getName()).log(Level.SEVERE, null, e);
        }
        return respuesta;
    }

    @Transactional
    @Override
    public CabeceraDTO cargarImss(String archivo, Integer cabecera) {
        CabeceraDTO respuesta = new CabeceraDTO();
        try {
            boolean respuestaGuardar
                    = ((CabeceraDAO) getGenericDAO()).cargarImss(archivo, cabecera);

            if (respuestaGuardar) {
//                respuesta.setCodigoMensaje(StaticConstantes.EXITO_GUARDAR_ENTIDAD_ACADEMICA);
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_CORRECTO);
                respuesta.setConfirmacion(respuestaGuardar);
            } else {
//                respuesta.setCodigoMensaje(StaticConstantes.ERROR_GUARDAR_ENTIDAD_ACADEMICA);
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
                respuesta.setConfirmacion(respuestaGuardar);
            }
        } catch (Exception e) {
            respuesta = new CabeceraDTO();
            respuesta.setCodigoMensaje(e.getMessage());
            respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            logger.getLogger(Tsgnomcabecera.class.getName()).log(Level.SEVERE, null, e);
        }
        return respuesta;
    }

    /**
     * @return the caberaDAO
     */
    public CabeceraDAO getCabeceraDAO() {
        return cabeceraDAO;
    }

    /**
     * @param caberaDAO the caberaDAO to set
     */
    public void setCabeceraDAO(CabeceraDAO caberaDAO) {
        this.cabeceraDAO = caberaDAO;
    }
}
