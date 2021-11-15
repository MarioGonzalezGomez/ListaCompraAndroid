package com.example.ejercicioclase;
import androidx.fragment.app.DialogFragment;

public class Tarea extends DialogFragment {
    private String titulo;
    private String descripcion;

    private boolean idea;
    private boolean tarea;
    private boolean importante;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isIdea() {
        return idea;
    }

    public void setIdea(boolean idea) {
        this.idea = idea;
    }

    public boolean isTarea() {
        return tarea;
    }

    public void setTarea(boolean tarea) {
        this.tarea = tarea;
    }

    public boolean isImportante() {
        return importante;
    }

    public void setImportante(boolean importante) {
        this.importante = importante;
    }
}
