package com.infoshareacademy.pomaranczowi.financialanalyser.utilities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LoggerFileNameInit {

    public void getTimeAndDateForFileName(){
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");
        System.setProperty("current.date",dateTimeFormatter.format(LocalDateTime.now()));
    }
}

