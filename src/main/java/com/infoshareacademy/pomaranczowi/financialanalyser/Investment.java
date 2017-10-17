package com.infoshareacademy.pomaranczowi.financialanalyser;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Investment {


    public String name;
    private List<Quotation> quotations = new ArrayList<>();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Investment(String name, List<Quotation> quotations) {
        this.name = name;
        this.quotations = quotations;
    }

    BigDecimal getOpen(String date) {
        for (Quotation quotation : quotations) if (quotation.getDate().toString().equals(date)) return quotation.getOpen();
        return null;
    }

    BigDecimal getHigh(String date) {
        for (Quotation quotation : quotations) if (quotation.getDate().toString().equals(date)) return quotation.getHigh();
        return null;
    }


    BigDecimal getLow(String date) {
        for (Quotation quotation : quotations) if (quotation.getDate().toString().equals(date)) return quotation.getLow();
        return null;
    }


    BigDecimal getClose(String date){
        for (Quotation quotation : quotations) if (quotation.getDate().toString().equals(date)) return quotation.getClose();
        return null;
        }

    LocalDate getFirstDate(){
        return quotations.get(0).getDate();
        }

    LocalDate getLastDate(){
        return quotations.get(quotations.size()-1).getDate();
        }

    Integer getNumberOfQuotation(){
        return quotations.size();
        }

}
