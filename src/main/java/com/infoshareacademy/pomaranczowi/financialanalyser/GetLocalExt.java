package com.infoshareacademy.pomaranczowi.financialanalyser;

import java.math.BigDecimal;
import java.time.LocalDate;

public class GetLocalExt {

    private static LocalDate startDate;
    private static LocalDate endDate;

    public static void ShowAll(Quotation quotation) {

        System.out.println("\nMaksymalna wartość OPEN to: " +
                GetLocalExt.getMaxOpen(quotation).getValue() +
                " z dnia " + GetLocalExt.getMaxOpen(quotation).getDate());
        System.out.println("Minimalna wartość OPEN to: " +
                GetLocalExt.getMaxOpen(quotation).getValue() +
                " z dnia " + GetLocalExt.getMinOpen(quotation).getDate());

        System.out.println("\nMaksymalna wartość LOW to: " +
                GetLocalExt.getMaxLow(quotation).getValue() +
                " z dnia " + GetLocalExt.getMaxLow(quotation).getDate());
        System.out.println("Minimalna wartość LOW to: " +
                GetLocalExt.getMinLow(quotation).getValue() +
                " z dnia " + GetLocalExt.getMinLow(quotation).getDate());

        System.out.println("\nMaksymalna wartość HIGH to: " +
                GetLocalExt.getMaxHigh(quotation).getValue() +
                " z dnia " + GetLocalExt.getMaxHigh(quotation).getDate());
        System.out.println("Minimalna wartość HIGH to: " +
                GetLocalExt.getMinHigh(quotation).getValue() +
                " z dnia " + GetLocalExt.getMinHigh(quotation).getDate());

        System.out.println("\nMaksymalna wartość CLOSE to: " +
                GetLocalExt.getMaxClose(quotation).getValue() +
                " z dnia " + GetLocalExt.getMaxClose(quotation).getDate());
        System.out.println("Minimalna wartość CLOSE to: " +
                GetLocalExt.getMinClose(quotation).getValue() +
                " z dnia " + GetLocalExt.getMinClose(quotation).getDate());

        System.out.println("\nMaksymalna wartość VOLUME to: " +
                GetLocalExt.getMaxVolume(quotation).getValue() +
                " z dnia " + GetLocalExt.getMaxVolume(quotation).getDate());
        System.out.println("Minimalna wartość VOLUME to: " +
                GetLocalExt.getMinVolume(quotation).getValue() +
                " z dnia " + GetLocalExt.getMinVolume(quotation).getDate());
    }

    public static Extremes getMaxOpen(Quotation quotation) {
        Extremes extremes = new Extremes();
        BigDecimal bigDecimal;
        LocalDate localDate;

        for (Price x : quotation.getPrices()) {
            if ((x.getDate().isAfter(startDate) || x.getDate().isEqual(startDate)) && (x.getDate().isBefore(endDate) || x.getDate().isEqual(endDate))) {
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

    public static Extremes getMaxClose(Quotation quotation) {
        Extremes extremes = new Extremes();
        BigDecimal bigDecimal;
        LocalDate localDate;

        for (Price x : quotation.getPrices()) {
            if ((x.getDate().isAfter(startDate) || x.getDate().isEqual(startDate)) && (x.getDate().isBefore(endDate) || x.getDate().isEqual(endDate))) {
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

    public static Extremes getMaxHigh(Quotation quotation) {
        Extremes extremes = new Extremes();
        BigDecimal bigDecimal;
        LocalDate localDate;

        for (Price x : quotation.getPrices()) {
            if ((x.getDate().isAfter(startDate) || x.getDate().isEqual(startDate)) && (x.getDate().isBefore(endDate) || x.getDate().isEqual(endDate))) {
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

    public static Extremes getMaxLow(Quotation quotation) {
        Extremes extremes = new Extremes();
        BigDecimal bigDecimal;
        LocalDate localDate;

        for (Price x : quotation.getPrices()) {
            if ((x.getDate().isAfter(startDate) || x.getDate().isEqual(startDate)) && (x.getDate().isBefore(endDate) || x.getDate().isEqual(endDate))) {
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

    public static Extremes getMaxVolume(Quotation quotation) {
        BigDecimal bigDecimal;
        LocalDate localDate;
        Extremes extremes = new Extremes();

        for (Price x : quotation.getPrices()) {
            if ((x.getDate().isAfter(startDate) || x.getDate().isEqual(startDate)) && (x.getDate().isBefore(endDate) || x.getDate().isEqual(endDate))) {
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

    public static Extremes getMax(Quotation quotation, ExtremesParams p) { //ochlv - Open, Close, High, Low, Volume

        Extremes extremes = null;

        switch (p) {
            case OPEN:
                extremes = getMaxOpen(quotation);
                break;
            case CLOSE:
                extremes = getMaxClose(quotation);
                break;
            case HIGH:
                extremes = getMaxHigh(quotation);
                break;
            case LOW:
                extremes = getMaxLow(quotation);
                break;
            case VOLUME:
                extremes = getMaxVolume(quotation);
                break;
        }
        return extremes;
    }

    public static Extremes getMinOpen(Quotation quotation) {
        Extremes extremes = new Extremes();
        BigDecimal bigDecimal = BigDecimal.valueOf(0);
        LocalDate localDate;
        extremes.setValue(bigDecimal);

        for (Price x : quotation.getPrices()) {
            if ((x.getDate().isAfter(startDate) || x.getDate().isEqual(startDate)) && (x.getDate().isBefore(endDate) || x.getDate().isEqual(endDate))) {
                if (extremes.getValue().compareTo(BigDecimal.ZERO) == 0) {
                    extremes.setValue(x.getOpen());
                    extremes.setDate(x.getDate());
                }
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

    public static Extremes getMinClose(Quotation quotation) {
        Extremes extremes = new Extremes();
        BigDecimal bigDecimal = BigDecimal.valueOf(0);
        LocalDate localDate;
        extremes.setValue(bigDecimal);

        for (Price x : quotation.getPrices()) {
            if ((x.getDate().isAfter(startDate) || x.getDate().isEqual(startDate)) && (x.getDate().isBefore(endDate) || x.getDate().isEqual(endDate))) {
                if (extremes.getValue().compareTo(BigDecimal.ZERO) == 0) {
                    extremes.setValue(x.getClose());
                    extremes.setDate(x.getDate());
                }
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

    public static Extremes getMinHigh(Quotation quotation) {
        Extremes extremes = new Extremes();
        BigDecimal bigDecimal = BigDecimal.valueOf(0);
        LocalDate localDate;
        extremes.setValue(bigDecimal);

        for (Price x : quotation.getPrices()) {
            if ((x.getDate().isAfter(startDate) || x.getDate().isEqual(startDate)) && (x.getDate().isBefore(endDate) || x.getDate().isEqual(endDate))) {
                if (extremes.getValue().compareTo(BigDecimal.ZERO) == 0) {
                    extremes.setValue(x.getHigh());
                    extremes.setDate(x.getDate());
                }
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

    public static Extremes getMinLow(Quotation quotation) {
        Extremes extremes = new Extremes();
        BigDecimal bigDecimal = BigDecimal.valueOf(0);
        LocalDate localDate;
        extremes.setValue(bigDecimal);

        for (Price x : quotation.getPrices()) {
            if ((x.getDate().isAfter(startDate) || x.getDate().isEqual(startDate)) && (x.getDate().isBefore(endDate) || x.getDate().isEqual(endDate))) {
                if (extremes.getValue().compareTo(BigDecimal.ZERO) == 0) {
                    extremes.setValue(x.getLow());
                    extremes.setDate(x.getDate());
                }
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

    public static Extremes getMinVolume(Quotation quotation) {
        Extremes extremes = new Extremes();
        BigDecimal bigDecimal = BigDecimal.valueOf(0);
        LocalDate localDate;
        extremes.setValue(bigDecimal);

        for (Price x : quotation.getPrices()) {
            if ((x.getDate().isAfter(startDate) || x.getDate().isEqual(startDate)) && (x.getDate().isBefore(endDate) || x.getDate().isEqual(endDate))) {
                if (extremes.getValue().compareTo(BigDecimal.ZERO) == 0) {
                    extremes.setValue(x.getVolume());
                    extremes.setDate(x.getDate());
                }
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

    public static Extremes getMin(Quotation quotation, ExtremesParams p) { //Open, Close, High, Low, Volume

        Extremes extremes = null;

        switch (p) {
            case OPEN:
                extremes = getMinOpen(quotation);
                break;
            case CLOSE:
                extremes = getMinClose(quotation);
                break;
            case HIGH:
                extremes = getMinHigh(quotation);
                break;
            case LOW:
                extremes = getMinLow(quotation);
                break;
            case VOLUME:
                extremes = getMinVolume(quotation);
                break;
        }
        return extremes;
    }

    static LocalDate getStartDate() {
        return startDate;
    }

    static void setStartDate(LocalDate startDate) {
        GetLocalExt.startDate = startDate;
    }

    static LocalDate getEndDate() {
        return endDate;
    }

    static void setEndDate(LocalDate endDate) {
        GetLocalExt.endDate = endDate;
    }

    enum ExtremesParams {
        OPEN, CLOSE, HIGH, LOW, VOLUME
    }
}
