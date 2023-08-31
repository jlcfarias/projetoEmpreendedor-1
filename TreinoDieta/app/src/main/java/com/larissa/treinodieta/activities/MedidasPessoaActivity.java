package com.larissa.treinodieta.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.larissa.treinodieta.R;
import com.larissa.treinodieta.dao.MedidasCorporalDao;
import com.larissa.treinodieta.helpers.MedidasCorporalHelper;
import com.larissa.treinodieta.models.MedidasCorporal;

public class MedidasPessoaActivity extends AppCompatActivity {

    private MedidasCorporalHelper medidasCorporalHelper;

    private Button salvar;

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
            Intent i = new Intent(MedidasPessoaActivity.this, MainActivity.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medidas_pessoa);
        setTitle(R.string.medidasCorporal);

        salvar = findViewById(R.id.btnSalvar);

        medidasCorporalHelper = new MedidasCorporalHelper(this);

        MedidasCorporalDao dao = new MedidasCorporalDao(this);

        MedidasCorporal ultimaMedida = dao.burcarMedidasCorporal();

        if (ultimaMedida != null){
            medidasCorporalHelper.preencherCampos(ultimaMedida);
        }

        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MedidasCorporal medidas = medidasCorporalHelper.getMedidasCorporal();
                    dao.inserirMedidasCorporal(medidas);
                    dao.close();
                    Toast.makeText(getApplicationContext(), R.string.salvoSucesso , Toast.LENGTH_SHORT).show();
            }
        });
    }

}
