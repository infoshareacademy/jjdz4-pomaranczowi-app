package com.infoshareacademy.pomaranczowi.financialanalyser.dao;


import com.infoshareacademy.pomaranczowi.financialanalyser.domain.Price;

import javax.ejb.Local;

@Local
public interface PriceRepositoryDao {

    boolean addPrices (Price price);
}
