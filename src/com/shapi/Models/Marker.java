package com.shapi.Models;

public class Marker {

    private final String usuario;
    private final String date_time;

    public Marker(String usuario, String date_time) {
        this.usuario = usuario;
        this.date_time = date_time;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getDate_time() {
        return date_time;
    }

}
