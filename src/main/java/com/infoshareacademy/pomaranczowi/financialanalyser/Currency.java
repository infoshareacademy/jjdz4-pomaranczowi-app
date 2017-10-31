package com.infoshareacademy.pomaranczowi.financialanalyser;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Currency class operates on Price objects
class Currency implements Quotation {

    //ArrayList of Price objects
    private ArrayList<Price> prices = new ArrayList<>();

    //File load on Currency creation
    Currency(String path) throws FileNotFoundException {

        File file = new File(path);
        Scanner fileScanner = new Scanner(file);

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

                    getPrices().add(price);

                }
            }
        } catch (NullPointerException e) {}
    }

    //returns Price object for demanded date (in String), if no object returns null
    public Price getPrice(String date) {
        int i = 0;

        LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyyMMdd"));
        for (Price x : getPrices()) {
            if (localDate.equals(x.getDate())) {
                return getPrices().get(i);
            }
            i++;
        }
        return null;
    }

    @Override
    public BigDecimal getOpen(String date) {
        int i = 0;
        LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyyMMdd"));
        for (Price x : getPrices()) {
            if (localDate.equals(x.getDate())) {
                return x.getOpen();
            }
            i++;
        }
        return null;
    }

    @Override
    public BigDecimal getHigh(String date) {
        int i = 0;
        LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyyMMdd"));
        for (Price x : getPrices()) {
            if (localDate.equals(x.getDate())) {
                return x.getHigh();
            }
            i++;
        }
        return null;
    }

    @Override
    public BigDecimal getLow(String date) {
        int i = 0;
        LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyyMMdd"));
        for (Price x : getPrices()) {
            if (localDate.equals(x.getDate())) {
                return x.getLow();
            }
            i++;
        }
        return null;
    }

    @Override
    public BigDecimal getClose(String date) {
        int i = 0;
        LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyyMMdd"));
        for (Price x : getPrices()) {
            if (localDate.equals(x.getDate())) {
                return x.getClose();
            }
            i++;
        }
        return null;
    }

    @Override
    public BigDecimal getVolume(String date) {
        int i = 0;
        LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("yyyyMMdd"));
        for (Price x : getPrices()) {
            if (localDate.equals(x.getDate())) {
                return x.getVolume();
            }
            i++;
        }
        return null;
    }

    String firstDate() {
        try {
            return getPrices().get(1).getDate().toString();
        } catch (IndexOutOfBoundsException exception) {
            return null;
        }
    }

    String lastDate() {

        try {
            return getPrices().get(getPrices().size() - 1).getDate().toString();
        } catch (IndexOutOfBoundsException exception) {
            return null;
        }
    }

    String getName() {
        return getPrices().get(1).getName();
    }

    Integer countPrices() {
        return getPrices().size();
    }

    void addPrice(Price price) {
        getPrices().add(price);
    }


    @Override
    public ArrayList<Price> getPrices() {
        return prices;
    }
}