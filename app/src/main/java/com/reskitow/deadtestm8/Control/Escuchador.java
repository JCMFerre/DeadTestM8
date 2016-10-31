package com.reskitow.deadtestm8.Control;

import android.app.DatePickerDialog;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.reskitow.deadtestm8.R;
import com.reskitow.deadtestm8.Utils.MyUtils;

import java.util.Calendar;
import java.util.TimeZone;

public class Escuchador implements View.OnClickListener, AdapterView.OnItemSelectedListener, DatePickerDialog.OnDateSetListener {

    private MainActivity mainActivity;
    private MyUtils myUtils;
    private Calendar cal;

    public Escuchador(final MainActivity mainActivity) {
        this.mainActivity = mainActivity;
        myUtils = new MyUtils();
        cal = Calendar.getInstance(TimeZone.getDefault());
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_calc:
                lanzarMensaje("Has pulsado el boton calc.");
                break;
            case R.id.et_fecha:
                new DatePickerDialog(mainActivity, this, cal.get(cal.YEAR),
                        cal.get(cal.MONTH), cal.get(cal.DAY_OF_MONTH)).show();
                break;
            default:
                lanzarMensaje("Error");
                break;
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
        mainActivity.findViewById(R.id.btn_calc).setVisibility((position == 0) ? View.GONE: View.VISIBLE);
        mainActivity.findViewById(R.id.txt_aviso).setVisibility((position == 0) ? View.VISIBLE : View.GONE);
        if (position != 0){
            switch (position) {
                case 1:
                    lanzarMensaje(""+adapterView.getItemAtPosition(1));
                    break;
                case 2:
                    lanzarMensaje(""+adapterView.getItemAtPosition(2));
                    break;
                case 3:
                    lanzarMensaje(""+adapterView.getItemAtPosition(3));
                    break;
                default:
                    lanzarMensaje("error");
                    break;
            }
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        lanzarMensaje("La verdad no se cuando entra.");
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
