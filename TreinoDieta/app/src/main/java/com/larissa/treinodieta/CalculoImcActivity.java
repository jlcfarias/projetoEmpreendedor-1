package com.larissa.treinodieta;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CalculoImcActivity extends AppCompatActivity {

    private TextView txtResultado;
    private Button btncalcularImc;
    private EditText editPeso;
    private EditText editAltura;
    private Button btnlimpar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo_imc);

        editPeso = findViewById(R.id.edtPesoCorporal);
        editAltura = findViewById(R.id.edtAltura);
        txtResultado = findViewById(R.id.txtResultado);
        btncalcularImc = findViewById(R.id.btnCalcular);
        btnlimpar = findViewById(R.id.btnLimpar);

        btncalcularImc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcular();
            }
        });
        btnlimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                limpar();
            }
        });
    }

    private void calcular(){

        float peso = Float.parseFloat(editPeso.getText().toString());
        float altura = Float.parseFloat(editAltura.getText().toString());
        float res = peso / (altura * altura);

      //  String resultado = Float.toString(res);
        String imc;

        if (res < 18.5){
            imc = "Muito a baixo do normal";
        } else if (res < 24.9) {
            imc = "Normal";
        } else if (res <29.9) {
            imc = "Sobrepeso";
        }else {
            imc = "Obesidade";
        }
        txtResultado.setText("IMC: " + String.format("%.2f", res ) + " " + " - " + imc);
    }

    private void limpar(){
        editPeso.setText("");
        editAltura.setText("");
    }

}
