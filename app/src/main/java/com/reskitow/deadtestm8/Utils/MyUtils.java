package com.reskitow.deadtestm8.Utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

/**
 * En esta clase utilizaremos metodos para capitalizar una palabra, etc.
 * Los metodos siempre devuelven en esta clase.
 */
public class MyUtils {

    public String modificarVista(String formato, Calendar cal) {
        return (new SimpleDateFormat(formato).format(cal.getTime()));
    }

    public int[] separarFechaInt(String fecha) {
        String[] fechas = fecha.split("/");
        int[] fechasInt = new int[fechas.length];
        for (int i = 0; i < fechas.length; i++) {
            fechasInt[i] = Integer.parseInt(fechas[i]);
        }
        return fechasInt;
    }

    private String capitalizarString(String nombre) {
        return (nombre.length() >= 2 ? nombre.substring(0, 1).toUpperCase() + nombre.substring(1).toLowerCase() :
                nombre.substring(0, 1).toUpperCase());
    }

    public String capitalizarCadenasString(String nombre) {
        String[] cadenas = nombre.split("\\s+");
        if (cadenas.length > 1) {
            String cad = "";
            for (int i = 0; i < cadenas.length; i++) {
                cad += (i != cadenas.length - 1) ? capitalizarString(cadenas[i]) +
                        " " : capitalizarString(cadenas[i]);
            }
            return cad;
        } else {
            return capitalizarString(nombre);
        }
    }

    public int calcularFechaMuerte(int anyo, boolean[] vicios) {
        int anyoMuerte = 0;
        while (anyoMuerte < anyo) {
            anyoMuerte = anyo + 27 + (new Random().nextInt(53));
            for (int i = 0; i < vicios.length; i++) {
                anyoMuerte -= (vicios[i]) ? 3 : 0;
            }
        }
        return anyoMuerte;
    }

    public String calcularDescMuerte(String[] descripciones) {
        return descripciones[new Random().nextInt(descripciones.length)];
    }

}
