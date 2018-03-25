package com.infoshareacademy.pomaranczowi.report.repository;

import com.infoshareacademy.pomaranczowi.report.model.Quotation;

import javax.ejb.Local;
import java.util.List;

@Local
public interface QuotationRepositoryDao {

    boolean addOrUpdateQuotation(Quotation quotation);
    boolean isQuotationCodeInDB(String quotationCode);
    Integer getTheNextFreeQuotationId();
    List<Quotation> getAllQuotationsList();
    Quotation getQuotation(String code);
}
