package com.infoshareacademy.pomaranczowi.financialanalyser;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

interface Quotation {

    static void ShowAll(Quotation quotation, LocalDate date) {
        System.out.println("\nDla dnia "+date+" wartość OPEN wynosi: "+quotation.getOpen(date));
        System.out.println("Dla dnia "+date+" wartość LOW wynosi: "+quotation.getLow(date));
        System.out.println("Dla dnia "+date+" wartość HIGH wynosi: "+quotation.getHigh(date));
        System.out.println("Dla dnia "+date+" wartość CLOSE wynosi: "+quotation.getClose(date));
        System.out.println("Dla dnia "+date+" wartość VOLUME wynosi: "+quotation.getVolume(date));
    }

    BigDecimal getOpen(LocalDate date);
    BigDecimal getHigh(LocalDate date);
    BigDecimal getLow(LocalDate date);
    BigDecimal getClose(LocalDate date);
    BigDecimal getVolume(LocalDate date);
    ArrayList<Price> getPrices();

    boolean containsDate(LocalDate date);
}
