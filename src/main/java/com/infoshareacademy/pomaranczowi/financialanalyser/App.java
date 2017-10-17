package com.infoshareacademy.pomaranczowi.financialanalyser;

import java.util.ArrayList;


public class App
{
    public static void main( String[] args ) {
        InvestmentName investmentName = new InvestmentName();
        ArrayList<String> investmentFilePath = investmentName.loadInvestmentNameFromFile("data/fund/omegafun.lst");

        Menu menu = new Menu("Analizator Finansowy");
        menu.add("Fundusze inwestycyjne");
        menu.add("Notowania walut");
        menu.add("Wyjście");

        //setting up new menu
        Menu menu2 = new Menu("Notowania giełdowe");
        menu2.add("WIG20");
        menu2.add("WIG30");
        menu2.add("WIG-ENERG");
        //for (String description : investmentName.loadInvestmentNameFromFile("data/fund/omegafun.lst"));
        menu2.add("Powrót");

        /* Here is an example of using my menu.
        You can create so many menus and sub-menus as you wish.
        Using this schema make possible to enter a menu, then go back to previous,
        then jump to another menu, go back once again etc.
         */

        while (!menu.wantExit()) { //exits menu when .exit() is used
            switch (menu.Init()) { //menu initialization
                case 0: //menu returns user choice as an int so you can use switch case
                    int userChoice;
                    while (!investmentName.chooseInvestmentName.wantExit()) {
                        userChoice = investmentName.chooseInvestmentName.Init();
                        System.out.println("Wybrano fundusz " + investmentName.getInvestmentName(userChoice));
                        Investment investment = new Investment(investmentName.getInvestmentName(userChoice), Loader.getQuotationsList("data/fund/"+ investmentFilePath.get(userChoice)));

                        /* Here is an example of using a Investment class */
                        System.out.println("Nazwa wczytanego funduszu inwestycyjnego " + investment.getName());
                        System.out.println("Wczytano " + investment.getNumberOfQuotation() + " danych z okresu od " + investment.getFirstDate() + " do " + investment.getLastDate() +".");
                        String exampleDate = "2017-04-13";
                        System.out.println("Wartość open dla notowania z dnia " + exampleDate + " wynosi " + investment.getOpen(exampleDate));
                        System.out.println("Wartość open dla notowania z dnia " + exampleDate + " wynosi " + investment.getHigh(exampleDate));
                        System.out.println("Wartość open dla notowania z dnia " + exampleDate + " wynosi " + investment.getLow(exampleDate));
                        System.out.println("Wartość open dla notowania z dnia " + exampleDate + " wynosi " + investment.getClose(exampleDate));
                        /* End of example */

                        Menu menuFuduszyInwestycyjnych = new Menu("Menu funduszy");
                        menuFuduszyInwestycyjnych.add("Ekstrema");
                        menuFuduszyInwestycyjnych.add("Średnie");
                        menuFuduszyInwestycyjnych.add("Powrót");

                        while (!menuFuduszyInwestycyjnych.wantExit()) {
                            switch (menuFuduszyInwestycyjnych.Init()) {
                                case 0:
                                    System.out.println("Wybrano ekstrema.");
                                    menuFuduszyInwestycyjnych.exit();
                                    break;
                                case 1:
                                    System.out.println("Wybrano średnie.");
                                    menuFuduszyInwestycyjnych.exit();
                                    break;
                                case 2:
                                    menuFuduszyInwestycyjnych.exit();
                                    break;
                                default:
                                    investmentName.chooseInvestmentName.exit();
                            }
                            break;
                        }
                        investmentName.chooseInvestmentName.wantExit();
                    }
                case 1: //case for a menu
                    System.out.println("Wybrano opcję 1");
                    menu.exit(); //exits menu
                    break;
                default:
                    menu.exit(); //exits menu
            }
        }

        /* End of the example */

        /* Here is an example of using a Currency class */

        Currency aud = new Currency("data/currency/AUD.txt");
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

    }
}

