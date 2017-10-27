package com.infoshareacademy.pomaranczowi.financialanalyser;

public class ReadJsonConfig {

    private String url;
    private String zipDestination;
    private String dataDirectoryDestination;
    private String fundListURL;
    private String fundListDestination;


    public ReadJsonConfig(String url, String zipDestination, String dataDirectoryDestination, String fundListURL,
                          String fundListDestination) {
        this.url = url;
        this.zipDestination = zipDestination;
        this.dataDirectoryDestination = dataDirectoryDestination;
        this.fundListURL = fundListURL;
        this.fundListDestination = fundListDestination;
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

    String getFundListURL() {
        return fundListURL;
    }

    String getFundListDestination() {
        return fundListDestination;
    }
}
