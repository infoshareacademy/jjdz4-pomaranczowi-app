package com.infoshareacademy.pomaranczowi.financialanalyser.operations;


import com.infoshareacademy.pomaranczowi.financialanalyser.financial.domain.Price;
import com.infoshareacademy.pomaranczowi.financialanalyser.financial.domain.Quotation;
import com.infoshareacademy.pomaranczowi.financialanalyser.financial.operations.LocalExt;
import com.infoshareacademy.pomaranczowi.financialanalyser.financial.operations.Simplify;
import com.infoshareacademy.pomaranczowi.financialanalyser.financial.operations.Weeks;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;


public class SimpllifyTest {

    Quotation testQuotation;
    LocalDate date1 = LocalDate.parse("2015-05-14", DateTimeFormatter.ISO_LOCAL_DATE);
    LocalDate date2 = LocalDate.parse("2015-05-15", DateTimeFormatter.ISO_LOCAL_DATE);
    LocalDate date3 = LocalDate.parse("2015-05-16", DateTimeFormatter.ISO_LOCAL_DATE);
    LocalDate date4 = LocalDate.parse("2016-06-14", DateTimeFormatter.ISO_LOCAL_DATE);
    LocalDate date5 = LocalDate.parse("2016-07-15", DateTimeFormatter.ISO_LOCAL_DATE);
    LocalDate date6 = LocalDate.parse("2016-08-16", DateTimeFormatter.ISO_LOCAL_DATE);

    Simplify simplify = new Simplify();

    @Before
    public void before() {
        //Date,Open,High,Low,Close,Volume
        Price price1 = new Price(date1, BigDecimal.valueOf(1), BigDecimal.valueOf(4), BigDecimal.valueOf(7), BigDecimal.valueOf(10), BigDecimal.valueOf(13));
        Price price2 = new Price(date2, BigDecimal.valueOf(2), BigDecimal.valueOf(5), BigDecimal.valueOf(8), BigDecimal.valueOf(11), BigDecimal.valueOf(14));
        Price price3 = new Price(date3, BigDecimal.valueOf(3), BigDecimal.valueOf(6), BigDecimal.valueOf(9), BigDecimal.valueOf(12), BigDecimal.valueOf(15));
        Price price4 = new Price(date4, BigDecimal.valueOf(1), BigDecimal.valueOf(4), BigDecimal.valueOf(7), BigDecimal.valueOf(10), BigDecimal.valueOf(13));
        Price price5 = new Price(date5, BigDecimal.valueOf(2), BigDecimal.valueOf(5), BigDecimal.valueOf(8), BigDecimal.valueOf(11), BigDecimal.valueOf(14));
        Price price6 = new Price(date6, BigDecimal.valueOf(3), BigDecimal.valueOf(6), BigDecimal.valueOf(9), BigDecimal.valueOf(12), BigDecimal.valueOf(15));

        ArrayList<Price> testPrices = new ArrayList<>(Arrays.asList(price1, price2, price3, price4, price5, price6));
        testQuotation = new Quotation(testPrices, "USD");
    }

    @Test
    public void getYearTest() {

        Integer[] exp = {2016, 2015};
        simplify.getYear(testQuotation);

        assertThat(simplify.year).containsExactlyInAnyOrder(exp);
    }

    @Test
    public void getMonthsForYearTest() {
        simplify.month.clear();
        Integer[] exp = {6, 7, 8};
        simplify.getMonthsForYear(testQuotation, 2016);
        assertThat(simplify.month).containsExactlyInAnyOrder(exp);
    }

    @Test
    public void getWeeksForMonthTest() {
        //method gives start, stop dates and no of week, in month represented by first day of month (LocalDate)
        simplify.week.clear();
        simplify.getWeeksForMonth(LocalDate.parse("2015-05-01", DateTimeFormatter.ISO_LOCAL_DATE));
        for (Weeks x : simplify.week) {
            assertThat(x.getFrom()).isIn("2015-05-01", "2015-05-04", "2015-05-11", "2015-05-18", "2015-05-25");
            assertThat(x.getTo()).isIn("2015-05-03", "2015-05-10", "2015-05-17", "2015-05-24", "2015-05-31");
            assertThat(x.getWeek()).isIn(18, 19, 20, 21, 22);
        }
    }

    @Test
    public void periodWeekTest() {
        simplify.week.clear();
        simplify.periodWeek(testQuotation, 2015, 1);
        for (Weeks x : simplify.week) {
            assertThat(x.getFrom()).isIn("2015-01-01", "2015-01-05", "2015-01-12", "2015-01-19", "2015-01-26");
            assertThat(x.getTo()).isIn("2015-01-04", "2015-01-11", "2015-01-18", "2015-01-25", "2015-01-31");
            assertThat(x.getWeek()).isIn(1, 2, 3, 4, 5);
        }
    }

    @Test
    public void resultTest() {
        LocalExt test = simplify.result(testQuotation, LocalDate.parse("2015-05-01", DateTimeFormatter.ISO_LOCAL_DATE), LocalDate.parse("2015-05-31", DateTimeFormatter.ISO_LOCAL_DATE));
        assertThat(test.getStartDate()).isEqualTo("2015-05-01");
        assertThat(test.getEndDate()).isEqualTo("2015-05-31");
        assertThat(test.getMaxOpen(testQuotation).getValue().intValue()).isEqualTo(3);
        assertThat(test.getMaxOpen(testQuotation).getDate()).isEqualTo("2015-05-16");
    }

    @Test
    public void periodMonthTest() {

        simplify.month.clear();
        String input = "N";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        simplify.periodMonth(testQuotation, 2016);

        assertThat(simplify.month).containsExactlyInAnyOrder(6, 7, 8);
    }

}