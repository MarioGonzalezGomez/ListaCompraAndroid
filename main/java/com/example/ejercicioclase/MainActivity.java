package com.example.ejercicioclase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ClipData;
import android.content.Intent;
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

    //para guardar los datos crearemos un fichero
    //SharedPreferences preferences;
    //Instanciar. 1 parametro/ nombre fichero 2 parametro/ forma de acceso
    //preferences= getSharedPreferences("nombre del fichero", MODE_PRIVATE)

    //Para la versión de escritura
    //SharedPreferences.Editor editor = preferences.edit();

    //Almacenar los datos qu etenemos en variables en el disco
    //editor.putString("clave", variable)"
    //también tenemos putInt, putBoolean...

    //commit guarda toda la info en el disco de la que se ha hecho put
    //editor.commit()

    //Para leerlo hacemos el camino inverso
    //String nombre = preferences.getStringg("clave", "Si mo tiene valor, me pones este segundo");
    //Podemos usar esos valores opcionales y comprobarlos con if para saber si se ha cargado o no el
    //dato que se quería inicialmente

    //Para ir de una actividad a otra
    //A esto lo llamaremos cuando pulsemos los 3 puntos de el menu
    //ClipData.Item intem = new ClipData.Item(findViewById(R.id.ajustes));
    //Intent intent = new Intent(this, Main2Activity.class);

    //Para ejecutar el intent:
    //startActivity(intent)

    //Podemos pasar datos a la segunda actividad, solo variables simples:
    //intent.putExtra("clave" [Que puede ser la que quedamos, ej. User_Name] , variable);

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