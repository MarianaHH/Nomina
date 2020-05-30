package com.mbn.sinod.model.comun;

import java.util.Calendar;
import java.util.List;

/**
 * Clase que contiene metodos de utileria
 *
 * @author
 */
public class Util {

    /**
     * método para obtener los días hábiles entre 2 fechas
     *
     * @param fechaInicial
     * @param fechaFinal
     * @param listaFechasNoLaborables
     * @return
     */
    public static int getDiasHabiles(Calendar fechaInicial, Calendar fechaFinal, List<Calendar> listaFechasNoLaborables) {

        int diffDays = 0;
        Calendar fechaInicialtmp = fechaInicial;
        Calendar fechaFinaltmp = fechaFinal;
        //mientras la fecha inicial sea menor o igual que la fecha final se cuentan los dias 
        while (fechaInicialtmp.before(fechaFinaltmp) || fechaInicialtmp.equals(fechaFinaltmp)) {

            //si el dia de la semana de la fecha minima es diferente de sabado o domingo 
            if (fechaInicialtmp.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY && fechaInicialtmp.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY) {

                //se recorre la lista de días no habiles
                if (listaFechasNoLaborables != null && listaFechasNoLaborables.size() > 0) {
                    for (Calendar calendarTmp : listaFechasNoLaborables) {
                        if (!fechaInicialtmp.getTime().equals(calendarTmp.getTime())) {
                            System.out.println(fechaInicialtmp.getTime() + " --> " + calendarTmp.getTime());
                            diffDays++;
                        }
                    }

                } else {
                      System.out.println(fechaInicialtmp.getTime() + " ----------> " );
                           
                    diffDays++;
                }

            }

            //se suma 1 dia para hacer la validacion del siguiente dia. 
            fechaInicialtmp.add(Calendar.DATE, 1);

        }

        return diffDays;

    }

}
