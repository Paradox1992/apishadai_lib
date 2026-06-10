package com.shapi.model.auth;

import com.fasterxml.jackson.annotation.JsonProperty;

public final record Credentials(
        @JsonProperty("name")
        String name,
        @JsonProperty("password")
        String password) {

}
