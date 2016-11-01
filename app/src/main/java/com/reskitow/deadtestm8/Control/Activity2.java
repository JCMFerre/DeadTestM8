package com.reskitow.deadtestm8.Control;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.reskitow.deadtestm8.R;
import com.reskitow.deadtestm8.Utils.MyUtils;

public class Activity2 extends AppCompatActivity {

    private MyUtils myUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        myUtils = new MyUtils();
        String nombre = getIntent().getStringExtra("nombre");
        String apellidos = getIntent().getStringExtra("apellidos");
        String fecha = getIntent().getStringExtra("fecha");
        String lugar = getIntent().getStringExtra("lugar");
        String[] fechas = myUtils.separarFecha(fecha);
        int sexo = getIntent().getIntExtra("sexo", -33);
        boolean[] vicios = getIntent().getBooleanArrayExtra("arrayVicios");
        int profesion = getIntent().getIntExtra("profesion", -33);
        String[] profesiones;
        profesiones = getResources().getStringArray(R.array.array_profesiones);
        ((TextView) findViewById(R.id.txt_act2)).setText("Nombre: " + myUtils.capitalizarDosString(nombre) + ".\n" +
                (apellidos.isEmpty() ? "" : ("Apellidos: " + myUtils.capitalizarDosString(apellidos)) + ".\n") +
                "Fecha: " + fecha + ".\n" +
                (lugar.isEmpty() ? "" : ("Lugar: " + myUtils.capitalizarDosString(lugar)) + ".\n") +
                "Sexo: " + sexo + ".\n" +
                "Vicios: " + myUtils.mostrarVicios(vicios) + ".\n" +
                "Profesión: " + profesiones[profesion] + ".\n" +
                "Dia: " + Integer.parseInt(fechas[0]) + ".\n" +
                "Mes: " + Integer.parseInt(fechas[1]) + ".\n" +
                "Año: " + Integer.parseInt(fechas[2]) + ".\n" +
                "Total length de (" + apellidos + ") : " + myUtils.separarPorEspacios(apellidos) +
                ", (" + nombre + ") : " + myUtils.separarPorEspacios(nombre));
    }
}
