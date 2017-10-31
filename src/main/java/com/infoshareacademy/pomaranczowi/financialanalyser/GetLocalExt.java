package com.infoshareacademy.pomaranczowi.financialanalyser;

import com.sun.xml.internal.bind.v2.TODO;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class GetLocalExt {

    private static LocalDate startDate;
    private static LocalDate endDate;

    public static LocalDate getStartDate() {
        return startDate;
    }

    public static LocalDate getEndDate() {
        return endDate;
    }

    enum ExtremesParams {
        OPEN, CLOSE, HIGH, LOW, VOLUME
    }

    static void getDatesFromUser() {

        boolean dataOk = false;
        DateTimeFormatter ft1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        System.out.println("Podaj początkową datę w formacie YYYY-MM-DD");
        while (!dataOk) {
            Scanner odczytScanner = new Scanner(System.in);
            try {
                startDate = LocalDate.parse(odczytScanner.nextLine(), ft1);
                dataOk = true;
            } catch (DateTimeParseException exc) {
                System.out.println("Podaj datę w formacie YYYY-MM-DD\nSpróbuj ponownie");
            }
        }

        dataOk = false;
        System.out.println("Podaj końcową datę w formacie YYYY-MM-DD");
        while (!dataOk) {
            Scanner odczytScanner = new Scanner(System.in);
            try {
                endDate = LocalDate.parse(odczytScanner.nextLine(), ft1);
                if(endDate.isAfter(startDate)||endDate.isEqual(startDate))
                    dataOk = true;
                else System.out.println("Data końcowa musi być większa lub równa dacie początku ("+startDate+")\n" +
                        "Spróbuj ponownie - Podaj końcową datę w formacie YYYY-MM-DD");
            } catch (DateTimeParseException exc) {
                System.out.println("Podaj datę w formacie YYYY-MM-DD\nSpróbuj ponownie");
            }
        }
    }

    public static Extremes getMaxOpen(Quotation quotation, LocalDate from, LocalDate to) {
        Extremes extremes = new Extremes();
        BigDecimal bigDecimal;
        LocalDate localDate;

        for (Price x : quotation.getPrices()) {
            if ((x.getDate().isAfter(from) || x.getDate().isEqual(from)) && (x.getDate().isBefore(to) || x.getDate().isEqual(to))) {
                if (x.getOpen().compareTo(extremes.getValue()) > 0) {
                    bigDecimal = x.getOpen();
                    localDate = x.getDate();
                    extremes.setValue(bigDecimal);
                    extremes.setDate(localDate);
                }
            }
        }
        return extremes;
    }

    public static Extremes getMaxClose(Quotation quotation, LocalDate from, LocalDate to) {
        Extremes extremes = new Extremes();
        BigDecimal bigDecimal;
        LocalDate localDate;

        for (Price x : quotation.getPrices()) {
            if ((x.getDate().isAfter(from) || x.getDate().isEqual(from)) && (x.getDate().isBefore(to) || x.getDate().isEqual(to))) {
                if (x.getClose().compareTo(extremes.getValue()) > 0) {
                    bigDecimal = x.getClose();
                    localDate = x.getDate();
                    extremes.setValue(bigDecimal);
                    extremes.setDate(localDate);
                }
            }
        }
        return extremes;
    }

    public static Extremes getMaxHigh(Quotation quotation, LocalDate from, LocalDate to) {
        Extremes extremes = new Extremes();
        BigDecimal bigDecimal;
        LocalDate localDate;

        for (Price x : quotation.getPrices()) {
            if ((x.getDate().isAfter(from) || x.getDate().isEqual(from)) && (x.getDate().isBefore(to) || x.getDate().isEqual(to))) {
                if (x.getHigh().compareTo(extremes.getValue()) > 0) {
                    bigDecimal = x.getHigh();
                    localDate = x.getDate();
                    extremes.setValue(bigDecimal);
                    extremes.setDate(localDate);
                }
            }
        }
        return extremes;
    }

    public static Extremes getMaxLow(Quotation quotation, LocalDate from, LocalDate to) {
        Extremes extremes = new Extremes();
        BigDecimal bigDecimal;
        LocalDate localDate;

        for (Price x : quotation.getPrices()) {
            if ((x.getDate().isAfter(from) || x.getDate().isEqual(from)) && (x.getDate().isBefore(to) || x.getDate().isEqual(to))) {
                if (x.getLow().compareTo(extremes.getValue()) > 0) {
                    bigDecimal = x.getLow();
                    localDate = x.getDate();
                    extremes.setValue(bigDecimal);
                    extremes.setDate(localDate);
                }
            }
        }
        return extremes;
    }

    public static Extremes getMaxVolume(Quotation quotation, LocalDate from, LocalDate to) {
        BigDecimal bigDecimal;
        LocalDate localDate;
        Extremes extremes = new Extremes();

        for (Price x : quotation.getPrices()) {
            if ((x.getDate().isAfter(from) || x.getDate().isEqual(from)) && (x.getDate().isBefore(to) || x.getDate().isEqual(to))) {
                if (x.getVolume().compareTo(extremes.getValue()) > 0) {
                    bigDecimal = x.getVolume();
                    localDate = x.getDate();
                    extremes.setValue(bigDecimal);
                    extremes.setDate(localDate);
                }
            }
        }
        return extremes;
    }

    public static Extremes getMax(Quotation quotation, LocalDate from, LocalDate to, ExtremesParams p) { //ochlv - Open, Close, High, Low, Volume

        Extremes extremes = null;

        switch (p) {
            case Open:
                extremes = getMaxOpen(quotation, from, to);
                break;
            case Close:
                extremes = getMaxClose(quotation, from, to);
                break;
            case High:
                extremes = getMaxHigh(quotation, from, to);
                break;
            case Low:
                extremes = getMaxLow(quotation, from, to);
                break;
            case Volume:
                extremes = getMaxVolume(quotation, from, to);
                break;
        }
        return extremes;
    }

    public static Extremes getMinOpen(Quotation quotation, LocalDate from, LocalDate to) {
        Extremes extremes = new Extremes();
        BigDecimal bigDecimal;
        LocalDate localDate;

        for (Price x : quotation.getPrices()) {
            if ((x.getDate().isAfter(from) || x.getDate().isEqual(from)) && (x.getDate().isBefore(to) || x.getDate().isEqual(to))) {
                if (x.getOpen().compareTo(extremes.getValue()) < 0) {
                    bigDecimal = x.getOpen();
                    localDate = x.getDate();
                    extremes.setValue(bigDecimal);
                    extremes.setDate(localDate);
                }
            }
        }
        return extremes;
    }

    public static Extremes getMinClose(Quotation quotation, LocalDate from, LocalDate to) {
        Extremes extremes = new Extremes();
        BigDecimal bigDecimal;
        LocalDate localDate;

        for (Price x : quotation.getPrices()) {
            if ((x.getDate().isAfter(from) || x.getDate().isEqual(from)) && (x.getDate().isBefore(to) || x.getDate().isEqual(to))) {
                if (x.getClose().compareTo(extremes.getValue()) < 0) {
                    bigDecimal = x.getClose();
                    localDate = x.getDate();
                    extremes.setValue(bigDecimal);
                    extremes.setDate(localDate);
                }
            }
        }
        return extremes;
    }

    public static Extremes getMinHigh(Quotation quotation, LocalDate from, LocalDate to) {
        Extremes extremes = new Extremes();
        BigDecimal bigDecimal;
        LocalDate localDate;

        for (Price x : quotation.getPrices()) {
            if ((x.getDate().isAfter(from) || x.getDate().isEqual(from)) && (x.getDate().isBefore(to) || x.getDate().isEqual(to))) {
                if (x.getHigh().compareTo(extremes.getValue()) < 0) {
                    bigDecimal = x.getHigh();
                    localDate = x.getDate();
                    extremes.setValue(bigDecimal);
                    extremes.setDate(localDate);
                }
            }
        }
        return extremes;
    }

    public static Extremes getMinLow(Quotation quotation, LocalDate from, LocalDate to) {
        Extremes extremes = new Extremes();
        BigDecimal bigDecimal;
        LocalDate localDate;

        for (Price x : quotation.getPrices()) {
            if ((x.getDate().isAfter(from) || x.getDate().isEqual(from)) && (x.getDate().isBefore(to) || x.getDate().isEqual(to))) {
                if (x.getLow().compareTo(extremes.getValue()) < 0) {
                    bigDecimal = x.getLow();
                    localDate = x.getDate();
                    extremes.setValue(bigDecimal);
                    extremes.setDate(localDate);
                }
            }
        }
        return extremes;
    }

    public static Extremes getMinVolume(Quotation quotation, LocalDate from, LocalDate to) {
        Extremes extremes = new Extremes();
        BigDecimal bigDecimal;
        LocalDate localDate;

        for (Price x : quotation.getPrices()) {
            if ((x.getDate().isAfter(from) || x.getDate().isEqual(from)) && (x.getDate().isBefore(to) || x.getDate().isEqual(to))) {
                if (x.getVolume().compareTo(extremes.getValue()) < 0) {
                    bigDecimal = x.getVolume();
                    localDate = x.getDate();
                    extremes.setValue(bigDecimal);
                    extremes.setDate(localDate);
                }
            }
        }
        return extremes;
    }

    public static Extremes getMin(Quotation quotation, LocalDate from, LocalDate to, ExtremesParams p) { //Open, Close, High, Low, Volume

        Extremes extremes = null;

        switch (p) {
            case Open:
                extremes = getMinOpen(quotation, from, to);
                break;
            case Close:
                extremes = getMinClose(quotation, from, to);
                break;
            case High:
                extremes = getMinHigh(quotation, from, to);
                break;
            case Low:
                extremes = getMinLow(quotation, from, to);
                break;
            case Volume:
                extremes = getMinVolume(quotation, from, to);
                break;
        }
        return extremes;
    }
}
