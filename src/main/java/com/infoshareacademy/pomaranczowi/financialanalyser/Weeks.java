package com.infoshareacademy.pomaranczowi.financialanalyser;

import java.time.LocalDate;

public class Weeks {

    private int week;
    private LocalDate from;
    private LocalDate to;

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public LocalDate getFrom() {
        return from;
    }

    public void setFrom(LocalDate from) {
        this.from = from;
    }

    public LocalDate getTo() {
        return to;
    }

    public void setTo(LocalDate to) {
        this.to = to;
    }
}

