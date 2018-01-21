package com.infoshareacademy.pomaranczowi.financialanalyser.domain;


import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
/*@NamedQueries({
        @NamedQuery(name = "getQuotationIdByCode",
                query = "select Quotation.id from Quotation where Quotation.code=:quotationCode")
        //@NamedQuery(name = "addPriceToQuotation", query = "update Quotation q set q.prices=:priceToAdded where q.id=:parentId")
})*/
/*@NamedQueries({
        @NamedQuery(name = "pricefromQurrencyCode", query = "select p from Price p join Quotation q on q.id = p.quotation.id")
})*/
@NamedQueries({
        @NamedQuery(name = "isQuotationCodeInDB", query = "select q.code from Quotation q where q.code=:quotationCode")
})
public class Quotation implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(nullable=false, unique=true)
    private Long id;

    @Column
    private String name;

    @Column
    private String code;

    @Enumerated(EnumType.STRING)
    private QuotationType quotationType;

    //@OneToMany(cascade = CascadeType.MERGE, orphanRemoval = true, fetch = FetchType.EAGER)
    //@OneToMany

    //my
    //@OneToMany(targetEntity = Price.class)
    //@JoinColumn(name = "quotation_id")

    @OneToMany(mappedBy = "quotation", targetEntity = Price.class ,cascade = CascadeType.PERSIST, orphanRemoval = false, fetch = FetchType.EAGER)
    private List<Price> prices = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Price> getPrices() {
        return prices;
    }

    public void setPrices(List<Price> prices) {
        this.prices = prices;
    }

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
                "id=" + id +
                ", name=" + name + "\'" +
                "}";
    }
}
