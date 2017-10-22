package com.infoshareacademy.pomaranczowi.financialanalyser;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Currency class operates on Price objects
class Currency {

    //ArrayList of Price objects
    private ArrayList<Price> prices = new ArrayList<>();

    //File load on Currency creation
    public Currency(String path) {

        File file = new File(path);
        Scanner fileScanner = null;
        try {
            fileScanner = new Scanner(file);
            System.out.println("Wczytano plik: " + path);
        } catch (FileNotFoundException e) {
            System.out.println("Nie znaleziono pliku: " + path);
        }

        Pattern pattern = Pattern.compile("^([A-Z]{3}),([0-9]{8}),([0-9]\\.[0-9]{4}),([0-9]\\.[0-9]{4}),([0-9]\\.[0-9]{4}),([0-9]\\.[0-9]{4}),([0-9]+.?[0-9]*)$");

        try {
            while (fileScanner.hasNextLine()) {

                Matcher matcher = pattern.matcher(fileScanner.nextLine());
                if (matcher.matches()) {
                    Price price = new Price();

                    price.setName(matcher.group(1));
                    price.setDate(matcher.group(2));
                    price.setOpen(new BigDecimal(matcher.group(3)));
                    price.setHigh(new BigDecimal(matcher.group(4)));
                    price.setLow(new BigDecimal(matcher.group(5)));
                    price.setClose(new BigDecimal(matcher.group(6)));
                    price.setVolume(new BigDecimal(matcher.group(7)));

                    prices.add(price);

                }
            }
        } catch (NullPointerException exception) {

        }

    }

    //returns Price object for demanded date (in String), if no object returns null
    public Price getPrice(String date) {
        int i = 0;

        LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyMMdd"));
        for (Price x : prices) {
            if (localDate.equals(x.getDate())) {
                return prices.get(i);
            }
            i++;
        }
        return null;
    }

    public BigDecimal getOpen(String date) {
        int i = 0;
        LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyMMdd"));
        for (Price x : prices) {
            if (localDate.equals(x.getDate())) {
                return x.getOpen();
            }
            i++;
        }
        return null;
    }

    public BigDecimal getHigh(String date) {
        int i = 0;
        LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyMMdd"));
        for (Price x : prices) {
            if (localDate.equals(x.getDate())) {
                return x.getHigh();
            }
            i++;
        }
        return null;
    }

    public BigDecimal getLow(String date) {
        int i = 0;
        LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyMMdd"));
        for (Price x : prices) {
            if (localDate.equals(x.getDate())) {
                return x.getLow();
            }
            i++;
        }
        return null;
    }

    public BigDecimal getClose(String date) {
        int i = 0;
        LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyMMdd"));
        for (Price x : prices) {
            if (localDate.equals(x.getDate())) {
                return x.getClose();
            }
            i++;
        }
        return null;
    }

    public String firstDate() {
        try {
            return prices.get(1).getDate().toString();
        } catch (IndexOutOfBoundsException exception) {
            return null;
        }
    }

    public String lastDate() {

        try {
            return prices.get(prices.size() - 1).getDate().toString();
        } catch (IndexOutOfBoundsException exception) {
            return null;
        }
    }

    public String getName() {
        return prices.get(1).getName();
    }

    public Integer countPrices() {
        return prices.size();
    }

    public void addPrice(Price price) {
        prices.add(price);
    }

    // -- tmk
    public Extremes getMinOpen() {

        Extremes extremes = new Extremes();
        BigDecimal bigDecimal = prices.get(0).getOpen();
        LocalDate localDate = prices.get(0).getDate();

        extremes.setValue(bigDecimal);
        extremes.setDate(localDate);

        for (Price x : prices) {
            if (x.getOpen().doubleValue() < extremes.getValue().doubleValue()) {
                bigDecimal = x.getOpen();
                localDate = x.getDate();
                extremes.setValue(bigDecimal);
                extremes.setDate(localDate);
            }
        }
        return extremes;
    }
    public Extremes getMinClose() {

        Extremes extremes = new Extremes();
        BigDecimal bigDecimal = prices.get(0).getClose();
        LocalDate localDate = prices.get(0).getDate();

        extremes.setValue(bigDecimal);
        extremes.setDate(localDate);

        for (Price x : prices) {
            if (x.getClose().doubleValue() < extremes.getValue().doubleValue()) {
                bigDecimal = x.getClose();
                localDate = x.getDate();
                extremes.setValue(bigDecimal);
                extremes.setDate(localDate);
            }
        }
        return extremes;
    }
    public Extremes getMinHigh() {

        Extremes extremes = new Extremes();
        BigDecimal bigDecimal = prices.get(0).getHigh();
        LocalDate localDate = prices.get(0).getDate();

        extremes.setValue(bigDecimal);
        extremes.setDate(localDate);

        for (Price x : prices) {
            if (x.getHigh().doubleValue() < extremes.getValue().doubleValue()) {
                bigDecimal = x.getHigh();
                localDate = x.getDate();
                extremes.setValue(bigDecimal);
                extremes.setDate(localDate);
            }
        }
        return extremes;
    }
    public Extremes getMinLow() {

        Extremes extremes = new Extremes();
        BigDecimal bigDecimal = prices.get(0).getLow();
        LocalDate localDate = prices.get(0).getDate();

        extremes.setValue(bigDecimal);
        extremes.setDate(localDate);

        for (Price x : prices) {
            if (x.getLow().doubleValue() < extremes.getValue().doubleValue()) {
                bigDecimal = x.getLow();
                localDate = x.getDate();
                extremes.setValue(bigDecimal);
                extremes.setDate(localDate);
            }
        }
        return extremes;
    }
    public Extremes getMinVolume() {

        Extremes extremes = new Extremes();
        BigDecimal bigDecimal = prices.get(0).getVolume();
        LocalDate localDate = prices.get(0).getDate();

        extremes.setValue(bigDecimal);
        extremes.setDate(localDate);

        for (Price x : prices) {
            if (x.getVolume().doubleValue() < extremes.getValue().doubleValue()) {
                bigDecimal = x.getVolume();
                localDate = x.getDate();
                extremes.setValue(bigDecimal);
                extremes.setDate(localDate);
            }
        }
        return extremes;
    }

    public Extremes getMin(String ochlv) { //Open, Close, High, Low, Volume

        Extremes extremes = null;

        switch (ochlv) {
            case "Open":
                extremes = getMinOpen();
                break;
            case "Close":
                extremes = getMinClose();
                break;
            case "High":
                extremes=getMinHigh();
                break;
            case "Low":
                extremes=getMinLow();
                break;
            case "Volume":
                extremes=getMinVolume();
                break;
        }
        return extremes;
    }

    public Extremes getMaxOpen() {

        Extremes extremes = new Extremes();
        BigDecimal bigDecimal = prices.get(0).getOpen();
        LocalDate localDate = prices.get(0).getDate();

        extremes.setValue(bigDecimal);
        extremes.setDate(localDate);

        for (Price x : prices) {
            if (x.getOpen().doubleValue() > extremes.getValue().doubleValue()) {
                bigDecimal = x.getOpen();
                localDate = x.getDate();
                extremes.setValue(bigDecimal);
                extremes.setDate(localDate);
            }
        }
        return extremes;
    }
    public Extremes getMaxClose() {

        Extremes extremes = new Extremes();
        BigDecimal bigDecimal = prices.get(0).getClose();
        LocalDate localDate = prices.get(0).getDate();

        extremes.setValue(bigDecimal);
        extremes.setDate(localDate);

        for (Price x : prices) {
            if (x.getClose().doubleValue() > extremes.getValue().doubleValue()) {
                bigDecimal = x.getClose();
                localDate = x.getDate();
                extremes.setValue(bigDecimal);
                extremes.setDate(localDate);
            }
        }
        return extremes;
    }
    public Extremes getMaxHigh() {

        Extremes extremes = new Extremes();
        BigDecimal bigDecimal = prices.get(0).getHigh();
        LocalDate localDate = prices.get(0).getDate();

        extremes.setValue(bigDecimal);
        extremes.setDate(localDate);

        for (Price x : prices) {
            if (x.getHigh().doubleValue() > extremes.getValue().doubleValue()) {
                bigDecimal = x.getHigh();
                localDate = x.getDate();
                extremes.setValue(bigDecimal);
                extremes.setDate(localDate);
            }
        }
        return extremes;
    }
    public Extremes getMaxLow() {

        Extremes extremes = new Extremes();
        BigDecimal bigDecimal = prices.get(0).getLow();
        LocalDate localDate = prices.get(0).getDate();

        extremes.setValue(bigDecimal);
        extremes.setDate(localDate);

        for (Price x : prices) {
            if (x.getLow().doubleValue() > extremes.getValue().doubleValue()) {
                bigDecimal = x.getLow();
                localDate = x.getDate();
                extremes.setValue(bigDecimal);
                extremes.setDate(localDate);
            }
        }
        return extremes;
    }
    public Extremes getMaxVolume() {

        Extremes extremes = new Extremes();
        BigDecimal bigDecimal = prices.get(0).getVolume();
        LocalDate localDate = prices.get(0).getDate();

        extremes.setValue(bigDecimal);
        extremes.setDate(localDate);

        for (Price x : prices) {
            if (x.getVolume().doubleValue() > extremes.getValue().doubleValue()) {
                bigDecimal = x.getVolume();
                localDate = x.getDate();
                extremes.setValue(bigDecimal);
                extremes.setDate(localDate);
            }
        }
        return extremes;
    }

    public Extremes getMax(String ochlv) { //Open, Close, High, Low, Volume

        Extremes extremes = null;

        switch (ochlv) {
            case "Open":
                extremes = getMaxOpen();
                break;
            case "Close":
                extremes = getMaxClose();
                break;
            case "High":
                extremes=getMaxHigh();
                break;
            case "Low":
                extremes=getMaxLow();
                break;
            case "Volume":
                extremes=getMaxVolume();
                break;
        }
        return extremes;
    }

}