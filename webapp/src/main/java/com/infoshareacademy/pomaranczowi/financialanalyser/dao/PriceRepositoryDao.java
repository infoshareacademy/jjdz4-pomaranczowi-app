package com.infoshareacademy.pomaranczowi.financialanalyser.dao;


import com.infoshareacademy.pomaranczowi.financialanalyser.domain.Price;

import javax.ejb.Local;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Local
public interface PriceRepositoryDao {

    boolean addOrUpdatePrice (Price price, String quotationCode);
    List<Price> getPricesFromDate(String quotationCode, LocalDate localDate);
    List<Price> getPricesFromDateToDate(String quotationCode, LocalDate startDate, LocalDate endDate);
    BigDecimal getMaxOpenFromDateToDate(String quotationCode, LocalDate startDate, LocalDate endDate);
}
