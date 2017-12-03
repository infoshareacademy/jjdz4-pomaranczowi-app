/*
To tylko przykładowy plik - sprawdzenie czy jest dostęp do danych z modułu cli
Prawdopodobnie później zostanie usunięty z projektu
 */

package com.infoshareacademy.pomaranczowi.financialanalyser;

import com.infoshareacademy.pomaranczowi.financialanalyser.financial.investment.InvestmentLoader;
import com.infoshareacademy.pomaranczowi.financialanalyser.financial.investment.InvestmentName;
import com.infoshareacademy.pomaranczowi.financialanalyser.financial.domain.Quotation;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world");

        String investmentsDirectoryPath;

        Quotation investment = new Quotation();
        InvestmentName investmentName = new InvestmentName();

        investmentName.loadInvestmentNameFromFile("cli/data/fund/omegafun.lst");
        investmentsDirectoryPath = "cli/data/fund/";

        String fundCodeFromUser = InvestmentLoader.getinvestmentFundCodeFromUser();

        investment = InvestmentLoader.load(investmentsDirectoryPath + investmentName.fundCodePath.get(fundCodeFromUser));
        investment.setName(investmentName.fundCodeName.get(fundCodeFromUser).toString());
        System.out.println("\nWybrano fundusz " + investment.getName() + "\nWczytano " + investment.countPrices() + " danych z okresu od " + investment.firstDate() + " do " + investment.lastDate() + ".");

    }
}