package com.reskitow.deadtestm8.Control;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.reskitow.deadtestm8.R;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        String nombre = getIntent().getStringExtra("Prueba");
        nombre = nombre.substring(0, 1).toUpperCase() + nombre.substring(1).toLowerCase();
        ((TextView) findViewById(R.id.txt_act2)).setText("Hola " + nombre + ",  Todo un placer.");
    }
}
