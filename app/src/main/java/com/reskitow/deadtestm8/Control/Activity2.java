package com.reskitow.deadtestm8.Control;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import com.reskitow.deadtestm8.R;
import com.reskitow.deadtestm8.Utils.MyUtils;

public class Activity2 extends AppCompatActivity {

    private MyUtils myUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        // Comprobamos si el Bundle está o no en nulo, si no está en nulo cargaremos la información
        // que contiene, ya que significa que ha estado antes abierta, si no, cargamos los elementos
        // como si los recibiéramos de nuevo.
        if (savedInstanceState != null) {
            ((TextView) findViewById(R.id.resultado_nombre)).setText(savedInstanceState.getString("resultado_nombre"));
            ((TextView) findViewById(R.id.resultado_fechas)).setText(savedInstanceState.getString("resultado_fechas"));
            ((TextView) findViewById(R.id.resultado_muerte)).setText(savedInstanceState.getString("resultado_muertes"));
            ((TextView) findViewById(R.id.resultado_vicio)).setText(savedInstanceState.getString("resultado_vicios"));
            ((TextView) findViewById(R.id.resultado_lugar_prof)).setText(savedInstanceState.getString("resultado_lugar_prof"));
        } else {
            // Instanciamos la clase MyUtils para poder usarla.
            myUtils = new MyUtils();
            // Recibimos con getIntent lo que hemos pasado desde la otra activity.
            String apellidos = getIntent().getStringExtra("apellidos");
            String lugar = getIntent().getStringExtra("lugar");
            int anyoFecha = myUtils.separarFechaInt(getIntent().getStringExtra("fecha"))[2];
            int sexo = getIntent().getIntExtra("sexo", -33);
            boolean[] vicios = getIntent().getBooleanArrayExtra("arrayVicios");
            String profesiones = getResources().getStringArray(R.array.array_profesiones)[getIntent().getIntExtra("profesion", -33)];
            // Mostramos nombre, si apellido esta vacio (No lo recibe) no lo mostramos, si no esta vacio, se muestra.
            if (!apellidos.isEmpty()) {
                ((TextView) findViewById(R.id.resultado_nombre)).setText(myUtils.capitalizarCadenasString
                        (getIntent().getStringExtra("nombre")) + " " + myUtils.capitalizarCadenasString(apellidos));
            } else {
                ((TextView) findViewById(R.id.resultado_nombre)).setText(myUtils.capitalizarCadenasString
                        (getIntent().getStringExtra("nombre")));
            }

            // Mostramos el año de nacimiento y calculamos el de la muerte.
            ((TextView) findViewById(R.id.resultado_fechas)).setText(anyoFecha + " - " +
                    myUtils.calcularFechaMuerte(anyoFecha, vicios));

            // Mostramos algunas frases con descripciones de muertes ¡¡¡ Importante no se puede traducir !!!
            ((TextView) findViewById(R.id.resultado_muerte)).setText(myUtils.calcularDescMuerte(
                    getResources().getStringArray(R.array.array_descripciones)));

            // Mostramos algunas frases relacionadas con los vicios.
            ((TextView) findViewById(R.id.resultado_vicio)).setText(calcularDescVicios(vicios));

            // Dependiendo de como esta el campo lugar y sexo, se mostrarà una cosa u otra.
            ((TextView) findViewById(R.id.resultado_lugar_prof)).setText((lugar.isEmpty() ? ""
                    : getString(R.string.res_lugar_1) + " " + myUtils.capitalizarCadenasString(lugar) + ". ") +
                    (sexo == 0 ? getString(R.string.res_lugar_2h) : (sexo == 1 ? getString(R.string.res_lugar_2m) :
                            getString(R.string.res_lugar_2o))) +
                    getString(R.string.res_lugar3) + " " + profesiones + ".");
        }
    }

    /*
     * Algoritmo básico para devolver frases según los vicios.
     * @param vicios
     * @return
     */
    private String calcularDescVicios(boolean[] vicios) {
        int contador = 0;
        String resultado = "";
        for (int i = 0; i < vicios.length; i++) {
            if (vicios[i]) {
                contador++;
            }
        }
        if (contador == 0) {
            resultado = getString(R.string.vicios_desc_1);
        } else if (contador <= 2) {
            if (vicios[vicios.length - 1]) {
                resultado = getString(R.string.vicios_desc_2);
            } else {
                resultado = getString(R.string.vicios_desc_3);
            }
        } else if (contador <= 4) {
            resultado = getString(R.string.vicios_desc_4);
        } else if (contador == 5) {
            resultado = getString(R.string.vicios_desc_5);
        } else {
            resultado = getString(R.string.vicios_desc_6);
        }
        return resultado;
    }


    /*
    * A este método accederá cuando el usuario abandone la activity, así que guardamos los datos que tenemos cargados
    * en un Bundle que luego recuperaremos si el Bundle no es nulo.
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString("resultado_nombre", ((TextView) findViewById(R.id.resultado_nombre)).getText().toString());
        outState.putString("resultado_fechas", ((TextView) findViewById(R.id.resultado_fechas)).getText().toString());
        outState.putString("resultado_muertes", ((TextView) findViewById(R.id.resultado_muerte)).getText().toString());
        outState.putString("resultado_vicios", ((TextView) findViewById(R.id.resultado_vicio)).getText().toString());
        outState.putString("resultado_lugar_prof", ((TextView) findViewById(R.id.resultado_lugar_prof)).getText().toString());
        super.onSaveInstanceState(outState);
    }
}
