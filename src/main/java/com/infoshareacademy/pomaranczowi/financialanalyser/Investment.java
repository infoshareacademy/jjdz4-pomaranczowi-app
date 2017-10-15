package com.infoshareacademy.pomaranczowi.financialanalyser;

import java.util.ArrayList;
import java.util.List;

public class Investment {


    public String name;
    public List<Quotation> quotations = new ArrayList<>();


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Quotation> getQuotations() {
        return quotations;
    }

    public void setQuotations(List<Quotation> quotations) {
        this.quotations = quotations;
    }

    public Investment(String name, List<Quotation> quotations) {
        this.name = name;
        this.quotations = quotations;
    }

}
