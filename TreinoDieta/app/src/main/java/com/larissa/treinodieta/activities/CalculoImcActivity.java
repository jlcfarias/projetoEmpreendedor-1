package com.larissa.treinodieta.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.larissa.treinodieta.R;

public class CalculoImcActivity extends AppCompatActivity {

    private TextView txtResultado;
    private Button btncalcularImc;
    private EditText editPeso;
    private EditText editAltura;
    private Button btnlimpar;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater mMenuInflater =  getMenuInflater();
        mMenuInflater.inflate(R.menu.voltar, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected( MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.menu_voltar) {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo_imc);
        setTitle(R.string.labelCalculoImc);

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

        if(!validaCamposObrigatorios()){
            float peso = Float.parseFloat(editPeso.getText().toString());
            float altura = Float.parseFloat(editAltura.getText().toString());
            float res = peso / (altura * altura);

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

    }

    private void limpar(){
        editPeso.setText("");
        editAltura.setText("");
        txtResultado.setText("");
    }

    public boolean validaCamposObrigatorios(){

        Boolean verificarCamposPreenchidos = false;

        String validaFieldPeso = editPeso.getText().toString();
        String validaFieldAltura = editAltura.getText().toString();

        if (validaFieldPeso.equals("")){
            verificarCamposPreenchidos = true;
            editPeso.setError("Preencha o campo peso");
        }

        if (validaFieldAltura.equals("")){
            verificarCamposPreenchidos = true;
            editAltura.setError("Preencha o campo altura");
        }

        return verificarCamposPreenchidos ;
    }

}
