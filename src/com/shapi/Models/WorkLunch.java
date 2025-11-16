package com.shapi.Models;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.time.OffsetDateTime;
import rsc.Utility.OffsetDateTimeDeserializer;

public class WorkLunch {

    private int id;
    private User usuario;
    private Device device;

    @JsonProperty("wkstart_time")
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
    private OffsetDateTime wkstart_time;

    @JsonProperty("wkend_time")
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
    private OffsetDateTime wkend_time;

    @JsonProperty("lunch_start_time")
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
    private OffsetDateTime lunch_start_time;

    @JsonProperty("lunch_end_time")
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
    private OffsetDateTime lunch_end_time;

    @JsonProperty("created_at")
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
    private OffsetDateTime created_at;

    @JsonProperty("updated_at")
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ssXXX")
    private OffsetDateTime updated_at;

    public WorkLunch() {
    }

    public WorkLunch(int id) {
        this.id = id;
    }

    public WorkLunch(int id, User usuario, Device device, OffsetDateTime wkstart_time, OffsetDateTime wkend_time, OffsetDateTime lunch_start_time, OffsetDateTime lunch_end_time, OffsetDateTime created_at, OffsetDateTime updated_at) {
        this.id = id;
        this.usuario = usuario;
        this.device = device;
        this.wkstart_time = wkstart_time;
        this.wkend_time = wkend_time;
        this.lunch_start_time = lunch_start_time;
        this.lunch_end_time = lunch_end_time;
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
     * @return the device
     */
    public Device getDevice() {
        return device;
    }

    /**
     * @param device the device to set
     */
    public void setDevice(Device device) {
        this.device = device;
    }

    /**
     * @return the wkstart_time
     */
    public OffsetDateTime getWkstart_time() {
        return wkstart_time;
    }

    /**
     * @param wkstart_time the wkstart_time to set
     */
    public void setWkstart_time(OffsetDateTime wkstart_time) {
        this.wkstart_time = wkstart_time;
    }

    /**
     * @return the wkend_time
     */
    public OffsetDateTime getWkend_time() {
        return wkend_time;
    }

    /**
     * @param wkend_time the wkend_time to set
     */
    public void setWkend_time(OffsetDateTime wkend_time) {
        this.wkend_time = wkend_time;
    }

    /**
     * @return the lunch_start_time
     */
    public OffsetDateTime getLunch_start_time() {
        return lunch_start_time;
    }

    /**
     * @param lunch_start_time the lunch_start_time to set
     */
    public void setLunch_start_time(OffsetDateTime lunch_start_time) {
        this.lunch_start_time = lunch_start_time;
    }

    /**
     * @return the lunch_end_time
     */
    public OffsetDateTime getLunch_end_time() {
        return lunch_end_time;
    }

    /**
     * @param lunch_end_time the lunch_end_time to set
     */
    public void setLunch_end_time(OffsetDateTime lunch_end_time) {
        this.lunch_end_time = lunch_end_time;
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
