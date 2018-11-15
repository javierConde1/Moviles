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
private Context contextTec;
private List<Listado_tecnico> listTec;

public Listado_tecnico_adapter(Context contextTec, List<Listado_tecnico> listTec){
        this.contextTec = contextTec;
        this.listTec = listTec;
        }


@Override
public ViewHolder onCreateViewHolder(ViewGroup parentTec, int viewTypeTec) {
        View vTec = LayoutInflater.from(contextTec).inflate(R.layout.single_item, parentTec, false );
        return new ViewHolder(vTec);
        }

@Override
public void onBindViewHolder(ViewHolder holderTec, int positionTec) {
        Listado_tecnico Listado_tecnico = listTec.get(positionTec);
        holderTec.txtNo_ordenTec.setText("Orden No. " + String.valueOf(Listado_tecnico.getNo_ordenTec()));
        holderTec.txtEstadoTec.setText("Actividad " + Listado_tecnico.getEstadoTec());

        switch(holderTec.txtEstadoTec.getText().toString()){
        case "Actividad finalizada":
        holderTec.txtEstadoTec.setTextColor(Color.GREEN);
        break;
        case "Actividad pendiente":
        holderTec.txtEstadoTec.setTextColor(Color.RED);
        break;
        }

        holderTec.txtFechaTec.setText("Fecha: " + Listado_tecnico.getFechaTec());

        holderTec.txtPrioridadTec.setText("Prioridad " + Listado_tecnico.getPrioridadTec());

        switch(holderTec.txtPrioridadTec.getText().toString()){
        case "Prioridad baja":
        holderTec.txtPrioridadTec.setTextColor(Color.GREEN);
        break;
        case "Prioridad media":
        holderTec.txtPrioridadTec.setTextColor(Color.YELLOW);
        break;
        case "Prioridad alta":
        holderTec.txtPrioridadTec.setTextColor(Color.RED);
        break;
        }

        holderTec.txtDomicilioTec.setText(Listado_tecnico.getDomicilioTec());
        }

@Override
public int getItemCount() {
        return listTec.size();
        }

public class ViewHolder extends RecyclerView.ViewHolder{
    public TextView txtNo_ordenTec, txtEstadoTec, txtFechaTec, txtPrioridadTec, txtDomicilioTec;
    public ViewHolder(View itemViewTec) {
        super(itemViewTec);
        txtNo_ordenTec = itemView.findViewById(R.id.main_no_orden);
        txtEstadoTec = itemView.findViewById(R.id.main_estado);
        txtFechaTec = itemView.findViewById(R.id.main_fecha);
        txtPrioridadTec = itemView.findViewById(R.id.main_prioridad);
        txtDomicilioTec = itemView.findViewById(R.id.main_domicilio);
    }
}
}
