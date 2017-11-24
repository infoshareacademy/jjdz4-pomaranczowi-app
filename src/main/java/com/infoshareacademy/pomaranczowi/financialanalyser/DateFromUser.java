package com.infoshareacademy.pomaranczowi.financialanalyser;

import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

class DateFromUser {

    @Setter @Getter private LocalDate startDate;
    @Setter @Getter private LocalDate endDate;

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static Logger logger = LoggerFactory.getLogger(Currency.class);

    LocalDate askForStartDate() {

        boolean isDataOk = false;

        System.out.println("\nPodaj datę w formacie YYYY-MM-DD");
        while (!isDataOk) {
            Scanner scanner = new Scanner(System.in);
            try {
                startDate = LocalDate.parse(scanner.nextLine(), formatter);
                logger.info("Użytkownik podał datę w prawidłowym formacie.");
                isDataOk = true;
            } catch (DateTimeParseException exc) {
                logger.warn("Użytkownik podał datę w nieprawidłowym formacie.");
                System.out.println("Podaj datę w formacie YYYY-MM-DD\nSpróbuj ponownie");
            }
        }
        return startDate;
    }

    LocalDate askForEndDate() {

        boolean isDataOk = false;

        System.out.println("\nPodaj końcową datę w formacie YYYY-MM-DD");
        while (!isDataOk) {
            Scanner scanner = new Scanner(System.in);
            try {
                endDate = LocalDate.parse(scanner.nextLine(), formatter);
                if(endDate.isAfter(startDate)|| endDate.isEqual(startDate)) {
                    logger.info("Użytkownik podał prawidłową datę końcową w prawidłowym formacie.");
                    isDataOk = true;
                } else {
                    logger.warn("Użytkownik podał datę końcową wcześniejszą niż data początkowa.");
                    System.out.println("Data końcowa musi być większa lub równa dacie początku ("+ startDate +")\n" +
                            "Spróbuj ponownie - Podaj końcową datę w formacie YYYY-MM-DD");
                }
            } catch (DateTimeParseException exc) {
                logger.warn("Użytkownik podał datę końcową w nieprawidłowym formacie.");
                System.out.println("Podaj datę w formacie YYYY-MM-DD\nSpróbuj ponownie");
            }
        }
        return endDate;
    }
}