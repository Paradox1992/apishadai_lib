package com.shapi.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.OffsetDateTime;
import lombok.Data;

@Data
public class User {

    private Integer id;
    private Role rol;
    private String nombre;
    private String name;
    private String password;
    private String email;
    private UserStatus estado;
    private OffsetDateTime created_at;
    private OffsetDateTime updated_at;

    public User() {
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public User(Integer id) {
        this.id = id;
    }

    public User(
            @JsonProperty("id") Integer id,
            @JsonProperty("rol") Role rol,
            @JsonProperty("nombre") String nombre,
            @JsonProperty("name") String name,
            @JsonProperty(value = "password") String password,
            @JsonProperty("email") String email,
            @JsonProperty("estado") UserStatus estado,
            @JsonProperty("created_at") OffsetDateTime created_at,
            @JsonProperty("updated_at") OffsetDateTime updated_at) {
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

    @Override
    public String toString() {
        if (nombre != null && !nombre.isBlank()) {
            return nombre;
        }
        if (name != null && !name.isBlank()) {
            return name;
        }
        return email != null ? email : "";
    }

}
