package com.infoshareacademy.pomaranczowi.financialanalyser;

import com.google.gson.Gson;
import lombok.Getter;
import lombok.Setter;
import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

class ImportCurrentData {

    @Setter @Getter private static String dataDirectoryDestination = "";
    @Setter @Getter private static String fundListDestination = "";

    static void downloadFileFromURL() {
        try {
            FileReader fileReader = new FileReader("config.json");
            Gson gson = new Gson();
            ReadJsonConfig readJsonConfig = gson.fromJson(fileReader, ReadJsonConfig.class);
            dataDirectoryDestination = readJsonConfig.getDataDirectoryDestination();
            fundListDestination = readJsonConfig.getFundListDestination();
            downloadData(readJsonConfig.getFundListURL(), readJsonConfig.getFundListDestination());
            System.out.println("Rozpoczęto pobieranie aktualnych danych, proszę czekać.");
            downloadData(readJsonConfig.getUrl(), readJsonConfig.getZipDestination());
            System.out.println("Rozpakowuję plik \"zip\"");
            extractAllFromZipFile(readJsonConfig.getZipDestination(), readJsonConfig.getDataDirectoryDestination());
            System.out.println("Pobieranie i rozpakowanie danych zakończone");
        } catch (FileNotFoundException e) {
            System.out.println("Nie znaleziono prawidłowego pliku konfiguracyjnego \"config.json\"");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Nie można połączyć się z serwerem");
            File stockData = new File(getDataDirectoryDestination());
            File fundListFile = new File(getFundListDestination());
            if(stockData.exists() && fundListFile.exists()){
                System.out.println("Operacja zostanie przeprowadzona na ostatnio pobranych danych");
            }
            else{
                System.out.println("Opcja tymczasowo niedostępna");
            }
        }
    }

    private static void downloadData(String url, String destination) throws IOException {
        ReadableByteChannel readableByteChannel;
        URL website = new URL(url);
        readableByteChannel = Channels.newChannel(website.openStream());
        FileOutputStream fileOutputStream = new FileOutputStream(destination);
        fileOutputStream.getChannel().transferFrom(readableByteChannel, 0, Long.MAX_VALUE);
        fileOutputStream.close();
        readableByteChannel.close();
    }

    private static void extractAllFromZipFile(String source, String destination) {
        try {
            ZipFile zipFile = new ZipFile(source);
            zipFile.extractAll(destination);
        } catch (ZipException e) {
            System.out.println("Nie można rozpakować pliku " + source);
        }
    }
}





