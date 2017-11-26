package com.infoshareacademy.pomaranczowi.financialanalyser;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
class Price {

    private LocalDate date;
    private BigDecimal open;
    private BigDecimal high;
    private BigDecimal low;
    private BigDecimal close;
    private BigDecimal volume;
}