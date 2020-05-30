/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.negocio;

import com.ibm.wsdl.ServiceImpl;
import com.mbn.sinod.model.comun.StaticConstantes;
import com.mbn.sinod.model.dao.IncidenciasQuincenaDAO;
import com.mbn.sinod.model.dto.IncidenciasQuincenaDTO;
import com.mbn.sinod.model.entidades.Tsgnomcatincidencia;
import java.util.List;
import java.util.logging.Logger;
import java.util.logging.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author mariana
 */
public class IncidenciasQuincenaServiceImpl extends BaseServiceImpl<Tsgnomcatincidencia, Integer> 
        implements IncidenciasQuincenaService {

    private static final Logger logger = Logger.getLogger(ServiceImpl.class.getName());
    
    @Autowired
    private IncidenciasQuincenaDAO incidenciasQuincenaDAO;
    
    @Override
    public IncidenciasQuincenaDTO listarincidenciasQuincena() {
        IncidenciasQuincenaDTO respuesta = new IncidenciasQuincenaDTO();
        try {

            List<IncidenciasQuincenaDTO> listaIncidencias = ((IncidenciasQuincenaDAO) getGenericDAO()).listarincidenciasQuincena();

            if (listaIncidencias != null) {
                respuesta.setListaIncidencias(listaIncidencias);
                //declara las constantes
                respuesta.setCodigoMensaje(StaticConstantes.EXITO_LISTAR_INCIDENCIAS_QUINCENA);
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_CORRECTO);

            } else {
                respuesta.setListaIncidencias(listaIncidencias);
                //declara las constantes
                respuesta.setCodigoMensaje(StaticConstantes.ERROR_LISTAR_INCIDENCIAS_QUINCENA);
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            }
        } catch (Exception e) {
            respuesta = new IncidenciasQuincenaDTO();
            respuesta.setCodigoMensaje(StaticConstantes.ERROR_LISTAR_INCIDENCIAS_QUINCENA);
            respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);

            logger.getLogger(IncidenciasQuincenaServiceImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        return respuesta;
    }

    @Transactional
    @Override
    public IncidenciasQuincenaDTO validarTodas(IncidenciasQuincenaDTO incidencia) {
        IncidenciasQuincenaDTO respuesta = new IncidenciasQuincenaDTO();
        try {
            boolean respuestaGuardar
                    = ((IncidenciasQuincenaDAO) getGenericDAO()).validarTodas(incidencia.getListaIncidencias());

            if (respuestaGuardar) {
//                respuesta.setCodigoMensaje(StaticConstantes.EXITO_GUARDAR_ENTIDAD_ACADEMICA);
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_CORRECTO);
                
                
                
                respuesta.setListaIncidencias(incidencia.getListaIncidencias());
            } else {
//                respuesta.setCodigoMensaje(StaticConstantes.ERROR_GUARDAR_ENTIDAD_ACADEMICA);
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            }
        } catch (Exception e) {
            respuesta = new IncidenciasQuincenaDTO();
            respuesta.setCodigoMensaje(e.getMessage());
            respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            logger.getLogger(Tsgnomcatincidencia.class.getName()).log(Level.SEVERE, null, e);
        }
        return respuesta;
    }
    
    @Transactional
    @Override
    public IncidenciasQuincenaDTO rechazarTodas(IncidenciasQuincenaDTO incidencia) {
       IncidenciasQuincenaDTO respuesta = new IncidenciasQuincenaDTO();
        try {
            boolean respuestaGuardar
                    = ((IncidenciasQuincenaDAO) getGenericDAO()).rechazarTodas(incidencia.getListaIncidencias());

            if (respuestaGuardar) {
//                respuesta.setCodigoMensaje(StaticConstantes.EXITO_GUARDAR_ENTIDAD_ACADEMICA);
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_CORRECTO);
                
                
                
                respuesta.setListaIncidencias(incidencia.getListaIncidencias());
            } else {
//                respuesta.setCodigoMensaje(StaticConstantes.ERROR_GUARDAR_ENTIDAD_ACADEMICA);
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            }
        } catch (Exception e) {
            respuesta = new IncidenciasQuincenaDTO();
            respuesta.setCodigoMensaje(e.getMessage());
            respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            logger.getLogger(Tsgnomcatincidencia.class.getName()).log(Level.SEVERE, null, e);
        }
        return respuesta;
        
    }

    @Transactional
    @Override
    public IncidenciasQuincenaDTO validarIncidencias(IncidenciasQuincenaDTO incidencia) {
         IncidenciasQuincenaDTO respuesta = new IncidenciasQuincenaDTO();
        try {
            boolean respuestaGuardar
                    = ((IncidenciasQuincenaDAO) getGenericDAO()).validarIncidencias(incidencia.getListaIncidencias());

            if (respuestaGuardar) {
//                respuesta.setCodigoMensaje(StaticConstantes.EXITO_GUARDAR_ENTIDAD_ACADEMICA);
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_CORRECTO);
                
                
                
                respuesta.setListaIncidencias(incidencia.getListaIncidencias());
            } else {
//                respuesta.setCodigoMensaje(StaticConstantes.ERROR_GUARDAR_ENTIDAD_ACADEMICA);
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            }
        } catch (Exception e) {
            respuesta = new IncidenciasQuincenaDTO();
            respuesta.setCodigoMensaje(e.getMessage());
            respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            logger.getLogger(Tsgnomcatincidencia.class.getName()).log(Level.SEVERE, null, e);
        }
        return respuesta;
    }

    @Transactional
    @Override
    public IncidenciasQuincenaDTO autorizarIncidencias(IncidenciasQuincenaDTO incidencias) {
        IncidenciasQuincenaDTO respuesta = new IncidenciasQuincenaDTO();
        try {
            boolean respuestaGuardar
                    = ((IncidenciasQuincenaDAO) getGenericDAO()).autorizarIncidencias(incidencias.getListaIncidencias());

            if (respuestaGuardar) {
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_CORRECTO);
                respuesta.setListaIncidencias(incidencias.getListaIncidencias());
            } else {
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            }
        } catch (Exception e) {
            respuesta = new IncidenciasQuincenaDTO();
            respuesta.setCodigoMensaje(e.getMessage());
            respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            logger.getLogger(Tsgnomcatincidencia.class.getName()).log(Level.SEVERE, null, e);
        }
        return respuesta;
    }

    @Transactional
    @Override
    public IncidenciasQuincenaDTO autorizarTodas(IncidenciasQuincenaDTO incidencias) {
        IncidenciasQuincenaDTO respuesta = new IncidenciasQuincenaDTO();
        try {
            boolean respuestaGuardar
                    = ((IncidenciasQuincenaDAO) getGenericDAO()).autorizarTodas(incidencias.getListaIncidencias());

            if (respuestaGuardar) {
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_CORRECTO);
                respuesta.setListaIncidencias(incidencias.getListaIncidencias());
            } else {
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            }
        } catch (Exception e) {
            respuesta = new IncidenciasQuincenaDTO();
            respuesta.setCodigoMensaje(e.getMessage());
            respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            logger.getLogger(Tsgnomcatincidencia.class.getName()).log(Level.SEVERE, null, e);
        }
        return respuesta;
    }

    @Transactional
    @Override
    public IncidenciasQuincenaDTO denegarTodas(IncidenciasQuincenaDTO incidencias) {
        IncidenciasQuincenaDTO respuesta = new IncidenciasQuincenaDTO();
        try {
            boolean respuestaGuardar
                    = ((IncidenciasQuincenaDAO) getGenericDAO()).denegarTodas(incidencias.getListaIncidencias());

            if (respuestaGuardar) {
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_CORRECTO);
                respuesta.setListaIncidencias(incidencias.getListaIncidencias());
            } else {
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            }
        } catch (Exception e) {
            respuesta = new IncidenciasQuincenaDTO();
            respuesta.setCodigoMensaje(e.getMessage());
            respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            logger.getLogger(Tsgnomcatincidencia.class.getName()).log(Level.SEVERE, null, e);
        }
        return respuesta;
    }

    @Override
    public IncidenciasQuincenaDTO incidenciasQuincenaPorArea(int area) {
        IncidenciasQuincenaDTO respuesta = new IncidenciasQuincenaDTO();
        try {

            List<IncidenciasQuincenaDTO> listaIncidencias = ((IncidenciasQuincenaDAO) getGenericDAO()).incidenciasQuincenaPorArea(area);

            if (listaIncidencias != null) {
                respuesta.setListaIncidencias(listaIncidencias);
                //declara las constantes
                respuesta.setCodigoMensaje(StaticConstantes.EXITO_LISTAR_INCIDENCIAS_QUINCENA);
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_CORRECTO);

            } else {
                respuesta.setListaIncidencias(listaIncidencias);
                //declara las constantes
                respuesta.setCodigoMensaje(StaticConstantes.ERROR_LISTAR_INCIDENCIAS_QUINCENA);
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            }
        } catch (Exception e) {
            respuesta = new IncidenciasQuincenaDTO();
            respuesta.setCodigoMensaje(StaticConstantes.ERROR_LISTAR_INCIDENCIAS_QUINCENA);
            respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);

            logger.getLogger(IncidenciasQuincenaServiceImpl.class.getName()).log(Level.SEVERE, null, e);
        }
        return respuesta;
    }
    
    @Transactional
    @Override
    public IncidenciasQuincenaDTO autorizarPagoIncidencias(IncidenciasQuincenaDTO incidencias) {
        IncidenciasQuincenaDTO respuesta = new IncidenciasQuincenaDTO();
        try {
            boolean respuestaGuardar
                    = ((IncidenciasQuincenaDAO) getGenericDAO()).autorizarPagoIncidencias(incidencias.getListaIncidencias());

            if (respuestaGuardar) {
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_CORRECTO);
                respuesta.setListaIncidencias(incidencias.getListaIncidencias());
            } else {
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            }
        } catch (Exception e) {
            respuesta = new IncidenciasQuincenaDTO();
            respuesta.setCodigoMensaje(e.getMessage());
            respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            logger.getLogger(Tsgnomcatincidencia.class.getName()).log(Level.SEVERE, null, e);
        }
        return respuesta;
    }

    @Transactional
    @Override
    public IncidenciasQuincenaDTO denegarPagoIncidencias(IncidenciasQuincenaDTO incidencias) {
        IncidenciasQuincenaDTO respuesta = new IncidenciasQuincenaDTO();
        try {
            boolean respuestaGuardar
                    = ((IncidenciasQuincenaDAO) getGenericDAO()).denegarPagoIncidencias(incidencias.getListaIncidencias());

            if (respuestaGuardar) {
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_CORRECTO);
                respuesta.setListaIncidencias(incidencias.getListaIncidencias());
            } else {
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            }
        } catch (Exception e) {
            respuesta = new IncidenciasQuincenaDTO();
            respuesta.setCodigoMensaje(e.getMessage());
            respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            logger.getLogger(Tsgnomcatincidencia.class.getName()).log(Level.SEVERE, null, e);
        }
        return respuesta;
    }

    @Transactional
    @Override
    public IncidenciasQuincenaDTO autorizarPagosIncidencias(IncidenciasQuincenaDTO incidencias) {
        IncidenciasQuincenaDTO respuesta = new IncidenciasQuincenaDTO();
        try {
            boolean respuestaGuardar
                    = ((IncidenciasQuincenaDAO) getGenericDAO()).autorizarPagosIncidencias(incidencias.getListaIncidencias());

            if (respuestaGuardar) {
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_CORRECTO);
                respuesta.setListaIncidencias(incidencias.getListaIncidencias());
            } else {
                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            }
        } catch (Exception e) {
            respuesta = new IncidenciasQuincenaDTO();
            respuesta.setCodigoMensaje(e.getMessage());
            respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
            logger.getLogger(Tsgnomcatincidencia.class.getName()).log(Level.SEVERE, null, e);
        }
        return respuesta;
    }

    @Transactional(readOnly = false)
    @Override
    public boolean posponerPagoIncidencia(Integer incidenciaid, String comentarios, Integer modifica) {
        return getIncidenciasQuincenaDAO().posponerPagoIncidencia(incidenciaid, comentarios, modifica);
    }

    public IncidenciasQuincenaDAO getIncidenciasQuincenaDAO() {
        return incidenciasQuincenaDAO;
    }

    public void setIncidenciasQuincenaDAO(IncidenciasQuincenaDAO incidenciasQuincenaDAO) {
        this.incidenciasQuincenaDAO = incidenciasQuincenaDAO;
    }
    
}
