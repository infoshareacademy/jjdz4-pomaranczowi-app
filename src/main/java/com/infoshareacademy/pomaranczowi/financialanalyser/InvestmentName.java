package com.infoshareacademy.pomaranczowi.financialanalyser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class InvestmentName {

    Menu investmentNameMenu = new Menu("Fundusze inwestycyjne");
    Map fundCodeName = new TreeMap();
    Map fundCodePath = new TreeMap();

    void loadInvestmentNameFromFile(String filepath) {
        File file = new File(filepath);
        Scanner fileScanner = null;
        try {
            fileScanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("\n\n\nNie znaleziono pliku: " + filepath + " zawierającego listę funduszy inwestycyjnych.");
        }

        Pattern pattern = Pattern.compile("([0-9]{4}-[0-9]{2}-[0-9]{2}) *([0-9]{2}:[0-9]{2}) *(\\d*) (\\w*) *(\\w*)(.\\w*) *(.*)");
        investmentNameMenu = new Menu("Fundusze inwestycyjne");

        try {
            while (fileScanner != null && fileScanner.hasNextLine()) {
                Matcher matcher = pattern.matcher(fileScanner.nextLine());
                if (matcher.matches()) {
                    investmentNameMenu.add(matcher.group(7));
                    fundCodePath.put(matcher.group(5), matcher.group(5) + matcher.group(6));
                    fundCodeName.put(matcher.group(5), matcher.group(7));
                }
            }
        } catch (NullPointerException exception) {
            System.out.println("Wystąpił problem z wczytaniem listy funduszy inwestycyjnych.");
        }
        investmentNameMenu.add("Powrót");
    }
}
