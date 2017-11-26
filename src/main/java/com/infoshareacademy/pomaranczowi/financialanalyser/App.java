package com.infoshareacademy.pomaranczowi.financialanalyser;

import java.io.FileNotFoundException;

public class App {
    public static void main(String[] args) {

        new LoggerFileNameInit().getTimeAndDateForFileName();

        Menu mainMenu = new Menu("$$$$ ANALIZATOR FINANSOWY $$$$");
        mainMenu.add("Notowania funduszy inwestycyjnych");
        mainMenu.add("Notowania kursów walut");
        mainMenu.add("Wyjście");

        Menu investmentChoiceMenu = new Menu("Notowania funduszy inwestycyjnych");
        investmentChoiceMenu.add("Wczytaj dane z pliku");
        investmentChoiceMenu.add("Wczytaj dane z adresu internetowego");
        investmentChoiceMenu.add("Powrót");

        while (!mainMenu.wantExit()) {
            switch (mainMenu.Init()) {
                case 0:
                    while (!investmentChoiceMenu.wantExit()) {

                        InvestmentName investmentName = new InvestmentName();
                        String investmentsDirectoryPath = null;
                        Quotation investment = new Quotation();

                        switch (investmentChoiceMenu.Init()) {
                            case 0:
                                System.out.println("\nWybrano wczytywanie z pliku");
                                investmentName.loadInvestmentNameFromFile("data/fund/omegafun.lst");
                                investmentsDirectoryPath = "data/fund/";

                                Menu.waitAndContinue();
                                break;
                            case 1:
                                System.out.println("\nWybrano wczytywanie z internetu");
                                ImportCurrentData.downloadFileFromURL();
                                investmentName.loadInvestmentNameFromFile(ImportCurrentData.getFundListDestination());
                                investmentsDirectoryPath = ImportCurrentData.getDataDirectoryDestination();

                                Menu.waitAndContinue();
                                break;
                            default:
                                investmentChoiceMenu.exit();
                                break;
                        }

                        if (!investmentChoiceMenu.isExitSet()) {
                            while (!investmentName.investmentNameMenu.wantExit()) {

                                System.out.println("\nPodaj kod funduszu inwestycyjnego, np. PZU001 lub ING001:\n");

                                Boolean isFundFileLoaded = false;

                                while (!isFundFileLoaded) {

                                    String fundCodeFromUser = InvestmentLoader.getinvestmentFundCodeFromUser();
                                    try {

                                        investment = InvestmentLoader.load(investmentsDirectoryPath + investmentName.fundCodePath.get(fundCodeFromUser));
                                        investment.setName(investmentName.fundCodeName.get(fundCodeFromUser).toString());
                                        System.out.println("\nWybrano fundusz " + investment.getName() + "\nWczytano " + investment.countPrices() + " danych z okresu od " + investment.firstDate() + " do " + investment.lastDate() + ".");

                                        isFundFileLoaded = true;
                                    }catch (IndexOutOfBoundsException e){
                                        System.out.println("Nie znaleziono pliku!");
                                    }
                                }

                                investmentName.investmentNameMenu.exit();
                                investmentChoiceMenu.exit();
                            }
                        }
                        Actions.init(investment);
                    }
                    break;
                case 1:
                    System.out.println("\nNotowania kursów walut\n");

                    Boolean isCurrencyFileLoaded = false;
                    Quotation currency = new Quotation();

                    while (!isCurrencyFileLoaded) {

                        String currencyCode = CurrencyLoader.getCurrencyCodeFromUser();

                        try {
                            currency = CurrencyLoader.load(currencyCode);
                            System.out.println("\nPlik wczytano pomyślnie.");
                            System.out.println("Wczytano " + currency.countPrices() + " notowań waluty od " +
                                    currency.firstDate() + " do " + currency.lastDate());
                            isCurrencyFileLoaded = true;
                        } catch (FileNotFoundException e) {
                            System.out.println("\nNieprawidłowa waluta lub brak waluty w bazie!");
                        }
                    }

                    if (isCurrencyFileLoaded) Actions.init(currency);
                    break;
                default:
                    mainMenu.exit();
            }
        }
    }
}