package com.reskitow.deadtestm8.Utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

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

    public String mostrarVicios(boolean[] vicios) {
        String resultado = "";
        for (int i = 0; i < vicios.length; i++) {
            switch (i) {
                case 0:
                    resultado += vicios[i] ? "Drogas " : "";
                    break;
                case 1:
                    resultado += vicios[i] ? "Sexo " : "";
                    break;
                case 2:
                    resultado += vicios[i] ? "Mujeres " : "";
                    break;
                case 3:
                    resultado += vicios[i] ? "Tabaco " : "";
                    break;
                case 4:
                    resultado += vicios[i] ? "Deporte " : "";
                    break;
                case 5:
                    resultado += vicios[i] ? "Madrugar " : "";
                    break;
            }
        }
        return resultado.isEmpty() ? "No hay vicios seleccionados" : resultado;
    }

    public int calcularFechaMuerte(int anyo, boolean[] vicios) {
        /*int anyoMuerte = 0;
        while (anyoMuerte < Calendar.YEAR && anyoMuerte - anyo > 95) {

        }
        return anyoMuerte;*/
        return 2042;
    }

    public String calcularDescMuerte(String[] descripciones) {
        return descripciones[new Random().nextInt(descripciones.length)];
    }

}
