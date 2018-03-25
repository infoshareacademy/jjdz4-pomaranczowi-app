package com.infoshareacademy.pomaranczowi.report.repository;

import com.infoshareacademy.pomaranczowi.report.model.Quotation;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class QuotationRepositoryDaoBean implements QuotationRepositoryDao {

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

    @Override
    public Integer getTheNextFreeQuotationId(){
        return quotationRepository.getTheNextFreeQuotationId();
    }

    /*@Override
    public List<String> getAllQuotationsList(QuotationType quotationType){
        return quotationRepository.getAllQuotationsList(quotationType);
    }*/

    @Override
    public Quotation getQuotation(String code){
        return quotationRepository.getQuotation(code);
    }
}
