package com.larissa.treinodieta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button contadorCalorias = (Button)findViewById(R.id.btnContadorCalorias);
        Button calculoImc = (Button)findViewById(R.id.btnCalculoImc);
        Button medidasPessoa = (Button)findViewById(R.id.btnMedidas);


        contadorCalorias.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intentContadorCalorias = new Intent(MainActivity.this, ContadorCaloriasActivity.class);
                startActivity(intentContadorCalorias);
            }
        });

        calculoImc.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intentCalculoImc = new Intent(MainActivity.this, CalculoImcActivity.class);
                startActivity(intentCalculoImc);
            }
        });

        medidasPessoa.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intentMedidasPessoa = new Intent(MainActivity.this, MedidasPessoaActivity.class);
                startActivity(intentMedidasPessoa);
            }
        });



    }
}