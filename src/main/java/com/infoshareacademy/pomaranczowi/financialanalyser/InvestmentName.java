package com.infoshareacademy.pomaranczowi.financialanalyser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class InvestmentName {

    Menu chooseInvestmentName = new Menu("Fundusze inwestycyjne");
    private ArrayList<String> investmentName = new ArrayList<>();
    private ArrayList<String> investvestmentFileName = new ArrayList<>();

    ArrayList<String> loadInvestmentNameFromFile(String filepath) {

        File file = new File(filepath);
        Scanner fileScanner = null;
        try {
            fileScanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("\n\n\nNie znaleziono pliku: " + filepath + " zawierającego listę funduszy inwestycyjnych.");
        }

        Pattern pattern = Pattern.compile("([0-9]{4}-[0-9]{2}-[0-9]{2}) *([0-9]{2}:[0-9]{2}) *(\\d*) (\\w*) *(\\S*) *(.*)");
        chooseInvestmentName = new Menu("Fundusze inwestycyjne");

        try {
            while (fileScanner != null && fileScanner.hasNextLine()) {
                Matcher matcher = pattern.matcher(fileScanner.nextLine());
                if (matcher.matches()) {
                    investvestmentFileName.add(matcher.group(5));
                    chooseInvestmentName.add(matcher.group(6));
                    investmentName.add(matcher.group(6));
                }
            }
        } catch (NullPointerException exception) {
            System.out.println("Wystąpił problem z wczytaniem listy funduszy inwestycyjnych.");
        }

    return investvestmentFileName;
    }

    String getInvestmentName(int i) {
        return investmentName.get(i);
    }

}
