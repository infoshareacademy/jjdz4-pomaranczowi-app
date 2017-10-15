package com.infoshareacademy.pomaranczowi.financialanalyser;

import java.time.LocalDate;


public class App
{
    public static void main( String[] args ) {

        InvestmentName investmentName = new InvestmentName();
        investmentName.loadInvestmentNameFromFile("data/fund/omegafun.lst");

        Menu menu = new Menu("Analizator Finansowy");
        menu.add("Notowania giełdowe");
        menu.add("Notowania walut");
        menu.add("Wyjście");

        //setting up new menu
        Menu menu2 = new Menu("Notowania giełdowe");
        menu2.add("WIG20");
        menu2.add("WIG30");
        menu2.add("WIG-ENERG");
        for (String description : investmentName.loadInvestmentNameFromFile("data/fund/omegafun.lst"));
        menu2.add("Powrót");

        /* Here is an example of using my menu.
        You can create so many menus and sub-menus as you wish.
        Using this schema make possible to enter a menu, then go back to previous,
        then jump to another menu, go back once again etc.
         */

        while (!menu.wantExit()) { //exits menu when .exit() is used
            switch (menu.Init()) { //menu initialization
                case 0: //menu returns user choice as an int so you can use switch case
                    int userChoice = 0;
                    while (!investmentName.menu.wantExit()) {
                        userChoice = investmentName.menu.Init();

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
                                    break;
                                case 2:
                                    menuFuduszyInwestycyjnych.exit();
                                    break;
                                default:
                                    menuFuduszyInwestycyjnych.exit();
                            }
                            break;
                        }
                        investmentName.menu.wantExit();
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


        /*//FoundInvestment class example of use
        FundInvestment pzu001 = new FundInvestment("data/fund/PZU001.txt");
        String fundDate = "20160414";
        System.out.println("Wczytano notowania dla "+pzu001.countPrices()+" dni.");
        System.out.println("Data pierwszego wczytanego notowania to: "+pzu001.firstDate());
        System.out.println("Data ostatniego wczytanego notowania to: "+pzu001.lastDate()+"\n");
        System.out.println("Wartość open dla notowania z dnia "+fundDate+" wynosi: "+pzu001.getOpen(fundDate));
        System.out.println("Wartość high dla notowania z dnia "+fundDate+" wynosi: "+pzu001.getHigh(fundDate));
        System.out.println("Wartość low dla notowania z dnia "+fundDate+" wynosi: "+pzu001.getLow(fundDate));
        System.out.println("Wartość close dla notowania z dnia "+fundDate+" wynosi: "+pzu001.getClose(fundDate));*/


        System.out.printf("\n\n\nInne podejście:\n");
        /*QuotationCreate quotationCreate = new QuotationCreate();
        quotationCreate.loadDataFromFile("data/fund/PZU001.txt");
        int numberOfQuotations = quotationCreate.getNumberOfQuotations();
        System.out.printf("\nLiczba Quotations: " + numberOfQuotations);*/

        Loader loader = new Loader();

        //Investment investment = new Investment(1,"Krakowiak", loader.getQuotationsList("data/fund/PZU001.txt"));

        //System.out.printf("\nName: " + investment.getName());
        System.out.println(loader.getQuotationsList("data/fund/PZU002.txt").get(3).getName());
        Investment investment = new Investment(Loader.getQuotationsList("data/fund/PZU002.txt").get(0).getName(), Loader.getQuotationsList("data/fund/PZU002.txt"));

        System.out.println(investment.getName());
        System.out.println(Loader.getQuotationsList("data/fund/PZU002.txt").size());

        LocalDate localDateAfter = LocalDate.of(2017,02,28);
        LocalDate localDateBefore = LocalDate.of(2017,04,01);


        //public List<Quotation> quotations = new ArrayList<>();
        System.out.println("Marzec: ");
        for (Quotation quotation : investment.getQuotations()){
            if (quotation.getDate().isAfter(localDateAfter) && quotation.getDate().isBefore(localDateBefore)) {
                System.out.printf(quotation.getDate()+ " ");
            }
        }

        //InvestmentName investmentName = new InvestmentName();
        //investmentName.loadInvestmentNameFromFile("data/fund/omegafun.lst");

    }
}

