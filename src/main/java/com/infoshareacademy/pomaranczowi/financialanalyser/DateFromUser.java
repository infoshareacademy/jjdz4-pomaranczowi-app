package com.infoshareacademy.pomaranczowi.financialanalyser;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

class DateFromUser {

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    @Setter @Getter private LocalDate startDate;
    @Setter @Getter private LocalDate endDate;

    LocalDate askForStartDate() {

        boolean isDataOk = false;

        System.out.println("\nPodaj datę w formacie YYYY-MM-DD");
        while (!isDataOk) {
            Scanner scanner = new Scanner(System.in);
            try {
                startDate = LocalDate.parse(scanner.nextLine(), formatter);
                isDataOk = true;
            } catch (DateTimeParseException exc) {
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
                if(endDate.isAfter(startDate)|| endDate.isEqual(startDate))
                    isDataOk = true;
                else System.out.println("Data końcowa musi być większa lub równa dacie początku ("+ startDate +")\n" +
                        "Spróbuj ponownie - Podaj końcową datę w formacie YYYY-MM-DD");
            } catch (DateTimeParseException exc) {
                System.out.println("Podaj datę w formacie YYYY-MM-DD\nSpróbuj ponownie");
            }
        }
        return endDate;
    }
}