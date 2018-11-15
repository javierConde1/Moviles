package com.example.javierconde.st;

public class Listado_tecnico {
    public int no_ordenTec;
    public String estadoTec;
    public String no_cleinte;
    public String fechaTec;
    public String prioridadTec;
    public String domicilioTec;

    public Listado_tecnico() {}

    public Listado_tecnico(int no_ordenTec, String estadoTec, String fechaTec, String prioridadTec, String domicilioTec) {
        this.no_ordenTec = no_ordenTec;
        this.estadoTec = estadoTec;
        this.fechaTec = fechaTec;
        this.prioridadTec = prioridadTec;
        this.domicilioTec = domicilioTec;
    }

    public int getNo_ordenTec() {
        return no_ordenTec;
    }

    public void setNo_ordenTec(int no_ordenTec) {
        this.no_ordenTec = no_ordenTec;
    }

    public String getEstadoTec() {
        return estadoTec;
    }

    public void setEstadoTec(String estadoTec) {
        this.estadoTec = estadoTec;
    }

    public String getNo_cleinte() {
        return no_cleinte;
    }

    public void setNo_cleinte(String no_cleinte) {
        this.no_cleinte = no_cleinte;
    }

    public String getFechaTec() {
        return fechaTec;
    }

    public void setFechaTec(String fechaTec) {
        this.fechaTec = fechaTec;
    }

    public String getPrioridadTec() {
        return prioridadTec;
    }

    public void setPrioridadTec(String prioridadTec) {
        this.prioridadTec = prioridadTec;
    }

    public String getDomicilioTec() {
        return domicilioTec;
    }

    public void setDomicilioTec(String domicilioTec) {
        this.domicilioTec = domicilioTec;
    }
}
