package com.infoshareacademy.pomaranczowi.financialanalyser;

import lombok.Getter;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

class Quotation {

    private List<Price> prices = new ArrayList<>();
    @Setter @Getter private String name;

    static void showAll(Quotation quotation, LocalDate date) {
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

    BigDecimal getOpen(LocalDate date) throws NoSuchDateException {

        return getPrices().parallelStream().filter(x -> x.getDate().equals(date)).
                findFirst().orElseThrow(NoSuchDateException::new).getOpen();
    }

    BigDecimal getHigh(LocalDate date) throws NoSuchDateException {

        return getPrices().parallelStream().filter(x -> x.getDate().equals(date)).
                findFirst().orElseThrow(NoSuchDateException::new).getHigh();
    }

    BigDecimal getLow(LocalDate date) throws NoSuchDateException {

        return getPrices().parallelStream().filter(x -> x.getDate().equals(date)).
                findFirst().orElseThrow(NoSuchDateException::new).getLow();

    }

    BigDecimal getClose(LocalDate date) throws NoSuchDateException {

        return getPrices().parallelStream().filter(x -> x.getDate().equals(date)).
                findFirst().orElseThrow(NoSuchDateException::new).getClose();
    }

    BigDecimal getVolume(LocalDate date) throws NoSuchDateException {

        return getPrices().parallelStream().filter(x -> x.getDate().equals(date)).
                findFirst().orElseThrow(NoSuchDateException::new).getVolume();
    }

    LocalDate firstDate() {
        try {
            return getPrices().get(0).getDate();
        } catch (IndexOutOfBoundsException exception) {
            return null;
        }
    }

    LocalDate lastDate() {

        try {
            return getPrices().get(getPrices().size() - 1).getDate();
        } catch (IndexOutOfBoundsException exception) {
            return null;
        }
    }

    Integer countPrices() {
        return getPrices().size();
    }

    List<Price> getPrices() {

        return prices;
    }

    boolean containsDate(LocalDate date) {

        return getPrices().parallelStream().anyMatch(x -> x.getDate().equals(date));
    }
}