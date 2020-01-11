package com.example.teste;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.teste.adapter.NomesAdapter;
import com.example.teste.model.Nomes;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView listView;

    List<Nomes> lista;

    private NomesAdapter adapterNomes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inicializar();
    }

    public void inicializar() {

        listView = findViewById(R.id.listView);

        lista = new ArrayList<>();
        listView.setLayoutManager(new LinearLayoutManager(this));

        lista();
        adapterNomes = new NomesAdapter(this, lista);

        listView.setAdapter(adapterNomes);
    }

    public void lista() {
        lista.add(new Nomes("Paulo"));
        lista.add(new Nomes("Maria"));
        lista.add(new Nomes("José"));
        lista.add(new Nomes("Marcos"));
        lista.add(new Nomes("Daniel"));
        lista.add(new Nomes("Anna"));
        lista.add(new Nomes("Claudio"));
        lista.add(new Nomes("Luciana"));
        lista.add(new Nomes("Renato"));
    }
}
