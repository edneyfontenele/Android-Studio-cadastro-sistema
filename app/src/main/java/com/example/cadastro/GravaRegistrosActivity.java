package com.example.cadastro;

import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Button;
import android.widget.EditText;

public class GravaRegistrosActivity extends AppCompatActivity {

    Button btcadastrar;
    EditText ednome, edtelefone, edemail;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grava_registros);

        btcadastrar = findViewById(R.id.btcadastrar);
        ednome = findViewById(R.id.ednome);
        edtelefone = findViewById(R.id.edtelefone);
        edemail = findViewById(R.id.edemail);

        try {
            db = openOrCreateDatabase("banco_dados", Context.MODE_PRIVATE, null);
        } catch (Exception e) {
            MostraMensagem("Erro : " + e.toString());
        }

        btcadastrar.setOnClickListener(arg0 -> {
            String nome = ednome.getText().toString();
            String telefone = edtelefone.getText().toString();
            String email = edemail.getText().toString();

            try {
                db.execSQL("insert into usuarios(nome, telefone, email) values('" +
                        nome + "','" + telefone + "','" + email + "');");
                MostraMensagem("Dados cadastrados com sucesso");
            } catch (Exception e) {
                MostraMensagem("Erro : " + e.toString());
            }
        });
    }

    public void MostraMensagem(String str) {
        new AlertDialog.Builder(GravaRegistrosActivity.this)
                .setTitle("Aviso")
                .setMessage(str)
                .setNeutralButton("OK", null)
                .show();
    }
}