package com.example.cadastro;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;

public class MainActivity extends Activity {
    Button btcadastrarusuario;
    Button btlistagemusuarios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btcadastrarusuario = findViewById(R.id.btcadastrar_usuario);
        btlistagemusuarios = findViewById(R.id.bt_listar_usuarios_cadastrados);

        btcadastrarusuario.setOnClickListener(view -> {
            Intent intentTelaCadastro = new Intent(MainActivity.this, CadastroActivity.class);
            startActivity(intentTelaCadastro);
        });

        btlistagemusuarios.setOnClickListener(view -> {
            if(RegistrosManager.getRegistros().size() == 0){
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Aviso")
                        .setMessage("Não existe nenhum registro cadastrado.")
                        .setNeutralButton("OK", null)
                        .show();
                return;
            }
            Intent intentTelaListagem = new Intent(MainActivity.this, ListagemActivity.class);
            startActivity(intentTelaListagem);
        });
    }
}