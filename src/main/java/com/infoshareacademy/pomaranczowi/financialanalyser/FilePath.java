package com.infoshareacademy.pomaranczowi.financialanalyser;


public class FilePath {
    int id;
    String path;
    String name;
    String code;

    public FilePath(int id, String path, String name, String code) {
        this.id = id;
        this.path = path;
        this.name = name;
        this.code = code;
    }


    public String getName() {
    return name;
    }
}