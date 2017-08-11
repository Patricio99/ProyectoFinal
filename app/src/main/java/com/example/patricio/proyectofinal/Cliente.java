package com.example.patricio.proyectofinal;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


    public class Cliente {

        @SerializedName("idClientes")
        @Expose
        private String idClientes;
        @SerializedName("Nombres")
        @Expose
        private String nombres;
        @SerializedName("Apellidos")
        @Expose
        private String apellidos;
        @SerializedName("actividades")
        @Expose
        private String actividades;

        public String getIdClientes() {
            return idClientes;
        }

        public void setIdClientes(String idClientes) {
            this.idClientes = idClientes;
        }

        public String getNombres() {
            return nombres;
        }

        public void setNombres(String nombres) {
            this.nombres = nombres;
        }

        public String getApellidos() {
            return apellidos;
        }

        public void setApellidos(String apellidos) {
            this.apellidos = apellidos;
        }

        public String getActividades() {
            return actividades;
        }

        public void setActividades(String actividades) {
            this.actividades = actividades;
        }
    }
