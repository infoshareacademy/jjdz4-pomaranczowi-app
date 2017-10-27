package com.infoshareacademy.pomaranczowi.financialanalyser;

import java.math.BigDecimal;
import java.time.LocalDate;

public class GetLocalExt {

    enum ExtremesParams{
        Open,Close,High,Low,Volume
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