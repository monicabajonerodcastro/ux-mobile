package com.uniandes.medicalarm;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;

public class AgregarMedicamentosActivity extends AppCompatActivity {

    ImageButton getback;
    Button continuar;



    EditText nameText;
    Spinner comboFrecuenia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_medicamento);
        String name = getIntent().getStringExtra("NAME");
        String selector = getIntent().getStringExtra("SELECTION");

        nameText= findViewById(R.id.editTextText);
        if(name!=null){
            nameText.setText(name);
        }
        comboFrecuenia= findViewById(R.id.spinner2);
        if(selector!=null){
            comboFrecuenia.setSelection(Integer.parseInt(selector));
        }

        getback = findViewById(R.id.imageButton);
        getback.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(AgregarMedicamentosActivity.this, MisMedicamentosActivity.class);
                        startActivity(i);
                    }
                }
        );

        continuar = findViewById(R.id.ingresar2);
        continuar.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(AgregarMedicamentosActivity.this, AgregarMedicamentosDosActivity.class);
                        startActivity(i);
                    }
                }
        );
    }
}