package com.example.calculoimc;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    EditText edtPeso;
    EditText edtAltura;
    Button btnCalcular;
    TextView txtMsg;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtPeso = findViewById(R.id.edtPeso);
        edtAltura = findViewById(R.id.edtAltura);
        btnCalcular = findViewById(R.id.btnCalcular);
        txtMsg = findViewById(R.id.txtMsg);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String msg = calcular(Double.valueOf(edtPeso.getText().toString()),Double.valueOf(edtAltura.getText().toString()));
                Intent intent = new Intent(getBaseContext(),Resultado.class);
                intent.putExtra("result",msg);
                startActivity(intent);


            }
        });
    }

    //calcular IMC
    public String calcular(Double peso,Double altura){
        altura = altura * altura;
        Double resultado = peso/altura;
        String retorno = converterDoubleString(resultado);
        return retorno;
    }

    //Formatar double em 2 casas decimais
    public static String converterDoubleString(double precoDouble) {
        /*Transformando um double em 2 casas decimais*/
        DecimalFormat fmt = new DecimalFormat("0.00");   //limita o número de casas decimais
        String string = fmt.format(precoDouble);
        String[] part = string.split("[,]");
        String valor = part[0]+"."+part[1];
        return valor;
    }
}


