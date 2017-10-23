package com.infoshareacademy.pomaranczowi.financialanalyser;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Investment {


    public String name;
    private List<Price> prices = new ArrayList<>();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Investment(String name, List<Price> prices) {
        this.name = name;
        this.prices = prices;
    }

    BigDecimal getOpen(String date) {
        for (Price price : prices) if (price.getDate().toString().equals(date)) return price.getOpen();
        return null;
    }

    BigDecimal getHigh(String date) {
        for (Price price : prices) if (price.getDate().toString().equals(date)) return price.getHigh();
        return null;
    }


    BigDecimal getLow(String date) {
        for (Price price : prices) if (price.getDate().toString().equals(date)) return price.getLow();
        return null;
    }


    BigDecimal getClose(String date){
        for (Price price : prices) if (price.getDate().toString().equals(date)) return price.getClose();
        return null;
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

}
