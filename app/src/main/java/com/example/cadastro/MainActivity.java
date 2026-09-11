package com.example.cadastro;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    CheckBox chkarroz, chkleite, chkcarne, chkfeijao;
    Button bttotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chkarroz = findViewById(R.id.chkarroz);
        chkleite = findViewById(R.id.chkleite);
        chkcarne = findViewById(R.id.chkcarne);
        chkfeijao = findViewById(R.id.chkfeijao);
        bttotal = findViewById(R.id.bttotal);

        bttotal.setOnClickListener(view -> {
            double total = 0;
            StringBuilder resumo = new StringBuilder("Resumo da Compra:\n\n");

            if (chkarroz.isChecked()) {
                total += 2.69;
                resumo.append("- Arroz: R$ 2,69\n");
            }
            if (chkleite.isChecked()) {
                total += 5.00;
                resumo.append("- Leite: R$ 5,00\n");
            }
            if (chkcarne.isChecked()) {
                total += 10.90;
                resumo.append("- Carne: R$ 10,90\n");
            }
            if (chkfeijao.isChecked()) {
                total += 2.30;
                resumo.append("- Feijão: R$ 2,30\n");
            }

            resumo.append(String.format("\nTotal da compra: R$ %.2f", total));

            if (total == 0) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("Aviso")
                        .setMessage("Selecione pelo menos um item para comprar.")
                        .setPositiveButton("OK", null)
                        .show();
                return;
            }

            // Exibe o resumo
            new AlertDialog.Builder(MainActivity.this)
                    .setTitle("Resumo")
                    .setMessage(resumo.toString())
                    .setPositiveButton("OK", (dialog, which) -> {
                        // Ao clicar em OK, exibe a escolha de pagamento
                        mostrarOpcoesPagamento();
                    })
                    .show();
        });
    }

    private void mostrarOpcoesPagamento() {
        String[] opcoes = {"PIX", "Cartão de Crédito", "Cartão de Débito", "Dinheiro"};

        new AlertDialog.Builder(MainActivity.this)
                .setTitle(R.string.forma_pagamento)
                .setItems(opcoes, (dialog, which) -> {
                    String formaEscolhida = opcoes[which];
                    String mensagem = getString(R.string.pagamento_sucesso, formaEscolhida);
                    
                    new AlertDialog.Builder(MainActivity.this)
                            .setTitle("Sucesso")
                            .setMessage(mensagem)
                            .setPositiveButton("OK", null)
                            .show();
                })
                .show();
    }
}