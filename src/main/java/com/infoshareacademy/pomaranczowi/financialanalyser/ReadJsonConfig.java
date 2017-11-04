package com.infoshareacademy.pomaranczowi.financialanalyser;

import lombok.Getter;

public class ReadJsonConfig {

    @Getter private String url;
    @Getter private String zipDestination;
    @Getter private String dataDirectoryDestination;
    @Getter private String fundListURL;
    @Getter private String fundListDestination;

    public ReadJsonConfig(String url, String zipDestination, String dataDirectoryDestination, String fundListURL,
                          String fundListDestination) {
        this.url = url;
        this.zipDestination = zipDestination;
        this.dataDirectoryDestination = dataDirectoryDestination;
        this.fundListURL = fundListURL;
        this.fundListDestination = fundListDestination;
    }
}
