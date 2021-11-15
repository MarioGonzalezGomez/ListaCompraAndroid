package com.example.ejercicioclase;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Adaptador extends RecyclerView.Adapter<Adaptador.ViewHolder> {
    private List<Producto> productos;
    private OnClickListenerInterface listaOnClick;

    public Adaptador(List<Producto> productos, OnClickListenerInterface listaOnClick) {
        this.productos = productos;
        this.listaOnClick = listaOnClick;
    }

    @NonNull
    @Override
    public Adaptador.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(
                (parent.getContext())).inflate(R.layout.productos, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Adaptador.ViewHolder holder, int position) {
        //hay que poner esto para cada uno de los campos
        //aquí estarán todos los elementos de la lista
        holder.tw.setText(productos.get(position).getNombre());
    }

    @Override
    public int getItemCount() {
        return productos.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView tw;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tw = itemView.findViewById(R.id.textView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            listaOnClick.OnClickListenerInterface(position);
        }
    }
}
