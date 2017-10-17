package com.example.cristian.tarea3_recyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements PersonajeAdapter.onPersonajeSelectedListener {
    RecyclerView personajesRecyclerView;
    PersonajeAdapter personajeAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        personajesRecyclerView = (RecyclerView) findViewById(R.id.recycler_main);
        personajesRecyclerView.setHasFixedSize(true);
        //equiposRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        personajesRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        //llenando los datos del adaptador
        personajeAdapter = new PersonajeAdapter(this, this);
        llenarDatos();

        personajesRecyclerView.setAdapter(personajeAdapter);
    }

    private void llenarDatos() {
        List<Personaje> lista = new ArrayList<>();
        lista.add(new Personaje(R.drawable.moises, "Moises", getString(R.string.moises_descripcion)));
        lista.add(new Personaje(R.drawable.josue, "Josue", getString(R.string.josue_descripcion)));
        lista.add(new Personaje(R.drawable.sanson, "Sanson", getString(R.string.sanson_descripcion)));
        lista.add(new Personaje(R.drawable.david, "David", getString(R.string.david_descripcion)));
        personajeAdapter.setDataset(lista);
    }

    @Override
    public void onPersonajeSelected(Personaje personaje) {
        Intent intent = new Intent(getApplicationContext(), DetalleActivity.class);
        intent.putExtra("personaje", personaje);
        startActivity(intent);
    }

}
