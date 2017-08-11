package com.example.patricio.proyectofinal;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ClienteService {

    @GET("apis/usuarioslist.php")
    Call<List<Cliente>> getClientes();


}
