package com.infoshareacademy.pomaranczowi.financialanalyser.services;

import com.infoshareacademy.pomaranczowi.financialanalyser.domain.QuotationType;

public class QuotationReport {

    private Integer id;
    private String name;
    private String code;
    private QuotationType quotationType;

    public QuotationReport(Integer id, String name, String code, QuotationType quotationType){
        this.id = id;
        this.name = name;
        this.code = code;
        this.quotationType = quotationType;
    }

    public QuotationReport(){
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public QuotationType getQuotationType() {
        return quotationType;
    }

    public void setQuotationType(QuotationType quotationType) {
        this.quotationType = quotationType;
    }

    @Override
    public String toString(){
        return "Quotation from report module: " +
                "id=" + id +
                ", name=" + name + "\'" +
                ", code=" + code + "\'" +
                ", quotation Type=" + getQuotationType() + "\'" +
                ".";
    }
}
