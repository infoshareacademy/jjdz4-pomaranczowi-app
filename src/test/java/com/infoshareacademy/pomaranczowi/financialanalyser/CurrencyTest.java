package com.infoshareacademy.pomaranczowi.financialanalyser;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;

public class CurrencyTest {

    @BeforeClass
    public static void beforeClass() {

        try {
            Files.write(Paths.get("data/currency/test.txt"), "AUD,19930113,1.0714,1.0715,1.0716,1.0717,0".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public static void afterClass() {

        try {
            Files.delete(Paths.get("data/currency/test.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getTest() {
        //given
        Currency currency = null;

        try {
            currency = new Currency("test");
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
    public void getWrongDate() {

        //given
        Currency currency = null;

        try {
            currency = new Currency("test");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //when
        LocalDate date = LocalDate.parse("19930115", DateTimeFormatter.ofPattern("yyyyMMdd"));

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
}
