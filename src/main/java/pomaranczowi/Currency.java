package pomaranczowi;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

class Currency {

    public Currency(String path) {

        File file = new File(path);
        Scanner fileScanner = null;
        try {
            fileScanner = new Scanner(file);
            System.out.println("Wczytano plik: "+path);
        } catch (FileNotFoundException e) {
            System.out.println("Nie ma takiego pliku!");
            return;
        }

        // TODO: 24.09.17 Dodać wczytywanie danych z pliku do array'ów w klasie

        dates.add("20160524");
        dates.add("20160525");
        dates.add("20160526");
        dates.add("20160527");
        close.add(0.2345);
        close.add(0.3545);
        close.add(0.6545);
        close.add(1.2345);
    }

    private ArrayList<String> dates = new ArrayList<>(); //Date as a String YYYYMMDD
    private ArrayList<Double>  open = new ArrayList<>();
    private ArrayList<Double> high = new ArrayList<>();
    private ArrayList<Double> low = new ArrayList<>();
    private ArrayList<Double> close = new ArrayList<>();
    private ArrayList<Double> volume = new ArrayList<>();

    public Double getOpen(String date) {
        int i = 0;
        for (String x : dates) {
            if (x.equals(date)) {
                return open.get(i);
            }
            i++;
        }
        return null;
    }

    public Double getHigh(String date) {
        int i = 0;
        for (String x : dates) {
            if (x.equals(date)) {
                return high.get(i);
            }
            i++;
        }
        return null;
    }

    public Double getLow(String date) {
        int i = 0;
        for (String x : dates) {
            if (x.equals(date)) {
                return low.get(i);
            }
            i++;
        }
        return null;
    }

    public Double getClose(String date) {
        int i = 0;
        for (String x : dates) {
            if (x.equals(date)) {
                return close.get(i);
            }
            i++;
        }
        return null;
    }

    public Double getVolume(String date) {
        int i = 0;
        for (String x : dates) {
            if (x.equals(date)) {
                return volume.get(i);
            }
            i++;
        }
        return null;
    }
}