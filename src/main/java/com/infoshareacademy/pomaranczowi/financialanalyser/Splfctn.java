package com.infoshareacademy.pomaranczowi.financialanalyser;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Splfctn {

    static HashSet<Integer> year = new HashSet<>();
    static Integer yearSelected;

    public static void period(Quotation quotation) {
        System.out.println("Upraszczanie danych finansowych. Dostępne są notowania z poniższych lat.\n" +
                "Wybierz z poniższego zestawu rok z którego chcesz otrzymać dane:");
        for (Price x : quotation.getPrices()) {
            year.add(x.getDate().getYear());
        }
        System.out.println(year);

        boolean dataOk = false;

        while (!dataOk) {
            try {
                Scanner odczytScanner = new Scanner(System.in);
                yearSelected = odczytScanner.nextInt();
                if (year.contains(yearSelected)) {
                    dataOk = true;
                } else {
                    System.out.println("Wprowadzony rok nie jest jednym z listy\n" +
                            "Wybierz z poniższego zestawu rok z którego chcesz otrzymać dane:");
                    System.out.println(year);
                }
            } catch (InputMismatchException exception) {
                System.out.println("Wprowadź proszę rok w formacie 4 cyfr z poniższej listy");
                System.out.println(year);
            }
        }
        System.out.println(" selected " + yearSelected);
/*
    public static Extremes getMaxOpen(Quotation quotation, LocalDate from, LocalDate to) {
        Extremes extremes = new Extremes();
        BigDecimal bigDecimal;
        LocalDate localDate;

        for (Price x : quotation.getPrices()) {
            if ((x.getDate().isAfter(from) || x.getDate().isEqual(from)) && (x.getDate().isBefore(to) || x.getDate().isEqual(to))) {
                if (x.getOpen().compareTo(extremes.getValue()) > 0) {
                    bigDecimal = x.getOpen();
                    localDate = x.getDate();
                    extremes.setValue(bigDecimal);
                    extremes.setDate(localDate);
                }
            }
        }
        return extremes;
    }
*/
    }
}
