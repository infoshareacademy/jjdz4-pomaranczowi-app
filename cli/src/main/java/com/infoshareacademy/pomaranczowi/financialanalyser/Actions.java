package com.infoshareacademy.pomaranczowi.financialanalyser;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import java.time.LocalDate;

class Actions {
    static void init(Quotation quotation) {
        Logger logger = LoggerFactory.getLogger(Actions.class.getName());
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
                    System.out.println("\nWybrano ekstrema globalne dla " + quotation.getName());
                    GlobalExt.ShowAll(quotation);

                    Menu.waitAndContinue();
                    break;
                case 1:
                    System.out.println("\nWybrano ekstrema lokalne dla " + quotation.getName());

                    boolean areChoosenDatesCorrect = false;

                    while (!areChoosenDatesCorrect) {

                        localExt.setStartDate(dateFromUser.askForStartDate());
                        localExt.setEndDate(dateFromUser.askForEndDate());

                        for (Price price : quotation.getPrices()) {
                            if ((price.getDate().isAfter(localExt.getStartDate()) ||
                                    price.getDate().isEqual(localExt.getStartDate())) &&
                                    (price.getDate().isBefore(localExt.getEndDate()) ||
                                    price.getDate().isEqual(localExt.getEndDate()))) {
                                
                                areChoosenDatesCorrect = true;
                                break;
                            }
                        }

                        if (!areChoosenDatesCorrect) System.out.println("Brak notowań pomiędzy podanymi datami!");
                        logger.info("Brak notowań pomiędzy podanymi datami! (FUN/WAL: "+ quotation.getName()+
                                ", OD:"+localExt.getStartDate() +" DO:"+localExt.getEndDate() +")");
                    }

                    dateFromUser.setEndDate(dateFromUser.getEndDate());

                    System.out.println("\nEkstrema dla przedziału " + localExt.getStartDate() +
                            " - " + localExt.getEndDate());

                    localExt.ShowAll(quotation);

                    Menu.waitAndContinue();
                    break;
                case 2:
                    System.out.println("\nWartości z danego dnia dla " + quotation.getName());

                    LocalDate date;
                    do {
                        date = dateFromUser.askForStartDate();
                    } while (!quotation.containsDate(date));
                    Quotation.showAll(quotation, dateFromUser.getStartDate());

                    Menu.waitAndContinue();
                    break;
                case 3:
                    System.out.println("\nUpraszczanie danych dla " + quotation.getName());
                    Simplify.periodYear(quotation);

                    Menu.waitAndContinue();
                    break;
                default:
                    actionsMenu.exit();
                    break;
            }
        }
    }
}
