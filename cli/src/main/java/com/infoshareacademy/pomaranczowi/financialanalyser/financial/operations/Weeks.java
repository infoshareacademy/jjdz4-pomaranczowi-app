package com.infoshareacademy.pomaranczowi.financialanalyser.financial.operations;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

class Weeks {

    @Setter @Getter private int week;
    @Setter @Getter private LocalDate from;
    @Setter @Getter private LocalDate to;
}

