package com.example.patricio.proyectofinal;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Productos {

    @SerializedName("Descripcion")
    @Expose
    private String descripcion;
    @SerializedName("Precio")
    @Expose
    private String precio;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }
}
