package com.infoshareacademy.pomaranczowi.financialanalyser.financial.investment;

import com.infoshareacademy.pomaranczowi.financialanalyser.exceptions.NoSuchDateException;
import com.infoshareacademy.pomaranczowi.financialanalyser.financial.domain.Quotation;
import com.infoshareacademy.pomaranczowi.financialanalyser.financial.operations.QuotationCreate;
import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;
import static org.junit.Assert.assertEquals;

@RunWith(JUnitParamsRunner.class)
public class QuotationInvestmentTest {

    private static String filepath = "../cli/data/fund/testFileWithFundInvestments.txt";

    @BeforeClass
    public static void BeforeClass() throws IOException {
        List<String> list = new ArrayList<>();
        list.add("Name,Date,Open,High,Low,Close,Volume");
        list.add("PZU001,20180108,109.42,109.42,109.42,109.42,0");
        list.add("PZU001,20180109,109.15,109.15,109.15,109.15,0");
        list.add("PZU001,20180110,108.47,108.47,108.47,108.47,0");
        list.add("PZU001,20180111,108.85,108.85,108.85,108.85,0");

            Path file = Paths.get(filepath);
            Files.write(file, list);
    }

    @AfterClass
    public static void AfterClass() throws IOException {
        Path file = Paths.get(filepath);
        if (Files.exists(file)) Files.delete(file);
    }

    @Test
    @Parameters({
            "2018-01-08",
            "2018-01-09",
            "2018-01-10",
            "2018-01-11"
    })
    public void fundInvestmentCorrectExistingDateValueIsNotNegativeTest(String correctDate) {
        //given
        Quotation investment;
        QuotationCreate quotationCreate = new QuotationCreate();
        quotationCreate.loadDataFromFile(filepath);
        investment = InvestmentLoader.load(filepath);

        //when
        LocalDate date = LocalDate.parse(correctDate,DateTimeFormatter.ISO_DATE);

        //then
        try {
            assertThat(investment.getOpen(date)).isNotNegative();
            assertThat(investment.getHigh(date)).isNotNegative();
            assertThat(investment.getLow(date)).isNotNegative();
            assertThat(investment.getClose(date)).isNotNegative();
            assertThat(investment.getVolume(date)).isNotNegative();
        } catch (NoSuchDateException e) {
            fail("No such date");
        }
    }

    @Test
    @Parameters({
            "2017-12-31",
            "2018-01-07",
            "2018-01-12",
            "2019-01-01"
    })
    public void fundInvestmentGetOpenWrongDateTest(String wrongDate) {
        //given
        Quotation investment;
        QuotationCreate quotationCreate = new QuotationCreate();
        quotationCreate.loadDataFromFile(filepath);
        investment = InvestmentLoader.load(filepath);

        //when
        LocalDate date = LocalDate.parse(wrongDate,DateTimeFormatter.ISO_DATE);

        //then
        try {
            investment.getOpen(date);
            fail("Incorrect date!");
        } catch (NoSuchDateException e) {
            assertThat(e);
        }
    }

    @Test
    @Parameters({
            "2018-01-08,109.42,109.42,109.42,109.42,0",
            "2018-01-09,109.15,109.15,109.15,109.15,0",
            "2018-01-10,108.47,108.47,108.47,108.47,0",
            "2018-01-11,108.85,108.85,108.85,108.85,0"
    })
    public void fundInvestmentCorrectExistingDateTest(String correctDate, String open, String high, String low, String close, String volume) {
        //given
        Quotation investment;
        QuotationCreate quotationCreate = new QuotationCreate();
        quotationCreate.loadDataFromFile(filepath);
        investment = InvestmentLoader.load(filepath);

        //when
        LocalDate date = LocalDate.parse(correctDate,DateTimeFormatter.ISO_DATE);

        //then
        try {
            assertThat(investment.getOpen(date)).isEqualTo(new BigDecimal(open));
            assertThat(investment.getHigh(date)).isEqualTo(new BigDecimal(high));
            assertThat(investment.getLow(date)).isEqualTo(new BigDecimal(low));
            assertThat(investment.getClose(date)).isEqualTo(new BigDecimal(close));
            assertThat(investment.getVolume(date)).isEqualTo(new BigDecimal(volume));
        } catch (NoSuchDateException e) {
            fail("No such date");
        }
    }

    @Test
    @Parameters({
            "2018-01-08",
            "2018-01-09",
            "2018-01-10",
            "2018-01-11"
    })
    public void fundInvestmentContainsDateMethodTest(String correctDate) {
        //given
        Quotation investment;
        QuotationCreate quotationCreate = new QuotationCreate();
        quotationCreate.loadDataFromFile(filepath);
        investment = InvestmentLoader.load(filepath);

        //when
        LocalDate date = LocalDate.parse(correctDate,DateTimeFormatter.ISO_DATE);

        //then
        assertThat(investment.containsDate(date)).isTrue();
    }

    @Test
    public void fundInvestmentFirstDatesMethodTest() {
        //given
        Quotation investment;
        QuotationCreate quotationCreate = new QuotationCreate();
        quotationCreate.loadDataFromFile(filepath);
        investment = InvestmentLoader.load(filepath);

        //when
        LocalDate date = LocalDate.parse("2018-01-08",DateTimeFormatter.ISO_DATE);

        //then
        assertEquals(investment.firstDate(),date);
    }

    @Test
    public void fundInvestmentLastDatesMethodTest() {
        //given
        Quotation investment;
        QuotationCreate quotationCreate = new QuotationCreate();
        quotationCreate.loadDataFromFile(filepath);
        investment = InvestmentLoader.load(filepath);

        //when
        LocalDate date = LocalDate.parse("2018-01-11",DateTimeFormatter.ISO_DATE);

        //then
        assertEquals(investment.lastDate(),date);
    }

    @Test
    public void fundInvestmentCountPriceMethodTest() {
        //given
        Quotation investment;
        QuotationCreate quotationCreate = new QuotationCreate();
        quotationCreate.loadDataFromFile(filepath);
        investment = InvestmentLoader.load(filepath);

        //then
        assertEquals(investment.countPrices().intValue(),4);
    }
}
