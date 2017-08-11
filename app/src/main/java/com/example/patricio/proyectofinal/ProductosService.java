package com.example.patricio.proyectofinal;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


public interface ProductosService {

    @GET("apis/productos.php")
    Call<List<Productos>> getProductos();
}
