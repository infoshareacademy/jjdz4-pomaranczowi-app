package com.infoshareacademy.pomaranczowi.financialanalyser;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

public class

Extremes {

    @Setter @Getter private BigDecimal value;
    @Setter @Getter private LocalDate date;

    Extremes (){
        this.value = BigDecimal.valueOf(0); //ustawione aby w LocalExt można było porównywac
                                            //x.getVolume().compareTo(extremes.getValue()) w pierwszej iteracji
    }
}
