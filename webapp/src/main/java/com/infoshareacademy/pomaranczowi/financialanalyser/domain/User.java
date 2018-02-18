package com.infoshareacademy.pomaranczowi.financialanalyser.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class User {

    @JsonIgnore
    String sub;

    @JsonProperty("given_name")
    String givenName;

    @JsonProperty("family_name")
    String familyName;

    String nickname;

    String name;

    String picture;

    String gender;

    String locale;

    @JsonProperty("updated_at")
    String updatedAt;

    String email;

    @JsonProperty("email_verified")
    Boolean emailVerified;
}
