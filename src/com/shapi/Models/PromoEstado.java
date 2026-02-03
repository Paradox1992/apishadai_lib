package com.shapi.Models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.time.OffsetDateTime;
import java.util.Objects;
import rsc.Utility.OffsetDateTimeDeserializer;

public class PromoEstado {

    @JsonProperty("id")
    private int id;

    @JsonProperty("descripcion")
    private String descripcion;

    @JsonProperty("created_at")
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
    private OffsetDateTime created_at;

    @JsonProperty("updated_at")
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
    private OffsetDateTime updated_at;

    public PromoEstado() {
    }

    public PromoEstado(int id, String descripcion, OffsetDateTime created_at, OffsetDateTime updated_at) {
        this.id = id;
        this.descripcion = descripcion;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public PromoEstado(int id) {
        this.id = id;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the descipcion
     */
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * @return the created_at
     */
    public OffsetDateTime getCreated_at() {
        return created_at;
    }

    /**
     * @param created_at the created_at to set
     */
    public void setCreated_at(OffsetDateTime created_at) {
        this.created_at = created_at;
    }

    /**
     * @return the updated_at
     */
    public OffsetDateTime getUpdated_at() {
        return updated_at;
    }

    /**
     * @param updated_at the updated_at to set
     */
    public void setUpdated_at(OffsetDateTime updated_at) {
        this.updated_at = updated_at;
    }

    @Override
    public String toString() {
        return getDescripcion();
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + this.id;
        hash = 59 * hash + Objects.hashCode(this.descripcion);
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
        final PromoEstado other = (PromoEstado) obj;
        if (this.id != other.id) {
            return false;
        }
        return Objects.equals(this.descripcion, other.descripcion);
    }

}
