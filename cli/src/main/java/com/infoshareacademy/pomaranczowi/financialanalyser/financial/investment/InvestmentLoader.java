package com.infoshareacademy.pomaranczowi.financialanalyser.financial.investment;

import com.infoshareacademy.pomaranczowi.financialanalyser.financial.domain.Quotation;
import com.infoshareacademy.pomaranczowi.financialanalyser.financial.operations.QuotationCreate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class InvestmentLoader {
    private static Logger logger = LoggerFactory.getLogger(QuotationCreate.class.getName());

    public static String getinvestmentFundCodeFromUser() {
        System.out.println("Podaj kod funduszu:");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static Quotation load(String filePath) {

        Quotation investment = new Quotation();

        QuotationCreate quotationData = new QuotationCreate();
        quotationData.loadDataFromFile("" + filePath);

        for (int i = 0; i < quotationData.getNumberOfQuotations(); i++) {
            investment.getPrices().add(quotationData.getQuotation(i));
        }
        logger.debug("Pobrano listę wartości dla funduszu inwestycyjnego z pliku: " + filePath + ".");
        return investment;
    }

}
