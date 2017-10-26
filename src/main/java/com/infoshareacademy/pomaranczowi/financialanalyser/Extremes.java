package com.infoshareacademy.pomaranczowi.financialanalyser;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class

Extremes {

    private BigDecimal value;
    private LocalDate date;

    public Extremes (){
        this.value = BigDecimal.valueOf(0); //ustawione aby w GetLocalExt można było porównywac
                                            //x.getVolume().compareTo(extremes.getValue()) w pierwszej iteracji
    }

    //setters and getters for private variables
    public BigDecimal getValue() {
        return value;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }



}
