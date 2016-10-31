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
        ((TextView) findViewById(R.id.txt_act2)).setText("Hola " + getIntent().getStringExtra("Prueba") + ",  Todo un placer.");
    }
}
