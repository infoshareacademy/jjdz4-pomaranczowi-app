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
        entityManager.merge(quotation);
        System.out.println("Quotation " + quotation + " added or update");
        return true;
    }

    public boolean isQuotationCodeInDB(String quotationCode){
        return entityManager.createNamedQuery("isQuotationCodeInDB")
                .setParameter("quotationCode", quotationCode)
                .getSingleResult().equals(quotationCode);
    }

    public Long getTheNextFreeQuotationId(){
        try{
            return (Long) entityManager.createNamedQuery("getTheNextFreeQuotationId").getResultList().get(0)+1;
        }catch (Exception e){
            return 1l;
        }
    }

}


