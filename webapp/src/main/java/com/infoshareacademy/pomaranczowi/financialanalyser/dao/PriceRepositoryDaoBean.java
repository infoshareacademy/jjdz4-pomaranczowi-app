package com.infoshareacademy.pomaranczowi.financialanalyser.dao;

import com.infoshareacademy.pomaranczowi.financialanalyser.domain.Price;
import com.infoshareacademy.pomaranczowi.financialanalyser.repository.PriceRepository;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Stateless
public class PriceRepositoryDaoBean implements PriceRepositoryDao {

    @EJB
    PriceRepository priceRepository;

    public List<Integer> getYearsList(String code) {
        List<Integer> yearsList = new ArrayList<>();
        Integer minYear = getMinDate(code).getYear();
        Integer maxYear = getMaxDate(code).getYear();
        for (; minYear <= maxYear; minYear++) {
            yearsList.add(minYear);
        }
        return yearsList;
    }

    @Override
    public boolean addOrUpdatePrice (Price price, String quotationCode){
        priceRepository.addOrUpdatePrice(price, quotationCode);
        return true;
    }

    @Override
    public Price getPriceFromDate(String quotationCode, LocalDate localDate){
        return priceRepository.getPriceFromDate(quotationCode,localDate);
    }

    @Override
    public Long getTheNextFreePriceId(){
        return priceRepository.getTheNextFreePriceId();
    }

    @Override
    public List<Price> getPricesFromDateToDate(String quotationCode, LocalDate startDate, LocalDate endDate){
        return priceRepository.getPricesFromDateToDate(quotationCode, startDate, endDate);
    }

    @Override
    public LocalDate getMinDate(String quotationCode){
        return priceRepository.getMinDate(quotationCode);
    }

    @Override
    public LocalDate getMaxDate(String quotationCode){
        return priceRepository.getMaxDate(quotationCode);
    }

    @Override
    public BigDecimal getMaxOpenFromDateToDate(String quotationCode, LocalDate startDate, LocalDate endDate){
        return priceRepository.getMaxOpenFromDateToDate(quotationCode, startDate, endDate);
    }

    @Override
    public BigDecimal getMinOpenFromDateToDate(String quotationCode, LocalDate startDate, LocalDate endDate){
        return priceRepository.getMinOpenFromDateToDate(quotationCode, startDate, endDate);
    }

    @Override
    public BigDecimal getMaxCloseFromDateToDate(String quotationCode, LocalDate startDate, LocalDate endDate){
        return priceRepository.getMaxCloseFromDateToDate(quotationCode, startDate, endDate);
    }

    @Override
    public BigDecimal getMinCloseFromDateToDate(String quotationCode, LocalDate startDate, LocalDate endDate){
        return priceRepository.getMinCloseFromDateToDate(quotationCode, startDate, endDate);
    }

    @Override
    public BigDecimal getMaxHighFromDateToDate(String quotationCode, LocalDate startDate, LocalDate endDate){
        return priceRepository.getMaxHighFromDateToDate(quotationCode, startDate, endDate);
    }

    @Override
    public BigDecimal getMinHighFromDateToDate(String quotationCode, LocalDate startDate, LocalDate endDate){
        return priceRepository.getMinHighFromDateToDate(quotationCode, startDate, endDate);
    }

    @Override
    public BigDecimal getMaxLowFromDateToDate(String quotationCode, LocalDate startDate, LocalDate endDate){
        return priceRepository.getMaxLowFromDateToDate(quotationCode, startDate, endDate);
    }

    @Override
    public BigDecimal getMinLowFromDateToDate(String quotationCode, LocalDate startDate, LocalDate endDate){
        return priceRepository.getMinLowFromDateToDate(quotationCode, startDate, endDate);
    }
}
