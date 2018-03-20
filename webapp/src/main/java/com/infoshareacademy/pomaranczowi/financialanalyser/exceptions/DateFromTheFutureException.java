package com.infoshareacademy.pomaranczowi.financialanalyser.exceptions;

public class DateFromTheFutureException extends Exception {
    public DateFromTheFutureException() {
    }

    public DateFromTheFutureException(String message) {
        super(message);
    }
}
