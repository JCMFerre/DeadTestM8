package com.reskitow.deadtestm8.Utils;

import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.reskitow.deadtestm8.Control.MainActivity;
import com.reskitow.deadtestm8.R;

/**
 * En esta clase validaremos campos y devolveremos los valores de algunas vistas del mainActivity.
 */
public class Validacion {

    private MainActivity mainActivity;

    public Validacion(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    public boolean validarRequeridos() {
        boolean nombre = validarEditText(R.id.et_nombre, R.id.nombre_error);
        boolean fecha = validarEditText(R.id.et_fecha, R.id.fecha_error);
        boolean radios = validarRadioButton();
        return (nombre && fecha && radios);
    }

    private boolean validarEditText(int EditTextId, int TextViewId) {
        TextView txt = (TextView) mainActivity.findViewById(TextViewId);
        if (((EditText) mainActivity.findViewById(EditTextId)).getText().toString().isEmpty()) {
            txt.setVisibility(View.VISIBLE);
            return false;
        } else {
            txt.setVisibility(View.GONE);
            return true;
        }
    }

    private boolean validarRadioButton() {
        TextView txt = (TextView) mainActivity.findViewById(R.id.sexo_error);
        if (!(((RadioButton) mainActivity.findViewById(R.id.rd_hombre)).isChecked() ||
                ((RadioButton) mainActivity.findViewById(R.id.rd_mujer)).isChecked() ||
                ((RadioButton) mainActivity.findViewById(R.id.rd_otros)).isChecked())) {
            txt.setVisibility(View.VISIBLE);
            return false;
        } else {
            txt.setVisibility(View.GONE);
            return true;
        }
    }

    public boolean[] arrayVicios() {
        return new boolean[]{((CheckBox) mainActivity.findViewById(R.id.cb_drogas)).isChecked(),
                ((CheckBox) mainActivity.findViewById(R.id.cb_sexo)).isChecked(),
                ((CheckBox) mainActivity.findViewById(R.id.cb_alcohol)).isChecked(),
                ((CheckBox) mainActivity.findViewById(R.id.cb_tabaco)).isChecked(),
                ((CheckBox) mainActivity.findViewById(R.id.cb_deporte)).isChecked(),
                ((CheckBox) mainActivity.findViewById(R.id.cb_madrugar)).isChecked()};
    }

    public int obtenerIntSexo() {
        return ((RadioButton) mainActivity.findViewById(R.id.rd_hombre)).isChecked() ? 0 :
                ((RadioButton) mainActivity.findViewById(R.id.rd_mujer)).isChecked() ? 1 : 2;
    }
}
