package com.infoshareacademy.pomaranczowi.financialanalyser;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;

public class Investment implements Quotation{


    public String name;
    private ArrayList<Price> prices = new ArrayList<>();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Investment(String name, ArrayList<Price> prices) {
        this.name = name;
        this.prices = prices;
    }

    @Override
    public BigDecimal getOpen(String date) {
        for (Price price : prices) if (price.getDate().toString().equals(date)) return price.getOpen();
        return null;
    }

    @Override
    public BigDecimal getHigh(String date) {
        for (Price price : prices) if (price.getDate().toString().equals(date)) return price.getHigh();
        return null;
    }

    @Override
    public BigDecimal getLow(String date) {
        for (Price price : prices) if (price.getDate().toString().equals(date)) return price.getLow();
        return null;
    }

    @Override
    public BigDecimal getClose(String date){
        for (Price price : prices) if (price.getDate().toString().equals(date)) return price.getClose();
        return null;
        }

    @Override
    public BigDecimal getVolume(String date){
        for (Price price : prices) if (price.getDate().toString().equals(date)) return price.getVolume();
        return null;
    }

    @Override
    public ArrayList<Price> getPrices() {
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
}
