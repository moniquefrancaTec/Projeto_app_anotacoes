package dev.android.monique.franca.app.lista.app_anotacoes.Controller;

import android.content.ContentValues;
import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;

import dev.android.monique.franca.app.lista.app_anotacoes.DataBase.AnotacoesData;
import dev.android.monique.franca.app.lista.app_anotacoes.Model.Anotacoes;
import dev.android.monique.franca.app.lista.app_anotacoes.View.MainActivity;

public class AnotacaoController extends AnotacoesData {

    SharedPreferences preferences;
    SharedPreferences.Editor listaVip;

    public static final String NOME_PREFERENCES = "pref_listavip";

    public AnotacaoController(MainActivity activity) {
        super(activity);

        preferences = activity.getSharedPreferences(NOME_PREFERENCES, 0);
        listaVip = preferences.edit();

    }

    @NonNull
    @Override
    public String toString() {
        Log.d("MVC_Controller", "Controller iniciada....");
        return super.toString();
    }


    public void salvar(Anotacoes anotacoes) {
        Log.d("MVC_Controller", "Salvo: " + anotacoes.toString());

        ContentValues dados = new ContentValues();
        dados.put("titulo", anotacoes.getTitulo());
        dados.put("conteudo", anotacoes.getConteudo());
        dados.put("lembrete", anotacoes.getLembrete());
        salvarDados("Anotacoes", dados);

    }


    public void limpar(Anotacoes anotacoes) {
        ContentValues dados = new ContentValues();
        dados.remove(anotacoes.getTitulo());
        dados.remove(anotacoes.getConteudo());
        dados.remove(anotacoes.getLembrete());

        salvarDados("Anotacoes", dados);

    }
}

