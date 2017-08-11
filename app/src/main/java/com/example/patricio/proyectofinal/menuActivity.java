package com.example.patricio.proyectofinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class menuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void GoUsuarios (View vista){
        Intent i = new Intent(this, recyclientes.class);
        startActivity(i);
    }
    public void GoProductos (View vista){
        Intent i = new Intent(this, recyproductos.class);
        startActivity(i);
    }
}
