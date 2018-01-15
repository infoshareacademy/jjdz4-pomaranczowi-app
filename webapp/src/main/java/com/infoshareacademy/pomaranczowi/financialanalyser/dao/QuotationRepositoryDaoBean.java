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

   /* @Override
    public Long getQuotationIdByCode (String quoatationCode){
       return quotationRepository.getQuotationIdByCode(quoatationCode);
    }*/

    /*@Override
    public void addPriceToQuotation (Long id ,List<Price> priceToAdded){
        quotationRepository.addPriceToQuotation(id, priceToAdded);
    }*/
}
