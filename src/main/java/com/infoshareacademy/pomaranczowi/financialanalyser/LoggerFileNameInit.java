package com.infoshareacademy.pomaranczowi.financialanalyser;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

class LoggerFileNameInit {

    void getTimeAndDateForFileName(){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
        System.setProperty("current.date",dateTimeFormatter.format(LocalDateTime.now()));
    }
}

