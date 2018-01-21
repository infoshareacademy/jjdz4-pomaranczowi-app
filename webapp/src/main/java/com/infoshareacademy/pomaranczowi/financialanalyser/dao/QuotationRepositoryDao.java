package com.infoshareacademy.pomaranczowi.financialanalyser.dao;

import com.infoshareacademy.pomaranczowi.financialanalyser.domain.Quotation;

import javax.ejb.Local;

@Local
public interface QuotationRepositoryDao {

    boolean addOrUpdateQuotation(Quotation quotation);
    boolean isQuotationCodeInDB(String quotationCode);
    /*Quotation getQuotationByCode(String quotationCode);*/
}
