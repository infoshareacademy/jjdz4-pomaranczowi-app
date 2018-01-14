package com.infoshareacademy.pomaranczowi.financialanalyser.dao;

import com.infoshareacademy.pomaranczowi.financialanalyser.domain.Price;
import com.infoshareacademy.pomaranczowi.financialanalyser.repository.PriceRepository;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class PriceRepositoryDaoBean implements PriceRepositoryDao {

    @EJB
    PriceRepository priceRepository;

    @Override
    public boolean addPrices (Price price){
        priceRepository.addPrices(price);
        return true;
    }

}
