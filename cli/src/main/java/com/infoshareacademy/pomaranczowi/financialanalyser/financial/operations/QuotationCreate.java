package com.infoshareacademy.pomaranczowi.financialanalyser.financial.operations;

import com.infoshareacademy.pomaranczowi.financialanalyser.financial.domain.Price;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileReader;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuotationCreate {

    private static final String DATE_FORMAT = "yyyyMMdd";
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
    private List<Price> quotations = new ArrayList<>();
    private Logger logger = LoggerFactory.getLogger(QuotationCreate.class.getName());

    public int getNumberOfQuotations() {
        return quotations.size();
    }

    public Price getQuotation(int i) {
        return quotations.get(i);
    }

    public void loadDataFromFile(String filepath) {
        try {
            Scanner scanner = new Scanner(new FileReader(filepath));
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                String data[] = scanner.nextLine().split(",");
                LocalDate date = LocalDate.parse(data[1], formatter);
                BigDecimal open = new BigDecimal(data[2]);
                BigDecimal high = new BigDecimal(data[3]);
                BigDecimal low = new BigDecimal(data[4]);
                BigDecimal close = new BigDecimal(data[5]);
                BigDecimal volume = new BigDecimal(data[6]);

                Price price = new Price();
                price.setDate(date);
                price.setOpen(open);
                price.setHigh(high);
                price.setLow(low);
                price.setClose(close);
                price.setVolume(volume);
                quotations.add(price);
            }
            logger.info("Wczytano poprawnie dane wybranego funduszu inwestycyjnego: \n- kod funduszu: "
                    + "," + "\n- ścieżka pliku: " + filepath + ".");
            scanner.close();
        } catch (Exception e) {
            System.out.println("Wystąpił problem z pobraniem wartości funduszu z pliku.");
            logger.warn("Wystąpił błąd przy wczytywaniu danych wybranego funduszu inwestycyjnego z pliku: "
                    + filepath + ".");
        }
    }
}
