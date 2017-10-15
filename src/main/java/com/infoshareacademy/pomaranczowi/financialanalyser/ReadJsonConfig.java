package com.infoshareacademy.pomaranczowi.financialanalyser;

public class ReadJsonConfig {

        String url;
        String destination;

    public ReadJsonConfig(String url, String destination) {
        this.url = url;
        this.destination = destination;
    }

    public String getUrl() {
        return url;
    }

    public String getDestination() {
        return destination;
    }
}
