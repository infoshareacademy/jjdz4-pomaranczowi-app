package com.infoshareacademy.pomaranczowi.financialanalyser;

import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Investment implements QuotationInterface {

    @Setter @Getter public String name;
    private List<Price> prices = new ArrayList<>();

    public Investment(String name, List<Price> prices) {
        this.name = name;
        this.prices = prices;
        Logger logger = LoggerFactory.getLogger(Investment.class.getName());
        logger.info("Stworzono nowy obiekt funduszu inwestycyjnego o nazwie: " + name + ".");
    }

    @Override
    public BigDecimal getOpen(LocalDate date) {
        for (Price price : prices) if (price.getDate().equals(date)) return price.getOpen();
        return null;
    }

    @Override
    public BigDecimal getHigh(LocalDate date) {
        for (Price price : prices) if (price.getDate().equals(date)) return price.getHigh();
        return null;
    }

    @Override
    public BigDecimal getLow(LocalDate date) {
        for (Price price : prices) if (price.getDate().equals(date)) return price.getLow();
        return null;
    }

    @Override
    public BigDecimal getClose(LocalDate date){
        for (Price price : prices) if (price.getDate().equals(date)) return price.getClose();
        return null;
        }

    @Override
    public BigDecimal getVolume(LocalDate date){
        for (Price price : prices) if (price.getDate().equals(date)) return price.getVolume();
        return null;
    }

    @Override
    public List<Price> getPrices() {
        return prices;
    }

    LocalDate getFirstDate(){
        return prices.get(0).getDate();
        }

    LocalDate getLastDate(){
        return prices.get(prices.size()-1).getDate();
        }

    Integer getNumberOfQuotation(){
        return prices.size();
        }

    @Override
    public boolean containsDate(LocalDate date){
        for (Price price : prices) {
            if (price.getDate().equals(date)) {
                return true;
            }
        }
        return false;
    }

    static String getinvestmentFundCodeFromUser() {
        System.out.println("Podaj kod funduszu:");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
}
