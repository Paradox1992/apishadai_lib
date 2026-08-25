package com.shapi.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public final class TicketRequest {

    private String numero;
    private String valor;
    private String promocion;
    private String cliente_n;
    private String cliente_i;
    private String cliente_t;
    private String stock;
    private String create_at;
    @Override
    public String toString() {
        return null;
    }
}
