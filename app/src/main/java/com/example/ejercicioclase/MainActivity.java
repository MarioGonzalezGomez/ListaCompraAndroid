package com.example.ejercicioclase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnClickListenerInterface {
    Tarea task;
    Producto producto;
    List<Producto> products;
    RecyclerView recycler;
    Adaptador adapter;
    //Servirá para decir cómo queremos que aparezcan los elementos en nuestra lista
    LinearLayoutManager llm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recycler = findViewById(R.id.lista);

        //instanciamos y cargamos el lyoutManager
        llm = new LinearLayoutManager(this);
        recycler.setLayoutManager(llm);

        //rellenar la lista. En este caso utilizaremos algún metodo que capte la info que introduce el usuario
        products = new ArrayList<>();

        adapter = new Adaptador(products, this);
        recycler.setAdapter(adapter);
    }

    public void createNuevaTarea(Tarea task) {
        this.task = task;
    }

    @Override
    public void OnClickListenerInterface(int position) {
        Toast.makeText(this, "El producto es " + products.get(position), Toast.LENGTH_SHORT).show();
    }
}