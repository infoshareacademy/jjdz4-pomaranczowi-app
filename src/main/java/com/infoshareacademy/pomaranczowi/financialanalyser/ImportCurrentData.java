package com.infoshareacademy.pomaranczowi.financialanalyser;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class ImportCurrentData {

//    static String url = "http://bossa.pl/pub/fundinwest/omega/omegafun.zip";
//    static File file = new File("data/stock_data.zip");

    static void downloadFileFromURL() {
        try {
            FileReader fileReader = new FileReader("config.json");
            Gson gson = new Gson();
            ReadJsonConfig readJsonConfig = gson.fromJson(fileReader, ReadJsonConfig.class);
            URL website = new URL(readJsonConfig.getUrl());
            ReadableByteChannel readableByteChannel;
            readableByteChannel = Channels.newChannel(website.openStream());
            FileOutputStream fileOutputStream = new FileOutputStream(readJsonConfig.getDestination());
            fileOutputStream.getChannel().transferFrom(readableByteChannel, 0, Long.MAX_VALUE);
            fileOutputStream.close();
            readableByteChannel.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}





