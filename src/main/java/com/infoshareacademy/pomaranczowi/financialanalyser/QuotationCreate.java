package com.infoshareacademy.pomaranczowi.financialanalyser;

import java.io.FileReader;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

class QuotationCreate {

    private static final String DATE_FORMAT = "yyyyMMdd";
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
    private ArrayList<Price> quotations = new ArrayList<>();

    int getNumberOfQuotations() {
        return quotations.size();
    }

    Price getQuotation(int i) {
        return quotations.get(i);
    }

    void loadDataFromFile(String filepath) {
        try {
            Scanner scanner = new Scanner(new FileReader(filepath));
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                String data[] = scanner.nextLine().split(",");
                String name = data[0];
                LocalDate date = LocalDate.parse(data[1],formatter);
                BigDecimal open = new BigDecimal(data[2]);
                BigDecimal high = new BigDecimal(data[3]);
                BigDecimal low = new BigDecimal(data[4]);
                BigDecimal close = new BigDecimal(data[5]);
                BigDecimal volume = new BigDecimal(data[6]);

                Price price = new Price();
                price.setName(name);
                price.setDate(date);
                price.setOpen(open);
                price.setHigh(high);
                price.setLow(low);
                price.setClose(close);
                price.setVolume(volume);
                quotations.add(price);
            }
            scanner.close();

        } catch (Exception e) {
            System.out.println("Wystąpił problem z pobraniem wartości funduszu z pliku.");
        }
    }
}
