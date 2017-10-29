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
        investmentMenu.add("Ekstrema");
        investmentMenu.add("Średnie");
        investmentMenu.add("Powrót");

        Menu currenciesMenu = new Menu("Notowania kursów walut");
        currenciesMenu.add("Wczytaj dane z pliku");
        currenciesMenu.add("Wczytaj dane z adresu internetowego");
        currenciesMenu.add("Powrót");

        while (!mainMenu.wantExit()) { //exits menu when .exit() is used
            switch (mainMenu.Init()) { //menu initialization
                case 0: //menu returns user choice as an int so you can use switch case
                    while (!investmentChoiceMenu.wantExit()) {
                        switch (investmentChoiceMenu.Init()) {
                            case 0:
                                while (!investmentName.investmentNameMenu.wantExit()) {

                                    int userChoice;

                                    userChoice = investmentName.investmentNameMenu.Init();

                                    if (userChoice == investmentName.filePaths.size()) {
                                        investmentName.investmentNameMenu.exit();
                                    } else {

                                        Investment investment = new Investment(investmentName.filePaths.get(userChoice).name,
                                                Loader.getQuotationsList("data/fund/" +
                                                        investmentName.filePaths.get(userChoice).path));

                                        /* Here is an example of using a Investment class */
                                        System.out.println("\nWybrano fundusz " + investment.getName());
                                        System.out.println("Wczytano " + investment.getNumberOfQuotation() + " danych z okresu od " + investment.getFirstDate() + " do " + investment.getLastDate() + ".");
                                        String exampleDate = "2017-04-13";
                                        //System.out.println("Wartość open dla notowania z dnia " + exampleDate + " wynosi " + investment.getOpen(exampleDate));
                                        //System.out.println("Wartość open dla notowania z dnia " + exampleDate + " wynosi " + investment.getHigh(exampleDate));
                                        //System.out.println("Wartość open dla notowania z dnia " + exampleDate + " wynosi " + investment.getLow(exampleDate));
                                        //System.out.println("Wartość open dla notowania z dnia " + exampleDate + " wynosi " + investment.getClose(exampleDate));
                                        /* End of example */

                                        while (!investmentMenu.wantExit()) {
                                            switch (investmentMenu.Init()) {
                                                case 0:
                                                    System.out.println("\nWybrano ekstrema dla " +investment.getName());
                                                    investmentMenu.waitAndContinue();
                                                    break;
                                                case 1:
                                                    System.out.println("\nWybrano średnie dla " + investment.getName());
                                                    investmentMenu.waitAndContinue();
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
                                System.out.println("\nWybrano wczytywanie z internetu");
                                investmentChoiceMenu.waitAndContinue();
                                break;
                            default:
                                investmentChoiceMenu.exit();
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
                        currenciesMenu.waitAndContinue();
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

                    mainMenu.waitAndContinue();
                    break;
                default:
                    mainMenu.exit();
            }
        }
    }
}