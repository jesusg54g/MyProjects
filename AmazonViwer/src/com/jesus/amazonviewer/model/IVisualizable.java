package com.jesus.amazonviewer.model;

import java.util.Date;

public interface IVisualizable {

    /**
     * Este metodo captura el tiempo exacto de inicio de
     * visualizacion.
     *
     * @param dateI  es un objeto {@code Date} con el tiempo de
     * inicio exacto.
     * @return Devuelve la fecha y hora capturada.
     * */

    Date startToSee(Date dateI);

    /**
     * Este metodo captura el tiempo exacto de inico y final de
     * visualizacion.
     *
     * @param dataI Es un objeto {@code Date} con el tiempo de inicio
     * exacto.
     * @param dateF Es un objeto {@code Date} con el tiempo final exacto.
     * */
    void stopToSee(Date dataI, Date dateF);
}
