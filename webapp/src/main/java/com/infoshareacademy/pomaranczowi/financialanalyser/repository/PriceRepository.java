package com.infoshareacademy.pomaranczowi.financialanalyser.repository;

import com.infoshareacademy.pomaranczowi.financialanalyser.domain.Price;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.List;

@Stateless
public class PriceRepository {

    //@EJB
    //QuotationRepository quotationRepository;

    @PersistenceContext(unitName = "pUnit")
    private EntityManager entityManager;

    public void addOrUpdatePrice(Price price, String quotationCode) {
        price.setQuotationCode(quotationCode);
        //price.setQuotation(quotationRepository.getQuotationByCode(quotationCode));
        entityManager.flush();
        entityManager.merge(price);
        System.out.println("Price id: " + price.getId() + " added/updatetd");
    }

    public List<Price> getPricesFromDate(String quotationCode, LocalDate localDate){
        return   entityManager.createNamedQuery("getpricefromQurrencyCode")
                .setParameter("quotationCode", quotationCode)
                .setParameter("userDate",localDate)
                .getResultList();
    }

    public List<Price> getPricesFromDateToDate(String quotationCode, LocalDate startDate, LocalDate endDate){
        return   entityManager.createNamedQuery("getPricesFromDateToDate")
                .setParameter("quotationCode", quotationCode)
                .setParameter("startDate",startDate)
                .setParameter("endDate",endDate)
                .getResultList();
    }
}
