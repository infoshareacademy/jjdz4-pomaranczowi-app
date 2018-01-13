package com.infoshareacademy.pomaranczowi.financialanalyser.dao;

import com.infoshareacademy.pomaranczowi.financialanalyser.domain.Quotation;
import com.infoshareacademy.pomaranczowi.financialanalyser.repository.QuotationRepository;

import javax.ejb.EJB;

public class QuotationRepositoryDaoBean implements QuotationRepositoryDao{

    @EJB
    QuotationRepository quotationRepository;

    @Override
    public boolean addQuotation (Quotation quotation) {
        quotationRepository.addQuotation(quotation);
        return true;
    }
}
