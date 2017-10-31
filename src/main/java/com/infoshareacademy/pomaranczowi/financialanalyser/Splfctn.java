package com.infoshareacademy.pomaranczowi.financialanalyser;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.time.temporal.TemporalAdjusters;
import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;


public class Splfctn {

    static HashSet<Integer> year = new HashSet<>();
    static HashSet<Integer> month = new HashSet<>();
    static Integer yearSelected;

    public static void periodYear(Quotation quotation) {
        System.out.println("Upraszczanie danych finansowych. Dostępne są notowania z poniższych lat.\n" +
                "Wybierz z poniższego zestawu rok z którego chcesz otrzymać dane:");
        for (Price x : quotation.getPrices()) {
            year.add(x.getDate().getYear());
        }
        System.out.println(year);

        boolean dataOk = false;

//--CHOICE YEAR
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
        System.out.println("Czy chcesz otrzymać dane uproszczone dla roku " + yearSelected + " ?\n" +
                "Jeżeli tak -> wciśnij 'T', jeżeli chcesz otrzymać dane uproszczone dla miesiąca -> wcisnij 'N'");

        dataOk = false;

        while (!dataOk) {
            Scanner odczytScanner = new Scanner(System.in);
            String answer = odczytScanner.nextLine();

            //DISPLAY DATA FOR YEAR AND MONTHS
            if (answer.equals("T") || answer.equals("t")) {
                LocalDate date = LocalDate.of(yearSelected, 1, 1);
                System.out.println("Dla roku " + yearSelected + " :\n" +
                        " maksymalna wartość Open to: " +
                        GetLocalExt.getMax(quotation, date.with(TemporalAdjusters.firstDayOfYear()), date.with(TemporalAdjusters.lastDayOfYear()), GetLocalExt.ExtremesParams.Open).getValue() +
                        " z dnia: " + GetLocalExt.getMax(quotation, date.with(TemporalAdjusters.firstDayOfYear()), date.with(TemporalAdjusters.lastDayOfYear()), GetLocalExt.ExtremesParams.Open).getDate() +
                        "\n minimalna wartość Open to: " +
                        GetLocalExt.getMin(quotation, date.with(TemporalAdjusters.firstDayOfYear()), date.with(TemporalAdjusters.lastDayOfYear()), GetLocalExt.ExtremesParams.Open).getValue() +
                        " z dnia: " + GetLocalExt.getMin(quotation, date.with(TemporalAdjusters.firstDayOfYear()), date.with(TemporalAdjusters.lastDayOfYear()), GetLocalExt.ExtremesParams.Open).getDate());
                System.out.println("Miesiące w roku " + yearSelected + " :");
                getMonthsForYear(quotation);
                /*
                for (Price x : quotation.getPrices()) {
                    if(x.getDate().getYear()==yearSelected)
                        month.add(x.getDate().getMonthValue());
                }
                */
                for (int i :month) {
                    System.out.println(date.getMonth().getDisplayName(TextStyle.FULL_STANDALONE, Locale.forLanguageTag("pl-PL")) + "\n" +
                            " Max Open: " +
                            GetLocalExt.getMax(quotation, date.with(TemporalAdjusters.firstDayOfMonth()), date.with(TemporalAdjusters.lastDayOfMonth()), GetLocalExt.ExtremesParams.Open).getValue() +
                            " z dnia: " + GetLocalExt.getMax(quotation, date.with(TemporalAdjusters.firstDayOfMonth()), date.with(TemporalAdjusters.lastDayOfMonth()), GetLocalExt.ExtremesParams.Open).getDate() +
                            "\n Min Open: " +
                            GetLocalExt.getMin(quotation, date.with(TemporalAdjusters.firstDayOfMonth()), date.with(TemporalAdjusters.lastDayOfMonth()), GetLocalExt.ExtremesParams.Open).getValue() +
                            " z dnia: " + GetLocalExt.getMin(quotation, date.with(TemporalAdjusters.firstDayOfMonth()), date.with(TemporalAdjusters.lastDayOfMonth()), GetLocalExt.ExtremesParams.Open).getDate());
                    date = date.plusMonths(1);
                }
                dataOk = true;
            } else if (answer.equals("N") || answer.equals("n")) {
                //wywołanie funckji wyboru mca
                periodMonth(quotation);
                dataOk = true;
            } else System.out.println("Wprowadź odpowiedź T lub N");
        }
    }

    public static void getMonthsForYear(Quotation quotation){
        for (Price x : quotation.getPrices()) {
            if(x.getDate().getYear()==yearSelected)
                month.add(x.getDate().getMonthValue());
        }
    }

    public static void periodMonth(Quotation quotation) {
        System.out.println("Dla roku "+yearSelected+" dostępne są dane z poniższych miesięcy.\n" +
                "Wybierz jeden z poniższych miesięcy:");
        getMonthsForYear(quotation);
        System.out.println(month);

    }

}
