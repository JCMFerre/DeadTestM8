package com.reskitow.deadtestm8.Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MyUtils {

    public String modificarVista(String formato, Calendar cal) {
        return (new SimpleDateFormat(formato).format(cal.getTime()));
    }

    public String[] separarFecha(String fecha) {
        return fecha.split("/");
    }

    public String capitalizarString(String nombre) {
        return (nombre.substring(0, 1).toUpperCase() + nombre.substring(1).toLowerCase());
    }

    public String capitalizarDosString(String nombre) {
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

    public int separarPorEspacios(String cadena) {
        return cadena.split("\\s+").length;
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

}
