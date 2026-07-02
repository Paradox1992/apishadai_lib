package com.shapi.model.Farma;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;
import lombok.Data;

@Data
public class Proveedores {

    private Integer id;
    private String nombre;
    private String telefono;
    private String direccion;
    private String imagen;
    private OffsetDateTime created_at;
    private OffsetDateTime updated;

    public Proveedores() {
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public Proveedores(@JsonProperty("id") Integer id) {
        this.id = id;
    }

    public Proveedores(
            @JsonProperty("id") Integer id,
            @JsonProperty("nombre") String nombre,
            @JsonProperty("telefono") String telefono,
            @JsonProperty("direccion") String direccion,
            @JsonProperty("imagen") String imagen,
            @JsonProperty("created_at") OffsetDateTime created_at,
            @JsonProperty("updated") OffsetDateTime updated) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.direccion = direccion;
        this.imagen = imagen;
        this.created_at = created_at;
        this.updated = updated;
    }

}
