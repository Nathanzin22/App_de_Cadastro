package com.unigran.appdecadastro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.unigran.appdecadastro.fragmentos.FragmentoCadastrarCliente;
import com.unigran.appdecadastro.fragmentos.FragmentoCadastrarFornecedor;
import com.unigran.appdecadastro.fragmentos.FragmentoCadastrarProduto;
import com.unigran.appdecadastro.fragmentos.FragmentoListarCliente;
import com.unigran.appdecadastro.fragmentos.FragmentoListarFornecedor;
import com.unigran.appdecadastro.fragmentos.FragmentoListarProduto;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Integer segundaTelaOpcao = getIntent().getIntExtra("segundaTela", -1);

        if (segundaTelaOpcao != -1) {
            Button btnListagem = findViewById(R.id.botaoListagem);
            Button btnCadastrar = findViewById(R.id.botaoCadastrar);

            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

            switch (segundaTelaOpcao) {
                case 0: {
                    transaction.add(R.id.fragmentoActivity, new FragmentoListarProduto());
                    break;
                }
                case 1: {
                    transaction.add(R.id.fragmentoActivity, new FragmentoListarCliente());
                    break;
                }
                case 2: {
                    transaction.add(R.id.fragmentoActivity, new FragmentoListarFornecedor());
                    break;
                }
            }
            transaction.commit();

            btnListagem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    switch (segundaTelaOpcao) {
                        case 0: {
                            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentoActivity, new FragmentoListarProduto()).commit();
                            break;
                        }
                        case 1: {
                            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentoActivity, new FragmentoListarCliente()).commit();
                            break;
                        }
                        case 2: {
                            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentoActivity, new FragmentoListarFornecedor()).commit();
                            break;
                        }
                    }
                }
            });

            btnCadastrar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    switch (segundaTelaOpcao) {
                        case 0: {
                            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentoActivity, new FragmentoCadastrarProduto()).commit();
                            break;
                        }
                        case 1: {
                            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentoActivity, new FragmentoCadastrarCliente()).commit();
                            break;
                        }
                        case 2: {
                            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentoActivity, new FragmentoCadastrarFornecedor()).commit();
                            break;
                        }
                    }
                }
            });
        }
    }
}