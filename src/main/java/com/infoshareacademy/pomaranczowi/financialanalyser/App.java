package com.infoshareacademy.pomaranczowi.financialanalyser;

import java.io.FileNotFoundException;

public class App
{
    public static void main( String[] args ) {
        InvestmentName investmentName = new InvestmentName();
        //ArrayList<String> investmentFilePath = investmentName.loadInvestmentNameFromFile("data/fund/omegafun.lst");
        investmentName.loadInvestmentNameFromFile("data/fund/omegafun.lst");

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
        investmentMenu.add("Średnie");
        investmentMenu.add("Powrót");

        Menu currenciesMenu = new Menu("Notowania kursów walut");
        currenciesMenu.add("Wczytaj dane z pliku");
        currenciesMenu.add("Wczytaj dane z adresu internetowego");
        currenciesMenu.add("Powrót");

        while (!mainMenu.wantExit()) {
            switch (mainMenu.Init()) {
                case 0:
                    while (!investmentChoiceMenu.wantExit()) {

                        Investment investment = null;

                        switch (investmentChoiceMenu.Init()) {
                            case 0:
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
                                break;
                            case 1:
                                System.out.println("\nWybrano wczytywanie z internetu");
                                Menu.waitAndContinue();
                                break;
                            default:
                                investmentChoiceMenu.exit();
                                break;
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
                                        GetLocalExt.getStartDateFromUser();
                                        GetLocalExt.getEndDateFromUser();

                                        System.out.println("\nEkstrema dla przedziału "+GetLocalExt.getStartDate()+
                                                " - "+GetLocalExt.getEndDate());

                                        GetLocalExt.ShowAll(investment);

                                        Menu.waitAndContinue();
                                        break;
                                    case 2:
                                        System.out.println("\nWybrano średnie dla " + investment.getName());
                                        GetLocalExt.getStartDateFromUser();
                                        GetLocalExt.getEndDateFromUser();

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

                    /* Here is an example of using a Currency class */
                    Currency aud = null;

                    try {
                        aud = new Currency("data/currency/AUD.txt");
                        System.out.println("Plik wczzytano pomyślnie.");
                    } catch (FileNotFoundException e) {
                        System.out.println("Nie znaleziono pkiku!");
                        Menu.waitAndContinue();
                        break;
                    }
                    String date = "20160414";
                    System.out.println("Wczytano notowania dla "+aud.countPrices()+" dni.");
                    System.out.println("Wczytana waluta: "+aud.getName());
                    System.out.println("Data pierwszego wczytanego notowania to: "+aud.firstDate());
                    System.out.println("Data ostatniego wczytanego notowania to: "+aud.lastDate()+"\n");
                    System.out.println("Wartość open dla notowania z dnia "+date+" wynosi: "+aud.getOpen(date));
                    System.out.println("Wartość high dla notowania z dnia "+date+" wynosi: "+aud.getHigh(date));
                    System.out.println("Wartość low dla notowania z dnia "+date+" wynosi: "+aud.getLow(date));
                    System.out.println("Wartość close dla notowania z dnia "+date+" wynosi: "+aud.getClose(date));
                    /* End of the example */

                    /* Here is an example of using a Global Extremes */
                    System.out.println("Maksymalna wartość Open to: "+ GetGlobalExt.getMax(aud, "Open").getValue()+ " z dnia: "+ GetGlobalExt.getMax(aud, "Open").getDate());
                    System.out.println("Minimalna wartość High to: "+ GetGlobalExt.getMin(aud, "High").getValue()+ " z dnia: "+ GetGlobalExt.getMin(aud, "High").getDate());
                    /* End of the example */

                    Menu.waitAndContinue();
                    break;
                default:
                    mainMenu.exit();
            }
        }
    }
}