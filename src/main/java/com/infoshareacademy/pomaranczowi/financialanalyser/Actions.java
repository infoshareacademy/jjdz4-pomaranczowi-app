package com.infoshareacademy.pomaranczowi.financialanalyser;

import java.time.LocalDate;

public class Actions {
    static void init(QuotationInterface quotationInterface) {

        Menu actionsMenu = new Menu("Co chcesz zrobić?");
        actionsMenu.add("Ekstrema globalne");
        actionsMenu.add("Ekstrema lokalne");
        actionsMenu.add("Wartości z danego dnia");
        actionsMenu.add("Upraszczanie danych");
        actionsMenu.add("Powrót");

        DateFromUser dateFromUser = new DateFromUser();
        LocalExt localExt = new LocalExt();

        while (!actionsMenu.wantExit()) {
            switch (actionsMenu.Init()) {
                case 0:
                    System.out.println("\nWybrano ekstrema globalne dla " + quotationInterface.getName());
                    GlobalExt.ShowAll(quotationInterface);

                    Menu.waitAndContinue();
                    break;
                case 1:
                    System.out.println("\nWybrano ekstrema lokalne dla " + quotationInterface.getName());
                    localExt.setStartDate(dateFromUser.askForStartDate());
                    localExt.setEndDate(dateFromUser.askForEndDate());
                    dateFromUser.setStartDate(dateFromUser.getStartDate());
                    dateFromUser.setEndDate(dateFromUser.getEndDate());

                    System.out.println("\nEkstrema dla przedziału " + localExt.getStartDate() +
                            " - " + localExt.getEndDate());

                    localExt.ShowAll(quotationInterface);

                    Menu.waitAndContinue();
                    break;
                case 2:
                    System.out.println("\nWartości z danego dnia dla " + quotationInterface.getName());

                    LocalDate date;
                    do {
                        date = dateFromUser.askForStartDate();
                    }while (!quotationInterface.containsDate(date));
                    QuotationInterface.showAll(quotationInterface, dateFromUser.getStartDate());

                    Menu.waitAndContinue();
                    break;
                case 3:
                    System.out.println("\nUpraszczanie danych dla " + quotationInterface.getName());
                    Simplify.periodYear(quotationInterface);

                    Menu.waitAndContinue();
                    break;
                default:
                    actionsMenu.exit();
                    break;
            }
        }
    }
}
