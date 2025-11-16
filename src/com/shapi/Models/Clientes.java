package com.shapi.Models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.time.OffsetDateTime;
import rsc.Utility.OffsetDateTimeDeserializer;

public class Clientes {

    @JsonProperty("id")
    private int id;

    @JsonProperty("docid")
    private String docid;

    @JsonProperty("pnombre")
    private String pnombre;

    @JsonProperty("snombre")
    private String snombre;

    @JsonProperty("papellido")
    private String papellido;

    @JsonProperty("spaellido")
    private String spaellido;

    @JsonProperty("edad")
    private int edad;

    @JsonProperty("telefono")
    private String telefono;

    @JsonProperty("genero")
    private String genero;

    @JsonProperty("municipio")
    private Municipios municipio;

    @JsonProperty("departamento")
    private Departamentos departamento;

    @JsonProperty("created_at")
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
    private OffsetDateTime created_at;

    @JsonProperty("updated_at")
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
    private OffsetDateTime updated_at;

    public Clientes() {
    }

    public Clientes(int id, String docid, String pnombre, String snombre, String papellido, String spaellido, int edad, String telefono, String genero, Municipios municipio, Departamentos departamento, OffsetDateTime created_at, OffsetDateTime updated_at) {
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
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public Clientes(int id) {
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
     * @return the docid
     */
    public String getDocid() {
        return docid;
    }

    /**
     * @param docid the docid to set
     */
    public void setDocid(String docid) {
        this.docid = docid;
    }

    /**
     * @return the pnombre
     */
    public String getPnombre() {
        return pnombre;
    }

    /**
     * @param pnombre the pnombre to set
     */
    public void setPnombre(String pnombre) {
        this.pnombre = pnombre;
    }

    /**
     * @return the snombre
     */
    public String getSnombre() {
        return snombre;
    }

    /**
     * @param snombre the snombre to set
     */
    public void setSnombre(String snombre) {
        this.snombre = snombre;
    }

    /**
     * @return the papellido
     */
    public String getPapellido() {
        return papellido;
    }

    /**
     * @param papellido the papellido to set
     */
    public void setPapellido(String papellido) {
        this.papellido = papellido;
    }

    /**
     * @return the spaellido
     */
    public String getSpaellido() {
        return spaellido;
    }

    /**
     * @param spaellido the spaellido to set
     */
    public void setSpaellido(String spaellido) {
        this.spaellido = spaellido;
    }

    /**
     * @return the edad
     */
    public int getEdad() {
        return edad;
    }

    /**
     * @param edad the edad to set
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * @return the telefono
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * @param telefono the telefono to set
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * @return the genero
     */
    public String getGenero() {
        return genero;
    }

    /**
     * @param genero the genero to set
     */
    public void setGenero(String genero) {
        this.genero = genero;
    }

    /**
     * @return the municipio
     */
    public Municipios getMunicipio() {
        return municipio;
    }

    /**
     * @param municipio the municipio to set
     */
    public void setMunicipio(Municipios municipio) {
        this.municipio = municipio;
    }

    /**
     * @return the departamento
     */
    public Departamentos getDepartamento() {
        return departamento;
    }

    /**
     * @param departamento the departamento to set
     */
    public void setDepartamento(Departamentos departamento) {
        this.departamento = departamento;
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
