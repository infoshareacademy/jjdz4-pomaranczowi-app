package com.infoshareacademy.pomaranczowi.financialanalyser.dao;

import com.infoshareacademy.pomaranczowi.financialanalyser.domain.Quotation;

public interface QuotationRepositoryDao {

    boolean addQuotation(Quotation quotation);
}
