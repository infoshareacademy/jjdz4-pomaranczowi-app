package com.infoshareacademy.pomaranczowi.financialanalyser;

import sun.util.resources.LocaleData;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

class GetDateFromUser {

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private LocalDate startDate;
    private LocalDate endDate;

    LocalDate AskForStartDate() {

        boolean dataOk = false;

        System.out.println("\nPodaj datę w formacie YYYY-MM-DD");
        while (!dataOk) {
            Scanner scanner = new Scanner(System.in);
            try {
                startDate = LocalDate.parse(scanner.nextLine(), formatter);
                dataOk = true;
            } catch (DateTimeParseException exc) {
                System.out.println("Podaj datę w formacie YYYY-MM-DD\nSpróbuj ponownie");
            }
        }
        return startDate;
    }

    LocalDate AskForEndDate() {

        boolean dataOk = false;

        System.out.println("\nPodaj końcową datę w formacie YYYY-MM-DD");
        while (!dataOk) {
            Scanner scanner = new Scanner(System.in);
            try {
                endDate = LocalDate.parse(scanner.nextLine(), formatter);
                if(endDate.isAfter(startDate)|| endDate.isEqual(startDate))
                    dataOk = true;
                else System.out.println("Data końcowa musi być większa lub równa dacie początku ("+ startDate +")\n" +
                        "Spróbuj ponownie - Podaj końcową datę w formacie YYYY-MM-DD");
            } catch (DateTimeParseException exc) {
                System.out.println("Podaj datę w formacie YYYY-MM-DD\nSpróbuj ponownie");
            }
        }
        return endDate;
    }

    LocalDate getStartDate() {
        return startDate;
    }

    LocalDate getEndDate() {
        return endDate;
    }

    void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}
