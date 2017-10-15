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
            System.out.println("Wczytano plik: "+path);
        } catch (FileNotFoundException e) {
            System.out.println("Nie znaleziono pliku: "+path);
        }

        Pattern pattern = Pattern.compile("^([A-Z]{3}),([0-9]{8}),([0-9]\\.[0-9]{4}),([0-9]\\.[0-9]{4}),([0-9]\\.[0-9]{4}),([0-9]\\.[0-9]{4}),([0-9]+.?[0-9]*)$");

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
                    price.setVolume(Double.valueOf(matcher.group(7)));

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

// -- tmk
/*   public Double getMinOpen() {

        Extemes extemes = new Extemes();
        BigDecimal bigDecimal = new BigDecimal(prices.get(0).getOpen());
        LocalDate localDate = prices.get(0).getDate();

        extemes.setValue(bigDecimal);
        extemes.setDate(localDate);



        for (Price x : prices) {
            if (x.getOpen() < (extemes.getValue()) {
                extemes.setValue( x.getOpen());
            }
        }
        return extemes;
    }
*/

public Double getMinOpen() {

    Double min = prices.get(0).getOpen();

    for (Price x : prices) {
        if (x.getOpen() < min) {
            min = x.getOpen();
        }
    }
    return min;
}


    public Double getMinClose() {

        Double min = prices.get(0).getClose();

        for (Price x : prices) {
            if (x.getClose() < min) {
                min = x.getClose();
            }
        }
        return min;
    }

    public Double getMinHigh() {

        Double min = prices.get(0).getHigh();

        for (Price x : prices) {
            if (x.getHigh() < min) {
                min = x.getHigh();
            }
        }
        return min;
    }

    public Double getMinLow() {

        Double min = prices.get(0).getLow();

        for (Price x : prices) {
            if (x.getLow() < min) {
                min = x.getLow();
            }
        }
        return min;


    }

    public Double getMinVolume() {

        Double min = prices.get(1).getVolume();
;
        for (Price x : prices) {
            if (x.getVolume() < min) {
                min = x.getVolume();
            }
        }
        return min;

    }

    public Double getMaxOpen() {

        Double max = prices.get(0).getOpen();

        for (Price x : prices) {
            if (x.getOpen() > max) {
                max = x.getOpen();
            }
        }
        return max;
    }

    public Double getMaxClose() {

        Double max = prices.get(0).getClose();

        for (Price x : prices) {
            if (x.getClose() > max) {
                max = x.getClose();
            }
        }
        return max;
    }

    public Double getMaxHigh() {

        Double max = prices.get(0).getHigh();

        for (Price x : prices) {
            if (x.getHigh() > max) {
                max = x.getHigh();
            }
        }
        return max;
    }

    public Double getMaxLow() {

        Double max = prices.get(0).getLow();

        for (Price x : prices) {
            if (x.getLow() > max) {
                max = x.getLow();
            }
        }
        return max;
    }

    public Double getMaxVolume() {

        Double max = prices.get(0).getVolume();

        for (Price x : prices) {
            if (x.getVolume() > max) {
                max = x.getVolume();
            }
        }
        return max;
    }


    public Double getMin(String ochlv) { //Open, Close, High, Low, Volume

        Double min = null;

        switch (ochlv) {
            case "Open":
                min = getMinOpen();
                break;
            case "Close":
                min = getMinClose();
                break;
            case "High":
                min=getMinHigh();
                break;
            case "Low":
                min=getMinLow();
                break;
            case "Volume":
                min=getMinVolume();
                break;
        }

        return min;
    }

    public Double getMax(String ochlv) { //Open, Close, High, Low, Volume

        Double max = null;

        switch (ochlv) {
            case "Open":
                max = getMinOpen();
                break;
            case "Close":
                max = getMinClose();
                break;
            case "High":
                max=getMinHigh();
                break;
            case "Volume":
                max=getMinVolume();
                break;
        }

        return max;
    }


}