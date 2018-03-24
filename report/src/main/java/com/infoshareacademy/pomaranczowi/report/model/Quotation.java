package com.infoshareacademy.pomaranczowi.report.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@NamedQueries({
        @NamedQuery(name = "isQuotationCodeInDB",
                query = "select q.code from Quotation q where q.code=:quotationCode"),
        @NamedQuery(name = "getTheNextFreeQuotationId",
                query = "select MAX(q.id) from Quotation q"),
        @NamedQuery(name = "getAllQuotationList",
                query = "select DISTINCT q.code from Quotation q where q.quotationType=:quotationType"),
        @NamedQuery(name = "getQuotationInfoReport",
                query = "select q from Quotation q where q.code=:code"),
})
public class Quotation {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(nullable=false, unique=true)
    private Integer id;

    @Column
    private String name;

    @Column
    @NotNull
    private String code;

    @Enumerated(EnumType.STRING)
    private QuotationType quotationType;

    public Quotation(Integer id, String name, String code, QuotationType quotationType){
        this.id = id;
        this.name = name;
        this.code = code;
        this.quotationType = quotationType;
    }

    public Quotation(){
    }

    //@OneToMany(mappedBy = "quotation", targetEntity = Price.class ,cascade = CascadeType.ALL, orphanRemoval = false, fetch = FetchType.EAGER)
    //private List<Price> prices = new ArrayList<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*public List<Price> getPrices() {
        return prices;
    }*/

    /*public void setPrices(List<Price> prices) {
        this.prices = prices;
    }*/

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public QuotationType getQuotationType() {
        return quotationType;
    }

    public void setQuotationType(QuotationType quotationType) {
        this.quotationType = quotationType;
    }

    @Override
    public String toString(){
        return "Quotation{" +
                //"id=" + id +
                ", name=" + name + "\'" +
                "}";
    }

}
