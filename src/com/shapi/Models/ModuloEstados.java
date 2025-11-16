package com.shapi.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.time.OffsetDateTime;
import java.util.Objects;
import rsc.Utility.OffsetDateTimeDeserializer;

public class ModuloEstados{

    @JsonProperty("id")
    private int id;

    @JsonProperty("descripcion")
    private String description;

    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime created_at;

    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime updated_at;

    // Constructores
    public ModuloEstados() {
    }

    public ModuloEstados(int id) {
        this.id = id;
    }

    public ModuloEstados(int id, String description, OffsetDateTime created_at, OffsetDateTime updated_at) {
        this.id = id;
        this.description = description;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Método toString() mejorado
    @Override
    public String toString() {
        return getDescription();
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

    /**
     *
     * @return
     */
    @Override
    public int hashCode() {
         return Objects.hash(id);
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
        final ModuloEstados other = (ModuloEstados) obj;
        return this.id == other.id;
    }
    
    
}
