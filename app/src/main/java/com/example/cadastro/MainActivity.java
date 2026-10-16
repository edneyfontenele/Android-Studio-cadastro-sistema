package com.example.cadastro;

import android.os.Bundle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Button;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {
    Button btcriarbanco;
    Button btcadastrardados;
    SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btcriarbanco = findViewById(R.id.btcriarbanco);
        btcadastrardados = findViewById(R.id.btcadastrardados);

        btcadastrardados.setOnClickListener(args0 -> {
            Intent gravaRegistroActivity = new Intent(MainActivity.this, GravaRegistrosActivity.class);
            startActivity(gravaRegistroActivity);
        });

        btcriarbanco.setOnClickListener(view -> {
            try {
                db = openOrCreateDatabase("banco_dados", Context.MODE_PRIVATE, null);
                db.execSQL("create table if not exists usuarios(numreg integer primary key autoincrement, nome text not null, telefone text not null, email text not null);");

                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Aviso")
                        .setMessage("Banco de dados criado com sucesso!")
                        .setNeutralButton("OK", null)
                        .show();
            } catch (Exception e) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Erro")
                        .setMessage("Erro ao criar banco: " + e.getMessage())
                        .setNeutralButton("OK", null)
                        .show();
            }
        });
    }
}