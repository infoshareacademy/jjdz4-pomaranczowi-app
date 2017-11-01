package com.infoshareacademy.pomaranczowi.financialanalyser;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class GetDateFromUser {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    private static LocalDate startDate;
    private static LocalDate endDate;

    static void AskForStartDate() {

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
    }

    static void AskForEndDate() {

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
    }

    static LocalDate getStartDate() {
        return startDate;
    }

    static LocalDate getEndDate() {
        return endDate;
    }
}
