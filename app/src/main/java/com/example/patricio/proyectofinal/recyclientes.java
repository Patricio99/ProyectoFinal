package com.example.patricio.proyectofinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class recyclientes extends AppCompatActivity {

    private final String baseUrl = "https://proyectopaton.000webhostapp.com/";
    List<Cliente> listaClientes = new ArrayList<>();
    RecyclerView rvClientes;
    ClienteAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclientes);

        Retrofit retrofit = new Retrofit.Builder().baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();



        iniciarControles();

        LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
        rvClientes.setLayoutManager(llm);

        adapter = new ClienteAdapter(listaClientes);
        rvClientes.setAdapter(adapter);

        DividerItemDecoration itemDecoration = new DividerItemDecoration(rvClientes.getContext(),llm.getOrientation());
        rvClientes.addItemDecoration(itemDecoration);



        ClienteService clienteService = retrofit.create(ClienteService.class);

        Call<List<Cliente>> lista = clienteService.getClientes();
        lista.enqueue(new Callback<List<Cliente>>() {
            @Override
            public void onResponse(Call<List<Cliente>> call, Response<List<Cliente>> response) {
                if(response.isSuccessful()) {
                    listaClientes = response.body();

                    adapter = new ClienteAdapter(listaClientes);
                    rvClientes.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<Cliente>> call, Throwable throwable) {

            }
        });
    }

    private void iniciarControles(){
        rvClientes = (RecyclerView) findViewById(R.id.rvClientes);
    }


    public void GoMenu(View vista){
        Intent i = new Intent(this, menuActivity.class );
        startActivity(i);

    }
    
}
