package com.infoshareacademy.pomaranczowi.financialanalyser;

import java.util.ArrayList;
import java.util.List;

class Loader {

    static ArrayList<Price> getQuotationsList(String filePath) {

        QuotationCreate quotationData = new QuotationCreate();
        quotationData.loadDataFromFile("" + filePath);

        ArrayList<Price> quotations = new ArrayList<>();
        for (int i = 0; i < quotationData.getNumberOfQuotations(); i++) {
            quotations.add(quotationData.getQuotation(i));
        }
        return quotations;
    }

}
