package com.uniandes.medicalarm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IngresarActivity extends AppCompatActivity {

    Button ingresarButton;
    EditText emailEditText;
    EditText contrasenaEditText;
    ImageView atrasImageView;

    LinearLayout crearCuentaLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresar);

        atrasImageView = findViewById(R.id.back_login);
        crearCuentaLayout = findViewById(R.id.crear_cuenta_layout);

        ingresarButton = findViewById(R.id.ingresar_login);
        emailEditText = findViewById(R.id.email_ingreso_input);
        contrasenaEditText = findViewById(R.id.contrasena_ingreso_input);

        ingresarButton.setOnClickListener(
                view -> {
                    if (isValidForm()){
                        //TODO Cambiar direccionamiento a pantalla principal de medicamentos
                        Intent intent = new Intent(IngresarActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                }
        );
        atrasImageView.setOnClickListener(
                view -> {
                    Intent intent = new Intent(IngresarActivity.this, MainActivity.class);
                    startActivity(intent);
                }
        );
        crearCuentaLayout.setOnClickListener(
                view -> {
                    Intent intent = new Intent(IngresarActivity.this, RegistroActivity.class);
                    startActivity(intent);
                }
        );
    }

    public boolean isEmptyTextData(EditText textField){
        return TextUtils.isEmpty(textField.getText());
    }

    public boolean isValidForm(){
        boolean formValid = true;
        //Validations
        if(isEmptyTextData(emailEditText)) {
            formValid = false;
            emailEditText.setError("El correo electrónico es requerido");
        }else{
            String regex = "^(.+)@(.+)$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(emailEditText.getText().toString());
            if(!matcher.matches()){
                formValid = false;
                emailEditText.setError("El formato del correo no es válido");
            }
        }
        if(isEmptyTextData(contrasenaEditText)) {
            formValid = false;
            contrasenaEditText.setError("La contraseña es requerida");
        }
        return formValid;
    }
}