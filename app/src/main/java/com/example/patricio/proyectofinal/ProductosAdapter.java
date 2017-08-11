package com.example.patricio.proyectofinal;

import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ProductosAdapter extends RecyclerView.Adapter<ProductosAdapter.ProductosViewHolder>{

    List<Productos> lista;

    public ProductosAdapter(List<Productos> lista){
        this.lista = lista;
    }

    @Override
    public ProductosViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.productos_row,parent,false);

        return new ProductosViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ProductosViewHolder holder, int position) {
        holder.bindProductos(lista.get(position));

    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public class ProductosViewHolder extends RecyclerView.ViewHolder{

        TextView tvNombre;
        TextView tvId;


        public ProductosViewHolder(View itemView) {
            super(itemView);

            tvNombre = (TextView) itemView.findViewById(R.id.tvCliente);
            tvId = (TextView) itemView.findViewById(R.id.tvID);
        }

        public void bindProductos(Productos productos){
            String nombre = productos.getDescripcion();
            tvNombre.setText(nombre);
            tvId.setText(String.valueOf(productos.getPrecio()));
        }
    }

}
