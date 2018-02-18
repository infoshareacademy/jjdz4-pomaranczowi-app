package com.infoshareacademy.pomaranczowi.financialanalyser.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(nullable=false, unique=true)
    @JsonIgnore
    private Long id;

    @JsonIgnore
    String sub;

    @Column
    @JsonProperty("given_name")
    String givenName;

    @Column
    @JsonProperty("family_name")
    String familyName;

    @Column
    String nickname;

    @Column
    String name;

    @Column
    String picture;

    @Column
    String gender;

    @Column
    String locale;

    @Column
    @JsonProperty("updated_at")
    String updatedAt;

    @Column
    String email;

    @Column
    @JsonProperty("email_verified")
    Boolean emailVerified;

    @Column
    @JsonIgnore
    String role;
}