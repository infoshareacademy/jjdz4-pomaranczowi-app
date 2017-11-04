package com.infoshareacademy.pomaranczowi.financialanalyser;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

//Price objects can be stored in and returned by Currency objects
public class Price {

    @Setter @Getter private String name;
    @Setter @Getter private LocalDate date;
    @Setter @Getter private BigDecimal open;
    @Setter @Getter private BigDecimal high;
    @Setter @Getter private BigDecimal low;
    @Setter @Getter private BigDecimal close;
    @Setter @Getter private BigDecimal volume;
}