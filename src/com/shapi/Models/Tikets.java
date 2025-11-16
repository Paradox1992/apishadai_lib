package com.shapi.Models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.time.OffsetDateTime;
import rsc.Utility.OffsetDateTimeDeserializer;

public class Tikets {

    @JsonProperty("id")
    private int id;

    @JsonProperty("promocion")
    private Promociones promocion;

    @JsonProperty("cliente")
    private Clientes cliente;

    @JsonProperty("ntiket")
    private int ntiket;

    @JsonProperty("usuario")
    private User usuario;

    @JsonProperty("stock")
    private Stock stock;

    @JsonProperty("created_at")
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
    private OffsetDateTime created_at;

    @JsonProperty("updated_at")
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
    private OffsetDateTime updated_at;

    public Tikets() {
    }

    public Tikets(int id, Promociones promocion, Clientes cliente, int ntiket, User usuario, Stock stock, OffsetDateTime created_at, OffsetDateTime updated_at) {
        this.id = id;
        this.promocion = promocion;
        this.cliente = cliente;
        this.ntiket = ntiket;
        this.usuario = usuario;
        this.stock = stock;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public Tikets(int id) {
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
     * @return the promocion
     */
    public Promociones getPromocion() {
        return promocion;
    }

    /**
     * @param promocion the promocion to set
     */
    public void setPromocion(Promociones promocion) {
        this.promocion = promocion;
    }

    /**
     * @return the cliente
     */
    public Clientes getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the ntiket
     */
    public int getNtiket() {
        return ntiket;
    }

    /**
     * @param ntiket the ntiket to set
     */
    public void setNtiket(int ntiket) {
        this.ntiket = ntiket;
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
     * @return the stock
     */
    public Stock getStock() {
        return stock;
    }

    /**
     * @param stock the stock to set
     */
    public void setStock(Stock stock) {
        this.stock = stock;
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
