/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mbn.sinod.web.mb;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mbn.sinod.model.dto.CabeceraDTO;
import com.mbn.sinod.model.entidades.Tsgnomcabecera;
import com.mbn.sinod.model.entidades.Tsgnomestatusnom;
import com.mbn.sinod.model.entidades.Tsgnomquincena;
import com.mbn.sinod.model.entidades.Tsgnomtiponomina;
import com.mbn.sinod.model.entidades.Tsgrhempleados;
import com.mbn.sinod.model.entidades.Usuario;
import com.mbn.sinod.web.client.CabecerasWSClient;
import com.mbn.sinod.web.client.EstatusNominaWSClient;
import com.mbn.sinod.web.client.QuincenasWSClient;
import com.mbn.sinod.web.client.TipoNominaWSClient;
import com.mbn.sinod.web.util.ResourceBundles;
import com.mbn.sinod.web.util.StaticsConstants;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.deltaspike.core.api.scope.ViewAccessScoped;
import org.primefaces.context.RequestContext;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author Ambrosio
 */
@Named(value = "nominaAdminMB")
@ViewAccessScoped
public class NominaAdminMB implements Serializable {

    private static final ResourceBundle BUNDLE = ResourceBundle.getBundle(ResourceBundles.MESSAGES.getBundleName());
    private Tsgrhempleados empleado;
    private Usuario usuario;
    private Tsgnomtiponomina tipoNominaSelecionado;
    private Tsgnomquincena quincenaSeleccionada;
    private Tsgnomcabecera cabeceraSeleccionada;
    private List<Tsgnomcabecera> listaCabecera;
    private List<Tsgnomtiponomina> listaTipoNomina;
    private List<Tsgnomquincena> listaQuincenas;
    private List<Tsgnomestatusnom> listaEstatusNomina;
    private String espacio = " / ";
    private int index = 0;
    private UploadedFile archivoCSV;
    private Boolean activo;
    private Boolean activarGuardar;
    private Boolean activarBtn;

    @PostConstruct
    public void iniciarVariables() {
        this.setEmpleado((Tsgrhempleados) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("empleado"));
        this.setUsuario((Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario"));
        setActivo(true);
        setActivarBtn(true);
        setActivarGuardar(true);
        setListaCabecera(CabecerasWSClient.listaCabecera());
        setListaQuincenas(QuincenasWSClient.listarQuincenasFuturas());
        setListaTipoNomina(TipoNominaWSClient.listarTipoNomina());
        setListaEstatusNomina(EstatusNominaWSClient.listarEstatusNomina());
    }

    public void detalle(Tsgnomcabecera cabecera) throws IOException {
        try {
            HttpServletResponse httpServletResponse = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
            Cookie cabeceraCookie = new Cookie("mbnCmbn", String.valueOf(cabecera.getCodCabeceraid()));
            cabeceraCookie.setPath("/");
            httpServletResponse.addCookie(cabeceraCookie);
        } catch (Exception e) {
            Logger.getLogger(NominaAdminMB.class.getName()).log(Level.SEVERE, null, e);
        }
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext externalContext = context.getExternalContext();
        HttpServletRequest originRequest = (HttpServletRequest) externalContext.getRequest();
        String scheme = originRequest.getScheme();
        String server = originRequest.getServerName();
        int port = originRequest.getServerPort();
        String URL_Detalle = scheme + "://" + server + ":" + port + "" + "/SINOD-web/Nomina/Consultar.xhtml";
        context.getExternalContext().redirect(URL_Detalle);
    }

    public void dialogoAgregarNomina() {
        setCabeceraSeleccionada(new Tsgnomcabecera());
        setQuincenaSeleccionada(new Tsgnomquincena());
        setTipoNominaSelecionado(new Tsgnomtiponomina());
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('agregarNominaDialogo').show();");
    }

    public void dialogoEliminar(Tsgnomcabecera cabecera) {
        setCabeceraSeleccionada(cabecera);
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('dialogEliminar').show();");
    }

    public void cerrarDialogo() {
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('agregarNominaDialogo').hide();");
        setActivo(true);
    }

    public void validar() {
        if (!getQuincenaSeleccionada().getCodQuincenaid().equals(null)
                && !getTipoNominaSelecionado().getCodTiponominaid().equals(null)) {
            setActivo(false);
            setActivarBtn(true);
            setActivarGuardar(true);
        } else {
            setActivo(true);
        }
    }

    public void upload(FileUploadEvent event) throws IOException {
        setArchivoCSV(event.getFile());
        File carpeta = new File("/tmp/archivos");
        //File carpeta = new File("/home/mariana/prueba");
        if (!carpeta.exists()) {
            if (carpeta.mkdirs()) {
                System.out.println("ya se creo la carpeta");
            }
        }
        crearArchivo();

    }

    public void crearArchivo() throws IOException {
        if (getArchivoCSV() != null) {
            String ruta = "/tmp/archivos/" + getArchivoCSV().getFileName();
            //String ruta ="/home/mariana/prueba/hola.txt";
            File archivo = new File(ruta);
            BufferedWriter bw;
  
            if (archivo.exists()) {
                bw = new BufferedWriter(new FileWriter(archivo));
                bw.write("El fichero de texto ya estaba creado.");
                generarMensaje("El archivo ya existe", FacesMessage.SEVERITY_ERROR);
            } else {
                bw = new BufferedWriter(new FileWriter(archivo));
                bw.write("Acabo de crear el fichero de texto.");
                setActivarGuardar(false);
                System.out.println("ruta: " +archivo.getAbsolutePath());
                generarMensaje("El archivo se guardo correctamente", FacesMessage.SEVERITY_INFO);
            }
            bw.close();
        }

    }

    public void crearNomina() {
        Integer cabecera = null;
        try {
            getCabeceraSeleccionada().setAudCodcreadopor(getEmpleado().getCodEmpleado());
            getCabeceraSeleccionada().setAudFeccreacion(new Date());
            getCabeceraSeleccionada().setFecCreacion(new Date());
            getCabeceraSeleccionada().setImpTotdeduccion(BigDecimal.ZERO);
            getCabeceraSeleccionada().setImpTotpercepcion(BigDecimal.ZERO);
            getCabeceraSeleccionada().setImpTotalemp(BigDecimal.ZERO);
            getCabeceraSeleccionada().setCodEstatusnomidFk(getListaEstatusNomina().get(0));
            getCabeceraSeleccionada().setCodTiponominaidFk(getTipoNominaSelecionado());
            getCabeceraSeleccionada().setCodQuincenaidFk(getQuincenaSeleccionada());
            getCabeceraSeleccionada().setCodNbnomina(getTipoNominaSelecionado().getCodNomina().
                    concat(getEspacio().concat(getQuincenaSeleccionada().getDesQuincena().
                            concat(getEspacio().concat(String.valueOf(getQuincenaSeleccionada().getCodEjercicioidFk().getCnuValorejercicio()))))));
            CabeceraDTO dto = new CabeceraDTO();
            dto.setCabecera(getCabeceraSeleccionada());
//            if (CabecerasWSClient.guardarCabecera(dto).getConfirmacion()) {
            cabecera = CabecerasWSClient.guardarCabecera(dto).getCabecera().getCodCabeceraid();
            if (cabecera > 0) {
                if (CabecerasWSClient.cargarImss(getArchivoCSV().getFileName(), cabecera).getConfirmacion()) {
                    setListaCabecera(CabecerasWSClient.listaCabecera());
                    RequestContext context = RequestContext.getCurrentInstance();
                    generarMensaje(BUNDLE.getString(StaticsConstants.EXITO_GUARDADO), FacesMessage.SEVERITY_INFO);
                    context.execute("PF('agregarNominaDialogo').hide();");
                } else {
                    File fichero = new File("\\tmp\\" + getArchivoCSV().getFileName());
                    fichero.delete();
                    generarMensaje(BUNDLE.getString(StaticsConstants.ERROR_GUARDADO), FacesMessage.SEVERITY_ERROR);
                }
            } else {
                generarMensaje(BUNDLE.getString(StaticsConstants.ERROR_GUARDADO), FacesMessage.SEVERITY_ERROR);
            }
        } catch (JsonProcessingException ex) {
            Logger.getLogger(NominaAdminMB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void eliminarCabecera() throws JsonProcessingException {
        CabecerasWSClient.eliminarCabecera(getCabeceraSeleccionada().getCodCabeceraid());
        getListaCabecera().clear();
        setListaCabecera(CabecerasWSClient.listaCabecera());
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('dialogEliminar').hide();");
        generarMensaje(BUNDLE.getString(StaticsConstants.EXITO_ELIMINAR), FacesMessage.SEVERITY_INFO);
    }

    public void generarMensaje(String mensaje, FacesMessage.Severity sever) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(sever, "Mensaje: ", mensaje));
    }

    /**
     * @return the listaTipoNomina
     */
    public List<Tsgnomtiponomina> getListaTipoNomina() {
        return listaTipoNomina;
    }

    /**
     * @param listaTipoNomina the listaTipoNomina to set
     */
    public void setListaTipoNomina(List<Tsgnomtiponomina> listaTipoNomina) {
        this.listaTipoNomina = listaTipoNomina;
    }

    /**
     * @return the listaQuincenas
     */
    public List<Tsgnomquincena> getListaQuincenas() {
        return listaQuincenas;
    }

    /**
     * @param listaQuincenas the listaQuincenas to set
     */
    public void setListaQuincenas(List<Tsgnomquincena> listaQuincenas) {
        this.listaQuincenas = listaQuincenas;
    }

    /**
     * @return the empleado
     */
    public Tsgrhempleados getEmpleado() {
        return empleado;
    }

    /**
     * @param empleado the empleado to set
     */
    public void setEmpleado(Tsgrhempleados empleado) {
        this.empleado = empleado;
    }

    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the tipoNominaSelecionado
     */
    public Tsgnomtiponomina getTipoNominaSelecionado() {
        return tipoNominaSelecionado;
    }

    /**
     * @param tipoNominaSelecionado the tipoNominaSelecionado to set
     */
    public void setTipoNominaSelecionado(Tsgnomtiponomina tipoNominaSelecionado) {
        this.tipoNominaSelecionado = tipoNominaSelecionado;
    }

    /**
     * @return the quincenaSeleccionada
     */
    public Tsgnomquincena getQuincenaSeleccionada() {
        return quincenaSeleccionada;
    }

    /**
     * @param quincenaSeleccionada the quincenaSeleccionada to set
     */
    public void setQuincenaSeleccionada(Tsgnomquincena quincenaSeleccionada) {
        this.quincenaSeleccionada = quincenaSeleccionada;
    }

    /**
     * @return the cabeceraSeleccionada
     */
    public Tsgnomcabecera getCabeceraSeleccionada() {
        return cabeceraSeleccionada;
    }

    /**
     * @param cabeceraSeleccionada the cabeceraSeleccionada to set
     */
    public void setCabeceraSeleccionada(Tsgnomcabecera cabeceraSeleccionada) {
        this.cabeceraSeleccionada = cabeceraSeleccionada;
    }

    /**
     * @return the listaCabecera
     */
    public List<Tsgnomcabecera> getListaCabecera() {
        return listaCabecera;
    }

    /**
     * @param listaCabecera the listaCabecera to set
     */
    public void setListaCabecera(List<Tsgnomcabecera> listaCabecera) {
        this.listaCabecera = listaCabecera;
    }

    /**
     * @return the espacio
     */
    public String getEspacio() {
        return espacio;
    }

    /**
     * @param espacio the espacio to set
     */
    public void setEspacio(String espacio) {
        this.espacio = espacio;
    }

    /**
     * @return the listaEstatusNomina
     */
    public List<Tsgnomestatusnom> getListaEstatusNomina() {
        return listaEstatusNomina;
    }

    /**
     * @param listaEstatusNomina the listaEstatusNomina to set
     */
    public void setListaEstatusNomina(List<Tsgnomestatusnom> listaEstatusNomina) {
        this.listaEstatusNomina = listaEstatusNomina;
    }

    /**
     * @return the index
     */
    public int getIndex() {
        return index;
    }

    /**
     * @param index the index to set
     */
    public void setIndex(int index) {
        this.index = index;
    }

    /**
     * @return the archivoCSV
     */
    public UploadedFile getArchivoCSV() {
        return archivoCSV;
    }

    /**
     * @param archivoCSV the archivoCSV to set
     */
    public void setArchivoCSV(UploadedFile archivoCSV) {
        this.archivoCSV = archivoCSV;
    }

    /**
     * @return the activo
     */
    public Boolean getActivo() {
        return activo;
    }

    /**
     * @param activo the activo to set
     */
    public void setActivo(Boolean activo) {
        this.activo = activo;
    }

    /**
     * @return the activarGuardar
     */
    public Boolean getActivarGuardar() {
        return activarGuardar;
    }

    /**
     * @param activarGuardar the activarGuardar to set
     */
    public void setActivarGuardar(Boolean activarGuardar) {
        this.activarGuardar = activarGuardar;
    }

    /**
     * @return the activarBtn
     */
    public Boolean getActivarBtn() {
        return activarBtn;
    }

    /**
     * @param activarBtn the activarBtn to set
     */
    public void setActivarBtn(Boolean activarBtn) {
        this.activarBtn = activarBtn;
    }
}
