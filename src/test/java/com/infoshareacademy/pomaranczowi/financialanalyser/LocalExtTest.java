package com.infoshareacademy.pomaranczowi.financialanalyser;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class LocalExtTest {

    @BeforeClass
    public static void beforeClass() {

        List<String> list = new ArrayList<>();
        list.add("AUD,19930113,1.0714,1.0715,1.0716,1.0717,0");
        list.add("AUD,19930114,1.0715,1.0716,1.0717,1.0718,0");
        list.add("AUD,19930115,1.0716,1.0717,1.0718,1.0719,0");

        try {
            Files.write(Paths.get("data/currency/test.txt"), list);
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
    public void getMaxOpen() throws Exception {
        LocalExt localExt = new LocalExt();

        LocalDate startDate = LocalDate.parse("19931010", DateTimeFormatter.ofPattern("yyyyMMdd"));
        LocalDate endDate = LocalDate.parse("19931010",DateTimeFormatter.ofPattern("yyyyMMdd"));


    }

}