package com.example.cristian.tarea3_recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Cristian on 16/10/2017.
 */

public class PersonajeAdapter extends RecyclerView.Adapter<PersonajeAdapter.PersonajeViewHolder>{

    //se agregaron estas variables
    List<Personaje> dataset;
    Context context;
    onPersonajeSelectedListener onPersonajeSelectedListener;
    //se agrego esta funcion
    public interface onPersonajeSelectedListener{
        void onPersonajeSelected(Personaje personaje);
    }
    //se agrego esta funcion
    public PersonajeAdapter(Context context, onPersonajeSelectedListener onPersonajeSelectedListener) {
        this.context = context;
        this.dataset = new ArrayList<>();
        this.onPersonajeSelectedListener = onPersonajeSelectedListener;
    }


    @Override
    public PersonajeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_personaje,parent,false);
        return new PersonajeViewHolder(view);
        //return null;
    }

    @Override
    public void onBindViewHolder(PersonajeViewHolder holder, int position) {
        Personaje personaje = dataset.get(position);

        holder.nombre.setText(personaje.getNombre());
        holder.imagen.setImageResource(personaje.getImagen());
        holder.setOnPersonajeSelectedListener(personaje, onPersonajeSelectedListener);
    }

    @Override
    public int getItemCount() {
        //return 0;
        return dataset.size();
    }

    public class PersonajeViewHolder extends RecyclerView.ViewHolder {

        View cardView;
        ImageView imagen;
        TextView nombre;

        public PersonajeViewHolder(View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.card_main);
            imagen = itemView.findViewById(R.id.imagen_item);
            nombre = itemView.findViewById(R.id.texto_item);
        }

        public void setOnPersonajeSelectedListener(final Personaje personaje, final onPersonajeSelectedListener onPersonajeSelectedListener) {
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    onPersonajeSelectedListener.onPersonajeSelected(personaje);
                }
            });
        }

    }

    public void setDataset(List<Personaje> personajes) {
        if (personajes == null){
            dataset = new ArrayList<>();
        }
        else{
            dataset = personajes;
        }
        notifyDataSetChanged();
    }

}
