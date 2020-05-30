/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor. 
 */
package com.mbn.sinod.web.mb;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mbn.sinod.model.dto.ConceptoDTO;
import com.mbn.sinod.model.dto.FormulaDTO;
import com.mbn.sinod.model.entidades.Tsgnomargumento;
import com.mbn.sinod.model.entidades.Tsgnomcalculo;
import com.mbn.sinod.model.entidades.Tsgnomclasificador;
import com.mbn.sinod.model.entidades.Tsgnomconcepto;
import com.mbn.sinod.model.entidades.Tsgnomconceptosat;
import com.mbn.sinod.model.entidades.Tsgnomformula;
import com.mbn.sinod.model.entidades.Tsgnomtipoconcepto;
import com.mbn.sinod.model.entidades.Tsgnomtiponomina;
import com.mbn.sinod.model.entidades.Tsgrhempleados;
import com.mbn.sinod.model.entidades.Usuario;
import com.mbn.sinod.web.client.ArgumentoWSClient;
import com.mbn.sinod.web.client.CatClasificadorWSClient;
import com.mbn.sinod.web.client.CatConceptosSATWSClient;
import com.mbn.sinod.web.client.ConceptoWSClient;
import com.mbn.sinod.web.client.FormulaWSClient;
import com.mbn.sinod.web.client.TipoCalculoWSClient;
import com.mbn.sinod.web.client.TipoConceptoWSClient;
import com.mbn.sinod.web.client.TipoNominaWSClient;
import com.mbn.sinod.web.util.ResourceBundles;
import com.mbn.sinod.web.util.StaticsConstants;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.servlet.http.HttpServletRequest;
import org.apache.deltaspike.core.api.scope.ViewAccessScoped;
import org.primefaces.context.RequestContext;
import org.primefaces.event.ReorderEvent;

/**
 *
 * @author Ambrosio
 */
@Named(value = "confConceptoMB")
@ViewAccessScoped
public class ConfConceptoMB implements Serializable {

    private static final ResourceBundle BUNDLE = ResourceBundle.getBundle(ResourceBundles.MESSAGES.getBundleName());
    private Integer visible;
    private Boolean prioridad;
    private Boolean boton;
    private Boolean disable;
    private Boolean active;
    private String FormulaDOC;
    private String NomFomulaDOC;
    private String formula;
    private String expReg;
    private String OperadoresDOC;
    private String FuncionesDOC;
    private String ConstantesDOC;
    private String cadena;
    private Double valor;
    private Object resultado;
    private String PruebaDOC;
    private Tsgrhempleados empleado;
    private Usuario usuario;
    private Tsgnomconcepto conceptoSeleccionado;
    private Tsgnomcalculo calculoSeleccinado;
    private List<Tsgnomconcepto> listaConceptos;
    private List<Tsgnomclasificador> listaclasificadores;
    private List<Tsgnomconceptosat> listaconceptosat;
    private List<Tsgnomcalculo> listatipocalculo;
    private List<Tsgnomargumento> listaargumentosconstantes;
    private List<Tsgnomargumento> listaargumentosvariables;
    private List<Tsgnomconcepto> listaConceptosFiltrados;
    private List<Tsgnomconcepto> listaConceptosDestino;
    private List<Tsgnomtipoconcepto> listaTipoConcepto;
    private List<Tsgnomtiponomina> listaTipoNomina;
    private ArrayList<String> partes;
    private List<Double> valores;
    private Tsgnomformula formulaSelecionada;
    private List<Tsgnomformula> formulas;
    private Integer guardar;
    private Boolean claveEditar;
    
    @PostConstruct
    public void iniciarVariables() {
        this.setEmpleado((Tsgrhempleados) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("empleado"));
        this.usuario = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        setVisible(1);
        setFormulaDOC("");
        setExpReg("");
        setPrioridad(false);
        setPartes(new ArrayList<>());
        setListaConceptos(ConceptoWSClient.listarConceptos());
        setListaclasificadores(CatClasificadorWSClient.listarConceptos());
        setListaconceptosat(CatConceptosSATWSClient.listarConceptosSAT());
        setListatipocalculo(TipoCalculoWSClient.listarConceptosSAT());
        setListaTipoConcepto(TipoConceptoWSClient.listarTipoConcepto());
        setListaTipoNomina(TipoNominaWSClient.listarTipoNomina());
        setListaargumentosconstantes(ArgumentoWSClient.listarArgumentosConstantes());
        setListaargumentosvariables(ArgumentoWSClient.listarArgumentosVariables());
        setFormulas(FormulaWSClient.listarCatIncidencias());
        setValores(new ArrayList<>());
        //si se inicia la aplicacion
        setGuardar(1);
    }

    public void operadores() {
        if (getFormula() == null) {
            setFormula(getOperadoresDOC());
            setExpReg(":".concat(getOperadoresDOC()));

        } else {
            setFormula(getFormula().concat(getOperadoresDOC()));
            setExpReg(getExpReg().concat(":".concat(getOperadoresDOC())));
        }
        setFormulaDOC(getFormula());
        setOperadoresDOC("");
        resetear();
    }

    public void funciones() {
        if (getFormula() == null) {
            setFormula(getFuncionesDOC());
            setExpReg(":".concat(getFuncionesDOC()));
            getPartes().add(getFuncionesDOC().replace(" ", ""));
        } else {
            setFormula(getFormula().concat(getFuncionesDOC()));
            setExpReg(getExpReg().concat(":".concat(getFuncionesDOC())));
            getPartes().add(getFuncionesDOC().replace(" ", ""));
        }
        setFormulaDOC(getFormula());
        setFuncionesDOC("");
        resetear();
    }

    public void constantes() {
        if (getFormula() == null) {
            setFormula(getConstantesDOC());
            setExpReg(":".concat(getConstantesDOC()));
            getPartes().add(getConstantesDOC().replace(" ", ""));
        } else {
            setFormula(getFormula().concat(getConstantesDOC()));
            setExpReg(getExpReg().concat(":".concat(getConstantesDOC())));
            getPartes().add(getConstantesDOC().replace(" ", ""));
        }
        setFormulaDOC(getFormula());
        setConstantesDOC("");
        resetear();
    }

    public void limpiarFormula() {
        setFormulaDOC("");
        setFormula("");
        setExpReg("");
        setPartes(new ArrayList<>());
        setResultado("");
        resetear();
    }

    public void resetear() {
        setValores(new ArrayList<>());
        setValor(0.0);
        getValores().clear();
        setPruebaDOC("");
        setResultado("");
        setActive(true);
        setDisable(true);

    }

    public void agregarValores(int index) {
        getValores().add(getValor());
        if (!Objects.equals(valores.get(index), getValor())) {
            getValores().set(index, getValor());
            getValores().remove(getValores().size() - 1);
        }
    }

    public void calcularFormula() {
        try {
            ScriptEngineManager manager = new ScriptEngineManager();
            ScriptEngine engine = manager.getEngineByName("js");
            if (getValores().size() == partes.size()) {
                for (int i = 0; i < getPartes().size(); i++) {
                    engine.put(partes.get(i), getValores().get(i));
                }
                setResultado(engine.eval(getFormula().replace(" ", "")));
                setActive(false);
                setDisable(false);
                generarMensaje("Formula calculada", FacesMessage.SEVERITY_INFO);
            } else {

                //mensaje de que verifique su formula
                generarMensaje("verifique sus datos", FacesMessage.SEVERITY_WARN);

            }
        } catch (ScriptException e) {
            Logger.getLogger(ConfConceptoMB.class.getName()).log(Level.SEVERE, null, e);
            generarMensaje("Varifique la formula", FacesMessage.SEVERITY_WARN);
        }
    }

    public void tipoCalculo() {
        System.out.println("as " + getConceptoSeleccionado().getCodCalculoidFk().getCodCalculoid());
        //si el tipo de calculo es por importe
        if (getConceptoSeleccionado().getCodCalculoidFk().getCodCalculoid().equals(1)) {
            getPartes().clear();
            setPartes(new ArrayList<>());
            setFormulaSelecionada(new Tsgnomformula());
            setFormulaDOC(new String());
            setGuardar(1);
            setActive(false);
            setDisable(false);
        } else {
            //si es calculo
            setGuardar(2);
            setActive(true);
            setDisable(true);
        }

    }

    public void eliminarConcepto() throws JsonProcessingException {
        ConceptoWSClient.eliminarConcepto(getConceptoSeleccionado().getCodConceptoid());
        setListaConceptos(ConceptoWSClient.listarConceptos());
        generarMensaje(BUNDLE.getString(StaticsConstants.EXITO_ELIMINAR), FacesMessage.SEVERITY_INFO);
    }

    public void comparar() {
        for (int i = 0; i < getListaConceptos().size(); i++) {
            if (getListaConceptos().get(i).getCodClaveconcepto().toUpperCase().equals(getConceptoSeleccionado().getCodClaveconcepto().toUpperCase())) {
                generarMensaje(BUNDLE.getString(StaticsConstants.ERROR_REPETIDO), FacesMessage.SEVERITY_WARN);
                setActive(true);
                setDisable(true);
                break;
            } else {
                setActive(false);
                setDisable(false);
            }
        }
    }

    public void compararFormula() {
        for (int i = 0; i < getFormulas().size(); i++) {
            if (getFormulas().get(i).getDesNbformula().toUpperCase().equals(getFormulaSelecionada().getDesNbformula().toUpperCase())) {
                generarMensaje(BUNDLE.getString(StaticsConstants.ERROR_REPETIDO), FacesMessage.SEVERITY_WARN);
                setActive(true);
                setDisable(true);
                break;
            } else {
                setActive(false);
                setDisable(false);
            }
        }
    }

    public void guardarConcepto() {
        try {
            if (getBoton().equals(true)) {
                getConceptoSeleccionado().setAudCodcreadopor(getEmpleado().getCodEmpleado());
                getConceptoSeleccionado().setAudFeccreacion(new Date());
            } else {
                getConceptoSeleccionado().setAudCodmodificadopor(getEmpleado().getCodEmpleado());
                getConceptoSeleccionado().setAudFecmodificacion(new Date());
                if (!getConceptoSeleccionado().getBolRetroactividad()) {
                    getConceptoSeleccionado().setCodExcento('0');
                    getConceptoSeleccionado().setCodGravado('0');
                }
            }
            if (getConceptoSeleccionado().getCodCalculoidFk().getCodCalculoid().equals(2)) {
                try {
                    FormulaDTO dtoRespuestaFormula = new FormulaDTO();
                    if (getExpReg().length() > 0) {
                        getFormulaSelecionada().setDesNbformula(getFormulaSelecionada().getDesNbformula().toUpperCase());
                        getFormulaSelecionada().setDesFormula(getExpReg());
                        getFormulaSelecionada().setBolEstatus(true);
                        dtoRespuestaFormula.setFormula(formulaSelecionada);
                        conceptoSeleccionado.setCodFormulaidFk(FormulaWSClient.guardarFormula(dtoRespuestaFormula).getFormula());
                        guardado();
//                        generarMensaje(BUNDLE.getString(StaticsConstants.EXITO_GUARDADO), FacesMessage.SEVERITY_INFO);
                    } else {
                        generarMensaje(BUNDLE.getString(StaticsConstants.ERROR_CAMPOS_VACIOS), FacesMessage.SEVERITY_ERROR);
                    }
                } catch (JsonProcessingException ex) {
                    Logger.getLogger(ConfConceptoMB.class.getName()).log(Level.SEVERE, null, ex);
                    generarMensaje(BUNDLE.getString(StaticsConstants.ERROR_GUARDADO), FacesMessage.SEVERITY_ERROR);
                } catch (NullPointerException e) {
                    Logger.getLogger(ConfConceptoMB.class.getName()).log(Level.SEVERE, null, e);
                    generarMensaje(BUNDLE.getString(StaticsConstants.ERROR_CAMPOS_VACIOS), FacesMessage.SEVERITY_WARN);
                } catch (Exception ex) {
                    Logger.getLogger(ConfConceptoMB.class.getName()).log(Level.SEVERE, null, ex);
                    generarMensaje("Otros", FacesMessage.SEVERITY_WARN);
                }
            } else {
                guardado();
            }
        } catch (Exception e) {
            Logger.getLogger(ConfConceptoMB.class.getName()).log(Level.SEVERE, null, e);
            generarMensaje(BUNDLE.getString(StaticsConstants.ERROR_CAMPOS_VACIOS), FacesMessage.SEVERITY_WARN);
        }
    }

    private void guardado() {
        try {
            ConceptoDTO dtoRespuesta = new ConceptoDTO();
            getConceptoSeleccionado().setCodClaveconcepto(getConceptoSeleccionado().getCodClaveconcepto().toUpperCase());
            getConceptoSeleccionado().setCodNbconcepto(getConceptoSeleccionado().getCodNbconcepto().toUpperCase());
            dtoRespuesta.setConcepto(getConceptoSeleccionado());
            //dtoRespuesta.getConcepto().getCnuCuentacontable();
            ConceptoWSClient.guardarConcepto(dtoRespuesta);
            generarMensaje(BUNDLE.getString(StaticsConstants.EXITO_GUARDADO), FacesMessage.SEVERITY_INFO);
            setGuardar(0);
            if (getBoton().equals(true)) {
                dialogoPrioridadCalculo();
                setPrioridad(false);
                limpiarFormula();
            } else {
                setVisible(1);
                limpiarFormula();
            }
        } catch (JsonProcessingException ex) {
            Logger.getLogger(ConfConceptoMB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void generarMensaje(String mensaje, FacesMessage.Severity sever) {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(sever, "Mensaje: ", mensaje));
    }

    public void onRowReorder(ReorderEvent event) {
        Integer temporal;
        Integer de = event.getFromIndex();
        Integer hacia = event.getToIndex();
        if (hacia < de) {
            temporal = de;
            de = hacia;
            hacia = temporal;
        }
        for (Integer i = de; i < getListaConceptosDestino().size(); i++) {
            getListaConceptosDestino().get(i).setCnuPrioricalculo(i + 1);
        }
        FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Concepto ", "De: " + (event.getFromIndex() + 1)
                + " A: " + (event.getToIndex() + 1));
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void guardarPrioridad() {
        ConceptoDTO dtoRespuesta = new ConceptoDTO();
        dtoRespuesta.setListConceptos(getListaConceptosDestino());
        try {
            ConceptoWSClient.guardarPrioridad(dtoRespuesta);
            generarMensaje(BUNDLE.getString(StaticsConstants.EXITO_GUARDADO), FacesMessage.SEVERITY_INFO);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(ConfConceptoMB.class.getName()).log(Level.SEVERE, null, ex);
            generarMensaje(BUNDLE.getString(StaticsConstants.ERROR_GUARDADO), FacesMessage.SEVERITY_ERROR);
        }
        getListaConceptos().clear();
        setListaConceptos(ConceptoWSClient.listarConceptos());
        setVisible(1);
    }

    public void dialogoCrear() {
        setVisible(2);
        setBoton(true);
        setClaveEditar(false);
        setConceptoSeleccionado(new Tsgnomconcepto());
        setFormulaSelecionada(new Tsgnomformula());
        getConceptoSeleccionado().setBolEstatus(true);
    }

    public void dialogoEditar(Tsgnomconcepto seleccionado) {
        setVisible(2);
        setBoton(false);
        setClaveEditar(true);
        setConceptoSeleccionado(seleccionado);
        if (seleccionado.getCodCalculoidFk().getCodCalculoid().equals(2)) {
            setFormulaDOC(seleccionado.getCodFormulaidFk().getDesFormula().replace(":", ""));
            setFormula(seleccionado.getCodFormulaidFk().getDesFormula().replace(":", ""));
            setExpReg(seleccionado.getCodFormulaidFk().getDesFormula());
            setFormulaSelecionada(conceptoSeleccionado.getCodFormulaidFk());
            //si es calculo
            setGuardar(2);
            setActive(true);
            setDisable(true);
            Pattern pattern = Pattern.compile(":");
            Matcher matcher = pattern.matcher(seleccionado.getCodFormulaidFk().getDesFormula());
            int index = 0;
            while (matcher.find()) {
                setCadena(seleccionado.getCodFormulaidFk().getDesFormula().substring(index, matcher.end())
                        .replace(":", "")
                        .replace("/", "")
                        .replace("*", "")
                        .replace("-", "")
                        .replace("+", "")
                        .replace("^", "")
                        .replace("(", "")
                        .replace(")", "")
                        .replace(" ", ""));
                if (getCadena().length() > 1) {
                    getPartes().add(getCadena());
                    index = matcher.end();
                }
            }
            setCadena(seleccionado.getCodFormulaidFk().getDesFormula().substring(index, matcher.regionEnd())
                    .replace(":", "")
                    .replace("/", "")
                    .replace("*", "")
                    .replace("-", "")
                    .replace("+", "")
                    .replace("^", "")
                    .replace("(", "")
                    .replace(")", "")
                    .replace(" ", ""));
            getPartes().add(getCadena());
        } else {
            setFormulaSelecionada(new Tsgnomformula());
            //si es importe
            setGuardar(1);
            setActive(false);
            setDisable(false);
        }
    }

    public void cancelar() {
        limpiarFormula();
        setVisible(1);
    }

    public void editarPrioridad(Tsgnomconcepto seleccionado) throws JsonProcessingException {
        setPrioridad(true);
        setConceptoSeleccionado(seleccionado);
        dialogoPrioridadCalculo();
    }

    public void dialogoPrioridadCalculo() throws JsonProcessingException {
        if (getConceptoSeleccionado().getCodTipoconceptoidFk().getCodTipoconceptoid().equals(1)) {
            setListaConceptosFiltrados(ConceptoWSClient.listarConceptosDeduccion());
            setListaConceptosDestino(getListaConceptosFiltrados());
        } else if (getConceptoSeleccionado().getCodTipoconceptoidFk().getCodTipoconceptoid().equals(2)) {
            setListaConceptosFiltrados(ConceptoWSClient.listarConceptosPercepcion());
            setListaConceptosDestino(getListaConceptosFiltrados());
        }

        if (getListaConceptosDestino().size() == 1) {
            getListaConceptosDestino().get(0).setCnuPrioricalculo(1);
            guardarPrioridad();
        } else {
            setVisible(3);
        }
    }

    public void dialogoEliminar(Tsgnomconcepto seleccionado) {
        setConceptoSeleccionado(seleccionado);
        RequestContext context = RequestContext.getCurrentInstance();
        context.execute("PF('eliminarConfConcepto').show();");
    }

    private void reload() throws IOException {
        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
        ec.redirect(((HttpServletRequest) ec.getRequest()).getRequestURI());
    }

    /**
     * @return the FormulaDOC
     */
    public String getFormulaDOC() {
        return FormulaDOC;
    }

    /**
     * @param FormulaDOC the FormulaDOC to set
     */
    public void setFormulaDOC(String FormulaDOC) {
        this.FormulaDOC = FormulaDOC;
    }

    /**
     * @return the OperadoresDOC
     */
    public String getOperadoresDOC() {
        return OperadoresDOC;
    }

    /**
     * @param OperadoresDOC the OperadoresDOC to set
     */
    public void setOperadoresDOC(String OperadoresDOC) {
        this.OperadoresDOC = OperadoresDOC;
    }

    /**
     * @return the formula
     */
    public String getFormula() {
        return formula;
    }

    /**
     * @param formula the formula to set
     */
    public void setFormula(String formula) {
        this.formula = formula;
    }

    /**
     * @return the FuncionesDOC
     */
    public String getFuncionesDOC() {
        return FuncionesDOC;
    }

    /**
     * @param FuncionesDOC the FuncionesDOC to set
     */
    public void setFuncionesDOC(String FuncionesDOC) {
        this.FuncionesDOC = FuncionesDOC;
    }

    /**
     * @return the ConstantesDOC
     */
    public String getConstantesDOC() {
        return ConstantesDOC;
    }

    /**
     * @param ConstantesDOC the ConstantesDOC to set
     */
    public void setConstantesDOC(String ConstantesDOC) {
        this.ConstantesDOC = ConstantesDOC;
    }

    /**
     * @return the visible
     */
    public Integer getVisible() {
        return visible;
    }

    /**
     * @param visible the visible to set
     */
    public void setVisible(Integer visible) {
        this.visible = visible;
    }

    /**
     * @return the expReg
     */
    public String getExpReg() {
        return expReg;
    }

    /**
     * @param expReg the expReg to set
     */
    public void setExpReg(String expReg) {
        this.expReg = expReg;
    }

    /**
     * @return the partes
     */
    public ArrayList<String> getPartes() {
        return partes;
    }

    /**
     * @param partes the partes to set
     */
    public void setPartes(ArrayList<String> partes) {
        this.partes = partes;
    }

    /**
     * @return the listaConceptos
     */
    public List<Tsgnomconcepto> getListaConceptos() {
        return listaConceptos;
    }

    /**
     * @param listaConceptos the listaConceptos to set
     */
    public void setListaConceptos(List<Tsgnomconcepto> listaConceptos) {
        this.listaConceptos = listaConceptos;
    }

    /**
     * @return the conceptoSeleccionado
     */
    public Tsgnomconcepto getConceptoSeleccionado() {
        return conceptoSeleccionado;
    }

    /**
     * @param conceptoSeleccionado the conceptoSeleccionado to set
     */
    public void setConceptoSeleccionado(Tsgnomconcepto conceptoSeleccionado) {
        this.conceptoSeleccionado = conceptoSeleccionado;
    }

    /**
     * @return the listaclasificadores
     */
    public List<Tsgnomclasificador> getListaclasificadores() {
        return listaclasificadores;
    }

    /**
     * @param listaclasificadores the listaclasificadores to set
     */
    public void setListaclasificadores(List<Tsgnomclasificador> listaclasificadores) {
        this.listaclasificadores = listaclasificadores;
    }

    /**
     * @return the listaconceptosat
     */
    public List<Tsgnomconceptosat> getListaconceptosat() {
        return listaconceptosat;
    }

    /**
     * @param listaconceptosat the listaconceptosat to set
     */
    public void setListaconceptosat(List<Tsgnomconceptosat> listaconceptosat) {
        this.listaconceptosat = listaconceptosat;
    }

    /**
     * @return the listatipocalculo
     */
    public List<Tsgnomcalculo> getListatipocalculo() {
        return listatipocalculo;
    }

    /**
     * @param listatipocalculo the listatipocalculo to set
     */
    public void setListatipocalculo(List<Tsgnomcalculo> listatipocalculo) {
        this.listatipocalculo = listatipocalculo;
    }

    public List<Tsgnomtipoconcepto> getListaTipoConcepto() {
        return listaTipoConcepto;
    }

    public void setListaTipoConcepto(List<Tsgnomtipoconcepto> listaTipoConcepto) {
        this.listaTipoConcepto = listaTipoConcepto;
    }

    public Tsgnomcalculo getCalculoSeleccinado() {
        return calculoSeleccinado;
    }

    public void setCalculoSeleccinado(Tsgnomcalculo calculoSeleccinado) {
        this.calculoSeleccinado = calculoSeleccinado;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public List<Double> getValores() {
        return valores;
    }

    public void setValores(List<Double> valores) {
        this.valores = valores;
    }

    public Object getResultado() {
        return resultado;
    }

    public void setResultado(Object resultado) {
        this.resultado = resultado;
    }

    public String getPruebaDOC() {
        return PruebaDOC;
    }

    public void setPruebaDOC(String PruebaDOC) {
        this.PruebaDOC = PruebaDOC;
    }

    public List<Tsgnomargumento> getListaargumentosconstantes() {
        return listaargumentosconstantes;
    }

    public void setListaargumentosconstantes(List<Tsgnomargumento> listaargumentosconstantes) {
        this.listaargumentosconstantes = listaargumentosconstantes;
    }

    public List<Tsgnomargumento> getListaargumentosvariables() {
        return listaargumentosvariables;
    }

    public void setListaargumentosvariables(List<Tsgnomargumento> listaargumentosvariables) {
        this.listaargumentosvariables = listaargumentosvariables;
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
     * @return the boton
     */
    public Boolean getBoton() {
        return boton;
    }

    /**
     * @param boton the boton to set
     */
    public void setBoton(Boolean boton) {
        this.boton = boton;
    }

    public List<Tsgnomconcepto> getListaConceptosFiltrados() {
        return listaConceptosFiltrados;
    }

    public void setListaConceptosFiltrados(List<Tsgnomconcepto> listaConceptosFiltrados) {
        this.listaConceptosFiltrados = listaConceptosFiltrados;
    }

    /**
     * @return the formulaSelecionada
     */
    public Tsgnomformula getFormulaSelecionada() {
        return formulaSelecionada;
    }

    /**
     * @param formulaSelecionada the formulaSelecionada to set
     */
    public void setFormulaSelecionada(Tsgnomformula formulaSelecionada) {
        this.formulaSelecionada = formulaSelecionada;
    }

    /**
     * @return the NomFomulaDOC
     */
    public String getNomFomulaDOC() {
        return NomFomulaDOC;
    }

    /**
     * @param NomFomulaDOC the NomFomulaDOC to set
     */
    public void setNomFomulaDOC(String NomFomulaDOC) {
        this.NomFomulaDOC = NomFomulaDOC;
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
     * @return the listaConceptosDestino
     */
    public List<Tsgnomconcepto> getListaConceptosDestino() {
        return listaConceptosDestino;
    }

    /**
     * @param listaConceptosDestino the listaConceptosDestino to set
     */
    public void setListaConceptosDestino(List<Tsgnomconcepto> listaConceptosDestino) {
        this.listaConceptosDestino = listaConceptosDestino;
    }

    /**
     * @return the formulas
     */
    public List<Tsgnomformula> getFormulas() {
        return formulas;
    }

    /**
     * @param formulas the formulas to set
     */
    public void setFormulas(List<Tsgnomformula> formulas) {
        this.formulas = formulas;
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
     * @return the disable
     */
    public Boolean getDisable() {
        return disable;
    }

    /**
     * @param disable the disable to set
     */
    public void setDisable(Boolean disable) {
        this.disable = disable;
    }

    /**
     * @return the active
     */
    public Boolean getActive() {
        return active;
    }

    /**
     * @param active the active to set
     */
    public void setActive(Boolean active) {
        this.active = active;
    }

    /**
     * @return the prioridad
     */
    public Boolean getPrioridad() {
        return prioridad;
    }

    /**
     * @param prioridad the prioridad to set
     */
    public void setPrioridad(Boolean prioridad) {
        this.prioridad = prioridad;
    }

    /**
     * @return the guardar
     */
    public Integer getGuardar() {
        return guardar;
    }

    /**
     * @param guardar the guardar to set
     */
    public void setGuardar(Integer guardar) {
        this.guardar = guardar;
    }

    /**
     * @return the cadena
     */
    public String getCadena() {
        return cadena;
    }

    /**
     * @param cadena the cadena to set
     */
    public void setCadena(String cadena) {
        this.cadena = cadena;
    }

    /**
     * @return the claveEditar
     */
    public Boolean getClaveEditar() {
        return claveEditar;
    }

    /**
     * @param claveEditar the claveEditar to set
     */
    public void setClaveEditar(Boolean claveEditar) {
        this.claveEditar = claveEditar;
    }

}
