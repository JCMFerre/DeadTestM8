package com.reskitow.deadtestm8.Control;

import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import com.reskitow.deadtestm8.R;

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
}
