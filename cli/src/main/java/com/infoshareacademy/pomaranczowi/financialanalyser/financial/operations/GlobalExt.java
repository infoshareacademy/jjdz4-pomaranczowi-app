package com.infoshareacademy.pomaranczowi.financialanalyser.financial.operations;

import com.infoshareacademy.pomaranczowi.financialanalyser.financial.domain.Extremes;
import com.infoshareacademy.pomaranczowi.financialanalyser.financial.domain.Price;
import com.infoshareacademy.pomaranczowi.financialanalyser.financial.domain.Quotation;

import java.math.BigDecimal;
import java.time.LocalDate;

public class GlobalExt {

    
    public static void ShowAll(Quotation quotation) {

        Extremes maxOpen = GlobalExt.getMaxOpen(quotation);
        System.out.println("\nMaksymalna wartość OPEN to: "+
                maxOpen.getValue()+" z dnia "+
                maxOpen.getDate());
        Extremes minOpen = GlobalExt.getMinOpen(quotation);
        System.out.println("Minimalna wartość OPEN to: "+
                minOpen.getValue()+" z dnia "+
                minOpen.getDate());

        Extremes maxLow = GlobalExt.getMaxLow(quotation);
        System.out.println("\nMaksymalna wartość LOW to: "+
                maxLow.getValue()+" z dnia "+
                maxLow.getDate());
        Extremes minLow = GlobalExt.getMinLow(quotation);
        System.out.println("Minimalna wartość LOW to: "+
                minLow.getValue()+" z dnia "+
                minLow.getDate());

        Extremes maxHigh = GlobalExt.getMaxHigh(quotation);
        System.out.println("\nMaksymalna wartość HIGH to: "+
                maxHigh.getValue()+" z dnia "+
                maxHigh.getDate());
        Extremes minHigh = GlobalExt.getMinHigh(quotation);
        System.out.println("Minimalna wartość HIGH to: "+
                minHigh.getValue()+" z dnia "+
                minHigh.getDate());

        Extremes maxClose = GlobalExt.getMaxClose(quotation);
        System.out.println("\nMaksymalna wartość CLOSE to: "+
                maxClose.getValue()+" z dnia "+
                maxClose.getDate());
        Extremes minClose = GlobalExt.getMinClose(quotation);
        System.out.println("Minimalna wartość CLOSE to: "+
                minClose.getValue()+" z dnia "+
                minClose.getDate());

        Extremes maxVolume = GlobalExt.getMaxVolume(quotation);
        System.out.println("\nMaksymalna wartość VOLUME to: "+
                maxVolume.getValue()+" z dnia "+
                maxVolume.getDate());
        Extremes minVolume = GlobalExt.getMinVolume(quotation);
        System.out.println("Minimalna wartość VOLUME to: "+
                minVolume.getValue()+" z dnia "+
                minVolume.getDate());
    }
    
    private static Extremes getMaxOpen(Quotation quotation) {

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

    private static Extremes getMaxClose(Quotation quotation) {

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

    private static Extremes getMaxHigh(Quotation quotation) {

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

    private static Extremes getMaxLow(Quotation quotation) {

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

    private static Extremes getMaxVolume(Quotation quotation) {

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

    private static Extremes getMinOpen(Quotation quotation) {

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

    private static Extremes getMinClose(Quotation quotation) {

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

    private static Extremes getMinHigh(Quotation quotation) {

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

    private static Extremes getMinLow(Quotation quotation) {

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

    private static Extremes getMinVolume(Quotation quotation) {

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
}
