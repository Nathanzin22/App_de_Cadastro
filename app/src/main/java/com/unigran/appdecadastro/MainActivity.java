package com.unigran.appdecadastro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button botaoProdutos = findViewById(R.id.botaoProdutos);
        Button botaoClientes = findViewById(R.id.botaoClientes);
        Button botaoFornecedores = findViewById(R.id.botaoFornecedores);
        Button botaoSair = findViewById(R.id.botaoSair);

        botaoProdutos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);

                intent.putExtra("segundaTela", 0);

                startActivity(intent);
            }
        });

        botaoClientes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);

                intent.putExtra("segundaTela", 1);

                startActivity(intent);
            }
        });

        botaoFornecedores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);

                intent.putExtra("segundaTela", 2);

                startActivity(intent);
            }
        });

        botaoSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.exit(0);
            }
        });
    }
    
}