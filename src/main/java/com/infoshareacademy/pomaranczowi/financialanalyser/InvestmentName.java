package com.infoshareacademy.pomaranczowi.financialanalyser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class InvestmentName {

    Menu investmentNameMenu = new Menu("Fundusze inwestycyjne");
    ArrayList<FilePath> filePaths = new ArrayList<>();

    ArrayList<FilePath> loadInvestmentNameFromFile(String filepath) {
        int id = 0;

        File file = new File(filepath);
        Scanner fileScanner = null;
        try {
            fileScanner = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("\n\n\nNie znaleziono pliku: " + filepath + " zawierającego listę funduszy inwestycyjnych.");
        }

        Pattern pattern = Pattern.compile("([0-9]{4}-[0-9]{2}-[0-9]{2}) *([0-9]{2}:[0-9]{2}) *(\\d*) (\\w*) *(\\S*) *(.*)");
        investmentNameMenu = new Menu("Fundusze inwestycyjne");

        try {
            while (fileScanner != null && fileScanner.hasNextLine()) {
                Matcher matcher = pattern.matcher(fileScanner.nextLine());
                if (matcher.matches()) {
                    FilePath filePath = new FilePath(id,matcher.group(5),matcher.group(6));
                    id++;
                    filePaths.add(filePath);
                    investmentNameMenu.add(matcher.group(6));
                }
            }
        } catch (NullPointerException exception) {
            System.out.println("Wystąpił problem z wczytaniem listy funduszy inwestycyjnych.");
        }
        investmentNameMenu.add("Powrót");
        return filePaths;
    }
}
