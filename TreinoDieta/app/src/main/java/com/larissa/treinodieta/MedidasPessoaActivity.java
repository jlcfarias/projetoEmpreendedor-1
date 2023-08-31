package com.larissa.treinodieta;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.larissa.treinodieta.dao.MedidasCorporalDao;
import com.larissa.treinodieta.helpers.MedidasCorporalHelper;
import com.larissa.treinodieta.model.MedidasCorporal;

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

        salvar = findViewById(R.id.btnSalvar);

        medidasCorporalHelper = new MedidasCorporalHelper(this);

        Intent mIntent = getIntent();
        MedidasCorporal medidasCorporal = (MedidasCorporal) mIntent.getSerializableExtra("MedidasCorporal");
        if (medidasCorporal != null){
            medidasCorporalHelper.preencherCampos(medidasCorporal);
        }

        MedidasCorporalDao dao = new MedidasCorporalDao(this);
        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MedidasCorporal medidas = medidasCorporalHelper.getMedidasCorporal();

                if (medidas.getId() == null){
                    dao.inserirMedidasCorporal(medidas);
                    dao.close();
                    Toast.makeText(getApplicationContext(), "Salvo com Sucesso!" , Toast.LENGTH_SHORT).show();

                }
            }
        });
    }

}
