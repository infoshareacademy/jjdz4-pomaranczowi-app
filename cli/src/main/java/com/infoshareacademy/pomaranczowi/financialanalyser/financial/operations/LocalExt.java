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

    public void ShowAll(Quotation quotation) {

        System.out.println("\nMaksymalna wartość OPEN to: " +
                getMaxOpen(quotation).getValue() +
                " z dnia " + getMaxOpen(quotation).getDate());
        System.out.println("Minimalna wartość OPEN to: " +
                getMinOpen(quotation).getValue() +
                " z dnia " + getMinOpen(quotation).getDate());

        System.out.println("\nMaksymalna wartość LOW to: " +
                getMaxLow(quotation).getValue() +
                " z dnia " + getMaxLow(quotation).getDate());
        System.out.println("Minimalna wartość LOW to: " +
                getMinLow(quotation).getValue() +
                " z dnia " + getMinLow(quotation).getDate());

        System.out.println("\nMaksymalna wartość HIGH to: " +
                getMaxHigh(quotation).getValue() +
                " z dnia " + getMaxHigh(quotation).getDate());
        System.out.println("Minimalna wartość HIGH to: " +
                getMinHigh(quotation).getValue() +
                " z dnia " + getMinHigh(quotation).getDate());

        System.out.println("\nMaksymalna wartość CLOSE to: " +
                getMaxClose(quotation).getValue() +
                " z dnia " + getMaxClose(quotation).getDate());
        System.out.println("Minimalna wartość CLOSE to: " +
                getMinClose(quotation).getValue() +
                " z dnia " + getMinClose(quotation).getDate());

        System.out.println("\nMaksymalna wartość VOLUME to: " +
                getMaxVolume(quotation).getValue() +
                " z dnia " + getMaxVolume(quotation).getDate());
        System.out.println("Minimalna wartość VOLUME to: " +
                getMinVolume(quotation).getValue() +
                " z dnia " + getMinVolume(quotation).getDate());
    }

    private Extremes getMaxOpen(Quotation quotation) {
        Extremes extremes = new Extremes();

        for (Price x : quotation.getPrices()) {
            if ((x.getDate().isAfter(startDate) || x.getDate().isEqual(startDate)) && (x.getDate().isBefore(endDate) || x.getDate().isEqual(endDate))) {
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
            if ((x.getDate().isAfter(startDate) || x.getDate().isEqual(startDate)) && (x.getDate().isBefore(endDate) || x.getDate().isEqual(endDate))) {
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
            if ((x.getDate().isAfter(startDate) || x.getDate().isEqual(startDate)) && (x.getDate().isBefore(endDate) || x.getDate().isEqual(endDate))) {
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
            if ((x.getDate().isAfter(startDate) || x.getDate().isEqual(startDate)) && (x.getDate().isBefore(endDate) || x.getDate().isEqual(endDate))) {
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
            if ((x.getDate().isAfter(startDate) || x.getDate().isEqual(startDate)) && (x.getDate().isBefore(endDate) || x.getDate().isEqual(endDate)))
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
            if ((x.getDate().isAfter(startDate) || x.getDate().isEqual(startDate)) && (x.getDate().isBefore(endDate) || x.getDate().isEqual(endDate))) {
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
            if ((x.getDate().isAfter(startDate) || x.getDate().isEqual(startDate)) && (x.getDate().isBefore(endDate) || x.getDate().isEqual(endDate))) {
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
            if ((x.getDate().isAfter(startDate) || x.getDate().isEqual(startDate)) && (x.getDate().isBefore(endDate) || x.getDate().isEqual(endDate))) {
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
            if ((x.getDate().isAfter(startDate) || x.getDate().isEqual(startDate)) && (x.getDate().isBefore(endDate) || x.getDate().isEqual(endDate))) {
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
            if ((x.getDate().isAfter(startDate) || x.getDate().isEqual(startDate)) && (x.getDate().isBefore(endDate) || x.getDate().isEqual(endDate))) {
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
