package com.infoshareacademy.pomaranczowi.financialanalyser.dao;

import com.infoshareacademy.pomaranczowi.financialanalyser.domain.Quotation;
import com.infoshareacademy.pomaranczowi.financialanalyser.repository.QuotationRepository;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class QuotationRepositoryDaoBean implements QuotationRepositoryDao{

    @EJB
    QuotationRepository quotationRepository;

    @Override
    public boolean addOrUpdateQuotation (Quotation quotation) {
        quotationRepository.addOrUpdateQuotation(quotation);
        return true;
    }

    @Override
    public boolean isQuotationCodeInDB(String quotationCode){
        return quotationRepository.isQuotationCodeInDB(quotationCode);
    }

   /*@Override
    public Quotation getQuotationByCode (String quoatationCode){
       return quotationRepository.getQuotationByCode(quoatationCode);
    }*/
}
