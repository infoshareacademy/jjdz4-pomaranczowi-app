package com.infoshareacademy.pomaranczowi.financialanalyser.repository;

import com.infoshareacademy.pomaranczowi.financialanalyser.domain.Price;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.time.LocalDate;
import java.util.List;

@Stateless
public class PriceRepository {

    /*@EJB
    QuotationRepositoryDao quotationRepositoryDao;*/

    @PersistenceContext(unitName = "pUnit")
    private EntityManager entityManager;

    public boolean addOrUpdatePrice(Price price) {
        entityManager.flush();
        entityManager.merge(price);
        System.out.println("Price id: " + price.getId() + " added/updatetd");
        return true;
    }

    public List<Price> getPricesFromDate(String quotationCode, LocalDate localDate){
        //Long quotationId = quotationRepositoryDao.getQuotationIdByCode(quotationCode);

        Long quotationId = 2l;

        List<Price> priceList = entityManager.createNamedQuery("getPricesByDate")
                .setParameter("quotationId", quotationId)
                .setParameter("localDate",localDate)
                .getResultList();

        List<Price> priceList8 = entityManager.createQuery("FROM Price p where p.")
                .setParameter("quotationId", quotationId)
                .setParameter("localDate",localDate)
                .getResultList();

        return priceList;
    }
}
