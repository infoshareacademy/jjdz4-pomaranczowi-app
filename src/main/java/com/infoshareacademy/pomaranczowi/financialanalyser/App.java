package com.infoshareacademy.pomaranczowi.financialanalyser;

public class App
{
    public static void main( String[] args ) {

        System.out.println("Hello world.");
        ImportCurrentData.downloadFileFromURL(ImportCurrentData.url, ImportCurrentData.file);
    }
}
