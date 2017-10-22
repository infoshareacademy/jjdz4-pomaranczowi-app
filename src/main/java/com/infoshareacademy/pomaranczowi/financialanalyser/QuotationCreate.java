package com.infoshareacademy.pomaranczowi.financialanalyser;

import java.io.FileReader;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class QuotationCreate {

    private static final String DATE_FORMAT = "yyyyMMdd";
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
    private List<Quotation> quotations = new ArrayList<>();

    int getNumberOfQuotations() {
        return quotations.size();
    }

    Quotation getQuotation(int i) {
        return quotations.get(i);
    }

    void loadDataFromFile(String filepath) {
        try {
            Scanner scanner = new Scanner(new FileReader(filepath));
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                String data[] = scanner.nextLine().split(",");
                String name = data[0];
                LocalDate date = LocalDate.parse(data[1], formatter);
                BigDecimal open = new BigDecimal(data[2]);
                BigDecimal high = new BigDecimal(data[3]);
                BigDecimal low = new BigDecimal(data[4]);
                BigDecimal close = new BigDecimal(data[5]);
                BigDecimal volume = new BigDecimal(data[6]);

                Quotation quotation = new Quotation();
                quotation.setName(name);
                quotation.setDate(date);
                quotation.setOpen(open);
                quotation.setHigh(high);
                quotation.setLow(low);
                quotation.setClose(close);
                quotation.setVolume(volume);
                quotations.add(quotation);
            }
            scanner.close();

        } catch (Exception e) {
            System.out.println("Wystąpił problem z pobraniem wartości funduszu z pliku.");
        }
    }
}
