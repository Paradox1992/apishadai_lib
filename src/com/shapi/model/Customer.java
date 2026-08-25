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
public class Customer {

    private Integer id;
    private String docid;
    private String pnombre;
    private String snombre;
    private String papellido;
    private String spaellido;
    private Integer edad;
    private String telefono;
    private String genero;
    private Municipality municipio;
    private Department departamento;
    private OffsetDateTime phone_updated_at;
    private OffsetDateTime created_at;
    private OffsetDateTime updated_at;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public Customer(Integer id) {
        this.id = id;
    }
}
