package com.uniandes.medicalarm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button registarse_button;
    Button ingresar_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        registarse_button = findViewById(R.id.registrar);
        ingresar_button = findViewById(R.id.ingresar);
        registarse_button.setOnClickListener(
                view -> {
                    Intent intent = new Intent(MainActivity.this, RegistroActivity.class);
                    startActivity(intent);
                }
        );
        ingresar_button.setOnClickListener(
                view -> {
                    Intent intent = new Intent(MainActivity.this, IngresarActivity.class);
                    startActivity(intent);
                }
        );
    }
}