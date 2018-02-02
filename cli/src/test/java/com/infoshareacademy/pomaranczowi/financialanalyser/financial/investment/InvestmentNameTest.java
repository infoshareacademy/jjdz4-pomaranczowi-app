package com.infoshareacademy.pomaranczowi.financialanalyser.financial.investment;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.PrintWriter;

public class InvestmentNameTest {
    File file;

    @Before
    public void setUp() throws Exception {
        file = new File("nazwa_pliku.txt");
        PrintWriter zapis = new PrintWriter("nazwa_pliku.txt");
        zapis.println("Ala ma kota, a kot ma Alę");
        zapis.close();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void loadInvestmentNameFromFile() throws Exception {
    }

}