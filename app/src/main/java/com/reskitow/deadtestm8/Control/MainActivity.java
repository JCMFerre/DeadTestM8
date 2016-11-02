package com.reskitow.deadtestm8.Control;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.reskitow.deadtestm8.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Creamos el escuchador para asignaserlo posteriormente a las vistas que queremos.
        Escuchador escuchador = new Escuchador(this);
        // Aquí se lo asignamos.
        findViewById(R.id.btn_calc).setOnClickListener(escuchador);
        findViewById(R.id.et_fecha).setOnClickListener(escuchador);
        // Instanciamos spinner de la vista
        Spinner spinner = (Spinner) findViewById(R.id.spinner_profesiones);
        // Creamos el adaptador con el contexto (this), array y layout.
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.array_profesiones,
                android.R.layout.simple_spinner_dropdown_item);
        // Le asignamos un layout para cuando se desplegue.
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Asignamos el adaptador al spinner
        spinner.setAdapter(adapter);
        // Asignamos el escuchador.
        spinner.setOnItemSelectedListener(escuchador);
    }

}
