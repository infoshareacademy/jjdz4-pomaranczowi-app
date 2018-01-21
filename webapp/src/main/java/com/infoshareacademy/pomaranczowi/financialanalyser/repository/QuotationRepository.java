package com.infoshareacademy.pomaranczowi.financialanalyser.repository;

import com.infoshareacademy.pomaranczowi.financialanalyser.domain.Quotation;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class QuotationRepository {

    @PersistenceContext(unitName = "pUnit")
    private EntityManager entityManager;

    public boolean addOrUpdateQuotation(Quotation quotation) {
        entityManager.flush();
         //quotation.setPrices(quotation.getPrices());
        entityManager.merge(quotation);
        System.out.println("Quotation " + quotation + " added ora update");
        return true;
    }

    public boolean isQuotationCodeInDB(String quotationCode){
        return entityManager.createNamedQuery("isQuotationCodeInDB")
                .setParameter("quotationCode", quotationCode)
                .getSingleResult().equals(quotationCode);
    }

   /*public Quotation getQuotationByCode (String quoatationCode){
        return (Quotation) entityManager.createNamedQuery("getQuotationByCode")
                .setParameter("quotationCode", quoatationCode);
    }*/
}


