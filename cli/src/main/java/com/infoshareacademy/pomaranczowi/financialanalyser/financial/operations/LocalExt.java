package com.infoshareacademy.pomaranczowi.financialanalyser.financial.operations;

import com.infoshareacademy.pomaranczowi.financialanalyser.financial.domain.Extremes;
import com.infoshareacademy.pomaranczowi.financialanalyser.financial.domain.Price;
import com.infoshareacademy.pomaranczowi.financialanalyser.financial.domain.Quotation;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

public class LocalExt {

    @Setter @Getter private LocalDate startDate;
    @Setter @Getter private LocalDate endDate;

    private static void printGroup(Extremes max, Extremes min, String groupName) {
        System.out.println("\nMaksymalna wartoæ " + groupName + " to: " + max.getValue() + " z dnia " + max.getDate());
        System.out.println("Minimalna wartoæ " + groupName + " to: " + min.getValue() + " z dnia " + min.getDate());
    }

    public void showAll(Quotation quotation) {
        printGroup(getMaxOpen(quotation), getMinOpen(quotation), "OPEN");
        printGroup(getMaxLow(quotation), getMinLow(quotation), "LOW");
        printGroup(getMaxHigh(quotation), getMinHigh(quotation), "HIGH");
        printGroup(getMaxClose(quotation), getMinClose(quotation), "CLOSE");
        printGroup(getMaxVolume(quotation), getMinVolume(quotation), "VOLUME");
    }

    private boolean isBetween(Price x, LocalDate startDate, LocalDate endDate) {
        Boolean isBetween = false;
        if ((x.getDate().isAfter(startDate) || x.getDate().isEqual(startDate)) && (x.getDate().isBefore(endDate) || x.getDate().isEqual(endDate))) {
            isBetween = true;
        }
        return isBetween;
    }

    private Extremes getMaxOpen(Quotation quotation) {
        Extremes extremes = new Extremes();
        for (Price x : quotation.getPrices()) {
            if (isBetween(x, startDate, endDate)) {
                if (x.getOpen().compareTo(extremes.getValue()) > 0) {
                    extremes.setValue(x.getOpen());
                    extremes.setDate(x.getDate());
                }
            }
        }
        return extremes;
    }

    private Extremes getMaxClose(Quotation quotation) {
        Extremes extremes = new Extremes();
        for (Price x : quotation.getPrices()) {
            if (isBetween(x, startDate, endDate)) {
                if (x.getClose().compareTo(extremes.getValue()) > 0) {
                    extremes.setValue(x.getClose());
                    extremes.setDate(x.getDate());
                }
            }
        }
        return extremes;
    }

    private Extremes getMaxHigh(Quotation quotation) {
        Extremes extremes = new Extremes();
        for (Price x : quotation.getPrices()) {
            if (isBetween(x, startDate, endDate)) {
                if (x.getHigh().compareTo(extremes.getValue()) > 0) {
                    extremes.setValue(x.getHigh());
                    extremes.setDate(x.getDate());
                }
            }
        }
        return extremes;
    }

    private Extremes getMaxLow(Quotation quotation) {
        Extremes extremes = new Extremes();
        for (Price x : quotation.getPrices()) {
            if (isBetween(x, startDate, endDate)) {
                if (x.getLow().compareTo(extremes.getValue()) > 0) {
                    extremes.setValue(x.getLow());
                    extremes.setDate(x.getDate());
                }
            }
        }
        return extremes;
    }

    private Extremes getMaxVolume(Quotation quotation) {
        Extremes extremes = new Extremes();
        for (Price x : quotation.getPrices()) {
            if (isBetween(x, startDate, endDate))
                if (extremes.getValue().compareTo(BigDecimal.ZERO) == 0) {
                    extremes.setValue(x.getVolume());
                    extremes.setDate(x.getDate());
                }
            if (x.getVolume().compareTo(extremes.getValue()) > 0) {
                extremes.setValue(x.getVolume());
                extremes.setDate(x.getDate());
            }
        }
        return extremes;
    }

    private Extremes getMinOpen(Quotation quotation) {
        Extremes extremes = new Extremes();
        BigDecimal bigDecimal = BigDecimal.valueOf(0);
        extremes.setValue(bigDecimal);
        for (Price x : quotation.getPrices()) {
            if (isBetween(x, startDate, endDate)) {
                if (extremes.getValue().compareTo(BigDecimal.ZERO) == 0) {
                    extremes.setValue(x.getOpen());
                    extremes.setDate(x.getDate());
                }
                if (x.getOpen().compareTo(extremes.getValue()) < 0) {
                    extremes.setValue(x.getOpen());
                    extremes.setDate(x.getDate());
                }
            }
        }
        return extremes;
    }

    private Extremes getMinClose(Quotation quotation) {
        Extremes extremes = new Extremes();
        BigDecimal bigDecimal = BigDecimal.valueOf(0);
        extremes.setValue(bigDecimal);
        for (Price x : quotation.getPrices()) {
            if (isBetween(x, startDate, endDate)) {
                if (extremes.getValue().compareTo(BigDecimal.ZERO) == 0) {
                    extremes.setValue(x.getClose());
                    extremes.setDate(x.getDate());
                }
                if (x.getClose().compareTo(extremes.getValue()) < 0) {
                    extremes.setValue(x.getClose());
                    extremes.setDate(x.getDate());
                }
            }
        }
        return extremes;
    }

    private Extremes getMinHigh(Quotation quotation) {
        Extremes extremes = new Extremes();
        BigDecimal bigDecimal = BigDecimal.valueOf(0);
        extremes.setValue(bigDecimal);
        for (Price x : quotation.getPrices()) {
            if (isBetween(x, startDate, endDate)) {
                if (extremes.getValue().compareTo(BigDecimal.ZERO) == 0) {
                    extremes.setValue(x.getHigh());
                    extremes.setDate(x.getDate());
                }
                if (x.getHigh().compareTo(extremes.getValue()) < 0) {
                    extremes.setValue(x.getHigh());
                    extremes.setDate(x.getDate());
                }
            }
        }
        return extremes;
    }

    private Extremes getMinLow(Quotation quotation) {
        Extremes extremes = new Extremes();
        BigDecimal bigDecimal = BigDecimal.valueOf(0);
        extremes.setValue(bigDecimal);
        for (Price x : quotation.getPrices()) {
            if (isBetween(x, startDate, endDate)) {
                if (extremes.getValue().compareTo(BigDecimal.ZERO) == 0) {
                    extremes.setValue(x.getLow());
                    extremes.setDate(x.getDate());
                }
                if (x.getLow().compareTo(extremes.getValue()) < 0) {
                    extremes.setValue(x.getLow());
                    extremes.setDate(x.getDate());
                }
            }
        }
        return extremes;
    }

    private Extremes getMinVolume(Quotation quotation) {
        Extremes extremes = new Extremes();
        BigDecimal bigDecimal = BigDecimal.valueOf(0);
        extremes.setValue(bigDecimal);
        for (Price x : quotation.getPrices()) {
            if (isBetween(x, startDate, endDate)) {
                if (extremes.getValue().compareTo(BigDecimal.ZERO) == 0) {
                    extremes.setValue(x.getVolume());
                    extremes.setDate(x.getDate());
                }
                if (x.getVolume().compareTo(extremes.getValue()) < 0) {
                    extremes.setValue(x.getVolume());
                    extremes.setDate(x.getDate());
                }
            }
        }
        return extremes;
    }
}