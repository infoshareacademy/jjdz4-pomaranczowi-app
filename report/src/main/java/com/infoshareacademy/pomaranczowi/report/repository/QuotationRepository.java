package com.infoshareacademy.pomaranczowi.report.repository;

import com.infoshareacademy.pomaranczowi.report.model.Quotation;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class QuotationRepository {

    @PersistenceContext(unitName = "pUnit")
    private EntityManager entityManager;

    public boolean addOrUpdateQuotation(Quotation quotation) {

        if (isQuotationCodeInDB(quotation.getCode())){
            entityManager.flush();
            entityManager.merge(quotation);
            System.out.println("Quotation " + quotation + " added or update");
            return true;
        } else {
            System.out.println("Quotation " + quotation + " already exists id db");
            return false;
        }
    }

    public boolean isQuotationCodeInDB(String quotationCode) {
        return entityManager.createNamedQuery("isQuotationCodeInDB")
                .setParameter("quotationCode", quotationCode)
                .getSingleResult().equals(quotationCode);
    }

    /*public Long getTheNextFreeQuotationId() {
        try {
            return (Long) entityManager.createNamedQuery("getTheNextFreeQuotationId").getResultList().get(0) + 1;
        } catch (Exception e) {
            return 1l;
        }
    }*/

    /*public List<String> getAllQuotationsList(QuotationType quotationType) {
        return entityManager.createNamedQuery("getAllQuotationList")
                .setParameter("quotationType", quotationType)
                .getResultList();
    }*/

    public Quotation getQuotation(String code) {
        return (Quotation) entityManager.createNamedQuery("getQuotation")
                .setParameter("code", code)
                .getResultList()
                .get(0);
    }
}


