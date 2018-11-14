package com.example.javierconde.st;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class Listado_tecnico_adapter extends RecyclerView.Adapter<Listado_tecnico_adapter.ViewHolder>{
private Context contextT;
private List<Listado_tecnico> list;

public Listado_tecnico_adapter(Context contextT, List<Listado_tecnico> list){
        this.contextT = contextT;
        this.list = list;
        }


@Override
public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(contextT).inflate(R.layout.single_item, parent, false );
        return new ViewHolder(v);
        }

@Override
public void onBindViewHolder(ViewHolder holder, int position) {
        Listado_tecnico Listado_tecnico = list.get(position);
        holder.txtNo_orden.setText("Orden No. " + String.valueOf(Listado_tecnico.getNo_orden()));
        holder.txtEstado.setText("Actividad " + Listado_tecnico.getEstado());

        switch(holder.txtEstado.getText().toString()){
        case "Actividad finalizada":
        holder.txtEstado.setTextColor(Color.GREEN);
        break;
        case "Actividad pendiente":
        holder.txtEstado.setTextColor(Color.RED);
        break;
        }

        holder.txtFecha.setText("Fecha: " + Listado_tecnico.getFecha());

        holder.txtPrioridad.setText("Prioridad " + Listado_tecnico.getPrioridad());

        switch(holder.txtPrioridad.getText().toString()){
        case "Prioridad baja":
        holder.txtPrioridad.setTextColor(Color.GREEN);
        break;
        case "Prioridad media":
        holder.txtPrioridad.setTextColor(Color.YELLOW);
        break;
        case "Prioridad alta":
        holder.txtPrioridad.setTextColor(Color.RED);
        break;
        }

        holder.txtDomicilio.setText(Listado_tecnico.getDomicilio());
        }

@Override
public int getItemCount() {
        return list.size();
        }

public class ViewHolder extends RecyclerView.ViewHolder{
    public TextView txtNo_orden, txtEstado, txtFecha, txtPrioridad, txtDomicilio;
    public ViewHolder(View itemView) {
        super(itemView);
        txtNo_orden = itemView.findViewById(R.id.main_no_orden);
        txtEstado = itemView.findViewById(R.id.main_estado);
        txtFecha = itemView.findViewById(R.id.main_fecha);
        txtPrioridad = itemView.findViewById(R.id.main_prioridad);
        txtDomicilio = itemView.findViewById(R.id.main_domicilio);
    }
}
}
