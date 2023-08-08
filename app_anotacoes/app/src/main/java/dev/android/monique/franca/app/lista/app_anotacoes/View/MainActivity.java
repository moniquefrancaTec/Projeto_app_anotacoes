package dev.android.monique.franca.app.lista.app_anotacoes.View;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import dev.android.monique.franca.app.lista.app_anotacoes.Controller.AnotacaoController;
import dev.android.monique.franca.app.lista.app_anotacoes.Model.Anotacoes;
import dev.android.monique.franca.app.lista.app_anotacoes.R;

public class MainActivity extends AppCompatActivity {

    AnotacaoController controllerAnotacao;
    Anotacoes anotacoes;


    EditText edittitulo;
    EditText editconteudo;
    TextView editlembrete;

    Button btnbuton_limpar;
    Button btnbuton_salvar;



     @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        controllerAnotacao = new AnotacaoController(MainActivity.this);
        controllerAnotacao.toString();

        anotacoes = new Anotacoes();

        edittitulo = findViewById(R.id.editTextTextPersonName);
        editconteudo = findViewById(R.id.editTextTextPersonName2);
        editlembrete =findViewById(R.id.editTextTextPersonName3);


        btnbuton_limpar = findViewById(R.id.button2);
        btnbuton_salvar = findViewById(R.id.button3);



        btnbuton_salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                boolean dadosOk = true;

                if(TextUtils.isEmpty(edittitulo.getText())){
                    edittitulo.setError("Obrigatório");
                    edittitulo.requestFocus();
                    dadosOk = false;
                }
                if(TextUtils.isEmpty(editconteudo.getText())){
                    editconteudo.setError("Obrigatório");
                    editconteudo.requestFocus();
                    dadosOk = false;
                }
                if(TextUtils.isEmpty(editlembrete.getText())){
                    editlembrete.setError("Obrigatório");
                    editlembrete.requestFocus();
                    dadosOk = false;
                }

                if(dadosOk){
                    anotacoes.setTitulo(String.valueOf(edittitulo.getText()));
                    anotacoes.setConteudo(String.valueOf(editconteudo.getText()));
                    anotacoes.setLembrete(String.valueOf(editlembrete.getText()));


                    Toast.makeText(MainActivity.this, "Dados salvos com sucesso ", Toast.LENGTH_LONG).show();

                    controllerAnotacao.salvar(anotacoes);



                }else{
                    Toast.makeText(MainActivity.this, "Digite os dados!", Toast.LENGTH_LONG).show();
                }



            }
        });


        btnbuton_limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edittitulo.setText("");
                editconteudo.setText("");
                editlembrete.setText("");

                controllerAnotacao.limpar(anotacoes);




            }
        });

    }
}