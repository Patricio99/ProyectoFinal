package com.example.patricio.proyectofinal;

import android.content.Context;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


public class ClienteAdapter extends RecyclerView.Adapter<ClienteAdapter.ClienteViewHolder>{

    List<Cliente> lista;



    public ClienteAdapter(List<Cliente> lista){
        this.lista = lista;
    }

    @Override
    public ClienteViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cliente_row,parent,false);

        return new ClienteViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ClienteViewHolder holder, final int position) {
        holder.bindCliente(lista.get(position));


    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class ClienteViewHolder extends RecyclerView.ViewHolder{

        TextView tvNombre;
        TextView tvAct;
        TextView tvId;


        public ClienteViewHolder(View itemView) {
            super(itemView);

            tvNombre = (TextView) itemView.findViewById(R.id.tvCliente);
            tvAct = (TextView) itemView.findViewById(R.id.tvAct);
            tvId = (TextView) itemView.findViewById(R.id.tvID);
        }

        public void bindCliente(Cliente cliente){
            String nombre = cliente.getNombres() + " " + cliente.getApellidos();
            tvNombre.setText(nombre);
            tvAct.setText(cliente.getActividades());
            tvId.setText(String.valueOf(cliente.getIdClientes()));
        }
    }
}
