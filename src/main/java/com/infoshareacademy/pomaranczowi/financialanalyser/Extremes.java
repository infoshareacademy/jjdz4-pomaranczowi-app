package com.infoshareacademy.pomaranczowi.financialanalyser;

import java.math.BigDecimal;
import java.time.LocalDate;

public class

Extremes {

    private BigDecimal value;
    private LocalDate date;

    Extremes (){
        this.value = BigDecimal.valueOf(0); //ustawione aby w GetLocalExt można było porównywac
                                            //x.getVolume().compareTo(extremes.getValue()) w pierwszej iteracji
    }

    BigDecimal getValue() {
        return value;
    }

    public LocalDate getDate() {
        return date;
    }

    void setValue(BigDecimal value) {
        this.value = value;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }



}
