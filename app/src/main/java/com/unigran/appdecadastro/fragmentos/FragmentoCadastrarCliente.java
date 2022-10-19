package com.unigran.appdecadastro.fragmentos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.unigran.appdecadastro.R;
import com.unigran.appdecadastro.db.ClienteDB;
import com.unigran.appdecadastro.db.DBHelper;
import com.unigran.appdecadastro.entidades.Cliente;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentoCadastrarCliente#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentoCadastrarCliente extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FragmentoCadastrarCliente() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentoCadastrarCliente.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentoCadastrarCliente newInstance(String param1, String param2) {
        FragmentoCadastrarCliente fragment = new FragmentoCadastrarCliente();
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmento_cadastrar_cliente, container, false);

        DBHelper db = new DBHelper(getActivity());
        ClienteDB clienteDB = new ClienteDB(db);

        EditText nome = view.findViewById(R.id.clienteNome);
        EditText email = view.findViewById(R.id.clienteEmail);
        EditText telefone = view.findViewById(R.id.clienteTelefone);
        Button btnSalvar = view.findViewById(R.id.clienteSalvar);

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cliente cliente = new Cliente();

                cliente.setNome(nome.getText().toString());
                cliente.setEmail(email.getText().toString());
                cliente.setTelefone(telefone.getText().toString());

                clienteDB.inserir(cliente);

                FragmentoListarCliente.atualizarListaCliente();
                Toast.makeText(getActivity(), "Salvo com sucesso!", Toast.LENGTH_LONG).show();
            }
        });

        return view;
    }
}