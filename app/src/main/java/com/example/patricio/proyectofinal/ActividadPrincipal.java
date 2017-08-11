package com.example.patricio.proyectofinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ActividadPrincipal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad_principal);
    }
    public void menu (View vista){

        EditText Usuario, Password;
        Usuario = (EditText) findViewById(R.id.usuario);
        Password = (EditText) findViewById(R.id.password);
        String user = Usuario.getText().toString();
        String pass = Password.getText().toString();

        if (user.equals("admin") && pass.equals("admin123")){
            Intent i = new Intent(this, menuActivity.class);
            startActivity(i);
        } else {
            Toast.makeText(this, "Datos invalidos", Toast.LENGTH_LONG).show();
        }
    }
}
