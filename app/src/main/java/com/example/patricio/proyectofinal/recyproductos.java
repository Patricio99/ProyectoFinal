package com.example.patricio.proyectofinal;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class recyproductos extends AppCompatActivity {

    private final String baseUrl = "https://proyectopaton.000webhostapp.com/";
    List<Productos> listaProductos = new ArrayList<>();
    RecyclerView rvProductos;
    ProductosAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyproductos);

        Retrofit retrofit = new Retrofit.Builder().baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        iniciarControles();

        LinearLayoutManager llm = new LinearLayoutManager(getApplicationContext());
        rvProductos.setLayoutManager(llm);

        adapter = new ProductosAdapter(listaProductos);
        rvProductos.setAdapter(adapter);

        DividerItemDecoration itemDecoration = new DividerItemDecoration(rvProductos.getContext(),llm.getOrientation());
        rvProductos.addItemDecoration(itemDecoration);



        ProductosService productosService = retrofit.create(ProductosService.class);

        Call<List<Productos>> lista = productosService.getProductos();
        lista.enqueue(new Callback<List<Productos>>() {
            @Override
            public void onResponse(Call<List<Productos>> call, Response<List<Productos>> response) {
                if(response.isSuccessful()) {
                    listaProductos = response.body();

                    adapter = new ProductosAdapter(listaProductos);
                    rvProductos.setAdapter(adapter);
                }
            }

            @Override
            public void onFailure(Call<List<Productos>> call, Throwable throwable) {

            }
        });
    }

    private void iniciarControles(){
        rvProductos = (RecyclerView) findViewById(R.id.rvProductos);
    }

    public void GoMenu(View vista){
        Intent i = new Intent(this, menuActivity.class );
        startActivity(i);
    }
}
