package dev.android.monique.franca.app.lista.app_anotacoes.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AnotacoesData extends SQLiteOpenHelper {

    private static final String DB_NAME = "anotacoes.db";
    private static final int DB_VERSION =1;

    Cursor cursor;
    SQLiteDatabase db;


    public AnotacoesData(Context context) {
        super(context,DB_NAME,null,DB_VERSION);

        db=getWritableDatabase();

    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String sqlTabelaAnotacoes
                = "CREATE TABLE Anotacoes (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "titulo TEXT," +
                "conteudo TEXT, " +
                "lembrete TEXT)";

        db.execSQL(sqlTabelaAnotacoes);



    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void salvarDados(String tabela, ContentValues dados){
        db.insert(tabela,null,dados);

    }

    //TODO: criar métodos para implementar um Crud
}
