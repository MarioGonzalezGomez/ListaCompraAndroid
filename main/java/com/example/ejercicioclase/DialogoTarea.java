package com.example.ejercicioclase;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

public class DialogoTarea extends DialogFragment {


    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View dialog = inflater.inflate(R.layout.tarea_layout, null);

        EditText titulo = dialog.findViewById(R.id.title);
        EditText desc = dialog.findViewById(R.id.description);

        CheckBox cb1 = dialog.findViewById(R.id.checkBox);
        CheckBox cb2 = dialog.findViewById(R.id.checkBox2);
        CheckBox cb3 = dialog.findViewById(R.id.checkBox3);

        Button ok = dialog.findViewById(R.id.ok);
        Button cancel = dialog.findViewById(R.id.cancelar);

        builder.setView(dialog).setMessage("Añadir una nueva nota");
        ok.setOnClickListener(view -> dismiss());
        cancel.setOnClickListener(view -> {
            Tarea task = new Tarea();
            task.setTitulo(titulo.getText().toString());
            task.setDescripcion(desc.getText().toString());
            task.setIdea(cb1.isChecked());
            task.setTarea(cb2.isChecked());
            task.setImportante(cb3.isChecked());

            MainActivity llamarMA = (MainActivity) getActivity();
            llamarMA.createNuevaTarea(task);
            dismiss();
        });
        return builder.create();
    }
}
