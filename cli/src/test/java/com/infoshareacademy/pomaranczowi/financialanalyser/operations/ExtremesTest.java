package com.infoshareacademy.pomaranczowi.financialanalyser.operations;

import com.infoshareacademy.pomaranczowi.financialanalyser.financial.domain.Extremes;
import com.infoshareacademy.pomaranczowi.financialanalyser.financial.domain.Price;
import com.infoshareacademy.pomaranczowi.financialanalyser.financial.domain.Quotation;
import com.infoshareacademy.pomaranczowi.financialanalyser.financial.operations.GlobalExt;
import com.infoshareacademy.pomaranczowi.financialanalyser.financial.operations.LocalExt;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(JUnitParamsRunner.class)
public class ExtremesTest {
    Quotation testQuotation;
        LocalDate date1 = LocalDate.parse("2016-05-14", DateTimeFormatter.ISO_LOCAL_DATE);
        LocalDate date2 = LocalDate.parse("2016-05-15", DateTimeFormatter.ISO_LOCAL_DATE);
        LocalDate date3 = LocalDate.parse("2016-05-16", DateTimeFormatter.ISO_LOCAL_DATE);

    @Before
    public void before (){
        //Date,Open,High,Low,Close,Volume
        Price price1 = new Price(date1, BigDecimal.valueOf(1),BigDecimal.valueOf(4),BigDecimal.valueOf(7),BigDecimal.valueOf(10),BigDecimal.valueOf(13));
        Price price2 = new Price(date2, BigDecimal.valueOf(2),BigDecimal.valueOf(5),BigDecimal.valueOf(8),BigDecimal.valueOf(11),BigDecimal.valueOf(14));
        Price price3 = new Price(date3, BigDecimal.valueOf(3),BigDecimal.valueOf(6),BigDecimal.valueOf(9),BigDecimal.valueOf(12),BigDecimal.valueOf(15));

        ArrayList<Price> testPrices = new ArrayList<>(Arrays.asList(price1,price2,price3));
        testQuotation = new Quotation(testPrices, "USD");
    }

    //-- Local Max

    @Test
    @Parameters({
            "2016-05-14, 2016-05-15, 2, 2016-05-15",
            "2016-05-15, 2016-05-16, 3, 2016-05-16",
    })
    public void ekstremaLokalneTest_getMaxOpen(String dateFrom, String dateTo, int expectedValue, String expectedDate){

        LocalExt localExt = new LocalExt();
        localExt.setStartDate(LocalDate.parse(dateFrom, DateTimeFormatter.ISO_LOCAL_DATE));
        localExt.setEndDate(LocalDate.parse(dateTo, DateTimeFormatter.ISO_LOCAL_DATE));
        Extremes extremes = localExt.getMaxOpen(testQuotation);

        assertThat(extremes.getValue().intValue()).isEqualTo(expectedValue);
        assertThat(extremes.getDate()).isEqualTo(LocalDate.parse(expectedDate, DateTimeFormatter.ISO_LOCAL_DATE));
    }

    @Test
    @Parameters({
            "2016-05-14, 2016-05-15, 5, 2016-05-15",
            "2016-05-15, 2016-05-16, 6, 2016-05-16",
    })
    public void ekstremaLokalneTest_getMaxHigh(String dateFrom, String dateTo, int expectedValue, String expectedDate){

        LocalExt localExt = new LocalExt();
        localExt.setStartDate(LocalDate.parse(dateFrom, DateTimeFormatter.ISO_LOCAL_DATE));
        localExt.setEndDate(LocalDate.parse(dateTo, DateTimeFormatter.ISO_LOCAL_DATE));
        Extremes extremes = localExt.getMaxHigh(testQuotation);

        assertThat(extremes.getValue().intValue()).isEqualTo(expectedValue);
        assertThat(extremes.getDate()).isEqualTo(LocalDate.parse(expectedDate, DateTimeFormatter.ISO_LOCAL_DATE));;
    }

    @Test
    @Parameters({
            "2016-05-14, 2016-05-15, 8, 2016-05-15",
            "2016-05-15, 2016-05-16, 9, 2016-05-16",
    })
    public void ekstremaLokalneTest_getMaxLow(String dateFrom, String dateTo, int expectedValue, String expectedDate){

        LocalExt localExt = new LocalExt();
        localExt.setStartDate(LocalDate.parse(dateFrom, DateTimeFormatter.ISO_LOCAL_DATE));
        localExt.setEndDate(LocalDate.parse(dateTo, DateTimeFormatter.ISO_LOCAL_DATE));
        Extremes extremes = localExt.getMaxLow(testQuotation);

        assertThat(extremes.getValue().intValue()).isEqualTo(expectedValue);
        assertThat(extremes.getDate()).isEqualTo(LocalDate.parse(expectedDate, DateTimeFormatter.ISO_LOCAL_DATE));;
    }

    @Test
    @Parameters({
            "2016-05-14, 2016-05-15, 11, 2016-05-15",
            "2016-05-15, 2016-05-16, 12, 2016-05-16",
    })
    public void ekstremaLokalneTest_getMaxClose(String dateFrom, String dateTo, int expectedValue, String expectedDate){

        LocalExt localExt = new LocalExt();
        localExt.setStartDate(LocalDate.parse(dateFrom, DateTimeFormatter.ISO_LOCAL_DATE));
        localExt.setEndDate(LocalDate.parse(dateTo, DateTimeFormatter.ISO_LOCAL_DATE));
        Extremes extremes = localExt.getMaxClose(testQuotation);

        assertThat(extremes.getValue().intValue()).isEqualTo(expectedValue);
        assertThat(extremes.getDate()).isEqualTo(LocalDate.parse(expectedDate, DateTimeFormatter.ISO_LOCAL_DATE));;
    }

    @Test
    @Parameters({
            "2016-05-14, 2016-05-15, 14, 2016-05-15",
            "2016-05-15, 2016-05-16, 15, 2016-05-16",
    })
    public void ekstremaLokalneTest_getMaxVolume(String dateFrom, String dateTo, int expectedValue, String expectedDate){

        LocalExt localExt = new LocalExt();
        localExt.setStartDate(LocalDate.parse(dateFrom, DateTimeFormatter.ISO_LOCAL_DATE));
        localExt.setEndDate(LocalDate.parse(dateTo, DateTimeFormatter.ISO_LOCAL_DATE));
        Extremes extremes = localExt.getMaxVolume(testQuotation);

        assertThat(extremes.getValue().intValue()).isEqualTo(expectedValue);
        assertThat(extremes.getDate()).isEqualTo(LocalDate.parse(expectedDate, DateTimeFormatter.ISO_LOCAL_DATE));;
    }

    //-- Local Min

    @Test
    @Parameters({
            "2016-05-14, 2016-05-15, 1, 2016-05-14",
            "2016-05-15, 2016-05-16, 2, 2016-05-15",
    })
    public void ekstremaLokalneTest_getMinOpen(String dateFrom, String dateTo, int expectedValue, String expectedDate){

        LocalExt localExt = new LocalExt();
        localExt.setStartDate(LocalDate.parse(dateFrom, DateTimeFormatter.ISO_LOCAL_DATE));
        localExt.setEndDate(LocalDate.parse(dateTo, DateTimeFormatter.ISO_LOCAL_DATE));
        Extremes extremes = localExt.getMinOpen(testQuotation);

        assertThat(extremes.getValue().intValue()).isEqualTo(expectedValue);
        assertThat(extremes.getDate()).isEqualTo(LocalDate.parse(expectedDate, DateTimeFormatter.ISO_LOCAL_DATE));
    }

    @Test
    @Parameters({
            "2016-05-14, 2016-05-15, 4, 2016-05-14",
            "2016-05-15, 2016-05-16, 5, 2016-05-15",
    })
    public void ekstremaLokalneTest_getMinHigh(String dateFrom, String dateTo, int expectedValue, String expectedDate){

        LocalExt localExt = new LocalExt();
        localExt.setStartDate(LocalDate.parse(dateFrom, DateTimeFormatter.ISO_LOCAL_DATE));
        localExt.setEndDate(LocalDate.parse(dateTo, DateTimeFormatter.ISO_LOCAL_DATE));
        Extremes extremes = localExt.getMinHigh(testQuotation);

        assertThat(extremes.getValue().intValue()).isEqualTo(expectedValue);
        assertThat(extremes.getDate()).isEqualTo(LocalDate.parse(expectedDate, DateTimeFormatter.ISO_LOCAL_DATE));;
    }

    @Test
    @Parameters({
            "2016-05-14, 2016-05-15, 7, 2016-05-14",
            "2016-05-15, 2016-05-16, 8, 2016-05-15",
    })
    public void ekstremaLokalneTest_getMinLow(String dateFrom, String dateTo, int expectedValue, String expectedDate){

        LocalExt localExt = new LocalExt();
        localExt.setStartDate(LocalDate.parse(dateFrom, DateTimeFormatter.ISO_LOCAL_DATE));
        localExt.setEndDate(LocalDate.parse(dateTo, DateTimeFormatter.ISO_LOCAL_DATE));
        Extremes extremes = localExt.getMinLow(testQuotation);

        assertThat(extremes.getValue().intValue()).isEqualTo(expectedValue);
        assertThat(extremes.getDate()).isEqualTo(LocalDate.parse(expectedDate, DateTimeFormatter.ISO_LOCAL_DATE));;
    }

    @Test
    @Parameters({
            "2016-05-14, 2016-05-15, 10, 2016-05-14",
            "2016-05-15, 2016-05-16, 11, 2016-05-15",
    })
    public void ekstremaLokalneTest_getMinClose(String dateFrom, String dateTo, int expectedValue, String expectedDate){

        LocalExt localExt = new LocalExt();
        localExt.setStartDate(LocalDate.parse(dateFrom, DateTimeFormatter.ISO_LOCAL_DATE));
        localExt.setEndDate(LocalDate.parse(dateTo, DateTimeFormatter.ISO_LOCAL_DATE));
        Extremes extremes = localExt.getMinClose(testQuotation);

        assertThat(extremes.getValue().intValue()).isEqualTo(expectedValue);
        assertThat(extremes.getDate()).isEqualTo(LocalDate.parse(expectedDate, DateTimeFormatter.ISO_LOCAL_DATE));;
    }

    @Test
    @Parameters({
            "2016-05-14, 2016-05-15, 13, 2016-05-14",
            "2016-05-15, 2016-05-16, 14, 2016-05-15",
    })
    public void ekstremaLokalneTest_getMinVolume(String dateFrom, String dateTo, int expectedValue, String expectedDate){

        LocalExt localExt = new LocalExt();
        localExt.setStartDate(LocalDate.parse(dateFrom, DateTimeFormatter.ISO_LOCAL_DATE));
        localExt.setEndDate(LocalDate.parse(dateTo, DateTimeFormatter.ISO_LOCAL_DATE));
        Extremes extremes = localExt.getMinVolume(testQuotation);

        assertThat(extremes.getValue().intValue()).isEqualTo(expectedValue);
        assertThat(extremes.getDate()).isEqualTo(LocalDate.parse(expectedDate, DateTimeFormatter.ISO_LOCAL_DATE));;
    }

    //-- Global Max

    @Test
    public void ekstremaGlobalneTest_getMaxOpen(){
        Extremes extremes = GlobalExt.getMaxOpen(testQuotation);
        assertThat(extremes.getValue().intValue()).isEqualTo(3);
        assertThat(extremes.getDate()).isEqualTo(LocalDate.parse("2016-05-16", DateTimeFormatter.ISO_LOCAL_DATE));
    }

    @Test
    public void ekstremaGlobalneTest_getMaxHigh(){
        Extremes extremes = GlobalExt.getMaxHigh(testQuotation);
        assertThat(extremes.getValue().intValue()).isEqualTo(6);
        assertThat(extremes.getDate()).isEqualTo(LocalDate.parse("2016-05-16", DateTimeFormatter.ISO_LOCAL_DATE));
    }

    @Test
    public void ekstremaGlobalneTest_getMaxLow(){
        Extremes extremes = GlobalExt.getMaxLow(testQuotation);
        assertThat(extremes.getValue().intValue()).isEqualTo(9);
        assertThat(extremes.getDate()).isEqualTo(LocalDate.parse("2016-05-16", DateTimeFormatter.ISO_LOCAL_DATE));
    }

    @Test
    public void ekstremaGlobalneTest_getMaxClose(){
        Extremes extremes = GlobalExt.getMaxClose(testQuotation);
        assertThat(extremes.getValue().intValue()).isEqualTo(12);
        assertThat(extremes.getDate()).isEqualTo(LocalDate.parse("2016-05-16", DateTimeFormatter.ISO_LOCAL_DATE));
    }

    @Test
    public void ekstremaGlobalneTest_getMaxVolume(){
        Extremes extremes = GlobalExt.getMaxVolume(testQuotation);
        assertThat(extremes.getValue().intValue()).isEqualTo(15);
        assertThat(extremes.getDate()).isEqualTo(LocalDate.parse("2016-05-16", DateTimeFormatter.ISO_LOCAL_DATE));
    }

    @Test
    public void ekstremaGlobalneTest_getMinOpen(){
        Extremes extremes = GlobalExt.getMinOpen(testQuotation);
        assertThat(extremes.getValue().intValue()).isEqualTo(1);
        assertThat(extremes.getDate()).isEqualTo(LocalDate.parse("2016-05-14", DateTimeFormatter.ISO_LOCAL_DATE));
    }

    @Test
    public void ekstremaGlobalneTest_getMinHigh(){
        Extremes extremes = GlobalExt.getMinHigh(testQuotation);
        assertThat(extremes.getValue().intValue()).isEqualTo(4);
        assertThat(extremes.getDate()).isEqualTo(LocalDate.parse("2016-05-14", DateTimeFormatter.ISO_LOCAL_DATE));
    }

    //-- Global Min

    @Test
    public void ekstremaGlobalneTest_getMinLow(){
        Extremes extremes = GlobalExt.getMinLow(testQuotation);
        assertThat(extremes.getValue().intValue()).isEqualTo(7);
        assertThat(extremes.getDate()).isEqualTo(LocalDate.parse("2016-05-14", DateTimeFormatter.ISO_LOCAL_DATE));
    }

    @Test
    public void ekstremaGlobalneTest_getMinClose(){
        Extremes extremes = GlobalExt.getMinClose(testQuotation);
        assertThat(extremes.getValue().intValue()).isEqualTo(10);
        assertThat(extremes.getDate()).isEqualTo(LocalDate.parse("2016-05-14", DateTimeFormatter.ISO_LOCAL_DATE));
    }

    @Test
    public void ekstremaGlobalneTest_getMinVolume(){
        Extremes extremes = GlobalExt.getMinVolume(testQuotation);
        assertThat(extremes.getValue().intValue()).isEqualTo(13);
        assertThat(extremes.getDate()).isEqualTo(LocalDate.parse("2016-05-14", DateTimeFormatter.ISO_LOCAL_DATE));
    }

}
