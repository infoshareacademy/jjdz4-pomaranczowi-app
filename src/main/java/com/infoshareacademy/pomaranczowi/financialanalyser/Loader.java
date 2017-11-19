package com.infoshareacademy.pomaranczowi.financialanalyser;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;

class Loader {
    private static Logger logger = LoggerFactory.getLogger(QuotationCreate.class.getName());

    static ArrayList<Price> getQuotationsList(String filePath) {

        QuotationCreate quotationData = new QuotationCreate();
        quotationData.loadDataFromFile("" + filePath);

        ArrayList<Price> quotations = new ArrayList<>();
        for (int i = 0; i < quotationData.getNumberOfQuotations(); i++) {
            quotations.add(quotationData.getQuotation(i));
        }
        logger.debug("Pobrano listę wartości dla funduszu inwestycyjnego z pliku: " + filePath + ".");
        return quotations;
    }

}
