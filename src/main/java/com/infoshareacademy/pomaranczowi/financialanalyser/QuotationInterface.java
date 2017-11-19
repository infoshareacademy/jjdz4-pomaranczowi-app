package com.infoshareacademy.pomaranczowi.financialanalyser;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

interface QuotationInterface {

    static void showAll(QuotationInterface quotation, LocalDate date) {
        try {
            System.out.println("\nDla dnia " + date + " wartość OPEN wynosi: " + quotation.getOpen(date));
            System.out.println("Dla dnia " + date + " wartość LOW wynosi: " + quotation.getLow(date));
            System.out.println("Dla dnia " + date + " wartość HIGH wynosi: " + quotation.getHigh(date));
            System.out.println("Dla dnia " + date + " wartość CLOSE wynosi: " + quotation.getClose(date));
            System.out.println("Dla dnia " + date + " wartość VOLUME wynosi: " + quotation.getVolume(date));
        } catch (NoSuchDateException e) {
            System.out.println("Niepoprawna data lub brak notowania w danym dniu!");
        }
    }

    BigDecimal getOpen(LocalDate date) throws NoSuchDateException;
    BigDecimal getHigh(LocalDate date) throws NoSuchDateException;
    BigDecimal getLow(LocalDate date) throws NoSuchDateException;
    BigDecimal getClose(LocalDate date) throws NoSuchDateException;
    BigDecimal getVolume(LocalDate date) throws NoSuchDateException;
    String getName();
    List<Price> getPrices();

    boolean containsDate(LocalDate date);
}
