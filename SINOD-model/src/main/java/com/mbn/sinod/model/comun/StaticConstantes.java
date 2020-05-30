
package com.mbn.sinod.model.comun;

import java.util.ResourceBundle;

/**
 * Clase en donde se encuentran las variables estaticas, mensajes y tipos de
 * mensajes mostrados en pantalla
 *
 * @author Francisco Rolando Muñoz
 */
public class StaticConstantes {

    private static final ResourceBundle CONF = ResourceBundle.getBundle("com.mbn.sinod.modelo.recurso.configuration");

    public static int MENSAJE_ERROR = 1;
    public static int MENSAJE_ADVERTENCIA = 2;
    public static int MENSAJE_CORRECTO = 3;
    
    //Sistema
    public static int CODIGO_SISTEMA = 3;

    //Mensaje
    public static String EXITO_GUARDAR_ARGUMENTO="IOO1";
    public static String ERROR_GUARDAR_ARGUMENTO="EOO1";
    
    public static String EXITO_ELIMINAR_ARGUMENTO="IOO2";
    public static String ERROR_ELIMINAR_ARGUMENTO="EOO2";
    
    public static String EXITO_OBTENER_LISTA_ARGUMENTOS="IOO3";
    public static String ERROR_OBTENER_LISTA_ARGUMENTOS="EOO3";
    
    public static String EXITO_OBTENER_LISTA_ARGUMENTOS_CONSTANTES="IOO4";
    public static String ERROR_OBTENER_LISTA_ARGUMENTOS_CONSTANTES="EOO4";
    
    public static String EXITO_OBTENER_LISTA_ARGUMENTOS_VARIABLES="IOO5";
    public static String ERROR_OBTENER_LISTA_ARGUMENTOS_VARIABLES="EOO5";
    
    public static String EXITO_OBTENER_LISTA_FUNCIONES="IOO6";
    public static String ERROR_OBTENER_LISTA_FUNCIONES="EOO6";
    
    public static String EXITO_ELIMINAR_CONCEPTO="IOO7";
    public static String ERROR_ELIMINAR_CONCEPTO="EOO7";
    
    public static String EXITO_LISTAR_CONCEPTOS_PERCEPCION="I008";
    public static String ERROR_LISTAR_CONCEPTOS_PERCEPCION="E008";
    
    public static String EXITO_LISTAR_CONCEPTOS_DEDUCCION="I009";
    public static String ERROR_LISTAR_CONCEPTOS_DEDUCCION="E009";
    
    public static String EXITO_LISTAR_INCIDENCIAS_QUINCENA = "I010";
    public static String ERROR_LISTAR_INCIDENCIAS_QUINCENA = "E010";
    
    public static String EXITO_LISTAR_ALTAS_A_VALIDAR = "I011";
    public static String ERROR_LISTAR_ALTAS_A_VALIDAR = "E011";
    

    public static String EXITO_LISTAR_BAJAS_A_VALIDAR = "I012";
    public static String ERROR_LISTAR_BAJAS_A_VALIDAR = "E012";
    

    public static String EXITO_LISTAR_EMPLEADOS_CABECERA = "I013";
    public static String ERROR_LISTAR_EMPLEADOS_CABECERA = "E013";
   
    
    public static String EXITO_ELIMINAR_CABECERA = "E014";
    

    public static String EXITO_OBTENER_LISTAEMPLEADOS = "LISTA DE EMPLEADOS OBTENIDA";
    public static String ERROR_OBTENER_LISTAEMPLEADOS = "LISTA DE EMPLEADOS NO OBTENIDA";
    
    
    
    
    
    
    //Banderas
   
    
    //Correo 
    
    //Nombre sistema
    public static String NOMBRE_SISTEMA = CONF.getString("sistema");
    
    //Formatos
    public static final String FORMATO_FECHA = CONF.getString("formato.fecha");

    /**
     * @param conf
     * @return the CONF
     */
    public static String getCONF(String conf) {
        return CONF.getString(conf);
    }

}
