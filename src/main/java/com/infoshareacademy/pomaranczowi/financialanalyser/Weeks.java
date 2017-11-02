package com.infoshareacademy.pomaranczowi.financialanalyser;

import java.time.LocalDate;

class Weeks {

    private int week;
    private LocalDate from;
    private LocalDate to;

    int getWeek() {
        return week;
    }

    void setWeek(int week) {
        this.week = week;
    }

    LocalDate getFrom() {
        return from;
    }

    void setFrom(LocalDate from) {
        this.from = from;
    }

    LocalDate getTo() {
        return to;
    }

    void setTo(LocalDate to) {
        this.to = to;
    }
}

