package com.unigran.appdecadastro.fragmentos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.unigran.appdecadastro.R;
import com.unigran.appdecadastro.db.DBHelper;
import com.unigran.appdecadastro.db.ProdutoDB;
import com.unigran.appdecadastro.entidades.Produto;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentoListarProduto#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentoListarProduto extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentoListarProduto() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentoListarProduto.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentoListarProduto newInstance(String param1, String param2) {
        FragmentoListarProduto fragment = new FragmentoListarProduto();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    ListView listaDados;
    static List<Produto> listaProdutos;
    static ArrayAdapter adapter;
    static ProdutoDB produtoDB;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmento_listar_produto, container, false);

        listaDados = view.findViewById(R.id.listProduto);

        DBHelper db = new DBHelper(getActivity());
        produtoDB = new ProdutoDB(db);

        listaProdutos = new ArrayList<>();
        adapter = new ArrayAdapter(getActivity(), androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, listaProdutos);
        listaDados.setAdapter(adapter);

        atualizarListaProduto();

        return view;
    }

    protected static void atualizarListaProduto() {
        produtoDB.listar(listaProdutos);
        adapter.notifyDataSetChanged();
    }
}