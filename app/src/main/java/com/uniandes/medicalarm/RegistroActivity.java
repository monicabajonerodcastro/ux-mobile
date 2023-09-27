package com.uniandes.medicalarm;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.text.TextUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistroActivity extends AppCompatActivity {

    ImageView atrasImageView;
    Button registrarseButton;

    // Fields to validate

    Spinner spinner;
    EditText nombreEditText;
    EditText edadEditText;
    EditText emailEditText;
    EditText contrasenaEditText;
    EditText contrasenaConfEditText;
    CheckBox tycChecbox;
    CheckBox politicaDatosCheckbox;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        spinner = (Spinner) findViewById(R.id.genero_spinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.genero_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);

        atrasImageView = findViewById(R.id.back_register);
        registrarseButton = findViewById(R.id.registrar);

        nombreEditText = findViewById(R.id.nombre_input);
        edadEditText = findViewById(R.id.edad_input);
        emailEditText = findViewById(R.id.email_input);
        contrasenaEditText = findViewById(R.id.contrasena_input);
        contrasenaConfEditText = findViewById(R.id.contrasena_confirmacion_input);
        tycChecbox = findViewById(R.id.terminos_condiciones_check_box);
        politicaDatosCheckbox = findViewById(R.id.politica_datos_check_box);

        tycChecbox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if ( isChecked ) {
                tycChecbox.setError(null);
            } else {
                tycChecbox.setError("Se debe aceptar los términos y condiciones");
            }
        });
        politicaDatosCheckbox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if ( isChecked ) {
                politicaDatosCheckbox.setError(null);
            } else {
                politicaDatosCheckbox.setError("Se debe aceptar la política de tratamiento de datos personales");
            }
        });

        atrasImageView.setOnClickListener(
                view -> {
                    Intent intent = new Intent(RegistroActivity.this, MainActivity.class);
                    startActivity(intent);
                }
        );
        registrarseButton.setOnClickListener(
                view -> {
                    if (isValidForm()){
                        Intent intent = new Intent(RegistroActivity.this, MainActivity.class);
                        startActivity(intent);
                    }
                }
        );

    }

    public boolean isEmptyTextData(EditText textField){
        return TextUtils.isEmpty(textField.getText());
    }

    public boolean isValidForm(){
        boolean formValid = true;
        //Validations
        if(isEmptyTextData(nombreEditText)) {
            formValid = false;
            nombreEditText.setError("El nombre es requerido");
        }
        if(isEmptyTextData(edadEditText)) {
            formValid = false;
            edadEditText.setError("La edad es requerida");
        }
        if(isEmptyTextData(emailEditText)) {
            formValid = false;
            emailEditText.setError("El correo es requerido");
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
        if(isEmptyTextData(contrasenaConfEditText)) {
            formValid = false;
            contrasenaConfEditText.setError("La confirmación de la contraseña es requerida");
        }
        if(!isEmptyTextData(contrasenaEditText) && !isEmptyTextData(contrasenaConfEditText)
        && !(contrasenaEditText.getText().toString().equals(contrasenaConfEditText.getText().toString()))) {
            formValid = false;
            contrasenaConfEditText.setError("La contraseña y la confirmación de la contraseña deben ser iguales");
        }
        if(!tycChecbox.isChecked()){
            formValid = false;
            tycChecbox.setError("Se debe aceptar los términos y condiciones");
        }
        if(!politicaDatosCheckbox.isChecked()){
            formValid = false;
            politicaDatosCheckbox.setError("Se debe aceptar la política de tratamiento de datos personales");
        }
        return formValid;
    }




}