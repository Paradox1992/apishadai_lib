package com.shapi.Models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import rsc.Utility.OffsetDateTimeDeserializer;

import java.time.OffsetDateTime;


public class User {

    @JsonProperty("id")
    private int id;

    @JsonProperty("rol")
    private Roles rol;

    @JsonProperty("nombre")
    private String nombre;

    @JsonProperty("name")
    private String name;

    @JsonProperty(value = "password") // Seguridad: solo se permite deserializar, no mostrar
    private String password;

    @JsonProperty("email")
    private String email;

    @JsonProperty("estado")
    private UserEstado estado;

    @JsonProperty("created_at")
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
    private OffsetDateTime created_at;

    @JsonProperty("updated_at")
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
    private OffsetDateTime updated_at;

    public User() {
    }

    public User(int id) {
        this.id = id;
    }

    public User(int id, Roles rol, String nombre, String name, String password, String email, UserEstado estado, OffsetDateTime created_at, OffsetDateTime updated_at) {
        this.id = id;
        this.rol = rol;
        this.nombre = nombre;
        this.name = name;
        this.password = password;
        this.email = email;
        this.estado = estado;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    // Getters
    public int getId() {
        return id;
    }

    public Roles getRol() {
        return rol;
    }

    public String getNombre() {
        return nombre;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public UserEstado getEstado() {
        return estado;
    }

    public OffsetDateTime getCreated_at() {
        return created_at;
    }

    public OffsetDateTime getUpdated_at() {
        return updated_at;
    }

    // Setters
    public void setId(int id) {
        this.id = id;
    }

    public void setRol(Roles rol) {
        this.rol = rol;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setEstado(UserEstado estado) {
        this.estado = estado;
    }

    public void setCreated_at(OffsetDateTime created_at) {
        this.created_at = created_at;
    }

    public void setUpdated_at(OffsetDateTime updated_at) {
        this.updated_at = updated_at;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + this.id;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        return this.id == other.id;
    }

}
