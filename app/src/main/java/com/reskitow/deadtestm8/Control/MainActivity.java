package com.reskitow.deadtestm8.Control;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.reskitow.deadtestm8.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Escuchador escuchador = new Escuchador(this);
        Button botonCalcular = (Button) findViewById(R.id.btn_calc);
        botonCalcular.setOnClickListener(escuchador);
        Spinner spinner = (Spinner) findViewById(R.id.spinner_profesiones);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.array_profesiones,
                android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(escuchador);
        EditText etFecha = (EditText) findViewById(R.id.et_fecha);
        etFecha.setOnClickListener(escuchador);
    }
}
