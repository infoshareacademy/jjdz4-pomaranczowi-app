package com.infoshareacademy.pomaranczowi.financialanalyser;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

class Extremes {

    @Setter @Getter private BigDecimal value;
    @Setter @Getter private LocalDate date;

}
