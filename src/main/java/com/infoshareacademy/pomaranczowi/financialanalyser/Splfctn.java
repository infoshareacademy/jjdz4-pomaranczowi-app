package com.infoshareacademy.pomaranczowi.financialanalyser;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.time.temporal.TemporalAdjusters;
import java.util.*;


public class Splfctn {

    static HashSet<Integer> year = new HashSet<>();
    static HashSet<Integer> month = new HashSet<>();
    static HashSet<Integer> week = new HashSet<>();
    static Integer yearSelected;
    static Integer monthSelected;
    static LocalDate date;

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
                Scanner scanner = new Scanner(System.in);
                yearSelected = scanner.nextInt();
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
            Scanner scanner = new Scanner(System.in);
            String answer = scanner.nextLine();

            //DISPLAY DATA FOR YEAR AND MONTHS
            if (answer.equals("T") || answer.equals("t")) {
                date = LocalDate.of(yearSelected, 1, 1);
                System.out.println("Dla roku " + yearSelected + " :\n" +
                        " maksymalna wartość Open to: " +
                        GetLocalExt.getMax(quotation, date.with(TemporalAdjusters.firstDayOfYear()), date.with(TemporalAdjusters.lastDayOfYear()), GetLocalExt.ExtremesParams.OPEN).getValue() +
                        " z dnia: " + GetLocalExt.getMax(quotation, date.with(TemporalAdjusters.firstDayOfYear()), date.with(TemporalAdjusters.lastDayOfYear()), GetLocalExt.ExtremesParams.OPEN).getDate() +
                        "\n minimalna wartość Open to: " +
                        GetLocalExt.getMin(quotation, date.with(TemporalAdjusters.firstDayOfYear()), date.with(TemporalAdjusters.lastDayOfYear()), GetLocalExt.ExtremesParams.OPEN).getValue() +
                        " z dnia: " + GetLocalExt.getMin(quotation, date.with(TemporalAdjusters.firstDayOfYear()), date.with(TemporalAdjusters.lastDayOfYear()), GetLocalExt.ExtremesParams.OPEN).getDate());
                System.out.println("Miesiące w roku " + yearSelected + " :");

                getMonthsForYear(quotation);

                for (int i : month) {
                    System.out.println(date.getMonth().getDisplayName(TextStyle.FULL_STANDALONE, Locale.forLanguageTag("pl-PL")) + "\n" +
                            " Max Open: " +
                            GetLocalExt.getMax(quotation, date.with(TemporalAdjusters.firstDayOfMonth()), date.with(TemporalAdjusters.lastDayOfMonth()), GetLocalExt.ExtremesParams.OPEN).getValue() +
                            " z dnia: " + GetLocalExt.getMax(quotation, date.with(TemporalAdjusters.firstDayOfMonth()), date.with(TemporalAdjusters.lastDayOfMonth()), GetLocalExt.ExtremesParams.OPEN).getDate() +
                            "\n Min Open: " +
                            GetLocalExt.getMin(quotation, date.with(TemporalAdjusters.firstDayOfMonth()), date.with(TemporalAdjusters.lastDayOfMonth()), GetLocalExt.ExtremesParams.OPEN).getValue() +
                            " z dnia: " + GetLocalExt.getMin(quotation, date.with(TemporalAdjusters.firstDayOfMonth()), date.with(TemporalAdjusters.lastDayOfMonth()), GetLocalExt.ExtremesParams.OPEN).getDate());
                    date = date.plusMonths(1);
                }
                dataOk = true;
            } else if (answer.equals("N") || answer.equals("n")) {
                //call month choice function
                periodMonth(quotation);
                dataOk = true;
            } else System.out.println("Wprowadź odpowiedź T lub N");
        }
    }

    public static void getMonthsForYear(Quotation quotation) {
        month.clear();
        for (Price x : quotation.getPrices()) {
            if (x.getDate().getYear() == yearSelected)
                month.add(x.getDate().getMonthValue());
        }
    }

    public static void periodMonth(Quotation quotation) {
        System.out.println("Dla roku " + yearSelected + " dostępne są dane z poniższych miesięcy.\n" +
                "Wybierz jeden z poniższych miesięcy:");
        getMonthsForYear(quotation);
        System.out.println(month);

        boolean dataOk = false;

//--CHOICE MONTH
        while (!dataOk) {
            try {
                Scanner scanner = new Scanner(System.in);
                monthSelected = scanner.nextInt();
                if (month.contains(monthSelected)) {
                    dataOk = true;
                } else {
                    System.out.println("Wprowadzony rok nie jest jednym z listy\n" +
                            "Wybierz jeden z poniższych miesięcy dla którego chcesz otrzymać dane:");
                    System.out.println(month);
                }
            } catch (InputMismatchException exception) {
                System.out.println("Wprowadź proszę miesiąc w formacie cyfry z poniższej listy");
                System.out.println(month);
            }
        }
        System.out.println("Czy chcesz otrzymać dane uproszczone dla miesiąca " + monthSelected + " ?\n" +
                "Jeżeli tak -> wciśnij 'T', jeżeli chcesz otrzymać dane uproszczone dla tygodni -> wcisnij 'N'");
        dataOk = false;

        while (!dataOk) {
            Scanner scanner = new Scanner(System.in);
            String answer = scanner.nextLine();

            //DISPLAY DATA FOR MONTHS AND ...
            if (answer.equals("T") || answer.equals("t")) {
                date = LocalDate.of(yearSelected, monthSelected, 1);
                System.out.println("Dla miesiąca " + date.getMonth().getDisplayName(TextStyle.FULL_STANDALONE, Locale.forLanguageTag("pl-PL"))
                        + " " + yearSelected + " roku:\n" +
                        " maksymalna wartość Open to: " +
                        GetLocalExt.getMax(quotation, date.with(TemporalAdjusters.firstDayOfMonth()), date.with(TemporalAdjusters.lastDayOfMonth()), GetLocalExt.ExtremesParams.OPEN).getValue() +
                        " z dnia: " + GetLocalExt.getMax(quotation, date.with(TemporalAdjusters.firstDayOfMonth()), date.with(TemporalAdjusters.lastDayOfMonth()), GetLocalExt.ExtremesParams.OPEN).getDate() +
                        "\n minimalna wartość Open to: " +
                        GetLocalExt.getMin(quotation, date.with(TemporalAdjusters.firstDayOfMonth()), date.with(TemporalAdjusters.lastDayOfMonth()), GetLocalExt.ExtremesParams.OPEN).getValue() +
                        " z dnia: " + GetLocalExt.getMin(quotation, date.with(TemporalAdjusters.firstDayOfMonth()), date.with(TemporalAdjusters.lastDayOfMonth()), GetLocalExt.ExtremesParams.OPEN).getDate());
                System.out.println("Tygodnie w miesiącu: " + date.getMonth().getDisplayName(TextStyle.FULL_STANDALONE, Locale.forLanguageTag("pl-PL")) + " " + yearSelected + " roku :");
                getWeeksForMonth(date);


            }
        }
    }



    public static void  getWeeksForMonth(LocalDate date) {

        ArrayList<Weeks> weeks = new ArrayList<>();


        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR,date.getYear());
        calendar.set(Calendar.MONTH,date.getMonthValue()-1);
        calendar.set(Calendar.DATE,date.getDayOfMonth());
        System.out.println(calendar.getWeeksInWeekYear());
        System.out.println("mnthFromWeek "+ calendar.get(Calendar.WEEK_OF_YEAR));




/*
        int mnthFromWeek;
        int mnthToWeek;

        week.clear();

        Calendar c = Calendar.getInstance();
        c.set(date.getYear(),date.getMonthValue());

        int start = c.get(Calendar.WEEK_OF_YEAR);
        System.out.println(start);
        String x = date.getYear();

        Calendar calendar = Calendar.getInstance();
//        calendar.set(Calendar.YEAR,date.getYear());
        //calendar.set(Calendar.DATE,date.getMonthValue(),4);
        calendar.set(Calendar.YEAR,date.getYear());
        calendar.set(Calendar.MONTH,date.getMonthValue()-1);
        calendar.set(Calendar.DATE,date.getDayOfMonth());
//        calendar.set(date.getYear(),date.getMonthValue()+1,4);
        System.out.println(calendar.getWeeksInWeekYear());
        System.out.println("mnthFromWeek "+ calendar.get(Calendar.WEEK_OF_YEAR));
*/
        //int week = calendar.get(Calendar.WEEK_OF_YEAR);
        //System.out.println(week);

 /*
    Calendar calendar = Calendar.getInstance();
    calendar.set(date.getYear(),date.getMonthValue());
    calendar.setMinimalDaysInFirstWeek(1);
    int week = calendar.get(Calendar.WEEK_OF_MONTH);
    for (int i = 0;i<week;i++){
     }
*/
 /*
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM");

        String date1 = date.getYear()+"-"+date.getMonth();


        Date date2 = null;
        try {
            date2 = format.parse(date1);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Calendar c = Calendar.getInstance();
        c.setTime(date2);
        int start = c.get(Calendar.WEEK_OF_MONTH);
        System.out.println(start);
*/
    }
}

                    /* Here is an example of using a Local Extremes */
//LocalDate from = LocalDate.parse("2017-01-01");
//LocalDate to = LocalDate.parse("2017-12-31");
//System.out.println("Max Open to: "+ GetLocalExt.getMax(aud,from,to, GetLocalExt.ExtremesParams.OPEN).getValue()+" z dnia: "+GetLocalExt.getMax(aud,from,to, GetLocalExt.ExtremesParams.OPEN).getDate());
//System.out.println("Min Open to: "+ GetLocalExt.getMin(aud,from,to, GetLocalExt.ExtremesParams.OPEN).getValue()+" z dnia: "+GetLocalExt.getMin(aud,from,to, GetLocalExt.ExtremesParams.OPEN).getDate());
//getDatesFromUser();
//                    Splfctn.periodYear(aud);