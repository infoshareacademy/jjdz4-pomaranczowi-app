package com.infoshareacademy.pomaranczowi.financialanalyser.dao;

import com.infoshareacademy.pomaranczowi.financialanalyser.domain.Price;
import com.infoshareacademy.pomaranczowi.financialanalyser.repository.PriceRepository;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.time.LocalDate;
import java.util.List;

@Stateless
public class PriceRepositoryDaoBean implements PriceRepositoryDao {

    @EJB
    PriceRepository priceRepository;

    @Override
    public boolean addOrUpdatePrice (Price price, String quotationCode){
        priceRepository.addOrUpdatePrice(price, quotationCode);
        return true;
    }

    @Override
    public List<Price> getPricesFromDate(String quotationCode, LocalDate localDate){
        return priceRepository.getPricesFromDate(quotationCode,localDate);
    }

    @Override
    public List<Price> getPricesFromDateToDate(String quotationCode, LocalDate startDate, LocalDate endDate){
        return priceRepository.getPricesFromDateToDate(quotationCode, startDate, endDate);
    }

}
