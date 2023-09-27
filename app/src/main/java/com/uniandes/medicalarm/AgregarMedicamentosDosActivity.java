package com.uniandes.medicalarm;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class AgregarMedicamentosDosActivity extends AppCompatActivity {

    ImageButton getback;
    TextView retorno;

    EditText mensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_medicamento_dos);

        getback = findViewById(R.id.imageButton2);
        getback.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(AgregarMedicamentosDosActivity.this, AgregarMedicamentosActivity.class);
                        startActivity(i);
                    }
                }
        );

        retorno = findViewById(R.id.textView12);
        retorno.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i = new Intent(AgregarMedicamentosDosActivity.this, AgregarMedicamentosActivity.class);
                        startActivity(i);
                    }
                }
        );

        mensaje = findViewById(R.id.editTextText2);
        mensaje.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mensaje.setText("");
                    }
                }
        );
    }
}