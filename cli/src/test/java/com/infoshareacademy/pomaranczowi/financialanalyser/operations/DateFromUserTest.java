package com.infoshareacademy.pomaranczowi.financialanalyser.operations;

import com.infoshareacademy.pomaranczowi.financialanalyser.financial.operations.DateFromUser;
import org.junit.Test;

import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import static org.assertj.core.api.Assertions.assertThat;
public class DateFromUserTest {

    @Test
    public void askForStartDateTest_Correct(){
        DateFromUser dateFromUser = new DateFromUser();
        String input = "2018-01-01";
        System.setIn(new ByteArrayInputStream(input.getBytes())); //set stdin

        dateFromUser.askForStartDate();

        assertThat(dateFromUser.getStartDate()).isEqualTo(LocalDate.parse("2018-01-01", DateTimeFormatter.ISO_LOCAL_DATE));
    }

    @Test
    public void askForEndDateTest_Correct(){

        DateFromUser dateFromUser = new DateFromUser();
        dateFromUser.setStartDate(LocalDate.parse("2018-01-01", DateTimeFormatter.ISO_LOCAL_DATE));
        String input = "2018-01-02";
        System.setIn(new ByteArrayInputStream(input.getBytes())); //set stdin

        dateFromUser.askForEndDate();
        assertThat(dateFromUser.getEndDate()).isEqualTo(LocalDate.parse("2018-01-02", DateTimeFormatter.ISO_LOCAL_DATE));
    }

}