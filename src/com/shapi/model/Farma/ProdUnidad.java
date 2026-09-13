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
public class ProdUnidad {

    private Integer id;
    private String abreviatura_c;
    private String abreviatura_v;
    private Integer cantidad_c;
    private Integer cantidad_v;
    private OffsetDateTime created_at;
    private OffsetDateTime updated_at;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public ProdUnidad(Integer id) {
        this.id = id;
    }
}
