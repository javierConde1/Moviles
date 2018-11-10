package com.example.javierconde.st;

public class Listado_cliente {
    public int no_orden;
    public String estado;
    public String no_cleinte;
    public String fecha;
    public String prioridad;
    public String domicilio;

    public Listado_cliente() {}

    public Listado_cliente(int no_orden, String estado, String fecha, String prioridad, String domicilio) {
        this.no_orden = no_orden;
        this.estado = estado;
        this.fecha = fecha;
        this.prioridad = prioridad;
        this.domicilio = domicilio;
    }

    public int getNo_orden() {
        return no_orden;
    }

    public void setNo_orden(int no_orden) {
        this.no_orden = no_orden;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }


    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }
}