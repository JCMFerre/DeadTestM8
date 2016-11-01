package com.reskitow.deadtestm8.Control;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import com.reskitow.deadtestm8.R;
import com.reskitow.deadtestm8.Utils.MyUtils;
import com.reskitow.deadtestm8.Utils.Validacion;

import java.util.Calendar;
import java.util.TimeZone;

/*
 * Esta clase controla los eventos y el envio de información a la otra activity.
 *
 */
public class Escuchador implements View.OnClickListener, AdapterView.OnItemSelectedListener, DatePickerDialog.OnDateSetListener {

    private MainActivity mainActivity;
    private MyUtils myUtils;
    private Validacion validacion;
    private Calendar cal;
    private int itemProfesion;

    public Escuchador(final MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        myUtils = new MyUtils();
        validacion = new Validacion(mainActivity);
        cal = Calendar.getInstance(TimeZone.getDefault());
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_calc:
                if (validacion.validarRequeridos()) {
                    Intent i = new Intent(mainActivity, Activity2.class);
                    i.putExtra("nombre", ((EditText) mainActivity.findViewById(R.id.et_nombre)).getText().toString());
                    i.putExtra("apellidos", ((EditText) mainActivity.findViewById(R.id.et_apellidos)).getText().toString());
                    i.putExtra("fecha", ((EditText) mainActivity.findViewById(R.id.et_fecha)).getText().toString());
                    i.putExtra("lugar", ((EditText) mainActivity.findViewById(R.id.et_lugar)).getText().toString());
                    i.putExtra("sexo", validacion.obtenerIntSexo());
                    i.putExtra("arrayVicios", validacion.arrayVicios());
                    i.putExtra("profesion", itemProfesion);
                    mainActivity.startActivity(i);
                } else {
                    lanzarMensaje(mainActivity.getString(R.string.completa_requeridos));
                }
                break;
            case R.id.et_fecha:
                new DatePickerDialog(mainActivity, this, cal.get(Calendar.YEAR),
                        cal.get(Calendar.MONTH), cal.get(Calendar.DAY_OF_MONTH)).show();
                break;
            default:
                lanzarMensaje(mainActivity.getString(R.string.e33));
                break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
        mainActivity.findViewById(R.id.btn_calc).setVisibility((position == 0) ? View.GONE : View.VISIBLE);
        mainActivity.findViewById(R.id.txt_aviso).setVisibility((position == 0) ? View.VISIBLE : View.GONE);
        if (position != 0) {
            itemProfesion = position;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        // No entrará, porque para ir a otra activity es necesario cambiar de item.
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        ((EditText) mainActivity.findViewById(R.id.et_fecha)).setText(myUtils.modificarVista("dd/MM/yyyy", cal));
    }

    private void lanzarMensaje(String mensaje) {
        Toast.makeText(mainActivity, mensaje, Toast.LENGTH_SHORT).show();
    }
}
