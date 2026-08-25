package com.shapi.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.time.OffsetDateTime;
import java.util.Objects;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class View {

    private Integer id;
    private AppModule modulo;
    private String nombre;
    private String codigo;
    private ViewStatus estado;
    private OffsetDateTime created_at;
    private OffsetDateTime updated_at;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public View(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return nombre;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final View other = (View) obj;
        return Objects.equals(this.id, other.id);
    }

}
