package com.example.calculoimc;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Resultado extends AppCompatActivity {
    TextView txtMostra;
    TextView txtMsgPeso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        txtMostra = findViewById(R.id.txtMostra);
        txtMsgPeso = findViewById(R.id.txtMsgPeso);

        Intent intent = getIntent();
        String resultado = intent.getStringExtra("result");
        txtMostra.setText(resultado);

        Double valor = Double.valueOf(resultado);


        if (valor < 18.5){
            txtMsgPeso.setText("Você está abaixo do peso.");
        }else if (valor <25){
            txtMsgPeso.setText("Você está com peso normal.");
        }else if (valor < 30){
            txtMsgPeso.setText("Você está com sobrepeso.");
        }else if (valor <40){
            txtMsgPeso.setText("Você está com obesidade.");
        }else if (valor >=40){
            txtMsgPeso.setText("Você está com obesidade grave.");
        }
    }
}
