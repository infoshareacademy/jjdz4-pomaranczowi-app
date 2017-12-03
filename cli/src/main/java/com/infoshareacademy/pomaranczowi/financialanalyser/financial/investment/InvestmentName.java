package com.infoshareacademy.pomaranczowi.financialanalyser.financial.investment;

import com.infoshareacademy.pomaranczowi.financialanalyser.menu.Menu;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InvestmentName {

    public Menu investmentNameMenu = new Menu("Fundusze inwestycyjne");
    public Map fundCodeName = new TreeMap();
    public Map fundCodePath = new TreeMap();
    Logger logger = LoggerFactory.getLogger(InvestmentName.class.getName());

    public void loadInvestmentNameFromFile(String filepath) {
        File file = new File(filepath);
        Scanner fileScanner = null;
        try {
            fileScanner = new Scanner(file);
            logger.info("Wczytano plik z listą funduszy inwestycyjmych: " + filepath + "");
        } catch (FileNotFoundException e) {
            System.out.println("\n\n\nNie znaleziono pliku: " + filepath + " zawierającego listę funduszy inwestycyjnych.");
            logger.error("Wystąpił błąd przy wczytywaniu danych z pliku! Nie udało się wczytać listy funduszy inwestycyjnego z pliku " + filepath +"!");
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
                } else {
                    logger.debug("Pojedynczy wiersz z pliku " + filepath + " nie pasował do wyrażenia regularnego.Wiersz " + matcher.toString());
                }
            }
        } catch (NullPointerException exception) {
            System.out.println("Wystąpił problem z wczytaniem listy funduszy inwestycyjnych.");
            logger.warn("Wystąpił błąd przy przypisywaniu odpowiednich wartości do zmienncyh na podtsawie wyrażenia regularnego.");
        }
        investmentNameMenu.add("Powrót");
    }
}
