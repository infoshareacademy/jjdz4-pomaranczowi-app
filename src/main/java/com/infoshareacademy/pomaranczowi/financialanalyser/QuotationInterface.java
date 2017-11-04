package com.infoshareacademy.pomaranczowi.financialanalyser;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

interface QuotationInterface {

    static void showAll(QuotationInterface quotation, LocalDate date) {
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
    String getName();
    ArrayList<Price> getPrices();

    boolean containsDate(LocalDate date);
}
