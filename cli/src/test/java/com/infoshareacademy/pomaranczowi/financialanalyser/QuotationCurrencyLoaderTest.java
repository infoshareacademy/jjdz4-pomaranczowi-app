/*
package com.infoshareacademy.pomaranczowi.financialanalyser;

import org.junit.BeforeClass;
import org.junit.Test;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

public class QuotationCurrencyLoaderTest {

    @BeforeClass
    public static void BeforeClass() {

        List<String> list = new ArrayList<>();
        list.add("AUD,19930113,1.0714,1.0715,1.0716,1.0717,0");
        list.add("AUD,19930114,1.0715,1.0716,1.0717,1.0718,0");
        list.add("AUD,19930115,1.0716,1.0717,1.0718,1.0719,0");

        try {
            Files.write(Paths.get("cli/data/currency/test.txt"), list);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void currencyGettersCorrectDateTest() {
        //given
        Quotation currency = new Quotation();

        try {
            currency = CurrencyLoader.load("test");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //when
        LocalDate date = LocalDate.parse("19930113", DateTimeFormatter.ofPattern("yyyyMMdd"));

        //then
        try {
            assertThat(currency.getOpen(date)).isEqualTo(new BigDecimal("1.0714"));
            assertThat(currency.getHigh(date)).isEqualTo(new BigDecimal("1.0715"));
            assertThat(currency.getLow(date)).isEqualTo(new BigDecimal("1.0716"));
            assertThat(currency.getClose(date)).isEqualTo(new BigDecimal("1.0717"));
            assertThat(currency.getVolume(date)).isEqualTo(new BigDecimal("0"));
        } catch (NoSuchDateException e) {
            fail("No such date");
        }
    }

    @Test
    public void currencyGettersWrongDateTest() {
        //given
        Quotation currency = new Quotation();

        try {
            currency = CurrencyLoader.load("test");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //when
        LocalDate date = LocalDate.parse("20030520", DateTimeFormatter.ofPattern("yyyyMMdd"));

        //then
        try {
            currency.getOpen(date);
            fail("No exception thrown");
            currency.getHigh(date);
            fail("No exception thrown");
            currency.getLow(date);
            fail("No exception thrown");
            currency.getClose(date);
            fail("No exception thrown");
            currency.getVolume(date);
            fail("No exception thrown");
        } catch (NoSuchDateException e) {
            assertThat(e);
        }
    }

    @Test
    public void currencyFirstDateLastDateTest() {
        //given
        Quotation currency = new Quotation();

        try {
            currency = CurrencyLoader.load("test");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //when
        LocalDate firstDate = LocalDate.parse("19930113",DateTimeFormatter.ofPattern("yyyyMMdd"));
        LocalDate lastDate = LocalDate.parse("19930115",DateTimeFormatter.ofPattern("yyyyMMdd"));

        //then
        assertThat(currency.firstDate()).isEqualTo(firstDate);
        assertThat(currency.lastDate()).isEqualTo(lastDate);
    }

    @Test
    public void currencyContainsDateTest() {
        //given
        Quotation currency = new Quotation();

        try {
            currency = CurrencyLoader.load("test");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //when
        LocalDate correctDate = LocalDate.parse("19930114",DateTimeFormatter.ofPattern("yyyyMMdd"));
        LocalDate wrongDate = LocalDate.parse("20100114",DateTimeFormatter.ofPattern("yyyyMMdd"));

        //then
        assertThat(currency.containsDate(correctDate)).isTrue();
        assertThat(currency.containsDate(wrongDate)).isFalse();
    }
}*/
