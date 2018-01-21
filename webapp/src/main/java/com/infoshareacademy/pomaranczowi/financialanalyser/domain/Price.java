package com.infoshareacademy.pomaranczowi.financialanalyser.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@NamedQueries({
        @NamedQuery(name = "getPricesByDate", query = "FROM Price p WHERE p.id =:quotationId AND p.date=:localDate"),
        @NamedQuery(name = "getPricesFromDateToDate", query = "select p from Price p join Quotation q on q.id = p.quotation.id where q.code=:quotationCode AND p.date>:startDate AND p.date<:endDate"),
        //@NamedQuery(name = "getPricesByDate2", query = "FROM Price.quotation JOIN Quotation WHERE p.date=:localDate"),
        @NamedQuery(name = "getpricefromQurrencyCode", query = "select p from Price p join Quotation q on q.id = p.quotation.id where q.code=:quotationCode AND p.date=:userDate")
})


public class Price {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(nullable=false, unique=true)
    private Long id;

    @Column
    private LocalDate date;
    private BigDecimal open;
    private BigDecimal high;
    private BigDecimal low;
    private BigDecimal close;
    private BigDecimal volume;
    private String quotationCode;

    public String getQuotationCode() {
        return quotationCode;
    }

    public void setQuotationCode(String quotationCode) {
        this.quotationCode = quotationCode;
    }
    //@JoinColumn(name = "quot")

    //my
    //@ManyToOne

    @ManyToOne
    @JoinColumn(name="quotation_id")
    private Quotation quotation;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public BigDecimal getOpen() {
        return open;
    }

    public void setOpen(BigDecimal open) {
        this.open = open;
    }

    public BigDecimal getHigh() {
        return high;
    }

    public void setHigh(BigDecimal high) {
        this.high = high;
    }

    public BigDecimal getLow() {
        return low;
    }

    public void setLow(BigDecimal low) {
        this.low = low;
    }

    public BigDecimal getClose() {
        return close;
    }

    public void setClose(BigDecimal close) {
        this.close = close;
    }

    public BigDecimal getVolume() {
        return volume;
    }

    public void setVolume(BigDecimal volume) {
        this.volume = volume;
    }

    public Quotation getQuotation() {
        return quotation;
    }

    public void setQuotation(Quotation quotation) {
        this.quotation = quotation;
    }
}










