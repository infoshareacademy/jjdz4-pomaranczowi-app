package com.infoshareacademy.pomaranczowi.financialanalyser.dao;

import com.infoshareacademy.pomaranczowi.financialanalyser.domain.Quotation;
import com.infoshareacademy.pomaranczowi.financialanalyser.domain.QuotationType;
import com.infoshareacademy.pomaranczowi.financialanalyser.repository.QuotationRepository;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.List;

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

    @Override
    public Long getTheNextFreeQuotationId(){
        return quotationRepository.getTheNextFreeQuotationId();
    }

    @Override
    public List<String> getAllQuotationsList(QuotationType quotationType){
        return quotationRepository.getAllQuotationsList(quotationType);
    }

    @Override
    public Quotation getQuotationInfoToReport(String code){
        return quotationRepository.getQuotationInfoToReport(code);
    }
}
