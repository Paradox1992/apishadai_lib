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
public class Permission {

    private Integer id;
    private User usuario;
    private AppModule modulo;
    private View vista;
    private ViewAction actionvista;
    private TimeType tipo_tiempo;
    private OffsetDateTime created_at;
    private OffsetDateTime updated_at;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public Permission(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        if (actionvista != null) {
            return actionvista.toString();
        }
        if (vista != null) {
            return vista.toString();
        }
        return id != null ? String.valueOf(id) : "";
    }

}
