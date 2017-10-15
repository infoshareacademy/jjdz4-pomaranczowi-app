package com.infoshareacademy.pomaranczowi.financialanalyser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FundInvestment {

    /*public int Id;
    String name;
    public List<Quotation> quotations = new ArrayList<>();*/

    //ArrayList of Price objects
    private ArrayList<Price> prices = new ArrayList<>();

    //File load on Currency creation
    protected FundInvestment(String path) {

        File file = new File(path);
        Scanner fileScanner = null;
        try {
            fileScanner = new Scanner(file);
            System.out.println("\n\n\nWczytano plik: " + path);
        } catch (FileNotFoundException e) {
            System.out.println("\n\n\nNie znaleziono pliku: " + path);
        }

        Pattern pattern = Pattern.compile("^[A-Z]{3}[0-9]{3},([0-9]{8}),((?:\\d*\\.)?\\d+),((?:\\d*\\.)?\\d+),((?:\\d*\\.)?\\d+),((?:\\d*\\.)?\\d+),((?:\\d*\\.)?\\d+)");

        try {
            while (fileScanner.hasNextLine()) {

                Matcher matcher = pattern.matcher(fileScanner.nextLine());
                if (matcher.matches()) {
                    Price price = new Price();
                    price.setDate(matcher.group(1));
                    price.setOpen(Double.valueOf(matcher.group(2)));
                    price.setHigh(Double.valueOf(matcher.group(3)));
                    price.setLow(Double.valueOf(matcher.group(4)));
                    price.setClose(Double.valueOf(matcher.group(5)));
                    prices.add(price);

                }
            }
        } catch (NullPointerException exception) {

        }

    }

    /*//returns Price object for demanded date (in String), if no object returns null
    public Price getPrice(String datde) {
        int i = 0;
        for (Price price : prices) {
            if (date.equals(price.getDate())) {
                return prices.get(i);
            }
            i++;
        }
        return null;
    }*/

    public Double getOpen(String date) {
        for (Price price : prices) {
            if (date.equals(price.getDate())) {
                return price.getOpen();
            }
        }
       return null;
    }

    public Double getHigh(String date) {
        for (Price x : prices) {
            if (date.equals(x.getDate())) {
                return x.getHigh();
            }
        }
        return null;
    }

    public Double getLow(String date) {
        for (Price x : prices) {
            if (date.equals(x.getDate())) {
                return x.getLow();
            }
        }
        return null;
    }

    public Double getClose(String date) {
        for (Price x : prices) {
            if (date.equals(x.getDate())) {
                return x.getClose();
            }
        }
        return null;
    }

    public String firstDate() {
        try {
            return prices.get(1).getDate();
        } catch (IndexOutOfBoundsException exception) {
            return null;
        }
    }

    public String lastDate() {

        try {
            return prices.get(prices.size() - 1).getDate();
        } catch (IndexOutOfBoundsException exception) {
            return null;
        }
    }

    public Integer countPrices() {
        return prices.size();
    }

    public void addPrice(Price price) {
        prices.add(price);
    }
}
