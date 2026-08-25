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
public class AppModule {

    private Integer id;
    private String nombre;
    private String codigo;
    private AppModuleStatus estado;
    private OffsetDateTime created_at;
    private OffsetDateTime updated_at;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public AppModule(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return this.nombre;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.id);
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
        final AppModule other = (AppModule) obj;
        return Objects.equals(this.id, other.id);
    }

}
