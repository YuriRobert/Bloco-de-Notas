package com.yuri.blocodenotas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.dynamicanimation.animation.FlingAnimation;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {


    private AnotacaoPreferencias preferencias;
    private EditText editAnotacao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Instanciando classe e pegando o contexto da mesma
        preferencias = new AnotacaoPreferencias(getApplicationContext());

        FloatingActionButton fbSalvar = findViewById(R.id.fb_Salvar);
        editAnotacao = findViewById(R.id.editAnotacao);

        fbSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Criando variavel para capturar o que foi escrito e transformar para String
                String textoRecuperado = editAnotacao.getText().toString();

                //Validação para saber se os campos estão vazios
                if (textoRecuperado.equals("")) {
                    //utilizado para mostrar essa mensagem de forma rapida caso o usuario tente salvar com os campos vazios
                    Toast.makeText(getApplicationContext(), "Preencha a anotação!", Toast.LENGTH_SHORT).show();
                } else {
                    preferencias.salvarAnotacao(textoRecuperado);
                    Toast.makeText(getApplicationContext(), "Anotação salva com sucesso!", Toast.LENGTH_SHORT).show();
                }


            }

        });
        //Recuperar anotação
        String anotacao = preferencias.recuperarAnotacao();

        //Se a anotação não estiver vazia ela sera exibida ao abrir o aplicativo novamente
        if (!anotacao.equals("")){
            editAnotacao.setText(anotacao);
        }

    }
}