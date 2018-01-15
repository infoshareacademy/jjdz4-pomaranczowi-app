package com.infoshareacademy.pomaranczowi.financialanalyser.dao;

import com.infoshareacademy.pomaranczowi.financialanalyser.domain.Quotation;

import javax.ejb.Local;

@Local
public interface QuotationRepositoryDao {

    boolean addOrUpdateQuotation(Quotation quotation);
    //Long getQuotationIdByCode (String quotationCode);
    //void addPriceToQuotation (Long id ,List<Price> pricesToAdded);
}
