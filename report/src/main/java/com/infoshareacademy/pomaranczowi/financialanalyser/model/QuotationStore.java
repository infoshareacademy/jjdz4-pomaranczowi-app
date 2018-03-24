package com.infoshareacademy.pomaranczowi.financialanalyser.model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Singleton;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Singleton
public class QuotationStore {

    private Logger LOG = LoggerFactory.getLogger(QuotationStore.class);

    private Map<Integer, Quotation> base;

    public Map<Integer, Quotation> getBase() {
        return base;
    }

    public QuotationStore(){
        base = new HashMap<Integer, Quotation>();

        Quotation quotation1 = new Quotation(1,"PZU Akcji Krakowiak", "PZU001", QuotationType.FUNDINVESTMENT);
        Quotation quotation2 = new Quotation(2,"EURO", "EURO", QuotationType.CURRENCY);

        base.put(1,quotation1);
        base.put(2,quotation2);
    }

    public Integer getNewId() {
        return  base.keySet().stream()
                .mapToInt(i -> i)
                .max().orElse(0) + 1;
    }

    public void add(Quotation quotation) {
        if (!base.containsValue(quotation)){
            LOG.info("Adding to store: " + quotation.toString());
            base.put(quotation.getId(), quotation);
        } else {
            LOG.info("Quotation " +quotation.toString() + " is already exists!");
        }

    }

    public Optional<Quotation> findById(Integer id) {
        return Optional.ofNullable(base.get(id));
    }
}
