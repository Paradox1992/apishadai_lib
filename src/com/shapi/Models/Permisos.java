package com.shapi.Models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.time.OffsetDateTime;
import rsc.Utility.OffsetDateTimeDeserializer;

public class Permisos {

    @JsonProperty("id")
    private int id;

    @JsonProperty("usuario")
    private User usuario;

    @JsonProperty("modulo")
    private Modulo modulo;

    @JsonProperty("vista")
    private Vista vista;

    @JsonProperty("actionvista")
    private Actionsvistas actionvista;

    @JsonProperty("tipo_tiempo")
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private TiposTiempo tipo_tiempo;

    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime created_at;

    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime updated_at;

    // Constructores
    public Permisos() {
    }

    public Permisos(int id) {
        this.id = id;
    }

    public Permisos(int id, User usuario, Modulo modulo, Vista vista, Actionsvistas actionvista, TiposTiempo tipo_tiempo, OffsetDateTime created_at, OffsetDateTime updated_at) {
        this.id = id;
        this.usuario = usuario;
        this.modulo = modulo;
        this.vista = vista;
        this.actionvista = actionvista;
        this.tipo_tiempo = tipo_tiempo;
        this.created_at = created_at;
        this.updated_at = updated_at;
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
     * @return the usuario
     */
    public User getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the modulo
     */
    public Modulo getModulo() {
        return modulo;
    }

    /**
     * @param modulo the modulo to set
     */
    public void setModulo(Modulo modulo) {
        this.modulo = modulo;
    }

    /**
     * @return the vista
     */
    public Vista getVista() {
        return vista;
    }

    /**
     * @param vista the vista to set
     */
    public void setVista(Vista vista) {
        this.vista = vista;
    }

    /**
     * @return the actionvista
     */
    public Actionsvistas getActionvista() {
        return actionvista;
    }

    /**
     * @param actionvista the actionvista to set
     */
    public void setActionvista(Actionsvistas actionvista) {
        this.actionvista = actionvista;
    }

    /**
     * @return the tipo_tiempo
     */
    public TiposTiempo getTipo_tiempo() {
        return tipo_tiempo;
    }

    /**
     * @param tipo_tiempo the tipo_tiempo to set
     */
    public void setTipo_tiempo(TiposTiempo tipo_tiempo) {
        this.tipo_tiempo = tipo_tiempo;
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

}
