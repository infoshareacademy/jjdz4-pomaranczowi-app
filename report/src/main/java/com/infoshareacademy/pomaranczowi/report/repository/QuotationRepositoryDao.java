package com.infoshareacademy.pomaranczowi.report.repository;

import com.infoshareacademy.pomaranczowi.report.model.Quotation;

import javax.ejb.Local;

@Local
public interface QuotationRepositoryDao {

    boolean addOrUpdateQuotation(Quotation quotation);
    boolean isQuotationCodeInDB(String quotationCode);
    Integer getTheNextFreeQuotationId();
   // List<String> getAllQuotationsList(QuotationType quotationType);
    Quotation getQuotation(String code);
}
