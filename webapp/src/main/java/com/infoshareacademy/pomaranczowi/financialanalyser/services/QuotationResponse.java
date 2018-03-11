package com.infoshareacademy.pomaranczowi.financialanalyser.services;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public class QuotationResponse {

    @JsonIgnore
    private QuotationReport quotationReport;

    private List<QuotationReport> data;

    public QuotationResponse(){}

    public QuotationReport getQuotationReport() {
        return quotationReport;
    }

    public void setQuotationReport(QuotationReport quotationReport) {
        this.quotationReport = quotationReport;
    }

    public List<QuotationReport> getData() {
        return data;
    }

    public void setData(List<QuotationReport> data) {
        this.data = data;
    }
}
