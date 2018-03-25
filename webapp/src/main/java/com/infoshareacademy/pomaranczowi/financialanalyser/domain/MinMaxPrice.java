package com.infoshareacademy.pomaranczowi.financialanalyser.domain;

import java.math.BigDecimal;

public class MinMaxPrice {

    private BigDecimal maxOpen;
    private BigDecimal minOpen;
    private BigDecimal maxLow;
    private BigDecimal minLow;
    private BigDecimal maxHigh;
    private BigDecimal minHigh;
    private BigDecimal maxClose;
    private BigDecimal minClose;
    private String period;

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public BigDecimal getMaxOpen() {
        return maxOpen;
    }

    public void setMaxOpen(BigDecimal maxOpen) {
        this.maxOpen = maxOpen;
    }

    public BigDecimal getMinOpen() {
        return minOpen;
    }

    public void setMinOpen(BigDecimal minOpen) {
        this.minOpen = minOpen;
    }

    public BigDecimal getMaxLow() {
        return maxLow;
    }

    public void setMaxLow(BigDecimal maxLow) {
        this.maxLow = maxLow;
    }

    public BigDecimal getMinLow() {
        return minLow;
    }

    public void setMinLow(BigDecimal minLow) {
        this.minLow = minLow;
    }

    public BigDecimal getMaxHigh() {
        return maxHigh;
    }

    public void setMaxHigh(BigDecimal maxHigh) {
        this.maxHigh = maxHigh;
    }

    public BigDecimal getMinHigh() {
        return minHigh;
    }

    public void setMinHigh(BigDecimal minHigh) {
        this.minHigh = minHigh;
    }

    public BigDecimal getMaxClose() {
        return maxClose;
    }

    public void setMaxClose(BigDecimal maxClose) {
        this.maxClose = maxClose;
    }

    public BigDecimal getMinClose() {
        return minClose;
    }

    public void setMinClose(BigDecimal minClose) {
        this.minClose = minClose;
    }
}
