package com.unigran.appdecadastro.db;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.unigran.appdecadastro.entidades.Fornecedor;

import java.util.List;

public class FornecedorDB {

    private DBHelper db;
    private SQLiteDatabase conexao;

    public FornecedorDB(DBHelper db) {
        this.db = db;
    }

    public void inserir(Fornecedor fornecedor) {
        conexao = db.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put("nomeFantasia", fornecedor.getNomeFantasia());
        valores.put("telefone", fornecedor.getTelefone());
        valores.put("email", fornecedor.getEmail());

        conexao.insertOrThrow("fornecedores", null, valores);
    }

    public void remover(Integer id) {
        conexao = db.getWritableDatabase();

        conexao.delete("fornecedores", "id=?", new String[]{id + ""});

        conexao.close();
    }

    public void listar(List<Fornecedor> listaFornecedores) {
        listaFornecedores.clear();
        conexao = db.getReadableDatabase();

        String colunas[] = {"id", "nomeFantasia", "telefone", "email"};
        Cursor query = conexao.query("fornecedores", colunas, null, null, null, null, "nomeFantasia");

        while (query.moveToNext()) {
            Fornecedor fornecedor = new Fornecedor();

            fornecedor.setId(query.getInt(0));
            fornecedor.setNomeFantasia(query.getString(1));
            fornecedor.setTelefone(query.getString(2));
            fornecedor.setEmail(query.getString(3));

            listaFornecedores.add(fornecedor);
        }

        conexao.close();
    }

}
