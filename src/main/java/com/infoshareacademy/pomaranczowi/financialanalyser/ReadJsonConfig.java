package com.infoshareacademy.pomaranczowi.financialanalyser;

public class ReadJsonConfig {

    private String url;
    private String zipDestination;
    private String dataDirectoryDestination;


    public ReadJsonConfig(String url, String zipDestination, String dataDirectoryDestination) {
        this.url = url;
        this.zipDestination = zipDestination;
        this.dataDirectoryDestination = dataDirectoryDestination;
    }


    String getDataDirectoryDestination() {
        return dataDirectoryDestination;
    }

    String getUrl() {
        return url;
    }

    String getZipDestination() {
        return zipDestination;
    }
}
