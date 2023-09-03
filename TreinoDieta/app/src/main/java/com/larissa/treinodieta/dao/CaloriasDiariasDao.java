package com.larissa.treinodieta.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.larissa.treinodieta.models.CaloriasDiarias;

public class CaloriasDiariasDao extends SQLiteOpenHelper {

    public CaloriasDiariasDao(Context context) {
        super(context, "CaloriasDiarias", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String tabela = "CREATE TABLE IF NOT EXISTS CaloriasDiarias (" +
                "id INTEGER PRIMARY KEY," +
                "data TEXT," +
                "caloriasDisponiveis REAL);";
        sqLiteDatabase.execSQL(tabela);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) { }

    public CaloriasDiarias buscarCaloriasDiarias(String dataAtual) {
        SQLiteDatabase mSQLiteDatabase = getReadableDatabase();
        Cursor cursor = mSQLiteDatabase.query("CaloriasDiarias",
                new String[]{"id", "data", "caloriasDisponiveis"},
                "data = ?",
                new String[]{dataAtual},
                null, null, null);

        CaloriasDiarias caloriasDiarias = null;

        if (cursor.moveToFirst()) {
            caloriasDiarias = new CaloriasDiarias();
            caloriasDiarias.setId(cursor.getLong(cursor.getColumnIndexOrThrow("id")));
            caloriasDiarias.setData(cursor.getString(cursor.getColumnIndexOrThrow("data")));
            caloriasDiarias.setCaloriasDisponiveis(cursor.getFloat(cursor.getColumnIndexOrThrow("caloriasDisponiveis")));
        }

        cursor.close();

        return caloriasDiarias;
    }

    public void inserirCaloriasDiarias(CaloriasDiarias caloriasDiarias) {
        SQLiteDatabase mSQLiteDatabase = getWritableDatabase();

        ContentValues dados = this.getDadosCaloriasDiarias(caloriasDiarias);

        mSQLiteDatabase.insert("CaloriasDiarias", null, dados);
        mSQLiteDatabase.close();
    }

    public void atualizarCaloriasDiarias(CaloriasDiarias caloriasDiarias) {
        SQLiteDatabase mSQLiteDatabase = getWritableDatabase();

        ContentValues dados = this.getDadosCaloriasDiarias(caloriasDiarias);

        mSQLiteDatabase.update("CaloriasDiarias", dados, "data = ?",  new String[]{String.valueOf(caloriasDiarias.getData())});
        mSQLiteDatabase.close();
    }

    private ContentValues getDadosCaloriasDiarias(CaloriasDiarias caloriasDiarias) {
        ContentValues dados = new ContentValues();

        dados.put("data", caloriasDiarias.getData());
        dados.put("caloriasDisponiveis", caloriasDiarias.getCaloriasDisponiveis());

        return dados;
    }
}