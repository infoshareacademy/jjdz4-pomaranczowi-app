package com.infoshareacademy.pomaranczowi.financialanalyser;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

public class GetGlobalExt {

    
    public static void ShowAll(Quotation quotation) {
        System.out.println("\nMaksymalna wartość OPEN to: "+
                GetGlobalExt.getMaxOpen(quotation).getValue()+" z dnia "+
                GetGlobalExt.getMaxOpen(quotation).getDate());
        System.out.println("Minimalna wartość OPEN to: "+
                GetGlobalExt.getMaxOpen(quotation).getValue()+" z dnia "+
                GetGlobalExt.getMaxOpen(quotation).getDate());

        System.out.println("\nMaksymalna wartość LOW to: "+
                GetGlobalExt.getMaxLow(quotation).getValue()+" z dnia "+
                GetGlobalExt.getMaxLow(quotation).getDate());
        System.out.println("Minimalna wartość LOW to: "+
                GetGlobalExt.getMinLow(quotation).getValue()+" z dnia "+
                GetGlobalExt.getMinLow(quotation).getDate());

        System.out.println("\nMaksymalna wartość HIGH to: "+
                GetGlobalExt.getMaxHigh(quotation).getValue()+" z dnia "+
                GetGlobalExt.getMaxHigh(quotation).getDate());
        System.out.println("Minimalna wartość HIGH to: "+
                GetGlobalExt.getMinHigh(quotation).getValue()+" z dnia "+
                GetGlobalExt.getMinHigh(quotation).getDate());

        System.out.println("\nMaksymalna wartość CLOSE to: "+
                GetGlobalExt.getMaxClose(quotation).getValue()+" z dnia "+
                GetGlobalExt.getMaxClose(quotation).getDate());
        System.out.println("Minimalna wartość CLOSE to: "+
                GetGlobalExt.getMinClose(quotation).getValue()+" z dnia "+
                GetGlobalExt.getMinClose(quotation).getDate());

        System.out.println("\nMaksymalna wartość VOLUME to: "+
                GetGlobalExt.getMaxVolume(quotation).getValue()+" z dnia "+
                GetGlobalExt.getMaxVolume(quotation).getDate());
        System.out.println("Minimalna wartość VOLUME to: "+
                GetGlobalExt.getMinVolume(quotation).getValue()+" z dnia "+
                GetGlobalExt.getMinVolume(quotation).getDate());
    }
    
    public static Extremes getMaxOpen(Quotation quotation) {

        Extremes extremes = new Extremes();
        BigDecimal bigDecimal = quotation.getPrices().get(0).getOpen();
        LocalDate localDate = quotation.getPrices().get(0).getDate();

        extremes.setValue(bigDecimal);
        extremes.setDate(localDate);

        for (Price x : quotation.getPrices()) {
            if(x.getOpen().compareTo(extremes.getValue()) > 0){
                bigDecimal = x.getOpen();
                localDate = x.getDate();
                extremes.setValue(bigDecimal);
                extremes.setDate(localDate);
            }
        }
        return extremes;
    }

    public static Extremes getMaxClose(Quotation quotation) {

        Extremes extremes = new Extremes();
        BigDecimal bigDecimal = quotation.getPrices().get(0).getClose();
        LocalDate localDate = quotation.getPrices().get(0).getDate();

        extremes.setValue(bigDecimal);
        extremes.setDate(localDate);

        for (Price x : quotation.getPrices()) {
            if(x.getClose().compareTo(extremes.getValue()) > 0){
                bigDecimal = x.getClose();
                localDate = x.getDate();
                extremes.setValue(bigDecimal);
                extremes.setDate(localDate);
            }
        }
        return extremes;
    }

    public static Extremes getMaxHigh(Quotation quotation) {

        Extremes extremes = new Extremes();
        BigDecimal bigDecimal = quotation.getPrices().get(0).getHigh();
        LocalDate localDate = quotation.getPrices().get(0).getDate();

        extremes.setValue(bigDecimal);
        extremes.setDate(localDate);

        for (Price x : quotation.getPrices()) {
            if(x.getHigh().compareTo(extremes.getValue()) > 0){
                bigDecimal = x.getHigh();
                localDate = x.getDate();
                extremes.setValue(bigDecimal);
                extremes.setDate(localDate);
            }
        }
        return extremes;
    }

    public static Extremes getMaxLow(Quotation quotation) {

        Extremes extremes = new Extremes();
        BigDecimal bigDecimal = quotation.getPrices().get(0).getLow();
        LocalDate localDate = quotation.getPrices().get(0).getDate();

        extremes.setValue(bigDecimal);
        extremes.setDate(localDate);

        for (Price x : quotation.getPrices()) {
            if(x.getLow().compareTo(extremes.getValue()) > 0){
                bigDecimal = x.getLow();
                localDate = x.getDate();
                extremes.setValue(bigDecimal);
                extremes.setDate(localDate);
            }
        }
        return extremes;
    }

    public static Extremes getMaxVolume(Quotation quotation) {

        Extremes extremes = new Extremes();
        BigDecimal bigDecimal = quotation.getPrices().get(0).getVolume();
        LocalDate localDate = quotation.getPrices().get(0).getDate();

        extremes.setValue(bigDecimal);
        extremes.setDate(localDate);

        for (Price x : quotation.getPrices()) {
            if (x.getVolume().compareTo(extremes.getValue()) > 0){
                bigDecimal = x.getVolume();
                localDate = x.getDate();
                extremes.setValue(bigDecimal);
                extremes.setDate(localDate);
            }
        }
        return extremes;
    }

    public static Extremes getMax(Quotation quotation, String ochlv) { //Open, Close, High, Low, Volume

        Extremes extremes = null;

        switch (ochlv) {
            case "Open":
                extremes = getMaxOpen(quotation);
                break;
            case "Close":
                extremes = getMaxClose(quotation);
                break;
            case "High":
                extremes= getMaxHigh(quotation);
                break;
            case "Low":
                extremes= getMaxLow(quotation);
                break;
            case "Volume":
                extremes= getMaxVolume(quotation);
                break;
        }
        return extremes;
    }


    public static Extremes getMinOpen(Quotation quotation) {

        Extremes extremes = new Extremes();
        BigDecimal bigDecimal = quotation.getPrices().get(0).getOpen();
        LocalDate localDate = quotation.getPrices().get(0).getDate();

        extremes.setValue(bigDecimal);
        extremes.setDate(localDate);

        for (Price x : quotation.getPrices()) {
            if (x.getOpen().compareTo(extremes.getValue()) < 0){
                bigDecimal = x.getOpen();
                localDate = x.getDate();
                extremes.setValue(bigDecimal);
                extremes.setDate(localDate);
            }
        }
        return extremes;
    }

    public static Extremes getMinClose(Quotation quotation) {

        Extremes extremes = new Extremes();
        BigDecimal bigDecimal = quotation.getPrices().get(0).getClose();
        LocalDate localDate = quotation.getPrices().get(0).getDate();

        extremes.setValue(bigDecimal);
        extremes.setDate(localDate);

        for (Price x : quotation.getPrices()) {
            if (x.getClose().compareTo(extremes.getValue()) < 0){
                bigDecimal = x.getClose();
                localDate = x.getDate();
                extremes.setValue(bigDecimal);
                extremes.setDate(localDate);
            }
        }
        return extremes;
    }

    public static Extremes getMinHigh(Quotation quotation) {

        Extremes extremes = new Extremes();
        BigDecimal bigDecimal = quotation.getPrices().get(0).getHigh();
        LocalDate localDate = quotation.getPrices().get(0).getDate();

        extremes.setValue(bigDecimal);
        extremes.setDate(localDate);

        for (Price x : quotation.getPrices()) {
            if (x.getHigh().compareTo(extremes.getValue()) < 0){
                bigDecimal = x.getHigh();
                localDate = x.getDate();
                extremes.setValue(bigDecimal);
                extremes.setDate(localDate);
            }
        }
        return extremes;
    }

    public static Extremes getMinLow(Quotation quotation) {

        Extremes extremes = new Extremes();
        BigDecimal bigDecimal = quotation.getPrices().get(0).getLow();
        LocalDate localDate = quotation.getPrices().get(0).getDate();

        extremes.setValue(bigDecimal);
        extremes.setDate(localDate);

        for (Price x : quotation.getPrices()) {
            if (x.getLow().compareTo(extremes.getValue()) < 0){
                bigDecimal = x.getLow();
                localDate = x.getDate();
                extremes.setValue(bigDecimal);
                extremes.setDate(localDate);
            }
        }
        return extremes;
    }

    public static Extremes getMinVolume(Quotation quotation) {

        Extremes extremes = new Extremes();
        BigDecimal bigDecimal = quotation.getPrices().get(0).getVolume();
        LocalDate localDate = quotation.getPrices().get(0).getDate();

        extremes.setValue(bigDecimal);
        extremes.setDate(localDate);

        for (Price x : quotation.getPrices()) {
            if (x.getVolume().compareTo(extremes.getValue()) < 0){
                bigDecimal = x.getVolume();
                localDate = x.getDate();
                extremes.setValue(bigDecimal);
                extremes.setDate(localDate);
            }
        }
        return extremes;
    }

    public static Extremes getMin(Quotation quotation, String ochlv) { //Open, Close, High, Low, Volume

        Extremes extremes = null;

        switch (ochlv) {
            case "Open":
                extremes = getMinOpen(quotation);
                break;
            case "Close":
                extremes = getMinClose(quotation);
                break;
            case "High":
                extremes= getMinHigh(quotation);
                break;
            case "Low":
                extremes= getMinLow(quotation);
                break;
            case "Volume":
                extremes= getMinVolume(quotation);
                break;
        }
        return extremes;
    }


}
