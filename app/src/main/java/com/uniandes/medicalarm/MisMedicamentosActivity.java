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

public class MisMedicamentosActivity extends AppCompatActivity {

    ImageButton agregar;
    ImageButton itemUno;
    ImageButton itemDos;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mis_medicamentos);

        agregar = findViewById(R.id.imageButton6);
        agregar.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(MisMedicamentosActivity.this, AgregarMedicamentosActivity.class);
                        startActivity(i);
                    }
                }
        );

        itemUno = findViewById(R.id.imageButton9);
        itemUno.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(MisMedicamentosActivity.this, AgregarMedicamentosActivity.class);
                        i.putExtra("NAME", "Levotiroxina");
                        i.putExtra("SELECTION", "0");
                        startActivity(i);
                    }
                }
        );

        itemDos = findViewById(R.id.imageButton14);
        itemDos.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(MisMedicamentosActivity.this, AgregarMedicamentosActivity.class);
                        i.putExtra("NAME", "Acetaminofén");
                        i.putExtra("SELECTION", "1");
                        startActivity(i);
                    }
                }
        );

    }
}