package com.infoshareacademy.pomaranczowi.financialanalyser.dao;

import com.infoshareacademy.pomaranczowi.financialanalyser.domain.Quotation;
import com.infoshareacademy.pomaranczowi.financialanalyser.domain.QuotationType;

import javax.ejb.Local;
import java.util.List;

@Local
public interface QuotationRepositoryDao {

    public List<String> getCodeList(String data);
    boolean addOrUpdateQuotation(Quotation quotation);
    boolean isQuotationCodeInDB(String quotationCode);
    Long getTheNextFreeQuotationId();
    List<String> getAllQuotationsList(QuotationType quotationType);
}
