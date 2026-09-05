package com.example.cadastro;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AlertDialog;
import android.content.DialogInterface;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CadastroActivity extends AppCompatActivity {
    EditText ednome, edendereco, edtelefone;
    Button btcadastrar, btcancelar_cadastro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        ednome = (EditText) findViewById(R.id.ednome);
        edtelefone = (EditText) findViewById(R.id.edtelefone);
        edendereco = (EditText) findViewById(R.id.edendereco);
        btcadastrar = (Button) findViewById(R.id.btcadastrar);
        btcancelar_cadastro = (Button) findViewById(R.id.btcancelar_cadastro);

        btcadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialogo = new AlertDialog.Builder(CadastroActivity.this);
                dialogo.setTitle("Aviso");
                dialogo.setMessage("Cadastrar usuário ?");
                dialogo.setNegativeButton("Não", null);
                dialogo.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String nome = ednome.getText().toString();
                        String telefone = edtelefone.getText().toString();
                        String endereco = edendereco.getText().toString();

                        RegistrosManager.getRegistros().add(new Registro(nome, telefone, endereco));

                        new AlertDialog.Builder(CadastroActivity.this)
                                .setTitle("Aviso")
                                .setMessage("Cadastro efetuado com sucesso")
                                .setNeutralButton("OK", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        CadastroActivity.this.finish();
                                    }
                                })
                                .show();
                    }
                });
                dialogo.show();
            }
        });

        btcancelar_cadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CadastroActivity.this.finish();
            }
        });
    }
}