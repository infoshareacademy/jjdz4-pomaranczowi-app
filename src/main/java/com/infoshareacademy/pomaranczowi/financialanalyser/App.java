package com.infoshareacademy.pomaranczowi.financialanalyser;

import java.io.FileNotFoundException;

public class App {
    public static void main(String[] args) {

        Menu mainMenu = new Menu("$$$$ ANALIZATOR FINANSOWY $$$$");
        mainMenu.add("Notowania funduszy inwestycyjnych");
        mainMenu.add("Notowania kursów walut");
        mainMenu.add("Wyjście");

        Menu investmentChoiceMenu = new Menu("Notowania funduszy inwestycyjnych");
        investmentChoiceMenu.add("Wczytaj dane z pliku");
        investmentChoiceMenu.add("Wczytaj dane z adresu internetowego");
        investmentChoiceMenu.add("Powrót");

        Menu investmentMenu = new Menu("Co chcesz zrobić?");
        investmentMenu.add("Ekstrema globalne");
        investmentMenu.add("Ekstrema lokalne");
        investmentMenu.add("Wartości z danego dnia");
        investmentMenu.add("Powrót");

        Menu currenciesMenu = new Menu("Notowania kursów walut");
        currenciesMenu.add("Wczytaj dane z pliku");
        currenciesMenu.add("Wczytaj dane z adresu internetowego");
        currenciesMenu.add("Powrót");

        GetDateFromUser getDateFromUser = new GetDateFromUser();
        GetLocalExt getLocalExt = new GetLocalExt();

        while (!mainMenu.wantExit()) {
            switch (mainMenu.Init()) {
                case 0:
                    while (!investmentChoiceMenu.wantExit()) {

                        InvestmentName investmentName = new InvestmentName();
                        investmentName.loadInvestmentNameFromFile("data/fund/omegafun.lst");
                        Investment investment = null;

                        switch (investmentChoiceMenu.Init()) {
                            case 0:
                                System.out.println("\nWybrano wczytywanie z pliku");

                                Menu.waitAndContinue();
                                break;
                            case 1:
                                System.out.println("\nWybrano wczytywanie z internetu");

                                ImportCurrentData.downloadFileFromURL();

                                Menu.waitAndContinue();
                                break;
                            default:
                                investmentChoiceMenu.exit();
                                break;
                        }

                        if(!investmentMenu.isExitSet()) {
                            while (!investmentName.investmentNameMenu.wantExit()) {

                                int userChoice;

                                userChoice = investmentName.investmentNameMenu.Init();

                                if (userChoice == investmentName.filePaths.size()) {
                                    investmentName.investmentNameMenu.exit();
                                    investmentChoiceMenu.exit();
                                } else {

                                    investment = new Investment(investmentName.filePaths.get(userChoice).name, Loader.getQuotationsList("data/fund/" + investmentName.filePaths.get(userChoice).path));

                                    System.out.println("\nWybrano fundusz " + investment.getName());
                                    System.out.println("Wczytano " + investment.getNumberOfQuotation() + " danych z okresu od " + investment.getFirstDate() + " do " + investment.getLastDate() + ".");

                                    Menu.waitAndContinue();
                                    investmentName.investmentNameMenu.exit();
                                }
                            }
                        }

                        if (!investmentChoiceMenu.isExitSet()) {
                            while (!investmentMenu.wantExit()) {
                                switch (investmentMenu.Init()) {
                                    case 0:
                                        System.out.println("\nWybrano ekstrema globalne dla " + investment.getName());
                                        GetGlobalExt.ShowAll(investment);

                                        Menu.waitAndContinue();
                                        break;
                                    case 1:
                                        System.out.println("\nWybrano ekstrema lokalne dla " + investment.getName());
                                        getLocalExt.setStartDate(getDateFromUser.AskForStartDate());
                                        getLocalExt.setEndDate(getDateFromUser.AskForEndDate());
                                        getDateFromUser.setStartDate(getDateFromUser.getStartDate());
                                        getDateFromUser.setEndDate(getDateFromUser.getEndDate());

                                        System.out.println("\nEkstrema dla przedziału " +getLocalExt.getStartDate() +
                                                " - " + getLocalExt.getEndDate());

                                        getLocalExt.ShowAll(investment);

                                        Menu.waitAndContinue();
                                        break;
                                    case 2:
                                        System.out.println("\nWartości z danego dnia dla " + investment.getName());

                                        getDateFromUser.AskForStartDate();
                                        Quotation.ShowAll(investment, getDateFromUser.getStartDate());

                                        Menu.waitAndContinue();
                                        break;
                                    default:
                                        investmentMenu.exit();
                                        break;
                                }
                            }
                        }
                    }
                    break;
                case 1:
                    System.out.println("\nNotowania kursów walut\n");

                    Currency aud;

                    try {
                        aud = new Currency("data/currency/AUD.txt");
                        System.out.println("Plik wczzytano pomyślnie.");
                    } catch (FileNotFoundException e) {
                        System.out.println("Nie znaleziono pkiku!");
                        Menu.waitAndContinue();
                        break;
                    }

                    Menu.waitAndContinue();
                    break;
                default:
                    mainMenu.exit();
            }
        }
    }
}