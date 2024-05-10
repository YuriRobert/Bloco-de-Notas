package com.yuri.blocodenotas;

import android.content.Context;
import android.content.SharedPreferences;

public class AnotacaoPreferencias {

    private Context context;
    //Objeto para salvar
    private SharedPreferences preferences;
    //Responsável por salvar uma anotação
    private SharedPreferences.Editor editor;


    private final String NOME_ARQUIVO = "anotacao.preferencias";
    private final String CHAVE_NOME = "nome";

    //Construtor
    public AnotacaoPreferencias(Context c) {
        //Pegando o contexto do construtor
        this.context = c;

        //Método getSharedPreferences precisa de dois parâmetros, uma String e um número inteiro
        preferences = context.getSharedPreferences(NOME_ARQUIVO, 0);
        editor = preferences.edit();
    }

    //Método para salvar anotação
    public void salvarAnotacao(String anotacao) {
        editor.putString(CHAVE_NOME, anotacao);
        editor.commit();
    }

    //método para recuperar anotação
    //Irá retornar uma String
    public String recuperarAnotacao() {
        return preferences.getString(CHAVE_NOME, "");
    }


}
