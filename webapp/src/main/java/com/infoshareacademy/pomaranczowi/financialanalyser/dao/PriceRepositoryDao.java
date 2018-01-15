package com.infoshareacademy.pomaranczowi.financialanalyser.dao;


import com.infoshareacademy.pomaranczowi.financialanalyser.domain.Price;

import javax.ejb.Local;
import java.time.LocalDate;
import java.util.List;

@Local
public interface PriceRepositoryDao {

    boolean addOrUpdatePrice (Price price);
    List<Price> getPricesFromDate(String quotationCode, LocalDate localDate);
}
