package com.infoshareacademy.pomaranczowi.financialanalyser;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Currency implements QuotationInterface {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");

    static String getCurrencyCodeFromUser() {
        System.out.println("Podaj kod waluty (np. USD, EUR): ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    private List<Price> prices = new ArrayList<>();

    Currency(String currencyCode) throws FileNotFoundException {

        File file = new File("data/currency/" + currencyCode + ".txt");
        Scanner fileScanner = new Scanner(file);

        Pattern pattern = Pattern.compile("^([A-Z]{3}),([0-9]{8}),([0-9]\\.[0-9]{4}),([0-9]\\.[0-9]{4}),([0-9]\\.[0-9]{4}),([0-9]\\.[0-9]{4}),([0-9]+.?[0-9]*)$");

        try {
            while (fileScanner.hasNextLine()) {

                Matcher matcher = pattern.matcher(fileScanner.nextLine());
                if (matcher.matches()) {
                    Price price = new Price();

                    price.setName(matcher.group(1));
                    price.setDate(LocalDate.parse(matcher.group(2), formatter));
                    price.setOpen(new BigDecimal(matcher.group(3)));
                    price.setHigh(new BigDecimal(matcher.group(4)));
                    price.setLow(new BigDecimal(matcher.group(5)));
                    price.setClose(new BigDecimal(matcher.group(6)));
                    price.setVolume(new BigDecimal(matcher.group(7)));

                    getPrices().add(price);

                }
            }
        } catch (NullPointerException e) {
            System.out.println("Wystąpił błąd przy wczytywaniu pliku!");
        }
    }

    @Override
    public BigDecimal getOpen(LocalDate date) throws NoSuchDateException {

        return getPrices().parallelStream().filter(x -> x.getDate().equals(date)).findFirst().orElseThrow(NoSuchDateException::new).getOpen();
    }

    @Override
    public BigDecimal getHigh(LocalDate date) throws NoSuchDateException {

        return getPrices().parallelStream().filter(x -> x.getDate().equals(date)).findFirst().orElseThrow(NoSuchDateException::new).getHigh();
    }

    @Override
    public BigDecimal getLow(LocalDate date) throws NoSuchDateException {

        return getPrices().parallelStream().filter(x -> x.getDate().equals(date)).findFirst().orElseThrow(NoSuchDateException::new).getLow();

    }

    @Override
    public BigDecimal getClose(LocalDate date) throws NoSuchDateException {

        return getPrices().parallelStream().filter(x -> x.getDate().equals(date)).findFirst().orElseThrow(NoSuchDateException::new).getClose();
    }

    @Override
    public BigDecimal getVolume(LocalDate date) throws NoSuchDateException {

        return getPrices().parallelStream().filter(x -> x.getDate().equals(date)).findFirst().orElseThrow(NoSuchDateException::new).getVolume();
    }

    LocalDate firstDate() {
        try {
            return getPrices().get(0).getDate();
        } catch (IndexOutOfBoundsException exception) {
            return null;
        }
    }

    LocalDate lastDate() {

        try {
            return getPrices().get(getPrices().size() - 1).getDate();
        } catch (IndexOutOfBoundsException exception) {
            return null;
        }
    }

    @Override
    public String getName() {
        return getPrices().get(1).getName();
    }

    Integer countPrices() {
        return getPrices().size();
    }

    @Override
    public List<Price> getPrices() {

        return prices;
    }

    @Override
    public boolean containsDate(LocalDate date) {

        return prices.parallelStream().anyMatch(x -> x.getDate().equals(date));
    }
}