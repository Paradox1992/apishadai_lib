package com.shapi.model;

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

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public User(Integer id) {
        this.id = id;
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
