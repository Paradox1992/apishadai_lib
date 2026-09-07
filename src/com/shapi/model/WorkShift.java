package com.shapi.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class WorkShift {

    private Integer id;
    private LocalDate work_date;
    private User usuario;
    private Device device;
    private OffsetDateTime wkstart_time;
    private OffsetDateTime wkend_time;
    private OffsetDateTime lunch_start_time;
    private OffsetDateTime lunch_end_time;
    private OffsetDateTime created_at;
    private OffsetDateTime updated_at;

    @JsonCreator(mode = JsonCreator.Mode.DELEGATING)
    public WorkShift(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        if (usuario != null) {
            return usuario.toString();
        }
        if (device != null) {
            return device.toString();
        }
        return id != null ? String.valueOf(id) : "";
    }

}
