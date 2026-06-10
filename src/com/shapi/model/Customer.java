package com.shapi.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.OffsetDateTime;
import lombok.Data;

@Data
public class Customer {

    private Integer id;
    private String docid;
    private String pnombre;
    private String snombre;
    private String papellido;
    private String spaellido;
    private int edad;
    private String telefono;
    private String genero;
    private Municipality municipio;
    private Department departamento;
    private OffsetDateTime phone_updated_at;
    private OffsetDateTime created_at;
    private OffsetDateTime updated_at;

    public Customer() {
    }

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public Customer(@JsonProperty("id") Integer id) {
        this.id = id;
    }

    public Customer(
            @JsonProperty("id") Integer id,
            @JsonProperty("docid") String docid,
            @JsonProperty("pnombre") String pnombre,
            @JsonProperty("snombre") String snombre,
            @JsonProperty("papellido") String papellido,
            @JsonProperty("spaellido") String spaellido,
            @JsonProperty("edad") int edad,
            @JsonProperty("telefono") String telefono,
            @JsonProperty("genero") String genero,
            @JsonProperty("municipio") Municipality municipio,
            @JsonProperty("departamento") Department departamento,
            @JsonProperty("phone_updated_at") OffsetDateTime phone_updated_at,
            @JsonProperty("created_at") OffsetDateTime created_at,
            @JsonProperty("updated_at") OffsetDateTime updated_at) {
        this.id = id;
        this.docid = docid;
        this.pnombre = pnombre;
        this.snombre = snombre;
        this.papellido = papellido;
        this.spaellido = spaellido;
        this.edad = edad;
        this.telefono = telefono;
        this.genero = genero;
        this.municipio = municipio;
        this.departamento = departamento;
        this.phone_updated_at = phone_updated_at;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

}
