package com.shapi.model.Farma;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Proveedores {

    private Integer id;
    private String nombre;
    private String telefono;
    private String direccion;
    private String imagen;
    private OffsetDateTime created_at;
    private OffsetDateTime updated_at;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public Proveedores(Integer id) {
        this.id = id;
    }
}
