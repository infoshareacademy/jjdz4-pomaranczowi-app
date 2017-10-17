package com.infoshareacademy.pomaranczowi.financialanalyser;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
            System.out.println("Wczytano plik: "+path);
        } catch (FileNotFoundException e) {
            System.out.println("Nie znaleziono pliku: "+path);
        }

        Pattern pattern = Pattern.compile("^([A-Z]{3}),([0-9]{8}),([0-9]\\.[0-9]{4}),([0-9]\\.[0-9]{4}),([0-9]\\.[0-9]{4}),([0-9]\\.[0-9]{4}),0$");

        try {
            while (fileScanner.hasNextLine()) {

                Matcher matcher = pattern.matcher(fileScanner.nextLine());
                if (matcher.matches()) {
                    Price price = new Price();

                    price.setName(matcher.group(1));
                    price.setDate(matcher.group(2));
                    price.setOpen(Double.valueOf(matcher.group(3)));
                    price.setHigh(Double.valueOf(matcher.group(4)));
                    price.setLow(Double.valueOf(matcher.group(5)));
                    price.setClose(Double.valueOf(matcher.group(6)));

                    prices.add(price);

                }
            }
        } catch (NullPointerException exception) {

        }

    }

    //returns Price object for demanded date (in String), if no object returns null
    public Price getPrice(String date) {
        int i = 0;

        LocalDate localDate = LocalDate.parse(date,DateTimeFormatter.ofPattern("yyyMMdd"));
        for (Price x : prices) {
            if (localDate.equals(x.getDate())) {
                return prices.get(i);
            }
            i++;
        }
        return null;
    }

    public Double getOpen(String date) {
        int i = 0;
        LocalDate localDate = LocalDate.parse(date,DateTimeFormatter.ofPattern("yyyMMdd"));
        for (Price x : prices) {
            if (localDate.equals(x.getDate())) {
                return x.getOpen();
            }
            i++;
        }
        return null;
    }

    public Double getHigh(String date) {
        int i = 0;
        LocalDate localDate = LocalDate.parse(date,DateTimeFormatter.ofPattern("yyyMMdd"));
        for (Price x : prices) {
            if (localDate.equals(x.getDate())) {
                return x.getHigh();
            }
            i++;
        }
        return null;
    }

    public Double getLow(String date) {
        int i = 0;
        LocalDate localDate = LocalDate.parse(date,DateTimeFormatter.ofPattern("yyyMMdd"));
        for (Price x : prices) {
            if (localDate.equals(x.getDate())) {
                return x.getLow();
            }
            i++;
        }
        return null;
    }

    public Double getClose(String date) {
        int i = 0;
        LocalDate localDate = LocalDate.parse(date,DateTimeFormatter.ofPattern("yyyMMdd"));
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
            return prices.get(prices.size()-1).getDate().toString();
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
}