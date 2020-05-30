package com.mbn.sinod.web.util;

public class StaticsConstants {
    
    //Ruta login
    public static final String RUTA_LOGIN = "config.path.login";

    //Validación contrasena
    public static final String REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[~'!@#$%?\\\\\\/&*\\]|\\[=()}\"{+_:;,.><'-])(?=\\S+$).{8,2000}$";
    //Validación correo
    public static final String PATRON_CORREO = "^[\\w-]+(\\.[\\w-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    //Validación RFC
    public static final String PATRON_RFC_PERSONA_FISICA = "[A-Z]{4}[0-9]{6}[A-Z0-9]{3}";
    public static final String PATRON_RFC_PERSONA_MORAL = "[A-Z]{3}[0-9]{6}[A-Z0-9]{3}";

    public static final String MESSAGES_CLASSPATH = "messages";

    //Roles
    public static final int USUARIO = 1;
    public static final int ADMINISTRADOR = 2;

    //Sesiones
    public static final int MOSTRAR_MSG_SESION_EXPIRADA = 1;
    
    //WS Config property messages
    public static final String WS_URL_HOST = "config.ws.url.host";
    public static final String TOKEN_PATH = "config.ws.token.path";
    public static final String TOKEN_USER = "config.ws.token.user";
    public static final String TOKEN_PWD = "config.ws.token.passwd";
    public static final String TOKEN_CLIENTID = "config.ws.token.clientid";
    public static final String TOKEN_SECRET = "config.ws.token.secret";

    //OAUTH grant types
    public static final String GRANT_PASSWORD = "password";
    public static final String GRANT_REFRESH = "refresh_token";

    //Util Stuff
    public static final String ACCESS_TOKEN = "access_token";
    public static final String ACCESS_VALUE = "value";
    public static final String LOCALE = "es";

    //WS
    public static final String WS_LOGIN = "ws.path.login";
    public static final String WS_LOGOUT = "ws.path.logout";
    public static final String WS_OBETENER_CATALOGO = "ws.path.obtenerCatalogo";
    //ARGUMENTOS WS
    public static final String WS_LISTAR_ARGUMENTOS = "ws.path.listarArgumentos";
    public static final String WS_ELIMINAR_ARGUMENTO = "ws.path.eliminarArgumento";
    public static final String WS_GUARDAR_ARGUMENTO = "ws.path.guardarArgumento";
    public static final String WS_LISTAR_ARGUMENTOS_CONSTANTES = "ws.path.listarArgumentosConstantes";
    public static final String WS_LISTAR_ARGUMENTOS_VARIABLES = "ws.path.listarArgumentosVariables";
    
    //    WS Nomina Quincenas
    public static final String WS_LISTAR_QUINCENAS = "ws.path.listaQuincenas";
    public static final String WS_LISTAR_QUINCENAS_FUTURAS = "ws.path.listaQuincenasFuturas";
    public static final String WS_GUARDAR_QUINCENA ="ws.path.guardarQuincena";
    public static final String WS_QUINCENA_ACTUAL ="ws.path.quincenaActual";

    //FUNCION WS
    public static final String WS_LISTAR_FUNCIONES = "ws.path.listarFunciones";

    //public static final String WS_OBETENER_EMPLEADOS = "ws.path.obtenerEmpleados";
    //public static final String WS_BUSCAR_EMPLEADOS = "ws.path.buscarEmpleados";
    //public static final String WS_OBTENER_VACACIONES_EMPLEADOS = "ws.path.obtenerVacacionesEmpleado";
    //public static final String WS_OBTENER_VACACIONES_EMPLEADOS_POR_APROBAR = "ws.path.obtenerVacacionesPorAprobar";
    //public static final String WS_GUARDAR_ACTUALIZAR_VACACIONES = "ws.path.guardarActualizarVacaciones";
    //public static final String WS_BUSCAR_EMPLEADOS_AREA ="ws.path.buscarEmpleadosArea";
    //WS Reuniones
    public static final String WS_GUARDAR_REUNION = "ws.path.guardarReunion";
    public static final String WS_ACTUALIZAR_REUNION = "ws.path.actualizarReunion";
    public static final String WS_LISTAR_REUNIONES = "ws.path.listaReuniones";
    public static final String WS_BUSCAR_REUNIONES = "ws.path.buscarReunion";
    public static final String WS_LISTAR_CIUADES_FILTRO = "ws.path.listarCiudades";
    public static final String WS_LISTAR_LUGARES = "ws.path.listaLugares";
    public static final String WS_LISTAR_ULTIMAS_REUNIONES = "ws.path.obtenerUltimasReuniones";

    public static final String WS_LISTAR_ESTADOS = "ws.path.listaEstados";
    public static final String WS_BUCAR_MINUTA_POR_ID = "ws.path.buscarMinutasPorId";
    public static final String WS_FILTRO_FECHAS_AREA = "ws.path.filtroFechasArea";
    public static final String WS_BUSCAR_REPORTE_TEMA = "ws.path.buscarReporteTema";
    public static final String WS_FILTRO_COMPROMISOS_COLABORADOR = "ws.path.filtroCompromisosColaborador";
    public static final String WS_REPORTE_TEMA = "ws.path.reporteTema";
    public static final String WS_REPORTE_MINUTAS_AREA = "ws.path.reporteMinutasArea";

    public static final String WS_LISTAR_AGENDA_POR_REUNION = "ws.path.listaAgendaPorReunion";
    public static final String WS_GUARDAR_LUGAR = "ws.path.guardarLugar";
    public static final String WS_GUARDAR_CIUDAD = "ws.path.guardarCiudad";
    public static final String WS_GUARDAR_AGENDA = "ws.path.guardarAgenda";
    public static final String WS_ELIMINAR_PUNTO_TRATAR = "ws.path.eliminarPuntoTratar";
    public static final String WS_GUARDAR_PUNTO_TRATAR = "ws.path.guardarPuntoTratar";
    public static final String WS_ACTUALIZAR_AGENDA = "ws.path.actualizarAgenda";

    public static final String WS_GUARDAR_INVITADOS = "ws.path.guardarInvitados";
    public static final String WS_GUARDAR_INVITADO = "ws.path.guardarInvitado";
    public static final String WS_ELIMINAR_INVITADO = "ws.path.eliminarInvitado";
    public static final String WS_ACTUALIZAR_INVITADO = "ws.path.actualizarInvitado";
    public static final String WS_LISTAR_INVITADOS_POR_REUNION = "ws.path.listaInvitadosPorReunion";

    //WS Usuarios
    public static final String WS_OBTENER_USUARIO_ID = "ws.path.obtenerUsuarioPorId";

    //WS Registro
    public static final String WS_GUARDAR_ASISTENTES = "ws.path.guardarAsistentes";
    public static final String WS_LISTAR_ASISTENTES = "ws.path.listarAsistentes";
    public static final String WS_GUARDAR_COMENTARIOS_AGENDA = "ws.path.guardarComentariosAgenda";
    public static final String WS_ELIMINAR_COMENTARIOS_AGENDA = "ws.path.eliminarComentarioAgenda";
    public static final String WS_LISTAR_COMENTARIOS_AGENDA = "ws.path.listaComentariosAgenda";
    public static final String WS_GUARDAR_COMENTARIOS_REUNION = "ws.path.guardarComentariosReunion";
    public static final String WS_LISTAR_COMENTARIOS_REUNION = "ws.path.listaComentariosReunion";
    public static final String WS_ELIMINAR_COMENTARIO_REUNION = "ws.path.eliminarComentarioReunion";
    public static final String WS_GUARDAR_COMPROMISOS = "ws.path.guardarCompromisos";
    public static final String WS_LISTAR_COMPROMISOS = "ws.path.listaCompromisosPorIdReunion";
    public static final String WS_ELIMINAR_COMROMISOS = "ws.path.eliminarCompromiso";
    public static final String WS_ACTUALIZAR_COMPROMISO = "ws.path.actualizarCompromiso";

    //WS Empleados
    public static final String WS_LISTAR_EMPLEADOS = "ws.path.listaEmpleados";
    public static final String WS_OBTENER_EMPLEADO_ID = "ws.path.obtenerEmpleadoPorId";
    public static final String WS_LISTAR_TODOS_EMPELADOS = "ws.path.detalleEmp"; //TORRES

    //WS Empleados RH
    public static final String WS_DETALLE_EMPLEADOS_NOM = "ws.path.detalleEmpleados";
    public static final String WS_DETALLE_EMPLEADOS_NOM_POR_AREA = "ws.path.detalleEmpleadosPorArea";
    public static final String WS_VER_INFORMACION_DE_PERSONAL = "ws.path.verInformacionDePersonal";
    public static final String WS_HISTORIAL_RH_DATOS = "ws.path.historialRh";
    public static final String WS_INFO_HISTORIAL = "ws.path.infoHistorial";
    public static final String WS_VALIDAR_CADA_ALTA = "ws.path.validarCadaAlta";
    public static final String WS_VALIDAR_ALTAS_ACEPTADAS = "ws.path.validarAltasAceptadas";
    public static final String WS_VALIDAR_ALTAS_RECHAZADAS = "ws.path.validarAltasRechazadas";
    public static final String WS_VALIDAR_ALTAS="ws.path.validar.altas";
    public static final String WS_LISTAR_BAJAS="ws.path.listar.bajas";
    public static final String WS_VALIDAR_CADA_BAJA="ws.path.validarCadaBaja";
    public static final String WS_VALIDAR_BAJAS_ACEPTADAS="ws.path.validarBajasAceptadas";
    public static final String WS_VALIDAR_BAJAS_RECHAZADAS="ws.path.validarBajasRechazadas";
    public static final String WS_VALIDAR="ws.path.validar";
    public static final String WS_ALTASVALIDADAS="ws.path.validacionesAltas";
    public static final String WS_BAJASVALIDADAS="ws.path.validacionesBajas";
    public static final String WS_CONCEPTOSEMPLEADOS="ws.path.conceptosempleados";
    public static final String WS_OBTENER_EMPLEADO_NOM = "ws.path.obtenerEmpleadoNomina";
    public static final String WS_INFO_PARA_ALTA_NOM = "ws.path.infoParaAltaNom";
    public static final String WS_ENVIAR_CORREO_VALIDAR_ALTA ="ws.path.validar.enviarcorreosvalidaraltas";
    public static final String WS_ENVIAR_CORREO_VALIDAR_BAJA="ws.path.validar.enviarcorreosvalidarbajas";
    public static final String WS_GUARDAR_EMPLEADO_NOMINA="ws.path.guardarEmpleadoNom";
    public static final String WS_OBTENER_EMPLEADOS_MOMINA_POR_IDNOM ="ws.path.obtenerEmpleadosNomporIdNom";
    public static final String WS_OBTENER_EMPLEADOS_MOMINA_POR_IDNOMHT ="ws.path.obtenerEmpleadosNomporIdNomHT";

    //WS Areas
    public static final String WS_LISTA_AREAS = "ws.path.listaAreas";
    public static final String WS_OBTENER_AREAS_POR_ID = "ws.path.obtenerAreasPorId";

    //WS CatClasificador
    public static final String WS_LISTA_CATCLASIFICADR = "ws.path.listaCatClasificador";

    //WS CatConceptosSAT
    public static final String WS_LISTA_CATCONCEPTOSSAT = "ws.path.listaCatConceptosSAT";

    //WS Formula
    public static final String WS_LISTA_FORMULAS = "ws.path.listarFormulas";
    public static final String WS_GUARDAR_FORMULA = "ws.path.guardarFormula";

    //WS TipoCalculos
    public static final String WS_LISTA_CATTIPOCALCULOS = "ws.path.listaTipoCalculos";

    //WS TipoConcepto
    public static final String WS_LISTA_CATTIPOCONCEPTOS = "ws.path.listaTipoConcepto";

    //WS TipoNomina
    public static final String WS_LISTA_CATTIPONOMINA = "ws.path.listaTipoNomina";
    
    //WS EstatusNomin
    public static final String WS_LISTA_ESTATUSNOMINA = "ws.path.listarEstatusNomina";
    
    //WS EmpQuincena
    public static final String WS_INSERTA_EMPQUINCENA = "ws.path.insertaEmpQuincena";
    
    //WS EjercicioFiscal
    public static final String WS_EJERCICIO_FISCAL= "ws.path.ejercicioFiscal";

    //WS Concepto
    public static final String WS_LISTA_CONCEPTOS = "ws.path.listaConceptos";
    public static final String WS_ELIMINAR_CONCEPTO = "ws.path.eliminarConcepto";
    public static final String WS_GUARDAR_CONCEPTO = "ws.path.guardarConcepto";
    public static final String WS_GUARDAR_PRIORIDAD = "ws.path.guardarPrioridad";
    public static final String WS_LISTAR_CONCEPTOS_PERCEPCION = "ws.path.listarConceptosPercepcion";
    public static final String WS_LISTAR_CONCEPTOS_DEDUCCION = "ws.path.listarConceptosDeduccion";
    
    //WS Conceptos Quincena
    public static final String WS_LISTA_CONCEPQUINC = "ws.path.listaConcepquinc";
    public static final String WS_LISTA_CONCEPQUINCHT = "ws.path.listaConcepquincht";
    public static final String WS_LISTA_CONCEPQUINC_CABECERA = "ws.path.listaConcepquincByCabecera";

    //WS CatIncidencias
    public static final String WS_LISTA_CATINCIDENCIA = "ws.path.listaCatIncidencias";
    public static final String WS_GUARDAR_CATINCIDENCIA = "ws.path.guardarActualizarCatInci";
    public static final String WS_ELIMINAR_CATINCIDENCIA = "ws.path.eliminarCatIncidenciasId";

    //Reportes Compromisos 
    public static final String WS_REPORTE_COMPROMISOS_POR_DIA = "ws.path.reporteCompromisosPorDia";
    public static final String WS_REPORTE_COMPROMISOS_GENERALES = "ws.path.reporteCompromisosGenerales";
    public static final String WS_REPORTE_COMPROMISOS_AREA = "ws.path.reporteCompromisosArea";

    //ws Acuerdos
    public static final String WS_LISTA_COMPROMISOS_POR_EJECUTOR = "ws.path.listaCompromisosPorEjecutor";
    public static final String WS_LISTA_COMPROMISOS_POR_VALIDADOR = "ws.path.listaCompromisosPorValidador";
    public static final String WS_LISTA_COMPROMISOS_POR_VERIFICADOR = "ws.path.listaCompromisosPorVerificador";

    //WS INCIDENCIAS
    public static final String WS_DETALLE_INCIDENCIAS_POR_EMPLEADO = "ws.path.detalleIncidenciasEmpleado";
    public static final String WS_ELIMINAR_INCIDENCIA_POR_EMPLEADO = "ws.path.eliminarIncidenciaEmpleado";
    public static final String WS_ACTUALIZAR_COMENTARIOS_INCIDENCIA = "ws.path.actualizarComentariosIncidencia";
    public static final String WS_ACTUALIZAR_IMPORTE_INCIDENCIA = "ws.path.actualizarImporteIncidencia";
    public static final String WS_ACTUALIZAR_INCIDENCIA = "ws.path.actualizarIncidencia";
    public static final String WS_REGISTRAR_INCIDENCIA = "ws.path.registrarIncidencia";
    public static final String WS_INCIDENCIAS_POR_QUINCENA = "ws.path.incidenciasPorQuincena";
    public static final String WS_INCIDENCIAS_POR_QUINCENA_AREA = "ws.path.incidenciasPorQuincenaArea";
    public static final String WS_INCIDENCIAS_POR_EMPLEADOQUINCENA = "ws.path.incidenciasPorEmpleadoQuincena";

    
    //WS IncidenciasQuincena
    public static final String WS_LISTAR_INCIDENCIAS_QUINCENA ="ws.path.listarIncidenciasQuincena";
    public static final String WS_VALIDAR_TODAS_INCIDENCIAS = "ws.path.validarTodasIncidencias";
    public static final String WS_VALIDAR_INCIDENCIAS = "ws.path.validarIncidencias";
    public static final String WS_RECHAZAR_TODAS_INCIDENCIAS = "ws.path.rechazarTodasIncidencias";
    public static final String WS_ENVIAR_CORREOS_INCIDENCIAS = "ws.path.enviarCorreos";
    public static final String WS_AUTORIZAR_INCIDENCIAS = "ws.path.autorizarIncidencias";
    public static final String WS_AUTORIZAR_TODAS_INCIDENCIAS = "ws.path.autorizarTodasIncidencias";
    public static final String WS_DENEGAR_TODAS_INCIDENCIAS = "ws.path.denegarTodasIncidencias";
    public static final String WS_INCIDENCIAS_QUINCENA_POR_AREA ="ws.path.incidenciasQuincenaPorArea";
    public static final String WS_AUTORIZAR_PAGOS_INCIDENCIAS = "ws.path.autorizarPagosIncidencias";
    public static final String WS_AUTORIZAR_PAGO_INCIDENCIAS = "ws.path.autorizarPagoIncidencias";
    public static final String WS_DENEGAR_PAGO_INCIDENCIAS = "ws.path.denegarPagoIncidencias";
    public static final String WS_POSPONER_PAGO_INCIDENCIA ="ws.path.posponerPagoIncidencia";

    //WS Puestos "Torres"
    public static final String WS_LISTA_PUESTOS = "ws.path.listaPuestos";
    public static final String WS_OBTENER_PUESTOS_POR_ID = "ws.path.obtenerPuestosPorId";

    //WS Cabeceras 
    public static final String WS_LISTA_CABECERAS = "ws.path.listaCabeceras";
    public static final String WS_GUARDAR_CABECERAS = "ws.path.guardarCabeceras";
    public static final String WS_OBTENER_CABECERA_POR_ID = "ws.path.obtenerCabeceraPorId";
    public static final String WS_CALCULA_NOMINA = "ws.path.calculaNomina";
    public static final String WS_LISTAR_EMPLEADOS_CABECERA ="ws.path.listarEmpleadosCabecera";
    public static final String WS_ELIMINAR_CABECERA = "ws.path.eliminarcabecera";
    public static final String WS_VALIDAR_PAGOS_NOMINA = "ws.path.validaPagosNomina";
    public static final String WS_CARGAR_IMSS = "ws.path.cargarImss";
    
    //WS Desgloce
    public static final String WS_LISTA_DEATALLE_DESGLOSE_D = "ws.path.detalleDesgloseD";
    public static final String WS_LISTA_DETALLES_DESGLOSE_P = "ws.path.detalleDesgloseP";
    public static final String WS_SUMA_DETALLE_DESGLOSE = "ws.path.sumaDesglose";

    //WS Autorizacion de Pagos RF y RH 
    public static final String WS_GUARDAR_AUTORIZACION_RF = "ws.path.guardarPagosRF";
    public static final String WS_RECHAZAR_AUTORIZACION_RF = "ws.path.rechazarPagosRF";
    
    public static final String WS_VALIDAR_TODAS_RF = "ws.path.validarTodas";
    public static final String WS_RECHAZAR_TODAS_RF = "ws.path.rechazarTodasRF";
    
    public static final String WS_GUARDAR_AUTORIZACION_RH = "ws.path.guardarPagosRH";
    public static final String WS_RECHAZAR_AUTORIZACION_RH = "ws.path.rechazarPagosRH";
    
    public static final String WS_VALIDAR_TODAS_RH = "ws.path.validarTodasRH";
    public static final String WS_RECHAZAR_TODAS_RH = "ws.path.rechazarTodasRH";
    
    public static final String WS_GUARDAR_AUTORIZACION_EMP = "ws.path.guardarPagosEMP";
    public static final String WS_RECHAZAR_AUTORIZACION_EMP = "ws.path.rechazarPagosEMP";
    public static final String WS_MOSTRAR_EMPLEADO = "ws.path.mostrarEmpleado";
 
    
    //calendario
    public static final String WS_LISTA_COMPROMISOS = "ws.path.listaCompromisos";

    public static final String WS_LISTA_REUNIOES_INVITADOS = "ws.path.listaReunionesInvitado";

    //chat
    public static final String WS_GUARDAR_CHAT = "ws.path.guardarChat";
    public static final String WS_ACTUALIZAR_CHAT = "ws.path.actualizarChat";
    public static final String WS_OBTENER_CHAT = "ws.path.obtnerChat";

    //Banderas
    public static final String ACTIVO = "1";

    //Privileges
    //Default
    public static final String EXTRANJERA = "Extranjera";
    public static final String RFC_PARAMETROS = "RFC";

    //URL´s
    public static final String CONTEXT_APP = "/SGRH-web";
    public static final String PAG_VACACIONES = "/vacaciones/vacaciones.xhtml?faces-redirect=true";

    //Plantillas reportes
    //  public static final String PLANTILLA_REPORTE_BITACORA = "plantilla_bitacora.jasper";
    //Extensiones de archivos 
    public static final String ARCHIVO_PDF = ".pdf";

    //Mensaje
    public static String CORREO_INEXISTENTE = "E009";
    public static String EXITO_ELIMINAR = "web.app.msj.exitoEliminar";
    public static String EXITO_GUARDADO = "web.app.msj.exitoGuardardo";
    public static String ERROR_REPETIDO = "web.app.msj.errorRepetido";
    public static String ERROR_ELIMINAR = "web.app.msj.errorEliminar";
    public static String ERROR_GUARDADO = "web.app.msj.errorGuardado";
    public static String ERROR_CAMPOS_VACIOS = "web.app.msj.errorCamposVacios";

}
