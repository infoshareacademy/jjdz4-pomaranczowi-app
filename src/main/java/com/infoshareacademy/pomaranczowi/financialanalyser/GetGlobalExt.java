package com.infoshareacademy.pomaranczowi.financialanalyser;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

public class GetGlobalExt {

    
    public static void ShowAll(Quotation quotation) {
        Extremes maxOpen = GetGlobalExt.getMaxOpen(quotation);
        System.out.println("\nMaksymalna wartość OPEN to: "+
                maxOpen.getValue()+" z dnia "+
                maxOpen.getDate());
        Extremes minOpen = GetGlobalExt.getMinOpen(quotation);
        System.out.println("Minimalna wartość OPEN to: "+
                minOpen.getValue()+" z dnia "+
                minOpen.getDate());

        Extremes maxLow = GetGlobalExt.getMaxLow(quotation);
        System.out.println("\nMaksymalna wartość LOW to: "+
                maxLow.getValue()+" z dnia "+
                maxLow.getDate());
        Extremes minLow = GetGlobalExt.getMinLow(quotation);
        System.out.println("Minimalna wartość LOW to: "+
                minLow.getValue()+" z dnia "+
                minLow.getDate());

        Extremes maxHigh = GetGlobalExt.getMaxHigh(quotation);
        System.out.println("\nMaksymalna wartość HIGH to: "+
                maxHigh.getValue()+" z dnia "+
                maxHigh.getDate());
        Extremes minHigh = GetGlobalExt.getMinHigh(quotation);
        System.out.println("Minimalna wartość HIGH to: "+
                minHigh.getValue()+" z dnia "+
                minHigh.getDate());

        Extremes maxClose = GetGlobalExt.getMaxClose(quotation);
        System.out.println("\nMaksymalna wartość CLOSE to: "+
                maxClose.getValue()+" z dnia "+
                maxClose.getDate());
        Extremes minClose = GetGlobalExt.getMinClose(quotation);
        System.out.println("Minimalna wartość CLOSE to: "+
                minClose.getValue()+" z dnia "+
                minClose.getDate());

        Extremes maxVolume = GetGlobalExt.getMaxVolume(quotation);
        System.out.println("\nMaksymalna wartość VOLUME to: "+
                maxVolume.getValue()+" z dnia "+
                maxVolume.getDate());
        Extremes minVolume = GetGlobalExt.getMinVolume(quotation);
        System.out.println("Minimalna wartość VOLUME to: "+
                minVolume.getValue()+" z dnia "+
                minVolume.getDate());
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
                extremes.setValue(x.getVolume());
                extremes.setDate(x.getDate());
            }
        }
        return extremes;
    }

    public Extremes getMax(Quotation quotation, String ochlv) { //Open, Close, High, Low, Volume

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
                extremes.setValue(x.getHigh());
                extremes.setDate(x.getDate());
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
                extremes.setValue(x.getLow());
                extremes.setDate(x.getDate());
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
                extremes.setValue(x.getVolume());
                extremes.setDate(x.getDate());
            }
        }
        return extremes;
    }

    public Extremes getMin(Quotation quotation, String ochlv) { //Open, Close, High, Low, Volume

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
