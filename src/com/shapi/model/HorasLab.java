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
public class HorasLab {

    private Integer id;
    private User usuario;
    private Integer horas_lab;
    private Integer horas_lunch;
    private OffsetDateTime created_at;
    private OffsetDateTime updated_at;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public HorasLab(Integer id) {
        this.id = id;
    }

    public HorasLab(Integer id, User usuario, Integer horas_lab, Integer horas_lunch, OffsetDateTime created_at, OffsetDateTime updated_at) {
        this.id = id;
        this.usuario = usuario;
        this.horas_lab = horas_lab;
        this.horas_lunch = horas_lunch;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }
    

    @Override
    public String toString() {
        return usuario != null ? usuario.toString() : "";
    }
}
