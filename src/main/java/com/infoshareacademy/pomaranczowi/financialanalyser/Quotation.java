package com.infoshareacademy.pomaranczowi.financialanalyser;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;

public interface Quotation {

    BigDecimal getOpen(String date);
    BigDecimal getHigh(String date);
    BigDecimal getLow(String date);
    BigDecimal getClose(String date);
    BigDecimal getVolume(String date);
    ArrayList<Price> getPrices();

}
