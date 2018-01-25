package com.infoshareacademy.pomaranczowi.financialanalyser.repository;

import com.infoshareacademy.pomaranczowi.financialanalyser.domain.Price;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Stateless
public class PriceRepository {

    @PersistenceContext(unitName = "pUnit")
    private EntityManager entityManager;

    public void addOrUpdatePrice(Price price, String quotationCode) {
        entityManager.merge(price);
    }

    public Long getTheNextFreePriceId(){
        try{
            return (Long) entityManager.createNamedQuery("getTheNextFreePriceId").getResultList().get(0)+1;
        }
        catch (Exception e){
            return 1l;
        }
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

    public LocalDate getMinDate(String quotationCode){
        return (LocalDate) entityManager.createNamedQuery("getMinDate")
                .setParameter("quotationCode", quotationCode)
                .getResultList().get(0);
    }

    public LocalDate getMaxDate(String quotationCode){
        return (LocalDate) entityManager.createNamedQuery("getMaxDate")
                .setParameter("quotationCode", quotationCode)
                .getResultList().get(0);
    }

    public BigDecimal getMaxOpenFromDateToDate(String quotationCode, LocalDate startDate, LocalDate endDate){
        return  (BigDecimal) entityManager.createNamedQuery("getMaxOpenFromDateToDate")
                .setParameter("quotationCode", quotationCode)
                .setParameter("startDate",startDate)
                .setParameter("endDate",endDate)
                .getResultList().get(0);
    }

    public BigDecimal getMinOpenFromDateToDate(String quotationCode, LocalDate startDate, LocalDate endDate){
        return  (BigDecimal) entityManager.createNamedQuery("getMinOpenFromDateToDate")
                .setParameter("quotationCode", quotationCode)
                .setParameter("startDate",startDate)
                .setParameter("endDate",endDate)
                .getResultList().get(0);
    }

    public BigDecimal getMaxCloseFromDateToDate(String quotationCode, LocalDate startDate, LocalDate endDate){
        return  (BigDecimal) entityManager.createNamedQuery("getMaxCloseFromDateToDate")
                .setParameter("quotationCode", quotationCode)
                .setParameter("startDate",startDate)
                .setParameter("endDate",endDate)
                .getResultList().get(0);
    }

    public BigDecimal getMinCloseFromDateToDate(String quotationCode, LocalDate startDate, LocalDate endDate){
        return  (BigDecimal) entityManager.createNamedQuery("getMinCloseFromDateToDate")
                .setParameter("quotationCode", quotationCode)
                .setParameter("startDate",startDate)
                .setParameter("endDate",endDate)
                .getResultList().get(0);
    }

    public BigDecimal getMaxHighFromDateToDate(String quotationCode, LocalDate startDate, LocalDate endDate){
        return  (BigDecimal) entityManager.createNamedQuery("getMaxHighFromDateToDate")
                .setParameter("quotationCode", quotationCode)
                .setParameter("startDate",startDate)
                .setParameter("endDate",endDate)
                .getResultList().get(0);
    }

    public BigDecimal getMinHighFromDateToDate(String quotationCode, LocalDate startDate, LocalDate endDate){
        return  (BigDecimal) entityManager.createNamedQuery("getMinHighFromDateToDate")
                .setParameter("quotationCode", quotationCode)
                .setParameter("startDate",startDate)
                .setParameter("endDate",endDate)
                .getResultList().get(0);
    }

    public BigDecimal getMaxLowFromDateToDate(String quotationCode, LocalDate startDate, LocalDate endDate){
        return  (BigDecimal) entityManager.createNamedQuery("getMaxLowFromDateToDate")
                .setParameter("quotationCode", quotationCode)
                .setParameter("startDate",startDate)
                .setParameter("endDate",endDate)
                .getResultList().get(0);
    }

    public BigDecimal getMinLowFromDateToDate(String quotationCode, LocalDate startDate, LocalDate endDate){
        return  (BigDecimal) entityManager.createNamedQuery("getMinLowFromDateToDate")
                .setParameter("quotationCode", quotationCode)
                .setParameter("startDate",startDate)
                .setParameter("endDate",endDate)
                .getResultList().get(0);
    }
}
