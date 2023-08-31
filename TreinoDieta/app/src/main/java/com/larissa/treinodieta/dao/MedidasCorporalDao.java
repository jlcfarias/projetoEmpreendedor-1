package com.larissa.treinodieta.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.larissa.treinodieta.model.MedidasCorporal;

public class MedidasCorporalDao extends SQLiteOpenHelper {

    public MedidasCorporalDao( Context context) {
        super(context, "MedidasCorporal", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String banco = "CREATE TABLE IF NOT EXISTS MedidasCorporal(id INTEGER PRIMARY KEY," +
                " antebracoE TEXT," +
                " antebracoD TEXT," +
                " bracoE TEXT," +
                " bracoD TEXT," +
                " cintura TEXT," +
                " quadril TEXT," +
                " pernaE TEXT," +
                " pernaD TEXT," +
                " peito TEXT);";

        sqLiteDatabase.execSQL(banco);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String banco = "";
        switch (oldVersion){
            case 1:
                banco = "ALTER TABLE MedidasCorporal ADD COLUMN peito TEXT";
                db.execSQL(banco);
        }
    }

    private ContentValues getInfoMedidasCorporal(MedidasCorporal medidasCorporal) {

        ContentValues dados = new ContentValues();

        dados.put("antebracoE", medidasCorporal.getAntebracoE());
        dados.put("antebracoD", medidasCorporal.getAntebracoD());
        dados.put("bracoE", medidasCorporal.getBracoE());
        dados.put("bracoD", medidasCorporal.getBracoD());
        dados.put("cintura", medidasCorporal.getCintura());
        dados.put("quadril", medidasCorporal.getQuadril());
        dados.put("pernaE", medidasCorporal.getPernaE());
        dados.put("pernaD", medidasCorporal.getPernaD());
        dados.put("peito", medidasCorporal.getPeito());

        return dados;
    }

    public void inserirMedidasCorporal(MedidasCorporal medidasCorporal) {
        SQLiteDatabase bancoSQL =  getWritableDatabase();
        ContentValues dados = getInfoMedidasCorporal(medidasCorporal);
        bancoSQL.insert("MedidasCorporal", null, dados);
    }


    public MedidasCorporal burcarMedidasCorporal() {
        String banco = "SELECT * FROM MedidasCorporal WHERE id = (SELECT MAX(id) FROM MedidasCorporal);";
        SQLiteDatabase mSQLiteDatabase = getReadableDatabase();
        Cursor cursor = mSQLiteDatabase.rawQuery(banco, null);

        MedidasCorporal medidas = new MedidasCorporal();

        while (cursor.moveToNext()){

            medidas.setId(cursor.getLong(cursor.getColumnIndexOrThrow("id")));
            medidas.setAntebracoE(cursor.getString(cursor.getColumnIndexOrThrow("antebracoE")));
            medidas.setAntebracoD(cursor.getString(cursor.getColumnIndexOrThrow("antebracoD")));
            medidas.setBracoE(cursor.getString(cursor.getColumnIndexOrThrow("bracoE")));
            medidas.setBracoD(cursor.getString(cursor.getColumnIndexOrThrow("bracoD")));
            medidas.setCintura(cursor.getString(cursor.getColumnIndexOrThrow("cintura")));
            medidas.setQuadril(cursor.getString(cursor.getColumnIndexOrThrow("quadril")));
            medidas.setPernaD(cursor.getString(cursor.getColumnIndexOrThrow("pernaD")));
            medidas.setPernaE(cursor.getString(cursor.getColumnIndexOrThrow("pernaE")));
            medidas.setPeito(cursor.getString(cursor.getColumnIndexOrThrow("peito")));

        }
        cursor.close();

        return medidas;
    }


    public void deletar(MedidasCorporal medidasCorporal) {
        SQLiteDatabase mSQLiteDatabase = getWritableDatabase();
        String [] paramentros = {medidasCorporal.getId().toString()};
        mSQLiteDatabase.delete("MedidasCorporal", "id = ?", paramentros);
    }
}
