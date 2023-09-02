package com.larissa.treinodieta.helpers;

import android.widget.EditText;

import com.larissa.treinodieta.activities.MedidasPessoaActivity;
import com.larissa.treinodieta.R;
import com.larissa.treinodieta.models.MedidasCorporal;

public class MedidasCorporalHelper {
    private final EditText antebracoE;
    private final EditText antebracoD;
    private final EditText bracoE;
    private final EditText bracoD;
    private final EditText cintura;
    private final EditText quadril;
    private final EditText pernaE;
    private final EditText pernaD;
    private final EditText peito;
    private MedidasCorporal medidasCorporal;

    public MedidasCorporalHelper(MedidasPessoaActivity medidasPessoaActivity){
        antebracoE = (EditText) medidasPessoaActivity.findViewById(R.id.edtAntebracoE);
        antebracoD = (EditText) medidasPessoaActivity.findViewById(R.id.edtAntebracoD);
        bracoE = (EditText) medidasPessoaActivity.findViewById(R.id.edtBracoE);
        bracoD = (EditText) medidasPessoaActivity.findViewById(R.id.edtBracoD);
        cintura = (EditText) medidasPessoaActivity.findViewById(R.id.edtCintura);
        quadril = (EditText) medidasPessoaActivity.findViewById(R.id.edtQuadril);
        pernaE = (EditText) medidasPessoaActivity.findViewById(R.id.edtPernaE);
        pernaD = (EditText) medidasPessoaActivity.findViewById(R.id.edtPernaD);
        peito = (EditText) medidasPessoaActivity.findViewById(R.id.edtPeito);

        medidasCorporal = new MedidasCorporal();
    }

    public MedidasCorporal getMedidasCorporal() {
        medidasCorporal.setAntebracoD(antebracoD.getText().toString());
        medidasCorporal.setAntebracoE(antebracoE.getText().toString());
        medidasCorporal.setBracoE(bracoE.getText().toString());
        medidasCorporal.setBracoD(bracoD.getText().toString());
        medidasCorporal.setCintura(cintura.getText().toString());
        medidasCorporal.setQuadril(quadril.getText().toString());
        medidasCorporal.setPernaD(pernaD.getText().toString());
        medidasCorporal.setPernaE(pernaE.getText().toString());
        medidasCorporal.setPeito(peito.getText().toString());
        return medidasCorporal;
    }

    public void preencherCampos(MedidasCorporal medidasCorporal) {
        antebracoD.setText(medidasCorporal.getAntebracoD());
        antebracoE.setText(medidasCorporal.getAntebracoE());
        bracoD.setText(medidasCorporal.getBracoD());
        bracoE.setText(medidasCorporal.getBracoE());
        cintura.setText(medidasCorporal.getCintura());
        quadril.setText(medidasCorporal.getQuadril());
        pernaD.setText(medidasCorporal.getPernaD());
        pernaE.setText(medidasCorporal.getPernaE());
        peito.setText(medidasCorporal.getPeito());

        this.medidasCorporal = medidasCorporal;
    }
}
