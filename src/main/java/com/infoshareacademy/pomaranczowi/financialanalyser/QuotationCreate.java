package com.infoshareacademy.pomaranczowi.financialanalyser;

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
    private List<Quotation> quotations = new ArrayList<>();

    public int getNumberOfQuotations() {
        return quotations.size();
    }

    public Quotation getQuotation(int i) {
        return quotations.get(i);
    }

    public void loadDataFromFile(String filepath) {
        try {
            Scanner scanner = new Scanner(new FileReader(filepath));
            scanner.nextLine();
            while (scanner.hasNextLine()) {
                String data[] = scanner.nextLine().split(",");
                String name = data[0];
                LocalDate date = LocalDate.parse(data[1], formatter);
                BigDecimal open = new BigDecimal(data[2]);   // Double.parseDouble(data[2]);
                BigDecimal high = new BigDecimal(data[3]);  // Double.parseDouble(data[3]);
                BigDecimal low = new BigDecimal(data[4]);    // Double.parseDouble(data[4]);
                BigDecimal close = new BigDecimal(data[5]); // Double.parseDouble(data[5]);
                BigDecimal volume = new BigDecimal(data[6]); // Double.parseDouble(data[6]);

                Quotation quotation = new Quotation(name, date, open, high, low, close, volume);
                quotations.add(quotation);
            }
            scanner.close();

        } catch (Exception e) {

        }
    }
}
