package com.reskitow.deadtestm8.Control;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
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
        String apellidos = getIntent().getStringExtra("apellidos");
        String lugar = getIntent().getStringExtra("lugar");
        int anyoFecha = myUtils.separarFechaInt(getIntent().getStringExtra("fecha"))[2];
        int sexo = getIntent().getIntExtra("sexo", -33);
        boolean[] vicios = getIntent().getBooleanArrayExtra("arrayVicios");
        String profesiones = getResources().getStringArray(R.array.array_profesiones)[getIntent().getIntExtra("profesion", -33)];

        ((TextView) findViewById(R.id.resultado_nombre)).setText(myUtils.capitalizarCadenasString
                (getIntent().getStringExtra("nombre")));

        if (!apellidos.isEmpty()) {
            TextView txtApellidos = (TextView) findViewById(R.id.resultado_apellidos);
            txtApellidos.setVisibility(View.VISIBLE);
            txtApellidos.setText(myUtils.capitalizarCadenasString(apellidos));
        }
        ((TextView) findViewById(R.id.resultado_fechas)).setText(anyoFecha + " - " +
                myUtils.calcularFechaMuerte(anyoFecha, vicios));

        ((TextView) findViewById(R.id.resultado_muerte)).setText(myUtils.calcularDescMuerte(
                getResources().getStringArray(R.array.array_descripciones)));

        ((TextView) findViewById(R.id.resultado_vicio)).setText("");

        ((TextView) findViewById(R.id.resultado_lugar_prof)).setText((lugar.isEmpty() ? ""
                : getString(R.string.res_lugar_1) + " " + myUtils.capitalizarCadenasString(lugar) + ". ") +
                (sexo == 0 ? getString(R.string.res_lugar_2h) : (sexo == 1 ? getString(R.string.res_lugar_2m) :
                        getString(R.string.res_lugar_2o))) +
                getString(R.string.res_lugar3) + " " + profesiones + ".");
    }

}
