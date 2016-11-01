package com.reskitow.deadtestm8.Control;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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
        nombre = (nombre.isEmpty() ? "" : myUtils.capitalizarCadenasString(nombre));
        String apellidos = getIntent().getStringExtra("apellidos");
        apellidos = (apellidos.isEmpty() ? "" : myUtils.capitalizarCadenasString(apellidos));
        String fecha = getIntent().getStringExtra("fecha");
        String lugar = getIntent().getStringExtra("lugar");
        lugar = (lugar.isEmpty() ? "" : myUtils.capitalizarCadenasString(lugar));
        int[] fechas = myUtils.separarFechaInt(fecha);
        int sexo = getIntent().getIntExtra("sexo", -33);
        boolean[] vicios = getIntent().getBooleanArrayExtra("arrayVicios");
        int profesion = getIntent().getIntExtra("profesion", -33);
        String profesiones = getResources().getStringArray(R.array.array_profesiones)[profesion];
        ((TextView) findViewById(R.id.txt_act2)).setText("Nombre: " + nombre + ".\n" +
                (apellidos.isEmpty() ? "" : ("Apellidos: " + apellidos) + ".\n") +
                "Fecha: " + fecha + ".\n" +
                (lugar.isEmpty() ? "" : ("Lugar: " + lugar) + ".\n") +
                "Sexo: " + sexo + ".\n" +
                "Vicios: " + myUtils.mostrarVicios(vicios) + ".\n" +
                "Profesión: " + profesiones + ".\n" +
                "Dia: " + fechas[0] + ".\n" +
                "Mes: " + fechas[1] + ".\n" +
                "Año: " + fechas[2] + ".\n");
    }
}
