/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.model.negocio;

import com.ibm.wsdl.ServiceImpl;
import com.mbn.sinod.model.dto.DesgloseDTO;
import com.mbn.sinod.model.entidades.Tsgnomcncptoquinc;
import org.springframework.beans.factory.annotation.Autowired;
import com.mbn.sinod.model.dao.DetalleDesgloseDAO;
import com.mbn.sinod.model.dto.DetalleDesgloseDTO;
import java.util.List;
import java.util.logging.Logger;

public class DetalleDesgloseServiceImpl extends BaseServiceImpl<Tsgnomcncptoquinc, Integer>
        implements DetalleDesgloseService {
    private static final Logger logger = Logger.getLogger(ServiceImpl.class.getName());


    @Autowired
    private DetalleDesgloseDAO detalleDesgloseDAO;

    @Override
    public DesgloseDTO desgloseDTO(Integer cod_empleado, Integer cod_cabecera) {
        DesgloseDTO dto = new DesgloseDTO();
        dto.setGetListaConcep(getDetalleDesgloseDAO().conceptosPorEmp(cod_empleado, cod_cabecera));
        return dto;
        
//        DesgloseDTO dto = new DesgloseDTO();
//        dto.setGetListaConcep(getDetalleDesgloseDAO().conceptosPorEmp(cod_empleado, cod_cabecera));
//        System.out.println("SERVICE del Desglose va bien ");
//        return dto;
//        
        
//        DesgloseDTO respuesta = new DesgloseDTO();
//        try {
//
//            List<DetalleDesgloseDTO> listargumentos = ((DetalleDesgloseDAO) getGenericDAO()).conceptosPorEmp(cod_empleado, cod_cabecera);
//
//            if (listargumentos != null) {
//                respuesta.setListaArgumentos(listargumentos);
//                //declara las constantes
//                respuesta.setCodigoMensaje(StaticConstantes.EXITO_OBTENER_LISTA_ARGUMENTOS);
//                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_CORRECTO);
//
//            } else {
//                respuesta.setListaArgumentos(listargumentos);
//                //declara las constantes
//                respuesta.setCodigoMensaje(StaticConstantes.ERROR_OBTENER_LISTA_ARGUMENTOS);
//                respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
//            }
//        } catch (Exception e) {
//            respuesta = new ArgumentoDTO();
//            respuesta.setCodigoMensaje(StaticConstantes.ERROR_OBTENER_LISTA_ARGUMENTOS);
//            respuesta.setTipoMensaje(StaticConstantes.MENSAJE_ERROR);
//
//            logger.getLogger(ArgumentoServiceImpl.class.getName()).log(Level.SEVERE, null, e);
//        }
//        return respuesta;
    }

    /**
     * @return the detalleDesgloseDAO
     */
    public DetalleDesgloseDAO getDetalleDesgloseDAO() {
        return detalleDesgloseDAO;
    }

    /**
     * @param detalleDesgloseDAO the detalleDesgloseDAO to set
     */
    public void setDetalleDesgloseDAO(DetalleDesgloseDAO detalleDesgloseDAO) {
        this.detalleDesgloseDAO = detalleDesgloseDAO;
    }

}
