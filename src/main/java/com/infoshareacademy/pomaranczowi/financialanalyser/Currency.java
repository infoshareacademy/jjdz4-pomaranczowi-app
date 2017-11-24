package com.infoshareacademy.pomaranczowi.financialanalyser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Currency implements QuotationInterface {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
    private static Logger logger = LoggerFactory.getLogger(Currency.class);

    static String getCurrencyCodeFromUser() {
        System.out.println("Podaj kod waluty (np. USD, EUR): ");
        Scanner scanner = new Scanner(System.in);
        String currencyCode = scanner.nextLine();
        logger.info("Wczytano kod waluty od użykownika (" + currencyCode + ").");
        return currencyCode;
    }

    //ArrayList of Price objects
    private ArrayList<Price> prices = new ArrayList<>();

    //File load on Currency creation
    Currency(String currencyCode) throws FileNotFoundException {

        logger.info("Utworzono nowy obiekt Currency.");

        File file = new File("data/currency/" + currencyCode + ".txt");
        logger.info("Wczytano plik txt.");
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

                } else {
                    logger.warn("Wczytywany wiersz nie jest poprawnym wierszem z danymi.");
                }
            }
        } catch (NullPointerException e) {
            System.out.println("Wystąpił błąd przy wczytywaniu pliku!");
            logger.error("Wystąpił błąd przy wczytywaniu pliku.");
        }
    }

    @Override
    public BigDecimal getOpen(LocalDate date) throws NoSuchDateException {

        for (Price x : getPrices()) {
            if (date.equals(x.getDate())) {
                return x.getOpen();
            }
        }
        logger.debug("Podano nieprawidłową datę (" + date + ") lub datę, dla której nie ma danych.");
        throw new NoSuchDateException();
    }

    @Override
    public BigDecimal getHigh(LocalDate date) throws NoSuchDateException {

        for (Price x : getPrices()) {
            if (date.equals(x.getDate())) {
                return x.getHigh();
            }
        }
        logger.debug("Podano nieprawidłową datę (" + date + ") lub datę, dla której nie ma danych.");
        throw new NoSuchDateException();
    }

    @Override
    public BigDecimal getLow(LocalDate date) throws NoSuchDateException {

        for (Price x : getPrices()) {
            if (date.equals(x.getDate())) {
                return x.getLow();
            }
        }
        logger.debug("Podano nieprawidłową datę (" + date + ") lub datę, dla której nie ma danych.");
        throw new NoSuchDateException();
    }

    @Override
    public BigDecimal getClose(LocalDate date) throws NoSuchDateException {

        for (Price x : getPrices()) {
            if (date.equals(x.getDate())) {
                return x.getClose();
            }
        }
        logger.debug("Podano nieprawidłową datę (" + date + ") lub datę, dla której nie ma danych.");
        throw new NoSuchDateException();
    }

    @Override
    public BigDecimal getVolume(LocalDate date) throws NoSuchDateException {

        for (Price x : getPrices()) {
            if (date.equals(x.getDate())) {
                return x.getVolume();
            }
        }
        logger.debug("Podano nieprawidłową datę (" + date + ") lub datę, dla której nie ma danych.");
        throw new NoSuchDateException();
    }

    LocalDate firstDate() {
        try {
            return getPrices().get(0).getDate();
        } catch (IndexOutOfBoundsException exception) {
            logger.error("Wystąpił błąd. Wykroczono poa zakres tablicy z danymi.");
            return null;
        }
    }

    LocalDate lastDate() {

        try {
            return getPrices().get(getPrices().size() - 1).getDate();
        } catch (IndexOutOfBoundsException exception) {
            logger.error("Wystąpił błąd. Wykroczono poa zakres tablicy z danymi.");
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
    public ArrayList<Price> getPrices() {
        return prices;
    }

    @Override
    public boolean containsDate(LocalDate date) {
        for (Price price : prices) {
            if (price.getDate().equals(date)) {
                return true;
            }
        }
        return false;
    }
}