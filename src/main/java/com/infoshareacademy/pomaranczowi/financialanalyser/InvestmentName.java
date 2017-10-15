package com.infoshareacademy.pomaranczowi.financialanalyser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InvestmentName {

    public String filename;
    public String investmentName;
    public Menu menu;


    //public void loadInvestmentNameFromFile(String filepath) {
    public ArrayList<String> loadInvestmentNameFromFile(String filepath) {

        ArrayList<String> investmentName = new ArrayList<>();
        File file = new File(filepath);
        Scanner fileScanner = null;
        try {
            fileScanner = new Scanner(file);
            System.out.println("\n\n\nWczytano plik: " + filepath);
        } catch (FileNotFoundException e) {
            System.out.println("\n\n\nNie znaleziono pliku: " + filepath);
        }

        Pattern pattern = Pattern.compile("([0-9]{4}-[0-9]{2}-[0-9]{2}) *([0-9]{2}:[0-9]{2}) *(\\d*) (\\w*) *(\\S*) *(.*)");
        menu = new Menu("Fundusze inwestycyjne");

        try {
            while (fileScanner.hasNextLine()) {
                Matcher matcher = pattern.matcher(fileScanner.nextLine());
                if (matcher.matches()) {
                    String filename = matcher.group(5);
                    String investName = matcher.group(6);
                    //System.out.println("file name: " + filename + " InvestName: " + investName);
                    investmentName.add(investName);
                    menu.add(investName);
                }
            }
        } catch (NullPointerException exception) {

        }

    return investmentName;
    }



}
