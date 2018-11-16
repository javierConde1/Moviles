package com.example.javierconde.st;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class OrdenRequest extends StringRequest {

    private  static final String INSERTAR_REQUEST_URL="https://javier-conde101.000webhostapp.com/insert.php";
    private Map<String,String> params;
    public OrdenRequest(String sEstado, Date sFecha, String sPrioridad, String sProblema, String sDescripcion, Response.Listener<String> listener){
        super(Method.POST, INSERTAR_REQUEST_URL,listener,null);
        params=new HashMap<>();
        params.put("estado", sEstado);
        params.put("fecha", String.valueOf(sFecha));
        params.put("prioridad", sPrioridad);
        //params.put("domicilio", sDomicilio);
        //params.put("fechaprog", sfechaprog);
        params.put("problema", sProblema);
        params.put("sdesc", sDescripcion);
    }

    @Override
    public Map<String, String> getParams() {
        return params;
    }
}
