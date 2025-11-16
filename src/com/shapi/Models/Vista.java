package com.shapi.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.time.OffsetDateTime;
import rsc.Utility.OffsetDateTimeDeserializer;

public class Vista {

    @JsonProperty("id")
    private int id;

    @JsonProperty("modulo")
    private Modulo modulo;

    @JsonProperty("nombre")
    private String nombre;

    @JsonProperty("codigo")
    private String codigo;

    @JsonProperty("estado")
    private VistaEstado estado;

    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime created_at;

    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime updated_at;

    // Constructores
    public Vista() {
    }

    public Vista(int id) {
        this.id = id;
    }

    public Vista(int id, Modulo modulo, String nombre, String codigo, VistaEstado estado, OffsetDateTime created_at, OffsetDateTime updated_at) {
        this.id = id;
        this.modulo = modulo;
        this.nombre = nombre;
        this.codigo = codigo;
        this.estado = estado;
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

    public Modulo getModulo() {
        return modulo;
    }

    public void setModulo(Modulo modulo) {
        this.modulo = modulo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public VistaEstado getEstado() {
        return estado;
    }

    public void setEstado(VistaEstado estado) {
        this.estado = estado;
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

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getCodigo() {
        return codigo;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + this.id;
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
        final Vista other = (Vista) obj;
        return this.id == other.id;
    }

    @Override
    public String toString() {
        return getNombre();
    }

}
