package com.infoshareacademy.pomaranczowi.financialanalyser;


import com.google.gson.Gson;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

public class ImportCurrentData {

//    static String url = "http://bossa.pl/pub/fundinwest/omega/omegafun.zip";
//    static File file = new File("data/stock_data.zip");

    public static void downloadFileFromURL() {
        try {
            Gson gson = new Gson();
            ReadJsonConfig readJsonConfig = gson.fromJson("config.json", ReadJsonConfig.class);
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




