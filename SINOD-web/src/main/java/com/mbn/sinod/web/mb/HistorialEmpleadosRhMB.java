/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.web.mb;

import com.mbn.sinod.model.dto.DetalleDesgloseXMLDTO;
import com.mbn.sinod.model.dto.EmpleadosCabeceraDTO;
import com.mbn.sinod.model.dto.HistorialEmpleadosRhDTO;
import com.mbn.sinod.model.dto.InfoHistorialRhDTO;
import com.mbn.sinod.model.dto.VerInformacionDePersonalDTO;
import com.mbn.sinod.model.entidades.Tsgnomcncptoquinc;
import com.mbn.sinod.model.entidades.Tsgnomempquincena;
import com.mbn.sinod.web.client.ConcepQuincWSClient;
import com.mbn.sinod.web.client.HistorialEmpleadosRhWSClient;
import com.mbn.sinod.web.client.SumaDesgloseWSClient;
import com.mbn.sinod.web.client.VerInformacionDePersonalWSClient;
import java.io.IOException;
import java.io.Serializable;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.deltaspike.core.api.scope.ViewAccessScoped;
import org.apache.log4j.Logger;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;


/**
 *
 * @author Ivette
 */
@Named(value = "historialEmpleadosRhMB")
@ViewAccessScoped
public class HistorialEmpleadosRhMB implements Serializable {
    
    private List<HistorialEmpleadosRhDTO> historialEmpleadosRh;
    HistorialEmpleadosRhDTO empleadoSeleccionado;
    private VerInformacionDePersonalDTO detalleSeleccionado;
    InfoHistorialRhDTO infoEmpleado;
    private Integer cod_empleado;
    private List<Tsgnomcncptoquinc> listaConcepQuincena;
    private ArrayList<DetalleDesgloseXMLDTO> listaDdxmldto;
    private DetalleDesgloseXMLDTO ddxmldto;
    private Document doc;
    private List<EmpleadosCabeceraDTO> listaEmpleadosCabecera;
    private ArrayList<DetalleDesgloseXMLDTO> listaDetalleConceptos;
    

   
    private final static Logger logger = Logger.getLogger(HistorialEmpleadosRhMB.class); 
    
    @PostConstruct//PERMITE QUE NUESTRA CLASE SE INICIALIZE CUANDO SEA LLAMADA
    public void iniciarVariables() {
       DetalleEmpleadosMB detalleEmpMB = new DetalleEmpleadosMB();
       setCod_empleado(detalleEmpMB.getCod_empleado());
       historialEmpleadosRh =  new ArrayList<>();
       setDetalleSeleccionado(VerInformacionDePersonalWSClient.informacionPorEmpleado(cod_empleado).get(0));
       setHistorialEmpleadosRh(HistorialEmpleadosRhWSClient.informacionHistorial(cod_empleado));
       //detallesConceptos(cod_empleado);
    }
    
     public void detallesConceptos(Integer ecdto){
        setListaConcepQuincena(ConcepQuincWSClient.listarConceptosByEmpQuin(ecdto).getListCncptoquinc());
        setListaDetalleConceptos(new ArrayList<>());
        setListaDdxmldto(new ArrayList<>());
        for (int i = 0; i < getListaConcepQuincena().size(); i++) { 
            setDdxmldto(new DetalleDesgloseXMLDTO());
            DocumentBuilder documentBuilder = null;
            try {
                documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            } catch (ParserConfigurationException ex) {
                java.util.logging.Logger.getLogger(HistorialEmpleadosRhMB.class.getName()).log(Level.SEVERE, null, ex);
            }
            InputSource inputSource = new InputSource();
            inputSource.setCharacterStream(new StringReader(getListaConcepQuincena().get(i).getXmlDesgloce()));
            try {
                setDoc(documentBuilder.parse(inputSource));
                getDoc().getDocumentElement().normalize();
                getDdxmldto().setValorConcepto(getDoc().getElementsByTagName("valor").item(0).getTextContent());
                getDdxmldto().setValorMes(getDoc().getElementsByTagName("valor").item(1).getTextContent());
                getDdxmldto().setValorLab(getDoc().getElementsByTagName("valor").item(2).getTextContent());
                getDdxmldto().setImporte(getDoc().getElementsByTagName("importe").item(0).getTextContent());
                System.out.println("ERROR HISTORIAL POR EMPLEADO ");
                

                getListaDdxmldto().add(i, getDdxmldto());
            } catch (SAXException | IOException ex) {
                java.util.logging.Logger.getLogger(HistorialEmpleadosRhMB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

     
     

    public List<HistorialEmpleadosRhDTO> getHistorialEmpleadosRh() {
        return historialEmpleadosRh;
    }

    public void setHistorialEmpleadosRh(List<HistorialEmpleadosRhDTO> historialEmpleadosRh) {
        this.historialEmpleadosRh = historialEmpleadosRh;
    }
    
     public Integer getCod_empleado() {
        return cod_empleado;
    }

    public void setCod_empleado(Integer cod_empleado) {
        this.cod_empleado = cod_empleado;
    }
    
    public HistorialEmpleadosRhDTO getEmpleadoSeleccionado() {
        return empleadoSeleccionado;
    }

    public void setEmpleadoSeleccionado(HistorialEmpleadosRhDTO empleadoSeleccionado) {
        this.empleadoSeleccionado = empleadoSeleccionado;
    }
    
     public VerInformacionDePersonalDTO getDetalleSeleccionado() {
        return detalleSeleccionado;
    }

    public void setDetalleSeleccionado(VerInformacionDePersonalDTO detalleSeleccionado) {
        this.detalleSeleccionado = detalleSeleccionado;
    }
    
    public InfoHistorialRhDTO getInfoEmpleado() {
        return infoEmpleado;
    }

    public void setInfoEmpleado(InfoHistorialRhDTO infoEmpleado) {
        this.infoEmpleado = infoEmpleado;
    }

    public List<Tsgnomcncptoquinc> getListaConcepQuincena() {
        return listaConcepQuincena;
    }

    public void setListaConcepQuincena(List<Tsgnomcncptoquinc> listaConcepQuincena) {
        this.listaConcepQuincena = listaConcepQuincena;
    }

    public ArrayList<DetalleDesgloseXMLDTO> getListaDdxmldto() {
        return listaDdxmldto;
    }

    public void setListaDdxmldto(ArrayList<DetalleDesgloseXMLDTO> listaDdxmldto) {
        this.listaDdxmldto = listaDdxmldto;
    }

    public DetalleDesgloseXMLDTO getDdxmldto() {
        return ddxmldto;
    }

    public void setDdxmldto(DetalleDesgloseXMLDTO ddxmldto) {
        this.ddxmldto = ddxmldto;
    }
    
    public Document getDoc() {
        return doc;
    }

    public void setDoc(Document doc) {
        this.doc = doc;
    }
    
    public List<EmpleadosCabeceraDTO> getListaEmpleadosCabecera() {
        return listaEmpleadosCabecera;
    }

    public void setListaEmpleadosCabecera(List<EmpleadosCabeceraDTO> listaEmpleadosCabecera) {
        this.listaEmpleadosCabecera = listaEmpleadosCabecera;
    }
    
    public ArrayList<DetalleDesgloseXMLDTO> getListaDetalleConceptos() {
        return listaDetalleConceptos;
    }

    public void setListaDetalleConceptos(ArrayList<DetalleDesgloseXMLDTO> listaDetalleConceptos) {
        this.listaDetalleConceptos = listaDetalleConceptos;
    }
    
    
  
}
