package com.infoshareacademy.pomaranczowi.financialanalyser.financial.domain;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Extremes {

    @Setter @Getter private BigDecimal value=BigDecimal.valueOf(0);
    @Setter @Getter private LocalDate date;

}
